import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class MyFrame extends JFrame implements ActionListener {
    String fromPath = "";
    String toPath = "";
    //gui for sorter
    JButton button;
    JButton button2;
    JButton button3;
    JTextField textField;
    JTextField textField2;
    
    MyFrame(){
        this.setTitle("Sorter");

        button = new JButton("Source");
        button.addActionListener(this);
        button.setBounds(10,10,75,25);
        button.setPreferredSize(new Dimension(75,25));
        button.setFocusable(false);
        
        button2 = new JButton("DesrDir");
        button2.addActionListener(this);
        button2.setBounds(10,10,75,25);
        button2.setPreferredSize(new Dimension(75,25));
        button2.setFocusable(false);
        
        button3 = new JButton("Sort!");
        button3.addActionListener(this);
        button3.setBounds(10,10,75,25);
        button3.setPreferredSize(new Dimension(330,180));
        button3.setFocusable(false);


        textField = new JTextField();
        textField.setBounds(10,10,50,25);
        textField.setPreferredSize(new Dimension(250,25));

        textField2 = new JTextField();
        textField2.setBounds(10,10,50,25);
        textField2.setPreferredSize(new Dimension(250,25));

        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400,300);
        getContentPane().add(button);
        getContentPane().add(textField);
        getContentPane().add(button2);
        getContentPane().add(textField2);
        getContentPane().add(button3);
        
        this.setVisible(true);


        this.getContentPane().setBackground(new Color(44, 47, 51));
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Select source directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.showOpenDialog(null);
            textField.setText(chooser.getSelectedFile().toString());

        }
        if(e.getSource()==button2){
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Select destination directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.showOpenDialog(null);
            textField2.setText(chooser.getSelectedFile().toString());
              

        }
        if(e.getSource()==button3){
            try {
				new sort(textField.getText(),textField2.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

        }

        
        
    }
}