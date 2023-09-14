package application;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuasFareCalculatorTest {



    @Test
    void fareCalculator5Zones() {

        adultFareCalculator5Zones();
        studentFareCalculator5Zones();
        childFareCalculator5Zones();


    }


    @Test
    void adultFareCalculator5Zones() {

        adultGreaterThan3Days5Zones();
        adultLessThan4Days5Zones();

    }

    @Test
    void adultGreaterThan3Days5Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.ADULT, 5);
        assertEquals( 22.4 , luasFareCalculator1.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(4, LuasFareCalculator.typeOfPassenger.ADULT, 5);
        assertEquals( 22.4, luasFareCalculator2.fareCalculator() );

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.ADULT, 5);
        assertEquals( 28.2, luasFareCalculator3.fareCalculator() );
    }

    @Test
    void adultLessThan4Days5Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator( 2, LuasFareCalculator.typeOfPassenger.ADULT, 5);
        assertEquals(11.6 ,luasFareCalculator1.fareCalculator());


        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator( 1, LuasFareCalculator.typeOfPassenger.ADULT, 5);
        assertEquals(5.8 ,luasFareCalculator2.fareCalculator() );

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator( 3, LuasFareCalculator.typeOfPassenger.ADULT, 5);
        assertEquals( 17.4 ,luasFareCalculator3.fareCalculator());

        LuasFareCalculator luasFareCalculatortroll = new LuasFareCalculator( 0, LuasFareCalculator.typeOfPassenger.ADULT, 5);
        assertEquals(0, luasFareCalculatortroll.fareCalculator() );



    }


    @Test
    void studentFareCalculator5Zones() {

        studentGreaterThan235Zones();
        studentLessThan24AndGreaterThan2Days5Zones();
        studentLessThan3Days5Zones();


    }
    @Test
    void studentGreaterThan235Zones() {
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(30, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(61.0 ,luasFareCalculator.fareCalculator());

        //one month and one week 61 + 15.6 = 76.6
        LuasFareCalculator luasFareCalculator7 = new LuasFareCalculator(37, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(76.6, luasFareCalculator7.fareCalculator() );


        //one month and one week and one day  61 + 15.6 + 5.8 = 82.4
        //broken
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(38, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(82.4, luasFareCalculator3.fareCalculator() );

        //one month and one day 61 + 5.8 = 66.8
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(31, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(66.8 , luasFareCalculator4.fareCalculator());



    }


    @Test
    void studentLessThan24AndGreaterThan2Days5Zones() {

        //3 one week passes
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(21, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(46.8, luasFareCalculator.fareCalculator());

        //1 one week pass
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(6, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(15.6,luasFareCalculator2.fareCalculator() );

        //1 one week pass
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(15.6, luasFareCalculator3.fareCalculator() );

        //1 one week pass and 1 one day pass
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(21.4, luasFareCalculator4.fareCalculator());

        //3 one week pass and 1 one day pass
        //broken
        LuasFareCalculator luasFareCalculator5 = new LuasFareCalculator(22, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(52.6,luasFareCalculator5.fareCalculator());

        //2 one week pass  and 2 one day pass
        LuasFareCalculator luasFareCalculator6 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(42.8, luasFareCalculator6.fareCalculator());


    }

    @Test
    void studentLessThan3Days5Zones() {
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(11.6,luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(5.8, luasFareCalculator2.fareCalculator());

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.STUDENT, 5);
        assertEquals(0, luasFareCalculator3.fareCalculator());
    }


    @Test
    void childFareCalculator5Zones() {

        childGreaterThan3_5Zones();
        childLessThan4_5Zones();


    }

    @Test
    void childGreaterThan3_5Zones() {

        //one week
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.CHILD, 5);
        assertEquals(8.00,luasFareCalculator.fareCalculator());

        //should buy a week
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.CHILD, 5);
        assertEquals(8.00, luasFareCalculator2.fareCalculator());

        //2 weeks and 2 days
        //broken
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.CHILD, 5);
        assertEquals(20.8, luasFareCalculator3.fareCalculator());

        //10 weeks
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(70, LuasFareCalculator.typeOfPassenger.CHILD, 5);
        assertEquals(80, luasFareCalculator4.fareCalculator());

    }

    @Test
    void childLessThan4_5Zones() {


        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(3, LuasFareCalculator.typeOfPassenger.CHILD,5);
        assertEquals(7.2, luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.CHILD, 5);
        assertEquals(4.8, luasFareCalculator2.fareCalculator() );


        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.CHILD, 5);
        assertEquals(2.4, luasFareCalculator3.fareCalculator());

        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.CHILD, 5);
        assertEquals(0, luasFareCalculator4.fareCalculator());

    }



    @Test
    void fareCalculator4Zones() {

        adultFareCalculator4Zones();
        studentFareCalculator4Zones();
        childFareCalculator4Zones();


    }


    @Test
    void adultFareCalculator4Zones() {

        adultGreaterThan3Days4Zones();
        adultLessThan4Days4Zones();

    }

    @Test
    void adultGreaterThan3Days4Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.ADULT, 4);
        assertEquals( 20 , luasFareCalculator1.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(4, LuasFareCalculator.typeOfPassenger.ADULT, 4);
        assertEquals( 20, luasFareCalculator2.fareCalculator() );

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.ADULT,4);
        assertEquals( 25.8, luasFareCalculator3.fareCalculator() );
    }

    @Test
    void adultLessThan4Days4Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator( 2, LuasFareCalculator.typeOfPassenger.ADULT,4);
        assertEquals(11.6 ,luasFareCalculator1.fareCalculator());


        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator( 1, LuasFareCalculator.typeOfPassenger.ADULT,4);
        assertEquals(5.8 ,luasFareCalculator2.fareCalculator() );

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator( 3, LuasFareCalculator.typeOfPassenger.ADULT,4);
        assertEquals( 17.4 ,luasFareCalculator3.fareCalculator());

        LuasFareCalculator luasFareCalculatortroll = new LuasFareCalculator( 0, LuasFareCalculator.typeOfPassenger.ADULT,4);
        assertEquals(0, luasFareCalculatortroll.fareCalculator() );



    }


    @Test
    void studentFareCalculator4Zones() {

        studentGreaterThan23_4Zones();
        studentLessThan24AndGreaterThan2Days4Zones();
        studentLessThan3Days4Zones();


    }
    @Test
    void studentGreaterThan23_4Zones() {
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(30, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(55 ,luasFareCalculator.fareCalculator());

        //one month and one week 55 + 14 = 69
        LuasFareCalculator luasFareCalculator7 = new LuasFareCalculator(37, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(69, luasFareCalculator7.fareCalculator() );


        //one month and one week and one day  55 + 14 + 5.8 = 74.8

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(38, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(74.8, luasFareCalculator3.fareCalculator() );

        //one month and one day 55 + 5.8 = 60.8
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(31, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(60.8 , luasFareCalculator4.fareCalculator());



    }


    @Test
    void studentLessThan24AndGreaterThan2Days4Zones() {

        //3 one week passes
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(21, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(42, luasFareCalculator.fareCalculator());

        //1 one week pass
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(6, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(14,luasFareCalculator2.fareCalculator() );

        //1 one week pass
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(14, luasFareCalculator3.fareCalculator() );

        //1 one week pass and 1 one day pass
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(19.8, luasFareCalculator4.fareCalculator());

        //3 one week pass and 1 one day pass
        //broken
        LuasFareCalculator luasFareCalculator5 = new LuasFareCalculator(22, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(47.8,luasFareCalculator5.fareCalculator());

        //2 one week pass  and 2 one day pass
        LuasFareCalculator luasFareCalculator6 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(39.6, luasFareCalculator6.fareCalculator());


    }

    @Test
    void studentLessThan3Days4Zones() {
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(11.6,luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(5.8, luasFareCalculator2.fareCalculator());

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.STUDENT,4);
        assertEquals(0, luasFareCalculator3.fareCalculator());
    }


    @Test
    void childFareCalculator4Zones() {

        childGreaterThan34Zones();
        childLessThan4_4Zones();


    }

    @Test
    void childGreaterThan34Zones() {

        //one week
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.CHILD,4);
        assertEquals(8.00,luasFareCalculator.fareCalculator());

        //should buy a week
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.CHILD,4);
        assertEquals(8.00, luasFareCalculator2.fareCalculator());

        //2 weeks and 2 days
        //broken
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.CHILD,4);
        assertEquals(20.8, luasFareCalculator3.fareCalculator());

        //10 weeks
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(70, LuasFareCalculator.typeOfPassenger.CHILD,4);
        assertEquals(80, luasFareCalculator4.fareCalculator());

    }

    @Test
    void childLessThan4_4Zones() {

        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(3, LuasFareCalculator.typeOfPassenger.CHILD,4);
        assertEquals(7.2, luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.CHILD,4);
        assertEquals(4.8, luasFareCalculator2.fareCalculator() );


        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.CHILD,4);
        assertEquals(2.4, luasFareCalculator3.fareCalculator());

        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.CHILD,4);
        assertEquals(0, luasFareCalculator4.fareCalculator());

    }















    //test cases for 3 zones


    @Test
    void fareCalculator3Zones() {

        adultFareCalculator3Zones();
        studentFareCalculator3Zones();
        childFareCalculator3Zones();


    }


    @Test
    void adultFareCalculator3Zones() {

        adultGreaterThan3Days3Zones();
        adultLessThan4Days3Zones();

    }

    @Test
    void adultGreaterThan3Days3Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.ADULT, 3);
        assertEquals( 20 , luasFareCalculator1.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(4, LuasFareCalculator.typeOfPassenger.ADULT, 3);
        assertEquals( 20, luasFareCalculator2.fareCalculator() );

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.ADULT,3);
        assertEquals( 25.8, luasFareCalculator3.fareCalculator() );
    }

    @Test
    void adultLessThan4Days3Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator( 2, LuasFareCalculator.typeOfPassenger.ADULT,3);
        assertEquals(11.6 ,luasFareCalculator1.fareCalculator());


        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator( 1, LuasFareCalculator.typeOfPassenger.ADULT,3);
        assertEquals(5.8 ,luasFareCalculator2.fareCalculator() );

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator( 3, LuasFareCalculator.typeOfPassenger.ADULT,3);
        assertEquals( 17.4 ,luasFareCalculator3.fareCalculator());

        LuasFareCalculator luasFareCalculatortroll = new LuasFareCalculator( 0, LuasFareCalculator.typeOfPassenger.ADULT,3);
        assertEquals(0, luasFareCalculatortroll.fareCalculator() );



    }


    @Test
    void studentFareCalculator3Zones() {

        studentGreaterThan23_3Zones();
        studentLessThan24AndGreaterThan2Days3Zones();
        studentLessThan3Days3Zones();


    }
    @Test
    void studentGreaterThan23_3Zones() {
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(30, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(55 ,luasFareCalculator.fareCalculator());

        //one month and one week 55 + 14 = 69
        LuasFareCalculator luasFareCalculator7 = new LuasFareCalculator(37, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(69, luasFareCalculator7.fareCalculator() );


        //one month and one week and one day  55 + 14 + 5.8 = 74.8

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(38, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(74.8, luasFareCalculator3.fareCalculator() );

        //one month and one day 55 + 5.8 = 60.8
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(31, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(60.8 , luasFareCalculator4.fareCalculator());



    }


    @Test
    void studentLessThan24AndGreaterThan2Days3Zones() {

        //3 one week passes
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(21, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(42, luasFareCalculator.fareCalculator());

        //1 one week pass
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(6, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(14,luasFareCalculator2.fareCalculator() );

        //1 one week pass
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(14, luasFareCalculator3.fareCalculator() );

        //1 one week pass and 1 one day pass
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(19.8, luasFareCalculator4.fareCalculator());

        //3 one week pass and 1 one day pass
        //broken
        LuasFareCalculator luasFareCalculator5 = new LuasFareCalculator(22, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(47.8,luasFareCalculator5.fareCalculator());

        //2 one week pass  and 2 one day pass
        LuasFareCalculator luasFareCalculator6 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(39.6, luasFareCalculator6.fareCalculator());


    }

    @Test
    void studentLessThan3Days3Zones() {
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(11.6,luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(5.8, luasFareCalculator2.fareCalculator());

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.STUDENT,3);
        assertEquals(0, luasFareCalculator3.fareCalculator());
    }


    @Test
    void childFareCalculator3Zones() {

        childGreaterThan2_3Zones();
        childLessThan3_3Zones();


    }

    @Test
    void childGreaterThan2_3Zones() {

        //one week
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.CHILD,3);
        assertEquals(6.50,luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculatorx = new LuasFareCalculator(3, LuasFareCalculator.typeOfPassenger.CHILD,3);
        assertEquals(6.50,luasFareCalculatorx.fareCalculator());

        //should buy a week
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.CHILD,3);
        assertEquals(6.50, luasFareCalculator2.fareCalculator());

        //2 weeks and 2 days
        //broken
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.CHILD,3);
        assertEquals(17.8, luasFareCalculator3.fareCalculator());

        //10 weeks
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(70, LuasFareCalculator.typeOfPassenger.CHILD,3);
        assertEquals(65, luasFareCalculator4.fareCalculator());

    }

    @Test
    void childLessThan3_3Zones() {



        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.CHILD,3);
        assertEquals(4.8, luasFareCalculator2.fareCalculator() );


        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.CHILD,3);
        assertEquals(2.4, luasFareCalculator3.fareCalculator());

        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.CHILD,3);
        assertEquals(0, luasFareCalculator4.fareCalculator());

    }

    //test cases for 2 zones

    @Test
    void fareCalculator2Zones() {

        adultFareCalculator2Zones();
        studentFareCalculator2Zones();
        childFareCalculator2Zones();


    }


    @Test
    void adultFareCalculator2Zones() {

        adultGreaterThan2Days2Zones();
        adultLessThan3Days2Zones();

    }

    @Test
    void adultGreaterThan2Days2Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator(3, LuasFareCalculator.typeOfPassenger.ADULT, 2);
        assertEquals( 16.40 , luasFareCalculator1.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(6, LuasFareCalculator.typeOfPassenger.ADULT, 2);
        assertEquals( 16.40, luasFareCalculator2.fareCalculator() );

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.ADULT,2);
        assertEquals( 22.2, luasFareCalculator3.fareCalculator() );
    }

    @Test
    void adultLessThan3Days2Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator( 2, LuasFareCalculator.typeOfPassenger.ADULT,2);
        assertEquals(11.6 ,luasFareCalculator1.fareCalculator());


        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator( 1, LuasFareCalculator.typeOfPassenger.ADULT,2);
        assertEquals(5.8 ,luasFareCalculator2.fareCalculator() );


        LuasFareCalculator luasFareCalculatortroll = new LuasFareCalculator( 0, LuasFareCalculator.typeOfPassenger.ADULT,2);
        assertEquals(0, luasFareCalculatortroll.fareCalculator() );



    }


    @Test
    void studentFareCalculator2Zones() {

        studentGreaterThan22_2Zones();
        studentLessThan23AndGreaterThan2Days2Zones();
        studentLessThan3Days2Zones();


    }
    @Test
    void studentGreaterThan22_2Zones() {
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(23, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(47 ,luasFareCalculator.fareCalculator());

        //one month and one week 47 + 12 = 59
        LuasFareCalculator luasFareCalculator7 = new LuasFareCalculator(37, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(59, luasFareCalculator7.fareCalculator() );


        //one month and one week and one day  47 + 12 + 5.8 = 64.8

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(38, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(64.8, luasFareCalculator3.fareCalculator() );

        //one month and one day 47 + 5.8 = 52.8
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(31, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(52.8 , luasFareCalculator4.fareCalculator());



    }


    @Test
    void studentLessThan23AndGreaterThan2Days2Zones() {

        //3 one week passes
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(21, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(36, luasFareCalculator.fareCalculator());

        //1 one week pass
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(6, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(12,luasFareCalculator2.fareCalculator() );

        //1 one week pass
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(3, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(12, luasFareCalculator3.fareCalculator() );

        //1 one week pass and 1 one day pass
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(17.8, luasFareCalculator4.fareCalculator());

        //3 one week pass and 1 one day pass
        LuasFareCalculator luasFareCalculator5 = new LuasFareCalculator(22, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(41.8,luasFareCalculator5.fareCalculator());

        //2 one week pass  and 2 one day pass
        LuasFareCalculator luasFareCalculator6 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(35.6, luasFareCalculator6.fareCalculator());


    }

    @Test
    void studentLessThan3Days2Zones() {
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(11.6,luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(5.8, luasFareCalculator2.fareCalculator());

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.STUDENT,2);
        assertEquals(0, luasFareCalculator3.fareCalculator());
    }


    @Test
    void childFareCalculator2Zones() {

        childGreaterThan2_2Zones();
        childLessThan3_2Zones();


    }

    @Test
    void childGreaterThan2_2Zones() {

        //one week
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.CHILD,2);
        assertEquals(6.50,luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator(3, LuasFareCalculator.typeOfPassenger.CHILD,2);
        assertEquals(6.50,luasFareCalculator1.fareCalculator());

        //should buy a week
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.CHILD,2);
        assertEquals(6.50, luasFareCalculator2.fareCalculator());

        //2 weeks and 2 days
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.CHILD,2);
        assertEquals(17.8, luasFareCalculator3.fareCalculator());

        //10 weeks
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(70, LuasFareCalculator.typeOfPassenger.CHILD,2);
        assertEquals(65, luasFareCalculator4.fareCalculator());

    }

    @Test
    void childLessThan3_2Zones() {



        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.CHILD,2);
        assertEquals(4.8, luasFareCalculator2.fareCalculator() );


        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.CHILD,2);
        assertEquals(2.4, luasFareCalculator3.fareCalculator());

        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.CHILD,2);
        assertEquals(0, luasFareCalculator4.fareCalculator());

    }



    //test cases for 1 zone

    @Test
    void adultFareCalculator1Zones() {

        adultGreaterThan2Days1Zones();
        adultLessThan3Days1Zones();

    }

    @Test
    void adultGreaterThan2Days1Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.ADULT, 1);
        assertEquals( 13.2 , luasFareCalculator1.fareCalculator());

        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(4, LuasFareCalculator.typeOfPassenger.ADULT, 1);
        assertEquals( 13.2, luasFareCalculator2.fareCalculator() );

        //one week and one day
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.ADULT,1);
        assertEquals( 19, luasFareCalculator3.fareCalculator() );
    }

    @Test
    void adultLessThan3Days1Zones(){

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator( 2, LuasFareCalculator.typeOfPassenger.ADULT,1);
        assertEquals(11.6 ,luasFareCalculator1.fareCalculator());


        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator( 1, LuasFareCalculator.typeOfPassenger.ADULT,1);
        assertEquals(5.8 ,luasFareCalculator2.fareCalculator() );


        LuasFareCalculator luasFareCalculatortroll = new LuasFareCalculator( 0, LuasFareCalculator.typeOfPassenger.ADULT,1);
        assertEquals(0, luasFareCalculatortroll.fareCalculator() );



    }


    @Test
    void studentFareCalculator1Zones() {

        studentGreaterThan22_1Zones();
        studentLessThan23AndGreaterThan2Days1Zones();
        studentLessThan2Days1Zones();


    }
    @Test
    void studentGreaterThan22_1Zones() {

        LuasFareCalculator luasFareCalculator1 = new LuasFareCalculator(23, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(38 ,luasFareCalculator1.fareCalculator());


        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(30, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(38 ,luasFareCalculator.fareCalculator());

        //one month and one week 38 + 10 = 48
        LuasFareCalculator luasFareCalculator7 = new LuasFareCalculator(37, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(48, luasFareCalculator7.fareCalculator() );


        //one month and one week and one day  38 + 10 + 5.8 = 53.8

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(38, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(53.8, luasFareCalculator3.fareCalculator() );

        //one month and one day 38 + 5.8 = 43.8
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(31, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(43.8 , luasFareCalculator4.fareCalculator());



    }


    @Test
    void studentLessThan23AndGreaterThan2Days1Zones() {

        //3 one week passes
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(21, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(30, luasFareCalculator.fareCalculator());

        //1 one week pass
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(6, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(10,luasFareCalculator2.fareCalculator() );

        //1 one week pass
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(10, luasFareCalculator3.fareCalculator() );

        //1 one week pass and 1 one day pass
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(8, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(15.8, luasFareCalculator4.fareCalculator());

        //3 one week pass and 1 one day pass
        LuasFareCalculator luasFareCalculator5 = new LuasFareCalculator(22, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(35.8,luasFareCalculator5.fareCalculator());

        //3 one week passes
        LuasFareCalculator luasFareCalculator6 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(30, luasFareCalculator6.fareCalculator());


    }

    @Test
    void studentLessThan2Days1Zones() {


        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(5.8, luasFareCalculator2.fareCalculator());

        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.STUDENT,1);
        assertEquals(0, luasFareCalculator3.fareCalculator());
    }


    @Test
    void childFareCalculator1Zones() {

        childGreaterThan2_1Zones();
        childLessThan3_1Zones();


    }

    @Test
    void childGreaterThan2_1Zones() {

        //one week
        LuasFareCalculator luasFareCalculator = new LuasFareCalculator(7, LuasFareCalculator.typeOfPassenger.CHILD,1);
        assertEquals(6.50,luasFareCalculator.fareCalculator());

        LuasFareCalculator luasFareCalculatorx = new LuasFareCalculator(3, LuasFareCalculator.typeOfPassenger.CHILD,1);
        assertEquals(6.50,luasFareCalculatorx.fareCalculator());

        //should buy a week
        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(5, LuasFareCalculator.typeOfPassenger.CHILD,1);
        assertEquals(6.50, luasFareCalculator2.fareCalculator());

        //2 weeks and 2 days
        //broken
        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(16, LuasFareCalculator.typeOfPassenger.CHILD,1);
        assertEquals(17.8, luasFareCalculator3.fareCalculator());

        //10 weeks
        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(70, LuasFareCalculator.typeOfPassenger.CHILD,1);
        assertEquals(65, luasFareCalculator4.fareCalculator());

    }

    @Test
    void childLessThan3_1Zones() {



        LuasFareCalculator luasFareCalculator2 = new LuasFareCalculator(2, LuasFareCalculator.typeOfPassenger.CHILD,1);
        assertEquals(4.8, luasFareCalculator2.fareCalculator() );


        LuasFareCalculator luasFareCalculator3 = new LuasFareCalculator(1, LuasFareCalculator.typeOfPassenger.CHILD,1);
        assertEquals(2.4, luasFareCalculator3.fareCalculator());

        LuasFareCalculator luasFareCalculator4 = new LuasFareCalculator(0, LuasFareCalculator.typeOfPassenger.CHILD,1);
        assertEquals(0, luasFareCalculator4.fareCalculator());

    }






    //output for flexi tickets
    @Test
    void UserOutput(){

        adultOutput();
        studentOutput();
        childOutput();

    }

    @Test
    void adultOutput(){

        adultOutput1DayPasses();
        adultOutput7DayPasses();
        adultOutputBothPasses();


    }

    @Test
    void adultOutput1DayPasses(){

        assertEquals( "Your best option is to buy " +1 + " one day adult flexi tickets."+" This will cost you " + UserInputOutput.euroSymbol+"5.80"+"." ,
                UserInputOutput.stringForAdult(1,0,5,5.8));

        assertEquals("Your best option is to buy " +2 + " one day adult flexi tickets."  +" This will cost you " + UserInputOutput.euroSymbol+"11.60"+"." ,
                UserInputOutput.stringForAdult(2,0,5,11.60));

    }

    @Test
    void adultOutput7DayPasses(){

        assertEquals( "Your best option is to buy " +1 + " seven day adult flexi tickets."+" This will cost you " + UserInputOutput.euroSymbol+"22.40"+"." ,
                UserInputOutput.stringForAdult(0,1,5,22.40));

        assertEquals( "Your best option is to buy " +5 + " seven day adult flexi tickets." +" This will cost you " + UserInputOutput.euroSymbol+"112.00"+"." ,
                UserInputOutput.stringForAdult(0,5,5,112.00));


    }
    @Test
    void adultOutputBothPasses(){


        assertEquals("Your best option is to buy " + 1 + " seven day adult flexi tickets and "+ 1+" one day adult flexi tickets."+" This will cost you " + UserInputOutput.euroSymbol+ "28.20"+"." ,
                UserInputOutput.stringForAdult(1,1,5,28.20));

        assertEquals("Your best option is to buy " + 5 + " seven day adult flexi tickets and "+ 2+" one day adult flexi tickets."+" This will cost you " + UserInputOutput.euroSymbol+ "123.60"+"." ,
                UserInputOutput.stringForAdult(2,5,5,123.60));

    }


    @Test
    void studentOutput(){

        studentOutput1DayPasses();
        studentOutput7DayPasses();
        studentOutput1And7Passes();
        studentOutput30DayPasses();
        studentOutput1And30DayPasses();
        studentOutput7And30DayPasses();
        studentOutputAllPasses();
    }

    @Test
    void studentOutput1DayPasses(){

        assertEquals("Your best option is to buy " + 2 + " one day adult flexi tickets." +" This will cost you " + UserInputOutput.euroSymbol+"11.60"+"." ,
                UserInputOutput.stringForStudent(2,0,0,5,11.60));
    }

    @Test
    void studentOutput7DayPasses(){

        assertEquals("Your best option is to buy " + 3 + " seven day student flexi tickets."+" This will cost you " + UserInputOutput.euroSymbol+"46.80"+"." ,
                UserInputOutput.stringForStudent(0,3,0,5,46.80));

        assertEquals("Your best option is to buy " + 5 + " seven day student flexi tickets."+" This will cost you " + UserInputOutput.euroSymbol+"78.00"+"." ,
                UserInputOutput.stringForStudent(0,5,0,5,78.00));

    }

    @Test
    void studentOutput1And7Passes() {

        assertEquals("Your best option is to buy " + 2 + " seven day student flexi tickets and " +2+ " adult flexi" +" tickets. This will cost you "+ UserInputOutput.euroSymbol+"42.80"+"." ,
                UserInputOutput.stringForStudent(2,2,0,5,42.80));

        assertEquals("Your best option is to buy " + 3 + " seven day student flexi tickets and " +1+ " adult flexi" +" tickets. This will cost you "+ UserInputOutput.euroSymbol+"52.60"+"." ,
                UserInputOutput.stringForStudent(1,3,0,5,52.60));

    }

    @Test
    void studentOutput30DayPasses(){

        assertEquals("Your best option is to buy " + 4 + " thirty day student flexi tickets." +" This will cost you " + UserInputOutput.euroSymbol+"244.00" +"." ,
                UserInputOutput.stringForStudent(0,0,4,5,244.00) );

        assertEquals("Your best option is to buy " + 18 + " thirty day student flexi tickets." +" This will cost you " + UserInputOutput.euroSymbol+"1098.00"+"." ,
                UserInputOutput.stringForStudent(0,0,18,5,1098.00) );

    }


    @Test
    void studentOutput1And30DayPasses() {

        assertEquals("Your best option is to buy "+ 4+ " thirty day student flexi tickets and " + 2+ "one day adult flexi tickets. This will cost you "+ UserInputOutput.euroSymbol+"255.60"+".",
                UserInputOutput.stringForStudent(2,0,4,5,255.60));


        assertEquals("Your best option is to buy "+ 9+ " thirty day student flexi tickets and " +1+ "one day adult flexi tickets. This will cost you "+ UserInputOutput.euroSymbol+"554.80"+"." ,
                UserInputOutput.stringForStudent(1,0,9,5,554.80));
    }

    @Test
    void studentOutput7And30DayPasses() {

        assertEquals("Your best option is to buy "+ 7+ " thirty day student flexi tickets and " + 5 + " seven day student flexi tickets. This will cost you "+ UserInputOutput.euroSymbol+"505.00"+"." ,
                UserInputOutput.stringForStudent(0,5,7,5,505.00));

        assertEquals("Your best option is to buy "+ 3+ " thirty day student flexi tickets and " + 1 + " seven day student flexi tickets. This will cost you "+ UserInputOutput.euroSymbol+"198.60"+"." ,
                UserInputOutput.stringForStudent(0,1,3,5,198.60));

    }


    @Test
    void studentOutputAllPasses() {

        assertEquals("Your best option is to buy "+ 6 + " thirty day student flexi tickets and " + 3 + " seven day student flexi tickets and " + 2+ " adult flexi" + " tickets. This will cost you "+ UserInputOutput.euroSymbol+"424.40"+"." ,
                UserInputOutput.stringForStudent(2,3,6,5,424.40));


        assertEquals("Your best option is to buy "+ 8 + " thirty day student flexi tickets and " +  1 + " seven day student flexi tickets and " + 1+ " adult flexi" + " tickets. This will cost you "+ UserInputOutput.euroSymbol+"509.40"+"." ,
                UserInputOutput.stringForStudent(1,1,8,5,509.40));


        assertEquals("Your best option is to buy "+ 1 + " thirty day student flexi tickets and " +
                        2 + " seven day student flexi tickets and " + 1+ " adult flexi" +
                        " tickets. This will cost you "+ UserInputOutput.euroSymbol+"98.00"+".",
                UserInputOutput.stringForStudent(1,2,1,5,98.0));

    }

    @Test
    void childOutput(){

        childOutput1DayPasses();
        childOutput7DayPasses();
        childOutputBothPasses();


    }


    @Test
    void childOutput1DayPasses(){

        assertEquals("Your best option is to buy " + 3 + " one day child flexi tickets."  +" This will cost you " + UserInputOutput.euroSymbol+"7.20"+"." ,
                UserInputOutput.stringForChild(3,0,5,7.2));

        assertEquals("Your best option is to buy " + 3 + " one day child flexi tickets."  +" This will cost you " + UserInputOutput.euroSymbol+"7.20"+"."  ,
                UserInputOutput.stringForChild(3,0,5,7.2));



    }

    @Test
    void childOutput7DayPasses(){

        assertEquals("Your best option is to buy " + 6 + " seven day child flexi tickets." +" This will cost you " + UserInputOutput.euroSymbol+ "48.00"+"." ,
                UserInputOutput.stringForChild(0,6,5,48.0) );


        assertEquals("Your best option is to buy " + 2 + " seven day child flexi tickets." +" This will cost you " + UserInputOutput.euroSymbol+ "16.00"+"." ,
                UserInputOutput.stringForChild(0,2,5,16.0) );

        assertEquals("Your best option is to buy " + 3 + " seven day child flexi tickets." +" This will cost you " + UserInputOutput.euroSymbol+ "24.00"+"." ,
                UserInputOutput.stringForChild(0,3,5,24.0) );

    }

    @Test
    void childOutputBothPasses() {

        assertEquals("Your best option is to buy " + 5 + " seven day child flexi tickets and " + 4 + " one day child flexi tickets."+ " This will cost you " + UserInputOutput.euroSymbol + "49.60"+"." ,
                UserInputOutput.stringForChild(4, 5,5, 49.60));


        assertEquals("Your best option is to buy " + 3 + " seven day child flexi tickets and " + 4 + " one day child flexi tickets."+ " This will cost you " + UserInputOutput.euroSymbol + "49.60" +"." ,
                UserInputOutput.stringForChild(4, 3, 5,49.60));

    }
}




