/**
 * @author UmaMaheswararao
 */

package com.util;


import java.util.Set;

import org.openqa.selenium.Cookie;
import static com.base.BasePage.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CookieLibrary.
 */
public class CookieLibrary {

	/**
	 * Gets the cookie by name.
	 *
	 * @param driver -The driver
	 * @param cookieName -The cookie name
	 * @return the cookie
	 */
	public static Cookie getCookieByName(String cookieName){
		return driver.manage().getCookieNamed(cookieName);
	}
	
	/**
	 * Delete cookie by name.
	 *
	 * @param driver -The driver
	 * @param cookieName -The cookie name
	 */
	public static void deleteCookieByName(String cookieName){
		driver.manage().deleteCookieNamed(cookieName);
	}
	
	/**
	 * Delete all cookies.
	 *
	 * @param driver -The driver
	 */
	public static void deleteAllCookies(){
		driver.manage().deleteAllCookies();
	}
	
	/**
	 * Gets the all cookies.
	 *
	 * @param driver -The driver
	 * @return all cookies as Set&lt;Cookie&gt;
	 */
	public static Set<Cookie> getAllCookies(){
		return driver.manage().getCookies();
	}
	
	
}
