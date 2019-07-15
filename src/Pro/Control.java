package Pro;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

//SE IMPLEMENTA EL KEYEVENT PARA CONFIGURAR LOS CONTROLES
public class Control implements KeyEventDispatcher {

	// OBJETO D TIPO GAMESCENE
	private GameScene instanceGame;

	// CONSTRUCTOR QUE ASIGNA VALOR
	/** @param instanceGame La instancia del Juego de clase GameScene */
	public Control(GameScene instanceGame) {
		this.instanceGame = instanceGame;
	}

	// METODO QUE CAPTURA LAS TECLAS QUE SE PRESIONAN
	/** @return Booelan que detecta si hay una tecla presionada */
	public boolean dispatchKeyEvent(KeyEvent e) {

		if (e.getID() == KeyEvent.KEY_PRESSED) {
			String direction = instanceGame.getPlay().getDirection();

			this.instanceGame.getScheduler().valueSpeed(this.instanceGame.getPlay().getScore());

			// CUANDO SE PRESIONE LA TECLA IZQUIERDA Y NO SE MUEVA A LA DERECHA
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (!direction.equals("Right")) {
					instanceGame.getScheduler().actuate(0);
					instanceGame.getPlay().moveSnake("Left");
				}
			} else
			// CUANDO SE PRESIONE TECLA DERECHA Y NO VAYA PARA LA IZQUIERDA
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (!direction.equals("Left")) {
					this.instanceGame.getScheduler().actuate(1);
					this.instanceGame.getPlay().moveSnake("Right");
				}
			} else
			// CUANDO SE PRESIONE ARRIBA Y NO VAYA PARA ABAJO
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (!direction.equals("Down")) {
					this.instanceGame.getScheduler().actuate(2);
					this.instanceGame.getPlay().moveSnake("Up");
				}
			} else
			// CUANDO SE PRESIONE ABAJO Y NO VAYA PARA ARRIBA
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (!direction.equals("Up")) {
					this.instanceGame.getScheduler().actuate(3);
					this.instanceGame.getPlay().moveSnake("Down");
				}
			}
		}

		return false;
	}

}
