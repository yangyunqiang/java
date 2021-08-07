
public class Tortoise2 extends Thread {

    private int totalStep;
    private int step;

    public Tortoise2(int totalStep) {
        this.totalStep = totalStep;
        step = 0;
    }

    public int getStep() {
        return step;
    }

    private void addStep() {
        step ++;
    }

    @Override
    public void  run() {
        int num = 0;
        while (num < 50) {
            addStep();
            num++;
            System.out.println("addstep: " + step);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Tortoise2 tortoise = new Tortoise2(100);
        Thread tortoiseThread1 = new Thread(tortoise);
        Thread tortoiseThread2 = new Thread(tortoise);

        tortoiseThread1.start();
        tortoiseThread2.start();

        tortoiseThread1.join();
        tortoiseThread2.join();
        System.out.println(tortoise.getStep());
    }
}
