/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.classes;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import javax.accessibility.AccessibleContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.RepaintManager;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.plaf.basic.BasicLabelUI;
import javax.swing.text.View;
import sun.swing.SwingUtilities2;

/**
 *
 * @author Wolf
 https://stackoverflow.com/users/834010/wolf
 https://stackoverflow.com/questions/10634417/imageIcon-resize-to-fit-on-jpanel
 */
public class ImageLabel extends JLabel{
    private ImageIcon imageIcon;
    
    public static final int FIT_BOTH = 0;
    public static final int FIT_WIDTH = 1;

    private int mode = FIT_BOTH;
    public ImageLabel(){
        this(FIT_BOTH);
    }
    
    public ImageLabel(int mode){
        super();
        //setBackground(new java.awt.Color(0,0,0,0));
        setDoubleBuffered(true);
        setMode(mode);
    }
    
    public void setMode(int mode){
        this.mode = mode;
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon instanceof ImageIcon)
        {
            ImageIcon oldValue = this.imageIcon;
            imageIcon = ((ImageIcon) icon);
            String text = getText();
            if(text == null || text.trim().isEmpty()) fitWidth();
            
            firePropertyChange("icon", oldValue, imageIcon);

            if ((accessibleContext != null) && (oldValue != imageIcon)) {
                    accessibleContext.firePropertyChange(
                            AccessibleContext.ACCESSIBLE_VISIBLE_DATA_PROPERTY,
                            oldValue, imageIcon);
            }

            revalidate();
            repaint();
        }else{
            super.setIcon(icon);
        }


    }
    
    public void setWidth(int width){
        int h = (int)(((double)width)/imageIcon.getIconWidth() * imageIcon.getIconHeight());
        Dimension size = new Dimension(width, h);
        //setMaximumSize(size);
        setPreferredSize(size);
        setSize(size);
    }
    
    public void fitWidth(){
        setWidth(getWidth());
    }

    public boolean paintImage(Graphics g){
        if(imageIcon == null) return false;
        if(g == null) return false;
        switch(mode){
            case FIT_BOTH:{
                g.drawImage(imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
                return true;
            }
            case FIT_WIDTH:{
                int w = getWidth();
                int h = w/imageIcon.getIconWidth() * imageIcon.getIconHeight();
                setSize(w, h);
                g.drawImage(imageIcon.getImage(), 0, 0, w, h, null);
                
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void paint(Graphics g){
        if(imageIcon == null){
            super.paint(g);
            return;
        }
        paintImage(g);
        paintChildren(g);
    }
    
}
