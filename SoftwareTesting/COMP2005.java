// Java program to read JSON from a file

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class COMP2005 {
    private static String inline;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        JSONParser parser = new JSONParser();
        URL url = new URL("http://intelligent-social-robots-ws.com/senators.json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if (responsecode != 200)
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()) {
                inline += sc.nextLine();
            }
            System.out.println("\nJSON data in string format");
            System.out.println(inline);
            sc.close();
        }
        try {
            Object obj = parser.parse(new FileReader("\\json.js"));
            JSONObject jsonObject = (JSONObject) obj;
            String fname = (String) jsonObject.get("firstname");
            System.out.println("Name is " + fname);
            String lname = (String) jsonObject.get("lastname");
            System.out.println("Name is " + lname);

            JSONArray array = (JSONArray) jsonObject.get("leadership_title");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}