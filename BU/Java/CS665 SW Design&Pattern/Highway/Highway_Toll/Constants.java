package Highway_Toll;


/*
 * Different car types and pricing. The toll system should consider the following types of cars.
- Cars : base price
- Taxis : 0.5 x base price
- Vans: 1.5 x base price
- Cars with trailer: 2 x base price
- Trunks with dynamic weights: 2 x base_price + weight_in_tons* base_price
- Cars with trailer should update the toll system about the existence of a trailer before traveling
on the highway.
- Truck drivers should update the system with their latest load weight before driving on
highways.
 */


public class Constants {

    public static double base_price = 2;
    public static int number_highway = 10;
    public static int highway_miles = 100;
    
    public static int number_tollgates = 10;
    public static int number_customer = 20;
    
    public static int time_period = 9;
    
    
}