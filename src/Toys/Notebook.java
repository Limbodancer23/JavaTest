package Toys;

import Toys.Toy;

public class Notebook extends Toy {
    private int id;
    private String name;
    public static double rarity = 0.1;

    public Notebook() {
        this.name = "Notebook";
        this.id = count++;
    }

    @Override
    public String toString() {
        return "Notebook{" +
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
