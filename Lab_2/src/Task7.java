/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class Task7 {

    public static class NumbersPermutater {

        private final int TEN = 10;
        private int initNumer;
        private int value;
        private int nextValue;

        NumbersPermutater(int initNumer) {
            this.initNumer = initNumer;

            value = 0;
            int multipier = 1;
            int border = 1;
            int i = initNumer;

            while (border <= i) {
                value += i * multipier;
                multipier *= 10;
                i--;
            }
        }

        public int permutateNumbersByIndex(int n1, int n2) {

            if (n1 > initNumer || n1 < 1 || n2 > initNumer || n2 < 1) throw new IllegalArgumentException();

            int nn1, nn2;
            if (n1 > n2) {
                nn1 = n1;
                nn2 = n2;
            } else {
                nn1 = n2;
                nn2 = n1;
            }

            int delimiter = Task3.raiseNumber(TEN, nn1);

            int result = value / delimiter * delimiter;
            result += getDigit(nn2) * (delimiter / TEN);
            result += value % (delimiter / TEN);
            while (nn1 > nn2) {
                delimiter /= TEN;
                nn2++;
            }
            result -= value % delimiter;
            result += getDigit(nn1) * (delimiter / TEN);
            result += value % (delimiter / TEN);

            return result;
        }

        public void printCombinationsNew() {

            if (initNumer < 2) {
                System.out.println(initNumer);
                return;
            } else if (initNumer > 9) {
                throw new IllegalArgumentException("Слишком большое число! Попробуйте от 1 до 9");
            }

            int counter = 0;
            int maxValue = Task2.reverseNumber(value);
            int maxCombinationsCount = Task4.factorialNumber(initNumer);
            boolean needContinue;

            //этот цикл реализует алгоритм Дейкстры для получения всех перестановок по алфавиту
            while (true) {
                System.out.println(toString());
                counter++;
                needContinue = false;
                int exchangeElement = 0, j, minForExchange = 1;
                for (j = 2; j <= initNumer; j++) {
                    exchangeElement = getDigit(j - 1);
                    if (getDigit(j) < exchangeElement) {
                        needContinue = true;
                        break;
                    }
                }
                if (needContinue == false) {
                    break;
                }
                for (int k = j - 1; k > 0; k--) {
                    if ((getDigit(k) > getDigit(j)) && ((getDigit(k) - getDigit(j)) < exchangeElement)) {
                        minForExchange = k;
                    }
                }
                nextValue = permutateNumbersByIndex(minForExchange, j);
                if (j > 2) {
                    int rightPart = nextValue % Task3.raiseNumber(TEN, j - 1);
                    value = nextValue - rightPart + Task2.reverseNumber(rightPart);
                    if (nextValue - value < 0) value = nextValue;
                } else {
                    value = nextValue;
                }
            }

            System.out.println("Количество комбинаций: " + counter + "; Ожидаемый результат: " + maxCombinationsCount + " Статус: " + (counter == maxCombinationsCount));
            System.out.println("Последнее значение среди всех перестановок по алфавиту: " + value + "; Ожидаемый результат: " + maxValue + " Статус: " + (value == maxValue));

        }

        public int getDigit(int i) {

            if (i < 1 || i > initNumer) throw new IllegalArgumentException();

            int delimiter = 1;

            while (i >= 1) {
                i--;
                delimiter *= TEN;
            }

            int result = value % delimiter; // left part

            result = result / (delimiter / TEN);

            return result;

        }

        public int permutateNumber(int n) {

            if (n == initNumer || n < 1) throw new IllegalArgumentException();

            int i = initNumer;
            int delimiter = 1;

            while (i >= n) {
                i--;
                delimiter *= TEN;
            }

            int leftPart = value / delimiter * delimiter; // left part

            delimiter /= TEN;

            int rightPart = 0;
            if (delimiter > 10)
                rightPart += value % (delimiter / TEN); //right part

            int result = 0;

            result += value % delimiter / (delimiter / TEN);
            delimiter *= 10;
            result *= TEN;
            result += value % delimiter / (delimiter / TEN); //new combination

            if (delimiter > 100) result *= delimiter / TEN / TEN;

            result += leftPart;

            result += rightPart;

            nextValue = result;

            return nextValue - value;
        }

        public void printCombinations() {

            if (initNumer < 2) {
                System.out.println(initNumer);
                return;
            }

            int maxValue = Task2.reverseNumber(value);
            int maxCombinationsCount = Task4.factorialNumber(initNumer);
            int multipier = 1;
            int border = 1;
            int i = initNumer;

            /*while (border <= i) {
                value += i * multipier;
                multipier *= 10;
                i--;
            }*/

            System.out.println(toString());
            int counter = 2;
            int nextIter = initNumer - 1;
            while (true) { //http://goo.gl/fkAaEo - код на с++
                i = nextIter;
                int prevValue = value;
                while (i > 0 && permutateNumber(i) < 0) {
                    i--;
//                    System.out.println("^^ val:" + value + "=>" + nextValue + "  :" + (i--));
                    value = nextValue;
                }
                if (counter >= maxCombinationsCount) {
                    System.out.println(toString());
                    break;
                }

                if (value == nextValue) {
                    value = prevValue;
                    nextIter = (--nextIter < 1) ? initNumer - 1 : nextIter;
                    continue;
                }

                value = nextValue;
                while (i < initNumer) {
                    int j = i + 1;
                    while (j < initNumer && permutateNumber(j) < 0) {
                        j++;
//                    System.out.println("^^ val:" + value + "=>" + nextValue + "  :" + (j++));
                        value = nextValue;
                    }
                    i++;
                }
                if (value - nextValue > 0) value = nextValue;
                System.out.println(toString());
                counter++;
            }

//            for (border = 2; border <= initNumer; border++) {
//                for (int j = 1; j <= border; j++) {
//                    int n = initNumer - j;
//                    if (n == 0) n = initNumer - 1;
//                    System.out.println("(" + permutateNumber(n) + ")");
//                }
//            }

        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + value + ')';
        }
    }
}
