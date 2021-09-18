package Usuarios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Usuarios;

public class Demo07 {
	public static void main(String[] args) {
		// Especificar BD CONECTION
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		 // listado de todos los usuarios
		TypedQuery<Usuarios>query=em.createQuery("select u from Usuarios u",Usuarios.class);
		
		List<Usuarios> lstUsuarios = query.getResultList();
		System.out.println("Cantidad de Usuarios :" + lstUsuarios.size());
		
		if (lstUsuarios.size()==0) {
			System.out.println("Listado Vacio");
		}else {
			System.out.println("Listado de Usuarios");
			for (Usuarios u : lstUsuarios) {
				System.out.println(">>>" + u);
			}
		}
		
List<Usuarios> lstUsuarios2 = em.createQuery("Select u from Usuarios u", Usuarios.class).getResultList();
		System.out.println("Cantidad de usuarios : " + lstUsuarios2.size());
		if (lstUsuarios2.size() == 0) {
			System.out.println("Listado vacío");
		} else {
			System.out.println("-- Listado de usuarios --");
			for (Usuarios u : lstUsuarios2) {
				System.out.println(">>> " + u);

			}

		}
		
       //Listado con parametros -> listado de usuarios por tipo
		//Select*from tb_usuarios where idtipo = ?
		String sql = "select u from Usuarios u where u.tipo = :xtipo";
		TypedQuery<Usuarios>query3=em.createQuery(sql,Usuarios.class);
		query3.setParameter("xtipo",1);
		List<Usuarios> lstUsuarios3 = query.getResultList();
		
		System.out.println("Cantidad de Usuarios :" + lstUsuarios3.size());
			System.out.println("Listado de Usuarios tipo 1--");
			for (Usuarios u : lstUsuarios3) {
				System.out.println(">>>" + u);
			
		}

		em.close();
	}
}
