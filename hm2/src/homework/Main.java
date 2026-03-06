package homework;

public class Main {

    public static void main(String[] args) {
        City bucuresti = new City("bucuresti", 0, 0, 2000000);
        City iasi = new City("iasi", 3, 4, 300000);

        Road drum = new Road(Roads.express, 5, 100, bucuresti, iasi);

        System.out.println(bucuresti.getName());
        System.out.println(drum);


        Problem harta = new Problem();

        harta.addLocation(bucuresti);
        harta.addLocation(iasi);
        harta.addRoad(drum);

        // testam metoda equals: incercam sa adaugam iasi inca o data
        System.out.println("incercam sa adaugam orasul iasi a doua oara:");
        harta.addLocation(iasi);


        // verificam algoritmul bfs
        System.out.println("exista drum intre bucuresti si iasi? " + harta.pathExists(bucuresti, iasi));

        City cluj = new City("cluj", 10, 10, 400000);
        harta.addLocation(cluj);

        System.out.println("exista drum intre bucuresti si cluj? " + harta.pathExists(bucuresti, cluj));
    }
}