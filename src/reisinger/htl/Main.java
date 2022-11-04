package reisinger.htl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {

        List<Fork> forks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            forks.add(new Fork(i));
        }


	    Ork Alois1 = new Ork(0, forks);
        Ork Alois2 = new Ork(1, forks);
        Ork Alois3 = new Ork(2, forks);
        Ork Alois4 = new Ork(3, forks);
        Ork Alois5 = new Ork(4, forks);

        Thread t = new Thread(Alois1);
        Thread t1 = new Thread(Alois2);
        Thread t2 = new Thread(Alois3);
        Thread t3 = new Thread(Alois4);
        Thread t4 = new Thread(Alois5);

        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
