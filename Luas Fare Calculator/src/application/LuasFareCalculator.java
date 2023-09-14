package application;

public class LuasFareCalculator {

    // prices from https://luas.ie/1-7-30-day-tickets.html  20/08/2023


    LuasFareCalculator(int numOfDays, typeOfPassenger currentPassenger,int numOfZones){

        this.numOfDays = numOfDays;
        LuasFareCalculator.currentPassenger = currentPassenger;
        this.numOfZones = numOfZones;

    }

     enum typeOfPassenger {
        CHILD,
        STUDENT,
        ADULT
    }

    enum Time {
        DAY,
        WEEK,
        MONTH

    }


    private static typeOfPassenger currentPassenger;
    private final int numOfDays;
    private final int numOfZones;

    //constant regardless of the number of zones
    private static final double oneDayFlexiTicketAdult = 5.8;
    private static final double oneDayFlexiTicketChild = 2.4;

    //for 5 zones or greater

    private static final double sevenDayFlexiTicketAdult = 22.4;

    private static final double sevenDayFlexiTicketChild = 8.00;
    private static final double sevenDayFlexiTicketStudent = 15.6;
    //only available to students
    private static final double thirtyDayFlexiTicketStudent = 61;

    //for 4 zones

    private static final double sevenDay4ZoneAdult = 20.00;
    private static final double sevenDay4ZoneStudentOrYoungAdult = 14.00;
    private static final double sevenDay4ZoneChild = 8.00;
    private static final double thirtyDay4ZoneStudent = 55.00;

    //for 3 zones

    private static final double sevenDay3ZoneAdult = 20.00;
    private static final double sevenDay3ZoneStudentOrYoungAdult = 14.00;
    private static final double sevenDay3ZoneChild = 6.50;
    private static final double thirtyDay3ZoneStudent = 55.00;


    //for 2 zones

    private static final double sevenDay2ZoneAdult = 16.40;
    private static final double sevenDay2ZoneStudentOrYoungAdult = 12.00;
    private static final double sevenDay2ZoneChild = 6.50;
    private static final double thirtyDay2ZoneStudent = 47.00;



    //for 1 zone

    private static final double sevenDay1ZoneAdult = 13.20;
    private static final double sevenDay1ZoneStudentOrYoungAdult = 10.00;
    private static final double sevenDay1ZoneChild = 6.50;
    private static final double thirtyDay1ZoneStudent = 38.00;

   public String output;

   


    public static void main(String[] args) {

        int numOfDays = UserInputOutput.takesIntegerNumberOfDays();
        int numOfZones = UserInputOutput.takesIntegerNumberOfZones();
        String typeOfPassengerString = UserInputOutput.takesStringPassengerType() ;


        //the following switch statement instantiates an instance of the class with the type of passenger and number of days
        switch (typeOfPassengerString) {

            case "adult" -> {LuasFareCalculator luasFareCalculator = new LuasFareCalculator(numOfDays, typeOfPassenger.ADULT, numOfZones);
            luasFareCalculator.fareCalculator();
            }

            case "student" -> {LuasFareCalculator luasFareCalculator = new LuasFareCalculator(numOfDays, typeOfPassenger.STUDENT, numOfZones);
                luasFareCalculator.fareCalculator();
            }

            case "child" -> {LuasFareCalculator luasFareCalculator = new LuasFareCalculator(numOfDays, typeOfPassenger.CHILD, numOfZones);
                luasFareCalculator.fareCalculator();
            }
        }



    }


    public double fareCalculator() {

        if (getCurrentPassenger() == typeOfPassenger.ADULT) {

               return adultFareCalculator();

        } else if (getCurrentPassenger() == typeOfPassenger.STUDENT) {

            return studentFareCalculator();

        } else {

            return childFareCalculator();
        }


    }

    public double adultFareCalculator(){

        int numberOfSevenDaysPasses = 0;
        int numberOfOneDayPasses = 0;

                double price = 0;
                int remainingDays = getNumOfDays();

                while(remainingDays > integerConditionalLogicAdultWeek()){

                    price = price + priceOfTicketAdult(Time.WEEK);
                    remainingDays = remainingDays - 7;
                    numberOfSevenDaysPasses++;

                }

                while( remainingDays > 0){

                    price = price + priceOfTicketAdult(Time.DAY);
                    remainingDays--;
                    numberOfOneDayPasses++;

                }

                price = roundToTwoDecimalPlaces(price);
           //     System.out.println( UserInputOutput.stringForAdult(numberOfOneDayPasses,numberOfSevenDaysPasses,getNumOfZones(),price));
                setOutput( UserInputOutput.stringForAdult(numberOfOneDayPasses,numberOfSevenDaysPasses,getNumOfZones(),price));
                return price;

            }




