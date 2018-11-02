/**
 * 
 */
package com.tarzen.cavelooter.enums;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public enum MenuEnum {
	
	MAIN_MENU_OPTIONS("****CAVE LOOTER GAME****","1. Create Player profile","2. Play Game","3. View All Players","4. View Game History","5. Resume last played Game","6. Exit Game","Enter your choice : "),
	GAME_MENU_OPTIONS("Choose your action::","1. Punch(30)","2. Push(20)","3. Kick(50)","4. Save & Exit","Enter action number : ");
	
	List<String> menuProperties;
	
	/**
	 * @return the menuProperties
	 */
	public List<String> getMenuProperties() {
		return menuProperties;
	}

	MenuEnum(String... values) {
		this.menuProperties = Arrays.asList(values);
	}
}
