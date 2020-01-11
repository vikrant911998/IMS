package org.bmpl.ims.start;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bmpl.ims.users.Login;
import org.bmpl.ims.users.Register;
import javax.swing.JButton;

public class Application extends JFrame {

	private JPanel contentPane;
	
	
	void loadLogin(){
		this.setVisible(false);
		this.dispose();
		Login login  = new Login();
		login.setVisible(true);
	}
	
	void loadRegister() {
		
		this.setVisible(false);
		this.dispose();
		Register register = new Register();
		register.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application application = new Application();
					application.setVisible(true);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setTitle("APPLICATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(25, 45, 117, 29);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadLogin();
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBounds(25, 142, 117, 29);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadRegister();
			}
		});
		contentPane.add(btnRegister);
	}
}





















