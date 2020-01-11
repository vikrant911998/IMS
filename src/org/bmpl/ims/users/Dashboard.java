package org.bmpl.ims.users;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bmpl.ims.users.dto.UserDTO;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	
	public Dashboard(UserDTO userDTO) {
		
		setTitle("DASHBOARD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashboard = new JLabel("Welcome User "+
				userDTO.getUserid());
		
		lblDashboard.setBounds(61, 45, 244, 33);
		contentPane.add(lblDashboard);
	
	}
	
}
