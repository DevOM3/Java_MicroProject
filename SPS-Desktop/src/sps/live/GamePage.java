
package sps.live;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GamePage extends JPanel implements ActionListener,MouseListener,Runnable{
    JButton stone,paper,scissor;
    Socket s;
    DataOutputStream dos;
    DataInputStream dis;
    String user,ai;
    JLabel result_you,result_ai,close,play,stoneLabel,scissorLabel,paperLabel,minimize,help,repeat;
    int user_count=0,ai_count=0;
    Frame frame ;
    ImageIcon stoneImage,paperImage, scissorImage ;
    DialogFinal dialog;
    ScoreCard score = null;
    String[][] data = {
        {"","","",""},
        {"","","",""},
        {"","","",""}
    };
    Font result;
    Timer time;
    int round = 1;
    public GamePage(Frame fr) {
                try{
                    s = new Socket("localhost",6666);
                    dos = new DataOutputStream(s.getOutputStream());
                    dis = new DataInputStream(s.getInputStream());
                    }
                    catch(IOException e){
                            System.out.println(e);
                    }
                frame = fr;
                setLayout(null);
                setVisible(true);
                result = new Font("Times New Roman", Font.BOLD, 15);
                stoneImage = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.Stone)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
                paperImage = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.Paper)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
                scissorImage = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.Scissor)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
                
                stoneLabel = new JLabel(stoneImage);
                paperLabel = new JLabel(paperImage);
                scissorLabel = new JLabel(scissorImage);
                
                
                
                stoneLabel.setBounds(55,120,120,120);
                paperLabel.setBounds(215,120,120,120);
                scissorLabel.setBounds(365,120,120,120);
                close = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.close_icon_path)));
                close.addMouseListener(this);
                close.setBounds(20,15,20,20);
                minimize = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.minimize_icon_path)));
                minimize.addMouseListener(this);
                minimize.setBounds(43,15,20,20);
                help = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.help_icon_path)));
		help.addMouseListener(this);
                help.setBounds(500,300,20,20);
                repeat = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(Constants.repeat_icon_path)));
		repeat.addMouseListener(this);
                repeat.setBounds(67,16,18,18);
                repeat.setVisible(false);
                play = new JLabel("Let's Play");
                play.setForeground(Color.WHITE);
                play.setFont(new Font("Times New Roman", Font.BOLD, 35));
                play.setBounds(50,50,200,40);
                stone = new JButton("Stone");
                stone.addMouseListener(this);
                paper = new JButton("Paper");
                paper.addMouseListener(this);
                scissor = new JButton("Scissor");
                scissor.addMouseListener(this);
                stone.setBounds(55,260,120,30);
                stone.addActionListener(this);
                paper.setBounds(215,260,120,30);
                paper.addActionListener(this);
                scissor.setBounds(365,260,120,30);
                scissor.addActionListener(this);
                
                stone.setOpaque(false);
                paper.setOpaque(false);
                scissor.setOpaque(false);
//                stone.setFocusPainted(false);
                stone.setContentAreaFilled(false);
                paper.setContentAreaFilled(false);
                scissor.setContentAreaFilled(false);
