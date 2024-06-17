package com.tc.gui;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.tc.afd.Maquina;
import com.tc.afd.State;

public class VendingMachineGUI extends JFrame {
    private Font customFont, customFont2;
    private JPanelImage panel, afdimage;
    private JPanel panelButtons;
    private JLabel titleLabel;
    RoundedBorder blackBorder, whiteborder,  transparentBorder, greenCircleBorder1, greenCircleBorder2;
    JLabel p1, p2, p3, p4, p5, p6, p7, p8, p9;
    JTextField precio;
    JLabel mo1, mo2, mo5;
    ImageIcon m1, m2, m5, jop, jope;
    Maquina maquina = new Maquina();
    JLabel verificar;
    JLabel O, C0, C1, C2, C5, B0, B1, B2, B3, B5, B6, A0, A1, A2, A3, A4, A5, A6, A7;

    public VendingMachineGUI() {
        this.setSize(988,644);
        this.setTitle("Maquina Expendedora");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        ImageIcon icono = new ImageIcon("resources/images/icon.jpg");
        Image Logo= icono.getImage();
        this.setIconImage(Logo);
        try{
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/HyliaSerif.ttf")).deriveFont(24f);
            customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/HyliaSerif.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                
                // Registrar la fuente
            ge.registerFont(customFont);
            ge.registerFont(customFont2);
        } catch (FontFormatException e) {
            System.out.println("La fuente no tiene un formato correcto: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de la fuente: " + e.getMessage());
            e.printStackTrace();
        }
        this.initComponents();
    }

    private void initComponents(){
        this.setConstans();
        this.addPanel();
        this.setCirculeState();
        this.setImage();
        this.addLabel();
        this.add_mouse_listener_products();
    }

    private void setImage(){
        m1 = new ImageIcon("./resources/images/mo1.png");
        m2 = new ImageIcon("./resources/images/mo2.png");
        m5 = new ImageIcon("./resources/images/mo5.png");
        jop = new ImageIcon("./resources/images/joption.jpg");
        jope = new ImageIcon("./resources/images/end.jpg");

    }

    private void setConstans(){
        blackBorder = new RoundedBorder(Color.BLACK, 10, 3);
        whiteborder = new RoundedBorder(Color.WHITE, 10, 3);
        transparentBorder = new RoundedBorder(new Color(0, 0, 0, 0), 3, 1); // Borde transparente
        greenCircleBorder1 = new RoundedBorder(Color.GREEN, 86, 4);
        greenCircleBorder2 = new RoundedBorder(Color.GREEN, 59, 5);
    }

    private void addPanel(){

        panel = new JPanelImage("Machine.jpg");
        panel.setLayout(null);
        panel.setBounds(0, 0, 515,644);
        this.getContentPane().add(panel);

        afdimage = new JPanelImage("AFD.jpg");
        afdimage.setLayout(null);
        afdimage.setBounds(515, 0, 473,544);
        this.getContentPane().add(afdimage);

        panelButtons = new JPanel();
        panelButtons.setLayout(null);
        panelButtons.setBounds(515, 544, 473, 100);
        panelButtons.setBackground(Color.WHITE);
        this.getContentPane().add(panelButtons);
        
    }

