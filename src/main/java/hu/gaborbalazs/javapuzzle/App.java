package hu.gaborbalazs.javapuzzle;

/**
 * The goal is to print out the "Am I still dreaming?" message.
 * Only the Dream.dream() method is allowed to be modified.
 */
public class App {

    public static void main(String[] args) {

        System.out.println(">> main()");

        if (new Sleeper().enter(new Dream()) != 0) {
            // The goal is to reach this line
            System.out.println("Am I still dreaming?");
        }

        System.out.println("<< main()");
    }
}

class Sleeper {
    private int level;

    public synchronized int enter(Dream dream) {
        level++;
        try {
            dream.dream(this);
        } finally {
            level--;
        }
        return level;
    }
}

class Dream {

    /**
     * This is the only one method we are allowed to modify to solve the problem.
     *
     * @param s is the Sleeper
     */
    public void dream(final Sleeper s) {
        new Thread() {
            public void run() {
                s.enter(new Dream() {
                    @Override
                    public void dream(Sleeper s) {
                        try {
                            s.wait(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }.start();

        try {
            s.wait(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
