package Compulsory5;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Resource book = new Resource("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth");
        Resource webDoc = new Resource("jvm25", "The Java Virtual Machine Specification", "https://docs.oracle.com/javase/specs/jvms/se25/html/index.html", 2025, "Tim Lindholm & others");

        try {
            catalog.addResource(book);
            catalog.addResource(webDoc);

            // deschidem resursa web
            System.out.println("incercam sa deschidem resursa web...");
            catalog.openResource(webDoc);

        } catch (InvalidResourceException e) {
            System.out.println("exceptie prinsa: " + e.getMessage());
        }
    }
}