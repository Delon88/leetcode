package LC.SOL;

import java.util.concurrent.Semaphore;

public class PrintZeroEvenOdd {
    class ZeroEvenOdd {
        private int n;

        Semaphore zero;
        Semaphore odd;
        Semaphore even;

        public ZeroEvenOdd(int n) {
            this.n = n;
            zero = new Semaphore(1);
            odd = new Semaphore(0);
            even = new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            boolean printEven = false;
            for (int i = 0; i < n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if (printEven) even.release();
                else odd.release();
                printEven = !printEven;
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0, num = 2; i < n / 2; i++, num += 2) {
                even.acquire();
                printNumber.accept(2);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0, num = 1; i < n / 2; i++, num += 2) {
                odd.acquire();
                printNumber.accept(num);
                zero.release();
            }
        }
    }
}
