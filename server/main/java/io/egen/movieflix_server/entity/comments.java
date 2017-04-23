package io.egen.movieflix_server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
@NamedQueries({ 
		@NamedQuery(name = "comments.findByTitle", query = "select c from comments c inner join c.movies m where m.id = :pId"),
		@NamedQuery(name = "comments.findAll", query = "select c FROM comments c")
})

public class comments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private users user;
	
	@ManyToOne
	@JoinColumn(name = "movie")
	private movies movie;
	
	@Column(name = "comment")
	private String comment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public users getUser() {
		return user;
	}
	public void setUser(users user) {
		this.user = user;
	}
	public movies getMovie() {
		return movie;
	}
	public void setMovie(movies movie) {
		this.movie = movie;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
