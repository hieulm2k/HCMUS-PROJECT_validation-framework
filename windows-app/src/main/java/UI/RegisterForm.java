package UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.User;

public class RegisterForm extends JFrame {
	private JPanel registerPanel;
	private JTextField fieldName;
	private JPasswordField fieldPassword;
	private JTextField fieldAddress;
	private JTextField fieldAge;
	private JTextField fieldPhone;
	private JTextField fieldEmail;
	private JButton registerButton;
	private JCheckBox showPasswordCheckBox;
	private JLabel labelName;
	private JLabel messageName;
	private JLabel labelEmail;
	private JLabel messageEmail;
	private JLabel labelPhone;
	private JLabel messagePhone;
	private JLabel labelAge;
	private JLabel messageAge;
	private JLabel labelAddress;
	private JLabel messageAddress;
	private JLabel labelPassword;
	private JLabel messagePassword;

	public RegisterForm() {
		this.setTitle("Register Form");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(400,400));
		this.setResizable(false);

		// add panel
		this.add(registerPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
