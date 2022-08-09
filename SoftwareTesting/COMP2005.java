// Java program to read JSON from a file

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class COMP2005 {
    private static String inline;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        try {
            URL url = new URL("http://intelligent-social-robots-ws.com/senators.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() == 200) {
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    String temp = scan.nextLine();
                    Object obj = new JSONParser().parse((temp));

                    // typecasting obj to JSONObject
                    JSONObject jo = (JSONObject) obj;

                    // getting firstName and lastName
                    String firstName = (String) jo.get("firstName");
                    String lastName = (String) jo.get("lastName");

                    System.out.println(firstName);
                    System.out.println(lastName);
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Error.");
        }
    }
}