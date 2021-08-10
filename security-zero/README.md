# Pre requisite
Before reading this article read and complete [Filter](https://gitlab.com/suyojan_learn/boot-filter/blob/master/README.md)

# Why security important
In real life application, every reource is not accessible to everyone. To access any resource one must be authentic and authorized.

*  Authentication: This provides identificaton of the user.
*  Authorization: The user must have rights to access the resource.

In normal case the **Login** is process of identification. &lt;username,password&gt; pair is used to identify the user. But it might be possible
that an autthetic user can not have rights to access the resource. Each authentic users may have different rights. To provides the rights, each type
of user must assign certain **ROLE** in the system. By identifying the **ROLE** system can determine the rights of the user.


## Token based authentication and authorization

In case of **REST Based Application**, when the client performs login, the system generates a token on behalf of the user and send back to the client.
After that the client need to send that token each time it interact with the system. The token, normally, is placed in the specific header called 
**Authorization**. The system retrievs the token from that header and verifies. If the token is valid then system allow request the access the protected resource.

## JWT Token
**JWT** stands for **JSON Web Token**. To know more about JWT and its format read [JWT](https://jwt.io/). JWT is an encrypted token which contains various information 
about the client. The following information are normally avilabe inside the token
1.  Subject : Username of the client.
2.  Issuing Date :  The date at when the token is generated.
3.  Expired Date: the date after the token will be invalid.
4.  Claim : Normally the role of the client.

There are more fields available. But for the demonstration purpose we will use only these fields. As mention above, JWT is an encrypted token, Base64 is used to 
encrypt the token.To verify that token is not tempered, it is signed with a key. There are many signing algorithms are available.  Here is the code snippet 
for creating JWT web token


        public String jwtAuthToken(String username,String role)
        {

            long oneHour=1*60*60*1000;

            return Jwts.builder()
                .claim("role",role)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+oneHour))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode("randomkey".getBytes()))
                .compact();
        }

In the above code , HS256 algorithm is used to sign the key. This key valid for one hour only. The generated key is sent back to the client. The client prepare 
Authorization header and send the key back to server. The server validate the key. Here is code for validating the key:
        
        public Claims validate(String token)
        {
            return Jwts.parser()
                .setSigningKey(Base64.getEncoder().encode("randomkey".getBytes()))
                .parseClaimsJws(token)
                .getBody();
        }

## Steps for generating token

There is at least one resource that should be accessible by all client. Normally that resource is used to perform login. As discussed above login is a process of 
authenticating the client. Once the client get authenticated, the server must retrieve its role and the generate the token for that client.

    @RestController
    @RequestMapping("/api")
    public class LoginResource
    {
        @Autowired
        private TokenBuilder tokenBuilder;

        @PostMapping("/login")
        public String login(@RequestParam("username") String username, @RequestParam("password") String password)
        {
            String role = "ROLE_USER";
             // authenticate the client
             ....
            return tokenBuilder.jwtAuthToken(username,role);
        }
    }

In the above example the code for authentication is not provided. In a normal flow the username and password is matched against the database. That flow can easily
be introduced here.

## How to validate token and grant permission to access the resource

The essential role is played by the filter. Whatever resource need to be secured, one or more filter must gaurding the resource. The filter must perform the following
action
1. Check the request and confirm that Authorization header is available.
2. Fetch value from Authorization header
3. Retrieve key
4. validate the key.
5. Allow to access on the basis of key validation

Here is the code for that:

    @WebFilter("/api/secured/*")
    public class AuthorizationFilter implements Filter
    {

        @Override
        public void doFilter(ServletRequest request, 
                             ServletResponse response, 
                             FilterChain chain) throws IOException, ServletException
        {
            HttpServletResponse httpServletResponse=(HttpServletResponse)response;
            HttpServletRequest httpServletRequest=(HttpServletRequest)request;
            // try to get value form Authorization header
            String authHeader=httpServletRequest.getHeader("Authorization");
            if ( authHeader!=null)
            {
                
                if (!authHeader.startsWith("Bearer"))
                    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"No bearer token available\n");
                else
                {
                   // retrieve the key
                    String token = authHeader.substring(7);
                    TokenBuilder tokenBuilder = new TokenBuilder();
                    Claims claims=tokenBuilder.validate(token);
                }
            }
            else
            {
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Authorization header not available\n");
            }

        chain.doFilter(request,response);
        }
    }

Note that this filter is created using `@WebFilter` annotation. So `@ServletComponentScan` must be used.

    @SpringBootApplication
    @ServletComponentScan
    public class SecurityZeroApplication {

        public static void main(String[] args) {
            SpringApplication.run(SecurityZeroApplication.class, args);
        }
    }
    
Also the above filter is applied on the url `/api/secured/*`. This means any url starts with `/api/secured` will be gaurded by this filter.    

## Running and testing the application
Clone the repository and use maven to run this application

     git clone https://gitlab.com/suyojan_learn/security-zero.git
     mvn clean install
     java -jar target/security-zero-0.0.1-SNAPSHOT.jar
     
Test the endpoint using curl. As a first step login is required to get the token from the server.
    
    curl -d "username=test&password=test" -X POST http://localhost:8080/api/login
    O/p : eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUk9MRV9VU0VSIiwic3ViIjoiYXR1bCIsImlhdCI6MTU1ODc1NTg0NCwiZXhwIjoxNTU4NzU5NDQ0fQ.Tvqx2jK6ksJu7jro4hvdh5j9T5_PIFUDkUjZ-l1roy
    

After getting the key try to access the secured sesource
    
    curl -H "Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUk9MRV9VU0VSIiwic3ViIjoiYXR1bCIsImlhdCI6MTU1ODc1NTg0NCwiZXhwIjoxNTU4NzU5NDQ0fQ.Tvqx2jK6ksJu7jro4hvdh5j9T5_PIFUDkUjZ-l1roy" 
    http://localhost:8080/api/secured/greet
    O/p : Secured Hello
    

If we try to access the secured resource without the key then:

    curl http://localhost:8080/api/secured/greet
    O/p: {"timestamp":"2019-05-25T04:02:04.631+0000","status":401,"error":"Unauthorized","message":"Authorization header not available\n","path":"/api/secured/greet"}
    
In the output the server sends `401 Unauthorized` error. That means without key the server is not allowing to access the protected resource.    

    