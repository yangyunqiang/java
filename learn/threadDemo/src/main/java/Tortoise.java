
public class Tortoise implements Runnable{

    private int totalStep;
    private int step;

    public Tortoise(int totalStep) {
        this.totalStep = totalStep;
        step = 0;
    }

    public int getStep() {
        return step;
    }

    private synchronized void addStep() {
        step ++;
    }

    @Override
    public void  run() {
        int num = 0;
        while (num < 1000000) {
            addStep();
            num++;
            //System.out.println("addstep: " + step + " "+Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Tortoise tortoise = new Tortoise(100);
        Thread tortoiseThread1 = new Thread(tortoise);
        Thread tortoiseThread2 = new Thread(tortoise);

        tortoiseThread1.start();
        tortoiseThread2.start();

        tortoiseThread1.join();
        tortoiseThread2.join();
        System.out.println(tortoise.getStep());
    }
}
