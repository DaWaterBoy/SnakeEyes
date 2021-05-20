import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JPanel;

public class SnakeEyesApp2 {

	private JFrame frmSnakeEyes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeEyesApp2 window = new SnakeEyesApp2();
					window.frmSnakeEyes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SnakeEyesApp2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSnakeEyes = new JFrame();
		frmSnakeEyes.setTitle("Snake Eyes");
		frmSnakeEyes.setBounds(100, 100, 705, 554);
		frmSnakeEyes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSnakeEyes.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Set your Handicap");
		frmSnakeEyes.getContentPane().add(lblNewLabel);
		
		JSlider HandiCap = new JSlider();
		HandiCap.setSnapToTicks(true);
		HandiCap.setPaintTicks(true);
		HandiCap.setPaintLabels(true);
		HandiCap.setMajorTickSpacing(1);
		HandiCap.setMaximum(25);
		frmSnakeEyes.getContentPane().add(HandiCap);
		
		JButton btnNewButton = new JButton("Ready");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int HC = HandiCap.getValue();
				playSnakeEyes TestSnake = new playSnakeEyes(HC);
			}
		});
		frmSnakeEyes.getContentPane().add(btnNewButton);
	}
}
