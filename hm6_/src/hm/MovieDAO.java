package hm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    public void create(Movie movie) throws SQLException {
        String sql = "INSERT INTO movies (title, release_date, duration, score, genre_id) VALUES (?, ?, ?, ?, ?) ";

        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, movie.getTitle());
            pstmt.setDate(2, Date.valueOf(movie.getReleaseDate()));
            pstmt.setInt(3, movie.getDuration());
            pstmt.setDouble(4, movie.getScore());
            pstmt.setInt(5, movie.getGenreId());

            pstmt.executeUpdate();
        }
    }

    public List<Movie> findAll() throws SQLException {
        List<Movie> allMovies = new ArrayList<>();
        String sql = "SELECT * FROM movies";

        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));

                Date sqlDate = rs.getDate("release_date");
                if (sqlDate != null) {
                    m.setReleaseDate(sqlDate.toLocalDate());
                }

                m.setDuration(rs.getInt("duration"));
                m.setScore(rs.getDouble("score"));
                m.setGenreId(rs.getInt("genre_id"));

                allMovies.add(m);
            }
        }
        return allMovies;
    }
}