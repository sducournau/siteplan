/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TagsFeaturesUI.java
 *
 * Created on 02-Dec-2010, 02:09:04
 */

package org.twak.siteplan.campskeleton;

import org.twak.siteplan.anchors.FeatureUI;
import org.twak.siteplan.tags.TagListUI;

/**
 *
 * @author twak
 */
public class TagsFeaturesUI extends javax.swing.JPanel {

    /** Creates new form TagsFeaturesUI */
    public TagsFeaturesUI() {
        initComponents();
    }
    public TagsFeaturesUI(Plan plan ) {
        initComponents();

        add( new FeatureUI(plan));
        add ( new TagListUI(plan) );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(1, 2));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
