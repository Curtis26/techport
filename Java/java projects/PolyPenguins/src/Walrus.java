
public class Walrus extends Animals {
	protected String dentalH;
	
	@Override
	public void specialInfo(double a,int b,String DentalH) {
		String dh;
		this.dentalH = DentalH;
		dh = this.dentalH;
		this.setSpecialInfo(dh);
	};
	
	@Override
	public void printReport(){
		String newReport;
		newReport = "Animal: " + this.getAnimalName() + "\n"
				  + "Species: " + this.getSpecies() + "\n"
				  + "Sex: " + isSex() + "\n"
				  + "Weight: " + this.getWeight() + "KG" + "\n"
				  + "GPS: " + this.getGPSInfo() + "\n"
				  + "Dental Health: " + this.getSpecialInfo() + "\n"
				  + "\n";
		this.setReport(newReport);
	}
	
	public Walrus() {};
}