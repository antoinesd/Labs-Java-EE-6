package org.beginningee6.tutorial;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         A simple class to define where JAX-RS resources are available from
 */
@ApplicationPath("resources")
public class ApplicationConfig extends Application {
}