//                stone.setBorderPainted(false);
                
                stone.setForeground(Color.WHITE);
                paper.setForeground(Color.WHITE);
                scissor.setForeground(Color.WHITE);
                
                result_you = new JLabel("You  : "+user_count);
                result_you.setFont(result);
                result_you.setForeground(Color.WHITE);
                result_you.addMouseListener(new MouseAdapter(){
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
                result_you.setBounds(400,50,100,20);
                result_ai = new JLabel("AI    : "+ai_count);
                result_ai.setFont(result);
                result_ai.setForeground(Color.WHITE);
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
                result_ai.setBounds(400,75,100,20);
                setBackground(Color.WHITE);
                add(stone);
                add(paper);
                add(scissor);
                add(result_you);
                add(result_ai);
                add(close);
                add(minimize);
                add(help);
                add(repeat);
                add(play);
                add(stoneLabel);
                add(paperLabel);
                add(scissorLabel);
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
        if(e.getSource() == stone){
            try{
                user = "Stone";
		dos.writeUTF("Stone");
                dos.flush();
		ai = (String)dis.readUTF();
                String result = check();
		String[] res = {""+round+"",user,ai,result};
                if(result != null){
                    data[round-1] = res;
                    round += 1;
                }
                
          }
          catch(IOException exception){
		System.out.println(exception);
          }   
        }
        else if(e.getSource() == paper){
            try{
                user = "Paper";
		dos.writeUTF("Paper");
                dos.flush();
		ai = (String)dis.readUTF();
                String result = check();
		String[] res = {""+round+"",user,ai,result};
                if(result != null){
                    data[round-1] = res;
                    round += 1;
                }
		
          }
          catch(IOException exception){
		System.out.println(exception);
          }   
        }
        else if(e.getSource() == scissor){
            try{
                user = "Scissor";
		dos.writeUTF("Scissor");
                dos.flush();
		ai = (String)dis.readUTF();
                String result = check();
		String[] res = {""+round+"",user,ai,result};
                if(result != null){
                    data[round-1] = res;
                    round += 1;
                }
		
          }
          catch(IOException exception){
		System.out.println(exception);
          }   
        }
    }
    public String check() {
        if(user.equalsIgnoreCase(ai)){
            RoundResult res = new RoundResult("Round Drawn",user,ai);
            res.setVisible(true);
            time = new Timer(3000, (e) -> {
                res.setVisible(false);
            });
            time.start();
        }
        else if("stone".equalsIgnoreCase(user) && "scissor".equalsIgnoreCase(ai) || "scissor".equalsIgnoreCase(user) && "paper".equalsIgnoreCase(ai) || "paper".equalsIgnoreCase(user) && "stone".equalsIgnoreCase(ai)){
            user_count+= 1;
            result_you.setText("You : "+user_count);
            result_ai.setText("AI   : "+ai_count);
            
            
            if(user_count + ai_count >=3 || user_count == 2){
                try {
                    dos.writeUTF("Close");
                    dos.flush();
                    s.close();
                    RoundResult res = new RoundResult("You won this round",user,ai);
                    res.setVisible(true);
                    time = new Timer(3000, (e) -> {
                        res.setVisible(false);
                        dialog = new DialogFinal(frame,"Hurrray!!!","You Won",user_count,ai_count,data);
                        stone.setEnabled(false);
                        paper.setEnabled(false);
                        scissor.setEnabled(false);
                        repeat.setVisible(true);
                        time.stop();
                    });
                    time.start();
                } catch (IOException ex) {
                    System.out.print(ex);
                }
            }
            else{
                RoundResult res = new RoundResult("You won this round",user,ai);
                res.setVisible(true);
                Timer time = new Timer(3000, (e) -> {
                    res.setVisible(false);
                });
                time.start();
            }
                return "you Won";
        }
        else if("stone".equalsIgnoreCase(ai) && "scissor".equalsIgnoreCase(user) || "scissor".equalsIgnoreCase(ai) && "paper".equalsIgnoreCase(user) || "paper".equalsIgnoreCase(ai) && "stone".equalsIgnoreCase(user)){
            
            ai_count+= 1;
            result_you.setText("You : "+user_count);
            result_ai.setText("AI   : "+ai_count);
            
            
            if(user_count + ai_count >=3 || ai_count == 2){
                try {
                    dos.writeUTF("Close");
                    dos.flush();
                    s.close();
                    RoundResult res = new RoundResult("You Lost this round",user,ai);
                    res.setVisible(true);
                    time = new Timer(3000, (e) -> {
                        res.setVisible(false);
                        dialog = new DialogFinal(frame,"OOPS!!!","You Lost",user_count,ai_count,data);
                        stone.setEnabled(false);
                        paper.setEnabled(false);
                        scissor.setEnabled(false);
                        repeat.setVisible(true);
                        time.stop();
                    });
                    time.start();
                } catch (IOException ex) {
                    System.out.print(ex);
                }
            }
            else{
                RoundResult res = new RoundResult("You Lost this round",user,ai);
                res.setVisible(true);
                time = new Timer(3000, (e) -> {
                    res.setVisible(false);
                });
                time.start();
            }
            return "AI Won";
        }
        return null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == close){
                if(s.isClosed() == false){
                    try{
                        dos.writeUTF("Close");
                        dos.flush();
                        s.close();
                    }
                    catch(IOException ex){
                            System.out.println(ex);
                    }
                
                }  
                System.exit(0);
        }
        else if(e.getSource() == minimize){
            frame.setState(JFrame.ICONIFIED);
        }
        else if(e.getSource() == help){
            try {
                Runtime.getRuntime().exec(new String[]{"cmd","/c","start chrome http://localhost:8080/SPS.live/"});
            } catch (IOException ex) {
                Logger.getLogger(SPSLive.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == repeat){
            Thread t = new Thread(new SPSLive());
            t.start();
            frame.dispose();
            try{
                dialog.dispose();
            }
            catch(Exception ex){
                
            }
        }
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
        if(e.getSource() == stone){
            stoneLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.HandStone)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == paper){
            paperLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.HandPaper)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == scissor){
            scissorLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.HandScissor)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == close){
            close.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.hover_close_icon_path)));
        }
        else if(e.getSource() == minimize){
            minimize.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.hover_minimize_icon_path)));
        }
        else if(e.getSource() == help){
            help.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.hover_help_icon_path)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == stone){
            stoneLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.Stone)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == paper){
            paperLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.Paper)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == scissor){
            scissorLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.Scissor)).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == close){
            close.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.close_icon_path)));
        }
        else if(e.getSource() == minimize){
            minimize.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.minimize_icon_path)));
        }
        else if(e.getSource() == help){
            help.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Constants.help_icon_path)));
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