    private void addLabel(){
        titleLabel = new JLabel("Maquina Expendedora");
        titleLabel.setBounds(127, 40, 260, 35);
        titleLabel.setFont(customFont);
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        precio = new JTextField("Precio: 0$");
        precio.setBounds(520, 544, 463, 60);
        precio.setFont(customFont);
        precio.setForeground(Color.BLACK);
        precio.setBackground(Color.WHITE);
        precio.setBorder(transparentBorder);
        precio.setEditable(false);
        panelButtons.add(precio);

        p1 = new JLabel("");
        p1.setBounds(200, 237, 40, 56);
        panel.add(p1);

        p2 = new JLabel("");
        p2.setBounds(254, 237, 40, 56);
        panel.add(p2);

        p3 = new JLabel("");
        p3.setBounds(306, 237, 40, 56);
        panel.add(p3);

        p4 = new JLabel("");
        p4.setBounds(195, 303, 50, 56);
        panel.add(p4);

        p5 = new JLabel("");
        p5.setBounds(249, 303, 50, 56);
        panel.add(p5);

        p6 = new JLabel("");
        p6.setBounds(306, 303, 40, 56);
        panel.add(p6);

        p7 = new JLabel("");
        p7.setBounds(200, 369, 40, 56);
        panel.add(p7);

        p8 = new JLabel("");
        p8.setBounds(254, 369, 40, 56);
        panel.add(p8);

        p9 = new JLabel("");
        p9.setBounds(306, 369, 40, 56);
        panel.add(p9);

        
        mo1 = new JLabel("");
        mo1.setBounds(400, 130, 80, 112);
        mo1.setIcon(new ImageIcon(m1.getImage().getScaledInstance(mo1.getWidth(), mo1.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(mo1);

        mo2 = new JLabel("");
        mo2.setBounds(400, 250, 80, 112);
        mo2.setIcon(new ImageIcon(m2.getImage().getScaledInstance(mo2.getWidth(), mo2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(mo2);

        mo5 = new JLabel("");
        mo5.setBounds(400, 370, 80, 112);
        mo5.setIcon(new ImageIcon(m5.getImage().getScaledInstance(mo5.getWidth(), mo5.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(mo5);


        verificar = new JLabel("Comprar");
        verificar.setBounds(400, 500, 110, 50);
        verificar.setFont(customFont);
        verificar.setForeground(Color.WHITE);
        verificar.setBorder(whiteborder);
        panel.add(verificar);
    }

    private void transparentallstates(){
        O.setBorder(transparentBorder);
        C0.setBorder(transparentBorder);
        C1.setBorder(transparentBorder);
        C2.setBorder(transparentBorder);
        C5.setBorder(transparentBorder);
        A0.setBorder(transparentBorder);
        A1.setBorder(transparentBorder);
        A2.setBorder(transparentBorder);
        A3.setBorder(transparentBorder);
        A4.setBorder(transparentBorder);
        A5.setBorder(transparentBorder);
        A6.setBorder(transparentBorder);
        A7.setBorder(transparentBorder);
        B0.setBorder(transparentBorder);
        B1.setBorder(transparentBorder);
        B2.setBorder(transparentBorder);
        B3.setBorder(transparentBorder);
        B5.setBorder(transparentBorder);
        B6.setBorder(transparentBorder);
        
    }

    private void setCirculeState(){
        O = new JLabel("");
        // O.setBounds(535, 240, 85, 85);
        O.setBounds(20, 239, 86, 86);
        O.setBorder(greenCircleBorder1);
        this.afdimage.add(O);

        C0 = new JLabel("");
        C0.setBounds(203, 420, 59, 59);
        C0.setBorder(transparentBorder);
        this.afdimage.add(C0);

        C1 = new JLabel("");
        C1.setBounds(312, 357, 59, 59);
        C1.setBorder(transparentBorder);
        this.afdimage.add(C1);

        C2 = new JLabel("");
        C2.setBounds(312, 420, 59, 59);
        C2.setBorder(transparentBorder);
        this.afdimage.add(C2);

        C5 = new JLabel("");
        C5.setBounds(312, 486, 59, 59);
        C5.setBorder(transparentBorder);
        this.afdimage.add(C5);

        B0 = new JLabel("");
        B0.setBounds(202, 250, 59, 59);
        B0.setBorder(transparentBorder);
        this.afdimage.add(B0);

        B1 = new JLabel("");
        B1.setBounds(319, 290, 59, 59);
        B1.setBorder(transparentBorder);
        this.afdimage.add(B1);

        B2 = new JLabel("");
        B2.setBounds(332, 220, 59, 59);
        B2.setBorder(transparentBorder);
        this.afdimage.add(B2);

        B3 = new JLabel("");
        B3.setBounds(402, 260, 59, 59);
        B3.setBorder(transparentBorder);
        this.afdimage.add(B3);

        B5 = new JLabel("");
        B5.setBounds(262, 195, 59, 59);
        B5.setBorder(transparentBorder);
        this.afdimage.add(B5);

        B6 = new JLabel("");
        B6.setBounds(402, 325, 59, 59);
        B6.setBorder(transparentBorder);
        this.afdimage.add(B6);

        A0 = new JLabel("");
        A0.setBounds(202, 83, 59, 59);
        A0.setBorder(transparentBorder);
        this.afdimage.add(A0);

        A1 = new JLabel("");
        A1.setBounds(300, 6, 59, 59);
        A1.setBorder(transparentBorder);
        this.afdimage.add(A1);

        A2 = new JLabel("");
        A2.setBounds(300, 83, 59, 59);
        A2.setBorder(transparentBorder);
        this.afdimage.add(A2);

        A3 = new JLabel("");
        A3.setBounds(402, 3, 59, 59);
        A3.setBorder(transparentBorder);
        this.afdimage.add(A3);

        A4 = new JLabel("");
        A4.setBounds(402, 122, 59, 59);
        A4.setBorder(transparentBorder);
        this.afdimage.add(A4);

        A5 = new JLabel("");
        A5.setBounds(300, 144, 59, 59);
        A5.setBorder(transparentBorder);
        this.afdimage.add(A5);

        A6 = new JLabel("");
        A6.setBounds(402, 60, 59, 59);
        A6.setBorder(transparentBorder);
        this.afdimage.add(A6);

        A7 = new JLabel("");
        A7.setBounds(402, 187, 59, 59);
        A7.setBorder(transparentBorder);
        this.afdimage.add(A7);

    }

    private void printnewState(State state){
        String name = state.getName();
        if(name.equals("O")){
            O.setBorder(greenCircleBorder1);
        } else if(name.equals("C0")){
            C0.setBorder(greenCircleBorder2);
        } else if(name.equals("A0")){
            A0.setBorder(greenCircleBorder2);
        } else if(name.equals("B0")){
            B0.setBorder(greenCircleBorder2);
        } else if(name.equals("C1")){
            C1.setBorder(greenCircleBorder2);
        } else if(name.equals("C2")){
            C2.setBorder(greenCircleBorder2);
        } else if(name.equals("C5")){
            C5.setBorder(greenCircleBorder2);
        } else if(name.equals("B1")){
            B1.setBorder(greenCircleBorder2);
        } else if(name.equals("B2")){
            B2.setBorder(greenCircleBorder2);
        } else if(name.equals("B3")){
            B3.setBorder(greenCircleBorder2);
        } else if(name.equals("B5")){
            B5.setBorder(greenCircleBorder2);
        } else if(name.equals("B6")){
            B6.setBorder(greenCircleBorder2);
        } else if(name.equals("A1")){
            A1.setBorder(greenCircleBorder2);
        } else if(name.equals("A2")){
            A2.setBorder(greenCircleBorder2);
        } else if(name.equals("A3")){
            A3.setBorder(greenCircleBorder2);
        } else if(name.equals("A4")){
            A4.setBorder(greenCircleBorder2);
        } else if(name.equals("A5")){
            A5.setBorder(greenCircleBorder2);
        } else if(name.equals("A6")){
            A6.setBorder(greenCircleBorder2);
        } else if(name.equals("A7")){
            A7.setBorder(greenCircleBorder2);
        }
    }

    private void setState(char value){
        System.out.println("--Estado actual: " + maquina.dfa.getCurrentState().getName() + " Valor: " + value + " --Estadp siguiente: " + maquina.dfa.getNextState(maquina.dfa.getCurrentState(), value).getName() );
        maquina.dfa.chageState(value);
        transparentallstates();
        printnewState(maquina.dfa.getCurrentState());
    }

    private void comprar(){
        if(maquina.dfa.isFinal()){
            JOptionPane.showMessageDialog(
                null, "Compra exitosa", "Compra Valida",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(jop.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))
            );
        } else {
            JOptionPane.showMessageDialog(
                null, "Compra fallida", 
                "Compra Invalida", JOptionPane.ERROR_MESSAGE, 
                new ImageIcon(jope.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH))
            );
        }
        transparentallstates();
        O.setBorder(greenCircleBorder1);
        maquina.dfa.reset();
    }


    private void add_mouse_listener_products(){
        MouseListener ml = new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == p1){
                    setState('A');
                } else if (e.getSource() == p2){
                    setState('B');
                } else if (e.getSource() == p3){
                    setState('C');
                } else if (e.getSource() == p4){
                    setState('D');
                } else if (e.getSource() == p5){
                    setState('E');
                } else if (e.getSource() == p6){
                    setState('F');
                } else if (e.getSource() == p7){
                    setState('G');
                } else if (e.getSource() == p8){
                    setState('H');
                } else if (e.getSource() == p9){
                    setState('I');
                } else if (e.getSource() == verificar){
                    comprar();
                } else if (e.getSource() == mo1){
                    setState('1');
                } else if (e.getSource() == mo2){
                    setState('2');
                } else if (e.getSource() == mo5){
                    setState('5');
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(e.getSource() == p1){
                    p1.setBorder(whiteborder);
                    precio.setText("Producto A -- Precio: 3$ ZeldaCoins");
                } else if (e.getSource() == p2){
                    p2.setBorder(whiteborder);
                    precio.setText("Producto B -- Precio: 3$ ZeldaCoins");
                } else if (e.getSource() == p3){
                    p3.setBorder(whiteborder);
                    precio.setText("Producto C -- Precio: 3$ ZeldaCoins");
                } else if (e.getSource() == p4){
                    p4.setBorder(whiteborder);
                    precio.setText("Producto D -- Precio: 2$ ZeldaCoins");
                } else if (e.getSource() == p5){
                    p5.setBorder(whiteborder);
                    precio.setText("Producto E -- Precio: 2$ ZeldaCoins");
                } else if (e.getSource() == p6){
                    p6.setBorder(whiteborder);
                    precio.setText("Producto F -- Precio: 2$ ZeldaCoins");
                } else if (e.getSource() == p7){
                    p7.setBorder(whiteborder);
                    precio.setText("Producto G -- Precio: 1$ ZeldaCoins");
                } else if (e.getSource() == p8){
                    p8.setBorder(whiteborder);
                    precio.setText("Producto H -- Precio: 1$ ZeldaCoins");
                } else if (e.getSource() == p9){
                    p9.setBorder(whiteborder);
                    precio.setText("Producto I -- Precio: 1$ ZeldaCoins");
                } else if (e.getSource() == mo1){
                    precio.setText("Moneda de 1$ ZeldaCoins");
                } else if (e.getSource() == mo2){
                    precio.setText("Moneda de 2$ ZeldaCoins");
                } else if (e.getSource() == mo5){
                    precio.setText("Moneda de 5$ ZeldaCoins");
                } else if (e.getSource() == O){
                    precio.setText("Estado Cuando se inicia la maquina");
                } else if (e.getSource() == C0){
                    precio.setFont(customFont2);
                    precio.setText("Cuando se escoge un producto de 1 ZCoin y no hay dinero acumulado");
                } else if (e.getSource() == A0){
                    precio.setFont(customFont2);
                    precio.setText("Cuando se escoge un producto de 3 ZCoin y no hay dinero acumulado");
                } else if (e.getSource() == B0){
                    precio.setFont(customFont2);
                    precio.setText("Cuando se escoge un producto de 2 ZCoin y no hay dinero acumulado");
                } else if (e.getSource() == C1){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 1 ZCoin y hay 1$ acumulado, es estado final");
                } else if (e.getSource() == C2){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 1 ZCoin y hay 2$ acumulado, es estado final");
                } else if (e.getSource() == C5){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 1 ZCoin y hay 5$ acumulado, es estado final");
                } else if (e.getSource() == B1){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 2 ZCoin y hay 1$ acumulado");
                } else if (e.getSource() == B2){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 2 ZCoin y hay 2$ acumulado, es estado final");
                } else if (e.getSource() == B3){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 2 ZCoin y hay 3$ acumulado, es estado final");
                } else if (e.getSource() == B5){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 2 ZCoin y hay 5$ acumulado, es estado final");
                } else if (e.getSource() == B6){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 2 ZCoin y hay 6$ acumulado, es estado final");
                } else if (e.getSource() == A1){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 3 ZCoin y hay 1$ acumulado");
                } else if (e.getSource() == A2){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 3 ZCoin y hay 2$ acumulado");
                } else if (e.getSource() == A3){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 3 ZCoin y hay 3$ acumulado, es estado final");
                } else if (e.getSource() == A4){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 3 ZCoin y hay 4$ acumulado, es estado final");
                } else if (e.getSource() == A5){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 3 ZCoin y hay 5$ acumulado, es estado final");
                } else if (e.getSource() == A6){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 3 ZCoin y hay 6$ acumulado, es estado final");
                } else if (e.getSource() == A7){
                    precio.setFont(customFont2);
                    precio.setText("Se Escogio un producto de 3 ZCoin y hay 7$ acumulado, es estado final");
                }

                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                precio.setText("Precio: 0$");
                precio.setFont(customFont);
                if(e.getSource() == p1){
                    p1.setBorder(transparentBorder);
                } if (e.getSource() == p2){
                    p2.setBorder(transparentBorder);
                } if (e.getSource() == p3){
                    p3.setBorder(transparentBorder);
                } if (e.getSource() == p4){
                    p4.setBorder(transparentBorder);
                } if (e.getSource() == p5){
                    p5.setBorder(transparentBorder);
                } if (e.getSource() == p6){
                    p6.setBorder(transparentBorder);
                } if (e.getSource() == p7){
                    p7.setBorder(transparentBorder);
                } if (e.getSource() == p8){
                    p8.setBorder(transparentBorder);
                } if (e.getSource() == p9){
                    p9.setBorder(transparentBorder);
                }
            }
        };

        p1.addMouseListener(ml);
        p2.addMouseListener(ml);
        p3.addMouseListener(ml);
        p4.addMouseListener(ml);
        p5.addMouseListener(ml);
        p6.addMouseListener(ml);
        p7.addMouseListener(ml);
        p8.addMouseListener(ml);
        p9.addMouseListener(ml);
        verificar.addMouseListener(ml);
        mo1.addMouseListener(ml);
        mo2.addMouseListener(ml);
        mo5.addMouseListener(ml);
        O.addMouseListener(ml);
        C0.addMouseListener(ml);
        C1.addMouseListener(ml);
        C2.addMouseListener(ml);
        C5.addMouseListener(ml);
        A0.addMouseListener(ml);
        A1.addMouseListener(ml);
        A2.addMouseListener(ml);
        A3.addMouseListener(ml);
        A4.addMouseListener(ml);
        A5.addMouseListener(ml);
        A6.addMouseListener(ml);
        A7.addMouseListener(ml);
        B0.addMouseListener(ml);
        B1.addMouseListener(ml);
        B2.addMouseListener(ml);
        B3.addMouseListener(ml);
        B5.addMouseListener(ml);
        B6.addMouseListener(ml);
    }

}
