package Productos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Productos;

public class Demo04 {
	public static void main(String[] args) {

	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	// Obtener el DAO
	EntityManager em = fabrica.createEntityManager();
	List<Productos> lstUsuarios2 = em.createQuery("Select p from Productos p", Productos.class).getResultList();
	for (Productos p : lstUsuarios2) {
			System.out.println(">>> " + p);
			
			

		}

	}

	}
	
