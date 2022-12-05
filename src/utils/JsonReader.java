
package utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class JsonReader {

    public JsonReader(String srcutilstemptxt) {
    }
    
    public static JSONObject getJson(String file){
        JSONObject obj = new JSONObject();
        try{
            String content = Files.readString(Paths.get(file));
            obj = new JSONObject(content);
            return obj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return obj;
    }
}
