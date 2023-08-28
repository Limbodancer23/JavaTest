import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    PrizeSaver saver;
    private final String filename;

    public FileManager(String filename, PrizeSaver saver) {
        this.saver = saver;
        this.filename = filename;
        try(FileWriter writer = new FileWriter(filename)) {
            writer.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveToFile(){
        try (FileWriter writer = new FileWriter(filename, true)){
            writer.write(this.saver.removeFirst().toString());
            writer.append('\n');
//            writer.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
