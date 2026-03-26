package Advanced;

import java.awt.*;
import java.io.File;
import java.net.URI;

public class ViewCommand implements Command {
    private Resource resource;

    public ViewCommand(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void execute() throws CatalogException {
        if (resource == null) throw new CatalogException("resursa nu exista");

        try {
            Desktop desktop = Desktop.getDesktop();
            if (resource.getLocation().startsWith("http")) {
                desktop.browse(new URI(resource.getLocation()));
            } else {
                desktop.open(new File(resource.getLocation()));
            }
        } catch (Exception e) {
            throw new CatalogException("nu s-a putut deschide locatia: " + resource.getLocation(), e);
        }
    }
}