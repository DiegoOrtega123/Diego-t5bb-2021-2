package Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Usuarios;

public class Demo08 {

	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// Procesos: find info - new user
		//Usuarios u = em.find(Usuarios.class, 1);//busca segun llave primaria
		//-- validar usando usuario y clave
		String sql = "select u from Usuarios u where u.usuario = :xusr and u.clave = :xcla";
		TypedQuery<Usuarios>query=em.createQuery(sql,Usuarios.class);
		query.setParameter("xusr","U002@gmail.com");
		query.setParameter("xcla","10002");
		
		Usuarios u = null;
		try {
			u= query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}

		if (u==null) {
			System.out.println("Usuario no existe");
		}else {
			System.out.println("usuario no encontrado: "+u.getNombre());
			System.out.println(u);
		}

		em.close();
		
	}
}
