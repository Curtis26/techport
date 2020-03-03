
public class Sealions extends Animals {
	protected int numofSpots;
	
	@Override
	public void specialInfo(double a,int NumofSpots,String c) {
		String ns;
		this.numofSpots = NumofSpots;
		ns = Integer.toString(this.numofSpots);
		this.setSpecialInfo(ns);
	};
	
	@Override
	public void printReport(){
		String newReport;
		newReport = "Animal: " + this.getAnimalName() + "\n"
				  + "Species: " + this.getSpecies() + "\n"
				  + "Sex: " + isSex() + "\n"
				  + "Weight: " + this.getWeight() + "KG" + "\n"
				  + "GPS: " + this.getGPSInfo() + "\n"
				  + "Number of Spots: " + this.getSpecialInfo() + " Spots" + "\n"
				  + "\n";
		this.setReport(newReport);
	}
	
	public Sealions() {};
}