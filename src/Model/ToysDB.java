package Model;

import java.io.File;

public class ToysDB {
    public static final String PATH = "ToysDB.txt";
    public static void CreateFile(){
        try {
            File db = new File(PATH);
            if (db.createNewFile()){
                System.out.println("File created!");
            }
            else {
                System.out.println("File already exist!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
