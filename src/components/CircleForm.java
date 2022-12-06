package components;

import java.awt.Graphics;
import javax.swing.JPanel;


public class CircleForm extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        
//        int h = getHeight();
//        int w = getWidth();
//        super.paintComponent(g);
//        g.setColor(getBackground());
        g.setColor(getBackground());
        g.fillOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
//        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        
        
    }
}
