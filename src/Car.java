public class Car extends Toy {
    private int id;
    private String name;
    static double rarity = 0.3;

    public Car() {
        this.id = count++;
        this.name = "Car";
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", rarity=" + rarity + ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRarity() {
        return rarity;
    }
}
