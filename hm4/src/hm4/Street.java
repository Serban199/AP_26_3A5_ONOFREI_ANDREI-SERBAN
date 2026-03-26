package hm4;

import java.util.Objects;
public class Street implements Comparable<Street> {
    private String name;
    private double length;
    private Intersection a;
    private Intersection b;

    public Street(String name,double length, Intersection a,Intersection b)
    {
      this.name=name;
      this.length = length;
      this.a = a;
      this.b = b;

    }
    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public Intersection getA() {
        return a;
    }

    public Intersection getB() {
        return b;
    }

    @Override
    public int compareTo(Street other) {
        if (other == null) return 1;
        return this.name.compareTo(other.name);//comp alf
    }

    @Override
    public String toString() {//java apeleaza o functie automata toString si noi o suprascriem
        return this.name;
    }
}