import javax.swing.JOptionPane;


public class Application {
	public void start(){
		
		String Choice = "1"; //trigger for big while
		int times = 0; //the times is use to calc average and make sure when no data type in no output 
		double alltotal = 0; //whole total sale
		String Bestsalename = null; //the name of best saler
		double lastsaletotal = 0; //last loop sale value
		String Name; //sale's name
		double saletotal; //total of one sale
		String num1; //item1 number
		String num2; //item2 number
		String num3; //item3 number
		String num4; //item4 number
		int item1total = 0; //total number for item1
		int item2total = 0; //total number for item2
		int item3total = 0; //total number for item3
		int item4total = 0; //total number for item4
		String bestnum = null; //the name of best sold item
		String bestitemtotal = null; // the number of best sold item
			
		while(Choice != "0")//trap
		{
			int x = 1; //trigger of the new sale loop
			int t1 = 0; //trigger of the item1 num loop
			int t2 = 0; //trigger of the item2 num loop
			int t3 = 0; //trigger of the item3 num loop
			int t4 = 0; //trigger of the item4 num loop
			int t5 = 0; //trigger of the item5 num loop
			int item1num = 0; //int version of num1
			int item2num = 0; //int version of num2
			int item3num = 0; //int version of num3
			int item4num = 0; //int version of num4
			
			
			Name = JOptionPane.showInputDialog("Please enter a sale's name.");
			
			if	(Name==null) {
			}// end if
			else if(validate(Name)) {  // if is true or else is false
				//JOptionPane.showMessageDialog(null, "You entered " + Name);
				while(t1!=1) {
					num1 = JOptionPane.showInputDialog("Enter number of Item1");
				 	if(num1==null) {
				 		t1 = t2 = t3 = t4 = t5 = 1;
				 	}
				 	else if(validateNum(num1)) {
						item1num = Integer.parseInt(num1);
						item1total = item1total + item1num;
						t1 = 1;
					}
					else {
						JOptionPane.showMessageDialog(null, "You entered an invalid input.");
						}	
					}	 
				while(t2!=1) {
				num2 = JOptionPane.showInputDialog("Enter number of Item2");
			 		if(num2==null) {
			 			t1 = t2 = t3 = t4 = t5 = 1;
			 		}
			 		else if(validateNum(num2)) {
						item2num = Integer.parseInt(num2);
						item2total = item2total + item2num;
						t2 = 1;
					}
					else {
						JOptionPane.showMessageDialog(null, "You entered an invalid input.");
					}	
				}	
				while(t3!=1) {
				num3 = JOptionPane.showInputDialog("Enter number of Item3");
			 		if(num3==null) {
			 			t1 = t2 = t3 = t4 = t5 = 1;
			 		}
			 		else if(validateNum(num3)) {
						item3num = Integer.parseInt(num3);
						item3total = item3total + item3num;
						t3 = 1;
					}
					else {
						JOptionPane.showMessageDialog(null, "You entered an invalid input.");
					}	
				}	
				while(t4!=1) {
				num4 = JOptionPane.showInputDialog("Enter number of Item4");
					if(num4==null) {
						t1 = t2 = t3 = t4 = t5 = 1;
					}
					else if(validateNum(num4)) {
						item4num = Integer.parseInt(num4);
						item4total = item4total + item4num;
						t4 = 1;
					} 
					else {
						JOptionPane.showMessageDialog(null, "You entered an invalid input.");
					}	
				}	
				if(t5!=1) {
				saletotal = 239.99 * item1num + 129.75 * item2num + 99.95 * item3num + 350.89 * item4num;
				JOptionPane.showMessageDialog(null,"Saler's name is " +Name + ".\n" + "The sale is " + String.format("$%.2f",saletotal) +".\n"
						+ "The weekly earning is " + String.format("$%.2f",(saletotal*0.09 +200))+"($200+"+String.format("$%.2f",(saletotal*0.09))+").");
				alltotal = alltotal + saletotal;
					if (lastsaletotal <= saletotal) {// an if else to update new best saler's name
						Bestsalename = Name;
					}else {
					}//end if else
					
					
				lastsaletotal = saletotal;
				
				
				times = times + 1;
				
				
				} else {
				}	
				}//end big if
			else {
				JOptionPane.showMessageDialog(null, "You entered an invalid name. \nOnly letters, period(.), and single quotation(') are available.");
			}//end big else
			while (x!=0) {
				String input = JOptionPane.showInputDialog("Do you want to continue to input another sale's data? Yes or Exit.");
				if(input == null){
					x = 0;
					Choice = "0";
				}
				else if(input.equals("Yes")){
					x = 0;
					Choice = "1";
				}
				else if(input.equals("Exit")){
					x = 0;
					Choice = "0";
				
				}
				else {
					JOptionPane.showMessageDialog(null, "You entered an invalid choice.");
				}
				}//end x while
		}//end big while


		//find the most sale
		if ((item1total>item2total)&&(item1total>item3total)&&(item1total>item4total)) {
			bestnum = "1";
			bestitemtotal = String.valueOf(item1total);
		}
		else if ((item2total>item1total)&&(item2total>item3total)&&(item2total>item4total)) {
			bestnum = "2";
			bestitemtotal = String.valueOf(item2total);
		}
		else if ((item3total>item1total)&&(item3total>item2total)&&(item3total>item4total)) {
			bestnum = "3";
			bestitemtotal = String.valueOf(item3total);
		}
		else if ((item4total>item1total)&&(item4total>item2total)&&(item4total>item3total)) {
			bestnum = "4";
			bestitemtotal = String.valueOf(item4total);
		}
		if(times>=1) {
		JOptionPane.showMessageDialog(null,"Best saler is " +Bestsalename + ".\n" + "The total sale is " + String.format("$%.2f",alltotal) +".\n" 
				+ "The average sale is " +String.format("$%.2f",(alltotal/times)) + ".\n" 
				+ "The item sold best is item" + bestnum + ". There are "+ bestitemtotal + " item"+bestnum +" sold!!!");
		}
		else {
			
		}
		}//end start

	public boolean validate(String input) {//loop through strings char array looking for #
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
	
	public boolean validateNum(String input) {//loop through strings # array looking for #
		if(input.equals("")) {
			return false;
		}else {
		String validNum = "0123456789";
		char testint;
		for(int i=0; i<input.length(); i++) {// i++ = i+1
			testint = input.charAt(i);
			if(validNum.indexOf(testint)<0) { // if char is in testChar
				return false;
			}//end if
		}//end for
		return true;
		}
	}//end boolean
}//end class
