package com.outlook.nathat890.twitchhelper.utils;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Date;

/**
 * Created by Nathat on 15/11/2015.
 */
public class ErrorHandler {

    public ErrorHandler(String error, StackTraceElement[] stack){
        JFrame message = new JFrame(error);
        message.setResizable(false);
        JLabel description = new JLabel(error);
        JLabel title = new JLabel("An error has occurred!", SwingConstants.LEFT);
        JTextArea errordetails = new JTextArea(8, 0);
        Font bold = new Font("Verdana", Font.BOLD, 20);
        title.setFont(bold);
        JPanel p = new JPanel(new GridLayout(2, 1));
        JPanel details = new JPanel();
        errordetails.setEditable(false);
        JScrollPane pane = new JScrollPane(errordetails);
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        errordetails.setText(error + ":");
        try {
            File file = new File(new Date().toString().replace(" ", "_") + ".txt");
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(file.getAbsolutePath(), "UTF-8");
            for(StackTraceElement s : stack){
                errordetails.setText(errordetails.getText() + System.lineSeparator() + s.toString());
                writer.write(errordetails.getText());
            }
            writer.close();
        }catch(Exception e){
            errordetails.setText(e.toString());
        }
        details.add(title);
        details.add(description);
        p.add(details);
        p.add(pane);
        message.getContentPane().add(p);
        message.pack();
        message.setLocationRelativeTo(null);
        message.setVisible(true);
    }
}
