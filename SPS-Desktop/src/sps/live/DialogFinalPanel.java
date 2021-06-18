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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class DialogFinalPanel extends JPanel implements Runnable,ActionListener, MouseListener{
    JLabel result_message,result_user,result_ai,minimize;
    JButton play_again,quit;
    Frame frame;
    Frame current;
    JLabel close,title;
    ScoreCard score = null;
    
    public DialogFinalPanel(Frame owner,String Title,String result_msg,int user,int ai,String[][] data, Frame current){
        
        setLayout(null);
        frame = owner;
        this.current = current;
        result_message  = new JLabel(result_msg); 
        result_message.setFont(new Font("Times New Roman", Font.BOLD, 18));
        result_message.setForeground(Color.WHITE);
        result_message.setBounds(50,70,100,20);
        result_user = new JLabel("You : "+user);
        result_user.setForeground(Color.WHITE);
        result_user.setFont(new Font("Times New Roman", Font.BOLD, 15));
        result_user.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(score == null || score.isDisplayable() == false){
                            score = new ScoreCard(data);
                        }
                        else if(score.isDisplayable() == true){
                            score.setState(Frame.NORMAL);
                        }
                    }
        });
        result_user.setBounds(50,100,100,20);
        result_ai = new JLabel("AI  : "+ai);
        result_ai.setForeground(Color.WHITE);
        result_ai.setFont(new Font("Times New Roman", Font.BOLD, 15));
        result_ai.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(score == null || score.isDisplayable() == false){
                            score = new ScoreCard(data);
                        }
                        else if(score.isDisplayable() == true){
                            score.setState(Frame.NORMAL);
                        }
                    }
        });
        result_ai.setBounds(50,130,100,20);
        play_again = new JButton("Play Again");
        play_again.setOpaque(false);
        play_again.setContentAreaFilled(false);
        play_again.setForeground(Color.WHITE);
        play_again.addActionListener((ActionListener) this);
        play_again.setBounds(50,180,100,30);
        quit = new JButton("Quit");
        quit.setOpaque(false);
        quit.setContentAreaFilled(false);
        quit.setForeground(Color.WHITE);
        quit.addActionListener((ActionListener) this);
        quit.setBounds(180,180,100,30);
        
        
        title = new JLabel(Title);
        Font titleFont = new Font("Times New Roman", Font.BOLD, 20);
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        title.setBounds(50,10,100,30);
        close = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.close_icon_path)));
        close.addMouseListener((MouseListener) this);
        close.setBounds(363,15,20,20);
        minimize = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.minimize_icon_path)));
        minimize.addMouseListener((MouseListener) this);
        minimize.setBounds(340,15,20,20);
        add(result_message);
        add(result_user);
        add(result_ai);
        add(play_again);
        add(quit);
        add(title);
        add(close);
        add(minimize);
        setVisible(true);
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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play_again){
            current.dispose();
            frame.dispose();
            Thread th = new Thread(new SPSLive());
            th.start();
        }
        else if(e.getSource() == quit){
            System.exit(0);
        }
    }
     @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        Line2D line = new Line2D.Float(0, 45, 400, 45);
        graphics.setColor(Color.WHITE);
        graphics.draw(line);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == close){
            current.dispose();
        }
        else if(e.getSource() == minimize){
            current.setState(Frame.ICONIFIED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == close){
            close.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.hover_close_icon_path)));
        }
        else if(e.getSource() == minimize){
            minimize.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.hover_minimize_icon_path)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == close){
            close.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.close_icon_path)));
        }
        else if(e.getSource() == minimize){
            minimize.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.minimize_icon_path)));
        }
    }
    
    @Override
    public void run() {
        try{
            new ServerLive();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
