
import java.util.*;

public class Randomizer {
    PrizeSaver saver;
    List<Double> list;
    Random r = new Random();
    private double rand;

    public Randomizer(PrizeSaver saver) {
        this.saver = saver;
        this.list = new ArrayList<>();
        list.add(Notebook.rarity);
        list.add(Car.rarity);
        list.add(Bear.rarity);
    }

    public void CycleOfFortune() {
        rand = Math.random();
        while (true) {
            int pos = r.nextInt(list.size());
            if (rand <= list.get(pos)) {
                if (Notebook.rarity == list.get(pos)) {
                    saver.add(new Notebook());
                    System.out.println("Jackpot!!!");
                    break;
                } else if (Car.rarity == list.get(pos)) {
                    saver.add(new Car());
                    break;
                }else if (Bear.rarity == list.get(pos)) {
                    saver.add(new Bear());
                    break;
                }else System.out.println("Not lucky..."); break;
            }
        }
    }

    @Override
    public String toString() {
        return "Randomizer{" +
                "queue=" + saver;
    }
}
