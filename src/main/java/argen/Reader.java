package argen;

public class Reader implements Runnable {

    private Queue queue;

    int i = 0;

    Reader(Queue queue, String name) {

        this.queue = queue;

        new Thread(this, "Читатель " + name).start();

    }

    public void run() {

        while (queue.work) {
            queue.read();
            i++;
        }

    }

}

