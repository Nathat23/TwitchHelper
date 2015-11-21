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
        m.text.setMaximumSize(new Dimension(300, 27));
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
        m.text.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panelt.add(m.text);
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
                m.name = m.text.getText();
                t.myThread.start();
            }

        });
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new About(m).showDialog();
            }

        });

        m.timereset.setForeground(Color.WHITE);
        m.status.setForeground(Color.WHITE);
        m.currentviews.setForeground(Color.WHITE);
        m.fps.setForeground(Color.WHITE);
        m.views.setForeground(Color.WHITE);
        m.followers.setForeground(Color.WHITE);
        m.game.setForeground(Color.WHITE);
        m.mature.setForeground(Color.WHITE);
        m.creation.setForeground(Color.WHITE);

        panela.add(m.timereset);
        panela.add(m.status);
        panela.add(m.currentviews);
        panela.add(m.fps);
        panela.add(m.views);
        panela.add(m.followers);
        panela.add(m.game);
        panela.add(m.mature);
        panela.add(m.creation);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }
}
