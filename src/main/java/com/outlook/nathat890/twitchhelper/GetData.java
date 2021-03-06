package com.outlook.nathat890.twitchhelper;


import com.outlook.nathat890.twitchhelper.utils.ErrorHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

public class GetData implements Runnable{

    boolean running = true;

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public void run() {
        JSONObject streamObject = null;
        while ( running ) {
            try{
                JSONParser parser = new JSONParser();
                String json = readUrl("https://api.twitch.tv/kraken/channels/" + TwitchHelper.name + ".json");
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
                TwitchHelper.game.setText("Game: " + jsonObject.get("game"));
                TwitchHelper.mature.setText("Mature: " + jsonObject.get("mature"));
                TwitchHelper.creation.setText("Account Created: " + jsonObject.get("created_at").toString().replace("T", " ").replace("Z", " "));
                TwitchHelper.views.setText("Total Views: " + jsonObject.get("views"));
                TwitchHelper.followers.setText("Followers: " + jsonObject.get("followers"));
                TwitchHelper.timereset.setText("Updated: " + new Date().toString());
                TwitchHelper.status.setText("Title: " + jsonObject.get("status"));
                String json2 = readUrl("https://api.twitch.tv/kraken/streams/" + TwitchHelper.name + ".json");
                JSONObject jsonObject2 = (JSONObject) jsonParser.parse(json2);
                streamObject = (JSONObject) jsonObject2.get("stream");
                String json3 = readUrl("http://tmi.twitch.tv/servers?channel=" + TwitchHelper.name);
                JSONObject jsonObject3 = (JSONObject) jsonParser.parse(json3);
                TwitchHelper.cluster.setText("Cluster: " + jsonObject3.get("cluster"));
            }catch(Exception e){
                new ErrorHandler(e.toString(), e.getStackTrace());
                running = false;
            }

            try{
                TwitchHelper.currentviews.setText("Current Viewers: " + streamObject.get("viewers"));
            }catch(NullPointerException e){
                TwitchHelper.currentviews.setText("Current Viewers: 0");
            }
            try{
                double currentFPS = Math.round((Double)streamObject.get("average_fps"));
                TwitchHelper.fps.setText("Current FPS: " + currentFPS);
            }catch(NullPointerException e){
                TwitchHelper.fps.setText("Current FPS: 0");
            }

            try{
                Thread.sleep(7000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
