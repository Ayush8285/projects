package com.ayush.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ayush.chatapp.dao.UserDAO;
import com.ayush.chatapp.dto.UserDTO;
import com.ayush.chatapp.utils.UserInfo;

public class UserScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField useridtxt;
	private JTextField passwordField;

	public static void main(String[] args) {
		
//		UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO = new UserDAO();
	private void doLogin() {
		String userid = useridtxt.getText();
		//String password = passwordField.getText(); // old way it is not safe ..password is seen by developer ...not prefer
		//char []password = passwordField.getPassword(); // in this version get password function is not there.
		String password = passwordField.getText();
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message ="";
			if(userDAO.isLogin(userDTO)) {
				message = "Welcome "+userid;
				UserInfo.USER_NAME = userid;
				JOptionPane.showMessageDialog(this,message);
				setVisible(false);
				dispose();
				DashBoard dashBoard = new DashBoard(message);
				dashBoard.setVisible(true);
			}else {
				message = "Invalid Userid or Password";
				JOptionPane.showMessageDialog(this,message);
			}
//			JOptionPane.showMessageDialog(this,message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void register(){
		String userid = useridtxt.getText();
		//String password = passwordField.getText(); // old way it is not safe ..password is seen by developer ...not prefer
		//char []password = passwordField.getPassword(); // in this version get password function is not there.
		String password = passwordField.getText();
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
		int result = userDAO.add(userDTO);
		if(result > 0) {
			JOptionPane.showMessageDialog(this, "Register Successfully");
			//System.out.println("Record Added....");
		}else {
			JOptionPane.showMessageDialog(this, "Register Failed");
//			System.out.println("Record not added....");
		}
		}
		catch(ClassNotFoundException | SQLException ex) {
			System.out.println("DB Issue ....");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some Generic Exception Raised....");
			ex.printStackTrace();  //Where is the Exception
		}
		System.out.println("userid "+ userid +" Password "+ password);
	}
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(278, 45, 127, 54);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(395, 144, 223, 30);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel useridlbl = new JLabel("Userid");
		useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		useridlbl.setBounds(210, 141, 86, 30);
		getContentPane().add(useridlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdlbl.setBounds(210, 206, 86, 30);
		getContentPane().add(pwdlbl);
		
		passwordField = new JTextField();
		passwordField.setBounds(395, 209, 223, 30);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbt.setBounds(249, 300, 111, 42);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerbt.setBounds(395, 300, 111, 42);
		getContentPane().add(registerbt);
		
		setBackground(Color.WHITE);
		setSize(833,440);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
