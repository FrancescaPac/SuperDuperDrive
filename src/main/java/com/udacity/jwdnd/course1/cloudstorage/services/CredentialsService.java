package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialsMapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsService {

    private final CredentialsMapper credentialsMapper;

    public CredentialsService(CredentialsMapper credentialsMapper) {
        this.credentialsMapper = credentialsMapper;
    }

    //get all credentials
    public List<Credentials> getAllCredentials(Integer userId) {
        return this.credentialsMapper.getAllCredentials(userId);
    }

    //get credential by id
    public Credentials getCredentialByUserId(Integer credentialId){
        return this.credentialsMapper.getCredentialsById(credentialId);
    }

    //add new credential
    public void addCredentials(Credentials c) {
        this.credentialsMapper.insertCredentials(c);
    }

    //edit credential
    public void editCredentials(Credentials c) {
        this.credentialsMapper.updateCredentials(c);
    }

    //delete credential
    public void deleteCredentials(Integer credentialId) {
        this.credentialsMapper.deleteCredentialsByUserId(credentialId);
    }
}