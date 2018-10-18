package customerlist.java;

import java.io.*;

import javax.swing.JOptionPane;
/**
 *
 * @author conas1290
 */
public class CustomerList {
  public static void main(String [] args) throws IOException {
    //Variable setup
    String userInput,myLine,customerName,customerAddress,customerCity,customerProvince,customerPCode;
    int customerAmount;

       BufferedReader readFile = new BufferedReader(
       new FileReader("CustomerList.txt"));
      System.out.println("Displaying previous Customers:");
   
      //read all the lines of the selected file
   
    do{
      myLine = readFile.readLine();
      if (myLine != null){
      System.out.println(myLine);
      } else{}
    } while(myLine != null);
   
     readFile.close();
    
     PrintWriter fileOut = new PrintWriter(new FileWriter("CustomerList.txt",true));
     customerAmount =  Integer.parseInt(JOptionPane.showInputDialog("How many customers are there?"));
     for(int i = 1; i <= customerAmount; i++){
      
      //Enter users info
      customerName =  JOptionPane.showInputDialog("Enter Customer Name     ");
      customerAddress =  JOptionPane.showInputDialog("Enter " + customerName + "'s Address");
      customerCity =  JOptionPane.showInputDialog("Enter " + customerName + "'s City");
      customerProvince =  JOptionPane.showInputDialog("Enter " + customerName + "'s Province");
      customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code");
     
      //Output directly to file
      fileOut.println("Name: " + customerName);
      fileOut.println("Address: " + customerAddress);
      fileOut.println("City: " + customerCity);
      fileOut.println("Province: " + customerProvince);
      fileOut.println("Postal Code: " + customerPCode);
      fileOut.println(" ");
     
      //System print for testing
      System.out.println("Name: " + customerName);
      System.out.println("Address: " + customerAddress);
      System.out.println("City: " + customerCity);
      System.out.println("Province: " + customerProvince);
      System.out.println("Postal Code: " + customerPCode);
      fileOut.println(" ");
    }
    //The file must be closed after writing is complete
    fileOut.close();
  }    
}
