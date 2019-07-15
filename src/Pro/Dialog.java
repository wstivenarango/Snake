
package Pro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author pr0mming
 * 
 *         SnakeProject is a project with the purpose to fully exploit tools
 *         Java (Swing and AWT) specifically ... If you think you can help me
 *         improve this project it would be great
 * 
 *         GitHub: https://github.com/pr0mming
 */

public class Dialog extends JDialog {

	private ActionListener[] actions;
	private Font font;
	private String message;

	public Dialog(ActionListener[] actions, String title, String message) {
		super(App.getInstance(), title, true);
		this.actions = actions;
		this.message = message;
		createDialog();
	}

	private void createDialog() {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 300));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.black);
		JLabel label = new JLabel(message);
		label.setForeground(Color.white);
		panel.add(label);

		Dimension size = App.getInstance().getPreferredSize();
		setSize((int) (size.width * 0.40), (int) (size.height * 0.18));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		pack();

	}


}
