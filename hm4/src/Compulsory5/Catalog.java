package Compulsory5;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Resource> resources = new ArrayList<>();

    public void addResource(Resource resource) throws InvalidResourceException {
        if (resource.getId() == null || resource.getLocation() == null) {
            throw new InvalidResourceException("resursa trebuie sa aiba id si locatie valide.");
        }
        resources.add(resource);
        System.out.println("am adaugat: " + resource);
    }

    public void openResource(Resource resource) {
        try {
            Desktop desktop = Desktop.getDesktop();
            String loc = resource.getLocation();

            if (loc.startsWith("http://") || loc.startsWith("https://")) {
                desktop.browse(new URI(loc));
            } else {
                File file = new File(loc);
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.out.println("fisierul nu exista pe disc: " + loc);
                }
            }
        } catch (Exception e) {
            System.out.println("eroare la deschiderea resursei: " + e.getMessage());
        }
    }
}