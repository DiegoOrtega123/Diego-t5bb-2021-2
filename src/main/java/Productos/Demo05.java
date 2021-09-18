package Productos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Productos;


public class Demo05 {
	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: find info - new user, them delete
		Productos p = em.find(Productos.class, "P0032");
		

		if (p==null) {
			System.out.println("Producto no Existe");
		}else {
			System.out.println("Producto encontrado: "+p.getDescripcion());
			System.out.println(p);
		}

		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("ELIMINACIÓN OK");
		em.close();
		
	}
}
