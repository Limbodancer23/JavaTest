package Toys;

public abstract class Toy {
    private int id;
    private String name;
    private double rarity;
    public static int count = 1;

    public Toy() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRarity(double rarity) {
        this.rarity = rarity;
    }
}
