package me.michaelkrauty.MCWrapperClient;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ManageServer {

	public ManageServer() {

		JFrame frame = new JFrame("MCWrapperClientSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Slect server");
		// JComponent test = new JComponent("lol");
		frame.getContentPane().add(label);

		frame.pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		int ww = 300;
		int wh = 200;

		frame.setBounds((int) ((width / 2) - (frame.getWidth() / 2)),
				(int) ((height / 2) - (frame.getHeight() / 2)), ww, wh);
		frame.setLocation((int) ((width / 2) - (frame.getWidth() / 2)),
				(int) ((height / 2) - (frame.getHeight() / 2)));
		frame.setVisible(true);
	}
}
