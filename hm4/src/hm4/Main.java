package hm4;

import com.github.javafaker.Faker;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.spanning.WeightedSpanningTreeIterator;
import java.util.Collection;
import org.graph4j.Edge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        // generam intersectii cu nume random folosind libraria ramdom
        Set<Intersection> intersections = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            intersections.add(new Intersection(faker.address().streetName()));
        }

        Intersection[] arr = intersections.toArray(new Intersection[0]);

        // generam strazi cu nume random
        List<Street> streets = new LinkedList<>();
        streets.add(new Street(faker.address().streetName(), 2.5, arr[0], arr[1]));
        streets.add(new Street(faker.address().streetName(), 1.2, arr[1], arr[2]));
        streets.add(new Street(faker.address().streetName(), 3.8, arr[0], arr[2]));
        streets.add(new Street(faker.address().streetName(), 0.9, arr[2], arr[3]));
        streets.add(new Street(faker.address().streetName(), 4.1, arr[3], arr[4]));
        streets.add(new Street(faker.address().streetName(), 1.5, arr[4], arr[5]));
        streets.add(new Street(faker.address().streetName(), 2.0, arr[3], arr[5]));
        streets.add(new Street(faker.address().streetName(), 5.0, arr[1], arr[4]));

        City myCity = new City("bucuresti", intersections, streets);

        // testam filtrarea prin stream api
        myCity.printFilteredStreets(2.0);

        System.out.println("\ncalculam posibilele retele de cost minim.");
        findSpanningTrees(myCity, 3); // cerem primele 3 solutii
    }

    public static void findSpanningTrees(City city, int numberOfSolutions) {
        Map<Intersection, Integer> nodeMap = new HashMap<>();//convertesc la valoriule cerute de graph4j
        int index = 0;
        for (Intersection intersection : city.getIntersections()) {
            nodeMap.put(intersection, index++);
        }

        // construim graful
        Graph graph = GraphBuilder.numVertices(city.getIntersections().size()).buildGraph();
        for (Street street : city.getStreets()) {
            graph.addEdge(nodeMap.get(street.getA()), nodeMap.get(street.getB()), street.getLength());
        }

        // cautam solutiile ordonate dupa cost
        WeightedSpanningTreeIterator iterator = new WeightedSpanningTreeIterator(graph);

        int count = 0;
        while (iterator.hasNext() && count < numberOfSolutions) {
            Collection<Edge> treeEdges = iterator.next();

            double totalCost = 0;
            for (Edge edge : treeEdges) {
                totalCost += edge.weight();
            }

            System.out.println("solutia " + (count + 1) + " a fost gasita cu costul minim aferent grafului. cost total: " + totalCost);
            count++;
        }
    }
}