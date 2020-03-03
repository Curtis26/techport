
public class Penguins extends Animals {
	protected double bloodPressure;
	
	@Override
	public void specialInfo(double BloodPressure,int b,String c) {
		String bp;
		this.bloodPressure = BloodPressure;
		bp = Double.toString(this.bloodPressure);
		this.setSpecialInfo(bp);
	};
	
	@Override
	public void printReport(){
		String newReport;
		newReport = "Animal: " + this.getAnimalName() + "\n"
				  + "Species: " + this.getSpecies() + "\n"
				  + "Sex: " + isSex() + "\n"
				  + "Weight: " + this.getWeight() + "KG" + "\n"
				  + "GPS: " + this.getGPSInfo() + "\n"
				  + "Blood Pressure: " + this.getSpecialInfo() + " mmHg" + "\n"
				  + "\n";
		this.setReport(newReport);
	}
	
	public Penguins() {};

}
