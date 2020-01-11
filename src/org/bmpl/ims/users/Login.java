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


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	void doLogin() {
		String userid = textField.getText();
		String password = new String(passwordField.getPassword());
		
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		try {
			
			userDTO = userDAO.login(userDTO);
			
			if(userDTO.isLoginSuccess()) {
				
				this.setVisible(false);
				Dashboard frame = new Dashboard(userDTO);
				frame.setVisible(true);
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	void loadApplication() {
		this.setVisible(false);
		this.dispose();
		Application application  = new Application();
		application.setVisible(true);
	}
	
	void doReset() {
		textField.setText("");
		passwordField.setText("");
	}

	
	public Login() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(39, 64, 61, 16);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(39, 120, 61, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(179, 59, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 115, 130, 26);
		contentPane.add(passwordField);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.setBounds(64, 167, 117, 29);
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doLogin();
				
			}
		});
		
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("reset");
		btnReset.setBounds(259, 167, 117, 29);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doReset();
				
			}
		});
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadApplication();
			}
		});
		btnBack.setBounds(310, 17, 117, 29);
		contentPane.add(btnBack);
	}
}
