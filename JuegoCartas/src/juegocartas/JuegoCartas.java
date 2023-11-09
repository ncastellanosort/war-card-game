package juegocartas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



class ImageButton extends JButton {
    private Image backgroundImage;
    private boolean pres = false;

    public ImageButton(String text, String imagePath) {
        super(text);
        this.backgroundImage = new ImageIcon(imagePath).getImage();
        setContentAreaFilled(false);
        pres = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    
    public boolean isPresionado() {
        return pres;
    }
}



public class JuegoCartas extends JFrame{
    public JuegoCartas() {
        
        setTitle("Titulo");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel panel = new JPanel();
        
        
        int promedio1 = (int)(Math.random()*302+290);
        
        int promedio2 = (int)(Math.random()*302+290);
        
        
        Dimension nuevoTamanio = new Dimension(122, 248);
        
        Dimension dimensionLabel = new Dimension(200, 50);
           
        
        
        String rutaCarta1 = "C:\\Users\\Practica\\Documents\\NetBeansProjects\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen1.png";
        
        String rutaCarta2 = "C:\\Users\\Practica\\Documents\\NetBeansProjects\\JuegoCartas\\src\\juegocartas\\imagenes\\imagen2.png";
        
        JButton carta = new ImageButton("Num random: " + promedio1, rutaCarta1);
        
        carta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("Botón presionado");
                carta.setVisible(false);
                boolean presionado = false;
                
            }
        });
        
       
        
        JButton boton = new ImageButton("Num random: " + promedio2, rutaCarta2);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("Botón presionado");
                boton.setVisible(false);
                
            }
        });
        
        

        
        if(promedio1 > promedio2){
            System.out.println("Gano la carta del jugador 1");
            JLabel res = new JLabel("Gano la carta del jugador 1");
            
            res.setHorizontalAlignment(SwingConstants.CENTER);
            res.setOpaque(true);
            res.setBackground(Color.BLUE);
            res.setPreferredSize(dimensionLabel);
            
            
            
            panel.add(res);
        }else{
            
            System.out.println("Gano la carta del jugador 2");
            JLabel res = new JLabel("Gano la carta del jugador 2");
            
            
            res.setHorizontalAlignment(SwingConstants.CENTER);
            res.setOpaque(true);
            res.setBackground(Color.RED);
            res.setPreferredSize(dimensionLabel);
            
            
            panel.add(res);
       
        
        } 
        
        boton.setPreferredSize(nuevoTamanio);
        panel.add(boton);
        
        carta.setPreferredSize(nuevoTamanio);
        panel.add(carta);
        
       
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        
       
       JuegoCartas ventana = new JuegoCartas();
       ventana.setVisible(true);

    }
}
