import java.util.Objects;

public class MappingPoliceViolence implements Comparable<MappingPoliceViolence>{
	private String name,gender,race,date,streetAdress,city,state,zip,county,agencyresp,causeOfDeath;
	private int age;
	private MappingPoliceViolence(ViolenceBuilder builder) {
		
	this.name=builder.name;
	this.gender=builder.gender;
	this.race=builder.race;
	this.date=builder.date;
	this.streetAdress= builder.streetAdress;
	this.city=builder.city;
	this.state= builder.state;
	this.zip= builder.zip;
	this.county = builder.county;
	this.agencyresp=builder.agencyresp;
	this.causeOfDeath= builder.causeOfDeath;
	this.age= builder.age;
	
}

@Override
public boolean equals(Object obj) {
boolean isEquals;
	
	if (obj instanceof MappingPoliceViolence) {
		 
		MappingPoliceViolence nE= (MappingPoliceViolence)obj;
		
		int nId= nE.age;
		String nName= nE.name;
		if((age==nId) &&( name.equalsIgnoreCase(nName))&&(agencyresp.equalsIgnoreCase(nE.agencyresp))&& 
				(causeOfDeath.equalsIgnoreCase(nE.causeOfDeath))&&(city.equalsIgnoreCase(city))&&(county.equalsIgnoreCase(nE.county))&&
				(date.equalsIgnoreCase(nE.date))&&(gender.equalsIgnoreCase(nE.gender))&&(state.equalsIgnoreCase(nE.state))&&(race.equalsIgnoreCase(nE.race))
				&&(streetAdress.equalsIgnoreCase(nE.streetAdress) && zip.equalsIgnoreCase(nE.zip))){
		
			isEquals= true;
		}else {
			isEquals= false;
		}
	
     }else {
    	 
	isEquals= false;
	}
	return isEquals;
}

@Override
public String toString() {
	return "MappingPoliceViolence [name=" + name + ", gender=" + gender + ", race=" + race + ", date=" + date
			+ ", streetAdress=" + streetAdress + ", city=" + city + ", state=" + state + ", zip=" + zip + ", county="
			+ county + ", agencyresp=" + agencyresp + ", causeOfDeath=" + causeOfDeath + ", age=" + age + "]";
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getRace() {
	return race;
}
public void setRace(String race) {
	this.race = race;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getStreetAdress() {
	return streetAdress;
}
public void setStreetAdress(String streetAdress) {
	this.streetAdress = streetAdress;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public String getCounty() {
	return county;
}
public void setCounty(String county) {
	this.county = county;
}
public String getAgencyresp() {
	return agencyresp;
}
public void setAgencyresp(String agencyresp) {
	this.agencyresp = agencyresp;
}
public String getCauseOfDeath() {
	return causeOfDeath;
}
public void setCauseOfDeath(String causeOfDeath) {
	this.causeOfDeath = causeOfDeath;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

	
	@Override
	public int compareTo(MappingPoliceViolence o) {
		if( Integer.compare(age, o.age)!=0) {
			 return Integer.compare(age, o.age);
		}else {
			return this.name.compareToIgnoreCase(o.name);
		}


	}
	public static class ViolenceBuilder{
		private String name,gender,race,date,streetAdress,city,state,zip,county,agencyresp,causeOfDeath;
		private int age;

	public ViolenceBuilder(String name,String gender,String race) {
		this.name=name;
		this.gender= gender;
		this.race=race;
		
	}
	public ViolenceBuilder age(int age) {
		this.age= age;
		return this;
	}
	public ViolenceBuilder causeOfDeath(String causeOfDeath) {
		this.causeOfDeath= causeOfDeath;
		return this;
	}
	public ViolenceBuilder county(String county) {
		this.county=county;
		return this;
	}
	public ViolenceBuilder agencyresp(String agencyresp) {
		this.agencyresp= agencyresp;
		return this;
	}
public ViolenceBuilder date(String date) {
	this.date= date;
	return this;
}
public ViolenceBuilder streetAdress(String street) {
	this.streetAdress= street;
	return this;
}
public ViolenceBuilder city(String city) {
	this.city=city;
	return this;
}
public ViolenceBuilder state(String state) {
	this.state= state;
	return this;
}
public ViolenceBuilder zip(String zip) {
	this.zip=zip;
	return this;
}
public MappingPoliceViolence build() {
	return new MappingPoliceViolence(this);
}
	}
	
}



