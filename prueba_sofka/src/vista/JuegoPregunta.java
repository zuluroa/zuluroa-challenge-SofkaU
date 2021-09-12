/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.JugadorJpaController;
import controlador.RondaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Jugador;
import modelo.Opcion;
import modelo.Pregunta;
import modelo.Premio;
import modelo.Ronda;

/**
 *
 * @author zulur
 */
public class JuegoPregunta extends javax.swing.JFrame implements ICambiaVentana {

    private Opcion opcion = new Opcion();
    private Categoria categoria = new Categoria();
    private Jugador jugador = new Jugador();
    private Premio premio = new Premio();
    private String RespuestaCorrecta = "", nombreJugador = "", TipoPremio = "";
    private int acumulado = 0, nivel = 0, i = 0;
    private final RondaJpaController controladorRonda = new RondaJpaController();
    private final JugadorJpaController controladorJugador = new JugadorJpaController();
    private final EntityManager em = controladorRonda.getEntityManager();

    public JuegoPregunta() {

    }

    public JuegoPregunta(String nombreJugador, String TipoPremio) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.nombreJugador = nombreJugador;
        this.TipoPremio = TipoPremio;

        nivel = 1;

        Iniciar();
        comenzarJuego();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbg_JP_grupoBotones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txt_JP_roda = new javax.swing.JLabel();
        txt_JP_acumulado = new javax.swing.JLabel();
        txt_JP_pregunta = new javax.swing.JLabel();
        Rbtn_JP_opcion1 = new javax.swing.JRadioButton();
        Rbtn_JP_opcion2 = new javax.swing.JRadioButton();
        Rbtn_JP_opcion3 = new javax.swing.JRadioButton();
        Rbtn_JP_opcion4 = new javax.swing.JRadioButton();
        btn_JP_retirar = new javax.swing.JButton();
        txt_JP_categoria = new javax.swing.JLabel();
        btn_JP_siguiente = new javax.swing.JButton();
        txt_JP_premio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_JP_roda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_JP_roda.setText("RONDA 1");

        txt_JP_acumulado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_JP_acumulado.setText("ACUMULADO");

        txt_JP_pregunta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_JP_pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_JP_pregunta.setText("¿Cuál es la nación más pequeña del mundo?");

        Rbtn_JP_opcion1.setText("Andorra");

        Rbtn_JP_opcion2.setText("Mónaco");

        Rbtn_JP_opcion3.setText("El Vaticano");

        Rbtn_JP_opcion4.setText("Alaska");

