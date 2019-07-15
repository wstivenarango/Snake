package Pro;

import Pro.FramesArc;
import Pro.TablaPuntaje;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class TablaGUI extends JDialog {

	// SE CREA EL PANEL
	private final JPanel contentPanel = new JPanel();
	// SE CREA LA TABLA
	TablaPuntaje tablar = new TablaPuntaje();
	private FramesArc f;
	private JButton btnBorrarDatos = new JButton();
	private JButton btnActualizar = new JButton();

	// FUNCIONES DEL JDIALOG
	public TablaGUI() {

		// CARACTERISTICAS
		setTitle("TABLA DE POSICIONES");
		setBounds(100, 100, 450, 300);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// LABEL PARA EL TITULO

		JLabel lblTitulo = new JLabel("TABLA DE POSICIONES");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(141, 11, 151, 14);
		contentPanel.add(lblTitulo);

		// TABLA PARA EL SCORE

		tablar.agregar();
		JTable tt = new JTable(tablar.getDtm());
		JScrollPane scrollpane = new JScrollPane(tt);
		scrollpane.setBounds(10, 36, 414, 171);
		contentPanel.add(scrollpane);

		// BOTON PARA BORRAR LOS DATOS

		btnBorrarDatos = new JButton("BORRAR DATOS");

		btnBorrarDatos.setBounds(10, 227, 127, 23);
		contentPanel.add(btnBorrarDatos);

		// BOTON PARA ACTUALIZAR LOS DATOS

		btnActualizar = new JButton("ACTUALIZAR");

		btnActualizar.setBounds(141, 227, 151, 23);
		contentPanel.add(btnActualizar);

		// BOTON PARA SALIR

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnSalir.setBounds(297, 227, 127, 23);
		contentPanel.add(btnSalir);

	}

	// GETTERS Y SETTERS
	public JButton getBtnBorrarDatos() {
		return btnBorrarDatos;
	}

	public void setBtnBorrarDatos(JButton btnBorrarDatos) {
		this.btnBorrarDatos = btnBorrarDatos;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

}