    public double studentFareCalculator(){

        double price = 0;
        int numOf30DayPasses = 0;
        int numOfSevenDaysPasses = 0;
        int numOfOneDayPasses= 0;
        int remainingDays = getNumOfDays();

        while( remainingDays > integerConditionalLogicStudent(Time.MONTH)){

            price = price + priceOfTicketStudent(Time.MONTH);
            numOf30DayPasses++;
            remainingDays = remainingDays - 30;

        }


        while ( remainingDays > integerConditionalLogicStudent(Time.WEEK)){

            price = price + priceOfTicketStudent(Time.WEEK);
            numOfSevenDaysPasses++;
            remainingDays = remainingDays - 7;

        }


        //there is no one day student flexi ticket on the luas so adult tickets are being used
        while ( remainingDays > 0){

            price = price + priceOfTicketStudent(Time.DAY);
            numOfOneDayPasses++;
            remainingDays--;

        }
        price = roundToTwoDecimalPlaces(price);

      //  System.out.println( UserInputOutput.stringForStudent(numOfOneDayPasses,numOfSevenDaysPasses,numOf30DayPasses,getNumOfZones(),price));
        setOutput(UserInputOutput.stringForStudent(numOfOneDayPasses,numOfSevenDaysPasses,numOf30DayPasses,getNumOfZones(),price));
        return price;

    }


    public double childFareCalculator(){
        int numberOfSevenDaysPasses = 0;
        int numberOfOneDayPasses = 0;

            double price = 0;
            int remainingDays = getNumOfDays();

            while(remainingDays > integerConditionalLogicChildWeek()){

                price = price + priceOfTicketChild(Time.WEEK);
                remainingDays = remainingDays - 7;
                numberOfSevenDaysPasses++;

            }

            while( remainingDays > 0){

                price = price + priceOfTicketChild(Time.DAY);
                remainingDays--;
                numberOfOneDayPasses++;

            }


         //   System.out.println( UserInputOutput.stringForChild(numberOfOneDayPasses,numberOfSevenDaysPasses,getNumOfZones(),price));
            price = roundToTwoDecimalPlaces(price);
            setOutput( UserInputOutput.stringForChild(numberOfOneDayPasses,numberOfSevenDaysPasses,getNumOfZones(),price));



            return price;
        }



    //this method takes an enum variable and returns the price for a ticket of that many days and zones
    //checks passengerType, Number of zones and type of ticket;
    //this method was broken down into smaller methods
    public double priceOfTicket(Time time){


        if (currentPassenger == typeOfPassenger.ADULT){

            if (time == Time.DAY){

           return getOneDayFlexiTicketAdult();

            } else if (time == Time.WEEK) {
                if (getNumOfZones() > 4){

                    return getSevenDayFlexiTicketAdult();

                } else if ( getNumOfZones() == 4) {

                    return getSevenDay4ZoneAdult();

                } else if ( getNumOfZones() == 3) {

                    return getSevenDay3ZoneAdult();

                } else if ( getNumOfZones() == 2) {
                    return getSevenDay2ZoneAdult();

                } else if (getNumOfZones() == 1) {

                    return getSevenDay1ZoneAdult();

                }

            }


        } else if (currentPassenger == typeOfPassenger.STUDENT) {

            if (time == Time.DAY){

                return getOneDayFlexiTicketAdult();


            } else if (time == Time.WEEK) {
                if (getNumOfZones() > 4){
                    return getSevenDayFlexiTicketAdult();

                } else if ( getNumOfZones() == 4) {
                    return getSevenDay4ZoneStudentOrYoungAdult();

                } else if (getNumOfZones()== 3) {
                    return getSevenDay3ZoneStudentOrYoungAdult();

                } else if ( getNumOfZones() == 2) {
                    return getSevenDay2ZoneStudentOrYoungAdult();

                } else if (getNumOfZones() == 1) {
                    return getSevenDay1ZoneStudentOrYoungAdult();
                }


            } else if (time == Time.MONTH){

                if (getNumOfZones() > 4){
                    return getThirtyDayFlexiTicketStudent();

                } else if ( getNumOfZones() == 4 || getNumOfZones() == 3) {
                    return getThirtyDay4ZoneStudent();

                } else if ( getNumOfZones() == 2) {
                    return getThirtyDay2ZoneStudent();

                } else if (getNumOfZones() == 1) {
                    return getThirtyDay1ZoneStudent();
                }

            }


        } else if (currentPassenger == typeOfPassenger.CHILD) {

            if (time == Time.DAY){

                return getOneDayFlexiTicketChild();

            } else if (time == Time.WEEK) {
                if (getNumOfZones() > 4){
                    return getSevenDayFlexiTicketChild();

                } else if (getNumOfZones() == 4) {
                    return getSevenDay4ZoneChild();

                } else if ( getNumOfZones() == 3) {
                    return getSevenDay3ZoneChild();

                } else if ( getNumOfZones() == 2) {
                    return getSevenDay2ZoneChild();

                } else if (getNumOfZones() == 1) {
                    return getSevenDay1ZoneChild();

                }


            }
        }

    return -1;
}


