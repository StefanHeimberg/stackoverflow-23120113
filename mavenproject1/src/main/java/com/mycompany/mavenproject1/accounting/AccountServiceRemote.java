package com.mycompany.mavenproject1.accounting;

import javax.ejb.Remote;

@Remote
public interface AccountServiceRemote {
    
    public static final String JNDI_NAME = "java:global/mavenproject1/AccountService!com.mycompany.mavenproject1.accounting.AccountServiceRemote";
    
    Account createAccount(Account account) throws AccountNotValidException;
    
}
