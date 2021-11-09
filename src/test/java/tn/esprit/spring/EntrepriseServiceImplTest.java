package tn.esprit.spring;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@SpringBootTest
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService ent;

	
	@Test
	@Order(1)
	public int testAjouterEntreprise(){
		
		Entreprise etrp = new Entreprise("test3", "25");
		Assertions.assertEquals(etrp.getName(),ent.ajouterEntreprise(etrp).getName());
		return 1;
		
	}

	@Test
	@Order(2)
	public void testAjouterDepartement(){
		
		Departement dep =new Departement("info");
		Integer id=ent.ajouterDepartement(dep);
		Assertions.assertEquals(id, dep.getId());
	}
	
	@Test
	@Order(3)
	public void testAffecterDepartementAEntreprise(){
		ent.affecterDepartementAEntreprise(16, 5);
	}
	
	@Test
	@Order(4)
	public void testGetAllDepartementsNamesByEntreprise(){
		 ent.getAllDepartementsNamesByEntreprise(3);
		
		
	}
	
	@Test
	@Order(5)
	public void testDeleteEntrepriseById(){
		ent.deleteEntrepriseById(17);
		Assertions.assertNull(ent.getEntrepriseById(17));
	}
	
	@Test
	@Order(6)
	public void testDeleteDepartementById(){
		ent.deleteDepartementById(11);
		Assertions.assertNull(ent.getDepartementById(11));
	}
	
	@Test
	@Order(7)
	public void testGetEntrepriseById(){
		Entreprise e= ent.getEntrepriseById(5);
		Assertions.assertEquals(e.getId(),5 );
		
	}
}
