import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Copyright (c) Anton on 28.08.2018.
 */
public class ConnectionManager {

    JSONArray getConnectionToHands(String request) throws JSONException, IOException {
        String path = "http://localhost:8001/Query?q=" + URLEncoder.encode(request, "UTF-8");
        URLConnection connection = new URL(path).openConnection();
        StringBuilder stringBuilder = createStringBuilder(connection);
        JSONObject jsObject = new JSONObject(stringBuilder.toString());
        System.out.println(jsObject.getJSONArray("Results").get(80));
        return jsObject.getJSONArray("Results");
    }

    JSONArray getConnectionToHandhistory(String handNumber) throws JSONException, IOException {
        String path = "http://localhost:8001/Query?q=" + URLEncoder.encode("select * from handhistories where GameNumber=1304443223" , "UTF-8");
        URLConnection connection = new URL(path).openConnection();
        StringBuilder stringBuilder = createStringBuilder(connection);
        JSONObject jsObject = new JSONObject(stringBuilder.toString());
        System.out.println(jsObject);
        return jsObject.getJSONArray("HandHistory");
    }

    private StringBuilder createStringBuilder(URLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuilder stringBuilder2 = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            stringBuilder2.append(inputLine);
        }
        in.close();
        return stringBuilder2;
    }


    public static void main(String[] args) throws IOException {
        ConnectionManager connectionManager = new ConnectionManager();
        String s = "2018-08-25";
        JSONArray jsonArray  = connectionManager.getConnectionToHands("select * from hands where HandTimestamp >= {d \"2018-09-01\"}");
        ArrayList<Hand> hands = new ArrayList<>();
        for (int i = 0; i < jsonArray.length() ; i++) {
            Hand hand = new Hand((JSONObject) jsonArray.get(i));
            hands.add(hand);
        }
        ByPositionReport byPositionReport = new ByPositionReport(hands);
        byPositionReport.createReport();
//        connectionManager.getConnectionToHandhistory("1271441035");



    }

    }

