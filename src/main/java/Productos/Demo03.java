package Productos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Categoria;


public class Demo03 {
	

	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: find info - new user
		Categoria c = em.find(Categoria.class, 2);

		if (c==null) {
			System.out.println("Categoria no existe");
		}else {
			System.out.println("Categoria Encontrada: "+c.getCategoria());
			System.out.println(c);
		}

		em.close();
		
	}

}
