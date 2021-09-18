package Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuarios;

public class Demo03 {

	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: delete new user
		Usuarios u = new Usuarios();
		u.setCodigo(10);
		
		// reg, act, elim -> Transacciones
		em.getTransaction().begin();
		em.remove(u); //eliminar
		em.getTransaction().commit();
		System.out.println("ELIMINACIÓN OK");
		em.close();
		
	}
	
}
