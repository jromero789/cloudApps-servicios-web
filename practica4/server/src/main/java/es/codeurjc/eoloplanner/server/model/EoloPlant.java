package es.codeurjc.eoloplanner.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EoloPlant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String city;
	private int progress;
	private boolean completed;
	private String planning;

	public EoloPlant() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getPlanning() {
		return planning;
	}

	public void setPlanning(String planning) {
		this.planning = planning;
	}

	@Override
	public String toString() {
		return "EoloPlant{" +
				"id=" + id +
				", city='" + city + '\'' +
				", progress='" + progress + '\'' +
				", completed='" + completed + '\'' +
				", planning='" + planning + '\'' +
				'}';
	}
}
