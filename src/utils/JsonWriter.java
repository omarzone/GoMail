
package utils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import org.json.JSONObject;

public class JsonWriter {
    
    public void Write(String path2, JSONObject content){
    
     
    String path = path2;

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
