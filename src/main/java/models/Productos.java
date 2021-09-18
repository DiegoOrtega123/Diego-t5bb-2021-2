package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Entity
@Table(name = "tb_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productos {
	@Id
	@Column(name = "idprod")
	private String idprod;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "precio")
	private int precio;
	
	@Column(name = "idcategoria")
	private int idcategoria;
	
	@Column(name = "estado")
	private int estado;
	
	
	
	

}
