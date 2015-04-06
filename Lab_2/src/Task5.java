/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task5 {

    public static int fibonachiNumber(int n) {

        if (n > 45) return -1; // больше 45 числел считать уже нельзя, проверяем на это сразу.
        else if (n > 2)
            return fibonachiNumber(--n) + fibonachiNumber(--n); //потом проверка на то, что можно начать считать.
        else if (n > 1)
            return 1; // остальные проверки идут позже, т.к. вызываться будут реже, и не надо тратить на них время.
        else if (n > 0) return 0;
        else return -1;

    }

}

