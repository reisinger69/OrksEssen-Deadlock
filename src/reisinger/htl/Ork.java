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
        System.out.println("start");
        while (true) {
            try {
                System.out.println("Ork " + number + " starting drinking");
                drink();
                leftFork = getLeftFork();
                rightFork = getRightFork();
                eat();
                returnLeft();
                returnRight();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void drink() throws InterruptedException {
        int random = (int) (Math.random()*15+1);
        Thread.sleep(random);
        System.out.println("Ork " + number + " slept for " + random + "ms");
    }

    void eat() throws InterruptedException {
        int random = (int) (Math.random()*5+1);
        Thread.sleep(random);
        System.out.println("Ork " + number + " was eating for " + random + "ms");
    }

    Fork getRightFork() throws InterruptedException {
        System.out.println("trying to get right fork");
        while (true) {
            Thread.sleep(5);
            Fork temp = forks.get(number);
            if (temp == null) {
                //System.out.println("not found - " + number);
                continue;
            }
            System.out.println("got right fork - " + number);
            rightFork = temp;
            forks.set(number, null);
            return temp;
        }
    }

    Fork getLeftFork() throws InterruptedException {
        System.out.println("trying to get left fork");
        while (true) {
            Thread.sleep(5);
            if (number <= 0) {
                Fork temp = forks.get((number - 1 + 5));
                if (temp == null) {
                    //System.out.println("not found - " + number);
                    continue;
                }
                leftFork = temp;
                forks.set(number - 1 + 5, null);
                return temp;
            }
            Fork temp = forks.get(number - 1);
            if (temp == null) {
                //System.out.println("not found - " + number);
                continue;
            }
            leftFork = temp;
            forks.set(number - 1, null);
            System.out.println("got left fork - " + number);
            return temp;
        }
    }

    void returnRight() {
        forks.set(number, rightFork);
    }

    void returnLeft() {
        if (number <= 0) {
            forks.set(number-1+5, leftFork);
        } else {
            forks.set(number - 1, leftFork);
        }
    }

    public static List getList() {
        return forks;
    }
}
