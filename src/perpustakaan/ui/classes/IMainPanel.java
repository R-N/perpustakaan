/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.classes;

import javax.swing.JPanel;
import perpustakaan.ui.forms.MainPanel;

/**
 *
 * @author LENOVO
 */
public interface IMainPanel {
    public void init(MainPanel parent);
    public void setParent(MainPanel parent);
    public void refresh();
    public void load(Object object);
    public JPanel getPanel();
}
