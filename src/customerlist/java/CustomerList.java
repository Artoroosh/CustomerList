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
    String userInput,myLine,customerName,customerAddress,customerCity,customerProvince,customerPCode,customerAll,customerAmountStrg;
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
		} catch (IOException e) {
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
       customerAmountStrg = JOptionPane.showInputDialog("How many customers are there?");
   }
     customerAmount = Integer.parseInt(customerAmountStrg);
     for(int i = 1; i <= customerAmount; i++){

      //Enter Users info
      customerName =  JOptionPane.showInputDialog("Enter Customer Name     ");
      customerAddress =  JOptionPane.showInputDialog("Enter " + customerName + "'s Address");
      customerCity =  JOptionPane.showInputDialog("Enter " + customerName + "'s City");
      customerProvince =  JOptionPane.showInputDialog("Enter " + customerName + "'s Province");
      customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code"+"L#L #L# \n MUST HAVE SPACE");
     
      while(customerAmountStrg.length() == 0||Character.isDigit(customerPCode.charAt(0))){ 
          JOptionPane.showMessageDialog(null,"Invalid input");
          customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code"+"L#L #L#");
      }  
       while(customerAmountStrg.length() == 0||Character.isLetter(customerPCode.charAt(1))){ 
         JOptionPane.showMessageDialog(null,"Invalid input");
         customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code"+"L#L #L#");
      } 
      while(customerAmountStrg.length() == 0||Character.isDigit(customerPCode.charAt(2))){ 
         JOptionPane.showMessageDialog(null,"Invalid input");
         customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code"+"L#L #L#");
      }      
      while(customerAmountStrg.length() == 0||Character.isWhitespace(customerPCode.charAt(3))){ 
         JOptionPane.showMessageDialog(null,"Invalid input");
         customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code"+"L#L #L#");
      }  
      while(customerAmountStrg.length() == 0||Character.isLetter(customerPCode.charAt(4))){ 
          JOptionPane.showMessageDialog(null,"Invalid input");
          customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code"+"L#L #L#");
      }  
       while(customerAmountStrg.length() == 0||Character.isDigit(customerPCode.charAt(5))){ 
         JOptionPane.showMessageDialog(null,"Invalid input");
         customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code"+"L#L #L#");
      } 
      while(customerAmountStrg.length() == 0||Character.isLetter(customerPCode.charAt(6))){ 
         JOptionPane.showMessageDialog(null,"Invalid input");
         customerPCode =  JOptionPane.showInputDialog("Enter " + customerName + "'s Postal Code"+"L#L #L#");
      }      
       //make String with all the data
      customerAll = "Name: "+customerName + "\n" + "Address: "+customerAddress + "\n" 
      + "City: "+ customerCity + "\n" + "Province: " + customerProvince + 
      "\n" + "Postal Code: " + customerPCode;
      
  //Output directly to file  
      fileOut.println(customerAll);   
      fileOut.println(" ");
      //Print for user
      System.out.println(customerAll);
    }
    //The file must be closed after writing is complete
    fileOut.close();
    }
    catch(FileNotFoundException e) {
        System.out.println("File does not exist or could not be found.");
        System.err.println("FileNotFoundException: " + e.getMessage());
          }
    catch (IOException e) {
       System.out.println("Problem reading file.");
       System.err.println("IOException: " + e.getMessage());
   }
  
  }    
}
