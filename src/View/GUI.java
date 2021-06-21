/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Thomas Khiem
 */
public class gui extends javax.swing.JFrame {

    /**
     * Creates new form ContactEditorUI
     */
    public gui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPlane = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        LoadData = new javax.swing.JButton();
        loadAggregat = new javax.swing.JButton();
        outputType = new javax.swing.JCheckBox();
        run = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputArea.setColumns(20);
        outputArea.setRows(5);
        scrollPlane.setViewportView(outputArea);

        LoadData.setText("Load Data");
        LoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadDataActionPerformed(evt);
            }
        });

        loadAggregat.setText("Load Aggregat");
        loadAggregat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadAggregatActionPerformed(evt);
            }
        });

        outputType.setText("Output jsonfile instead of screen");

        run.setText("Run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outputType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(run)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LoadData)
                        .addGap(32, 32, 32)
                        .addComponent(loadAggregat)
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoadData)
                    .addComponent(loadAggregat)
                    .addComponent(outputType)
                    .addComponent(run))
                .addGap(30, 30, 30))
        );

        outputType.getAccessibleContext().setAccessibleName("Output json file instead of screen");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadDataActionPerformed
     
            JFileChooser c = new JFileChooser();
            c.setAcceptAllFileFilterUsed(false);
            c.setFileFilter(new FileFilter() {

                public String getDescription() {
                    return "JSON Files (*.json)";
                }

                public boolean accept(File f) {
                    if (f.isDirectory()) {
                        return true;
                    } else {
                        String filename = f.getName().toLowerCase();
                        return filename.endsWith(".json");
                    }
                }
            });
            // Demonstrate "Open" dialog:
            int rVal = c.showOpenDialog(gui.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                outputArea.setText(c.getSelectedFile().getName());
               // dir.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                outputArea.setText("You pressed cancel");
                //dir.setText("");
            }
        
        
    }//GEN-LAST:event_LoadDataActionPerformed

    private void loadAggregatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAggregatActionPerformed
        // TODO add your handling code here:
          JFileChooser c = new JFileChooser();
            c.setAcceptAllFileFilterUsed(false);
            c.setFileFilter(new FileFilter() {

                public String getDescription() {
                    return "JSON Files (*.json)";
                }

                public boolean accept(File f) {
                    if (f.isDirectory()) {
                        return true;
                    } else {
                        String filename = f.getName().toLowerCase();
                        return filename.endsWith(".json");
                    }
                }
            });
            // Demonstrate "Open" dialog:
            int rVal = c.showOpenDialog(gui.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                outputArea.setText(c.getSelectedFile().getName());
               // dir.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                outputArea.setText("You pressed cancel");
                //dir.setText("");
            }
        
    }//GEN-LAST:event_loadAggregatActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        // TODO add your handling code here:
        //filter nach Aggregat
        if(outputType.isSelected()){
        System.out.print("TEST");   
        saveReport();
        } else{
        outputArea.setText("Output string");
        }
        
    }//GEN-LAST:event_runActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    public void saveReport()
{   
    outputArea.setText("Saving in file: logKMAX.txt");
    final String content = "TEST";
    final Path path = Paths.get("logKMAX.txt");

    try (
        final BufferedWriter writer = Files.newBufferedWriter(path,
            StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    ) {
        writer.write(content);
        writer.flush();
    }catch(Exception e){
        outputArea.setText("ERROR SAVING FAILED");    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoadData;
    private javax.swing.JButton loadAggregat;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JCheckBox outputType;
    private javax.swing.JButton run;
    private javax.swing.JScrollPane scrollPlane;
    // End of variables declaration//GEN-END:variables
}
