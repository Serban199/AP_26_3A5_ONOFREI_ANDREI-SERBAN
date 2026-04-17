package Advanced;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataImporter {

    public void importMoviesFromCsv(String filePath, MovieDAO movieDAO, int defaultGenreId) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {
                    String title = data[0];
                    LocalDate releaseDate = LocalDate.parse(data[1]);
                    int duration = Integer.parseInt(data[2]);
                    double score = Double.parseDouble(data[3]);

                    Movie m = new Movie(title, releaseDate, duration, score, defaultGenreId);

                    movieDAO.create(m);
                }
            }
            System.out.println("importul s-a terminat cu succes!");

        } catch (IOException | SQLException e) {
            System.err.println("eroare la import: " + e.getMessage());
        }
    }
}