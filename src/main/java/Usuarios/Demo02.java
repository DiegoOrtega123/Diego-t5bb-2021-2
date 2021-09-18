package Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Usuarios;

public class Demo02 {

	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: update new user
		Usuarios u = new Usuarios();
		u.setCodigo(1);
		u.setNombre("Diego");
		u.setApellido("Ortega");
		u.setUsuario("diego@gmail.com");
		u.setClave("diego");
		u.setFnacim("2020/05/07");
		u.setTipo(1);
		u.setEstado(1);
		
		// reg, act, elim -> Transacciones
		em.getTransaction().begin();
		em.merge(u); //actualizar -> si existe codigo / si no existe, lo crea
		em.getTransaction().commit();
		System.out.println("ACTUALIZACION OK");
		em.close();
		
	}
	
	
}
