package ua.org.dmitrychernykh.SkiPassSystem.Turnstile;

import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPass;

/**
 * Turnstile
 *
 * @author Dmitry Chernykh on 26.04.2015.
 *         Project Labs for EPAM courses
 */
public interface Turnstile {

    boolean checkSkiPassOK(SkiPass s);

    int getId();
}
