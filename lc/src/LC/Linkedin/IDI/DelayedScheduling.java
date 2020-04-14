package LC.Linkedin.IDI;

import java.util.PriorityQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class DelayedScheduling implements DelayedScheduler {

    private DelayQueue<Task> q;

    public void delayedRun(long timeToRun, Runnable task) {
        q.put(new Task(task, timeToRun));
    }

    static class SchedulerRunnable implements Runnable {

        private DelayQueue<Task> q;

        public SchedulerRunnable(DelayQueue<Task> q) {
            this.q = q;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Task task = q.take();
                    System.out.println("Take " + task);
                    task.getTask().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


class Task implements Delayed {
    private Runnable task;
    private long startTime;  // milliseconds

    public Runnable getTask() {
        return task;
    }
    public Task(Runnable task, long delay) {
        this.task = task;
        this.startTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return startTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.startTime - ((Task) o).startTime);
    }
}

interface DelayedScheduler {
    void delayedRun(long timeToRun, Runnable task);
}


class DelayQueue<E extends Delayed> {
    private final transient ReentrantLock lock = new ReentrantLock();
    private final PriorityQueue<E> q = new PriorityQueue<>();
    private final Condition available = lock.newCondition();
    private Thread leader = null;

    public void put(E e) {
        lock.lock();
        try {
            q.offer(e);
            available.signal();
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (true) {
                E first = q.peek();
                if (first == null) {
                    available.await();
                } else {
                    long delay = first.getDelay(MILLISECONDS);
                    if (delay <= 0) return q.poll();
                    else available.await(delay, MILLISECONDS);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Inserts the specified element into this delay queue.
     *
     * @param e the element to add
     * @return {@code true}
     * @throws NullPointerException if the specified element is null
     */
    public boolean put(E e) {
        lock.lock();
        try {
            q.offer(e);
            if (q.peek() == e) {
                leader = null;
                available.signal();
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element with an expired delay is available on this queue.
     *
     * @return the head of this queue
     * @throws InterruptedException {@inheritDoc}
     */
    public E take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (true) {
                E first = q.peek();
                if (first == null) {
                    available.await();
                } else {
                    long delay = first.getDelay(NANOSECONDS);
                    if (delay <= 0) return q.poll();
                    first = null; // don't retain ref while waiting
                    if (leader != null) {
                        available.await();
                    } else {
                        Thread thisThread = Thread.currentThread();
                        leader = thisThread;
                        try {
                            available.awaitNanos(delay);
                        } finally {
                            if (leader == thisThread)
                                leader = null;
                        }
                    }
                }
            }
        } finally {
            if (leader == null && q.peek() != null)
                available.signal();
            lock.unlock();
        }
    }
}

