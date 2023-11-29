package laberintox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public final class PanelLaberinto extends JPanel implements ActionListener {

    private JPanel miPanel;
    private JButton[][] btnLaberinto;
    private char[][] matrizSolucion;
    Laberinto miLaberinto;

    /**
     * Create the panel.
     */
    public PanelLaberinto() {

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));

        miLaberinto = new Laberinto();

        miPanel = new JPanel();
        miPanel.setLayout(new GridLayout(miLaberinto.obtenerlongitudI(), miLaberinto.obtenerLongitudJ()));

        btnLaberinto = new JButton[miLaberinto.obtenerlongitudI()][miLaberinto.obtenerLongitudJ()];

        inicializarMatriz();
        add(miPanel, BorderLayout.CENTER);

    }

    public void resolverLaberinto() {
        if (miLaberinto.isEstadoEntrada() == true && miLaberinto.isEstadoSalida() == true) {
            matrizSolucion = miLaberinto.resolver();
            pintarSolucion();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleciona la salida y la llegada");
        }
    }

    public void pintarSolucion() {
        for (int i = 0; i < btnLaberinto.length; i++) {
            for (int j = 0; j < btnLaberinto[0].length; j++) {
                if (matrizSolucion[i][j] == '*') {
                    btnLaberinto[i][j].setText(matrizSolucion[i][j] + "");
                    btnLaberinto[i][j].setBackground(Color.GREEN);
                }
            }
        }
    }

    public void resetearLaberinto() {
        miLaberinto.laberintoBase();
        miLaberinto.setEstadoEntrada(false);
        miLaberinto.setEstadoSalida(false);
        resetearMatriz();
    }

    public void resetearMatriz() {
        for (int i = 0; i < btnLaberinto.length; i++) {
            for (int j = 0; j < btnLaberinto[0].length; j++) {
                if (miLaberinto.getLaberinto()[i][j] == '#') {
                    btnLaberinto[i][j].setBackground(new Color(74, 84, 92));
                } else {

                    btnLaberinto[i][j].setBackground(null);
                }
                btnLaberinto[i][j].setText(miLaberinto.getLaberinto()[i][j] + "");

            }
        }
    }

    public void inicializarMatriz() {
        for (int i = 0; i < btnLaberinto.length; i++) {
            for (int j = 0; j < btnLaberinto[0].length; j++) {
                if (miLaberinto.getLaberinto()[i][j] == '#') {
                    btnLaberinto[i][j] = new JButton(miLaberinto.getLaberinto()[i][j] + "");
                    btnLaberinto[i][j].setBackground(new Color(74, 84, 92));
                } else {
                    btnLaberinto[i][j] = new JButton(miLaberinto.getLaberinto()[i][j] + "");
                }

                miPanel.add(btnLaberinto[i][j]);
                btnLaberinto[i][j].addActionListener(this);

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < btnLaberinto.length; i++) {
            for (int j = 0; j < btnLaberinto[0].length; j++) {
                if (e.getSource() == btnLaberinto[i][j]) {
                    if (miLaberinto.getLaberinto()[i][j] == '#') {
                        JOptionPane.showMessageDialog(this, "Es un muro !");
                    } else {
                        if (miLaberinto.isEstadoEntrada() == false) {
                            btnLaberinto[i][j].setText("S");
                            miLaberinto.setEstadoEntrada(true);
                            miLaberinto.setEntradaI(i);
                            miLaberinto.setEntradaJ(j);
                        } else if (miLaberinto.isEstadoEntrada() == true
                                && miLaberinto.isEstadoSalida() == false) {
                            btnLaberinto[i][j].setText("X");
                            miLaberinto.setSalidaI(i);
                            miLaberinto.setSalidaJ(j);
                            miLaberinto.setEstadoSalida(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Ya esta la salida y la llegada");
                        }
                    }
                }
            }
        }

    }

}
