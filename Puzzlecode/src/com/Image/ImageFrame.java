package com.Image;

import javax.swing.*;

public class ImageFrame extends JFrame {

    public void showImage() {
        // creates the actual frame with title 'My GUI' and dimensions
        JFrame frame = new JFrame("My GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 50);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        // Inserts the image icon
        String imgStr = "temp.jpg";
        ImageIcon image = new ImageIcon(imgStr);
        JLabel label1 = new JLabel(" ", image, JLabel.CENTER);
        frame.getContentPane().add(label1);
        frame.validate();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //showImage();
    }
}