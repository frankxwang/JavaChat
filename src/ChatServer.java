import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Timer;
public class ChatServer {
	ChatServer(){
		Timer t = new Timer();
		t.schedule(new GetClients(), 0, 1);
	}
	class GetClients extends TimerTask{

		@Override
		public void run() {
			
		}
		
	}
}
