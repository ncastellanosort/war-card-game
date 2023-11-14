package juegocartas;

import java.awt.*;
import java.awt.event.*;
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

        // Promedios de las cartas
        int promedio1 = (int) (Math.random() * 320 + 280);
        int promedio2 = (int) (Math.random() * 320 + 280);
        int promedio3 = (int) (Math.random() * 320 + 280);




        // Tamano de las cartas
        Dimension nuevoTamanio = new Dimension(122, 248);

        // Tamano del label del ganador
        Dimension dimensionLabel = new Dimension(200, 50);

        // Rutas de las cartas
        String rutaCarta1 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen1.png";
        String rutaCarta2 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen2.png";
        String rutaCarta3 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen3.png";

        // El titulo del juego
        JLabel titulo = new JLabel("Inicio del juego.");


        JLabel puntajeComputador = new JLabel(".");
        final JLabel[] puntajeJugador = {new JLabel(".")};

        JLabel tituloCartaCompu = new JLabel("La carta con el texto verde es el computador");
        JLabel tempor = new JLabel("....");


        JButton cartaDelComputador = new ImageButton("Num random: " + promedio1, rutaCarta1);

        JButton fusionar = new JButton("Fusionar!");

        // El checkbox de la seleccion de la carta
        JCheckBox checkbox = new JCheckBox(" ");
        checkbox.setVisible(false);
        panel.add(checkbox);

        // Los puntajes
        final int[] puntajeCompu = {0};
        final int[] puntajeJug = {0};


        // Primer carta del jugador
        JButton cartaJugador = new ImageButton("Num random: " + promedio2, rutaCarta2);
        cartaJugador.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("Carta del jugador presionada");
                cartaJugador.setVisible(false);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                checkbox.setSelected(true);
                if (checkbox.isSelected()) {
//                    System.out.println("Carta seleccionada");

                    for (int i = 3; i > 0; i--) {

                        try {
                            tempor.setText(String.valueOf(i));
                            System.out.println(i);
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }

                    }

                    if (promedio1 > promedio2) {
                        System.out.println("Gano el computador");
                        JLabel res = new JLabel("Gano el computador");
                        puntajeCompu[0] += 50;
                        System.out.println(puntajeCompu[0]);

                        res.setHorizontalAlignment(SwingConstants.CENTER);
                        res.setOpaque(true);
                        res.setBackground(Color.BLUE);
                        res.setPreferredSize(dimensionLabel);

                        panel.add(res);
                    } else {

                        System.out.println("Gano la carta del jugador");
                        JLabel res = new JLabel("Gano la carta del jugador");
                        puntajeJug[0] += 50;
                        System.out.println(puntajeJug[0]);

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

        // Segunda carta del jugador
        JButton cartaJugador2 = new ImageButton("Num random: " + promedio3, rutaCarta3);
        cartaJugador2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Carta del jugador presionada");
                cartaJugador2.setVisible(false);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                checkbox.setSelected(true);
                if (checkbox.isSelected()) {
//                    System.out.println("Carta seleccionada");

                    for (int i = 3; i > 0; i--) {

                        try {
                            tempor.setText(String.valueOf(i));
                            System.out.println(i);
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }

                    }

                    if (promedio1 > promedio3) {
                        System.out.println("Gano el computador");
                        JLabel res = new JLabel("Gano el computador");
                        puntajeCompu[0] += 50;
                        System.out.println(puntajeCompu[0]);

                        res.setHorizontalAlignment(SwingConstants.CENTER);
                        res.setOpaque(true);
                        res.setBackground(Color.BLUE);
                        res.setPreferredSize(dimensionLabel);

                        panel.add(res);
                    } else {

                        System.out.println("Gano la carta del jugador");
                        JLabel res = new JLabel("Gano la carta del jugador");
                        puntajeJug[0] += 50;
                        System.out.println(puntajeJug[0]);

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

        // Agregar las cartas
        cartaDelComputador.setPreferredSize(nuevoTamanio);
        panel.add(cartaDelComputador);

        cartaJugador.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador);

        cartaJugador2.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador2);


        // Agregar las otras cosas
        panel.add(titulo);
        panel.add(fusionar);
        panel.add(tituloCartaCompu);
        panel.add(tempor);

        panel.add(puntajeComputador);
        panel.add(puntajeJugador[0]);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {

        JuegoCartas ventana = new JuegoCartas();
        ventana.setVisible(true);

    }
}
