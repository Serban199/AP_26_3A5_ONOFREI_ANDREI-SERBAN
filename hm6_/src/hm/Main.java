package hm;

import java.sql.SQLException;
import java.time.LocalDate;
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

            Movie myMovie = new Movie(
                    "Inception",
                    LocalDate.of(2010, 7, 16),
                    148,
                    8.8,
                    actionId
            );

            movies.create(myMovie);
            System.out.println("filmul " + myMovie.getTitle() + " a fost salvat!");
            List<Movie> dbMovies = movies.findAll();

            ReportGenerator generator = new ReportGenerator();
            generator.createReport(dbMovies);

            Database.getConnection().commit();
        } catch (SQLException e) {
            System.err.println("eroare la salvarea datelor: " + e.getMessage());
            try {
                Database.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            Database.closePool();
        }
    }
}