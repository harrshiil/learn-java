package com.sfl.americantutor.security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginVM {

    @NotNull
    @Email
    @Size(min = 1, max = 50)
    private String emailId;

    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVM{" +
            "emailId='" + emailId + '\'' +
            '}';
    }
}
