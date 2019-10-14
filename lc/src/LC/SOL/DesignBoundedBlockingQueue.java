package LC.SOL;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DesignBoundedBlockingQueue {
    class BoundedBlockingQueue {

        ReentrantLock lock = new ReentrantLock();
        Condition notfull = lock.newCondition();
        Condition notempty = lock.newCondition();
        int[] q;
        int head = 0;
        int tail = 0;
        int size = 0;

        public BoundedBlockingQueue(int capacity) {
            q = new int[capacity];
        }

        public void enqueue(int element) throws InterruptedException {
            lock.lock();
            try {
                while (size == q.length) notfull.await();
                q[tail++] = element;
                if (tail == q.length) tail = 0;
                size++;
                notempty.signal();
            } finally {
                lock.unlock();
            }
        }

        public int dequeue() throws InterruptedException {
            lock.lock();
            try {
                while (size == 0) notempty.await();
                int ret = q[head++];
                if (head == q.length) head = 0;
                size--;
                notfull.signal();
                return ret;
            } finally {
                lock.unlock();
            }
        }

        public int size() {
            lock.lock();
            try {
                return this.size;
            } finally {
                lock.unlock();
            }
        }
    }
}
