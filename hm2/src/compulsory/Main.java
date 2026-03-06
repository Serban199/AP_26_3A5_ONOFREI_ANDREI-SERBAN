package compulsory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Profile> network = new ArrayList<>();

        network.add(new Person("p1", "popescu ion"));
        network.add(new Company("c1", "ae corporation"));
        network.add(new Person("p2", "ionescu maria"));
        network.add(new Company("c2", "aumovio"));
        network.sort(new Comparator<Profile>() {
            @Override
            public int compare(Profile p1, Profile p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        for (Profile p : network) {
            System.out.println(p);
        }
    }
}