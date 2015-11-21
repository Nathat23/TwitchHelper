package com.outlook.nathat890.twitchhelper.utils;

import com.outlook.nathat890.twitchhelper.TwitchHelper;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Nathat on 19/11/2015.
 */
public class About {
    private TwitchHelper m;
    public About(TwitchHelper m){
        this.m = m;
    }
    public void showDialog(){
        JFrame frame = new JFrame("About TwitchHelper");
        frame.setResizable(false);
        JLabel name = new JLabel("TwitchHelper");
        ImageIcon img = new ImageIcon("icon.jpg");
        Font bold = new Font("Verdana", Font.BOLD, 40);
        name.setIcon(img);
        name.setFont(bold);
        JLabel ver = new JLabel("Version: " + m.getVersion());
        JLabel licence = new JLabel("Licence: MIT License");
        JTextArea licencet = new JTextArea(8,0);
        licencet.setEditable(false);
        try{
            String line = null;
            FileReader reader = new FileReader("LICENCE.txt");
            BufferedReader breader = new BufferedReader(reader);
            while((line = breader.readLine()) != null){
                licencet.setText(licencet.getText() + System.lineSeparator() + line);
            }
            breader.close();
        }catch(Exception e){
            new ErrorHandler(e.toString(), e.getStackTrace());
        }
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JScrollPane pane = new JScrollPane(licencet);
        p1.add(name);
        p1.add(ver);
        p1.add(licence);
        p2.add(pane);
        frame.add(p1);
        frame.add(p2);
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        frame.setLayout(new GridLayout(2, 1));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
