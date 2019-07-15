package Pro;

import java.io.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TablaPuntaje extends ArchivosPuntaje {

	// CREAMOS UNA MATRIZ DE STRING PARA GUARDAR EL NOMBRE Y EL PUNTAJE
	private Object tabla[][] = {};

	// CREAMOS ARREGLO PARA PONER LOS TITULOS DE LAS CASILLAS
	private String columnast[] = { "Nombre", "Puntaje" };
	private DefaultTableModel dtm = new DefaultTableModel(tabla, columnast);

	// CREAMOS EL CONSTRUCTOR
	public TablaPuntaje() {

	}

	void agregar() {
		// SE METE EN UN TRY CATCH PARA EVITAR PROBLEMAS
		try {
			// CREAMOS LOS STRING PARA GUARDAR LOS DATOS
			String names;
			String puntos;

			// CREAMOS LOS FILEREADERS Y BUFFEREDREADERS
			FileReader lectorNombres = new FileReader(nombres);
			FileReader lectorPuntos = new FileReader(puntajes);
			BufferedReader contenidoNombres = new BufferedReader(lectorNombres);
			BufferedReader contenidoPuntos = new BufferedReader(lectorPuntos);

			// VARIABLE CONTADORA
			int i = 0;
			while (((names = contenidoNombres.readLine()) != null)) {
				puntos = contenidoPuntos.readLine();
				dtm.addRow(new String[] { names });
				dtm.setValueAt(puntos, i, 1);
				i++;
			}
			// CERRADO DE ARCHIVOS
			lectorNombres.close();
			lectorPuntos.close();
			contenidoNombres.close();
			contenidoPuntos.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al imprimir el nombre");

		}
	}

	// SETTERS Y GETTERS

	public Object[][] getTabla() {
		return tabla;
	}

	public void setTabla(Object[][] tabla) {
		this.tabla = tabla;
	}

	public String[] getColumnast() {
		return columnast;
	}

	public void setColumnast(String[] columnast) {
		this.columnast = columnast;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

}
