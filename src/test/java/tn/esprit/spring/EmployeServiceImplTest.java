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
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
public class EmployeServiceImplTest {
@Autowired
IEmployeService es;

 
@Test
@Order(1)
public void testAjouterEmploye(){
	Employe e=new Employe("othmeni", "eya", "eya@esprit.tn", true, Role.INGENIEUR);
	int id=es.ajouterEmploye(e);
	Assertions.assertEquals(id,e.getId());
}

@Test
@Order(2)
public void testMettreAjourEmailByEmployeId(){
	es.mettreAjourEmailByEmployeId("takwa.hraghi@esprit.tn", 2);
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
	es.affecterContratAEmploye(1, 1);
}

@Test
@Order(6)
public void testGetEmployePrenomById(){
	es.getEmployePrenomById(1);
}
@Test
@Order(7)
public void testDeleteEmployeById(){
	es.deleteEmployeById(3);
}

@Test
@Order(8)
public void testDeleteContratById(){
	es.deleteContratById(2);
}
@Test
@Order(9)
public void testDesaffecterEmployeDuDepartement(){
	//es.desaffecterEmployeDuDepartement(2, 1);
}
}
