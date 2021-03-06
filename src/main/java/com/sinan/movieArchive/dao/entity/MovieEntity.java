package com.sinan.movieArchive.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sinan.movieArchive.dao.enums.GENRE;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * MovieEntity, entity based on movies table
 *
 * @author Pezhman Jahanmard
 */
@Entity
@Table(name = "movies")
public class MovieEntity extends BaseEntity {
	@Column
	private String name;

	@Column(columnDefinition = "SMALLINT")
	@Min(1970)
	@Max(2016)
	private Integer year;

	@Column(name = "avg_rating")
	@Digits(integer = 1, fraction = 2)
	@Min(0)
	@Max(5)
	private BigDecimal avgRating;

	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	private GENRE genre;

	@Column
	private String director;

	@OneToMany(mappedBy = "movieEntity")
	private List<RateEntity> rateEntities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(BigDecimal avgRating) {
		if (avgRating == null) {
			avgRating = BigDecimal.ZERO;
		}
		this.avgRating = avgRating.setScale(2, RoundingMode.CEILING);
	}

	public GENRE getGenre() {
		return genre;
	}

	public void setGenre(GENRE genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@JsonIgnore
	@XmlTransient
	public List<RateEntity> getRateEntities() {
		return rateEntities;
	}

	public void setRateEntities(List<RateEntity> rateEntities) {
		this.rateEntities = rateEntities;
	}
}
