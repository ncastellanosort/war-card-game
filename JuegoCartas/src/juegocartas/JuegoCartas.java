package juegocartas;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

/*
 *
 * -- Fusion de cartas, boton fusionar, 2 checkbutton para seleccionar 2 cartas y luego sumar el promedio de las 2
 * y compararlo con el doble del promedio de la carta del computador
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


        int promedio1 = (int) (Math.random() * 320 + 280);
        int promedio2 = (int) (Math.random() * 320 + 280);
        int promedio3 = (int) (Math.random() * 320 + 280);
        int promedio4 = (int) (Math.random() * 320 + 280);
        int promedio5 = (int) (Math.random() * 320 + 280);
        int promedio6 = (int) (Math.random() * 320 + 280);
        int promedio7 = (int) (Math.random() * 320 + 280);

        Dimension nuevoTamanio = new Dimension(122, 248);
        Dimension dimensionLabel = new Dimension(200, 50);


        String rutaCarta1 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen1.png";
        String rutaCarta2 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen2.png";
        String rutaCarta3 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen3.png";
        String rutaCarta4 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen3.png";
        String rutaCarta5 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen3.png";


        final int[] puntajeCompu = {0};
        final int[] puntajeJug = {0};


        JLabel puntajeComputador = new JLabel("Puntaje del Computador: ");

        Font letraPuntajeComputador = new Font(puntajeComputador.getFont().getName(), Font.PLAIN, 23);
        puntajeComputador.setFont(letraPuntajeComputador);


        JLabel puntajeJugador = new JLabel("Puntaje del Jugador: ");
        Font letraPuntajeJugador = new Font(puntajeJugador.getFont().getName(), Font.PLAIN, 23);
        puntajeJugador.setFont(letraPuntajeJugador);


        JLabel tempor = new JLabel(" ");
        Font letraTemporizador = new Font(tempor.getFont().getName(), Font.PLAIN, 25);
        tempor.setFont(letraTemporizador);

        JButton fusionar = new JButton("Fusionar!");

        JButton cartaDelComputador = new ImageButton("Num random: " + promedio1, rutaCarta1);

        JCheckBox checkbox = new JCheckBox(" ");
        checkbox.setVisible(false);
        panel.add(checkbox);

        JCheckBox checkbox2 = new JCheckBox(" ");
        checkbox2.setVisible(false);
        panel.add(checkbox2);


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

                Timer timer = new Timer(800, new ActionListener() {
                    private int cont = 3;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cont >= 1) {
                            tempor.setText(Integer.toString(cont));
                            cont--;
                        } else {
                            ((Timer) e.getSource()).stop();

                            if (checkbox.isSelected()) {
                                if (promedio1 > promedio2) {
                                    System.out.println("Gano el computador");
                                    JLabel res = new JLabel("Gano el computador");
                                    puntajeCompu[0] += 50;
                                    System.out.println(puntajeCompu[0]);
                                    puntajeComputador.setText("Puntaje del Computador: " + Arrays.toString(puntajeCompu));
                                    panel.add(puntajeComputador);

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
                                    puntajeJugador.setText("Puntaje del Jugador: " + Arrays.toString(puntajeJug));

                                    panel.add(puntajeJugador);

                                    res.setHorizontalAlignment(SwingConstants.CENTER);
                                    res.setOpaque(true);
                                    res.setBackground(Color.RED);
                                    res.setPreferredSize(dimensionLabel);

                                    panel.add(res);
                                }
                            }
                        }
                    }
                });
                timer.start();
            }

        });

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

                Timer timer = new Timer(800, new ActionListener() {
                    private int cont = 3;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cont >= 1) {
                            tempor.setText(Integer.toString(cont));
                            cont--;
                        } else {
                            ((Timer) e.getSource()).stop();

                            if (checkbox.isSelected()) {
                                if (promedio1 > promedio2) {
                                    System.out.println("Gano el computador");
                                    JLabel res = new JLabel("Gano el computador");
                                    puntajeCompu[0] += 50;
                                    System.out.println(puntajeCompu[0]);
                                    puntajeComputador.setText("Puntaje del Computador: " + Arrays.toString(puntajeCompu));
                                    panel.add(puntajeComputador);

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
                                    puntajeJugador.setText("Puntaje del Jugador: " + Arrays.toString(puntajeJug));

                                    panel.add(puntajeJugador);

                                    res.setHorizontalAlignment(SwingConstants.CENTER);
                                    res.setOpaque(true);
                                    res.setBackground(Color.RED);
                                    res.setPreferredSize(dimensionLabel);

                                    panel.add(res);
                                }
                            }
                        }
                    }
                });
                timer.start();
            }

        });

        JButton cartaJugador3 = new ImageButton("Num random: " + promedio4, rutaCarta3);
        cartaJugador3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Carta del jugador presionada");
                cartaJugador3.setVisible(false);

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                checkbox.setSelected(true);

                Timer timer = new Timer(800, new ActionListener() {
                    private int cont = 3;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cont >= 1) {
                            tempor.setText(Integer.toString(cont));
                            cont--;
                        } else {
                            ((Timer) e.getSource()).stop();

                            if (checkbox.isSelected()) {
                                if (promedio1 > promedio4) {
                                    System.out.println("Gano el computador");
                                    JLabel res = new JLabel("Gano el computador");
                                    puntajeCompu[0] += 50;
                                    System.out.println(puntajeCompu[0]);
                                    puntajeComputador.setText("Puntaje del Computador: " + Arrays.toString(puntajeCompu));
                                    panel.add(puntajeComputador);

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
                                    puntajeJugador.setText("Puntaje del Jugador: " + Arrays.toString(puntajeJug));

                                    panel.add(puntajeJugador);

                                    res.setHorizontalAlignment(SwingConstants.CENTER);
                                    res.setOpaque(true);
                                    res.setBackground(Color.RED);
                                    res.setPreferredSize(dimensionLabel);

                                    panel.add(res);
                                }
                            }
                        }
                    }
                });
                timer.start();
            }

        });

        JButton cartaJugador4 = new ImageButton("Num random: " + promedio5, rutaCarta3);
        cartaJugador4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Carta del jugador presionada");
                cartaJugador4.setVisible(false);

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                checkbox.setSelected(true);

                Timer timer = new Timer(800, new ActionListener() {
                    private int cont = 3;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cont >= 1) {
                            tempor.setText(Integer.toString(cont));
                            cont--;
                        } else {
                            ((Timer) e.getSource()).stop();

                            if (checkbox.isSelected()) {
                                if (promedio1 > promedio5) {
                                    System.out.println("Gano el computador");
                                    JLabel res = new JLabel("Gano el computador");
                                    puntajeCompu[0] += 50;
                                    System.out.println(puntajeCompu[0]);
                                    puntajeComputador.setText("Puntaje del Computador: " + Arrays.toString(puntajeCompu));
                                    panel.add(puntajeComputador);

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
                                    puntajeJugador.setText("Puntaje del Jugador: " + Arrays.toString(puntajeJug));

                                    panel.add(puntajeJugador);

                                    res.setHorizontalAlignment(SwingConstants.CENTER);
                                    res.setOpaque(true);
                                    res.setBackground(Color.RED);
                                    res.setPreferredSize(dimensionLabel);

                                    panel.add(res);
                                }
                            }
                        }
                    }
                });
                timer.start();
            }

        });

        JButton cartaJugador5 = new ImageButton("Num random: " + promedio6, rutaCarta3);
        cartaJugador5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Carta del jugador presionada");
                cartaJugador5.setVisible(false);

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                checkbox.setSelected(true);

                Timer timer = new Timer(800, new ActionListener() {
                    private int cont = 3;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cont >= 1) {
                            tempor.setText(Integer.toString(cont));
                            cont--;
                        } else {
                            ((Timer) e.getSource()).stop();

                            if (checkbox.isSelected()) {
                                if (promedio1 > promedio6) {
                                    System.out.println("Gano el computador");
                                    JLabel res = new JLabel("Gano el computador");
                                    puntajeCompu[0] += 50;
                                    System.out.println(puntajeCompu[0]);
                                    puntajeComputador.setText("Puntaje del Computador: " + Arrays.toString(puntajeCompu));
                                    panel.add(puntajeComputador);

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
                                    puntajeJugador.setText("Puntaje del Jugador: " + Arrays.toString(puntajeJug));

                                    panel.add(puntajeJugador);

                                    res.setHorizontalAlignment(SwingConstants.CENTER);
                                    res.setOpaque(true);
                                    res.setBackground(Color.RED);
                                    res.setPreferredSize(dimensionLabel);

                                    panel.add(res);
                                }
                            }
                        }
                    }
                });
                timer.start();
            }

        });

        JButton cartaJugador6 = new ImageButton("Num random: " + promedio7, rutaCarta3);
        cartaJugador6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Carta del jugador presionada");
                cartaJugador6.setVisible(false);

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                checkbox.setSelected(true);

                Timer timer = new Timer(800, new ActionListener() {
                    private int cont = 3;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cont >= 1) {
                            tempor.setText(Integer.toString(cont));
                            cont--;
                        } else {
                            ((Timer) e.getSource()).stop();

                            if (checkbox.isSelected()) {
                                if (promedio1 > promedio7) {
                                    System.out.println("Gano el computador");
                                    JLabel res = new JLabel("Gano el computador");
                                    puntajeCompu[0] += 50;
                                    System.out.println(puntajeCompu[0]);
                                    puntajeComputador.setText("Puntaje del Computador: " + Arrays.toString(puntajeCompu));
                                    panel.add(puntajeComputador);

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
                                    puntajeJugador.setText("Puntaje del Jugador: " + Arrays.toString(puntajeJug));

                                    panel.add(puntajeJugador);

                                    res.setHorizontalAlignment(SwingConstants.CENTER);
                                    res.setOpaque(true);
                                    res.setBackground(Color.RED);
                                    res.setPreferredSize(dimensionLabel);

                                    panel.add(res);
                                }
                            }
                        }
                    }
                });
                timer.start();
            }

        });

        cartaDelComputador.setPreferredSize(nuevoTamanio);
        panel.add(cartaDelComputador);

        cartaJugador.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador);

        cartaJugador2.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador2);

        cartaJugador3.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador3);

        cartaJugador4.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador4);

        cartaJugador5.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador5);

        cartaJugador6.setPreferredSize(nuevoTamanio);
        panel.add(cartaJugador6);

        panel.add(puntajeComputador);
        panel.add(puntajeJugador);


        panel.add(fusionar);
        panel.add(tempor);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {

        JuegoCartas ventana = new JuegoCartas();
        ventana.setVisible(true);

    }
}

