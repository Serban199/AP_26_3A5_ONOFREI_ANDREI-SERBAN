package hm5;

import freemarker.template.*;
import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class RaportCommand implements Command {
    private Catalog catalog;

    public RaportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CatalogException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        try {
            cfg.setDirectoryForTemplateLoading(new File("src/hm5"));
            Template temp = cfg.getTemplate("report.ftl");

            Map<String, Object> root = new HashMap<>();
            root.put("resources", catalog.getResources());

            File output = new File("catalog_report.html");
            try (Writer out = new FileWriter(output)) {
                temp.process(root, out);
            }

            Desktop.getDesktop().open(output);
        } catch (Exception e) {
            throw new CatalogException("eroare la generarea raportului", e);
        }
    }
}