package ren.laughing.test.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2016);
			Socket socket = server.accept();//
			Reader reader = new InputStreamReader(socket.getInputStream());
			char[] chars = new char[64];
			int len;
			StringBuilder sb = new StringBuilder();
			while ((len = reader.read(chars)) != -1) {
				sb.append(new String(chars, 0, len));
			}
			System.out.println("from client: " + sb);
			reader.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
