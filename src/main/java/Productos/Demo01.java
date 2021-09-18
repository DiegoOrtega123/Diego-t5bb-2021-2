package Productos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Productos;


public class Demo01 {
	
	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: register new Producto
		Productos p = new Productos ();
		p.setIdprod("P0032");
		p.setDescripcion("Almuerzo");
		p.setStock(4);
		p.setPrecio(12);
		p.setIdcategoria(2);
		p.setEstado(1);
		
		// reg, act, elim -> Transacciones
		em.getTransaction().begin();
		em.persist(p); //registar
		em.getTransaction().commit();
		System.out.println("REGISTRO DE PRODUCTO OK");
		em.close();
		
	}
}
