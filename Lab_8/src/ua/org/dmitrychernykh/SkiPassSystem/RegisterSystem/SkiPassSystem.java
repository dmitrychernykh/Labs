package ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem;

import org.apache.log4j.Logger;
import ua.org.dmitrychernykh.SkiPassSystem.*;
import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPass;
import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPassFactory;

import java.time.LocalDateTime;

/**
 * Created by Dmitry Chernykh on 26.04.2015.
 * Project Labs for EPAM courses
 */
public class SkiPassSystem implements SkiPassRegistrationSystem {
    private static final Logger log = Logger.getLogger(SkiPassSystem.class);
    private static SkiPassSystem System;

    private LocalDateTime nowDateForTest;
    private boolean isTest = false;

    private SkiPassSystem() {
    }

    public static SkiPassSystem getSkiPassSystem() {
        if (System != null) return System;
        System = new SkiPassSystem();
        return System;
    }

    public boolean isTest() {
        return isTest;
    }

    public void setTest(boolean isTest) {
        this.isTest = isTest;
    }

    public LocalDateTime getNowDateForTest() {
        return nowDateForTest;
    }

    public void setNowDateForTest(LocalDateTime nowDateForTest) {
        if (isTest) this.nowDateForTest = nowDateForTest;
    }

    @Override
    public SkiPass getSkiPassByInputID(String Id) {
        log.debug("Scan for SkiPass with getSkiPassByInputID by " + Id);
        return PassRegister.getPassRegister().findSkiPassById(Id);
    }

    @Override
    public SkiPass createSkiPass(PassCardType type, PassQuantities quantities) {
        SkiPass s = SkiPassFactory.getInstance().getNewSkiPass(type, quantities);
        log.debug("SkiPass added " + s.toString());
        PassRegister.getPassRegister().addSkiPass(s);
        return s;
    }

    @Override
    public SkiPass createSkiPass(PassCardType type, PassTimePeriods timePeriods) {
        SkiPass s = SkiPassFactory.getInstance().getNewSkiPass(type, timePeriods);
        log.debug("SkiPass added " + s.toString());
        PassRegister.getPassRegister().addSkiPass(s);
        return s;
    }

    @Override
    public SkiPass createSkiPass() {
        SkiPass s = SkiPassFactory.getInstance().getRejectedSkiPass();
        log.debug("SkiPass rejected returned " + s.toString());
        return s;
    }

    @Override
    public void blockSkiPass(SkiPass s) {
        s.setBlocked(true);
    }

    @Override
    public void unBlockSkiPass(SkiPass s) {
        s.setBlocked(false);
    }

    @Override
    public void registerPassOk(int turnstileId, SkiPass s) {
        PassRegister.getPassRegister().addNote(turnstileId, s.getCardType(), false, s.toString());
    }

    @Override
    public void registerPassRejected(int turnstileId, SkiPass s) {
        PassRegister.getPassRegister().addNote(turnstileId, s.getCardType(), true, s.toString());
    }

    @Override
    public void printStats() {
        LoadSaveData.saveToFile(PassRegister.getPassRegister().getAllNotes(), "Stats for " + CardPeriod.DATE_FORMAT.format(nowDateForTest));
    }

    @Override
    public void printStatsByCardType() {

    }

    public void clearStats() {
        PassRegister.getPassRegister().clearRegister();
    }
}
