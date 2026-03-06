package compulsory;


public class Company implements Profile, Comparable<Company> {
    private String id;
    private String name;

    public Company(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public int compareTo(Company other) {
        if (other == null || other.getName() == null) return 1;
        if (this.name == null) return -1;
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "company: " + name + " (id: " + id + ")";
    }
}