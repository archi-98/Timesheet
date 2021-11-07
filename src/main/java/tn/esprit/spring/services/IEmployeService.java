package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;


public interface IEmployeService {
	
	public int ajouterEmploye(Employe employe);
	public int mettreAjourEmailByEmployeId(String email, int employeId);
	public List<Employe> getAllEmployes();
	public int desaffecterEmployeDuDepartement(int employeId, int depId);
	public int ajouterContrat(Contrat contrat);
	public int affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public int deleteEmployeById(int employeId);
	public int deleteContratById(int contratId);
	
	public int getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise);
	public int mettreAjourEmailByEmployeIdJPQL(String email, int employeId);
	public int deleteAllContratJPQL();
	public Double getSalaireByEmployeIdJPQL(int employeId);
	public Double getSalaireMoyenByDepartementId(int departementId);
	public int affecterEmployeADepartement(int employeId, int depId); 
	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, 
	Date dateDebut, Date dateFin);
	
	
	
	
	

	
	

	
}
