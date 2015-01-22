package com.mycompany.mavenproject1.accounting;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.Before;
import org.junit.Test;

public class AccountServiceRemoteTest {

    private AccountServiceRemote accountService;
    
    @Before
    public void setUp() throws NamingException {
        final Context context = new InitialContext();
        accountService = (AccountServiceRemote) context.lookup(AccountServiceRemote.JNDI_NAME);
    }
    
    @Test(expected = AccountNotValidException.class)
    public void test() throws AccountNotValidException {
        accountService.createAccount(new Account());
    }
    
}
