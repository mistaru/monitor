package argen;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Queue {
    private int[] n = new int[10];

    boolean work = true;

    private final Lock lock = new ReentrantLock();

    private final Condition ReaderCanStart = lock.newCondition();

    private final Condition WriterCanStart = lock.newCondition();

    private int WaitingReader = 0;
    private int RunningReader = 0;

    private int WaitingWriter = 0;
    private int RunningWriter = 0;

    void read() {

        Thread t = Thread.currentThread();

        System.out.println(t.getName() + " ждет...");

        StartRead();

        System.out.println(t.getName() + " читает...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }

        int m = randomBooks(n);

        System.out.println(t.getName() + ": " + m);

        StopRead();

    }

    private void StartRead() {

        lock.lock();

        try {

            if ((RunningWriter > 0)) {

                WaitingReader++;

                try {
                    ReaderCanStart.await();
                } catch (InterruptedException ignored) {
                }

            } else

                RunningReader++;

        } finally {
            lock.unlock();
        }

    }

    private void StopRead() {

        lock.lock();

        try {

            RunningReader--;

            if ((RunningReader == 0) & (WaitingWriter > 0)) {

                WaitingWriter--;

                RunningWriter++;

                WriterCanStart.signal();

            }

        } finally {
            lock.unlock();
        }

    }


    void write(int[] n) {

        Thread t = Thread.currentThread();

        System.out.println(t.getName() + " ждет...");

        StartWrite();

        System.out.println(t.getName() + " обновил...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }

        this.n = n;

        StopWrite();

        System.out.println(t.getName() + ": " + toString(n));

    }

    private void StartWrite() {

        lock.lock();

        try {

            if ((RunningWriter > 0) | (RunningReader > 0)) {

                WaitingWriter++;

                try {
                    WriterCanStart.await();
                } catch (InterruptedException ignored) {
                }

            } else RunningWriter++;

        } finally {
            lock.unlock();
        }

    }

    private void StopWrite() {

        lock.lock();

        try {
            RunningWriter--;

            if (WaitingReader > 0) {

                while (WaitingReader > 0) {

                    RunningReader++;

                    WaitingReader--;

                    ReaderCanStart.signal();

                }

            } else if (WaitingWriter > 0) {

                WaitingWriter--;

                RunningWriter++;

                WriterCanStart.signal();

            }

        } finally {
            lock.unlock();
        }

    }

    private String toString(int[] n) {

        StringBuilder s = new StringBuilder();

        for (int value : n) s.append(value).append(" ");

        return s.toString();

    }

    private int randomBooks(int[] m) {

        int randomIndex = new Random().nextInt(m.length);

        return m[randomIndex];
    }

}
