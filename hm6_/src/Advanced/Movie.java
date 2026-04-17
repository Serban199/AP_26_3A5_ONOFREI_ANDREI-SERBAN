package Advanced;
import java.time.LocalDate;

public class Movie {
    private Integer id;
    private String title;
    private LocalDate releaseDate;
    private int duration; //min
    private double score;
    private int genreId;

    public Movie() {}

    public Movie(String title, LocalDate releaseDate, int duration, double score, int genreId) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
        this.genreId = genreId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public int getGenreId() { return genreId; }
    public void setGenreId(int genreId) { this.genreId = genreId; }

    @Override
    public String toString() {
        return "Movie{" + "title='" + title + '\'' + ", score=" + score + '}';
    }
}