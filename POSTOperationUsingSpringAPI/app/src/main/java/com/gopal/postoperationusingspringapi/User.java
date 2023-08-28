package com.gopal.postoperationusingspringapi;

public class User {
   private String adminName;
   private String email;
   private String mobile;
   private String password;

    public User() {
    }

    public User(String adminName, String email, String mobile, String password) {
        this.adminName = adminName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
