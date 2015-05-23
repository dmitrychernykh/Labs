package ua.org.dmitrychernykh.SkiPassSystem.Turnstile;

import org.apache.log4j.Logger;
import ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem.SkiPassRegistrationSystem;
import ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem.SkiPassSystem;
import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPass;

/**
 * Realizes turnstile terminal object
 *
 * @author Created by Dmitry Chernykh on 05.05.2015.
 *         Project Labs for EPAM courses
 */
public class TurnstileTerminal implements Turnstile {
    private static final Logger log = Logger.getLogger(TurnstileTerminal.class);

    private final SkiPassRegistrationSystem SYSTEM = SkiPassSystem.getSkiPassSystem();

    private int Id;

    protected TurnstileTerminal(int id) {
        Id = id;
        log.debug("added Turnstile id: " + Id);
    }

    @Override
    public boolean checkSkiPassOK(SkiPass s) {
        boolean result;
        if (s == null) {
            log.info("SkiPass is null and rejected");
            result = false;
        } else
            result = s.canPass();

        makeTurnstilePass(s, result);

        return result;
    }

    //    @Override
    public void makeTurnstilePass(SkiPass s, boolean canPass) {
        log.info("Turnstile make pass " + canPass + " for SkiPass:" + s);
        if (canPass)
            SYSTEM.registerPassOk(getId(), s);
        else
            SYSTEM.registerPassRejected(getId(), s);
    }

    @Override
    public int getId() {
        return Id;
    }
}

