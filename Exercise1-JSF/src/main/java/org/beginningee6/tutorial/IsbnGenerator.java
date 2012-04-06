package org.beginningee6.tutorial;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.Interceptors;
import java.util.Random;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         Simple IsbnGenerator Pojo with Managed Bean annotation
 */
@ManagedBean
public class IsbnGenerator {

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @PostConstruct
    private void init() {
        System.out.println("\n=> IsbnGenerator PostConstruct");
        System.out.println("================");
    }

    @PreDestroy
    private void release() {
        System.out.println("=============");
        System.out.println("=> IsbnGenerator PreDestroy");
    }

    // ======================================
    // =          Business methods          =
    // ======================================

    @Interceptors(LoggingInterceptor.class)
    public String generateIsbn() {
        return "1-84356-" + Math.abs(new Random().nextInt());
    }
}