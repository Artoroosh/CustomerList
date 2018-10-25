/*
Corbin Nash
25/10/2018
This programs adds customer data to CustomerList.txt
*/
package customerlist.java;
import java.io.*;
import javax.swing.JOptionPane;
public class CustomerList {
  public static void main(String [] args) throws IOException {
    //Variable setup
    String userInput,myLine,info,customerAmountStrg,customerPCode;
    int customerAmount;
    BufferedReader readFile = new BufferedReader(
    new FileReader("CustomerList.txt"));
      System.out.println("Displaying previous Customers:");
      //try statement
      try{  
           //read all the lines of the customer list and 
        do{
          myLine = readFile.readLine();
          if (myLine != null){
          System.out.println(myLine);
          } else{}
         } while(myLine != null);
         //catch if the file is not found
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
    	}
         readFile.close(); 
    try{
     PrintWriter fileOut = new PrintWriter(new FileWriter("CustomerList.txt",true));
  //ask user to input # of customers and force them to use
  customerAmountStrg = JOptionPane.showInputDialog("How many customers are there?");
   while(customerAmountStrg.length() == 0||!Character.isDigit(customerAmountStrg.charAt(0))){
     JOptionPane.showMessageDialog(null,"Invalid input");
     customerAmountStrg = JOptionPane.showInputDialog("How many customers are there?");}
     customerAmount = Integer.parseInt(customerAmountStrg);
     for(int i = 1; i <= customerAmount; i++){
     //Enter Users info abd add it to one string
     info = "Name: "+ JOptionPane.showInputDialog("Enter Customer Name");
     info += "\nAddress: " + JOptionPane.showInputDialog("Enter Customer's Address");
     info += "\nCity: "+ JOptionPane.showInputDialog("Enter Customer's City");
     info += "\nProvince: " + JOptionPane.showInputDialog("Enter Customer's Province");
     //Postal code can't be checked
     customerPCode =  JOptionPane.showInputDialog("Enter Customer's Postal Code"+"L#L #L# \n MUST HAVE SPACE");
     //Makes sure the postal code is angry
      while(!Character.isLetter(customerPCode.charAt(0)) && !Character.isDigit(customerPCode.charAt(1))
      &&!Character.isLetter(customerPCode.charAt(2)) && !Character.isWhitespace(customerPCode.charAt(3))
      &&!Character.isDigit(customerPCode.charAt(4)) && !Character.isDigit(customerPCode.charAt(6)))
      {JOptionPane.showMessageDialog(null,"Invalid input");
       customerPCode =  JOptionPane.showInputDialog("Enter Customer's Postal Code"+"L#L #L#");}   
      //Add postal code to data
      info += "\nPostal Code: " + customerPCode;
      //Output directly to file  
      fileOut.println(info);   
      fileOut.println(" ");
      //Print for user
      System.out.println(info);}
      //The file must be closed after writing is complete
      fileOut.close();
          }
    catch(FileNotFoundException e){
        System.out.println("File does not exist or could not be found.");
        System.err.println("FileNotFoundException: " + e.getMessage());
          }
     catch(IOException e){
       System.out.println("Problem reading file.");
       System.err.println("IOException: " + e.getMessage());
          }
  }    
}
