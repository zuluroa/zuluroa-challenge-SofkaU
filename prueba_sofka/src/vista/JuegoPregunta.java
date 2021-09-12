/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.RondaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Opcion;
import modelo.Pregunta;
import modelo.Premio;
import modelo.Ronda;

/**
 *
 * @author zulur
 */
public class JuegoPregunta extends javax.swing.JFrame implements ICambiaVentana{

    private Opcion opcion = new Opcion();
    private Categoria categoria = new Categoria();
    private String RespuestaCorrecta = "";
    private int acumulado = 0;
    private int nivel = 0;
    private int i = 0;
    RondaJpaController controladorRonda = new RondaJpaController();
    EntityManager em = controladorRonda.getEntityManager();

    public JuegoPregunta() {
        initComponents();
        this.setLocationRelativeTo(null);
        nivel = 1;
        Iniciar();
        comenzarJuego();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnG_R_grupoBotones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txt_R_roda = new javax.swing.JLabel();
        txt_R_acumulado = new javax.swing.JLabel();
        txt_R_pregunta = new javax.swing.JLabel();
        Rbtn_R_opcion1 = new javax.swing.JRadioButton();
        Rbtn_R_opcion2 = new javax.swing.JRadioButton();
        Rbtn_R_opcion3 = new javax.swing.JRadioButton();
        Rbtn_R_opcion4 = new javax.swing.JRadioButton();
        Btn_R_retirar = new javax.swing.JButton();
        txt_R_categoria = new javax.swing.JLabel();
        Btn_R_siguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_R_roda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_R_roda.setText("RONDA 1");

        txt_R_acumulado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_R_acumulado.setText("ACUMULADO");

        txt_R_pregunta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_R_pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_R_pregunta.setText("¿Cuál es la nación más pequeña del mundo?");

        Rbtn_R_opcion1.setText("Andorra");

        Rbtn_R_opcion2.setText("Mónaco");

        Rbtn_R_opcion3.setText("El Vaticano");

        Rbtn_R_opcion4.setText("Alaska");

        Btn_R_retirar.setText("RETIRARSE");

        txt_R_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_R_categoria.setText("CATEGORIA");

        Btn_R_siguiente.setText("SIGUIENTE");
        Btn_R_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_R_siguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(txt_R_roda))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_R_pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Rbtn_R_opcion1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Rbtn_R_opcion2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Rbtn_R_opcion3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Rbtn_R_opcion4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_R_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_R_acumulado, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(Btn_R_retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(Btn_R_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txt_R_roda)
                .addGap(44, 44, 44)
                .addComponent(txt_R_acumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_R_categoria)
                .addGap(31, 31, 31)
                .addComponent(txt_R_pregunta)
                .addGap(46, 46, 46)
                .addComponent(Rbtn_R_opcion1)
                .addGap(18, 18, 18)
                .addComponent(Rbtn_R_opcion2)
                .addGap(18, 18, 18)
                .addComponent(Rbtn_R_opcion3)
                .addGap(18, 18, 18)
                .addComponent(Rbtn_R_opcion4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_R_retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_R_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_R_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_R_siguienteActionPerformed
      comprobarRespuesta();
    }//GEN-LAST:event_Btn_R_siguienteActionPerformed

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
            java.util.logging.Logger.getLogger(JuegoPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoPregunta().setVisible(true);
            }
        });
    }

    private void Iniciar() {
        BtnG_R_grupoBotones.add(Rbtn_R_opcion1);
        BtnG_R_grupoBotones.add(Rbtn_R_opcion2);
        BtnG_R_grupoBotones.add(Rbtn_R_opcion3);
        BtnG_R_grupoBotones.add(Rbtn_R_opcion4);
    }

    private void comenzarJuego() {
        txt_R_roda.setText("RONDA " + nivel);
        txt_R_acumulado.setText("ACUMULADO: " + acumulado);
        Query RsRonda = em.createQuery("SELECT r FROM Ronda r WHERE r.nivel = :nivel").setParameter("nivel", nivel);
        List<Ronda> listaRondas = (List<Ronda>) RsRonda.getResultList();
        if (listaRondas.isEmpty()) {
            finJuego();
        } else {
            for (Ronda ronda : listaRondas) {
                categoria = ronda.getCategoriaList().get(0);
                txt_R_categoria.setText("CATEGORIA: " + categoria.getNombre());
                if (categoria != null) {
                    Query RsPregunta = em.createNativeQuery("SELECT * FROM pregunta WHERE Categoria =? ORDER BY rand() LIMIT 1", Pregunta.class).setParameter(1, categoria.getId());
                    List<Pregunta> listaPreguntas = (List<Pregunta>) RsPregunta.getResultList();
                    if (!listaPreguntas.isEmpty()) {
                        for (Pregunta pregunta : listaPreguntas) {
                            txt_R_pregunta.setText(pregunta.getPregunta());
                            Query RsOpcion = em.createNativeQuery("SELECT * FROM opcion WHERE Pregunta =?", Opcion.class).setParameter(1, pregunta.getId());
                            List<Opcion> listaOpciones = (List<Opcion>) RsOpcion.getResultList();
                            if (!listaOpciones.isEmpty()) {
                                for (i = 0; i < listaOpciones.size(); i++) {
                                    opcion = listaOpciones.get(i);
                                    if (i == 0) {
                                        Rbtn_R_opcion1.setText(opcion.getRespuesta());
                                    } else if (i == 1) {
                                        Rbtn_R_opcion2.setText(opcion.getRespuesta());
                                    } else if (i == 2) {
                                        Rbtn_R_opcion3.setText(opcion.getRespuesta());
                                    } else if (i == 3) {
                                        Rbtn_R_opcion4.setText(opcion.getRespuesta());
                                    }
                                    if (opcion.getEstado() == 0) {
                                        RespuestaCorrecta = opcion.getRespuesta();
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    private void comprobarRespuesta() {
        if(Rbtn_R_opcion1.isSelected()){
            if (Rbtn_R_opcion1.getText().equals(RespuestaCorrecta)){
                siguienteNivel();
            }else{
                respuestaIncorrecta();
            }
        }else if(Rbtn_R_opcion2.isSelected()){
            if (Rbtn_R_opcion2.getText().equals(RespuestaCorrecta)) {
                siguienteNivel();
            }else{
                 respuestaIncorrecta();
            }
        }else if(Rbtn_R_opcion3.isSelected()){
            if (Rbtn_R_opcion3.getText().equals(RespuestaCorrecta)) {
                 siguienteNivel();
            }else{
                respuestaIncorrecta();
            }
        }else if(Rbtn_R_opcion4.isSelected()){
            if (Rbtn_R_opcion4.getText().equals(RespuestaCorrecta)) {
                siguienteNivel();
            }else{
                respuestaIncorrecta();
            }
        }
    }

    private void finJuego() {
        JOptionPane.showMessageDialog(null, "Felicidades por lograrlo!!, tu puntaje fue: " + acumulado);
        guardarDatos();
    }

    private void siguienteNivel() {
        acumulado += 100;
        nivel++;
        comenzarJuego();
    }

    private void respuestaIncorrecta() {
        JOptionPane.showMessageDialog(null, "Respuesta incorrecta, vuelve a intentarlo.");
        //guardarDatos();
    }

    private void guardarDatos() {
        cambiarPantalla();
    }
    
    @Override
    public void cambiarPantalla() {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnG_R_grupoBotones;
    private javax.swing.JButton Btn_R_retirar;
    private javax.swing.JButton Btn_R_siguiente;
    private javax.swing.JRadioButton Rbtn_R_opcion1;
    private javax.swing.JRadioButton Rbtn_R_opcion2;
    private javax.swing.JRadioButton Rbtn_R_opcion3;
    private javax.swing.JRadioButton Rbtn_R_opcion4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt_R_acumulado;
    private javax.swing.JLabel txt_R_categoria;
    private javax.swing.JLabel txt_R_pregunta;
    private javax.swing.JLabel txt_R_roda;
    // End of variables declaration//GEN-END:variables

   
}
