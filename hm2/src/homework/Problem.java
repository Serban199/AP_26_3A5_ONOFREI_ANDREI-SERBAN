package homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem {
    private List<Location> locations;
    private List<Road> roads;

    public Problem() {
        this.locations = new ArrayList<>();
        this.roads = new ArrayList<>();
    }

    public void addLocation(Location location) {
        if (!locations.contains(location)) {
            locations.add(location);
        } else {
            System.out.println("locatia " + location.getName() + " este deja in sistem.");
        }
    }

    public void addRoad(Road road) {
        if (!roads.contains(road)) {
            roads.add(road);
        }
    }

    public boolean isValid() {
        for (Road road : roads) {
            if (!locations.contains(road.getNodA()) || !locations.contains(road.getNodB())) {
                return false;
            }
        }
        return true;
    }

    public boolean pathExists(Location start, Location destination) {
        if (!locations.contains(start) || !locations.contains(destination)) {
            return false;
        }

        List<Location> vizitate = new ArrayList<>();
        Queue<Location> coada = new LinkedList<>();

        coada.add(start);
        vizitate.add(start);

        while (!coada.isEmpty()) {
            Location curent = coada.poll();

            if (curent.equals(destination)) {
                return true;
            }

            for (Road road : roads) {
                Location vecin = null;

                if (road.getNodA().equals(curent)) {
                    vecin = road.getNodB();
                } else if (road.getNodB().equals(curent)) {
                    vecin = road.getNodA();
                }

                if (vecin != null && !vizitate.contains(vecin)) {
                    vizitate.add(vecin);
                    coada.add(vecin);
                }
            }
        }
        return false;
    }
}