package me.michaelkrauty.MCWrapperClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class FromServer implements Runnable {

	private Thread t;
	private final Socket socket;

	public FromServer(Socket soc) {
		socket = soc;
	}

	public void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

	@Override
	public void run() {
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String fromServer;
			while ((fromServer = in.readLine()) != null) {
				System.out.println("MCWrapper: " + fromServer);
				if (fromServer.equalsIgnoreCase("disconnect")) {
					System.out.println("Closing socket...");
					socket.close();
					System.out.println("Server closed connection.");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
