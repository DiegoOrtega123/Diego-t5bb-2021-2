package Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuarios;

public class Demo01 {

	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: register new user
		Usuarios u = new Usuarios();
		u.setCodigo(6);
		u.setNombre("Leo");
		u.setApellido("Messi");
		u.setUsuario("messi10@gmail.com");
		u.setClave("barcaf");
		u.setFnacim("2021/07/24");
		u.setTipo(1);
		u.setEstado(1);
		
		// reg, act, elim -> Transacciones
		em.getTransaction().begin();
		em.persist(u); //registar
		em.getTransaction().commit();
		System.out.println("REGISTRO OK");
		em.close();
		
	}
	
}
