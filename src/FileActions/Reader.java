package FileActions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {

    private String filePath;

    public Reader(String path, String name){
        this.filePath = path + File.separator +name;
    }

    public String readFile() {
        try{
            return Files.readString(Paths.get(this.filePath));
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
