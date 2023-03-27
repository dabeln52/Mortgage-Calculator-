import java.text.Format;
import java.text.NumberFormat;
import java.util.Scanner;



public class Mortgage{
    final static int  month = 12;
    final static int Ir = 100;
public static void main(String[] args) 
{
// get and check Principle from the readNumber method 
int principle = (int)readNumber("Principle: ", 1000, 1000000);

//get and check rate using the readNumber method  
double rate = readNumber("Rate: ", 0, 30);

//loop to get and check years
int year = (int)readNumber("Years: ", 1, 30);

double monthlyPayment = calculateMortgage(principle, rate, year);
String payment = NumberFormat.getCurrencyInstance().format(monthlyPayment);

System.out.println("MORTGAGE ");
System.out.println("--------");
System.out.println("Monthly Payments: " + payment);
System.out.println("PAYMENT SCHEDULE");
System.out.println("-----------------");
for(int i = 1; i <= year * month; i++){
    double balance = paymentSchedule(principle, rate, year, i);
    String balanceFormat = NumberFormat.getCurrencyInstance().format(balance);
    System.out.println(balanceFormat);
}



}

public static double readNumber(String prompt, double min, double max){
     Scanner scanner = new Scanner(System.in);
     double value;
        while(true){
            System.out.println(prompt);
            value = scanner.nextDouble();
            if(value <= max || value >= min)
            
                break;
            System.out.println("Please enter a valid value between " + min + " and " + max);
            scanner.close();
        }
        
        return value;
    }


public static double calculateMortgage(
    int principle, 
    double rate,
    int year){
        int numOfPayments = year * month;
        double monthlyRate = (rate/Ir) / month ;

        double monthlyPayment = principle * (monthlyRate * Math.pow((1+monthlyRate), numOfPayments)) / (Math.pow((1+monthlyRate),numOfPayments) -1 );

        return monthlyPayment;

}

public static double paymentSchedule(int principle, double rate, int year, int numOfPayments){

    int NumOfMonths = year * month;
    double monthlyRate = (rate/Ir) / month ;

double balance =  principle * (Math.pow(1 + monthlyRate, NumOfMonths) - Math.pow(1 + monthlyRate, numOfPayments)
) / (Math.pow(1 + monthlyRate, NumOfMonths) -1);

return balance;
}
}
