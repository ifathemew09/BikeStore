package BikeStore1;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ExecuteTest {

	@Test
	void readInventoryFromFileTest() {
		Execute test = new Execute();
//		Bike mb = new Bike("mb", 32.3, 35.0, "red", 5, 3, 8);
//		Bike rb = new Bike("rb", 45.6, 50.0, "blue", 6, 2, 9);
//		Bike cb = new Bike("cb", 50.5, 60.0, "orange", 4, 1, 7);
		//Bike expected[] = [mb, rb, cb]; 
		//assertEquals(expected, test.readInventoryFromFile("Inventory.txt"));
		assertNotNull(Execute.readInventoryFromFile("Inventory.txt"));
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
	
	@Test
	void printInventoryTest() {
		Execute test = new Execute();
		Bike[] inventory = test.readInventoryFromFile("Inventory.txt");
		
		//assertSame("Hello", test.printInventory(inventory));
		//assertNotSame(5, test.printInventory(inventory));
	}

}
