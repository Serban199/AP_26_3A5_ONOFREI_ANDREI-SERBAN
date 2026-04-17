package Advanced;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {

    public void createReport(List<Movie> movies) {
        StringBuilder html = new StringBuilder();

        html.append("<html><head><title>raport filme</title></head>");
        html.append("<body style='font-family: arial;'>");
        html.append("<h1>colectia mea de filme</h1>");
        html.append("<table border='1' cellpadding='10' cellspacing='0'>");
        html.append("<tr style='background-color: #f2f2f2;'><th>id</th><th>titlu</th><th>durata (min)</th><th>scor</th></tr>");

        for (Movie m : movies) {
            html.append("<tr>");
            html.append("<td>").append(m.getId()).append("</td>");
            html.append("<td><b>").append(m.getTitle()).append("</b></td>");
            html.append("<td>").append(m.getDuration()).append("</td>");
            html.append("<td>").append(m.getScore()).append("</td>");
            html.append("</tr>");
        }

        html.append("</table></body></html>");

        try (FileWriter file = new FileWriter("raport_filme.html")) {
            file.write(html.toString());
            System.out.println("raportul a fost salvat in fisierul raport_filme.html!");
        } catch (IOException e) {
            System.err.println("eroare la scrierea fisierului: " + e.getMessage());
        }
    }
}