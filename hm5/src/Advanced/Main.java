package Advanced;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Resource> catalog = new ArrayList<>();
        String[] concepte = {"java", "grafuri", "retele", "baze de date"};
        Set<String> target = new HashSet<>(Arrays.asList(concepte));

        Random rand = new Random();

        // generam 5000 de resurse de test
        for (int i = 0; i < 5000; i++) {
            Item item = new Item("id" + i, "titlu " + i, "loc");
            item.addConcept(concepte[rand.nextInt(4)]);
            item.addConcept(concepte[rand.nextInt(4)]);
            catalog.add(item);
        }

        // masuram timpul
        long start = System.currentTimeMillis();

        Algorithm alg = new Algorithm();
        List<Resource> solutie = alg.findCover(catalog, target);

        long end = System.currentTimeMillis();

        System.out.println("ca sa acoperim toate conceptele, ne trebuie " + solutie.size() + " carti.");
        System.out.println("timpul de calcul a fost: " + (end - start) + " milisecunde.");
    }
}