package com.outlook.nathat890.twitchhelper;

import com.outlook.nathat890.twitchhelper.utils.About;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nathat on 21/11/2015.
 */
public class MainWindow {

    private TwitchHelper m;
    public MainWindow(TwitchHelper m){
        this.m = m;
    }

    public void createWindow(){
        TwitchHelper t = new TwitchHelper();
        System.out.println("TwitchHelper " + m.getVersion() + " by @nathat890");
        JFrame main = new JFrame("TwitchHelper " + m.getVersion());
        JButton check = new JButton("View Stats");
        JButton about = new JButton("About");
        main.setResizable(false);
        main.setPreferredSize(new Dimension(700, 250));
        ImageIcon img = new ImageIcon("icon.jpg");
        main.setIconImage(img.getImage());
        TwitchHelper.text.setMaximumSize(new Dimension(300, 27));
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
        TwitchHelper.text.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panelt.add(TwitchHelper.text);
        panelt.add(check);
        panelt.add(about);

        panelt.setBackground(Color.DARK_GRAY);
        panela.setBackground(Color.GRAY);

        main.getContentPane().setLayout(new BoxLayout(main.getContentPane(), BoxLayout.Y_AXIS));
        panela.setLayout(new BoxLayout(panela, BoxLayout.Y_AXIS));

        mainp.add(panelt,BorderLayout.PAGE_START);
        mainp.add(panela,BorderLayout.CENTER);

        main.getContentPane().add(mainp);

        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                TwitchHelper t = new TwitchHelper();
                TwitchHelper.name = TwitchHelper.text.getText();
                t.myThread.start();
            }

        });
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new About(m).showDialog();
            }

        });

        TwitchHelper.timereset.setForeground(Color.WHITE);
        TwitchHelper.status.setForeground(Color.WHITE);
        TwitchHelper.currentviews.setForeground(Color.WHITE);
        TwitchHelper.fps.setForeground(Color.WHITE);
        TwitchHelper.views.setForeground(Color.WHITE);
        TwitchHelper.followers.setForeground(Color.WHITE);
        TwitchHelper.game.setForeground(Color.WHITE);
        TwitchHelper.mature.setForeground(Color.WHITE);
        TwitchHelper.creation.setForeground(Color.WHITE);

        panela.add(TwitchHelper.timereset);
        panela.add(TwitchHelper.status);
        panela.add(TwitchHelper.currentviews);
        panela.add(TwitchHelper.fps);
        panela.add(TwitchHelper.views);
        panela.add(TwitchHelper.followers);
        panela.add(TwitchHelper.game);
        panela.add(TwitchHelper.mature);
        panela.add(TwitchHelper.creation);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }
}
