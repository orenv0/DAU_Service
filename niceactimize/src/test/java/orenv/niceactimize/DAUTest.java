package orenv.niceactimize;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;;

public class DAUTest

{
	@Test
	public void testCountDauByDateWithRelevantDate() {
		DAUService dau = new DAU();
		dau.initDau("input.txt");
		int result1 = dau.countDauByDate("01/01/2020");
		assertEquals(3,result1);
		int result2 = dau.countDauByDate("02/01/2020");
		assertEquals(2,result2);
		int result3 = dau.countDauByDate("03/01/2020");
		assertEquals(2,result3);
	}
	@Test
	public void testCountDauByDateWithEmptyInput() {
		DAUService dau = new DAU();
		dau.initDau("input.txt");
		assertThrows(Exception.class, () -> dau.countDauByDate(" "));
		
	}
	@Test
	public void testCountDauByDateWithDateNotExist() {
		DAUService dau = new DAU();
		dau.initDau("input.txt");
		assertThrows(Exception.class, () -> dau.countDauByDate("04/01/2020"));
		
	}
}
