package io.egen.movieflix_server.entity;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "genre")
@NamedQueries({ 
	@NamedQuery(name = "genre.findByCategory", query = "select g from genre g inner join g.movies m where m.id = :pGenre"),
	@NamedQuery(name = "genre.findAll", query = "SELECT g FROM genre g")
})
public class genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	//private movies Title;
	@JoinColumn(name = "category")
	private String Category;
	
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		this.Category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
