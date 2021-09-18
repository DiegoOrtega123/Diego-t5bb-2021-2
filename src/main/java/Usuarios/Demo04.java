package Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuarios;

public class Demo04 {

	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: find info - new user
		Usuarios u = em.find(Usuarios.class, 1);

		if (u==null) {
			System.out.println("USER DOESN'T EXIST");
		}else {
			System.out.println("USER FOUND: "+u.getNombre());
			System.out.println(u);
		}

		em.close();
		
	}
	
}
