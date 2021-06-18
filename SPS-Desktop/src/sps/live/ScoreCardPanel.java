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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javafx.scene.layout.Border;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DELL
 */
public class ScoreCardPanel extends JPanel implements MouseListener{
    JLabel close,title,minimize;
    JTable scores;
    Frame fr;
    String[][] datas = {
        {"1","Rock","Paper","AI"},
        {"2","Paper","Rock","User"},
        {"3","Scissor","Paper","User"}
    };
    String[] columns = {"Round","You","AI","Result"};
    public ScoreCardPanel(String[][] data,Frame fr){
        this.fr = fr;
        setLayout(null);
        title = new JLabel("Scores");
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setBounds(50,20,100,30);
        close = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.close_icon_path)));
        close.addMouseListener((MouseListener) this);
        minimize = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.minimize_icon_path)));
        minimize.addMouseListener((MouseListener) this);
        close.setBounds(663,15,20,20);
        minimize.setBounds(640,15,20,20);
        
        scores = new JTable(data,columns);
        JScrollPane scroll = new JScrollPane(scores);
        scroll.setBounds(20,80,660,128);
        scores.setRowHeight(35);
        scores.setOpaque(false);
        ((DefaultTableCellRenderer)scores.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer)scores.getDefaultRenderer(Object.class)).setForeground(Color.WHITE);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scores.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        
        add(title);
        add(close);
        add(minimize);
        add(scroll);
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
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        Line2D line = new Line2D.Float(0, 50, 700, 50);
        graphics.setColor(Color.WHITE);
        graphics.draw(line);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == close){
            fr.dispose();
        }
        else if(e.getSource() == minimize){
            fr.setState(Frame.ICONIFIED);
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
    
}
