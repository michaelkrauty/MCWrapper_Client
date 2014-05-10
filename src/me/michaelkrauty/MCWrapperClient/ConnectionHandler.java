package me.michaelkrauty.MCWrapperClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionHandler implements Runnable {
	private Thread t;

	public ConnectionHandler() {

	}

	@Override
	public void run() {
		String hostName = "dominationvps.com";
		int portNumber = 3307;

		try (Socket socket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(socket.getOutputStream(),
						true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()))) {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					System.in));
			String fromServer, fromUser;

			while ((fromServer = in.readLine()) != null) {
				System.out.println("MCWrapper: " + fromServer);
				if (fromServer.equalsIgnoreCase("disconnect")) {
					System.out.println("Closing socket...");
					socket.close();
					System.out.println("Server closed connection.");
				}

				if (stdIn.readLine() != null) {
					fromUser = stdIn.readLine();
					if (fromUser != null) {
						out.println(fromUser);
						if (fromUser.equalsIgnoreCase("disconnect")) {
							System.out.println("Closing socket...");
							socket.close();
							System.out.println("Disconnected.");
						}
					}
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("IOException connecting to " + hostName);
			System.exit(1);
		}
		System.exit(0);
	}

	public void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}
}
