package org.beginningee6.tutorial;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         An interceptor that logs method entering and exciting
 */
public class LoggingInterceptor {

    // ======================================
    // =             Attributes             =
    // ======================================

    private Logger logger = Logger.getLogger("org.beginningee6.tutorial");

    // ======================================
    // =          Business methods          =
    // ======================================

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.info("> " + ic.getTarget().getClass() + " - " + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.info("< " + ic.getTarget().getClass() + " - " + ic.getMethod().getName());
        }
    }
}