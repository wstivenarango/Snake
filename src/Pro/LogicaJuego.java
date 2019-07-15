package Pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class LogicaJuego {

	// OBJETO DE TIPO GAME SCENE
	private GameScene instanceGame;

	// ARREGLO DE TIPO ACTION LISTENER PARA MOVER LA SERIPIENTE
	private ActionListener[] actions = {

			// SE ENCARGA DE LOS MOVIMIENTOS A LA IZQUIERDA
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					valueSpeed(instanceGame.getPlay().getScore());
					instanceGame.getPlay().moveSnake("Left");
				}
			},
			// SE ENCARGA DE LOS MOVIMIENTOS A LA DERECHA
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					valueSpeed(instanceGame.getPlay().getScore());
					instanceGame.getPlay().moveSnake("Right");
				}
			},
			// SE ENCARGA DE LOS MOVIMIENTOS A LA ARRIBA
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					valueSpeed(instanceGame.getPlay().getScore());
					instanceGame.getPlay().moveSnake("Up");
				}
			},
			// SE ENCARGA DE LOS MOVIMIENTOS ABAJO
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					valueSpeed(instanceGame.getPlay().getScore());

					instanceGame.getPlay().moveSnake("Down");
				}
			} };

	// TIMER PARA EL BONUS
	private Timer timerBonus;
	// TIMER PARA MANEJAR EL MOVIMIENTO DE LA SERPIENTE
	private Timer[] timerMotion;
	// VARIABLES PARA GUARDAR MOMENTOS
	private int timeBonus, goal, delay, currentMotion;

	// CONSTRUCTOR PARA ASIGNAR VALORES INICIALES
	public LogicaJuego(GameScene instanceGame) {

		this.instanceGame = instanceGame;
		currentMotion = 0;
		// CON EL DELAY ASIGNAMOS VELOCIDAD
		delay = 100;
		goal = 100;
		// EL TIME BONUS DURA UNOS 5 SEGUNDOS APROXIMADAMENTE
		timeBonus = (900 * 5);
		timerMotion = new Timer[actions.length];

		// LLAMA A LOS METODOS
		createMotion();
	}

	// METODO PARA EVALUAR LA VELOCIDAD RESPECTO AL SCORE
	public void valueSpeed(int x) {
		if (x >= goal && delay >= 20) {
			increaseSpeed();
			goal += x;
		}
	}

	// METODO PARA EL MOVIMIENTO "INFINITO" HACIA UN LADO
	public void actuate(int e) {

		// PRIMERO VERIFICA QUE NO SE ESTE EJECUTANDO
		if (timerMotion[currentMotion].isRunning()) {
			// EN ESTE CASO LO DETIENE
			timerMotion[currentMotion].stop();
			// SE LE INDICA EL NUEVO TIMER A ACTIVAR
			currentMotion = e;
			timerMotion[currentMotion].start();

		} else {
			// SE ACTIVA Y ES NECESARIO PARA LA PRIMERA VEZ QUE SE USA
			currentMotion = e;
			timerMotion[currentMotion].start();
		}
	}

	// SE CREA EL MOVIMIENTO DE LA SERPIENTE RESPECTO AL TIMER Y EL DELAY
	private void createMotion() {
		for (int i = 0; i < timerMotion.length; i++)
			timerMotion[i] = new Timer(delay, actions[i]);
	}

	// LO INICIA
	public void startMotion(int t) {
		if (!timerMotion[t].isRunning())
			timerMotion[t].start();
	}

	// LO DETIENE
	public void stopMotion(int t) {
		if (timerMotion[t].isRunning())
			timerMotion[t].stop();
	}

	// DETIENE TODOS LOS MOVIMIENTOS
	public void stopAllMotions() {
		for (Timer motion : timerMotion)
			if (motion.isRunning())
				motion.stop();
	}

	// SE AUMENTA LA VELOCIDAD RESTANDOLE AL DELAY
	public void increaseSpeed() {
		delay -= 20;

		for (Timer motion : timerMotion)
			motion.setDelay(delay);
	}

	// SE VUELVE A PONER LA VELOCIDAD INICIAL
	public void restoreSpeed() {
		delay = 100;

		for (Timer motion : timerMotion)
			motion.setDelay(delay);
	}

	// DETIENE TODOS LOS TIMERS
	public void stopAllTimers() {
		stopAllMotions();
	}

	// GETTER DE SPEED
	public int getSpeed() {
		return delay;
	}

}
