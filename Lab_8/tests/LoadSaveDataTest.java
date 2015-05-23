import org.apache.log4j.Logger;
import org.junit.Test;
import ua.org.dmitrychernykh.SkiPassSystem.LoadSaveData;
import ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem.SkiPassRegistrationSystem;
import ua.org.dmitrychernykh.SkiPassSystem.RegisterSystem.SkiPassSystem;
import ua.org.dmitrychernykh.SkiPassSystem.SkiPass.SkiPass;
import ua.org.dmitrychernykh.SkiPassSystem.Turnstile.Turnstile;
import ua.org.dmitrychernykh.SkiPassSystem.Turnstile.TurnstileTerminalsFactory;

import java.util.ArrayList;
import java.util.Random;

public class LoadSaveDataTest {

    static final Logger log = Logger.getLogger(LoadSaveData.class);

    @Test
    public void testSaveData() throws Exception {
        LoadSaveData.saveData();
    }

    @Test
    public void testSaveRegisteredData() throws Exception {

        SkiPassRegistrationSystem system = SkiPassSystem.getSkiPassSystem();
        ArrayList list = new ArrayList();
        for (int i = 0; i < 4; i++) {
//            list.add(system.createSkiPass());
        }
        Turnstile T = TurnstileTerminalsFactory.TurnstileSystem().addTurnstile();
        T = TurnstileTerminalsFactory.TurnstileSystem().addTurnstile();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            SkiPass s = (SkiPass) list.get(rand.nextInt(4));
            if (T.checkSkiPassOK(s)) {

            } else {

            }
        }
        system.printStats();
    }

    @Test
    public void testLoadData() throws Exception {

    }
}