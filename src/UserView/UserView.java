package UserView;
import Controller.Randomizer;
import Model.FileManager;
import Model.PrizeSaver;
import Toys.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView {
    FileManager fileManager;
    PrizeSaver saver;
    Randomizer randomizer;

    public UserView(FileManager fileManager, PrizeSaver saver, Randomizer randomizer) {
        this.fileManager = fileManager;
        this.saver = saver;
        this.randomizer = randomizer;
    }



    public void Start() {
        System.out.println("Welcome to toy shop!\n---------------------------------------------");
        while (true) {
            int choice = promt("Select option...\n1)Let`s try my luck!!\n2)Show awaiting toys\n" +
                    "3)Choose a toy by my side\n4)Take a toy\n5)Change rarity of toys\n6)Exit\n---------------------------------------------");
            switch (choice) {
                case 1:
                    randomizer.CycleOfFortune();
                    break;
                case 2:
                    if (saver.isEmpty()) {
                        System.out.println("The list of toys is empty...\n---------------------------------------------");
                    } else {
                        for (Toy el : saver) {
                            System.out.println(el.getName());
                        }
                        System.out.println("---------------------------------------------");
                    }
                    break;
                case 3:
                    choice = promt("Choose type of the toy:\n1)Car\n2)Bear\n---------------------------------------------");
                    if (choice == 1) {
                        saver.add(new Car());
                        System.out.println("Toy added to awaiting list...\n");
                    } else if (choice == 2) {
                        saver.add(new Bear());
                        System.out.println("Toy added to awaiting list...\n");
                    } else System.out.println("Wrong number!\n");
                    break;
                case 4:
                    if (saver.isEmpty()) {
                        System.out.println("The list of toys is empty...\n");
                    } else {
                        fileManager.saveToFile();
                        System.out.println("Toy added to your pocket!\n");
                    }
                    break;
                case 5:
                    choice = promt("Select toy:\n1)Car\n2)Bear\n3)Notebook");
                        if (choice == 1) {
                           Car.rarity =  setValue(Car.rarity);
                        } else if (choice == 2) {
                            Bear.rarity = setValue(Bear.rarity);
                        } else if (choice == 3) {
                           Notebook.rarity = setValue(Notebook.rarity);
                        }
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    private double setValue(Double rarity){
        try {
            double value;
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.printf("Enter new value:\nCurrent value: %.1f\n", rarity);
                value = scan.nextDouble();
                if (value > 0 && value < 1.0) {
                    randomizer.prepareCycle();
                    return value;
                } else System.out.println("Value must be positive and less than 1.0!");
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return 0.0;
    }

    private int promt(String massage) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println(massage);
            int input = scan.nextInt();
            return input;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
