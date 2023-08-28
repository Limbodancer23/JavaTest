
public class Notebook extends Toy {
    private int id;
    private String name;
    static double rarity = 0.3;

    public Notebook() {
        this.name = "Notebook";
        this.id = count++;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", rarity=" + rarity +", id=" + id +
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
