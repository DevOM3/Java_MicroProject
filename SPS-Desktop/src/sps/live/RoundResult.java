
package sps.live;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;


public class RoundResult extends Frame {
    
    public RoundResult(String result_msg,String user_img,String ai_img){
        setSize(330,220);
        setUndecorated(true);
        setResizable(false);
        add(new RoundResultPanel(result_msg, user_img, ai_img));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
}
