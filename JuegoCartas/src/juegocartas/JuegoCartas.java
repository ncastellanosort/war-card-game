package juegocartas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/*
*
* -- Fusion de cartas, boton fusionar, 2 checkbutton para seleccionar 2 cartas y luego sumar el promedio de las 2
* -- Intentar ponerlo en la interfaz linda
* -- Hacer un contador, que a partir de cada ronda que gane algun jugador, le sume el puntaje y mostrarlo al final
*    si gano o perdio
*
* */


class ImageButton extends JButton {
    private Image backgroundImage;

    public ImageButton(String text, String imagePath) {
        super(text);
        this.backgroundImage = new ImageIcon(imagePath).getImage();
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

public class JuegoCartas extends JFrame {
    public JuegoCartas() {

        setTitle("Titulo");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();


        int promedio1 = (int) (Math.random() * 302 + 290);

        int promedio2 = (int) (Math.random() * 302 + 290);


        Dimension nuevoTamanio = new Dimension(122, 248);

        Dimension dimensionLabel = new Dimension(200, 50);


        String rutaCarta1 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen1.png";

        String rutaCarta2 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen2.png";

        JLabel titulo = new JLabel("Empezo el juego");
        JLabel tituloCartaCompu = new JLabel("La carta con el texto verde es el computador");
        JLabel tempor = new JLabel("....");

        JButton cartaDelComputador = new ImageButton("Num random: " + promedio1, rutaCarta1);

        JCheckBox checkbox = new JCheckBox(" ");
        checkbox.setVisible(false);
        panel.add(checkbox);

        cartaDelComputador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Carta Del Computador presionada");
                cartaDelComputador.setVisible(false);

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                checkbox.setSelected(true);
                if (checkbox.isSelected()) {
                    System.out.println("Carta seleccionada");


                    for (int i = 3; i > 0; i--) {

                        try {
                            tempor.setText(String.valueOf(i));
                            System.out.println(i);
                            Thread.sleep(1 * 1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }

                    }


                    if (promedio1 > promedio2) {
                        System.out.println("Gano el computador");
                        JLabel res = new JLabel("Gano el computador");

                        res.setHorizontalAlignment(SwingConstants.CENTER);
                        res.setOpaque(true);
                        res.setBackground(Color.BLUE);
                        res.setPreferredSize(dimensionLabel);

                        panel.add(res);
                    } else {

                        System.out.println("Gano la carta del jugador 2");
                        JLabel res = new JLabel("Gano la carta del jugador 2");

                        res.setHorizontalAlignment(SwingConstants.CENTER);
                        res.setOpaque(true);
                        res.setBackground(Color.RED);
                        res.setPreferredSize(dimensionLabel);

                        panel.add(res);

                    }

                }

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                checkbox.setSelected(false);
            }
        });

        JButton cartaJugador = new ImageButton("Num random: " + promedio2, rutaCarta2);
        cartaJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón boton presionado");
                cartaJugador.setVisible(false);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                checkbox.setSelected(true);
                if (checkbox.isSelected()) {
                    System.out.println("Carta seleccionada");

                    if (promedio1 > promedio2) {
                        System.out.println("Gano el computador");
                        JLabel res = new JLabel("Gano el computador");

                        res.setHorizontalAlignment(SwingConstants.CENTER);
                        res.setOpaque(true);
                        res.setBackground(Color.BLUE);
                        res.setPreferredSize(dimensionLabel);

                        panel.add(res);
                    } else {

                        System.out.println("Gano la carta del jugador 2");
                        JLabel res = new JLabel("Gano la carta del jugador 2");

                        res.setHorizontalAlignment(SwingConstants.CENTER);
                        res.setOpaque(true);
                        res.setBackground(Color.RED);
                        res.setPreferredSize(dimensionLabel);

                        panel.add(res);

                    }

                }

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                checkbox.setSelected(false);
            }
        });


        cartaJugador.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador);

        cartaDelComputador.setPreferredSize(nuevoTamanio);
        panel.add(cartaDelComputador);

        panel.add(titulo);
        panel.add(tituloCartaCompu);
        panel.add(tempor);


        getContentPane().add(panel);
    }

    public static void main(String[] args) throws InterruptedException {

        JuegoCartas ventana = new JuegoCartas();
        ventana.setVisible(true);

    }
}
