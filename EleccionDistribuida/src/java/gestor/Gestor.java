
package gestor;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import proceso.Estado;
import proceso.Proceso;


public class Gestor extends javax.swing.JFrame {

    
    public final static String[] IP_MAQUINAS = {"http://localhost", "http://127.0.0.1", "http://127.0.0.1"};
    public final static String PATH_BASE = ":8080/EleccionDistribuida/webresources/servicio/";
    
    
    
    public Gestor() {
        initComponents();
        this.pack();
        
        // set IPs
        this.labelIPMaquina1.setText("IP: " + IP_MAQUINAS[0]);
        this.labelIPMaquina2.setText("IP: " + IP_MAQUINAS[1]);
        this.labelIPMaquina3.setText("IP: " + IP_MAQUINAS[2]);
    }
    
    
    
    private void arrancarProceso(int id) {
        mostrarNotificacion("Arrancando proceso con id=" + id);
        try {
            URL url = new URL(getUrlBase(id) + "arrancarProceso/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                mostrarNotificacion("Ha arrancado el proceso con id=" + id);
                cambiarEstado(id, Estado.Corriendo);
            } else {
                mostrarNotificacion("ERROR: No se ha arrancando proceso con id=" + id);
            }
            conn.disconnect();
        } catch (IOException ex) {
            mostrarNotificacion("ERROR: Problema al establecer la conexión");
        }
    }
    
    
    
    private void pararProceso(int id) {
        mostrarNotificacion("Parando proceso con id=" + id);
        try {
            URL url = new URL(getUrlBase(id) + "pararProceso/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                mostrarNotificacion("Ha parado el proceso con id=" + id);
                cambiarEstado(id, Estado.Parado);
            } else {
                mostrarNotificacion("ERROR: No se ha parado proceso con id=" + id);
            }
            conn.disconnect();
        } catch (IOException ex) {
            mostrarNotificacion("ERROR: Problema al establecer la conexión");
        }
    }
    
    
    
    private void cambiarEstado(int id, Estado estado) {
        JToggleButton button = null;
        switch (id) {
            case 1:
                button = this.jToggleEstat1;
                break;
            case 2:
                button = this.jToggleEstat2;
                break;
            case 3:
                button = this.jToggleEstat3;
                break;
            case 4:
                button = this.jToggleEstat4;
                break;
            case 5:
                button = this.jToggleEstat5;
                break;
            case 6:
                button = this.jToggleEstat6;
                break;
        }
        ImageIcon icon;
        if (estado == Estado.Corriendo) {
            icon = new ImageIcon(getClass().getResource("/gestor/imatges/on.png"));
        } else { // estado == Estado.Parado
            icon = new ImageIcon(getClass().getResource("/gestor/imatges/off.png"));
        }
        button.setIcon(icon);
    }
    
    
    
    private void seleccionarProceso(int id) {
        // Primero los des-seleccionamos todos
        ImageIcon icon;
        // P1
        icon = new ImageIcon(getClass().getResource("/gestor/imatges/1.png"));
        this.jLabelP1.setIcon(icon);
        // P2
        icon = new ImageIcon(getClass().getResource("/gestor/imatges/2.png"));
        this.jLabelP2.setIcon(icon);
        // P3
        icon = new ImageIcon(getClass().getResource("/gestor/imatges/3.png"));
        this.jLabelP3.setIcon(icon);
        // P4
        icon = new ImageIcon(getClass().getResource("/gestor/imatges/4.png"));
        this.jLabelP4.setIcon(icon);
        // P5
        icon = new ImageIcon(getClass().getResource("/gestor/imatges/5.png"));
        this.jLabelP5.setIcon(icon);
        // P6
        icon = new ImageIcon(getClass().getResource("/gestor/imatges/6.png"));
        this.jLabelP6.setIcon(icon);
        
        // seleccionamos el proceso
        switch (id) {
            case 1:
                icon = new ImageIcon(getClass().getResource("/gestor/imatges/select1.png"));
                this.jLabelP1.setIcon(icon);
                break;
            case 2:
                icon = new ImageIcon(getClass().getResource("/gestor/imatges/select2.png"));
                this.jLabelP2.setIcon(icon);
                break;
            case 3:
                icon = new ImageIcon(getClass().getResource("/gestor/imatges/select3.png"));
                this.jLabelP3.setIcon(icon);
                break;
            case 4:
                icon = new ImageIcon(getClass().getResource("/gestor/imatges/select4.png"));
                this.jLabelP4.setIcon(icon);
                break;
            case 5:
                icon = new ImageIcon(getClass().getResource("/gestor/imatges/select5.png"));
                this.jLabelP5.setIcon(icon);
                break;
            case 6:
                icon = new ImageIcon(getClass().getResource("/gestor/imatges/select6.png"));
                this.jLabelP6.setIcon(icon);
                break;
        }
    }
    
    
    
