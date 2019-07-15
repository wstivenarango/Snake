package Pro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Daniel Arenas y Pedro Higuera
 * @version 1.0
 * 
 */
public class App extends JFrame {
//SE CREA EL PANEL Y SE CREA OBJETO DE TIPO APP
	private JPanel rootPanel;
	private static App app;

	// CONSTRUCTOR QUE PONE TITULO Y LLAMA AL METODO CREATE APP
	private App() {
		super("Snake");
		createApp();
	}

	// METODO ENCARGADO DE RETORNAR LA INSTANCIA DEL OBJETO SI ES NULA O NO
	public static App getInstance() {
		if (app == null) {
			app = new App();
		}

		return app;
	}

	// METODO ENCARGADO DE DEFINIR LA VENTANA
	private void createApp() {

		// ARREGLO DE TIPO DOUBLE QUE GUARDE EL ANCHO Y LARGO
		double[] screen = calculateScreen();
		setPreferredSize(new Dimension((int) screen[0], (int) screen[1]));

		// CARACTERISTICAS DEL PANEL
		rootPanel = new JPanel();
		rootPanel.setBackground(Color.white);
		rootPanel.setPreferredSize(getPreferredSize());
		rootPanel.setFocusable(true);

		getContentPane().add(rootPanel);

		// SE LE AGREGA ICONO AL JUEGO
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icon.png"));
		setIconImage(icon);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocation((int) screen[0] / 2, (int) screen[1] / 4);
		setResizable(false);

		// DEFINE EL TAMAÑO RESPECTO AL TAMAÑO DE LA VENTANA, MAS FACIL QUE SET SIZE
		pack();
	}

	// SE ENCARGA DE VACIAR EL PANEL Y REPINTARLO
	public void runScene(JPanel scene) {

		// LLAMA AL METODO PARA DESTRUIR LA ESCENA ANTERIOR
		destroyScene();

		// SE LE VUELVEN A ASIGNAR EL MISMO COLOR Y CARACTERISTICAS
		rootPanel.setBackground(scene.getBackground());
		rootPanel.add(scene);
		rootPane.revalidate();
		rootPanel.repaint();
	}

	// METODO PARA REMOVER TODO DEL PANEL
	private void destroyScene() {
		rootPanel.removeAll();
	}

	// CON ESTO SE CALCULA EL TAMAÑO DE LA VENTANA Y QUE SEA COMPATIBLE
	private double[] calculateScreen() {

		// SE OBTIENE LA RESOLUCION DE PANTALLA
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		// SE LE ASIGNA DE ANCHO UN 54% Y DE ALTO UN 72% DE LA PANTALLA
		double width = screen.getWidth() * 0.5483;
		double height = screen.getHeight() * 0.727;

		return new double[] { width, height };
	}

}