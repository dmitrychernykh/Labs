package ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem;

import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;
import ua.org.dmitrychernykh.SkiPassSystem.PassQuantities;
import ua.org.dmitrychernykh.SkiPassSystem.PassTimePeriods;
import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPass;

/**
 * Created by Dmitry Chernykh on 26.04.2015.
 * Project Labs for EPAM courses
 */
public interface SkiPassRegistrationSystem {


    SkiPass getSkiPassByInputID(String Id);

//    SkiPass createSkiPass();

    SkiPass createSkiPass(PassCardType type, PassQuantities quantities);

    SkiPass createSkiPass(PassCardType type, PassTimePeriods timePeriods);

    //creates rejected ski pass
    SkiPass createSkiPass();

    void blockSkiPass(SkiPass s);

    void unBlockSkiPass(SkiPass s);

    void registerPassOk(int turnstileId, SkiPass s);

    void registerPassRejected(int turnstileId, SkiPass s);

    void printStats();

    void printStatsByCardType();
}
