package orenv.niceactimize;

public class App 
{
	private static DAUService dauService = new DAU();
    public static void main( String[] args )
    {
    	dauService.initDau("input.txt");
		System.out.println("----------------------------------------------------------");
		System.out.println("The number of DAU in 01/01/2020 is: " + dauService.countDauByDate("01/01/2020"));// output:3
		System.out.println("The number of DAU in 02/01/2020 is: " + dauService.countDauByDate("02/01/2020"));// output:2
		System.out.println("The number of DAU in 03/01/2020 is: " + dauService.countDauByDate("03/01/2020"));// output:2
	//	System.out.println(dauService.countDauByDate(" "));// Exception - invalid date
	//	System.out.println(dauService.countDauByDate("04/01/2020"));// Exception - this input does not exist
    }
}
