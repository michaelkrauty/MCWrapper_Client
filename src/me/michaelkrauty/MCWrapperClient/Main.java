package me.michaelkrauty.MCWrapperClient;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		ConnectionHandler connectionHandler = new ConnectionHandler();
		connectionHandler.start();

	}
}