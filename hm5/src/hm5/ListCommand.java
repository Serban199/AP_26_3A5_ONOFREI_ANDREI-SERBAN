package hm5;

public class ListCommand implements Command {
    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        System.out.println("continutul catalogului:");
        catalog.getResources().forEach(System.out::println);
    }
}