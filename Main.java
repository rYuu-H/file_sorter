import java.awt.Color;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello git!");
        //gui for sorter
        JFrame frame = new JFrame();
        frame.setTitle("Sorter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400,800);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(44, 47, 51));



    }
}