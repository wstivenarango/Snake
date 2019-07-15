package Pro;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SnakePanel extends JPanel {

	private JButton btnSalir;
	private JButton btnJugar;
	private JButton btnTabla;
	private JButton btnInstrucciones;
	private JLabel lblImagen;

	// FUNCIONES DEL PANEL
	public SnakePanel() {

		// CARACTERÍSTICAS
		setBackground(new Color(102, 204, 102));
		setLayout(null);

		// BOTON JUGAR
		btnJugar = new JButton("JUGAR");

		// CUANDO EL MOUSE ESTA DENTRO O FUERA DE LOS LIMITES
		btnJugar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btnJugar.setForeground(Color.lightGray);
			}

			public void mouseExited(MouseEvent e) {
				btnJugar.setForeground(Color.DARK_GRAY);
			}// CUANDO SE HACE CLICK AL BOTON

			public void mousePressed(MouseEvent e) {
				btnJugar.setFont(new Font("Bahnschrift", Font.BOLD, 13));
			}

			public void mouseReleased(MouseEvent e) {
				btnJugar.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			}
		});
		btnJugar.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJugar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnJugar.setBounds(10, 286, 76, 23);
		btnJugar.setOpaque(false);
		btnJugar.setContentAreaFilled(false);
		btnJugar.setBorderPainted(false);
		add(btnJugar);

		// BOTON PARA LA TABLA DE POSICIONES
		btnTabla = new JButton("POSICIONES");
		// CUANDO EL MOUSE ESTA DENTRO O FUERA DE LOS LIMITES
		btnTabla.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnTabla.setForeground(Color.lightGray);
			}

			public void mouseExited(MouseEvent e) {
				btnTabla.setForeground(Color.DARK_GRAY);
			}

			public void mousePressed(MouseEvent e) {
				btnTabla.setFont(new Font("Bahnschrift", Font.BOLD, 13));
			}

			public void mouseReleased(MouseEvent e) {
				btnTabla.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			}
		});
		btnTabla.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnTabla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTabla.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnTabla.setBounds(96, 286, 126, 23);
		btnTabla.setOpaque(false);
		btnTabla.setContentAreaFilled(false);
		btnTabla.setBorderPainted(false);
		add(btnTabla);

		// BOTON DE LAS INSTRUCCIONES
		btnInstrucciones = new JButton("INSTRUCCIONES");
		// CUANDO EL MOUSE ESTA DENTRO O FUERA DE LOS LIMITES
		btnInstrucciones.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnInstrucciones.setForeground(Color.lightGray);
			}

			public void mouseExited(MouseEvent e) {
				btnInstrucciones.setForeground(Color.DARK_GRAY);
			}

			public void mousePressed(MouseEvent e) {
				btnInstrucciones.setFont(new Font("Bahnschrift", Font.BOLD, 13));
			}

			public void mouseReleased(MouseEvent e) {
				btnInstrucciones.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			}
		});
		btnInstrucciones.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnInstrucciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInstrucciones.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnInstrucciones.setBounds(232, 286, 136, 23);
		btnInstrucciones.setOpaque(false);
		btnInstrucciones.setContentAreaFilled(false);
		btnInstrucciones.setBorderPainted(false);
		add(btnInstrucciones);

		// BOTON PARA SALIR
		btnSalir = new JButton("SALIR");
		// CUANDO EL MOUSE ESTA DENTRO O FUERA DE LOS LIMITES
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnSalir.setForeground(Color.lightGray);
			}

			public void mouseExited(MouseEvent e) {
				btnSalir.setForeground(Color.DARK_GRAY);
			}

			public void mousePressed(MouseEvent e) {
				btnSalir.setFont(new Font("Bahnschrift", Font.BOLD, 13));
			}

			public void mouseReleased(MouseEvent e) {
				btnSalir.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			}
		});
		btnSalir.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSalir.setBackground(new Color(0, 102, 0));
		btnSalir.setBounds(373, 286, 89, 23);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		add(btnSalir);

	}

	// IMAGEN PARA EL FONDO
	/** @param g Recibe Graphics para darle Imagen al fondo */
	public void paint(Graphics g) {

		Toolkit t = Toolkit.getDefaultToolkit();
		Image imagen = t.getImage(getClass().getResource("/imagenes/Snake.jpg"));
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		super.paint(g);
		setOpaque(false);
	}

	// GETTERS Y SETTERS

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}

	public void setBtnJugar(JButton btnJugar) {
		this.btnJugar = btnJugar;
	}

	public JButton getBtnTabla() {
		return btnTabla;
	}

	public void setBtnTabla(JButton btnTabla) {
		this.btnTabla = btnTabla;
	}

	public JButton getBtnInstrucciones() {
		return btnInstrucciones;
	}

	public void setBtnInstrucciones(JButton btnInstrucciones) {
		this.btnInstrucciones = btnInstrucciones;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

}