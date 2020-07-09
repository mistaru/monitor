package argen;

class MyMonitor {

    public static void main(String[] args) {

        Queue queue = new Queue();

        Writer w1 = new Writer(queue, "Оля");
        Writer w2 = new Writer(queue, "Юля");
        Writer w3 = new Writer(queue, "Таня");
        Writer w4 = new Writer(queue, "Валя");
        Writer w5 = new Writer(queue, "Нюша");
        Writer w6 = new Writer(queue, "Даша");
        Writer w7 = new Writer(queue, "Маша");
        Writer w8 = new Writer(queue, "Саша");


        Reader r1 = new Reader(queue, "Арген");
        Reader r2 = new Reader(queue, "Бексултан");
        Reader r3 = new Reader(queue, "Мырза");
        Reader r4 = new Reader(queue, "Талгат");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {
        }

        queue.work = false;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }

        System.out.println

                (
                                "Оля записал: " + w1.i + " раз\n" +

                                "Юля записал: " + w2.i + " раз\n" +

                                "Арген прочитал: " + r1.i + " раз\n" +

                                "Бексултан прочитал: " + r2.i + " раз\n" +

                                "Мырза прочитал: " + r3.i + " раз\n" +

                                "Талгат прочитал: " + r4.i + " раз\n" +

                                "Таня записал: " + w3.i + " раз\n" +

                                "Валя записал: " + w4.i + " раз\n" +

                                "Нюша записал: " + w5.i + " раз\n" +

                                "Даша записал: " + w6.i + " раз\n" +

                                "Маша записал: " + w7.i + " раз\n" +

                                "Саша записал: " + w8.i + " раз\n"
                );

    }

}



