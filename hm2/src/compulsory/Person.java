package compulsory;

public class Person implements Profile, Comparable<Person> {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public int compareTo(Person other) {
        if (other == null || other.getName() == null) return 1;
        if (this.name == null) return -1;
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "person: " + name + " (id: " + id + ")";
    }
}
