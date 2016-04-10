package sample;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by Женя on 16.03.2016.
 */
public class VKapi {
    private String access_token;

    public String getHTML(String urlToRead) {
        URL url;
        HttpsURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String postHTML(String urlToRead, String urlParameters) {
        URL url;
        HttpsURLConnection conn;
        String result = "";
        try {
            byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int postDataLength = postData.length;
            url = new URL(urlToRead);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setDoOutput( true );
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );
            try( DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.write(postData);
            }
            result = conn.getResponseMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void authorize(String email, String password){
        String response = getHTML("https://oauth.vk.com/token?" +
                "grant_type=password" +
                "&client_id=2274003" +
                "&client_secret=hHbZxrka2uZ6jB1inYsH" +
                "&username="+ email +
                "&password="+ password +
                "&scope=friends,offline,photos,status,messages");
        access_token = new JSONObject(response).getString("access_token");
    }

    public JSONArray getCountries(int need_all){
        String response = getHTML("https://api.vk.com/method/database.getCountries?" +
                "need_all=" + need_all +
                "&v=5.50" +
                "&count=300" +
                "&lang=ru");
        return new JSONObject(response).getJSONObject("response").getJSONArray("items");
    }

    public JSONArray getCities(int country_id, String q, int need_all){
        String response = getHTML("https://api.vk.com/method/database.getCities?" +
                "country_id=" + country_id +
                "&q=" + q +
                "&need_all=" + need_all +
                "&count=100" +
                "&v=5.50" +
                "&lang=ru");
        return new JSONObject(response).getJSONObject("response").getJSONArray("items");
    }

    public JSONArray getUniversities(int country_id, int city_id){
        String response = getHTML("https://api.vk.com/method/database.getUniversities?" +
                "v=5.50" +
                "&count=1000" +
                "&country_id=" + country_id +
                "&city_id=" + city_id +
                "&lang=ru");
        return new JSONObject(response).getJSONObject("response").getJSONArray("items");
    }

    public JSONArray getSchools(int city_id){
        String response = getHTML("https://api.vk.com/method/database.getSchools?" +
                "v=5.50" +
                "&count=1000" +
                "&city_id=" + city_id +
                "&lang=ru");
        return new JSONObject(response).getJSONObject("response").getJSONArray("items");
    }

    public JSONArray getUser(){
        String response = getHTML("https://api.vk.com/method/users.get?" +
                "v=5.50" +
                "&lang=ru"+
                "&access_token=" + access_token);
        return new JSONObject(response).getJSONArray("response");
    }

    public JSONArray search(String q, int country, int city, int university, int university_year, int sex, int status,
                            int age_from, int age_to, int schole){
        String query = "https://api.vk.com/method/users.search?" +
                "v=5.50" +
                "&count=1000" +
                "&q=" + q +
                "&sort=0" +
                "&sex=" + sex +
                "&fields=photo_50"+
                "&lang=ru";
        query = country != 0 ? query += "&country=" + country : query;
        query = city != 0 ? query += "&city=" + city : query;
        query = university != 0 ? query += "&university=" + university : query;
        query = university_year != 0 ? query += "&university_year=" + university_year : query;
        query = status != 0 ? query += "&status=" + status : query;
        query = age_from != 0 ? query += "&age_from=" + age_from : query;
        query = age_to != 0 ? query += "&age_to=" + age_to : query;
        query = schole != 0 ? query += "&schole=" + schole : query;
        query += "&access_token=" + access_token;
        String response = getHTML(query);
        return new JSONObject(response).getJSONObject("response").getJSONArray("items");
    }

    public void sendMessages(int user_id, String message) {
        String response = postHTML("https://api.vk.com/method/messages.send",
                "v=5.50" +
                "&message=" + message.replace(" ","%20") +
                "&user_id=" + user_id +
                "&notification=0"+
                "&lang=ru" +
                "&access_token=" + access_token);
        System.out.println(response);
    }


}

