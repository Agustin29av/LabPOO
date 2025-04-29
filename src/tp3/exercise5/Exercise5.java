package src.tp3.exercise5;
public class Exercise5 {

    // The Integer class must be static to be used from main
    public static class IntegerNumber {
        private int number;

        public IntegerNumber(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public long square() {
            return (long) number * number;
        }

        public boolean isEven() {
            return number % 2 == 0;
        }

        public long factorial() {
            long result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            return result;
        }

        public boolean isPrime() {
            if (number <= 1) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        }
    }

}
