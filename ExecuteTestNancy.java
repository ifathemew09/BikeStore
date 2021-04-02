import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

class ExecuteTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();

	@Test
	public void isFileRead(){
		ClassLoader classLoader = this.getClass().getClassLoader();
		
		//Real file
		File file = new File(classLoader.getResource("Inventory.txt").getFile());
		assertTrue(file.exists());
		
		//Real file
		File file2 = new File(classLoader.getResource("BikeOrder.txt").getFile());
		assertTrue(file2.exists());
		assertFalse(file2.exists());
		
		//Fake file
		File file3 = new File(classLoader.getResource("test.txt").getFile());
		assertFalse(file3.exists());
	}
	
	//Tests if there are any type of exceptions
	@Test
	public void testException() {
		exception.expect(IOException.class);
        exception.expectMessage("IOException");
        exception.expect(NumberFormatException.class);
        exception.expectMessage("NumberFormatException");
        exception.expect(ArrayIndexOutOfBoundsException.class);
        exception.expectMessage("ArrayIndexOutOfBoundsException");
	}
	
	@Test
	void updateInventoryBasedOnClientsRequestsTest() {
		Execute test = new Execute();
		Bike mb = new Bike("mb", 32.3, 35.0, "red", 5, 3, 8);
		Bike rb = new Bike("rb", 45.7, 51.2, "blue", 6, 2, 9);
		Bike[] inventory = test.readInventoryFromFile("Inventory.txt");
		
		assertEquals(3600.0, test.updateInventoryBasedOnClientsRequests(inventory, "ClientRequest.txt", "BikeOrder.txt"));
		assertTrue(test.updateInventoryBasedOnClientsRequests(inventory, "ClientRequest.txt", "BikeOrder.txt") == 3600.0);
		assertNotSame(3600, test.updateInventoryBasedOnClientsRequests(inventory, "ClientRequest.txt", "BikeOrder.txt"));
	
	}
}
