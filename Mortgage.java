import java.math.*;
import java.text.NumberFormat;
import java.util.Scanner;



public class Mortgage{

public static void main(String[] args) 
{
    //ALL of my variables 
    final int month = 12;
    final int Ir = 100;
    int principle = 0;
    double rate = 0;
    int year = 0;
    Scanner scanner = new Scanner(System.in);

// loop to check Principle 
    while(true){
    System.out.print("Principle: ");
    principle = scanner.nextInt();
    if(principle > 1000000 || principle < 1000){
    System.out.println("Please enter a valid principle between 1,000 and 1,000,000");
    continue;
    }
    break;
}
//loop to check and get rate 
    while(true){
    System.out.print("Rate: ");
     rate = scanner.nextDouble();
    if(rate > 30 || rate <= 0)
    {
        System.out.println("Please enter a rate between 0 and 30");
        continue;
    }
    rate = (rate/Ir) / month ;
    break;
}

//loop to get and check years
while(true){
    System.out.print("Years: ");
    year = scanner.nextByte();
    if(year > 30 || year <= 0){
    continue;
    }
    year = year * month; 
  break;
}
// MATH AND FORMAT TO FOR OUR MONTHLY PAYMENT 
double monthlyPayment = principle * (rate * Math.pow((1+rate), year)) / (Math.pow((1+rate),year) -1 );
NumberFormat payment = NumberFormat.getCurrencyInstance();
String MPayment = payment.format(monthlyPayment);
    System.out.println("Your Payment " + MPayment);
  
  scanner.close();
}

}
