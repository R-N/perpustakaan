/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.classes;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author Lenovo2
 */
public class ImagePanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    private ImageIcon imageIcon = null;
    public String path = "/perpustakaan/ui/gambar/";
    private int iWidth2;
    private int iHeight2;
    

    public ImagePanel()
    {
        super();
        
        setDoubleBuffered(true);
    }
    
    public void setImage(String iconName){
        setImage(new javax.swing.ImageIcon(getClass().getResource(path + iconName)));
    }
    

    public void setImage(Icon icon) {
        if (icon instanceof ImageIcon)
        {
            imageIcon = ((ImageIcon) icon);
            //fitWidth();
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
    /*
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (imageIcon != null)
        {
            int x = this.getParent().getWidth()/2 - iWidth2;
            int y = this.getParent().getHeight()/2 - iHeight2;
            g.drawImage(imageIcon.getImage(),x,y,this);
        }
    }*/
    
    public boolean paintImage(Graphics g){
        if(imageIcon == null) return false;
        if(g == null) return false;
        g.drawImage(imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        return true;
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
