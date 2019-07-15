package Pro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SnakeFrame extends JFrame {

	// SE CREA EL PANEL
	private SnakePanel contentPane;
	// SE CREA LOS DIALOGS
	private InstruccionesGUI inst = new InstruccionesGUI();
	private TablaGUI tablap = new TablaGUI();
	private FramesArc f;
	ArchivosPuntaje arp = new ArchivosPuntaje();

	// FUNCIONES DEL FRAME
	public SnakeFrame() {

		// CARACTERISTICAS
		setBounds(100, 100, 480, 350);
		setLocationRelativeTo(null);
		setTitle("SNAKE");
		contentPane = new SnakePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		System.out.print(1);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		// BOTON JUGAR
		contentPane.getBtnJugar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ABRE EL JUEGO DESDE LA CLASE APP
				App.getInstance().runScene(new GameScene());
				App.getInstance().setVisible(true);
			}

		});

		// BOTON DE INSTRUCCIONES
		contentPane.getBtnInstrucciones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ABRE EL JDIALOG DE LAS INSTRUCCIONES
				inst.setVisible(true);

			}
		});

		// BOTON PARA LA TABLA DE POSICIONES
		contentPane.getBtnTabla().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ABRE EL DIALOG DE LA TABLA
				tablap.setVisible(true);

			}
		});

		// BOTON BORRAR TABLA
		tablap.getBtnBorrarDatos().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// LLAMADO DE LA FUNCION VACIAR, VACÍA EL ARCHIVO
				tablap.tablar.vaciar();
				JOptionPane.showMessageDialog(null, "Se han borrado los datos");
				// SE CIERRA EL DIALOGO
				tablap.dispose();
				// SE CIERRRA EL FRAME
				dispose();
				f = new FramesArc(true);

			}
		});

		// BOTON ACTUALIZAR TABLA
		tablap.getBtnActualizar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				tablap.dispose();
				dispose();
				f = new FramesArc(true);

			}
		});

		// BOTON SALIR
		contentPane.getBtnSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// MUESTRA CUADRO DE DIALOGO Y TERMINA PROCESO
				JOptionPane.showMessageDialog(null, "Gracias por usar el programa", "Saludo", 1);
				System.exit(0);

			}
		});

	}
}
