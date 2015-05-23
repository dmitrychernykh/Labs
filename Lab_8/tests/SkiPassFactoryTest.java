import org.junit.Before;
import org.junit.Test;
import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;
import ua.org.dmitrychernykh.SkiPassSystem.PassQuantities;
import ua.org.dmitrychernykh.SkiPassSystem.PassTimePeriods;
import ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem.SkiPassSystem;
import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPass;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Dmitry Chernykh on 06.05.2015.
 * Poject Labs for EPAM courses
 */
public class SkiPassFactoryTest {
    PassTimePeriods passTimePeriod;
    PassCardType passCardType;
    PassQuantities passQuantity;
    LocalDateTime nowDate;
    SkiPassSystem system;

    @Before
    public void setup() {
        passTimePeriod = PassTimePeriods.HALFDAY_MORNING;
        passCardType = PassCardType.WORKDAYS;
        passQuantity = PassQuantities.TEN;
        nowDate = LocalDateTime.of(2015, 5, 8, 8, 0);
        system = SkiPassSystem.getSkiPassSystem();
        system.setTest(true);
        system.setNowDateForTest(nowDate);
    }

    @Test
    public void newSkiPassByCount() {

        SkiPass s = system.createSkiPass(passCardType, passQuantity);
        assertFalse("new SkiPass is Blocked", s.isBlocked());
        system.blockSkiPass(s);
        assertTrue("Blocked SkiPass is not Blocked", s.isBlocked());
        assertFalse("can pass when blocked", s.canPass());
        system.unBlockSkiPass(s);
        assertFalse("Unblocked SkiPass is Blocked", s.isBlocked());
    }

    @Test
    public void newSkiPassByCount1() {

        SkiPass s;
        passCardType = PassCardType.HOLIDAYS;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 8, 9, 1));
        s = system.createSkiPass(passCardType, passTimePeriod);
        assertFalse("can pass by Holliday card when workday", s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 1));
        assertTrue("can't pass by card", s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 18, 0));
        assertFalse("can pass by card when time is out", s.canPass());

        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 10, 0));

        for (PassQuantities quantity : PassQuantities.values()) {

            s = system.createSkiPass(passCardType, quantity);
            system.registerPassOk(1, s);
            system.registerPassRejected(1, s);

            int dow = system.getNowDateForTest().getDayOfWeek().getValue();
            if (dow >= passCardType.getDaysFrom() && dow <= passCardType.getDaysTo())
                assertTrue(s.canPass());
            else
                assertFalse(s.canPass());

            if (s.canPass()) {
                int count = 0;
                while (s.canPass()) {
                    s.makePass();
                    count++;
                }
                assertEquals("Passes count must ", quantity.getCount(), count);
            }

        }

    }

    @Test
    public void newSkiPassStoreCheck() {

        SkiPass s = system.createSkiPass(passCardType, passQuantity);
        SkiPass s1 = system.getSkiPassByInputID(s.getId().toString());
        assertEquals("new SkiPass store error", s, s1);
    }

    @Test
    public void newSkiPassByTime() {

        SkiPass s = system.createSkiPass(passCardType, passTimePeriod);
        assertFalse("new SkiPass is Blocked", s.isBlocked());
        system.blockSkiPass(s);
        assertTrue("Blocked SkiPass is not Blocked", s.isBlocked());
        assertFalse("can pass when blocked", s.canPass());
        system.unBlockSkiPass(s);
        assertFalse("Unblocked SkiPass is Blocked", s.isBlocked());

        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());

        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 9, 1));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 12, 59));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 13, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 12, 10, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());

    }

    @Test
    public void newSkiPassByTime2() {

        passTimePeriod = PassTimePeriods.HALFDAY_EVENING;
        passCardType = PassCardType.WORKDAYS;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 8, 9, 0));
        SkiPass s = system.createSkiPass(passCardType, passTimePeriod);
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 13, 1));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 16, 59));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 17, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 10, 16, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());

    }

    @Test
    public void newSkiPassByTime3() {

        SkiPass s;

        passTimePeriod = PassTimePeriods.HALFDAY_MORNING;
        passCardType = PassCardType.HOLIDAYS;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 0));
        s = system.createSkiPass(passCardType, passTimePeriod);
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 1));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 12, 59));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 13, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 10, 10, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());

    }

    @Test
    public void newSkiPassByTime4() {

        SkiPass s;

        passTimePeriod = PassTimePeriods.SEASON;
        passCardType = PassCardType.SEASON;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 0));
        s = system.createSkiPass(passCardType, passTimePeriod);
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 1));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 12, 59));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 13, 0));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 10, 10, 0));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());

    }

    @Test(expected = IllegalArgumentException.class)
    public void newSkiPassByTime5() {

        SkiPass s;

        passTimePeriod = PassTimePeriods.SEASON;
        passCardType = PassCardType.HOLIDAYS;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 0));
        s = system.createSkiPass(passCardType, passTimePeriod);

    }

    @Test(expected = IllegalArgumentException.class)
    public void newSkiPassByTime6() {

        SkiPass s;

        passTimePeriod = PassTimePeriods.FIVEDAYS;
        passCardType = PassCardType.HOLIDAYS;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 0));
        s = system.createSkiPass(passCardType, passTimePeriod);

    }

    @Test
    public void newSkiPassByTime7() {

        SkiPass s;

        passTimePeriod = PassTimePeriods.FIVEDAYS;
        passCardType = PassCardType.WORKDAYS;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 0));
        s = system.createSkiPass(passCardType, passTimePeriod);
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 10, 9, 1));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 12, 59));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 17, 1));
//        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 12, 13, 0));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 15, 10, 0));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 16, 10, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());

    }

    @Test
    public void newSkiPassByTime8() {

        SkiPass s;

        passTimePeriod = PassTimePeriods.TWODAYS;
        passCardType = PassCardType.WORKDAYS;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 0));
        s = system.createSkiPass(passCardType, passTimePeriod);
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 10, 9, 1));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 12, 59));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 17, 1));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 12, 13, 0));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 15, 10, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 16, 10, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());

    }

    @Test
    public void newSkiPassByTime9() {

        SkiPass s;

        passTimePeriod = PassTimePeriods.FULLDAY;
        passCardType = PassCardType.HOLIDAYS;
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 0));
        s = system.createSkiPass(passCardType, passTimePeriod);
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 9, 1));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 12, 59));
        assertTrue(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 9, 17, 1));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 10, 13, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 11, 10, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());
        system.setNowDateForTest(LocalDateTime.of(2015, 5, 12, 10, 0));
        assertFalse(passTimePeriod.toString() + " " + system.getNowDateForTest(), s.canPass());

    }

}
