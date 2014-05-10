package me.michaelkrauty.MCWrapperClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ToServer {

	private PrintWriter out;

	public ToServer(Socket socket) {

		new FromServer(socket);

		try {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					System.in));
			out = new PrintWriter(socket.getOutputStream(), true);

			String fromUser;

			while ((fromUser = stdIn.readLine()) != null) {
				out.println(fromUser);

				if (fromUser.equalsIgnoreCase("disconnect")) {
					System.out.println("Closing socket...");
					socket.close();
					System.out.println("Disconnected.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
