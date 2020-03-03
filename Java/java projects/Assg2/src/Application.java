import java.util.Arrays;
import javax.swing.*;//for JOptionPane
public class Application {
	
	public void start() {
		boolean allSeats[][] = new boolean[4][4];
		String [] seatResearch = new String[16];
		int i =0;
		while (true) {		
		try {
			String seatType = "3";
			String classType = "3";
			if(allSeats[1][3]==true && allSeats[1][2]==true && allSeats[3][3]==true && allSeats[3][2]==true){
				JOptionPane.showMessageDialog(null, "The plane is full.");
				showResearch(seatResearch);
				System.exit(0);
			}
			String Name = getName();
			if(allSeats[1][3]==true && allSeats[1][2]==true){
			String classReroll = ecChoice();
				if(classReroll.equals("y")||classReroll.equals("Yes")||classReroll.equals("Y")||classReroll.equals("yes")) {
					classType = "2";
					seatType = getseatType();
					}
				else if(classReroll.equals("n")||classReroll.equals("No")||classReroll.equals("N")||classReroll.equals("no")) {
					JOptionPane.showMessageDialog(null, "Next flight leaves in 3 hours.");
				}
			}
			else if(allSeats[3][3]==true && allSeats[3][2]==true){
			String classReroll = fcChoice();
				if(classReroll.equals("y")||classReroll.equals("Yes")||classReroll.equals("Y")||classReroll.equals("yes")){
					classType = "1";
					seatType = getseatType();
					}
				else if(classReroll.equals("n")||classReroll.equals("No")||classReroll.equals("N")||classReroll.equals("no")) {
					JOptionPane.showMessageDialog(null, "Next flight leaves in 3 hours.");
				}
			}
			else {
				classType = getclassType();
				seatType = getseatType();
			}
			

			if(classType.equals("1")&& seatType.equals("1") && allSeats[1][3]!=true){
				String passInfo = firstClass(allSeats, Name);
				seatResearch[i]=passInfo;
				i += 1;
			}
			else if(classType.equals("1")&& seatType.equals("1") && allSeats[1][3]==true){
				String passInfo = fcAuto(allSeats, Name);
				seatResearch[i]=passInfo;
				i += 1;
			}
			else if(classType.equals("1")&& seatType.equals("2") && allSeats[1][2]!=true){
				String passInfo = fcAuto(allSeats, Name);
				seatResearch[i]=passInfo;
				i += 1;
			}
			else if(classType.equals("1")&& seatType.equals("2") && allSeats[1][2]==true){
				String passInfo = firstClass(allSeats, Name);
				seatResearch[i]=passInfo;
				i += 1;
			}
			else if(classType.equals("2")&& seatType.equals("1") && allSeats[3][3]!=true){
				String passInfo = ecoClass(allSeats, Name);
				seatResearch[i]=passInfo;
				i += 1;
			}
			else if(classType.equals("2")&& seatType.equals("1") && allSeats[3][3]==true){
				String passInfo = ecAuto(allSeats, Name);
				seatResearch[i]=passInfo;
				i += 1;
			}
			else if(classType.equals("2")&& seatType.equals("2") && allSeats[3][2]!=true){
				String passInfo = ecAuto(allSeats, Name);
				seatResearch[i]=passInfo;
				i += 1;
			}
			else if(classType.equals("2")&& seatType.equals("2") && allSeats[3][2]==true){
				String passInfo = ecoClass(allSeats, Name);
				seatResearch[i]=passInfo;
				i += 1;
			}
			else {
			}		
			}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Thank you for using!\nBye!");
			System.exit(0);
			}
		}
	}//end start	
	
	public String firstClass(boolean[][] allSeats, String Name) {
		String passInfo = null;
		for(int row = 0; row <2; row++) {
			if(allSeats[row][0]==false) {
				allSeats[row][0] = true;
				JOptionPane.showMessageDialog(null,String.format(Name+" First Class Row %d Seat 1 Window",row+1));
				passInfo = String.format(Name+" First Class Row %d Seat 1 Window",row+1);
				break;
				}
			else if (allSeats[row][3]==false) {
				allSeats[row][3] = true;
				JOptionPane.showMessageDialog(null,String.format(Name+" First Class Row %d Seat 4 Window",row+1));
				passInfo = String.format(Name+" First Class Row %d Seat 4 Window",row+1);
				break;
				}
			}
		return passInfo;
	}
	
	public String fcAuto(boolean[][] allSeats, String Name) {
		String passInfo = null;
		for(int row = 0; row <2; row++) {
			if(allSeats[row][1]==false) {
				allSeats[row][1] = true;
				JOptionPane.showMessageDialog(null,String.format(Name+" First Class Row %d Seat 2 Isle",row+1));
				passInfo = String.format(Name+" First Class Row %d Seat 2 Isle",row+1);
				break;
				}
			else if (allSeats[row][2]==false) {
				allSeats[row][2] = true;
				JOptionPane.showMessageDialog(null,String.format(Name+" First Class Row %d Seat 3 Isle",row+1));
				passInfo = String.format(Name+" First Class Row %d Seat 3 Isle",row+1);
				break;
				}
		}
		return passInfo;
	}
	
	public String ecoClass(boolean[][] allSeats, String Name) {
		String passInfo = null;
		for(int row = 2; row <4; row++) {
			if(allSeats[row][0]==false) {
				allSeats[row][0] = true;
				JOptionPane.showMessageDialog(null,String.format(Name+" Economy Class Row %d Seat 1 Window",row+1));
				passInfo = String.format(Name+" Economy Class Row %d Seat 1 Window",row+1);
				break;
				}
			else if (allSeats[row][3]==false) {
				allSeats[row][3] = true;
				JOptionPane.showMessageDialog(null,String.format(Name+" Economy Class Row %d Seat 4 Window",row+1));
				passInfo = String.format(Name+" Economy Class Row %d Seat 4 Window",row+1);
				break;
				}
			}
		return passInfo;
	}
	
	public String ecAuto(boolean[][] allSeats, String Name) {
		String passInfo = null;
		for(int row = 2; row <4; row++) {
			if(allSeats[row][1]==false) {
				allSeats[row][1] = true;
				JOptionPane.showMessageDialog(null,String.format(Name+" Economy Class Row %d Seat 2 Isle",row+1));
				passInfo = String.format(Name+" Economy Class Row %d Seat 2 Isle",row+1);
				break;
				}
			else if (allSeats[row][2]==false) {
				allSeats[row][2] = true;
				JOptionPane.showMessageDialog(null,String.format(Name+" Economy Class Row %d Seat 3 Isle",row+1));
				passInfo = String.format(Name+" Economy Class Row %d Seat 3 Isle",row+1);
				break;
				}
		}
		return passInfo;
	}
	
	public String getName() {
		while(true){
		String Name = JOptionPane.showInputDialog("Please enter passenger name.\nCaution! Press Cancel or Exit button will quit the program.");
		if(validateName(Name) == true){
			return Name;
		}else {
			JOptionPane.showMessageDialog(null, "You entered an invalid name. \nOnly letters, period(.), and single quotation(') are available.");
		}
		}
	}
	
	public String fcChoice() {
		while(true){
		String Choice = JOptionPane.showInputDialog("The Economy Class is full.\nDo you accept the First Class? Yes(y) or No(n)?");
		if(validateChoice(Choice) == true){
			return Choice;
		}else {
			JOptionPane.showMessageDialog(null, "You entered an invalid input.");
		}
		}
	}
	
	public String ecChoice() {
		while(true){
		String Choice = JOptionPane.showInputDialog("The First Class is full.\nDo you accept the Economy Class? Yes(y) or No(n)?");
		if(validateChoice(Choice) == true){
			return Choice;
		}else {
			JOptionPane.showMessageDialog(null, "You entered an invalid input.");
		}
		}
	}
	
	public String getclassType() {
		while(true){
		String classType = JOptionPane.showInputDialog("Please type 1 for First Class or 2 for Economy");
		if(classType == null) {
			JOptionPane.showMessageDialog(null, "You entered an invalid input.");
		}
		else if(validateType(classType) == true){
			return classType;
		}else {
			JOptionPane.showMessageDialog(null, "You entered an invalid input.");
		}
		}
	}
	
	public String getseatType() {
		while(true){
		String classType = JOptionPane.showInputDialog("Please type 1 for Window or 2 for Isle");
		if(classType == null) {
			JOptionPane.showMessageDialog(null, "You entered an invalid input.");
		}
		else if(validateType(classType) == true){
			return classType;
		}else {
			JOptionPane.showMessageDialog(null, "You entered an invalid input.");
		}
		}
	}
	
	public boolean validateName(String input) {//loop through strings char array looking for wrong input
		if(input.equals("")) {
			return false;
		}else {
		String validChars = "abcdefghijklmnopqrstuvwxyz'. ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char testChar;
		for(int i=0; i<input.length(); i++) {// i++ = i+1
			testChar = input.charAt(i);
			if(validChars.indexOf(testChar)<0) { // if char is in testChar
				return false;
			}//end if
		}//end for
		return true;
		}
	}//end boolean

	public boolean validateType(String input) {//loop through strings char array looking for wrong input
		if(input.equals("")) {
			return false;
		}else {
		String validChars = "12";
		char testChar;
		for(int i=0; i<input.length(); i++) {// i++ = i+1
			testChar = input.charAt(i);
			if(validChars.indexOf(testChar)<0) { // if char is in testChar
				return false;
			}//end if
		}//end for
		return true;
		}
	}//end boolean
	
	public boolean validateChoice(String input) {
		if(input.equals("")||input.equals(null)) {
			return false;
		}else {
		String validChars = "ynYesNo";
		char testChar;
		for(int i=0; i<input.length(); i++) {// i++ = i+1
			testChar = input.charAt(i);
			if(validChars.indexOf(testChar)<0) { // if char is in testChar
				return false;
			}//end if
		}//end for
		return true;
		}
	}//end boolean
	
	public void showResearch(String [] seatResearch) {//ref:https://zhidao.baidu.com/question/251870986.html
		String[] arrayToSort = seatResearch;
		String report = "";
		Arrays.sort(arrayToSort,String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < arrayToSort.length; i++)
		{
		report = report + arrayToSort[i]+"\n";
		}
		JOptionPane.showMessageDialog(null,"Here is the research:\n\n" + report);
	}

}//end class