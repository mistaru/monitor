package argen;

public class Writer implements Runnable {

    private Queue queue;

    int i = 0;

    Writer(Queue queue, String name) {

        this.queue = queue;

        new Thread(this, "Работник " + name).start();

    }

    public void run() {

        while (queue.work) {
            queue.write(creatRandom(10));
            i++;
        }

    }

    private int[] creatRandom(int n) {

        int[] m = new int[n];

        for (int i = 0; i < n; i++)

            m[i] = (int) Math.round(Math.random() * 10);

        return m;

    }

}

