package Advanced;

import com.github.javafaker.Faker;
import org.graph4j.Edge;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.spanning.WeightedSpanningTreeIterator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        // generam intersectii cu coord x y
        Set<Intersection> intersections = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            double randomX = Math.random() * 100;
            double randomY = Math.random() * 100;
            intersections.add(new Intersection(faker.address().streetName(), randomX, randomY));
        }

        Intersection[] arr = intersections.toArray(new Intersection[0]);


        // construim un graf complet cu iontersectiile toate coneect
        List<Street> streets = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double length = Math.sqrt(Math.pow(arr[i].getX() - arr[j].getX(), 2) + Math.pow(arr[i].getY() - arr[j].getY(), 2));
                length = Math.round(length * 100.0) / 100.0;

                streets.add(new Street(faker.address().streetName(), length, arr[i], arr[j]));
            }
        }

        City myCity = new City("bucuresti", intersections, streets);

        // testam filtrarea prin stream api
        myCity.printFilteredStreets(50.0);

        System.out.println("\ncalculam posibilele retele de cost minim.");
        printMaintenanceRoute(myCity);
    }

    public static void printMaintenanceRoute(City city) {
        int n = city.getIntersections().size();


        Map<Intersection, Integer> nodeMap = new HashMap<>();//transform numele in val num
        Map<Integer, Intersection> reverseMap = new HashMap<>();

        int index = 0;
        for (Intersection intersection : city.getIntersections()) {
            nodeMap.put(intersection, index);
            reverseMap.put(index, intersection);
            index++;
        }

        // construim graful si o matrice ca sa stim  distantele
        Graph graph = GraphBuilder.numVertices(n).buildGraph();
        double[][] distMatrix = new double[n][n];

        for (Street street : city.getStreets()) {
            int u = nodeMap.get(street.getA());
            int v = nodeMap.get(street.getB());
            double w = street.getLength();
            graph.addEdge(u, v, w);
            distMatrix[u][v] = w;
            distMatrix[v][u] = w;
        }

        // mst
        WeightedSpanningTreeIterator iterator = new WeightedSpanningTreeIterator(graph);
        if (!iterator.hasNext()) return;
        Collection<Edge> mstEdges = iterator.next();

        // lista de adiacenta PE mST
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (Edge edge : mstEdges) {
            // extragem capetele strazii (in graph4j muchiile au metoda source si target)
            int u = edge.source();
            int v = edge.target();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // dfs
        List<Integer> route = new ArrayList<>();
        boolean[] visited = new boolean[n];
        dfs(0, tree, visited, route); // pornim din intersectia 0


        System.out.println("\n traseul masinii ");
        double totalCost = 0;

        for (int i = 0; i < route.size(); i++) {
            int current = route.get(i);
            int next = route.get((i + 1) % route.size());

            System.out.print(reverseMap.get(current).getName() + " ");
            totalCost += distMatrix[current][next];
        }
        System.out.println(reverseMap.get(route.get(0)).getName() + " (Inapoi la baza)");


    }


    private static void dfs(int node, List<List<Integer>> tree, boolean[] visited, List<Integer> route) {
        visited[node] = true;
        route.add(node); // adaugam intersectia curenta pe foaia de parcurs

        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, tree, visited, route);
            }
        }
    }
}