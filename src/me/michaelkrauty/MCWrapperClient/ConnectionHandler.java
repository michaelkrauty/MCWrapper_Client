package me.michaelkrauty.MCWrapperClient;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionHandler {

	public ConnectionHandler() {
		String hostName = "dominationvps.com";
		int portNumber = 3307;

		try {
			Socket socket = new Socket(hostName, portNumber);
			new ToServer(socket);
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("IOException connecting to " + hostName);
			System.exit(1);
		}
		System.exit(0);
	}
}
