package HIS_E2.app_sanidad.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medico")
public class Medico extends Usuario{

	int idEspecialidad;
	
	
	public Medico(String dni, String nombre, String apellidos, String contrs, int idEspecialidad) throws Exception {
		super(dni, nombre, apellidos, contrs);
		this.idEspecialidad = idEspecialidad;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	@Override
	public String toString() {
		return "Medico [idEspecialidad=" + idEspecialidad + ", dni=" + dni + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", contrs=" + contrs + ", centroSalud=" + centroSalud + "]";
	}
	
}
