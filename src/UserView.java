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
                    Scanner scan = new Scanner(System.in);
                    try {
                        double value;
                        if (choice == 1) {
                            System.out.printf("Enter new value:\nCurrent value: %.1f\n", Car.rarity);
                            value = scan.nextDouble();
                            Car.rarity = value;
                        } else if (choice == 2) {
                            System.out.printf("Enter new value:\nCurrent value: %.1f\n", Bear.rarity);
                            value = scan.nextDouble();
                            Bear.rarity = value;
                        } else if (choice == 3) {
                            value = scan.nextDouble();
                            System.out.printf("Enter new value:\nCurrent value: %.1f\n", Notebook.rarity);
                            Notebook.rarity = value;
                        } else System.out.println("Wrong number!");
                    }catch (InputMismatchException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        }
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
