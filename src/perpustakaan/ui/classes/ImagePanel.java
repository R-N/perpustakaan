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
import java.awt.MediaTracker;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author Lenovo2
 */
public class ImagePanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    public static final int FIT_BOTH = 0;
    public static final int FIT_WIDTH = 1;
    public static final int FIT_HEIGHT = 2;
    
    private ImageIcon imageIcon = null;
    public String path = "/perpustakaan/ui/gambar/";
    
    private Image image;
    private javax.swing.SwingWorker worker;

    private int mode = FIT_BOTH;
    public ImagePanel()
    {
        super();
        
        setDoubleBuffered(true);
        setMode(mode);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                image = null;
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        rebuildImage();
                    }
                });
            }
        });
    }
    
    public void rebuildImage(){
        final int w;
        final int h;
        switch(mode){
            case FIT_BOTH:{
                w = this.getWidth();
                h = this.getHeight();
                break;
            }
            case FIT_WIDTH:{
                w = getWidth();
                h = (int)((1.0*w)/imageIcon.getIconWidth() * imageIcon.getIconHeight());
                break;
            }
            case FIT_HEIGHT:{
                h = getHeight();
                w = (int)((1.0*h)/imageIcon.getIconHeight() * imageIcon.getIconWidth());
                break;
            }
            default:{
                w = 0;
                h = 0;
            }
        }
        if(w == 0 || h == 0) return;
        int oldW = imageIcon.getIconWidth();
        int oldH = imageIcon.getIconHeight();
        double origDiag = Math.sqrt(oldW*oldW+oldH*oldH);
        final double newDiag = Math.sqrt(w*w+h*h);
        final int scaling;
        if(newDiag < origDiag){
            scaling = Image.SCALE_AREA_AVERAGING;
        }else{
            scaling = Image.SCALE_SMOOTH;
        }
        final Image img = imageIcon.getImage().getScaledInstance(w, h, scaling);
        if(worker != null) worker.cancel(true);
        worker = new javax.swing.SwingWorker() {
            @Override
            protected Object doInBackground() throws IOException {    
                Image img = imageIcon.getImage().getScaledInstance(w, h, scaling);     
                MediaTracker tracker = new MediaTracker(new java.awt.Container());
                tracker.addImage(img, 0);
                try {
                    tracker.waitForAll();
                    if(worker == this){
                        worker = null;
                        image = img;
                        revalidate();
                        repaint();
                    }
                } catch (InterruptedException ex) {
                }
                return null;
            }            
        };
        worker.execute();
    }
    
    public void setMode(int mode){
        this.mode = mode;
    }
    public void setImage(String iconName){
        setImage(new javax.swing.ImageIcon(getClass().getResource(path + iconName)));
    }
    

    public void setImage(Icon icon) {
        if (icon instanceof ImageIcon)
        {
            imageIcon = ((ImageIcon) icon);
            //fitWidth();
            image = null;
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    rebuildImage();
                }
            });
            
            revalidate();
            repaint();
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
        switch(mode){
            case FIT_BOTH:{
                int w = this.getWidth();
                int h = this.getHeight();
                if(image == null){
                    g.drawImage(imageIcon.getImage(), 0, 0, w, h, this);
                }else{
                    g.drawImage(image, 0, 0, this);
                }
                return true;
            }
            case FIT_WIDTH:{
                int w = getWidth();
                int h = (int)((1.0*w)/imageIcon.getIconWidth() * imageIcon.getIconHeight());
                int x = 0;
                int y = (int)(0.5*(getHeight()-h));
                if(image == null){
                    g.drawImage(imageIcon.getImage(), x, y, w, h, this);
                }else{
                    g.drawImage(image, x, y, this);
                }
                
                return true;
            }
            case FIT_HEIGHT:{
                int h = getHeight();
                int w = (int)((1.0*h)/imageIcon.getIconHeight() * imageIcon.getIconWidth());
                int x = (int)(0.5*(getWidth()-w));
                int y = 0;
                if(image == null){
                    g.drawImage(imageIcon.getImage(), x, y, w, h, this);
                }else{
                    g.drawImage(image, x, y, this);
                }
                
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
