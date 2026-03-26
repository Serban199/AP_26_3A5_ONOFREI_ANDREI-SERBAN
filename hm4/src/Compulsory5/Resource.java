package Compulsory5;


public class Resource {
    private String id;
    private String title;
    private String location;
    private int year;
    private String author;

    public Resource(String id, String title, String location, int year, String author) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public int getYear() { return year; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return title + " " + author + " " + year ;
    }
}