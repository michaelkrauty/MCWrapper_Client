package me.michaelkrauty.MCWrapperClient;

import java.io.IOException;

public class Main {

	public static ConnectionHandler connectionHandler = new ConnectionHandler();

	public static void main(String[] args) throws IOException {

		connectionHandler.start();

	}
}