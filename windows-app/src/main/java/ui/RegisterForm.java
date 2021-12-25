package ui;

import static common.Constant.ASTERISK;
import static common.Constant.DIALOG_TITLE;
import static common.Constant.FRAME_HEIGHT;
import static common.Constant.FRAME_TITLE;
import static common.Constant.FRAME_WIDTH;
import static common.Constant.HTML_CLOSE_TAG;
import static common.Constant.HTML_OPEN_TAG;
import static common.Constant.LINE_BREAK_TAG;
import static common.Constant.MESSAGE_FAIL;
import static common.Constant.MESSAGE_SUCCESS;

import java.awt.Dimension;
import java.util.Objects;
import java.util.Set;

import common.UserProperty;
import facade.Validation;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.User;
import validator.ValidatorResult;

/**
 * This class used to define register form
 *
 * @author Chi Cam Hao
 * @version 1.0.0
 * @since 1.0.0
 */
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
	private JLabel messageName;
	private JLabel messageEmail;
	private JLabel messagePhone;
	private JLabel messageAge;
	private JLabel messageAddress;
	private JLabel messagePassword;

	/**
	 * Default constructor
	 */
	public RegisterForm() {
		this.setTitle(FRAME_TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);

		// add panel
		this.add(registerPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		registerButton.addActionListener(e -> {
					resetMessage();
					validateUser();

					if (checkRegister()) {
						JOptionPane.showMessageDialog(this, MESSAGE_SUCCESS, DIALOG_TITLE, JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this, MESSAGE_FAIL, DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
					}
				}
		);
		showPasswordCheckBox.addActionListener(e -> {
			if (showPasswordCheckBox.isSelected()) {
				fieldPassword.setEchoChar((char) 0);
			} else {
				fieldPassword.setEchoChar(ASTERISK);
			}
		});
	}

	/**
	 * This method used to validate user model from user's input
	 */
	private void validateUser() {
		User user = new User(fieldName.getText(), fieldPhone.getText(), fieldEmail.getText(), fieldAge.getText(),
				String.valueOf(fieldPassword.getPassword()), fieldAddress.getText());

		Validation validation = Validation.getInstance();
		Set<ValidatorResult> results = validation.validate(user);

		StringBuilder reasonName = new StringBuilder();
		StringBuilder reasonPhone = new StringBuilder();
		StringBuilder reasonEmail = new StringBuilder();
		StringBuilder reasonAge = new StringBuilder();
		StringBuilder reasonPassword = new StringBuilder();
		StringBuilder reasonAddress = new StringBuilder();

		for (ValidatorResult result : results) {
			UserProperty property = UserProperty.getPropertyByName(result.getProperty());

			switch (property) {
				case NAME:
					reasonName.append(HTML_OPEN_TAG);
					reasonName.append(result.getReason());
					reasonName.append(LINE_BREAK_TAG);
					break;
				case PHONE_NUMBER:
					reasonPhone.append(HTML_OPEN_TAG);
					reasonPhone.append(result.getReason());
					reasonPhone.append(LINE_BREAK_TAG);
					break;
				case EMAIL:
					reasonEmail.append(HTML_OPEN_TAG);
					reasonEmail.append(result.getReason());
					reasonEmail.append(LINE_BREAK_TAG);
					break;
				case AGE:
					reasonAge.append(HTML_OPEN_TAG);
					reasonAge.append(result.getReason());
					reasonAge.append(LINE_BREAK_TAG);
					break;
				case PASSWORD:
					reasonPassword.append(HTML_OPEN_TAG);
					reasonPassword.append(result.getReason());
					reasonPassword.append(LINE_BREAK_TAG);
					break;
				case ADDRESS:
					reasonAddress.append(HTML_OPEN_TAG);
					reasonAddress.append(result.getReason());
					reasonAddress.append(LINE_BREAK_TAG);
					break;
				default:
					break;
			}
		}

		setMessage(reasonName, reasonPhone, reasonEmail, messageName, messagePhone, messageEmail);

		setMessage(reasonAge, reasonPassword, reasonAddress, messageAge, messagePassword, messageAddress);
	}

	/**
	 * This method used to set message to message field
	 */
	private void setMessage(StringBuilder reasonName, StringBuilder reasonPhone, StringBuilder reasonEmail, JLabel messageName, JLabel messagePhone, JLabel messageEmail) {
		if (reasonName.length() > 0) {
			reasonName.append(HTML_CLOSE_TAG);
			messageName.setText(reasonName.toString());
			messageName.setVisible(true);
		}

		if (reasonPhone.length() > 0) {
			reasonPhone.append(HTML_CLOSE_TAG);
			messagePhone.setText(reasonPhone.toString());
			messagePhone.setVisible(true);
		}

		if (reasonEmail.length() > 0) {
			reasonEmail.append(HTML_CLOSE_TAG);
			messageEmail.setText(reasonEmail.toString());
			messageEmail.setVisible(true);
		}
	}

	/**
	 * This method used to check if register success or not
	 *
	 * @return true if register successfully and vice versa
	 */
	private boolean checkRegister() {
		return Objects.equals(messageName.getText(), "") && Objects.equals(messageEmail.getText(), "") && Objects.equals(messageAddress.getText(), "") && Objects.equals(messageAge.getText(), "")
				&& Objects.equals(messagePassword.getText(), "") && Objects.equals(messagePhone.getText(), "");
	}

	/**
	 * This method used to reset error message of all fields
	 */
	private void resetMessage() {
		messageAddress.setText("");
		messageAddress.setVisible(false);

		messageAge.setText("");
		messageAge.setVisible(false);

		messageName.setText("");
		messageName.setVisible(false);

		messageEmail.setText("");
		messageEmail.setVisible(false);

		messagePhone.setText("");
		messagePhone.setVisible(false);

		messagePassword.setText("");
		messagePassword.setVisible(false);
	}
}
