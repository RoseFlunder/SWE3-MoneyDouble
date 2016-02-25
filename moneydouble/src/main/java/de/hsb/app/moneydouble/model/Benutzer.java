package de.hsb.app.moneydouble.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Benutzer.findAdminUser", query="select b from Benutzer b where b.username='admin'")
public class Benutzer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(unique=true)
	private String username;
	private String password;
	private Rolle rolle;
	
	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Kreditkarte kreditkarte;
	
	private Integer money;
	
	public Benutzer(){
		
	}
	
	public Benutzer(String username, String password, Rolle rolle, Date geburtsdatum, Integer money) {
		super();
		this.username = username;
		this.password = password;
		this.rolle = rolle;
		this.geburtsdatum = geburtsdatum;
	}

	public Kreditkarte getKreditkarte() {
		return kreditkarte;
	}

	public void setKreditkarte(Kreditkarte kreditkarte) {
		this.kreditkarte = kreditkarte;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public Rolle getRolle() {
		return rolle;
	}

	public void setRolle(Rolle rolle) {
		this.rolle = rolle;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
	

}
