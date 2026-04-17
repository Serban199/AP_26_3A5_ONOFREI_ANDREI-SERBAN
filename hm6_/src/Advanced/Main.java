package Advanced;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            GenreDAO genres = new GenreDAO();
            MovieDAO movies = new MovieDAO();

            Integer actionId = genres.findByName("Action");
            if (actionId == null) {
                genres.create("Action");
                actionId = genres.findByName("Action");
            }

            DataImporter importer = new DataImporter();
            importer.importMoviesFromCsv("src/Advanced/movies.csv", movies, actionId);

            List<Movie> dbMovies = movies.findAll();

            ReportGenerator generator = new ReportGenerator();
            generator.createReport(dbMovies);

        } catch (SQLException e) {
            System.err.println("eroare la bd: " + e.getMessage());
        } finally {
            Database.closePool();
        }
    }
}