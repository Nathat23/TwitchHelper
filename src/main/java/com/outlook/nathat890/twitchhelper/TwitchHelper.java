/*
 To make your twitch life easier while broadcasting
 */

package com.outlook.nathat890.twitchhelper;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class TwitchHelper{

    public static String version = "v0.0.2-DEV";
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
    public static JButton check = new JButton("View Stats");
    public static JLabel timereset = new JLabel("Updated: ");
    public static JLabel fps = new JLabel("Current FPS: ");
    public static String name = "";
    public static  String getVersion(){
        return version;
    }


    public static void main(String[] args){
        try {
            TwitchHelper t = new TwitchHelper();
            System.out.println("TwitchHelper " + getVersion() + " by @nathat890");
            JFrame main = new JFrame("TwitchHelper " + getVersion());
            main.setResizable(false);
            main.setPreferredSize(new Dimension(700, 250));
            ImageIcon img = new ImageIcon("icon.jpg");
            main.setIconImage(img.getImage());
            text.setMaximumSize(new Dimension(300, 27));
            main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JPanel panelt = new JPanel();
            JPanel panela = new JPanel();
            JPanel mainp = new JPanel(new BorderLayout());
            panelt.setLayout(new BoxLayout(panelt, BoxLayout.X_AXIS));
            JLabel title = new JLabel("TwitchHelper");
            Font bold = new Font("Verdana", Font.BOLD, 30);
            panelt.setSize(new Dimension(350, 100));
            title.setFont(bold);
            title.setForeground(Color.WHITE);
            panelt.add(title);
            title.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            panelt.add(text);
            text.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            panelt.add(check);
            panelt.setBackground(Color.DARK_GRAY);
            panela.setBackground(Color.GRAY);
            main.getContentPane().setLayout(new BoxLayout(main.getContentPane(), BoxLayout.Y_AXIS));
            mainp.add(panelt,BorderLayout.PAGE_START);
            mainp.add(panela,BorderLayout.CENTER);
            panela.setLayout(new BoxLayout(panela, BoxLayout.Y_AXIS));
            main.getContentPane().add(mainp);
            timereset.setForeground(Color.WHITE);
            panela.add(timereset);
            check.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    TwitchHelper t = new TwitchHelper();
                    name = text.getText();
                    t.myThread.start();
                }

            });
            status.setForeground(Color.WHITE);
            currentviews.setForeground(Color.WHITE);
            fps.setForeground(Color.WHITE);
            views.setForeground(Color.WHITE);
            followers.setForeground(Color.WHITE);
            game.setForeground(Color.WHITE);
            mature.setForeground(Color.WHITE);
            creation.setForeground(Color.WHITE);
            panela.add(status);
            panela.add(currentviews);
            panela.add(fps);
            panela.add(views);
            panela.add(followers);
            panela.add(game);
            panela.add(mature);
            panela.add(creation);
            main.pack();
            main.setLocationRelativeTo(null);
            main.setVisible(true);
        }catch(Exception e){
            new ErrorHandler(e.toString(), e.getStackTrace());
        }
    }

}
