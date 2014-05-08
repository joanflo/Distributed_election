
package gui;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author joanflo
 */
public class Interfaz extends javax.swing.JFrame {

    
    public Interfaz() {
        initComponents();
        this.pack();
        
        canviarEstat(4, false);
        
        seleccionarProces(4);
    }
    
    
    
    private void canviarEstat(int id, boolean estat) {
        JLabel label = null;
        switch (id) {
            case 1:
                label = this.jLabelEstat1;
                break;
            case 2:
                label = this.jLabelEstat2;
                break;
            case 3:
                label = this.jLabelEstat3;
                break;
            case 4:
                label = this.jLabelEstat4;
                break;
            case 5:
                label = this.jLabelEstat5;
                break;
            case 6:
                label = this.jLabelEstat6;
                break;
        }
        ImageIcon icon;
        if (estat) {
            icon = new ImageIcon(getClass().getResource("/imatges/on.png"));
        } else {
            icon = new ImageIcon(getClass().getResource("/imatges/off.png"));
        }
        label.setIcon(icon);
    }
    
    
    
    private void seleccionarProces(int id) {
        // Primero los des-seleccionamos todos
        ImageIcon icon;
        // P1
        icon = new ImageIcon(getClass().getResource("/imatges/1.png"));
        this.jLabelP1.setIcon(icon);
        // P2
        icon = new ImageIcon(getClass().getResource("/imatges/2.png"));
        this.jLabelP1.setIcon(icon);
        // P3
        icon = new ImageIcon(getClass().getResource("/imatges/3.png"));
        this.jLabelP1.setIcon(icon);
        // P4
        icon = new ImageIcon(getClass().getResource("/imatges/4.png"));
        this.jLabelP1.setIcon(icon);
        // P5
        icon = new ImageIcon(getClass().getResource("/imatges/5.png"));
        this.jLabelP1.setIcon(icon);
        // P6
        icon = new ImageIcon(getClass().getResource("/imatges/6.png"));
        this.jLabelP1.setIcon(icon);
        
        // seleccionamos el proceso
        switch (id) {
            case 1:
                icon = new ImageIcon(getClass().getResource("/imatges/select1.png"));
                this.jLabelP1.setIcon(icon);
                break;
            case 2:
                icon = new ImageIcon(getClass().getResource("/imatges/select2.png"));
                this.jLabelP2.setIcon(icon);
                break;
            case 3:
                icon = new ImageIcon(getClass().getResource("/imatges/select3.png"));
                this.jLabelP3.setIcon(icon);
                break;
            case 4:
                icon = new ImageIcon(getClass().getResource("/imatges/select4.png"));
                this.jLabelP4.setIcon(icon);
                break;
            case 5:
                icon = new ImageIcon(getClass().getResource("/imatges/select5.png"));
                this.jLabelP5.setIcon(icon);
                break;
            case 6:
                icon = new ImageIcon(getClass().getResource("/imatges/select6.png"));
                this.jLabelP6.setIcon(icon);
                break;
        }
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMaquina1 = new javax.swing.JPanel();
        jLabelP1 = new javax.swing.JLabel();
        jLabelP2 = new javax.swing.JLabel();
        jLabelEstat1 = new javax.swing.JLabel();
        jLabelEstat2 = new javax.swing.JLabel();
        jPanelMaquina2 = new javax.swing.JPanel();
        jLabelP3 = new javax.swing.JLabel();
        jLabelP4 = new javax.swing.JLabel();
        jLabelEstat3 = new javax.swing.JLabel();
        jLabelEstat4 = new javax.swing.JLabel();
        jPanelMaquina3 = new javax.swing.JPanel();
        jLabelP5 = new javax.swing.JLabel();
        jLabelP6 = new javax.swing.JLabel();
        jLabelEstat5 = new javax.swing.JLabel();
        jLabelEstat6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elección Distribuida");
        setMinimumSize(new java.awt.Dimension(660, 520));
        setPreferredSize(new java.awt.Dimension(660, 520));

        jPanelMaquina1.setBackground(new java.awt.Color(153, 153, 153));
        jPanelMaquina1.setBorder(javax.swing.BorderFactory.createTitledBorder("Máquina 1"));
        jPanelMaquina1.setMinimumSize(new java.awt.Dimension(150, 300));
        jPanelMaquina1.setPreferredSize(new java.awt.Dimension(150, 300));

        jLabelP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/1.png"))); // NOI18N
        jLabelP1.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelP1.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelP1.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabelP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/2.png"))); // NOI18N
        jLabelP2.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelP2.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelP2.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabelEstat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/on.png"))); // NOI18N
        jLabelEstat1.setMaximumSize(new java.awt.Dimension(22, 22));
        jLabelEstat1.setMinimumSize(new java.awt.Dimension(22, 22));
        jLabelEstat1.setPreferredSize(new java.awt.Dimension(22, 22));

        jLabelEstat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/on.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMaquina1Layout = new javax.swing.GroupLayout(jPanelMaquina1);
        jPanelMaquina1.setLayout(jPanelMaquina1Layout);
        jPanelMaquina1Layout.setHorizontalGroup(
            jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMaquina1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelMaquina1Layout.createSequentialGroup()
                        .addComponent(jLabelEstat2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMaquina1Layout.createSequentialGroup()
                        .addComponent(jLabelEstat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanelMaquina1Layout.setVerticalGroup(
            jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstat2))
                .addGap(47, 47, 47))
        );

        jPanelMaquina2.setBackground(new java.awt.Color(153, 153, 153));
        jPanelMaquina2.setBorder(javax.swing.BorderFactory.createTitledBorder("Máquina 2"));

        jLabelP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/3.png"))); // NOI18N
        jLabelP3.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelP3.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelP3.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabelP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/4.png"))); // NOI18N
        jLabelP4.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelP4.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelP4.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabelEstat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/on.png"))); // NOI18N

        jLabelEstat4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/on.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMaquina2Layout = new javax.swing.GroupLayout(jPanelMaquina2);
        jPanelMaquina2.setLayout(jPanelMaquina2Layout);
        jPanelMaquina2Layout.setHorizontalGroup(
            jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMaquina2Layout.createSequentialGroup()
                        .addComponent(jLabelP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEstat4))
                    .addGroup(jPanelMaquina2Layout.createSequentialGroup()
                        .addComponent(jLabelP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEstat3)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanelMaquina2Layout.setVerticalGroup(
            jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstat3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstat4))
                .addGap(42, 42, 42))
        );

        jPanelMaquina3.setBackground(new java.awt.Color(153, 153, 153));
        jPanelMaquina3.setBorder(javax.swing.BorderFactory.createTitledBorder("Máquina 3"));
        jPanelMaquina3.setMinimumSize(new java.awt.Dimension(180, 150));
        jPanelMaquina3.setPreferredSize(new java.awt.Dimension(180, 150));

        jLabelP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/5.png"))); // NOI18N
        jLabelP5.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelP5.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelP5.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabelP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/6.png"))); // NOI18N
        jLabelP6.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelP6.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelP6.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabelEstat5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/on.png"))); // NOI18N

        jLabelEstat6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/on.png"))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/gestor.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMaquina3Layout = new javax.swing.GroupLayout(jPanelMaquina3);
        jPanelMaquina3.setLayout(jPanelMaquina3Layout);
        jPanelMaquina3Layout.setHorizontalGroup(
            jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina3Layout.createSequentialGroup()
                .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMaquina3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEstat5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEstat6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMaquina3Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jLabelP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelP6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelMaquina3Layout.setVerticalGroup(
            jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelP6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEstat5)
                    .addComponent(jLabelEstat6))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(488, 488, 488)
                        .addComponent(jPanelMaquina2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelMaquina1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jPanelMaquina3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanelMaquina3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelMaquina1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelMaquina2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 161, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEstat1;
    private javax.swing.JLabel jLabelEstat2;
    private javax.swing.JLabel jLabelEstat3;
    private javax.swing.JLabel jLabelEstat4;
    private javax.swing.JLabel jLabelEstat5;
    private javax.swing.JLabel jLabelEstat6;
    private javax.swing.JLabel jLabelP1;
    private javax.swing.JLabel jLabelP2;
    private javax.swing.JLabel jLabelP3;
    private javax.swing.JLabel jLabelP4;
    private javax.swing.JLabel jLabelP5;
    private javax.swing.JLabel jLabelP6;
    private javax.swing.JPanel jPanelMaquina1;
    private javax.swing.JPanel jPanelMaquina2;
    private javax.swing.JPanel jPanelMaquina3;
    // End of variables declaration//GEN-END:variables
}