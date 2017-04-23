package io.egen.movieflix_server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="ratings")
@NamedQueries({ 
	@NamedQuery(name = "ratings.findByUMId", query = "select r from ratings r where r.users.id = :pUserId and r.movies.id = :pMovieId"),
	@NamedQuery(name = "ratings.findAll", query = "select avg(r.value) from ratings r where r.movies.id = :pMovieId")
})	
public class ratings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "movie")
	private movies movie;
	
	@JoinColumn(name = "rating")
	private int rating;
	
	@ManyToOne
	private users user;
	
	public movies getMovie() {
		return movie;
	}
	public void setMovie(movies movie) {
		this.movie = movie;
	}
	public users getUser() {
		return user;
	}
	public void setUser(users user) {
		this.user = user;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
