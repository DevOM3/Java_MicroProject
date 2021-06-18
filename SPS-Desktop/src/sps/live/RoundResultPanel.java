/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sps.live;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class RoundResultPanel extends JPanel implements MouseListener{
    JLabel message,user_label,user,ai_label,ai;
    String usr_image,ai_image;
    
    public RoundResultPanel(String result_msg,String user_img,String ai_img){
        setLayout(null);
        Font f = new Font("Times New Roman", Font.BOLD, 15);
        usr_image = user_img;
        ai_image = ai_img;
        message  = new JLabel(result_msg); 
        message.setForeground(Color.WHITE);
        message.setFont(f);
        message.setBounds(80,180,130,20);
        user_label = new JLabel("You");
        user_label.setForeground(Color.WHITE);
        user_label.setFont(f);
        user_label.setBounds(70,20,80,20);
        user = new JLabel(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(user_img+".jpeg")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        user.setBounds(30,50,120,120);
        user.addMouseListener((MouseListener) this);
        ai_label = new JLabel("AI");
        ai_label.setFont(f);
        ai_label.setForeground(Color.WHITE);
        ai_label.setBounds(210,20,80,20);
        ai = new JLabel(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(ai_img+".jpeg")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        ai.setBounds(180,50,120,120);
        ai.addMouseListener((MouseListener) this);
        add(message);
        add(user_label);
        add(user);
        add(ai_label);
        add(ai);
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
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if(e.getSource() == user){
            user.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Hand"+usr_image+".jpeg")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == ai){
            ai.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Hand"+ai_image+".jpeg")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == user){
            user.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(usr_image+".jpeg")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == ai){
            ai.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(ai_image+".jpeg")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
    }
}
