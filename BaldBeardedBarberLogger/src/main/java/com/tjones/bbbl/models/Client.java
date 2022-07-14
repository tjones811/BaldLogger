package com.tjones.bbbl.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 2,message = "Name must be more than 2 characters!")
	private String name;
	
	@NotEmpty
	private String notes;
	
	@NotNull
	private String month;
	
	@NotNull
	private String day;
	
	@NotNull
	private String hour;
	
	@NotNull
	private String minute;
	
	@NotNull
	private String ampm;
	
	@NotNull
    @Min(value = 0)
    private Float price ;
	
	@NotEmpty
	@Size(min = 2,message = "Beard type must be more than 2 characters!")
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Client() {
		super();
	}
	public Client(@NotEmpty @Size(min = 2, message = "Name must be more than 2 characters!") String name,
			@NotEmpty String notes, @NotNull String month, @NotNull String day, @NotNull String hour,
			@NotNull String minute, @NotNull String ampm, @NotNull @Min(0) Float price,
			@NotEmpty @Size(min = 2, message = "Beard type must be more than 2 characters!") String type, User user) {
		super();
		this.name = name;
		this.notes = notes;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.ampm = ampm;
		this.price = price;
		this.type = type;
		this.user = user;
	}
	public Client(Long id, @NotEmpty @Size(min = 2, message = "Name must be more than 2 characters!") String name,
			@NotEmpty String notes, @NotNull String month, @NotNull String day, @NotNull String hour,
			@NotNull String minute, @NotNull String ampm, @NotNull @Min(0) Float price,
			@NotEmpty @Size(min = 2, message = "Beard type must be more than 2 characters!") String type, User user,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.notes = notes;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.ampm = ampm;
		this.price = price;
		this.type = type;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
		this.minute = minute;
	}
	public String getAmpm() {
		return ampm;
	}
	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
}