    public double priceOfTicketAdult(Time time){


            if (time == Time.DAY){

                return getOneDayFlexiTicketAdult();

            } else /*if (time == Time.WEEK)*/ {
                if (getNumOfZones() > 4){

                    return getSevenDayFlexiTicketAdult();

                } else if ( getNumOfZones() == 4) {

                    return getSevenDay4ZoneAdult();

                } else if ( getNumOfZones() == 3) {

                    return getSevenDay3ZoneAdult();

                } else if ( getNumOfZones() == 2) {
                    return getSevenDay2ZoneAdult();

                } else /*if (getNumOfZones() == 1) */{

                    return getSevenDay1ZoneAdult();

                }

            }

    }


    public double priceOfTicketStudent(Time time){


            if (time == Time.DAY){

                return getOneDayFlexiTicketAdult();


            } else if (time == Time.WEEK) {
                if (getNumOfZones() > 4){
                    return getSevenDayFlexiTicketStudent();

                } else if ( getNumOfZones() == 4) {
                    return getSevenDay4ZoneStudentOrYoungAdult();

                } else if ( getNumOfZones() == 3) {
                    return getSevenDay3ZoneStudentOrYoungAdult();

                } else if ( getNumOfZones() == 2) {
                    return getSevenDay2ZoneStudentOrYoungAdult();

                } else if (getNumOfZones() == 1) {
                    return getSevenDay1ZoneStudentOrYoungAdult();
                }


            } else if (time == Time.MONTH){

                if (getNumOfZones() > 4){
                    return getThirtyDayFlexiTicketStudent();

                } else if ( getNumOfZones() == 4 || numOfZones == 3) {
                    return getThirtyDay4ZoneStudent();

                } else if ( getNumOfZones() == 2) {
                    return getThirtyDay2ZoneStudent();

                } else if (getNumOfZones() == 1) {
                    return getThirtyDay1ZoneStudent();
                }

            }


        return -1;
    }

    public double priceOfTicketChild(Time time) {



            if (time == Time.DAY) {

                return getOneDayFlexiTicketChild();

            } else  { //time == week
                if (getNumOfZones() > 4) {
                    return getSevenDayFlexiTicketChild();

                } else if (getNumOfZones() == 4) {
                    return getSevenDay4ZoneChild();

                } else if (getNumOfZones() == 3) {
                    return getSevenDay3ZoneChild();

                } else if (getNumOfZones() == 2) {
                    return getSevenDay2ZoneChild();

                } else  { //numOfZones ==1
                    return getSevenDay1ZoneChild();

                }


            }

        }



    //this method returns the integer for when it is more economical to buy a week rather than individual days etc
    //this method avoids repeating the same code many times
    //this method is used in the fare calculator methods
    //used in the while loop condition while remainingDays > returned int
   
  

    public int integerConditionalLogicAdultWeek() {

            if (getNumOfZones() > 4) {

                return 3;

            } else if (getNumOfZones() == 4) {

                return 3;

            } else if (getNumOfZones() == 3) {

                return 3;

            } else if (getNumOfZones() == 2) {
                return 2;

            } else{

                return 2;

            }

    }

