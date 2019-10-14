package LC.SOL;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzzMultithreaded {
    class FizzBuzz {
        private int n;

        ReentrantLock lock = new ReentrantLock();
        Condition c = lock.newCondition();
        volatile int cur = 1;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            lock.lock();
            try {
                while (cur <= n) {
                    if (cur % 3 != 0 || cur % 5 == 0) {c.await(); continue;}
                    printFizz.run();
                    cur++;
                    c.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            lock.lock();
            try {
                while (cur <= n) {
                    if (cur % 5 != 0 || cur % 3 == 0) {c.await(); continue;}
                    printBuzz.run();
                    cur++;
                    c.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".

        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            lock.lock();
            try {
                while (cur <= n) {
                    if (cur % 15 != 0) {c.await(); continue;}
                    printFizzBuzz.run();
                    cur++;
                    c.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            lock.lock();
            try {
                while (cur <= n) {
                    if (cur % 5 == 0 || cur % 3 == 0) {c.await(); continue;}
                    printNumber.accept(cur);
                    cur++;
                    c.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
