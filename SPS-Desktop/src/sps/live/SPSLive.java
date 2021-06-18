package sps.live;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SPSLive extends Frame implements Runnable {

    String data;
    
    JPanel home, game;
    

    SPSLive() {

        setSize(550, 350);
        setUndecorated(true);
        
        add(new HomePage(this));
        setVisible(true);
        this.setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

//                setDefaultLookAndFeelDecorated(true);
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
    }
    
    

    public static void main(String ar[]) throws IOException {
        Thread thr = new Thread(new SPSLive());
        thr.start();
//                    new SPSLive();

    }
    
    @Override
    public void run() {
        try {
            new ServerLive();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
