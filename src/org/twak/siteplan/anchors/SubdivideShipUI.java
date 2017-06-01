package org.twak.siteplan.anchors;

import org.twak.siteplan.campskeleton.Siteplan;
import org.twak.siteplan.campskeleton.Plan;
import org.twak.utils.AbstractDocumentListener;
import org.twak.utils.WeakListener;
import org.twak.utils.WeakListener.Changed;

/**
 *
 * @author twak
 */
public class SubdivideShipUI extends javax.swing.JPanel {

    Plan plan;
    SubdivideShip ship;
    WeakListener.Changed pListChangedListener = new Changed()
        {
            @Override
            public void changed()
            {
                jProfileProfileMap1.update( ship.volumeSubdivide, SubdivideShipUI.this.plan.findProfiles());
            }
        } ;

    /** Creates new form SubdivideShipUI */
    public SubdivideShipUI() {
        initComponents();
    }

    public SubdivideShipUI( Plan plan, final SubdivideShip ship, final  Changed refreshFeatureListListener ) {
        this.plan = plan;
        this.ship = ship;
        initComponents();

        Siteplan.instance.profileListChangedListeners.add( pListChangedListener );

        useOriginalCheck.setSelected( ship.keepOriginal );
        nameField.setText( ship.name );
        nameField.getDocument().addDocumentListener(new AbstractDocumentListener() {
            @Override
            public void changed() {
                SubdivideShipUI.this.ship.name = nameField.getText();
                refreshFeatureListListener.changed(); // flush to ui
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jProfileProfileMap1 = new JProfileProfileMap(plan, ship.volumeSubdivide, plan.findProfiles());
        useOriginalCheck = new javax.swing.JCheckBox();

        jLabel1.setText("name:");

        nameField.setText("name");

        useOriginalCheck.setText("keep original");
        useOriginalCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useOriginalCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
            .addComponent(jProfileProfileMap1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
            .addComponent(useOriginalCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useOriginalCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProfileProfileMap1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void useOriginalCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_useOriginalCheckActionPerformed
    {//GEN-HEADEREND:event_useOriginalCheckActionPerformed
        ship.keepOriginal = useOriginalCheck.isSelected();
        Siteplan.instance.somethingChanged();
    }//GEN-LAST:event_useOriginalCheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private org.twak.siteplan.anchors.JProfileProfileMap jProfileProfileMap1;
    private javax.swing.JTextField nameField;
    private javax.swing.JCheckBox useOriginalCheck;
    // End of variables declaration//GEN-END:variables

}
