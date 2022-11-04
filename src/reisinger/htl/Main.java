package reisinger.htl;

import java.util.ArrayList;
import java.util.List;

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

        System.out.println(Alois1.getLeftFork().number);
        System.out.println(Alois1.getRightFork().number);
        System.out.println(Ork.getList());
        Alois1.returnLeft();
        Alois1.returnRight();
        System.out.println(Ork.getList());

    }
}
