package homework;

import java.util.Objects;

public abstract class Location {
    protected String name;
    protected double x;
    protected double y;

    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return Objects.equals(name, location.name);
    }

}

class City extends Location {
    private int population;

    public City(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }
}

class Airport extends Location {
    private int terminals;

    public Airport(String name, double x, double y, int terminals) {
        super(name, x, y);
        this.terminals = terminals;
    }

    public int getTerminals() { return terminals; }
    public void setTerminals(int terminals) { this.terminals = terminals; }
}

class GasStation extends Location {
    private double gasPrice;

    public GasStation(String name, double x, double y, double gasPrice) {
        super(name, x, y);
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() { return gasPrice; }
    public void setGasPrice(double gasPrice) { this.gasPrice = gasPrice; }
}