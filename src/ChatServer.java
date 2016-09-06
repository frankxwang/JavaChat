import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Timer;
@SuppressWarnings("all")
public class ChatServer{
	ArrayList clients = new ArrayList();
	ArrayList clientsIn = new ArrayList();
	ServerSocket server;
	ChatServer(){
		Timer t = new Timer();
		try {
			server = new ServerSocket(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new GetClients();
	}
	class GetClients extends TimerTask{
		
		@Override
		public void run(){
			while(true){
				try {
					Socket client = server.accept();
					PrintWriter pw = new PrintWriter(client.getOutputStream());
					clients.add(pw);
					InputStreamReader isr = new InputStreamReader(client.getInputStream());
					clientsIn.add(isr);
					getAndSend();
				} catch (Exception e) {e.printStackTrace();}
			}
		}
		public void broadcast(String message){
			Iterator i = clients.iterator();
			while(i.hasNext()){
				try{
					PrintWriter pw = (PrintWriter) i.next();
					pw.println(message);
					pw.flush();
				}catch(Exception e){e.printStackTrace();}
			}
		}
		public void getAndSend(){
			while(true){
				Iterator i = clientsIn.iterator();
				while(i.hasNext()){
					try{
						InputStreamReader pw = (InputStreamReader) i.next();
						BufferedReader br = new BufferedReader(pw);
						broadcast(br.readLine());
					}catch(Exception e){e.printStackTrace();}
				}
			}
		}
	}
}
