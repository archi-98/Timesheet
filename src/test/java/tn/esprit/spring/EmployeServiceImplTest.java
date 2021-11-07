package tn.esprit.spring;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
public class EmployeServiceImplTest {
@Autowired
IEmployeService es;
@Autowired
EmployeRepository er;
@Autowired
ContratRepository cr;

@Test
@Order(1)
public void testAjouterEmploye(){
	Employe e=new Employe("haraghi", "takwa", "takwa@esprit.tn", true, Role.INGENIEUR);
	int id=es.ajouterEmploye(e);
	Assertions.assertEquals(id,e.getId());
}
 
@Test
@Order(2)
public void testMettreAjourEmailByEmployeId(){
es.mettreAjourEmailByEmployeId("takwa.hraghi@esprit.tn", 3);
Assertions.assertEquals("takwa.hraghi@esprit.tn",er.findById(3).get().getEmail());
}
@Test
@Order(3)
public void testGetAllEmployes(){
	es.getAllEmployes();
}

@Test
@Order(4)
public void testAjouterContrat()throws ParseException {

	Date d = new SimpleDateFormat("dd-MM-yyyy").parse("03-05-2021");
	Contrat c =new Contrat(d, "CDI", 2000);
	int id = es.ajouterContrat(c);
	Assertions.assertEquals(id,c.getReference());

	
}

@Test
@Order(5)
public void testAffecterContratAEmploye(){
	es.affecterContratAEmploye(23,1);
}

@Test
@Order(6)
public void testGetEmployePrenomById(){
	es.getEmployePrenomById(1);
	Assertions.assertEquals("takwa",es.getEmployePrenomById(1));
}
@Test
@Order(7)
public void testDeleteEmployeById(){
	es.deleteEmployeById(12);
	Assertions.assertNull(er.findById(12).orElse(null));
	
}

@Test
@Order(8)
public void testDeleteContratById(){
	es.deleteContratById(11);
	Assertions.assertNull(cr.findById(11).orElse(null));

}
@Test
@Order(9)
public void testDesaffecterEmployeDuDepartement(){
	//es.desaffecterEmployeDuDepartement(2, 1);
}





@Test
@Order(10)
public void testGetNombreEmployeJPQL(){
	
  es.getNombreEmployeJPQL();
 
	
}
@Test
@Order(11)
public void TestGetAllEmployeNamesJPQL()
{
	es.getAllEmployeNamesJPQL();
}






@Test
@Order(12)
public void TestGetAllEmployeByEntreprise()
{
//	Entreprise entreprise=new Entreprise("Esprit","RS");
 //es.getAllEmployeByEntreprise(entreprise);
}

@Test 
@Order(13)
public void TestMettreAjourEmailByEmployeIdJPQL()
{
es.mettreAjourEmailByEmployeIdJPQL("takwa.hraghi@esprit.tn", 50);
}
@Test
@Order(14)
public void TestDeleteAllContratJPQL()
{
	es.deleteAllContratJPQL();
}
@Test
@Order(15)
public void TestgetSalaireByEmployeIdJPQL()
{
	es.getSalaireByEmployeIdJPQL(3);
	}
@Test
@Order(16)
public void TestGetSalaireMoyenByDepartementId()
{
es.getSalaireMoyenByDepartementId(1);
}


@Test
@Order(17)
public void TestGetTimesheetsByMissionAndDate()throws ParseException{

 // Employe e=new Employe("haraghi", "takwa", "takwa@esprit.tn", true, Role.INGENIEUR);
   // Mission m=new Mission("BB","DD");
    //Date dateDebut = new SimpleDateFormat("dd-MM-yyyy").parse("03-05-2021");
    //Date dateFin = new SimpleDateFormat("dd-MM-yyyy").parse("03-06-2021");
    
	//es.getTimesheetsByMissionAndDate(e, m, dateDebut, dateFin);
}
@Test
@Order(18)
public void TestAffecterEmployeADepartement()
{
	es.affecterEmployeADepartement(1,1);
}

}