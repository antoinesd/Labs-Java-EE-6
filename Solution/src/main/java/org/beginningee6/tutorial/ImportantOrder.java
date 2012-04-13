package org.beginningee6.tutorial;

import java.lang.annotation.*;
import javax.inject.Qualifier;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A CDI Qualifier annotation
 */
@Qualifier
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImportantOrder {}

