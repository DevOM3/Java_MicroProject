
package sps.live;

import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javax.swing.*;


public class DialogFinal extends Frame{

    public DialogFinal(Frame owner,String Title,String result_msg,int user,int ai,String[][] data){
        
        setSize(400,250);
        setUndecorated(true);
        add(new DialogFinalPanel(owner, Title, result_msg, user, ai, data,this));
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
