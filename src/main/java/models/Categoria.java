package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Entity
@Table(name = "tb_categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
	@Column(name = "idcategoria")
	private int id;

	@Column(name = "descripcion")
	private String descripcion;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return descripcion;
	}
	public void setCategoria(String categoria) {
		this.descripcion = categoria;
	}
	
	
}
