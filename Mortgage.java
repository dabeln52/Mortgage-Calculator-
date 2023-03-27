import java.text.NumberFormat;
import java.util.Scanner;



public class Mortgage{

public static void main(String[] args) 
{
// get and check Principle from the readNumber method 
int principle = (int)readNumber("Principle: ", 1000, 1000000);

//get and check rate using the readNumber method  
double rate = readNumber("Rate: ", 0, 30);

//loop to get and check years
int year = (int)readNumber("Years: ", 1, 30);

double monthlyPayment = calculateMortgage(principle, rate, year);
NumberFormat payment = NumberFormat.getCurrencyInstance();
String MPayment = payment.format(monthlyPayment);
System.out.println("Your Payment " + MPayment);
}

public static double readNumber(String prompt, double min, double max){
    try (Scanner scanner = new Scanner(System.in)) {
        double value;
        while(true){
            System.out.println(prompt);
            value = scanner.nextInt();
            if(value <= max || value >= min)
                break;
            System.out.println("Please enter a valid value between " + min + " and " + max);
        }
        return value;
    }
}

public static double calculateMortgage(
    int principle, 
    double rate,
    int year){
        
        final int month = 12;
        final int Ir = 100;

        int numOfPayments = year * month;
        double monthlyRate = (rate/Ir) / month ;

        double monthlyPayment = principle * (monthlyRate * Math.pow((1+monthlyRate), numOfPayments)) / (Math.pow((1+monthlyRate),numOfPayments) -1 );

        return monthlyPayment;

}
}
