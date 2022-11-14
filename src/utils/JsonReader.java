/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

/**
 *
 * @author PC GOOSE
 */
public class JsonReader {
    
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
