package Pro;

import java.io.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ArchivosPuntaje extends JFrame {
	private String ruta1 = null;

	// CREAMOS EL ARCHIVO ENCARGADO DE LOS NOMBRES Y PUNTAJES
	protected File nombres = new File("archivos\\nombres.txt");
	protected File puntajes = new File("archivos\\puntajes.txt");
	private String punt;

	// METODO PARA CREAR ARCHIVO
	/** @throws IOException */
	void crear() throws IOException {

		// SI NO EXISTE LO CREA
		if (!nombres.exists()) {
			nombres.createNewFile();
		}
		if (!puntajes.exists()) {
			puntajes.createNewFile();
		}
	}
//	public void ruta()
//	{
//		if(ruta1 == null)
//		{
//			ruta1 = JOptionPane.showInputDialog("Ingrese ruta");						
//		}

//				
//	}
	// METODO PARA VACIAR EL ARCHIVO
	/** @throws IOException */
	void vaciar() {
		try {
			// ELIMINA EL ARCHIVO
			nombres.delete();
			nombres.createNewFile();
			puntajes.delete();
			puntajes.createNewFile();
		} catch (IOException e) {
		}
	}

	// METODO PARA LEER EL ARCHIVO
	void leer() {

		String nombre = JOptionPane.showInputDialog("Ingrese nombre");
		// TRY CATCH PARA EVITAR ERRORES
		try {
			if (punt == "Score: ") {
				punt = "0";
			}

			// GUARDA LOS DATOS DE LOS NOMBRES EN UN ARCHIVO
			FileWriter escribirNombres = new FileWriter(nombres, true);
			escribirNombres.write(nombre + "\n");
			escribirNombres.close();

			// GUARDA LOS DATOS DE LOS PUNTAJES EN UN ARCHIVO APARTE
			FileWriter escribirPuntajes = new FileWriter(puntajes, true);
			escribirPuntajes.write(punt + "\n");
			escribirPuntajes.close();

		} catch (Exception e) {

		}

	}

	public File getNombres() {
		return nombres;
	}

	public void setNombres(File nombres) {
		this.nombres = nombres;
	}

	public File getPuntajes() {
		return puntajes;
	}

	public void setPuntajes(File puntajes) {
		this.puntajes = puntajes;
	}

	public String getPunt() {
		return punt;
	}

	public void setPunt(String punt) {
		this.punt = punt;
	}

	public String getRuta1() {
		return ruta1;
	}

	public void setRuta1(String ruta1) {
		this.ruta1 = ruta1;
	}

}
