import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class SinusSum {

    public static int k = 0;
    public final int N;
    private final int threadsCount;
    public Sinus[] results;
    public double sinusSum = 0;

    public SinusSum(int newN, int threadsCount) throws InterruptedException {

        if (threadsCount % 2 != 0) threadsCount++;

        this.threadsCount = threadsCount;
        this.N = newN;

        results = new Sinus[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int kNext;

            k = ((i * N) / threadsCount);
            kNext = (((i + 1) * N) / threadsCount);
            results[i] = new Sinus(k, kNext);
            results[i].start();

            k = ((i + 1) * -N / threadsCount);
            kNext = (i * -N / threadsCount);
            results[++i] = new Sinus(k, kNext);
            results[i].start();

        }

        for (int i = 0; i < threadsCount; i++) if (results[i].isAlive()) results[i].join();

        for (int i = 0; i < threadsCount; i++)
            sinusSum += results[i].result;

        System.out.println("SUM = " + String.format("%.4f", sinusSum));

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    static double calculateSinus(int num) {
        double rad, sin;

        if (num % 180 == 0)
            sin = 0;
        else {
            rad = (num / 180.0) * Math.PI;
            sin = Math.sin(rad);
        }
//        System.out.println(" sin(" + num + ") = " + sin);
        return round(sin, 4);
    }

    public static void main(String[] args) {

        try {
            new SinusSum(180, 10);
        } catch (InterruptedException e) {
            System.out.println("Run error: " + e.toString());
        }
    }

    class Sinus extends Thread {

        double result = 0;

        private int startFrom, end;

        Sinus(int from, int to) {
            startFrom = from;
            end = to;
        }

        @Override
        public void run() {
            System.out.println("Tread #" + getId() + " was started");
            while (startFrom <= end)
                result += calculateSinus(startFrom++);
            System.out.println("Tread" + getId() + " was finished; result: " + result);
        }
    }

}
