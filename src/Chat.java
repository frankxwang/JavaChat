import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.net.*;
import java.util.TimerTask;
public class Chat implements ActionListener{
	JLabel label;
	JFrame frame;
	JTextField textField;
	Socket chatSoc;
	JScrollBar list = new JScrollBar();
	Chat(){
		try {
			chatSoc = new Socket("190.165.1.103", 4242);
		} catch (IOException e) {}
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
					//System.out.println("HI");
					//System.out.println(textField.getText());
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
		//System.out.println("HI");
	}
	class CheckChat extends TimerTask{

		@Override
		public void run() {
			Runnable r = new GetChat();
			Thread t = new Thread(r);
			t.start();
		}
		
	}
	
	class GetChat implements Runnable{
		public void run() {
			try {
				InputStreamReader isr = new InputStreamReader(chatSoc.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				String get;
				while((get = br.readLine()) != null){
					list.setToolTipText(list.getToolkit() + get);
				}
				br.close();
			} catch (Exception e) {}
		}
	}
	
	class Send implements Runnable{
		public void run() {
			try {
				PrintWriter pw = new PrintWriter(chatSoc.getOutputStream());
				pw.println(textField.getText());
				pw.flush();
				textField.setText("");
				pw.close();
			} catch (Exception e){}
		}
	}
}

