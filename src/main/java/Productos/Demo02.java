package Productos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Categoria;


public class Demo02 {
	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		 // listado de todos los usuarios
		
		
List<Categoria> lstCategoria = em.createQuery("Select u from Categoria u", Categoria.class).getResultList();
		System.out.println("Cantidad de Categorias : " + lstCategoria.size());
		if (lstCategoria.size() == 0) {
			System.out.println("Listado vacío");
		} else {
			System.out.println("-- Listado de Categorias --");
			for (Categoria u : lstCategoria) {
				System.out.println(">>> " + u);

			}

		}
		
      
		

		em.close();
	}
}
