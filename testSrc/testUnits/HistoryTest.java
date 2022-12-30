package testUnits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.JsonDataManager;
import model.Player;
import model.SysData;

class HistoryTest {

	Player p = new Player("Muhannad", 198, "");
	
	/*
	 * Tests that the added Player is found in the History data structure.
	 */
	@Test
	void a1() {
		SysData.getInstance().addHistory(p);
		assertTrue(SysData.getInstance().getHistoryGamesForShow().contains(p));
	}
	
	/*
	 * Tests that the added Player is found in the History JSON file.
	 */
	@Test
	void b2() {
		assertTrue(JsonDataManager.getInstance().readHistoryDataFRomFile().contains(p));
	}

}
