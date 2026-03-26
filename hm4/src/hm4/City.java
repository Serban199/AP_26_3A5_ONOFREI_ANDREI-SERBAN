package hm4;

import java.util.List;
import java.util.Set;
public class City {
    private String name;
    private Set<Intersection> intersections;
    private List<Street> streets;
    public City(String name, Set<Intersection> intersections, List<Street> streets) {
        this.name = name;
        this.intersections = intersections;
        this.streets = streets;
    }
    public List<Street> getStreets() {
        return streets;
    }

    public Set<Intersection> getIntersections() {
        return intersections;
    }

    public void printFilteredStreets(double minLength) {
        System.out.println("strazi mai lungi ca val data si care comunica cu alte 3:");

        streets.stream()
                .filter(street -> street.getLength() > minLength)
                .filter(street -> {
                    long connectedCount = streets.stream()
                            .filter(other -> other != street) // ignoram strada curenta
                            .filter(other -> other.getA() == street.getA() ||
                                    other.getA() == street.getB() ||
                                    other.getB() == street.getA() ||
                                    other.getB() == street.getB())
                            .count();

                    return connectedCount >= 3;
                })
                .forEach(street -> System.out.println(street.getName()));
    }
}
