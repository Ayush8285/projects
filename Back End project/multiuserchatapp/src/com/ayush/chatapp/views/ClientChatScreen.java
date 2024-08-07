package com.ayush.chatapp.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ayush.chatapp.network.Client;
import com.ayush.chatapp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClientChatScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private Client client ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
						try {
							ClientChatScreen frame = new ClientChatScreen();
							frame.setVisible(true);
						} catch (UnknownHostException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				

	}

	private void sendIt() {
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME+" - " +message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea  = new JTextArea();
		client =  new Client(textArea);
		setTitle("Chit Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 768, 313);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(10, 24, 713, 280);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(20, 339, 578, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendIt = new JButton("Send Message");
		sendIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		sendIt.setBounds(627, 339, 109, 36);
		contentPane.add(sendIt);
		setVisible(true);
		
		
	}
}
