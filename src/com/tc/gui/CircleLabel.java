package com.tc.gui;

import javax.swing.*;
import java.awt.*;


class CircleLabel extends JLabel {
    private Color borderColor;
    private int borderWidth;

    public CircleLabel() {
        this.borderColor = new Color(0, 0, 0, 128); // Color negro semi-transparente
        this.borderWidth = 5;
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    public void setBorderWidth(int width) {
        this.borderWidth = width;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Habilitar anti-aliasing para círculos suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el círculo
        int diameter = Math.min(getWidth(), getHeight()) - borderWidth * 2;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        // Dibujar el círculo con borde transparente
        g2d.setColor(new Color(255, 255, 255, 0)); // Transparente
        g2d.fillOval(x, y, diameter, diameter);

        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(borderWidth));
        g2d.drawOval(x, y, diameter, diameter);
    }
}

