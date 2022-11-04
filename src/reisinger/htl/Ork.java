package reisinger.htl;

import java.util.ArrayList;
import java.util.List;

public class Ork implements Runnable{

    private int number;
    static List<Fork> forks = new ArrayList();
    private Fork leftFork;
    private Fork rightFork;

    public Ork(int number, List forkList) {
        this.number = number;
        forks = forkList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("starting drinking");
                drink();
                leftFork = getLeftFork();
                rightFork = getRightFork();
                eat();



            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void drink() throws InterruptedException {
        int random = (int) (Math.random()*5+1);
        Thread.sleep(random*100);
        System.out.println("slept for " + random*100 + "ms");
    }

    void eat() throws InterruptedException {
        int random = (int) (Math.random()*5+1);
        Thread.sleep(random*100);
        System.out.println("Ork " + number + " was eating for " + random*100 + "ms");
    }

    Fork getRightFork() {
        return forks.remove(number);
    }

    Fork getLeftFork() {
        if (number <= 0) {
            return forks.remove((number-1+5));
        }
        return forks.remove(number-1);
    }

    void returnRight() {
        forks.add(number, rightFork);
    }

    void returnLeft() {
        if (number <= 0) {
            forks.add(number-1+5, leftFork);
        }
        forks.add(number-1, leftFork);
    }

    public static List getList() {
        return forks;
    }
}
