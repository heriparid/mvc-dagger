package com.heriparid.auth.ui.controller;

/**
 * To controller incoming action from LoginActivity
 * 
 * @author heri
 *
 */
public interface ILoginController extends IController {
	
	/**
	 * Logins to web server
	 * 
	 * @param username the String value provided by user
	 * @param password the String value provided by user
	 */
	void onRequestLogin(String username, String password);
}
