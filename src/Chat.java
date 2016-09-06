import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.net.*;
public class Chat implements ActionListener{
	JLabel label;
	JFrame frame;
	JTextField textField;
	Chat(){
		textField = new JTextField();
		frame = new JFrame("SOME SIMPLE CHAT CLIENT YOU SHOULD'NT USE");
		frame.setPreferredSize(new Dimension(1000,1000));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		textField.setPreferredSize(new Dimension(100,60));
		frame.add(textField, BorderLayout.SOUTH);
		frame.pack();
		textField.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER && !(textField.getText().trim() == "")){
					System.out.println("HI");
					System.out.println(textField.getText());
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public void actionPerformed(ActionEvent ev) {
		System.out.println("HI");
	}
}
