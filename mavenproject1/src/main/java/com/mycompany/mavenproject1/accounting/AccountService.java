package com.mycompany.mavenproject1.accounting;

import com.mycompany.mavenproject1.audit.AuditInterceptor;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors({AuditInterceptor.class})
public class AccountService implements AccountServiceRemote {

    @Override
    public Account createAccount(Account account) throws AccountNotValidException {
        throw new AccountNotValidException();
    }
    
}
