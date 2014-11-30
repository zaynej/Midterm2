import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RadioButtons extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RadioButtons frame = new RadioButtons();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RadioButtons() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 200, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton Bt1 = new JRadioButton("  Small");
		Bt1.setBounds(50, 50, 100, 50);
		contentPane.add(Bt1);
		JRadioButton Bt2 = new JRadioButton("  Medium");
		Bt2.setBounds(50, 100, 100, 50);
		contentPane.add(Bt2);
		JRadioButton Bt3 = new JRadioButton("  Large");
		Bt3.setBounds(50, 150, 100, 50);
		contentPane.add(Bt3);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(Bt1);
		buttonGroup.add(Bt2);
		buttonGroup.add(Bt3);
		
		Bt1.setSelected(true);
	}
}