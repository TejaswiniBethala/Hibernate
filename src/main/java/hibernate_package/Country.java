package hibernate_package;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	@Id
	private int CountryCode;
	private String CountryName;
	
	@OneToMany(targetEntity=States.class,cascade=CascadeType.ALL)
	private List<States> states = new ArrayList<States>();

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(int countryCode) {
		CountryCode = countryCode;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public List<States> getStates() {
		return states;
	}

	public void setStates(List<States> states) {
		this.states = states;
	}
	

}
