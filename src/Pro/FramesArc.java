package Pro;

import javax.swing.JFrame;

public class FramesArc extends JFrame {

	// BOOL PARA TOMAR DECISIONES
	boolean s;

	// CONSTRUCTOR DE LA CLASE
	FramesArc() {

	}

	// CONSTRUCTOR DE POLIMORFISMO PARA ACTUALIZAR FRAME
	/** @param Bolean detecta si se reinicia el Frame */
	FramesArc(boolean s) {
		if (s) {
			SnakeFrame nuevo = new SnakeFrame();
			nuevo.dispose();
			nuevo.setVisible(s);

		}
	}

	// METODO PARA CERRAR EL JUEGO
	void cerrarJuego() {
		App.getInstance().setVisible(false);

	}

}
