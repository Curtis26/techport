import java.util.regex.Pattern;

public class Validator {

	public boolean validateBP(String input) {//loop through strings char array looking for wrong input
		if(input.equals("")) {
			return false;
		}else {
		String validChars = "1234567890.";
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
	
	public boolean validateWeight(String input) {//loop through strings char array looking for wrong input
		if(input.equals("")) {
			return false;
		}else {
		String validChars = "1234567890.";
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
	
	public boolean validateNumSpots(String input) {//loop through strings char array looking for wrong input
		if(input.equals("")) {
			return false;
		}else {
		String validChars = "1234567890";
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
	
	public boolean validateDH(String input) {//loop through strings char array looking for wrong input
		if(input.equals("")) {
			return false;
		}else {
		String[] status = {"good","average","poor"};
		for(int i=0; i<3; i++) {
			if(status[i].equals(input)) { // 
				return true;
			}//end if
		}
		return false;
		}
	}//end boolean
	
	public boolean validateGPS(String input) {
		
		boolean result = Pattern.matches("^\\d{2}\\.\\d{7}"+ " " + "-\\d{2}\\.\\d{7}$", input);
		if(result)
			return true;
		else
			return false;
	}
}
