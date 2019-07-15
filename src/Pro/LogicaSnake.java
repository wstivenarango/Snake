
package Pro;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LogicaSnake extends JFrame {

	// SE CREA ARCHIVO DE TIPO ARCHIVOS PUNTAJE
	ArchivosPuntaje p = new ArchivosPuntaje();
	FramesArc f = new FramesArc();

	// OBJETO PARA CARGAR EL AMBIENTE
	private GameScene instanceGame;
	private JLabel[][] matrix;
	// VARIABLES PARA GUARDAR EL TAMAÑO, SCORE Y POSCICIONES
	private int snakeLen, len, score, xFood, yFood, foodInMemory;
	// ARRAY LIST PARA HACER LA SERPIENTE
	private ArrayList<String> snake, foodInBonus;
	private Color snakeColor;
	private String direction;
	private boolean bonus, lose, win;
	private Random rnd;

	// CONSTRUCTOR
	public LogicaSnake() {

	}

	// METODO CERRAR PARA CERRAR EL JUEGO
	public void cerrar() {
		this.dispose();
	}

	// CONSTRUCTOR PARA PARA INICIALIZAR LOS ATRIBUTOS
	public LogicaSnake(GameScene instanceGame) {

		this.rnd = new Random();
		this.instanceGame = instanceGame;
		this.matrix = instanceGame.getMatrix();
		// SE INICIA EL JUEGO CON ESTE METODO
		startGame();
	}

	// METODO PARA INICIALIZAR EL JUEGO
	private void startGame() {

		// SE ASIGNAN VALORES A TODOS LOS ELEMENTOS
		this.snakeLen = 4;
		this.foodInMemory = 0;
		this.score = 0;
		this.foodInBonus = new ArrayList<>();
		this.snake = new ArrayList<>();
		this.snakeColor = Color.white;
		this.bonus = false;
		this.lose = false;
		this.win = false;

		// SE CREA LA SERPIENTE Y LA COMIDA
		createSnake();
		createFood();

	}

	// METODO PARA EVALLUAR SI LA POSICION DE LA COMIDA ES LA MISMA QUE LA DE LA
	// CABEZA
	/** @param x Punto en el eje X */
	/** @param y Punto en el eje Y */

	public void eat(int x, int y) {

		if (xFood == x && yFood == y) {
			matrix[x][y].setIcon(null);
			// INCREMENTA PUNTAJE
			foodInMemory += 2;
			incrementScore(10);
			// LLAMA AL METODO PARA GENERAR OTRA MANZANA
			createFood();
		}
		youWin();
	}

	// SE VA AUMENTANDO EL SCORE
	/** @param p Cantidad en la que se incrementa el Score */
	public void incrementScore(int p) {
		score += p;
		instanceGame.updateScore(score);
		instanceGame.updateScoren(score);
	}

	// METODO PARA CREAR NUEVAS MANZANAS
	public void createFood() {

		// NUMEROS ALEATORIOS ENTRE 0 Y EL NUMERO DE FILAS/COLUMNAS DEL TABLERO
		int xRnd = rnd.nextInt(matrix.length - 0) + 0;
		int yRnd = rnd.nextInt(matrix[0].length - 0) + 0;

		// CUANDO LA SERPIENTE YA HALLA PASADO POR LAS COORDENADAS DE LA COMIDA CREA
		// OTRA
		if (snake.contains(xRnd + "," + yRnd) || foodInBonus.contains(xRnd + "," + yRnd)) {
			createFood();
		} else {

			// ASIGNA LOS NUMEROS ALEATORIOS COMO COORDENADAS
			xFood = xRnd;
			yFood = yRnd;

			// VUELVE A PINTAR LA MANZANA Y SE LE PONE UNA IMAGEN PARA QUE SE VEA MAS BONITA
			matrix[xFood][yFood].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/food.png"))
					.getImage().getScaledInstance(matrix[xFood][yFood].getSize().width,
							matrix[xFood][yFood].getSize().height, Image.SCALE_REPLICATE)));
		}
	}

	// METODO PARA CREAR LA SERPIENTE
	public void createSnake() {

		// POSICION INICIAL DE LA SERPIENTE
		int x = (matrix.length / 2);
		int y = (matrix[0].length / 2);

		if (snakeLen > (matrix[0].length - 1) / 2)
			snakeLen = 4;

		for (int i = 0, j = y; i <= snakeLen; i++, j++) {
			matrix[x][j].setBackground(snakeColor);
			snake.add(x + "," + j);
		}
		// LA SERPIENTE EMPIEZA MIRANDO A LA IZQUIERDA
		direction = "Left";

	}

	// METODO RECURSIVO PARA REPOSICIONAR LA SERPIENTE (VER MOVIMIENTO)
	/** @param x Punto en el eje X */
	/** @param y Punto en el eje Y */
	/** @param indexx Rectifica el tamañano de la serpiente */
	public void reposition(int x, int y, int index) {

		int[] array = { x, y };

		if (index >= snake.size()) {
			if (foodInMemory > 0) {
				matrix[x][y].setBackground(snakeColor);
				snake.add(x + "," + y);
				foodInMemory--;
			} else
				matrix[x][y].setBackground(instanceGame.getBackgroundGame());
		} else {
			String[] coords = snake.get(index).split(",");
			snake.set(index, x + "," + y);
			matrix[x][y].setBackground(snakeColor);

			reposition(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]), index += 1);
		}
	}

	// METODO PARA MOVER EL SNAKE
	/** @param Verifica la Telca Pulsada */
	public void moveSnake(String key) {

		// ARREGLO QUE SEPARA POR ,
		String[] coords = snake.get(0).split(",");

		// BLOQUEA LAS TECLAS QUE VAN EN DIRECCION CONTRARIA A LA SERPIENTE
		// Y ACABA EL JUEGO CUANDO LA CABEZA TIENE LAS MISMAS COOREDNADAS QUE EL
		// "CUERPO"
		if (key.equals("Right") && !direction.equals("Left") && Integer.valueOf(coords[1]) < matrix[0].length - 1) {

			if (!snake.contains(coords[0] + "," + (Integer.valueOf(coords[1]) + 1))) {
				reposition(Integer.valueOf(coords[0]), (Integer.valueOf(coords[1]) + 1), 0);
				eat(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]) + 1);
				direction = key;
			} else {
				youLose();
			}

		} else {
			if (key.equals("Left") && !direction.equals("Right") && Integer.valueOf(coords[1]) > 0) {
				if (!snake.contains(coords[0] + "," + (Integer.valueOf(coords[1]) - 1))) {
					reposition(Integer.valueOf(coords[0]), (Integer.valueOf(coords[1]) - 1), 0);
					eat(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]) - 1);
					direction = key;
				} else {
					youLose();
				}
			} else {
				if (key.equals("Up") && !direction.equals("Down") && Integer.valueOf(coords[0]) > 0) {
					if (!snake.contains((Integer.valueOf(coords[0]) - 1) + "," + coords[1])) {
						reposition((Integer.valueOf(coords[0]) - 1), Integer.valueOf(coords[1]), 0);
						eat(Integer.valueOf(coords[0]) - 1, Integer.valueOf(coords[1]));
						direction = key;
					} else {
						youLose();
					}
				} else {
					if (key.equals("Down") && !direction.equals("Up")
							&& Integer.valueOf(coords[0]) < matrix.length - 1) {
						if (!snake.contains((Integer.valueOf(coords[0]) + 1) + "," + coords[1])) {
							reposition((Integer.valueOf(coords[0]) + 1), Integer.valueOf(coords[1]), 0);
							eat(Integer.valueOf(coords[0]) + 1, Integer.valueOf(coords[1]));
							direction = key;
						} else {
							youLose();
						}
					} else {
						youLose();
					}
				}
			}
		}
	}

	// VA LIMPIANDO EL CAMPO Y SE ASIGNA EL COLOR DEL FONDO, TAMBIEN SE ELIMINA
	// CUALQUIER ICONO QUE ESTE EN ESA POSICIO
	/** @param x Lista que recibe coordenadas de X */
	public void deleteArray(ArrayList<String> x) {

		for (String element : x) {
			String[] coords = element.split(",");
			matrix[Integer.valueOf(coords[0])][Integer.valueOf(coords[1])].setBackground(instanceGame.getBackground());
			matrix[Integer.valueOf(coords[0])][Integer.valueOf(coords[1])].setIcon(null);
		}

		x.removeAll(x);
	}

	// METODO GANADOR
	public void youWin() {

		// MIENTRAS WIN SEA FALSO Y LA SERPIENTE CUBRA EL 25% DEL TABLERO
		if (!win && len >= ((matrix.length * matrix[0].length) * 0.25)) {

			win = true;
			// DETIENE TODO
			instanceGame.getScheduler().stopAllTimers();
			instanceGame.removeKeyFocus();
			instanceGame.restoreColorPanel();
			// MUESTRA MENSAJE DE VICTORIA
			JOptionPane.showMessageDialog(null, "Felicidades, usted llegará muy lejos");
			// LLAMA AL METODO LEER DE ARVHIVOS PUNTAJE
			p.leer();
			p.setPunt("Gano");
			dispose();
			f.cerrarJuego();
		}
	}

	// METODO PERDEDOR
	public void youLose() {

		// MIENTRAS LOSE SEA FALSO
		if (!lose) {

			lose = true;
			instanceGame.removeKeyFocus();
			instanceGame.restoreColorPanel();
			// MENSAJE DE PERDIDA
			JOptionPane.showMessageDialog(null, "Lo siento, usted ha perdido");
			// LLAMA AL METODO LEER DE ARVHIVOS PUNTAJE
			p.setPunt(instanceGame.getScore().getText());
			p.leer();
			dispose();
			f.cerrarJuego();

		}
		;
	}

	// GETTERS Y SETTERS

	public Color getSnakeColor() {
		return this.snakeColor;
	}

	public int getXFood() {
		return this.xFood;
	}

	public int getYFood() {
		return this.yFood;
	}

	public JLabel[][] getMatrix() {
		return this.matrix;
	}

	public boolean getBonus() {
		return this.bonus;
	}

	public void setBonus(boolean e) {
		this.bonus = e;
	}

	public String getDirection() {
		return this.direction;
	}

	public int getScore() {
		return this.score;
	}

	public int getLen() {
		return this.len;
	}

	public ArrayList<String> getFoodInBonus() {
		return this.foodInBonus;
	}

}
