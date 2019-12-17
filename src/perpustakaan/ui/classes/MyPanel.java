/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdrpl.gui;

import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class MyPanel extends javax.swing.JPanel{
    public MyPanel(){
        super();
        getFrame();
    }
    public MyFrame getFrame(){
        return (MyFrame) SwingUtilities.getWindowAncestor(this);
    }
    public void setPopup(MyFrame popup, boolean hideParent){
        getFrame().setPopup(popup, hideParent);
    }
    public void dispose(){
        getFrame().dispose();
    }
    public void dispose(boolean x){
        getFrame().dispose(x);
    }
}
