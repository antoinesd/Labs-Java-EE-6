package org.beginningee6.tutorial;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.inject.Named;

/**
 * @author Antonio Goncalves & Alexis Moussine-Pouchkine
 *         Tutorial - Beginning with The Java EE 6 Platform
 *         http://www.antoniogoncalves.org
 *         http://blogs.sun.com/alexismp
 *         --
 *         An EJB Singleton that caches a map of languages
 */
@Startup
@Singleton
@Named("languages")
public class LanguageSingleton {

    // ======================================
    // =             Attributes             =
    // ======================================

    private Map<String, String> languages;

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @PostConstruct
    private void initLanguages() {
        languages = new HashMap<String, String>();
        languages.put("EN", "English");
        languages.put("FR", "French");
        languages.put("DE", "German");
        languages.put("ES", "Spanish");
        languages.put("FI", "Finnish");
        languages.put("IT", "Italian");
        languages.put("RU", "Russian");
        System.out.println("Loaded " + languages.size() + " languages !!!");
    }

    // ======================================
    // =          Business methods          =
    // ======================================

    public String getLanguageValue(String code) {
        return languages.containsKey(code.toUpperCase()) ? languages.get(code.toUpperCase()) : "UNKNOWN";
    }
    
    public String getListOfValues() {
        return languages.keySet().toString();
    }
}