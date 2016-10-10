package ren.laughing.test.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 2016);
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write("Hello World");
			writer.flush();
			writer.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
