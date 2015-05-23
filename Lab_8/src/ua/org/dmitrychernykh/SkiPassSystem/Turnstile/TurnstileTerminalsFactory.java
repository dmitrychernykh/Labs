package ua.org.dmitrychernykh.SkiPassSystem.Turnstile;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Realizes factory singleton that making turnstile objects and manage them
 *
 * @author Created by Dmitry Chernykh on 05.05.2015.
 *         Project Labs for EPAM courses
 */
public class TurnstileTerminalsFactory {

    private static final Logger log = Logger.getLogger(TurnstileTerminalsFactory.class);

    private static TurnstileTerminalsFactory System;
    private ArrayList turnstiles;

    private TurnstileTerminalsFactory() {
        turnstiles = new ArrayList();
    }

    public static TurnstileTerminalsFactory TurnstileSystem() {
        if (System != null) return System;
        System = new TurnstileTerminalsFactory();
        log.debug("TurnstileSystemsFactory Started");
        return System;
    }

    private int getNewId() {
        return turnstiles.size() + 1;
    }

    /**
     * adds a new turnstile
     */
    public Turnstile addTurnstile() {
        TurnstileTerminal t = new TurnstileTerminal(getNewId());
        turnstiles.add(t);
        log.debug("added from T_factory Turnstile id: " + t.getId());
        return t;
    }

}
