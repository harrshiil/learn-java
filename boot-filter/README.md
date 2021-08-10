# What is a filter

   In a client server architecture the client sends a request to a server
   and the server sends a response back to the client. When client is sending
   request to the server, there is some component in the server which actually 
   handle that request and prepare the response. In technical word that component 
   is called **Resource**. 
   
   Many time it is required that before hitting the actual resource, the request 
   should be verified and then allowed to access the resource. If the varification
   failed, the client should be notified and request should not be allowed access
   to resource. The **filter** is a component on server which is intercepted
   between client and actual resource, and used for various kind of request 
   verification.

## JEE Filter Interface

  JEE gives an interface called **javax.servlet.Filter** which is used to define
  filter in spring boot application. Here is the interface : 
  
  ```
      public interface Filter {
          public void doFilter(ServletRequest request,
                               ServletResponse response,
                               FilterChain chain
                              ) throws IOExcption,ServletException;
      }
  ```
  Here are the details of parameters:
  1.  __javax.servlet.ServletRequest request__ : It represents the client request. In most of the application,it must be type casted to javax.servlet.http.HttpServletRequest.
  2.  __javax.servlet.ServletResponse response__ : It represents the response send to the client. In most of the application, it must be type casted to javax.servlet.http.HttpServletResponse.
  3.  __javax.servlet.FilterChain chain__ : It is another interface provided by JEE. Here is its signature
    
        ```
         public interface FilterChain
         {
             public void doFilter(ServletRequest request,ServletResponse response) throws IOException,ServletException;
         }
        ```
     
      This interface is used to invoke another filter in the queue or the actual resource if queue is empty.

## Filter in action
   To work with filter, we need to create a class that mus implements **Filter**  interface.
   ```
      public class FilterExample implements Filter
      {
          public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException,ServletException
          {
              HttpServletRequest httpServletRequest = (HttpServletRequest)request;
              HttpServletResponse httpServletResponse = (HttpServletResponse)response;
              // if there is any Authorization header available in the request
              if(httpServletRequest.getHeader("Authorization") == null)
              {
                 // if no Authorization header availabe send an error 401 to the client saying that client is not authorize to access the resource
                 response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
              }
              // if header is available the invoke the next filter in the queue or invoke the actual resource if there is no filter in queue
              chain.doFilter(request,response);
          }
      }
   ```
   The next step is to apply the filter over the real resource. Now in any web application the resource is accessible only through the URL. Hence filter must be applied on URL. 
   In **Spring Boot** there are two different ways to apply the filter over the URL.
</p>

#### First Way : The JEE way

 In this way Two annotations are used
 1. __javax.servlet.annotation.WebFilter__ : This annotation declare various properties of a filte. Use urlPatterns attribute to apply the filter over any URL.
 2. __org.springframework.boot.web.servlet.ServletComponentScan__: This annotation can be applied over any configuration class or on main spring boot class.
 
    ```
        @WebFilter(urlPatterns={"/secured","/test"})
        public class FilterExample implements Filter
        {
              
        }
    ```    

       ```
          @ServletComponentScan
          @SpringBootApplication
          public class BootFilterExample
          {
              public static void main(String [] args)
              {
                  SpringApplication.run(BootFilterExample.class,args);
              }
          }
       ```

#### Second Way : The Boot way

   We need to declare a bean of type <b>org.springframework.boot.web.servlet.FilterRegistrationBean</b>.
   ```
       @Bean
       public FilterRegistrationBean&lt;FilterExample&gt; filterRegistrationBean
       {
           FilterRegistrationBean &lt;FilterExample&gt; filterRegistrationBean = new FilterRegistrationBean();
           //adding a filter
           filterRegistrationBean.setFilter(new FilterExample());
           //applying a filter over a URL
           filterRegistrationBean.addUrlPatterns("/secured/*");
           return filterRegistrationBean;
       }
   ```

# How to work with this project
Firts clone the project using the following command:

     
        git clone https://gitlab.com/suyojan_learn/boot-filter.git
        git fetch origin
        

Run the application

    mvn clean install
    java -jar target/boot-filter-0.0.1-SNAPSHOT.jar


Use [CURL](https://curl.haxx.se/) to test the endpoint

    curl http://localhost:8080/secured/greet
    O/p: Secured Hello
    curl http://localhost:880/unsecured/greet
    O/p: Unsecured Hello

Now chechout to **security-on-specific-url** branch    

    git checkout security-on-specific-url
    mvn clean install
    java -jar target/boot-filter-0.0.1-SNAPSHOT.jar

Use curl to test the end point

    curl http://localhost:8080/unsecured/greet
    O/p: Unsecured Hello
    curl http://localhost:8080/secured/greet
    O/p: {"timestamp":"2019-05-23T08:03:15.852+0000","status":401,"error":"Unauthorized","message":"No message available","path":"/secured/greet"}

As the filter is applied on __/secured/*__ URL the filter start checking Authorization header in the request. But currently no such header present the server is throwing 401 i.e. Unauthorized error.
This is the expected behaviour of the server. Note that the actual resource is not invoked. If authorization header is present then the filter will allow access to the actual resource

    curl -H "Authorization: Bearer abc" http://localhost:8080/secured/greet
    O/p : Secured Hello
    
    
    
    


    
