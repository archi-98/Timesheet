package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
