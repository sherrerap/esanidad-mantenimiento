package HIS_E2.app_sanidad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import HIS_E2.app_sanidad.model.Cita;
import HIS_E2.app_sanidad.model.Medico;
import HIS_E2.app_sanidad.model.Paciente;
import HIS_E2.app_sanidad.model.Usuario;
import HIS_E2.app_sanidad.repositories.CitaRepository;
import HIS_E2.app_sanidad.repositories.EspecialidadRepository;
import HIS_E2.app_sanidad.repositories.MedicoRepository;
import HIS_E2.app_sanidad.repositories.PacienteRepository;
import HIS_E2.app_sanidad.repositories.UserRepository;

@Component
public class Manager {
	
	//Aqui se declaran los repository con @Autowire
	@Autowired
	UserRepository userRepo;
	@Autowired
	PacienteRepository pacienteRepo;
	@Autowired
	MedicoRepository medicoRepo;
	@Autowired
	CitaRepository citaRepo;
	@Autowired
	EspecialidadRepository especialidadRepo;
	
	private Manager() {
		
	}

	private static class ManagerHolder {
		static Manager singleton=new Manager();
	}
	
	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}
	
	public Usuario register(String dni,	String nombre, String apellidos, String contrs, int numSS, int idEspecialidad) {
		Usuario usuario = new Usuario(dni, nombre, apellidos, contrs);
		userRepo.insert(usuario);
		
		if(numSS < 0) {
			Medico medico = new Medico(usuario.getDni(), usuario.getNombre(), usuario.getApellidos(), usuario.getContrs(), idEspecialidad);
			medicoRepo.insert(medico);
		} else if(idEspecialidad < 0) {
			Paciente paciente = new Paciente(usuario.getDni(), usuario.getNombre(), usuario.getApellidos(), usuario.getContrs(), numSS);
			pacienteRepo.insert(paciente);
		}
		
		return usuario;
	}

	public List<Cita> getCitas(String dni, String pass) {
		Medico med = medicoRepo.findByDni(dni);
		
		if(med.getContrs().equals(pass)) {
			List<Cita> lista = citaRepo.findByDniMedico(dni);
			return lista;
		} else {
			return null;
		}
		
	}
}