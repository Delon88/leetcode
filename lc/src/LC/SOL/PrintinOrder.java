package LC.SOL;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintinOrder {
    class Foo {

        AtomicInteger i;
        public Foo() {
            i = new AtomicInteger(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            while ( i.get() != 0 ) {
                Thread.sleep(1);
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            i.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while ( i.get() != 1 ) {
                Thread.sleep(1);
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            i.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while ( i.get() != 2 ) {
                Thread.sleep(1);
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            i.incrementAndGet();
        }
    }
}
