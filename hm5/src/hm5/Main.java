package hm5;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        // adaugare resurse de test
        Item res1 = new Item("knuth67", "the art of computer programming", "https://books.google.com");
        Item res2 = new Item("java25", "java language spec", "https://docs.oracle.com");

        catalog.add(res1);
        catalog.add(res2);

        try {
            // executare comanda list
            new ListCommand(catalog).execute();

            // executare comanda save
            new SaveCommand(catalog, "catalog.ser").execute();



            // executare comanda raport
            new RaportCommand(catalog).execute();

        } catch (CatalogException e) {
            System.err.println("eroare: " + e.getMessage());
        }
    }
}