    public static String getUrlBase(int id) {
        String urlStr = "";
        switch (id) {
            case 1:
            case 2:
                // máquina 1
                urlStr += IP_MAQUINAS[0];
                break;
            case 3:
            case 4:
                // máquina 2
                urlStr += IP_MAQUINAS[1];
                break;
            case 5:
            case 6:
                // máquina 3
                urlStr += IP_MAQUINAS[2];
                break;
        }
        return urlStr + PATH_BASE;
    }
    
    
    
    public static void mostrarNotificacion(String notificacio) {
        textAreaNotificaciones.append("> " + notificacio + "\n");
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
        labelIPMaquina1 = new javax.swing.JLabel();
        jToggleEstat1 = new javax.swing.JToggleButton();
        jToggleEstat2 = new javax.swing.JToggleButton();
        jPanelMaquina2 = new javax.swing.JPanel();
        jLabelP3 = new javax.swing.JLabel();
        jLabelP4 = new javax.swing.JLabel();
        labelIPMaquina2 = new javax.swing.JLabel();
        jToggleEstat3 = new javax.swing.JToggleButton();
        jToggleEstat4 = new javax.swing.JToggleButton();
        jPanelMaquina3 = new javax.swing.JPanel();
        jLabelP5 = new javax.swing.JLabel();
        jLabelP6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelIPMaquina3 = new javax.swing.JLabel();
        jToggleEstat5 = new javax.swing.JToggleButton();
        jToggleEstat6 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaNotificaciones = new javax.swing.JTextArea();
        buttonArrancarTodos = new javax.swing.JButton();
        buttonPararProcesos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elección Distribuida");
        setMinimumSize(new java.awt.Dimension(660, 520));
        setPreferredSize(new java.awt.Dimension(660, 520));

        jPanelMaquina1.setBackground(new java.awt.Color(153, 153, 153));
        jPanelMaquina1.setBorder(javax.swing.BorderFactory.createTitledBorder("Máquina 1"));
        jPanelMaquina1.setMinimumSize(new java.awt.Dimension(150, 300));
        jPanelMaquina1.setPreferredSize(new java.awt.Dimension(150, 300));

        jLabelP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/1.png"))); // NOI18N

        jLabelP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/2.png"))); // NOI18N

        labelIPMaquina1.setText("IP:");

        jToggleEstat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/off.png"))); // NOI18N
        jToggleEstat1.setMnemonic('1');
        jToggleEstat1.setMaximumSize(new java.awt.Dimension(22, 22));
        jToggleEstat1.setMinimumSize(new java.awt.Dimension(22, 22));
        jToggleEstat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleEstat1ActionPerformed(evt);
            }
        });

        jToggleEstat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/off.png"))); // NOI18N
        jToggleEstat2.setMnemonic('2');
        jToggleEstat2.setMaximumSize(new java.awt.Dimension(22, 22));
        jToggleEstat2.setMinimumSize(new java.awt.Dimension(22, 22));
        jToggleEstat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleEstat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMaquina1Layout = new javax.swing.GroupLayout(jPanelMaquina1);
        jPanelMaquina1.setLayout(jPanelMaquina1Layout);
        jPanelMaquina1Layout.setHorizontalGroup(
            jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMaquina1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelMaquina1Layout.createSequentialGroup()
                        .addComponent(jToggleEstat2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP2))
                    .addGroup(jPanelMaquina1Layout.createSequentialGroup()
                        .addComponent(jToggleEstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelP1)))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMaquina1Layout.createSequentialGroup()
                .addComponent(labelIPMaquina1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelMaquina1Layout.setVerticalGroup(
            jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelIPMaquina1)
                .addGap(32, 32, 32)
                .addGroup(jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleEstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanelMaquina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelP2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleEstat2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        jPanelMaquina2.setBackground(new java.awt.Color(153, 153, 153));
        jPanelMaquina2.setBorder(javax.swing.BorderFactory.createTitledBorder("Máquina 2"));

        jLabelP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/3.png"))); // NOI18N

        jLabelP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/4.png"))); // NOI18N

        labelIPMaquina2.setText("IP:");

        jToggleEstat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/off.png"))); // NOI18N
        jToggleEstat3.setMnemonic('3');
        jToggleEstat3.setMaximumSize(new java.awt.Dimension(22, 22));
        jToggleEstat3.setMinimumSize(new java.awt.Dimension(22, 22));
        jToggleEstat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleEstat3ActionPerformed(evt);
            }
        });

        jToggleEstat4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/off.png"))); // NOI18N
        jToggleEstat4.setMnemonic('4');
        jToggleEstat4.setMaximumSize(new java.awt.Dimension(22, 22));
        jToggleEstat4.setMinimumSize(new java.awt.Dimension(22, 22));
        jToggleEstat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleEstat4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMaquina2Layout = new javax.swing.GroupLayout(jPanelMaquina2);
        jPanelMaquina2.setLayout(jPanelMaquina2Layout);
        jPanelMaquina2Layout.setHorizontalGroup(
            jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMaquina2Layout.createSequentialGroup()
                        .addComponent(jLabelP4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleEstat4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMaquina2Layout.createSequentialGroup()
                        .addComponent(jLabelP3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleEstat3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(labelIPMaquina2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMaquina2Layout.setVerticalGroup(
            jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelIPMaquina2)
                .addGap(34, 34, 34)
                .addGroup(jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleEstat3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanelMaquina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleEstat4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanelMaquina3.setBackground(new java.awt.Color(153, 153, 153));
        jPanelMaquina3.setBorder(javax.swing.BorderFactory.createTitledBorder("Máquina 3"));
        jPanelMaquina3.setMinimumSize(new java.awt.Dimension(180, 150));
        jPanelMaquina3.setPreferredSize(new java.awt.Dimension(180, 150));

        jLabelP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/5.png"))); // NOI18N

        jLabelP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/6.png"))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/gestor.png"))); // NOI18N

        labelIPMaquina3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIPMaquina3.setText("IP: localhost");
        labelIPMaquina3.setToolTipText("");

        jToggleEstat5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/off.png"))); // NOI18N
        jToggleEstat5.setMnemonic('5');
        jToggleEstat5.setMaximumSize(new java.awt.Dimension(22, 22));
        jToggleEstat5.setMinimumSize(new java.awt.Dimension(22, 22));
        jToggleEstat5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleEstat5ActionPerformed(evt);
            }
        });

        jToggleEstat6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/imatges/off.png"))); // NOI18N
        jToggleEstat6.setMnemonic('6');
        jToggleEstat6.setMaximumSize(new java.awt.Dimension(22, 22));
        jToggleEstat6.setMinimumSize(new java.awt.Dimension(22, 22));
        jToggleEstat6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleEstat6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMaquina3Layout = new javax.swing.GroupLayout(jPanelMaquina3);
        jPanelMaquina3.setLayout(jPanelMaquina3Layout);
        jPanelMaquina3Layout.setHorizontalGroup(
            jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP5)
                    .addComponent(jToggleEstat5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIPMaquina3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP6)
                    .addComponent(jToggleEstat6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelMaquina3Layout.setVerticalGroup(
            jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaquina3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelMaquina3Layout.createSequentialGroup()
                        .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelP6)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelMaquina3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIPMaquina3)
                            .addComponent(jToggleEstat6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelMaquina3Layout.createSequentialGroup()
                        .addComponent(jLabelP5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleEstat5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelIPMaquina3.getAccessibleContext().setAccessibleName("LabelIPMaquina3");

        textAreaNotificaciones.setColumns(20);
        textAreaNotificaciones.setRows(5);
        jScrollPane1.setViewportView(textAreaNotificaciones);

        buttonArrancarTodos.setText("Arrancar procesos");
        buttonArrancarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonArrancarTodosActionPerformed(evt);
            }
        });

        buttonPararProcesos.setText("Parar procesos");
        buttonPararProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPararProcesosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonArrancarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPararProcesos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonArrancarTodos)
                    .addComponent(buttonPararProcesos))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMaquina1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMaquina3, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMaquina2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMaquina1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jPanelMaquina2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMaquina3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonArrancarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArrancarTodosActionPerformed
        for (int i = 1; i <= Proceso.NUM_PROCESOS; i++) {
            arrancarProceso(i);
        }
    }//GEN-LAST:event_buttonArrancarTodosActionPerformed

    private void jToggleEstat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleEstat1ActionPerformed
        if (!jToggleEstat1.isSelected()) {
            pararProceso(1);
        } else {
            arrancarProceso(1);
        }
    }//GEN-LAST:event_jToggleEstat1ActionPerformed

    private void jToggleEstat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleEstat2ActionPerformed
        if (!jToggleEstat2.isSelected()) {
            pararProceso(2);
        } else {
            arrancarProceso(2);
        }
    }//GEN-LAST:event_jToggleEstat2ActionPerformed

    private void jToggleEstat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleEstat3ActionPerformed
        if (!jToggleEstat3.isSelected()) {
            pararProceso(3);
        } else {
            arrancarProceso(3);
        }
    }//GEN-LAST:event_jToggleEstat3ActionPerformed

    private void jToggleEstat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleEstat4ActionPerformed
        if (!jToggleEstat4.isSelected()) {
            pararProceso(4);
        } else {
            arrancarProceso(4);
        }
    }//GEN-LAST:event_jToggleEstat4ActionPerformed

    private void jToggleEstat5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleEstat5ActionPerformed
        if (!jToggleEstat5.isSelected()) {
            pararProceso(5);
        } else {
            arrancarProceso(5);
        }
    }//GEN-LAST:event_jToggleEstat5ActionPerformed

    private void jToggleEstat6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleEstat6ActionPerformed
        if (!jToggleEstat6.isSelected()) {
            pararProceso(6);
        } else {
            arrancarProceso(6);
        }
    }//GEN-LAST:event_jToggleEstat6ActionPerformed

    private void buttonPararProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPararProcesosActionPerformed
        for (int i = 1; i <= 6; i++) {
            pararProceso(i);
        }
    }//GEN-LAST:event_buttonPararProcesosActionPerformed

    
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
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestor().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonArrancarTodos;
    private javax.swing.JButton buttonPararProcesos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelP1;
    private javax.swing.JLabel jLabelP2;
    private javax.swing.JLabel jLabelP3;
    private javax.swing.JLabel jLabelP4;
    private javax.swing.JLabel jLabelP5;
    private javax.swing.JLabel jLabelP6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMaquina1;
    private javax.swing.JPanel jPanelMaquina2;
    private javax.swing.JPanel jPanelMaquina3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleEstat1;
    private javax.swing.JToggleButton jToggleEstat2;
    private javax.swing.JToggleButton jToggleEstat3;
    private javax.swing.JToggleButton jToggleEstat4;
    private javax.swing.JToggleButton jToggleEstat5;
    private javax.swing.JToggleButton jToggleEstat6;
    private javax.swing.JLabel labelIPMaquina1;
    private javax.swing.JLabel labelIPMaquina2;
    private javax.swing.JLabel labelIPMaquina3;
    private static javax.swing.JTextArea textAreaNotificaciones;
    // End of variables declaration//GEN-END:variables
}
