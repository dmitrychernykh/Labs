package ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem;

import org.apache.log4j.Logger;
import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;
import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPass;

import java.util.LinkedList;
import java.util.UUID;

/**
 * Created by Dmitry Chernykh on 06.05.2015.
 * Project Labs for EPAM courses
 */
public class PassRegister {
    private static final Logger log = Logger.getLogger(PassRegister.class);

    private static PassRegister passRegister;
    private LinkedList register;
    private LinkedList skiPasses;

    private PassRegister() {
        register = new LinkedList();
        addNote(new PassRegisterNote("№", "TURNSTILE", "CARD TYPE", "REJECTED", "SKI PASS info"));
        skiPasses = new LinkedList();
    }

    public static PassRegister getPassRegister() {
        if (passRegister != null) return passRegister;
        passRegister = new PassRegister();
        return passRegister;
    }

    public void addNote(PassRegisterNote note) {
        register.add(note);
    }

    public void addSkiPass(SkiPass s) {
        log.debug("SkiPass registered " + s.toString());
        skiPasses.add(s);
    }

    private void addNote(int noteIndex, int turnstileId, PassCardType skiPassType, boolean rejected, String skiPass) {
        log.debug("Pass " + String.valueOf(rejected).toUpperCase() + " registered on " + turnstileId + " by " + skiPass);
        register.add(new PassRegisterNote(noteIndex, turnstileId, skiPassType.toString(), rejected, skiPass));
    }

    public void addNote(int turnstileId, PassCardType skiPassType, boolean rejected, String skiPass) {
        addNote(getNewIndex(), turnstileId, skiPassType, rejected, skiPass);
    }

    public int size() {
        return register.size();
    }

    public SkiPass findSkiPassById(String inputId) {
        UUID Id = UUID.fromString(inputId);
        for (Object skiPass : skiPasses) {
            SkiPass s = (SkiPass) skiPass;
            if (s.getId().equals(Id)) return s;
        }
        return SkiPassSystem.getSkiPassSystem().createSkiPass();
    }

    public int getNewIndex() {
        return register.size() + 1;
    }

    public LinkedList getAllNotes() {
        return register;
    }

    public LinkedList getAllNotesByCardType() {
        return register;
    }

    public LinkedList getAllSkiPasses() {
        return skiPasses;
    }

    public void clearRegister() {
        register.clear();
    }
}
