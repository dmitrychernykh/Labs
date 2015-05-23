import org.apache.log4j.Logger;
import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;
import ua.org.dmitrychernykh.SkiPassSystem.PassQuantities;
import ua.org.dmitrychernykh.SkiPassSystem.PassTimePeriods;
import ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem.SkiPassSystem;
import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPass;
import ua.org.dmitrychernykh.SkiPassSystem.Turnstile.Turnstile;
import ua.org.dmitrychernykh.SkiPassSystem.Turnstile.TurnstileTerminalsFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dmitry Chernykh on 08.05.2015.
 * Project Labs for EPAM courses
 */
public class Runner {

    private static final Logger log = Logger.getLogger(Runner.class);

    /*
    * In test runner we go to make a model that simulates a several work days of working system
    * for this reason we need Ski Pass System, three Turnstiles, around 1000 cards of skipasses and some broken passes
    * system will work fixed time with hollidays and workdays from 2015/05/09 during 10 days
    * */
    static SkiPassSystem system;
    static ArrayList<String> listSkiPass;
    static ArrayList<String> wrongSkiPassIdlist;
    static Turnstile[] turnstiles;
    static LocalDate[] datesOfSkiing;
    static Random rand = new Random();

    /* initializes all the data and objects for system*/
    public static void init() {

        /* getting the system */
        system = SkiPassSystem.getSkiPassSystem();
        system.setTest(true);
        /*setting the start simulation date*/
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 10, 30));

        /*setting the days for simulation*/
        datesOfSkiing = new LocalDate[10];
        for (int i = 0; i < 10; i++) {
            datesOfSkiing[i] = LocalDate.of(2015, 5, 9 + i);
        }

        /*creating ski passes with restricted count of usages, and adding all of them to list*/
        listSkiPass = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                listSkiPass.add(system.createSkiPass(PassCardType.values()[rand.nextInt(3)], PassQuantities.values()[rand.nextInt(4)]).getId().toString());
            } catch (IllegalArgumentException e) {
                log.debug(e);
            }
        }
        /*creating ski passes with restricted period of usage, and adding all of them to list*/
        for (int i = 0; i < 100; i++) {
            try {
                listSkiPass.add(system.createSkiPass(PassCardType.values()[rand.nextInt(3)], PassTimePeriods.values()[rand.nextInt(6)]).getId().toString());
            } catch (IllegalArgumentException e) {
                log.debug(e);
            }
        }

        /*ski passe codes that will not pass*/
        wrongSkiPassIdlist = new ArrayList<>();
        wrongSkiPassIdlist.add("890d62d2-8d69-4ba8-9aea-8df17ad51bbc");
        wrongSkiPassIdlist.add("23208139-bf6f-4e10-a1fe-919f3ff40fa5");

        /* adds three turnstiles for the system*/
        turnstiles = new Turnstile[3];
        turnstiles[0] = TurnstileTerminalsFactory.TurnstileSystem().addTurnstile();
        turnstiles[1] = TurnstileTerminalsFactory.TurnstileSystem().addTurnstile();
        turnstiles[2] = TurnstileTerminalsFactory.TurnstileSystem().addTurnstile();

    }

    /* starts the cycle of simulation process */
    public static void simulate() {

        for (LocalDate date : datesOfSkiing) {
            simulateDay(date);
        }
    }

    /* simulates one system working day */
    public static void simulateDay(LocalDate nowDate) {

        system.setNowDateForTest(LocalDateTime.of(nowDate.getYear(), nowDate.getMonth(), nowDate.getDayOfMonth(), 0, 0).plusHours(8));
        /*for each working hour of day */
        for (int i = 0; i < 11; i++) {

            /*tries to make a pass throw random turnstile*/
            for (String id : listSkiPass) {
//                String id = listSkiPass.get(rand.nextInt(listSkiPass.size()));
                tryThisSkiPass(id);
            }
            /*tries to pass with broken cards*/
            for (String id : wrongSkiPassIdlist) {
                tryThisSkiPass(id);
            }

            /*starts new hour of day*/
            system.setNowDateForTest(LocalDateTime.from(system.getNowDateForTest().plusHours(1)));
        }

        /*after day will print stats*/
        system.printStats();
        system.clearStats();
    }

    public static void tryThisSkiPass(String sId) {
        SkiPass s = system.getSkiPassByInputID(sId);
        Turnstile T = turnstiles[rand.nextInt(3)];
        if (T.checkSkiPassOK(s)) {
            log.info("passed " + sId + " by " + T.getId());
        } else {
            log.info("rejected " + sId + " by " + T.getId());
        }
    }

    public static void main(String[] args) {

        init();

        simulate();

    }
}
