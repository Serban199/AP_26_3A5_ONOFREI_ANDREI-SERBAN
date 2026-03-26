package Advanced;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand implements Command {
    private Catalog catalog;
    private String path;

    public SaveCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }

    @Override
    public void execute() throws CatalogException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(catalog);
        } catch (IOException e) {
            throw new CatalogException("eroare la salvare in " + path, e);
        }
    }
}