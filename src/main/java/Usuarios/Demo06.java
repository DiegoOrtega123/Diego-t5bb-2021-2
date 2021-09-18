package Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuarios;

public class Demo06 {
	public static void main(String[] args) {
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		// 3. empezar mi transacción
		em.getTransaction().begin();
		// 4. proceso
		Usuarios u = new Usuarios(7, "José", "Atúncar", "jatuncar@ciber.com", "123", "2000/10/15", 1, 1);
		em.persist(u);
		// 5. confirmar la transacción
		em.getTransaction().commit();
		em.close();
		
	}
	
}
