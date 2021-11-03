package tn.esprit.spring;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
public class EmployeServiceImplTest {
@Autowired
IEmployeService es;



 
@Test
@Order(1)
public void testAjouterEmploye(){
	Employe e=new Employe("haraghi", "takwa", "takwa@esprit.tn", true, Role.INGENIEUR);
	int id=es.ajouterEmploye(e);
	Assertions.assertEquals(id,e.getId());
}
@Test
@Order(2)
public void testGetNombreEmployeJPQL(){
	
  es.getNombreEmployeJPQL();
	
}
@Test
@Order(3)
public void TestGetAllEmployeNamesJPQL()
{
	es.getAllEmployeNamesJPQL();
}


@Test
@Order(4)
public void TestGetAllEmployeByEntreprise()
{
	Entreprise entreprise=new Entreprise("Esprit","RS");
 es.getAllEmployeByEntreprise(entreprise);
}
@Test 
@Order(5)
public void TestMettreAjourEmailByEmployeIdJPQL(String email, int employeId)
{
es.mettreAjourEmailByEmployeIdJPQL(email, employeId);
}
@Test
@Order(6)
public void TestDeleteAllContratJPQL()
{
	es.deleteAllContratJPQL();
	}
@Test
@Order(7)
public void TestgetSalaireByEmployeIdJPQL(int employeId)
{
	es.getSalaireByEmployeIdJPQL(employeId);
	}
@Test
@Order(8)
public void TestGetSalaireMoyenByDepartementId(int departementId)
{
es.getSalaireMoyenByDepartementId(departementId);
}
@Test
@Order(9)
public void TestGetTimesheetsByMissionAndDate(Employe employe, Mission mission,Date dateDebut,Date dateFin)
{
	es.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
}
@Test
@Order(10)
public void TestAffecterEmployeADepartement(int employeId, int depId)
{
	es.affecterEmployeADepartement(employeId, depId);
}
}