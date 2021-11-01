package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
public class EmployeServiceImplTest {
@Autowired
IEmployeService es;

@Test
@Order(10)
public int testgetNombreEmployeJPQL(){
	
  return es.getNombreEmployeJPQL();
	
}

}
