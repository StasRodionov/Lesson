package JavaJunior;

public class Multithreading {

    static boolean win = false;

    public static void main(String[] args) {

        int ramdom = (int) (Math.random() * 1000000000);
        System.out.println(ramdom);

        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while (!win) {
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread player = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!win) {
                    int guessNumber = (int) (Math.random() * 1000000000);
                    if (guessNumber == ramdom) {
                        win = true;
                        System.out.println(guessNumber);
                    }
                }
            }
        });
        timer.start();
        player.start();
    }
}
