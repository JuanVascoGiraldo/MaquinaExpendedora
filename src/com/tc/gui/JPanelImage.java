package com.tc.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JPanelImage extends JPanel{
    private Image backgroundImage;

    // Constructor para cargar la imagen
    public JPanelImage(String imagename) {
        try {
            backgroundImage = ImageIO.read(new File("./resources/images/"+imagename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Sobrescribir paintComponent para dibujar la imagen de fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
