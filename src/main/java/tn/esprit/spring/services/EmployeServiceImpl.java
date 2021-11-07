package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
	@Override
	public int ajouterEmploye(Employe employe) {
		l.info("début ajout employee");
		employeRepository.save(employe);
		l.info("fin ajout employee ");
		return employe.getId();
	}
	@Override
	public int mettreAjourEmailByEmployeId(String email, int employeId) {
		l.info("début mettre à jour email d'employee d'id "+ employeId);
		try {Employe employe = employeRepository.findById(employeId).orElse(null);
			if(employe == null){
				l.info("employe not found");
				l.info("fin mettre à jour email d'employee " );

				return 0;
		}else{
			employe.setEmail(email);
			l.info("email de l'employee mis à jour");
			employeRepository.save(employe);
			l.info("email de l'employee d id "+employeId+" est mis à jour");
			l.info("fin mettre à jour email d'employee " );
			return 1;}
			
		}
		catch(Exception e) 
			{l.error("Erreur : " + e);
			return 0;}
			
		
	}
	@Override
	public List<Employe> getAllEmployes() {
		l.info("début getAllEmployes");
		l.info("fin getAllEmployes");
	    return (List<Employe>) employeRepository.findAll();
	}

	@Transactional
	@Override
	public int desaffecterEmployeDuDepartement(int employeId, int depId)
	{	l.info("début desaffectation employee à departement");

		Departement dep = deptRepoistory.findById(depId).orElse(null);
if(dep==null){
	l.info("departement introuvable");
	l.info("fin desaffectation employee à departement");
return 0;
}
else {
		int employeNb = dep.getEmployes().size();
		for(int index = 0; index < employeNb; index++){
			if(dep.getEmployes().get(index).getId() == employeId){
				dep.getEmployes().remove(index);
				l.info("employe desafecté du departement");
				break;
			}
		}
		l.info("fin desaffectation employee à departement");

		return 1;
	}
}
	@Override
	public int ajouterContrat(Contrat contrat) {
		l.info("début ajout contrat");
		contratRepoistory.save(contrat);
		l.info("fin ajout contrat de reference "+contrat.getReference());

		return contrat.getReference();

	}
	@Override
	public int affecterContratAEmploye(int contratId, int employeId) {
		l.info("début affectation contrat a employe");

		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);
if(contratManagedEntity==null || employeManagedEntity==null){
	l.info("contrat ou employe not found");
	l.info("fin affectation contrat a employe");
	return 0;
}else {
		contratManagedEntity.setEmploye(employeManagedEntity);
		l.info("contrat"+contratId+" affecte a employe "+employeId);

		contratRepoistory.save(contratManagedEntity);
		l.info("fin affectation contrat a employe");
return 1;
	}}
	@Override
	public String getEmployePrenomById(int employeId) {
		l.info("début get employePrenom by id "+employeId);

		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);
		if(employeManagedEntity==null){
			l.info("employe introuvable + fin get employePrenom by id");
			return "not found";
		}
		else{
			l.info("fin get employePrenom by id "+employeManagedEntity.getId());

		return employeManagedEntity.getPrenom();}
		
	}
	@Override
	public int deleteEmployeById(int employeId)
	{		l.info("début delete employe by id");

		Employe employe = employeRepository.findById(employeId).orElse(null);
		if(employe==null){
			l.info("employe introuvable + fin delete employe by id");
			return 0;
		}
		else{
		
		for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);
			l.info("remove employe ");
		}

		employeRepository.delete(employe);
		l.info("fin delete employe by id");
		return 1;
	}}
	@Override
	public int deleteContratById(int contratId) {
		l.info("début delete contrat by id "+contratId);
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(null);
		if(contratManagedEntity==null){
			l.info("contrat introuvable + fin delete contrat by id");
			return 0;
		}
		else{
		contratRepoistory.delete(contratManagedEntity);
		l.info("contrat "+contratId+" is deleted");

		l.info("fin delete contrat by id "+contratId);
return 1;}
	}
	
	
	
	
	
	public int getNombreEmployeJPQL() {
		l.info("début getNombreEmploye");
		l.info("fin getNombreEmploye");
		return employeRepository.countemp();
		
	}
	
	public List<String> getAllEmployeNamesJPQL() {
		l.info("In getAllEmployeNames");
		l.info("Out getAllEmployeNames");
		return employeRepository.employeNames();

	}
	
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		l.info("In getAllEmployeByEntreprise");
		l.info("Out getAllEmployeByEntreprise");
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}
@Override
@Transactional
	public int mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		l.info("Debut mettreAjourEmailByEmployeIdJPQL"+ employeId);
		
		try{ Employe emp= employeRepository.findById(employeId).orElse(null);
		   if (emp==null){
			   l.debug("employe not found!");
			   l.info("fin mettreAjourEmailByEmployeIdJPQL");
			   return 0;}
		   else {
				   employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);
				   l.debug ("la mise à jour est faite et le nouveau email est:"+ email);
				   l.info("fin mettreAjourEmailByEmployeIdJPQL");
				   return 1;
				   
			   }}
		   catch(Exception e) 
			{l.error("Erreur : " + e);
			return 0;}   
		}
			   
		   
	public int deleteAllContratJPQL() {
		 l.info("IN delete all Contrat");
         employeRepository.deleteAllContratJPQL();
         l.info("Out delete all Contrat");
	return 0 ;
	}
	
	public float getSalaireByEmployeIdJPQL(int employeId) {
		try{ l.info("début getSalaireByEmployeId");
		employeRepository.getSalaireByEmployeIdJPQL(employeId);}
		catch (Exception e) { l.error("erreur dans findById():" + e);}
	    return 0;
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		l.info("début getSalaireMoyenByDepartementId");
		l.info("fin getSalaireMoyenByDepartementId");
		Departement	dep= deptRepoistory.findById(departementId).orElse(null);
		if(dep!=null){
	return	employeRepository.getSalaireMoyenByDepartementId(departementId);}
		return null;
		
		
		
	}
	
	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		l.info("début getSalaireMoyenByDepartementId");
		l.info("fin getSalaireMoyenByDepartementId");
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	
	@Transactional	
	public int affecterEmployeADepartement(int employeId, int depId) {
		l.info("début affectation employee à departement");

		Departement depManagedEntity = deptRepoistory.findById(depId).orElse(null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);
if (depManagedEntity==null || employeManagedEntity==null )
	return 0;
else if(depManagedEntity.getEmployes() == null){
			l.info("list employee dans le departement est null")
			;
			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity);
			depManagedEntity.setEmployes(employes);
			l.info("employee avec l'id:"+employeId+"  est affecté à departement d'id:" + depId);
			return 1;
		}
		else{
			l.info("list employee dans le departement non null");
			depManagedEntity.getEmployes().add(employeManagedEntity);
			l.info("employee affecté à departement");

		
		l.info("fin affectation employee à departement");
		return 1;
		}

	}
	

	}
