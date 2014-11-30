import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Password implements ActionListener {

	private JFrame frame;
	private JPasswordField passwordField;
	private static String OK = "ok";
	private static String HELP = "help";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Password window = new Password();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblEnterPassword = new JLabel("Enter Password:");
		frame.getContentPane().add(lblEnterPassword, "4, 6");

		passwordField = new JPasswordField();
		frame.getContentPane().add(passwordField, "8, 6, 15, 1, fill, default");
		passwordField.setActionCommand("Ok");
		passwordField.addActionListener(this);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (OK.equals(cmd)) { // Process the password.
					char[] input = passwordField.getPassword();
					if (isPasswordCorrect(input)) {
						JOptionPane.showMessageDialog(frame,
								"Success! You typed the right password.");
					} else {
						JOptionPane.showMessageDialog(frame,
								"Invalid password. Try again.",
								"Error Message", JOptionPane.ERROR_MESSAGE);
					}

					passwordField.selectAll();
					resetFocus();
				}
			}
		});
		btnOk.setActionCommand(OK);
		btnOk.addActionListener(this);
		frame.getContentPane().add(btnOk, "24, 6");

		JButton btnHelp = new JButton("Help");
		frame.getContentPane().add(btnHelp, "24, 8");

		btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (HELP.equals(cmd)) {
					passwordField.selectAll();
					resetFocus();
				} else {
					JOptionPane
							.showMessageDialog(
									frame,
									"You can get the password by searching this example's\n"
											+ "source code for the string \"correctPassword\".\n"
											+ "Or look at the section How to Use Password Fields in\n"
											+ "the components section of The Java Tutorial.");
				}
			}
		});
		{
			btnHelp.setActionCommand(OK);
			btnHelp.addActionListener(this);
		}
	}

	private void resetFocus() {

	}

	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };

		if (input.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(input, correctPassword);
		}
		return isCorrect;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
