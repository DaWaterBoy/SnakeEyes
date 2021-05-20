import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;

public class RollSnakeEyes {

	private JFrame RollAgain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RollSnakeEyes window = new RollSnakeEyes();
					window.RollAgain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param managerSnakeEyes 
	 */
	public RollSnakeEyes(ManagerSnakeEyes managerSnakeEyes) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		RollAgain = new JFrame();
		RollAgain.setBounds(100, 100, 450, 300);
		RollAgain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RollAgain.getContentPane().setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Your current total is {}");
		RollAgain.getContentPane().add(lblNewLabel, "cell 6 0");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		RollAgain.getContentPane().add(lblNewLabel_1, "cell 6 2");
		
		JButton btnNewButton = new JButton("New button");
		RollAgain.getContentPane().add(btnNewButton, "cell 5 4");
		
		JButton btnNewButton_1 = new JButton("New button");
		RollAgain.getContentPane().add(btnNewButton_1, "cell 7 4");
	}

}
