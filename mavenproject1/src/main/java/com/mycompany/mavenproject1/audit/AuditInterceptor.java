package com.mycompany.mavenproject1.audit;

import com.mycompany.mavenproject1.logging.LogService;
import java.text.MessageFormat;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AuditInterceptor {
    
    @EJB
    private LogService logService;

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        logService.log(MessageFormat.format("--> method {0} call start", ic.getMethod()));
        Object result = null;
        try {
            result = ic.proceed();
        } catch(Exception ex) {
            logService.log(MessageFormat.format("XXX Exception {0}", ex.getClass().getName()));
            throw ex;
        } finally {
            logService.log(MessageFormat.format("<-- method {0} call finished", ic.getMethod()));
        }
        return result;
    }
    
}
