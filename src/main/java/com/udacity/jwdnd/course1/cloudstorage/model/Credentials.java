package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credentials {
    Integer credentialId;
    Integer userId;
    String url;
    String username;
    String password;

    public Credentials(Integer credentialId,Integer userId,  String url, String username, String password) {
        this.userId = userId;
        this.credentialId = credentialId;
        this.url = url;
        this.username = username;
        this.password = password;
    }


    public Credentials() {
        this.url ="";
        this.username= "";
        this.password ="";
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }
}
