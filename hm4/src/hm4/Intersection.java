package hm4;

import java.util.Objects;
public class Intersection implements Comparable<Intersection> {
      private String  name;
      public Intersection(String name)
      {
          this.name=name;
      }
      public String getName()
      {
          return name;
      }


    @Override
    public int compareTo(Intersection other) {
        if (other == null) return 1;
        return this.name.compareTo(other.name);//comp alf
    }
    @Override

    public String toString() {//java apeleaza o functie automata toString si noi o suprascriem

        return this.name;

    }

}
