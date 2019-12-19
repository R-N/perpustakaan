/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.classes;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
/**
 *
 * @author MojoMacW7
 */

public class WrapTextPane extends JTextPane{
    String text;
    public GridBagConstraints gridBagConstraints;
    public double widthMul;
    public WrapTextPane(){
        super();
        setDoubleBuffered(true);
        setBackground(null);
        setEditable(false);
        setContentType("text/html");
        setHighlighter(null);
    }
    @Override
    public String getText(){
        return text;
    }
    @Override
    public void setText(String text){
        this.text = text;
        //text = "<!DOCTYPE html>\n<html>\n<head>\n<style>\nimg {\nmax-width:100%;\n}\nbody\n{white-space:pre;word-wrap:break-word;\n}\n</style></head><body style=\"max-width:100%;word-wrap:break-word;white-space:pre;\">" + text +  "</body></html>";
        text = "<!DOCTYPE html>\n<html>\n<head>\n<style>\nimg {\nmax-width:100%;\n}\nbody\n{word-wrap:break-word;\n}\n</style></head><body style=\"max-width:100%;word-wrap:break-word;\">" + text.replace("\n", "<br>").replace("  ", "&nbsp;&nbsp;") +  "</body></html>";
        super.setText(text);
    }
    public void setTextCenter(String text){
        //https://stackoverflow.com/questions/37972338/how-to-center-text-vertically-in-a-heading
        String text2 = "<p align=\"center\" style=\"text-align:center;width:100%;height:100%;justify-content: center;align-items: center;vertical-align: middle;\">" +  text + "</p>";
        setText(text2);
        this.text = text;
    }
    public WrapTextPane(String text){
        this();
        setText(text);
    }
    
    @Override
    public void setSize(Dimension size){
        super.setSize(size);
        super.setSize(getPreferredSize());
    }
     
     @Override
     public Dimension getPreferredSize(){
        int w = getWidth();
        if(w > 0){
            super.setSize(new Dimension(w, 20));
            return new Dimension(w, super.getPreferredSize().height);
        }else{
            return super.getPreferredSize();
        }
     }
}
