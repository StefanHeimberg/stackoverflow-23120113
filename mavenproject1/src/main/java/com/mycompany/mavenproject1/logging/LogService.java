package com.mycompany.mavenproject1.logging;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

@Stateless
@ExcludeDefaultInterceptors
public class LogService {
    
    private static final Logger LOG = Logger.getLogger(LogService.class.getName());

    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void log(@NotNull final String text) {
        LOG.log(Level.SEVERE, "Logging text: {0}", text);
        em.persist(new Log(text));
    }
    
}
