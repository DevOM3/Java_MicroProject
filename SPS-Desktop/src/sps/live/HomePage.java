/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sps.live;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class HomePage extends JPanel implements KeyListener, MouseListener{
    Font titleFont, subtitleFont, keyFont;
    JLabel title, subTitle, keypress, close, minimize, help;
    JButton stone, paper, scissor;
    Boolean isHomeVisible = true, isGameVisible = false;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    Frame frame;
    
    public HomePage(Frame frame){
        this.frame = frame;
        titleFont = new Font("Times New Roman", Font.BOLD, 35);
        subtitleFont = new Font("Times New Roman", Font.BOLD, 30);
        keyFont = new Font("Times New Roman", Font.PLAIN, 30);
        setLayout(null);
        close = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.close_icon_path)));
        close.addMouseListener((MouseListener) this);
        close.setBounds(20, 15, 20, 20);
        minimize = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.minimize_icon_path)));
        minimize.addMouseListener((MouseListener) this);
        minimize.setBounds(43, 15, 20, 20);
        help = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.help_icon_path)));
        help.addMouseListener((MouseListener) this);
        help.setBounds(500, 300, 20, 20);

        title = new JLabel("SPS.Live"); 
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        title.setSize(200, 50);
        title.setLocation(175, 50);
        subTitle = new JLabel("Stone Paper Scissor");
        subTitle.setFont(subtitleFont);
        subTitle.setForeground(Color.WHITE);
        subTitle.setSize(300, 30);
        subTitle.setLocation(125, 130);
        keypress = new JLabel("Press any key to start");
        keypress.setFont(keyFont);
        keypress.setForeground(Color.WHITE);
        keypress.setBounds(125, 200, 300, 30);
        this.addKeyListener(this);
        setFocusable(true);
        add(title);
        add(subTitle);
        add(keypress);
        add(close);
        add(minimize);
        add(help);
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == close) {
            try {
                s = new Socket("localhost", 6666);
                dos = new DataOutputStream(s.getOutputStream());
                dis = new DataInputStream(s.getInputStream());
                dos.writeUTF("Close");
                dos.flush();
                s.close();
                System.exit(0);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == minimize) {
            frame.setState(JFrame.ICONIFIED);
        } else if (e.getSource() == help) {
            try {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome http://localhost:8080/SPS.live/"});
            } catch (IOException ex) {
                Logger.getLogger(SPSLive.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
            setVisible(false);
        if (isHomeVisible == true && isGameVisible == false) {
            isHomeVisible = false;
            isGameVisible = true;
            frame.add(new GamePage(frame));
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
            setVisible(false);
        if (isHomeVisible == true && isGameVisible == false) {
            isHomeVisible = false;
            isGameVisible = true;
            frame.add(new GamePage(frame));
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(189,195,199);
        Color color2 = new Color(44,62,80);
        GradientPaint gp = new GradientPaint(0, 0, color1,0,h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == close) {
            close.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.hover_close_icon_path)));
        } else if (e.getSource() == minimize) {
            minimize.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.hover_minimize_icon_path)));
        } else if (e.getSource() == help) {
            help.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.hover_help_icon_path)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == close) {
            close.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.close_icon_path)));
        } else if (e.getSource() == minimize) {
            minimize.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.minimize_icon_path)));
        } else if (e.getSource() == help) {
            help.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.help_icon_path)));
        }
    }

}
