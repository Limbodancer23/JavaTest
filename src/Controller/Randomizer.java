package Controller;
import Model.PrizeSaver;
import Toys.Bear;
import Toys.Car;
import Toys.Notebook;
import java.util.*;

public class Randomizer {
    PrizeSaver saver;
    private final List<Character> list;
    Random r = new Random();

    public Randomizer(PrizeSaver saver) {
        this.saver = saver;
        this.list = new ArrayList<>();
        prepareCycle();
    }

    public void CycleOfFortune() {
        int pos = r.nextInt(list.size());
        System.out.println(pos);
        if (list.get(pos).equals('n')) {
            System.out.println("Jackpot!!!");
            saver.add(new Notebook());
        } else if (list.get(pos).equals('b')) {
            saver.add(new Bear());
        } else if (list.get(pos).equals('c')) {
            saver.add(new Car());
        } else System.out.println("Not lucky...");
    }

    public void prepareCycle(){
        list.clear();
        for (int i = 0; i < Notebook.rarity * 100; i++) {
            list.add('n');
        }
        for (int i = 0; i < Car.rarity * 100; i++) {
            list.add('c');
        }
        for (int i = 0; i < Bear.rarity * 100; i++) {
            list.add('b');
        }
    }

    @Override
    public String toString() {
        return "Controller.Randomizer{" +
                "queue=" + saver;
    }
}
