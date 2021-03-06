package de.hsb.app.moneydouble.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entität die alle Informationen zu einem getätigen Spielzug des Benutzers enthält.
 */
@Entity
@NamedQueries({
	@NamedQuery(name=Spielzug.FIND_ALL, query="SELECT s FROM Spielzug s"),
	@NamedQuery(name=Spielzug.FIND_BY_USER, query="SELECT s FROM Spielzug s WHERE s.user = :user ORDER BY s.timestamp DESC"),
	@NamedQuery(name=Spielzug.COUNT_GUESS_DISTRIBUTION_BY_USER, query="SELECT s.guess, COUNT(s.guess) FROM Spielzug s "
			+ "WHERE s.user = :user AND s.guess is not null GROUP BY s.guess ORDER BY s.guess"),
	@NamedQuery(name=Spielzug.COUNT_RESULT_DISTRIBUTION_BY_USER, query="SELECT s.result, COUNT(s.result) FROM Spielzug s "
			+ "WHERE s.user = :user AND s.result is not null GROUP BY s.result ORDER BY s.result")
})
public class Spielzug implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Spielzug.findAll";
	public static final String FIND_BY_USER = "Spielzug.findByUser";
	public static final String COUNT_GUESS_DISTRIBUTION_BY_USER = "Spielzug.countGuessDistributionByUser";
	public static final String COUNT_RESULT_DISTRIBUTION_BY_USER = "Spielzug.countResultDistributionByUser";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Benutzer user;
	private Integer moneyAmount;
	private RouletteColor guess;
	private RouletteColor result;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	public Spielzug(){
		
	}
	
	public Spielzug(Benutzer user, Integer moneyAmount, RouletteColor guess, RouletteColor result, Date timestamp) {
		super();
		this.user = user;
		this.moneyAmount = moneyAmount;
		this.guess = guess;
		this.result = result;
		this.timestamp = timestamp;
	}
	
	public Benutzer getUser() {
		return user;
	}
	public void setUser(Benutzer user) {
		this.user = user;
	}
	public Integer getMoneyAmount() {
		return moneyAmount;
	}
	public void setMoneyAmount(Integer moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	public RouletteColor getGuess() {
		return guess;
	}
	public void setGuess(RouletteColor guess) {
		this.guess = guess;
	}
	public RouletteColor getResult() {
		return result;
	}
	public void setResult(RouletteColor result) {
		this.result = result;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Spielzug [id=" + id + ", user=" + user.getUsername() + ", moneyAmount=" + moneyAmount + ", guess=" + guess
				+ ", result=" + result + ", timestamp=" + timestamp + "]";
	}

}
