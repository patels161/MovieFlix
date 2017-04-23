package io.egen.movieflix_server.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movies")
@NamedQueries({
		@NamedQuery(name = "movies.findByTitle", query = "SELECT m FROM movies m WHERE m.title= :pTitle"),
	//	@NamedQuery(name = "movies.findByTitle", query = "SELECT m FROM movies m WHERE m.title=:pTitle ORDER BY m.year DESC"),
		@NamedQuery(name = "movies.findAll", query = "SELECT m FROM movies m ORDER BY m.title ASC"),
		@NamedQuery(name = "movies.findByYear", query = "SELECT m FROM movies m WHERE m.year=:pYear ORDER BY m.title ASC"),
		@NamedQuery(name = "movies.findByGenre", query = "select m from movies m inner join m.genre g where g.category = :pGenre ORDER BY m.title ASC"),
})

public class movies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(unique=true, name="title")
	private String title;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "rated")
	private String rated;
	
	@Column(name = "date_released")
	@JsonFormat(pattern = "dd mm yyyy")
	private Date released;
	
	@Column(name = "runtime")
	private String runtime;
	
	@ManyToMany
	@JoinColumn(name = "genre")
	private Set<genre> genre;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "writer")
	private String writer;
	
	
	@Column(name = "plot")
	private String plot;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "actors")
	private String actors;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "awards")
	private String awards;
	
	@Column(name = "poster")
	private String poster;
	
	@Column(name = "metaScore")
	private int metaScore;
	
	@Column(name = "imdbRating")
	private int imdbRating;
	
	@Column(name = "imdbId")
	private String imdbId;
	
	@Column(name = "imdbVotes")
	private int imdbVotes;
	
	@Column(name = "type")
	private String type;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public Date getReleased() {
		return released;
	}
	public void setReleased(Date released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public Set<genre> getGenre() {
		return genre;
	}
	public void setGenre(Set<genre> genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	public int getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(int imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "movies [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ",  plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metaScore=" + metaScore + ", imdbRating="
				+ imdbRating + ", imdbId=" + imdbId + ", imdbVotes=" + imdbVotes + ", type=" + type + "]";
	}
	

	
}
  