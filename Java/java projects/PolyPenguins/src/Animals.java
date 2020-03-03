
public abstract class Animals {
	
	protected String AnimalName;
	protected String Species;
	protected Boolean Sex;
	protected String Weight;
	protected String GPSInfo;
	protected String SpecialInfo;
	protected String Report;
	
	
	public Animals(){};//default constructor
	
	//constructors
	public Animals(String animalName,String species,Boolean sex,String weight,String gPSInfo,String report) {
		super();
		AnimalName = animalName;
		Species = species;
		Sex = sex;
		Weight = weight;
		GPSInfo = gPSInfo;
		Report = report;
	}
	
	public abstract void specialInfo(double a,int b,String c);
	
	public abstract void printReport();
	
	public String isSex() {
		if(getSex()==true) {
			return "Male";
		}
		else {
			return "Female";
		}
	};
	
	//getters and setters
	public String getAnimalName() {
		return AnimalName;
	}


	public void setAnimalName(String animalName) {
		AnimalName = animalName;
	}


	public String getSpecies() {
		return Species;
	}


	public void setSpecies(String species) {
		Species = species;
	}


	public Boolean getSex() {
		return Sex;
	}


	public void setSex(Boolean sex) {
		Sex = sex;
	}


	public String getWeight() {
		return Weight;
	}


	public void setWeight(String weight) {
		Weight = weight;
	}


	public String getGPSInfo() {
		return GPSInfo;
	}


	public void setGPSInfo(String gPSInfo) {
		GPSInfo = gPSInfo;
	}


	public String getSpecialInfo() {
		return SpecialInfo;
	}


	public void setSpecialInfo(String specialInfo) {
		SpecialInfo = specialInfo;
	}


	public String getReport() {
		return Report;
	}


	public void setReport(String report) {
		Report = report;
	}
}//end class
