/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task5 {

    public static int febonachiNumber(int n) {
        n = checkArgument(n);

        if (n > 2) {
            return febonachiNumber(--n) + febonachiNumber(--n);
        } else return n;

    }

    public static int febonachiObjectRecursion(int length) {

        length = checkArgument(length);

        if (length < 3) {
            return length;
        }

        FeboNode f1 = null;

        for (int i = 1; i < length; i++) {
            if (i < 3)
                f1 = new FeboNode(1, f1);
            else
                f1 = new FeboNode(f1.feboValue + f1.next.feboValue, f1);
        }

        return f1.feboValue;

    }

    public static int checkArgument(int arg) {
        if (arg > 45) return -1; // больше 45 числел считать уже нельзя, проверяем на это сразу.
        else if (arg > 2)
            return arg; //потом проверка на то, что можно начать считать.
        else if (arg > 1)
            return 1; // остальные проверки идут позже, т.к. вызываться будут реже, и не надо тратить на них время.
        else if (arg > 0) return 0; // res = 0, 1, 1, 2, 3, 5, 8....
        else return -1;             //   n = 1, 2, 3, 4, 5, 6, 7
    }

    private static class FeboNode {

        int feboValue = 0;
        FeboNode next = null;

        public FeboNode(int feboValue, FeboNode next) {
            this.feboValue = feboValue;
            this.next = next;
        }
    }

}

