package Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuarios;

public class Demo05 {

	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: find info - new user, them delete
		Usuarios u = em.find(Usuarios.class, 6);

		if (u==null) {
			System.out.println("Usuario no Existe");
		}else {
			System.out.println("Usuario encontrado: "+u.getNombre());
			System.out.println(u);
		}

		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("ELIMINACIÓN OK");
		em.close();
		
	}
	
}
