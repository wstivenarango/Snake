package Pro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InstruccionesGUI extends JDialog {

	// SE CREA UN PANEL
	private final JPanel contentPanel = new JPanel();

	// FUNCIONES
	public InstruccionesGUI() {

		// CARACTERISTICAS
		setModal(true);
		setBounds(100, 100, 500, 300);
		setLocationRelativeTo(null);
		setTitle("INSTRUCCIONES");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// LABEL DEL TITULO
		{
			JLabel lblInstrucciones = new JLabel("INSTRUCCIONES DE JUEGO");
			lblInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblInstrucciones.setBounds(149, 11, 186, 14);
			contentPanel.add(lblInstrucciones);
		}
		// LABEL DE INSTRUCCION 1
		{
			JLabel Inst1 = new JLabel("1.Dele click al bot\u00F3n de jugar");
			Inst1.setBounds(29, 51, 337, 21);
			contentPanel.add(Inst1);
		}
		// LABEL DE INSTRUCCION 2
		{
			JLabel Inst2 = new JLabel("2.Al cargar la partida pulse una tecla de direccion cualquiera");
			Inst2.setBounds(29, 83, 395, 21);
			contentPanel.add(Inst2);
		}
		// LABEL DE INSTRUCCION 3
		{
			JLabel Inst3 = new JLabel("3.Para dirigir la serpiente use las flechas");
			Inst3.setBounds(29, 115, 337, 21);
			contentPanel.add(Inst3);
		}
		// LABEL DE INSTRUCCION 4
		{
			JLabel Inst4 = new JLabel("4.El objetivo es crecer lo m\u00E1ximo posible comiendo manzanas");
			Inst4.setBounds(29, 147, 395, 21);
			contentPanel.add(Inst4);
		}
		// LABEL DE INSTRUCCION 5
		{
			JLabel Inst5 = new JLabel("5.Evite tocar los bordes y a s\u00ED mismo");
			Inst5.setBounds(29, 179, 337, 21);
			contentPanel.add(Inst5);
		}
		// LABEL DE INSTRUCCION 6
		{
			JLabel Inst6 = new JLabel("6.Divi\u00E9rtase");
			Inst6.setBounds(29, 204, 337, 21);
			contentPanel.add(Inst6);
		}
		// BOTON PARA SALIR DE LA VENTANA
		{
			JButton btnSalir = new JButton("Salir");
			// ACCIONES AL OPRIMIR
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// CIERRA LA VENTANA
					dispose();
				}
			});
			btnSalir.setBounds(385, 227, 89, 23);
			contentPanel.add(btnSalir);
		}
	}

}
