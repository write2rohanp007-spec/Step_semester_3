package encapsulation.assigment_problems;

public class TrafficLight {
      private final String id;
      private String color;
      private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};
      private int index;

    public TrafficLight(String id) {
              this.id = id;
              this.index = 0;
              this.color = CYCLE[0];
    }

    public String next() {
              index = (index + 1) % CYCLE.length;
              color = CYCLE[index];
              return color;
    }

    public String getColor() {
              return color;
    }

    public String getId() {
              return id;
    }

    public static void main(String[] args) {
              TrafficLight t = new TrafficLight("TL-9");
              System.out.println("Initial: " + t.getColor());
              System.out.println("next(): " + t.next());
              System.out.println("next(): " + t.next());
              System.out.println("next(): " + t.next());
    }
}
