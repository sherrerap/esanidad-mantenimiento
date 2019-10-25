package HIS_E2.app_sanidad.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cita")
public class Cita {
	
	@Id
	int idCita;
	Date fecha;
	String dniMedico;
	String dniPaciente;

	
	public Cita(int idCita, Date fecha, String dniMedico, String dniPaciente) {
		super();
		this.idCita = idCita;
		this.fecha = fecha;
		this.dniMedico = dniMedico;
		this.dniPaciente = dniPaciente;
	}

	public int getIdCita() {
		return idCita;
	}
	
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getDniMedico() {
		return dniMedico;
	}
	
	public void setDniMedico(String dniMedico) {
		this.dniMedico = dniMedico;
	}
	
	public String getDniPaciente() {
		return dniPaciente;
	}
	
	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fecha=" + fecha + ", dniMedico=" + dniMedico + ", dniPaciente="
				+ dniPaciente + "]";
	}
	
}