    public int integerConditionalLogicStudent(Time time) {


            if (time == Time.WEEK) {
                if (getNumOfZones() > 4) {
                    return 2;

                } else if (getNumOfZones() == 4) {
                    return 2;

                } else if (getNumOfZones() == 3) {
                    return 2;

                } else if (getNumOfZones() == 2) {
                    return 2;

                } else if (getNumOfZones() == 1) {
                    return 1;
                }


            } else {

                if (getNumOfZones() > 4) {
                    return 23;
                } else if (getNumOfZones() == 4 ||getNumOfZones() == 3) {
                    return 23;

                } else if (getNumOfZones() == 2) {
                    return 22;

                } else  {
                    return 22;
                }

            }

        return -1;
    }


    public int integerConditionalLogicChildWeek() {

            if (getNumOfZones() > 4) {
                return 3;

            } else if (getNumOfZones() == 4) {
                return 3;

            } else if (getNumOfZones() == 3) {
                return 2;

            } else if (getNumOfZones() == 2) {
                return 2;

            } else  {
                return 2;

            }

    }


    private double roundToTwoDecimalPlaces(double price){

        price = price * 100;
        price = Math.round(price);
        price = price / 100;

        return price;

    }
    
    public String getOutput() {
 	   
  	  return output;
     }
     
     private void setOutput(String newOutput) {
  	   output = newOutput;
     }

    public int getNumOfZones() {
        return numOfZones;
    }

    private typeOfPassenger getCurrentPassenger() {
        return currentPassenger;
    }

    private int getNumOfDays() {
        return numOfDays;
    }


    //flexi ticket getters
    private static double getOneDayFlexiTicketAdult() {return oneDayFlexiTicketAdult;}

    private double getOneDayFlexiTicketChild() {
        return oneDayFlexiTicketChild;
    }

    private static double getSevenDayFlexiTicketAdult() {
        return sevenDayFlexiTicketAdult;
    }

    private double getSevenDayFlexiTicketStudent() {
        return sevenDayFlexiTicketStudent;
    }

    private double getSevenDayFlexiTicketChild() {
        return sevenDayFlexiTicketChild;
    }

    private double getThirtyDayFlexiTicketStudent() {
        return thirtyDayFlexiTicketStudent;
    }

    //4 zone getters
    private double getSevenDay4ZoneAdult(){
        return sevenDay4ZoneAdult;
    }

    private double getSevenDay4ZoneStudentOrYoungAdult(){
        return sevenDay4ZoneStudentOrYoungAdult;
    }

    private double getSevenDay4ZoneChild(){
        return sevenDay4ZoneChild;
    }
    private double getThirtyDay4ZoneStudent(){
        return thirtyDay4ZoneStudent;
    }

    //3 zone getters
    private double getSevenDay3ZoneAdult(){
        return sevenDay3ZoneAdult;
    }

    private double getSevenDay3ZoneStudentOrYoungAdult(){
        return sevenDay3ZoneStudentOrYoungAdult;
    }

    private double getSevenDay3ZoneChild(){
        return sevenDay3ZoneChild;
    }

    //not used as the thirtyDay4ZoneStudent getter method was used instead as they have the same value
    private double getThirtyDay3ZoneStudent(){
        return thirtyDay3ZoneStudent;
    }
    //2 zone getters
    private double getSevenDay2ZoneAdult(){
        return sevenDay2ZoneAdult;
    }

    private double getSevenDay2ZoneStudentOrYoungAdult(){
        return sevenDay2ZoneStudentOrYoungAdult;
    }

    private double getSevenDay2ZoneChild(){
        return sevenDay2ZoneChild;
    }
    private double getThirtyDay2ZoneStudent(){
        return thirtyDay2ZoneStudent;
    }
    //1 zone getters
    private double getSevenDay1ZoneAdult(){
        return sevenDay1ZoneAdult;
    }

    private double getSevenDay1ZoneStudentOrYoungAdult(){
        return sevenDay1ZoneStudentOrYoungAdult;
    }

    private double getSevenDay1ZoneChild(){
        return sevenDay1ZoneChild;
    }
    private double getThirtyDay1ZoneStudent(){
        return thirtyDay1ZoneStudent;
    }
}
