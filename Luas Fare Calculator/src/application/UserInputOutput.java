package application;
import java.util.Scanner;

public class UserInputOutput {

	//euro symbol does not work
    public static final String euroSymbol = "€";

    public static int takesIntegerNumberOfDays(){

        Scanner scanner = new Scanner(System.in);

        //keeps looping till user inputs a valid integer

        System.out.println("How many consecutive days would you like to have access to the luas?");

        int numOfDays = scanner.nextInt();

        while (numOfDays< 1){

            System.out.println("How many consecutive days would you like to have access to the luas?");
            numOfDays = scanner.nextInt();

        }

        return numOfDays;

    }

    public static int takesIntegerNumberOfZones(){

        Scanner scanner = new Scanner(System.in);

        //keeps looping till user inputs a valid integer

        System.out.println("How many zones are you travelling?");

        int numOfZones = scanner.nextInt();

        while (numOfZones< 1){

            System.out.println("How many zones are you travelling?");
            
            if (numOfZones > 5) {
            	numOfZones = 5;
            }
            
            numOfZones = scanner.nextInt();

        }

        return numOfZones;

    }

    public static String takesStringPassengerType(){

        Scanner scanner = new Scanner(System.in);

        //keeps loop till the user enters a valid string

        System.out.println("If you are a child please type \"child\".If you are a student or young adult please type \"student\"." +
                "If you are an adult please type \"adult\".");

        String typeOfPassengerString = scanner.next().trim().toLowerCase();

        while (!typeOfPassengerString.trim().toLowerCase().equals("adult") && !typeOfPassengerString.trim().toLowerCase().equals("child") &&
                !typeOfPassengerString.trim().toLowerCase().equals("student")){

            System.out.println("If you are a child please type \"child\". If you are a student or young adult please type \"student\"." +
                    "If you are an adult please type \"adult\".");

            typeOfPassengerString  = scanner.next().trim().toLowerCase();
        }

        return typeOfPassengerString;

    }

 public static String stringForNumOfZones(int numOfZones) {
    	
    	if (numOfZones >= 5) {
    		return "flexi";
    	} else if (numOfZones == 4) {
    		return "four zone";
    	} else if (numOfZones == 3) {
    		return "three zone";
    	} else if (numOfZones == 2) {
    		return "two zone";
    	} else {
    		return "one zone";
    	}
    	
    	
    }
 
    public static String stringForAdult( int numberOf1DayPasses, int numberOf7DayPasses ,int numOfZones ,double price){
    	
    	

        if (numberOf7DayPasses == 0){

            return "Your best option is to buy " + numberOf1DayPasses + " one day adult flexi tickets."
                    +" This will cost you " + euroSymbol+String.format("%.2f", price)+".";

        }

       else if (numberOf1DayPasses == 0){

            return "Your best option is to buy " + numberOf7DayPasses + " seven day adult "+ stringForNumOfZones(numOfZones)  +" tickets."
                    +" This will cost you " + euroSymbol+ String.format("%.2f", price)+".";
        }
       else {

            return "Your best option is to buy " + numberOf7DayPasses + " seven day adult "+ stringForNumOfZones(numOfZones) + " tickets and "+ numberOf1DayPasses+" one day adult flexi tickets."
                    +" This will cost you " + euroSymbol+ String.format("%.2f", price)+".";

        }

    }
    
   
    



    public static String stringForChild( int numberOf1DayPasses, int numberOf7DayPasses ,int numOfZones, double price){

        if (numberOf7DayPasses == 0){

            return "Your best option is to buy " + numberOf1DayPasses + " one day child flexi tickets."
                    +" This will cost you " + euroSymbol+String.format("%.2f", price)+".";

        }

        else if (numberOf1DayPasses == 0){

            return "Your best option is to buy " + numberOf7DayPasses + " seven day child "+stringForNumOfZones(numOfZones)+" tickets."
                    +" This will cost you " + euroSymbol+ String.format("%.2f", price)+".";
        }
        else {

            return "Your best option is to buy " + numberOf7DayPasses + " seven day child "+stringForNumOfZones(numOfZones)+" tickets and "+ numberOf1DayPasses+" one day child flexi tickets."
                    +" This will cost you " + euroSymbol+ String.format("%.2f", price)+".";

        }

    }

    public static String stringForStudent(  int numberOf1DayPasses, int numberOf7DayPasses, int numberOf30DayPasses,int numOfZones, double price){

        //only 7 and 30 day passes required
        if (numberOf1DayPasses == 0 && numberOf7DayPasses != 0 && numberOf30DayPasses !=0 ){

            return "Your best option is to buy "+ numberOf30DayPasses+ " thirty day student "+stringForNumOfZones(numOfZones)+" tickets and " +
                    numberOf7DayPasses + " seven day student "+stringForNumOfZones(numOfZones)+" tickets. This will cost you "+ euroSymbol+String.format("%.2f", price)+".";

            //only 1 and 30 day passes required
        } else if (numberOf1DayPasses!= 0 && numberOf7DayPasses == 0 && numberOf30DayPasses !=0 ){
            return "Your best option is to buy "+ numberOf30DayPasses+ " thirty day student "+stringForNumOfZones(numOfZones)+" tickets and " +
                      numberOf1DayPasses+ "one day adult flexi tickets. This will cost you "+ euroSymbol+String.format("%.2f", price)+".";

            //only 1 and 7 day passes required
        } else if (numberOf1DayPasses!= 0 && numberOf7DayPasses != 0 && numberOf30DayPasses == 0 ){
            return "Your best option is to buy " + numberOf7DayPasses + " seven day student "+stringForNumOfZones(numOfZones)+" tickets and " + numberOf1DayPasses+ " adult flexi" +
                    " tickets. This will cost you "+ euroSymbol+String.format("%.2f", price)+".";

            //only 30 day passes required
        } else if (numberOf1DayPasses== 0 && numberOf7DayPasses == 0 && numberOf30DayPasses !=0){
            return "Your best option is to buy " + numberOf30DayPasses + " thirty day student "+stringForNumOfZones(numOfZones)+" tickets."
                    +" This will cost you " + euroSymbol+String.format("%.2f", price)+".";

            //only 1 day passes required
        }else if (numberOf1DayPasses!= 0 && numberOf7DayPasses == 0 && numberOf30DayPasses ==0){
            return "Your best option is to buy " + numberOf1DayPasses + " one day adult flexi tickets."
                    +" This will cost you " + euroSymbol+String.format("%.2f", price)+".";

            //only 7 day required
        } else if (numberOf1DayPasses== 0 && numberOf7DayPasses != 0 && numberOf30DayPasses ==0) {

            return "Your best option is to buy " + numberOf7DayPasses + " seven day student "+stringForNumOfZones(numOfZones)+" tickets."
                    +" This will cost you " + euroSymbol+String.format("%.2f", price)+".";

            //all passes required
        } else /*if (numberOf1DayPasses!= 0 && numberOf7DayPasses != 0 && numberOf30DayPasses !=0) */{
            return "Your best option is to buy "+ numberOf30DayPasses + " thirty day student "+stringForNumOfZones(numOfZones)+" tickets and " +
                    numberOf7DayPasses + " seven day student "+stringForNumOfZones(numOfZones)+" tickets and " + numberOf1DayPasses+ " adult flexi" +
                    " tickets. This will cost you "+ euroSymbol+String.format("%.2f", price)+".";
        }

    }

}





