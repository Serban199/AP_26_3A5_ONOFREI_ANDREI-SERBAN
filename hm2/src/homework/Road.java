package homework;

import java.util.Objects;

enum Roads{
    highway, express, country
}

public class Road {
    Roads type;
    double length;
    int speedLimit;
    Location nodA;
    Location nodB;

    public Road(Roads type, double length, int speedLimit, Location nodA, Location nodB) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.length = length;
        this.nodA = nodA;
        this.nodB = nodB;
    }

    private double EuclideanDist() {
        if (nodA == null || nodB == null) return 0;
        return Math.sqrt(Math.pow(nodA.getX() - nodB.getX(), 2) + Math.pow(nodA.getY() - nodB.getY(), 2));
    }

    public double getLength() { return length; }

    public void setLength(double length) {
        double minLength = EuclideanDist();
        if (length < minLength) {
            System.out.println("lungime prea mica " + minLength);
            this.length = minLength;
        } else {
            this.length = length;
        }
    }

    public Roads getType() { return type; }
    public void setType(Roads type) { this.type = type; }

    public int getSpeedLimit() { return speedLimit; }
    public void setSpeedLimit(int speedLimit) { this.speedLimit = speedLimit; }

    public Location getNodA() { return nodA; }
    public void setNodA(Location nodA) { this.nodA = nodA; }

    public Location getNodB() { return nodB; }
    public void setNodB(Location nodB) { this.nodB = nodB; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Road road = (Road) obj;

        boolean aceeasiDirectie = Objects.equals(nodA, road.nodA) && Objects.equals(nodB, road.nodB);
        boolean directieOpusa = Objects.equals(nodA, road.nodB) && Objects.equals(nodB, road.nodA);

        return Double.compare(road.length, length) == 0 &&
                speedLimit == road.speedLimit &&
                type == road.type && (aceeasiDirectie || directieOpusa);
    }


    @Override
    public String toString() {
        return "Road{" + "type=" + type + ", length=" + length + ", speedLimit=" + speedLimit +
                " nodeA=" + nodA.getName() + ", nodeB=" + nodB.getName()  + '}';
    }
}