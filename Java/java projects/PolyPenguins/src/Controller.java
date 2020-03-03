import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controller {
	
	public void writeFile(ArrayList<String> List)
	{
		 BufferedWriter bw = null;
	      try {
	    	  File file = new File("./Records.txt");

		  if (!file.exists()) {
		     file.createNewFile();
		  }

		  FileWriter fw = new FileWriter(file);
		  bw = new BufferedWriter(fw);
			 for(int a=0; a<List.size();a++) {
				 bw.append(List.get(a)+"\n");
			 }
		  	JOptionPane.showMessageDialog(null,"File written");

	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null,e.getMessage());
		}
		finally
		{ 
		   try{
		      if(bw!=null)
			 bw.close();
		   }catch(Exception e){
		       JOptionPane.showMessageDialog(null, "Error in closing the BufferedWriter "+e.getMessage());
		    }
		}
	
	}//end writeFile()

	public String readFile(){
			String allFile = "";
			try
			{
				BufferedReader br = Files.newBufferedReader(Paths.get("./Records.txt"));
				String CurrentLine = br.readLine();
				while(CurrentLine!=null){
					allFile = allFile + CurrentLine + "\n";
					CurrentLine = br.readLine();
				}//while stuff to read
				br.close();
			}
			catch(IOException e1)//only IO exception types
			{
				JOptionPane.showMessageDialog(null,e1.getMessage());//explain error to user
			}
			catch(Exception e)//any exception type
			{
				JOptionPane.showMessageDialog(null,e.getMessage());//explain error to user
			}
			return allFile;
		}//end doRead()

	
}//end class
