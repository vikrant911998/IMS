package org.bmpl.ims.users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.bmpl.ims.start.Application;
import org.bmpl.ims.users.dao.UserDAO;
import org.bmpl.ims.users.dto.UserDTO;


public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	void doRegister() {
		String userid = textField.getText();
		String password = new String(passwordField.getPassword());
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);

		UserDAO userDAO = new UserDAO();
		
		try {
			
			boolean result = userDAO.register(userDTO);
			
			if(result) {
				this.setVisible(false);
				
				Login login = new Login();
				login.setVisible(true);
			}
			else {
				System.out.println("Error in Registering User..");
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	void doReset() {
		textField.setText("");
		passwordField.setText("");
	}
	
	void loadApplication(){
		this.setVisible(false);
		Application application= new Application();
		application.setVisible(true);
	}
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setBounds(42, 86, 61, 16);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(42, 144, 61, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(168, 81, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 139, 130, 26);
		contentPane.add(passwordField);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(113, 19, 61, 16);
		contentPane.add(lblRegister);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.setBounds(57, 202, 117, 29);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doRegister();		
			}
		});
		contentPane.add(btnSubmit);
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(256, 202, 117, 29);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doReset();
				
			}
		});
		
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(327, 6, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadApplication();
				
			}
		});
		contentPane.add(btnBack);
	}

}
