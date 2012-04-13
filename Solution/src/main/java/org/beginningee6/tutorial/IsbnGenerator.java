package org.beginningee6.tutorial;

import java.util.Random;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         Simple IsbnGenerator Pojo with Managed Bean annotation
 */
public class IsbnGenerator {

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @Inject Logger logger;
    
    @PostConstruct
    private void init() {
        logger.info("\n=> IsbnGenerator PostConstruct");
        logger.info("================");
    }

    @PreDestroy
    private void release() {
        logger.info("=============");
        logger.info("=> IsbnGenerator PreDestroy");
    }

    // ======================================
    // =          Business methods          =
    // ======================================

    @Interceptors(LoggingInterceptor.class)
    public String generateIsbn() {
        return "1-84356-" + Math.abs(new Random().nextInt());
    }
}