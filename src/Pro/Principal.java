/*
 *NOMBRE DEL PROGRAMA: PROYECTO FINAL DE PROGRAMACIÓN
 *AUTOR: DANIEL ARENAS // PEDRO HIGUERA
 *FECHA: XXXX X DE 2019
 *VERSION: 0.1 
*/
package Pro;

import java.awt.EventQueue;
import java.io.*;

/**
 * @author Daniel Arenas y Pedro Higuera
 * @version 1.0
 */

public class Principal {

	// AQUI VA EL MAIN
	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeFrame frame = new SnakeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
