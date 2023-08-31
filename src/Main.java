import Controller.Randomizer;
import Model.FileManager;
import Model.PrizeSaver;
import Model.ToysDB;
import UserView.UserView;

public class Main {
    public static void main(String[] args) {
        ToysDB.CreateFile();
        PrizeSaver saver = new PrizeSaver();
        Randomizer randomizer =new Randomizer(saver);
        FileManager manager = new FileManager(ToysDB.PATH, saver);
        UserView view = new UserView(manager, saver, randomizer);
        view.Start();
    }
}