        btn_JP_retirar.setText("RETIRARSE");
        btn_JP_retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_JP_retirarActionPerformed(evt);
            }
        });

        txt_JP_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_JP_categoria.setText("CATEGORIA");

        btn_JP_siguiente.setText("SIGUIENTE");
        btn_JP_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_JP_siguienteActionPerformed(evt);
            }
        });

        txt_JP_premio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_JP_premio.setText("PREMIO A CONSEGUIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(txt_JP_roda))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btn_JP_retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btn_JP_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rbtn_JP_opcion1)
                            .addComponent(Rbtn_JP_opcion2)
                            .addComponent(Rbtn_JP_opcion3)
                            .addComponent(Rbtn_JP_opcion4)
                            .addComponent(txt_JP_pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_JP_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_JP_acumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_JP_premio, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txt_JP_roda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(txt_JP_premio, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_JP_acumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_JP_categoria)
                .addGap(36, 36, 36)
                .addComponent(txt_JP_pregunta)
                .addGap(38, 38, 38)
                .addComponent(Rbtn_JP_opcion1)
                .addGap(18, 18, 18)
                .addComponent(Rbtn_JP_opcion2)
                .addGap(18, 18, 18)
                .addComponent(Rbtn_JP_opcion3)
                .addGap(18, 18, 18)
                .addComponent(Rbtn_JP_opcion4)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_JP_retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_JP_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_JP_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_JP_siguienteActionPerformed
        comprobarRespuesta();
    }//GEN-LAST:event_btn_JP_siguienteActionPerformed

    private void btn_JP_retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_JP_retirarActionPerformed
        JOptionPane.showMessageDialog(null, "Es una pena que te vayas..., pero no te preocupes, tus datos serán guardados.");
        nivel--;
        guardarDatos();
    }//GEN-LAST:event_btn_JP_retirarActionPerformed

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

    @Override
    public void cambiarVentana() {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }

    private void Iniciar() {

        txt_JP_premio.setText(TipoPremio + " A CONSEGUIR: 100");

        rbg_JP_grupoBotones.add(Rbtn_JP_opcion1);
        rbg_JP_grupoBotones.add(Rbtn_JP_opcion2);
        rbg_JP_grupoBotones.add(Rbtn_JP_opcion3);
        rbg_JP_grupoBotones.add(Rbtn_JP_opcion4);
    }

    private void comenzarJuego() {
        if (nivel == 5) {
            btn_JP_siguiente.setText("FINALIZAR");
        }
        txt_JP_roda.setText("RONDA " + nivel);
        txt_JP_acumulado.setText("ACUMULADO: " + acumulado);
        Query RsRonda = em.createQuery("SELECT r FROM Ronda r WHERE r.nivel = :nivel").setParameter("nivel", nivel);
        List<Ronda> listaRondas = (List<Ronda>) RsRonda.getResultList();
        for (Ronda ronda : listaRondas) {
            categoria = ronda.getCategoriaList().get(0);
            txt_JP_categoria.setText("CATEGORIA: " + categoria.getNombre());
            if (categoria != null) {
                Query RsPregunta = em.createNativeQuery("SELECT * FROM pregunta WHERE Categoria =? ORDER BY rand() LIMIT 1", Pregunta.class).setParameter(1, categoria.getId());
                List<Pregunta> listaPreguntas = (List<Pregunta>) RsPregunta.getResultList();
                if (!listaPreguntas.isEmpty()) {
                    for (Pregunta pregunta : listaPreguntas) {
                        txt_JP_pregunta.setText(pregunta.getPregunta());
                        Query RsOpcion = em.createNativeQuery("SELECT * FROM opcion WHERE Pregunta =?", Opcion.class).setParameter(1, pregunta.getId());
                        List<Opcion> listaOpciones = (List<Opcion>) RsOpcion.getResultList();
                        if (!listaOpciones.isEmpty()) {
                            for (i = 0; i < listaOpciones.size(); i++) {
                                opcion = listaOpciones.get(i);
                                if (i == 0) {
                                    Rbtn_JP_opcion1.setText(opcion.getRespuesta());
                                } else if (i == 1) {
                                    Rbtn_JP_opcion2.setText(opcion.getRespuesta());
                                } else if (i == 2) {
                                    Rbtn_JP_opcion3.setText(opcion.getRespuesta());
                                } else if (i == 3) {
                                    Rbtn_JP_opcion4.setText(opcion.getRespuesta());
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

    private void comprobarRespuesta() {
        if (Rbtn_JP_opcion1.isSelected()) {
            if (Rbtn_JP_opcion1.getText().equals(RespuestaCorrecta)) {
                siguienteNivel();
            } else {
                respuestaIncorrecta();
            }
        } else if (Rbtn_JP_opcion2.isSelected()) {
            if (Rbtn_JP_opcion2.getText().equals(RespuestaCorrecta)) {
                siguienteNivel();
            } else {
                respuestaIncorrecta();
            }
        } else if (Rbtn_JP_opcion3.isSelected()) {
            if (Rbtn_JP_opcion3.getText().equals(RespuestaCorrecta)) {
                siguienteNivel();
            } else {
                respuestaIncorrecta();
            }
        } else if (Rbtn_JP_opcion4.isSelected()) {
            if (Rbtn_JP_opcion4.getText().equals(RespuestaCorrecta)) {
                siguienteNivel();
            } else {
                respuestaIncorrecta();
            }
        }
        rbg_JP_grupoBotones.clearSelection();
    }

    private void finJuego() {
        JOptionPane.showMessageDialog(null, "Felicidades por lograrlo!!,  tu puntaje fue: " + acumulado);
        guardarDatos();
    }

    private void siguienteNivel() {
        acumulado += 100;
        nivel++;
        if(nivel > 5){
            finJuego();
        }else{
            comenzarJuego();
        }
    }

    private void respuestaIncorrecta() {
        JOptionPane.showMessageDialog(null, "Respuesta incorrecta, vuelve a intentarlo.");
        cambiarVentana();
    }

    private void guardarDatos() {
        Query RsPremio = em.createQuery("SELECT p FROM Premio p WHERE p.tipoPremio = :tipoPremio").setParameter("tipoPremio", TipoPremio);
        List<Premio> listaPremios = (List<Premio>) RsPremio.getResultList();
        int idPremio = 0;
        for (Premio premio : listaPremios) {
            idPremio = premio.getId();
        }
        Query RsRonda = em.createQuery("SELECT r FROM Ronda r WHERE r.nivel = :nivel").setParameter("nivel", nivel);
        List<Ronda> listaRondas = (List<Ronda>) RsRonda.getResultList();
        int idRonda = 0;
        for (Ronda ronda : listaRondas) {
            idRonda = ronda.getId();
        }
        jugador.setNombre(nombreJugador);
        jugador.setPremio(new Premio(idPremio));
        jugador.setAcomulado(String.valueOf(acumulado));
        jugador.setRonda(new Ronda(idRonda));
        controladorJugador.create(jugador);
        cambiarVentana();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Rbtn_JP_opcion1;
    private javax.swing.JRadioButton Rbtn_JP_opcion2;
    private javax.swing.JRadioButton Rbtn_JP_opcion3;
    private javax.swing.JRadioButton Rbtn_JP_opcion4;
    private javax.swing.JButton btn_JP_retirar;
    private javax.swing.JButton btn_JP_siguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup rbg_JP_grupoBotones;
    private javax.swing.JLabel txt_JP_acumulado;
    private javax.swing.JLabel txt_JP_categoria;
    private javax.swing.JLabel txt_JP_pregunta;
    private javax.swing.JLabel txt_JP_premio;
    private javax.swing.JLabel txt_JP_roda;
    // End of variables declaration//GEN-END:variables

}
