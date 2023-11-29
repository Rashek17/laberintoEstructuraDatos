package laberintox;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VentananPrincipal extends JFrame implements ActionListener {

    private final JPanel contentPane;
    private final PanelLaberinto miPanelLaberinto;
    private final JButton btnReset;
    private final JButton btnResolver;

    /**
     * Ivan Andres Guapacha
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    VentananPrincipal frame = new VentananPrincipal();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                } catch (Exception e) {
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentananPrincipal() {
        setTitle("Laberinto Estructura de datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 553, 484);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        miPanelLaberinto = new PanelLaberinto();
        miPanelLaberinto.setBounds(25, 30, 474, 350);
        contentPane.add(miPanelLaberinto);

        btnReset = new JButton("Reset");
        btnReset.setBounds(25, 391, 89, 43);
        contentPane.add(btnReset);
        btnReset.addActionListener(this);

        btnResolver = new JButton("Resolver");
        btnResolver.setBounds(143, 391, 89, 43);
        contentPane.add(btnResolver);
        btnResolver.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReset) {
            miPanelLaberinto.resetearLaberinto();
            this.setVisible(true);
        }
        if (e.getSource() == btnResolver) {
            miPanelLaberinto.resolverLaberinto();
        }

    }
}
