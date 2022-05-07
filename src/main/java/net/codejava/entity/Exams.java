package net.codejava.entity;


import java.sql.*;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Exams {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long room;	
	
	private long code;
	private Date date;
	private Time time;
	
 
	public Exams() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exams(long code, long room, Date date, Time time) {
		super();
		this.code = code;
		this.room = room;
		this.date = date;
		this.time = time;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public long getRoom() {
		return room;
	}
	public void setRoom(long room) {
		this.room = room;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

}