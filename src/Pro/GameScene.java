package Pro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GameScene extends JPanel {

	// SE CREA EL PANEL Y LOS ELEMENTOS NECESARIOS
	private JPanel panelGame;
	private JLabel[][] matrix;
	private JLabel score, numero;
	// OBJETO DE TIPO LOGICA SNAKE
	private LogicaSnake play;
	private Color background;
	// OBJETO DE TIPO SCHEDULER
	private LogicaJuego motion;
	private Font font;
	// EVENTO D TECLADO
	private KeyboardFocusManager keyboardFocus;
	private Control keyEventDispatcher;
	String puntaje;

	// CONSTRUCTOR QUE CARGA LOS DATOS Y CREA LA ESCENA
	public GameScene() {

		// SE LLAMA AL METODO
		createScene();

		motion = new LogicaJuego(this);
		play = new LogicaSnake(this);
		keyEventDispatcher = new Control(this);
		keyboardFocus = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		addKeyboardFocus();

	}

	// METODO PARA CREAR LA ESCENA
	private void createScene() {

		// SE ASIGNAN EL TAMAÑO DE LA CUADRICULA
		int x = 50, y = 60;

		// SE LE ASIGNA EL COLOR DE FONDO
		background = new Color(102, 204, 102);
		panelGame = new JPanel(new GridLayout(x, y, 0, 0));

		// SE LE ASIGNA LA DIMENSION Y BORDES
		Dimension size = App.getInstance().getPreferredSize();
		panelGame.setPreferredSize(new Dimension((int) (size.width * 0.99), (int) (size.height * 0.79)));
		// COLOR DE LOS BORDES
		panelGame.setBackground(Color.WHITE);
		panelGame.setBorder(BorderFactory.createLineBorder(background, 5));

		JPanel panelStatistics = new JPanel(new GridLayout(2, 2, 10, 10));
		panelStatistics.setPreferredSize(new Dimension((int) (size.width), (int) (size.height * 0.14)));
		panelStatistics.setBorder(new EmptyBorder(2, 25, 25, 25));
		panelStatistics.setBackground(background);

		// PROPORCIONES DE LA PANTALLA
		matrix = new JLabel[x][y];

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new JLabel();
				matrix[i][j].setBackground(background);
				matrix[i][j].setOpaque(true);
				matrix[i][j].setSize(
						new Dimension(panelGame.getPreferredSize().width / y, panelGame.getPreferredSize().height / x));
				panelGame.add(matrix[i][j]);
			}

		int sizeFont = (int) (panelGame.getPreferredSize().height * 0.044);

		// SE LE ASIGNAN VALORES AL STRING PARA QUE MUESTRE EL PUNTAJE
		score = new JLabel();
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setBounds(10, 100, 90, 30);
		score.setText("Score: ");
		// updateScore(0);

		// SE AÑADE EL PANEL DEL FONDO
		JPanel rootPanel = new JPanel();
		rootPanel.setPreferredSize(App.getInstance().getPreferredSize());
		rootPanel.add(panelGame);
		rootPanel.add(panelStatistics, BorderLayout.SOUTH);

		// SE AÑADE EL LABEL DE LOS NUMEROS
		numero = new JLabel("Score");
		numero.setForeground(Color.WHITE);
		numero.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 18));
		panelStatistics.add(numero);

		// SE ESTABLECE EL COLOR AL ROOT PANEL
		rootPanel.setBackground(background);
		rootPanel.setVisible(true);

		add(rootPanel);
		setBackground(background);
		setVisible(true);
	}

	// METODO PARA PODER ACTUALIZAR LA PARTE GRAFICA
	public void changeScene(JPanel scene) {
		// SE LLAMA AL METOO
		removeKeyFocus();
		// DETIENE LOS TIMERS
		motion.stopAllTimers();

		motion = null;
		play = null;
		keyboardFocus = null;
		keyEventDispatcher = null;

		App.getInstance().runScene(scene);

	}

	// SE ENCARGA DE IR ACTUALIZANDO EL SCORE
	public void updateScore(int p) {
		score.setText(Integer.toString(p));
	}
	public void updateScoren(int p) {
		numero.setText("Score: " + p);
	}
	// METODO PARA PODER COMUNICAR LAS TECLAS CON ACCIONES EN EL JUEGO
	public void addKeyboardFocus() {
		this.keyboardFocus.addKeyEventDispatcher(keyEventDispatcher);
	}

	// HACE LO INVERSO A LO ANTERIOR
	protected void removeKeyFocus() {
		this.keyboardFocus.removeKeyEventDispatcher(keyEventDispatcher);
	}

	// METODOS PARA EL BONUS
	public void changeColorPanel() {
		panelGame.setBackground((panelGame.getBackground() == Color.white) ? Color.black : Color.white);
	}

	public void restoreColorPanel() {
		panelGame.setBackground(Color.white);
	}

	// SETTERS Y GETTERS
	public LogicaJuego getScheduler() {
		return this.motion;
	}

	public LogicaSnake getPlay() {
		return this.play;
	}

	public Color getBackgroundGame() {
		return this.background;
	}

	public JLabel[][] getMatrix() {
		return matrix;
	}

	public JLabel getScore() {
		return score;
	}

	public void setScore(JLabel score) {
		this.score = score;
	}

}