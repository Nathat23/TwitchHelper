package com.outlook.nathat890.twitchhelper.utils;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Nathat on 21/11/2015.
 */
public class ChangeLog {

    public void createDialog(){
        JFrame frame = new JFrame("TwitchHelper Changelog");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel des = new JPanel();
        Font bold = new Font("Verdana", Font.BOLD, 20);
        JLabel title = new JLabel("ChangeLog:");
        title.setFont(bold);

        JPanel text = new JPanel();
        JTextArea texta = new JTextArea(8,0);
        texta.setSize(new Dimension(250,500));
        JScrollPane pane = new JScrollPane(texta);

        try{
            String line = null;
            FileReader reader = new FileReader("changelog.txt");
            BufferedReader areader = new BufferedReader(reader);
            while((line = areader.readLine()) != null){
                texta.setText(texta.getText() + System.lineSeparator() + line);
            }
            areader.close();
        }catch(Exception e){
            new ErrorHandler(e.toString(), e.getStackTrace());
        }

        text.add(pane);
        des.add(title);
        frame.add(des);
        frame.add(text);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
