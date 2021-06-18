
package sps.live;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javax.swing.*;


public class ScoreCard extends Frame {
    Frame fr;
    public ScoreCard(String[][] data) {
        fr = this;
        setSize(700,240);
        setUndecorated(true);
        setResizable(false);
        add(new ScoreCardPanel(data,this));
        setLocationRelativeTo(null);
        setVisible(true);
        
                
    }

    
}
