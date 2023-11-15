package juegocartas;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import java.util.Random;

class FondoPanel extends JPanel {
    private Image imagenFondo;

    public FondoPanel(String imagePath) {
        this.imagenFondo = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}

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

class Login2 extends JFrame {
    public Login2() {
        setTitle("WAR CARD GAME");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FondoPanel panel2 = new FondoPanel("C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagenMenu.jpeg");

        JTextField campoNombre = new JTextField();
        JTextField campoEdad = new JTextField();

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel labelNombre = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(labelNombre, gbc);

        campoNombre.setPreferredSize(new Dimension(350, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelFormulario.add(campoNombre, gbc);

        JLabel labelEdad = new JLabel("Edad:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(labelEdad, gbc);

        campoEdad.setPreferredSize(new Dimension(350, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelFormulario.add(campoEdad, gbc);

        JButton boton = new JButton("QUE INICIEN LOS DESAPARECIDOS");
        Dimension tamanosBotonLogin = new Dimension(400, 70);
        boton.setBackground(Color.BLACK);
        boton.setForeground(Color.WHITE);
        boton.setPreferredSize(tamanosBotonLogin);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoCartas game = new JuegoCartas();
                game.setVisible(true);
                dispose();
            }
        });

        panel2.setLayout(new BorderLayout());
        panel2.add(panelFormulario, BorderLayout.NORTH);
        panel2.add(boton, BorderLayout.SOUTH);


        setLocationRelativeTo(null);

        Font letraLabels = new Font(labelNombre.getFont().getName(), Font.PLAIN, 23);
        labelNombre.setFont(letraLabels);
        labelNombre.setForeground(Color.black);

        Font letraLabels2 = new Font(labelEdad.getFont().getName(), Font.PLAIN, 23);
        labelEdad.setFont(letraLabels2);
        labelEdad.setForeground(Color.black);

        Font letraBoton = new Font(boton.getFont().getName(), Font.PLAIN, 25);
        boton.setFont(letraBoton);

        getContentPane().add(panel2);

    }
}

public class JuegoCartas extends JFrame {

    private JButton cartaJugador6;
    private JButton cartaJugador2;
    private JButton cartaJugador7;

    public JuegoCartas() {


        setTitle("WAR CARD GAME");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel panel = new JPanel();
        FondoPanel panel = new FondoPanel("C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\fondo.jpg");

        Random rand = new Random();


        int promedio1 = rand.nextInt(350) + 280;
        int promedio2 = rand.nextInt(350) + 280;
        int promedio3 = rand.nextInt(350) + 280;
        int promedio4 = rand.nextInt(350) + 280;
        int promedio5 = rand.nextInt(350) + 280;
        int promedio6 = rand.nextInt(350) + 280;
        int promedio7 = rand.nextInt(350) + 280;
        int promedio8 = rand.nextInt(350) + 280;

        Dimension nuevoTamanio = new Dimension(122, 248);
        Dimension dimensionLabel = new Dimension(200, 50);
        Dimension tamanoTempor = new Dimension(50, 50);
        Dimension dimensionLabelPuntajes = new Dimension(400, 50);


        String rutaCarta1 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen1comp.png";
        String rutaCarta2 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen1a.png";
        String rutaCarta3 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen2a.png";
        String rutaCarta4 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen3a.png";
        String rutaCarta5 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen4a.png";
        String rutaCarta6 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen5a.png";
        String rutaCarta7 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen6a.png";
        String rutaCarta8 = "C:\\Users\\Nicolas\\Documents\\Code\\Intellij\\juegodecartaslindo\\JuegoCartas\\src\\juegocartas\\imagenes\\imagenFusionada1.png";


        final int[] puntajeCompu = {0};
        final int[] puntajeJug = {0};


        JLabel puntajeComputador = new JLabel("Puntaje del Computador: ");
        puntajeComputador.setHorizontalAlignment(SwingConstants.CENTER);
        puntajeComputador.setOpaque(true);
        puntajeComputador.setBackground(Color.LIGHT_GRAY);
        puntajeComputador.setPreferredSize(dimensionLabelPuntajes);
        Font letraPuntajeComputador = new Font(puntajeComputador.getFont().getName(), Font.PLAIN, 23);
        puntajeComputador.setFont(letraPuntajeComputador);


        JLabel puntajeJugador = new JLabel("Puntaje del Jugador: ");
        puntajeJugador.setHorizontalAlignment(SwingConstants.CENTER);
        puntajeJugador.setOpaque(true);
        puntajeJugador.setBackground(Color.GRAY);
        puntajeJugador.setPreferredSize(dimensionLabelPuntajes);
        Font letraPuntajeJugador = new Font(puntajeJugador.getFont().getName(), Font.PLAIN, 23);
        puntajeJugador.setFont(letraPuntajeJugador);


        JLabel tempor = new JLabel(" ");

        tempor.setHorizontalAlignment(SwingConstants.CENTER);
        tempor.setOpaque(true);
        tempor.setBackground(Color.BLACK);
        tempor.setPreferredSize(tamanoTempor);
        Font letraTemporizador = new Font(tempor.getFont().getName(), Font.PLAIN, 35);
        tempor.setForeground(Color.WHITE);
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
                                    res.setForeground(Color.WHITE);
                                    res.setBackground(Color.BLACK);
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
                                    res.setBackground(Color.GRAY);
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

        cartaJugador2 = new ImageButton("Num random: " + promedio3, rutaCarta3);
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
                                    res.setForeground(Color.WHITE);
                                    res.setBackground(Color.BLACK);
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
                                    res.setBackground(Color.GRAY);
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

        JButton cartaJugador3 = new ImageButton("Num random: " + promedio4, rutaCarta4);
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
                                    res.setForeground(Color.WHITE);
                                    res.setBackground(Color.BLACK);
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
                                    res.setBackground(Color.GRAY);
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

        JButton cartaJugador4 = new ImageButton("Num random: " + promedio5, rutaCarta5);
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
                                    res.setForeground(Color.WHITE);
                                    res.setBackground(Color.BLACK);
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
                                    res.setBackground(Color.GRAY);
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

        JButton cartaJugador5 = new ImageButton("Num random: " + promedio6, rutaCarta6);
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
                                    res.setForeground(Color.WHITE);
                                    res.setBackground(Color.BLACK);
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
                                    res.setBackground(Color.GRAY);
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

        cartaJugador6 = new ImageButton("Num random: " + promedio7, rutaCarta7);
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
                                    res.setForeground(Color.WHITE);
                                    res.setBackground(Color.BLACK);
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
                                    res.setBackground(Color.GRAY);
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


        fusionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Carta del jugador presionada");
                cartaJugador6.setVisible(false);
                cartaJugador2.setVisible(false);
                cartaJugador7 = new ImageButton("Num Random: " + promedio8, rutaCarta8);
                cartaJugador7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Carta del jugador presionada");
                        cartaJugador7.setVisible(false);

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
                                            res.setForeground(Color.WHITE);
                                            res.setBackground(Color.BLACK);
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
                                            res.setBackground(Color.GRAY);
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
                panel.add(cartaJugador7);
                cartaJugador7.setVisible(true);
                cartaJugador7.setPreferredSize(nuevoTamanio);
                panel.revalidate();
                panel.repaint();
            }
        });

        JPanel panelBotonesJugador = new JPanel();
        panelBotonesJugador.add(cartaJugador);
        panelBotonesJugador.add(cartaJugador2);
        panelBotonesJugador.add(cartaJugador3);
        panelBotonesJugador.add(cartaJugador4);
        panelBotonesJugador.add(cartaJugador5);
        panelBotonesJugador.add(cartaJugador6);


        cartaDelComputador.setPreferredSize(nuevoTamanio);
        panel.add(cartaDelComputador);

        cartaJugador.setPreferredSize(nuevoTamanio);
        cartaJugador2.setPreferredSize(nuevoTamanio);
        cartaJugador3.setPreferredSize(nuevoTamanio);
        cartaJugador4.setPreferredSize(nuevoTamanio);
        cartaJugador5.setPreferredSize(nuevoTamanio);
        cartaJugador6.setPreferredSize(nuevoTamanio);

        panel.add(puntajeComputador);
        panel.add(fusionar);
        panel.add(tempor);

        panel.add(panelBotonesJugador, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        Login2 login = new Login2();
        login.setVisible(true);

    }
}

