/*
 To make your twitch life easier while broadcasting
 */

package com.outlook.nathat890.twitchhelper;
import com.outlook.nathat890.twitchhelper.utils.ErrorHandler;

import javax.swing.*;

public class TwitchHelper{

    public String version = "v0.0.2-DEV";
    public GetData data = new GetData();
    public Thread myThread = new Thread(data);
    public static JLabel game = new JLabel("Game: ");
    public static JLabel mature = new JLabel("Mature: ");
    public static JLabel creation = new JLabel("Account Created: ");
    public static JLabel views = new JLabel("Total Views: ");
    public static JLabel followers = new JLabel("Followers: ");
    public static JLabel status = new JLabel("Title: ");
    public static JLabel currentviews = new JLabel("Current Viewers: ");
    public static JTextField text = new JTextField(1);
    public static JLabel timereset = new JLabel("Updated: ");
    public static JLabel fps = new JLabel("Current FPS: ");
    public static String name = "";
    public String getVersion(){
        return version;
    }


    private MainWindow createWindow(){
        return new MainWindow(this);
    }
    public static void main(String[] args){
        try {
            TwitchHelper h = new TwitchHelper();
            h.createWindow().createWindow();
        }catch(Exception e){
            new ErrorHandler(e.toString(), e.getStackTrace());
        }
    }

}
