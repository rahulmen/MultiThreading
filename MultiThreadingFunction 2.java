package componentGroups;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.PageObjects;





//import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

@SuppressWarnings("unused")
public class CommonFunctions {
	public String ORName = "Common_OR";
	private final int SHORT_TO = 5;
	//public static Wait wait;
	public static WebDriver driver;
	public static Properties properties;


	public CommonFunctions(){
		try{
			properties = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "//"+"Miscellaneous"+"//"+"Global Settings.properties");
			properties.load(file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void assertTrue(boolean textPresent){

	}
	
	/********************************************************
	 * Function to initialize WebDriver instance
	 * @param WebDriver
	 ******************************************************
	 */
	

	public static void initialize(){
			
			String browserName = properties.getProperty("Browser");
			try {
			switch(browserName){
			case "chrome" : {
				System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromeDriverPath"));
				driver = new ChromeDriver();
				break;
			}
			case "gecko" : {
				System.setProperty("webdriver.ie.driver", properties.getProperty("InternetExplorerDriverPath"));
				driver = new FirefoxDriver();
				break;
			}
			case "ie" : {
				System.setProperty("webdriver.gecko.driver", properties.getProperty("GeckoDriverPath"));
				driver = new InternetExplorerDriver();
				break;
			}
			default : System.err.println("There is no such browser availaible");	
			}}catch(WebDriverException nsee) {
				nsee.printStackTrace();
			}catch(Exception nsee) {
				nsee.printStackTrace();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.get(properties.getProperty("WebURL"));
			}

	/*******************************************************
	 * Function to Check whether Frame is present ON web page or not
	 * @param frameId
	 * @return
	 * ******************************************************
	 */
	public boolean isFramePresent(String frameId)
	{
		try {
			WebElement frame = driver.findElement(By.id(frameId));
			if(frame.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (NoSuchElementException e) 
		{
			return false;
		}
	}	

	/*******************************************************
	 * Function to check whether Element is present on page
	 * 
	 * @Modified by pxg0fzc on 13 October
	 *	
	 *****************************************************
	 */
	public boolean isElementPresent(By by)
	{
		try 
		{
			driver.findElement(by);
			return true;
		} 
		catch (NoSuchElementException e) 
		{
			return false;
		}
	}


	/**********************************************************
	 *Function to  Verify if element is present on page
	 * 
	 * @param strObjectProperty
	 *            -
	 * @param strFindElementType
	 *            - Element type to search by.
	 * @return returns true if the element exist, otherwise, false.
	 ***************************************************/
	public boolean isElementPresent(String strObjectProperty, String strFindElementType){
		WebElement elemToFind = null;
		try{

			if(strFindElementType.equalsIgnoreCase("CSS"))
				elemToFind = driver.findElement(By.cssSelector(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("XPATH"))
				elemToFind = driver.findElement(By.xpath(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("ID"))
				elemToFind = driver.findElement(By.id(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("NAME"))
				elemToFind = driver.findElement(By.name(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
				elemToFind = driver.findElement(By.linkText(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("TAG"))
				elemToFind = driver.findElement(By.tagName(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("CLASS"))
				elemToFind = driver.findElement(By.className(strObjectProperty));
			// //report.updateTestLog("isElementPresent","Expected...",
			// Status.PASS);

		} catch(org.openqa.selenium.NoSuchElementException nsee){
			//System.out.println("Exception in isElementPresent:" + nsee);
			return false;
		}
		// Extra protection...
		if(elemToFind == null){
			return false;
		} else{
			//System.out.println("Found element:" + strObjectProperty);
			return true;
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify if an element exists on the Webpage
	 * Does not print error to log if element is not found
	 * 
	 * @param locatorType
	 *            - Element type to search by. i.e CSS,ID,NAME etc.
	 *            
	 * @param property
	 *            - Property of the element to be located 
	 *            
	 * @param objName
	 *            - Name of the object to be updated in test log
	 *              Required when printError is true           
	 *            
	 * @param printError
	 * 			- If true, error will be printed to log when element
	 * 			  is not found.
	 *          - If false, no error will be printed to the log* 
	 *            
	 * @return true
	 *         If the element exists on page
	 *         
	 * @return false 
	 *   	   If the element does not exist on page
	 *   
	 * @author 387478  
	 ************************************************************* 
	 */
	public boolean isElementPresent(String locatorType, String property, String objName, Boolean printError){
		WebElement elemToFind = null;
		try{	    	
			elemToFind = getElementByProperty(property,locatorType,false);
			if(!elemToFind.isDisplayed()){
				if(printError)
					//report.updateTestLog(objName, objName+" element is not displayed", Status.FAIL);

					return false;
			}
		} catch(Exception e){
			if(printError)
				//report.updateTestLog(objName, objName+" element is not displayed", Status.FAIL);
				return false;
		}
		if(elemToFind == null){
			if(printError)
				//report.updateTestLog(objName, objName+" element is not displayed", Status.FAIL);
				return false;
		}
		return true;
	}


	/**
	 ************************************************************* 
	 * Function to verify if an element is present in the application, not using
	 * OR.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean isElementPresentVerification(WebElement elemToVerify, String strObjName){

		try{
			if(elemToVerify.isDisplayed()){
				//report.updateTestLog((strObjName + " element is present"), strObjName+ " is verified successfully", Status.DONE);
				return true;
			} else{
				//report.updateTestLog((strObjName + " element is present"), strObjName
				//+ " is NOT displayed", Status.FAIL);
				return false;
			}
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			//report.updateTestLog("Error in identifying element (" + strObjName + ")", nsee.toString(), Status.FAIL);
			return false;
		} catch(Exception e){
			/*//report.updateTestLog("IS ELEMENT PRESENT VERIFICATION", "Error in identifying object (" + strObjName
					+ ") -" + e.toString(), Status.FAIL);*/
			return false;
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify if an element is present in the application, not using
	 * OR.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean isElementPresentVerification(WebElement elemToVerify, String strObjName,Boolean writereport){

		boolean result;
		try{
			if(elemToVerify.isDisplayed())
				return true;
			else {	
				return false;
			}
			}catch(NoSuchElementException nsee) {
			return false;
		}catch(Exception e) {
			return false;
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify and update test log if an element exists on the Webpage
	 * 
	 * @param  strFindElementType 
	 * 		   Type of element i.e ID, CSS, NAME, etc.
	 * 
	 * @param strObjectProperty
	 *        Propertu of the element which is to be searched
	 * @return true
	 *         If the element exists on page
	 *         
	 * @return false 
	 *   	   If the element does not exist on page
	 ************************************************************* 
	 */
	public boolean verifyIfElementIsPresent(String strFindElementType, String strObjectProperty, String objName){
		WebElement elemToFind;
		try{	    	

			if(strFindElementType.equalsIgnoreCase("CSS"))
				elemToFind = driver.findElement(By.cssSelector(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("XPATH"))
				elemToFind =  driver.findElement(By.xpath(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("ID"))
				elemToFind =  driver.findElement(By.id(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("NAME"))
				elemToFind = driver.findElement(By.name(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
				elemToFind = driver.findElement(By.linkText(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("TAG"))
				elemToFind =  driver.findElement(By.tagName(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("CLASS"))
				elemToFind =  driver.findElement(By.className(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("PARTIALLINKTEXT"))
				elemToFind = driver.findElement(By.partialLinkText(strObjectProperty));
			else
				elemToFind = null;

		} catch(Exception e){
			//report.updateTestLog(objName, objName+" element is not displayed", Status.FAIL);
			return false;
		}
		if(elemToFind == null ||(!elemToFind.isDisplayed())){
			//report.updateTestLog(objName, objName+" element is not displayed", Status.FAIL);
			return false;
		}
		if(elemToFind.isDisplayed()){
			//report.updateTestLog(objName, objName+" is displayed", Status.PASS);	
			return true;
		}else{
			//report.updateTestLog(objName, objName+" element is not displayed", Status.FAIL);
			return false;
		}
	}

	/*************************************************************
	 *Function to Verify Element is Not Present For Negative Scenario
	 * 
	 * @param elemToVerify
	 * @param strObjName
	 **************************************************************/

	public boolean verifyIsElementNotPresent(String strObjectProperty, String strFindElementType, String strObjName){
		boolean result = false;
		WebElement element = null;
		try{

			if(strFindElementType.equalsIgnoreCase("CSS")){
				element = driver.findElement(By.cssSelector(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("XPATH")){
				element = driver.findElement(By.xpath(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("ID")){
				element = driver.findElement(By.id(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("NAME")){
				element = driver.findElement(By.name(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("LINKTEXT")){
				element = driver.findElement(By.linkText(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("TAG")){
				element = driver.findElement(By.tagName(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("CLASS")){
				element = driver.findElement(By.className(strObjectProperty));
			}
			if(element.isDisplayed()) 
				result = true;
				
			
			else{
				result = false;
			}

		} catch(org.openqa.selenium.NoSuchElementException nsee){
			nsee.printStackTrace();
		} catch(Exception nsee) {
			nsee.printStackTrace();
		}
		return result;
		}


	/*******************************************************************
	 * Function to Verify Element is Not Present within a parent element -
	 * Negative Scenario
	 * 
	 * @param elemToVerify
	 * @param strObjName
	 *******************************************************************/
	public boolean verifyIsElementNotPresent(WebElement elmt, String strParentElementName, String strObjectProperty,
			String strFindElementType, String strObjName){

		try{

			if(strFindElementType.equalsIgnoreCase("CSS")){
				elmt.findElement(By.cssSelector(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("XPATH")){
				elmt.findElement(By.xpath(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("ID")){
				elmt.findElement(By.id(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("NAME")){
				elmt.findElement(By.name(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("LINKTEXT")){
				elmt.findElement(By.linkText(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("TAG")){
				elmt.findElement(By.tagName(strObjectProperty));
			} else if(strFindElementType.equalsIgnoreCase("CLASS")){
				elmt.findElement(By.className(strObjectProperty));
			} else{

			}
			//report.updateTestLog("verifyIsElementNotPresent".toUpperCase() + " - (" + strObjName + ")", "("
			//	+ strObjName + ")" + " Is Present with property : " + strObjectProperty + " within the Element "
			//+ strParentElementName + "!!Not expected", Status.FAIL);
			return false;

		} catch(org.openqa.selenium.NoSuchElementException nsee){
			//report.updateTestLog("verifyIsElementNotPresent".toUpperCase() + " - identifying element (" + strObjName
			//+ ")", "(" + strObjName + ")" + " with property: " + strObjectProperty
			//+ " Is Not Present within the Element " + strParentElementName + " as expected", Status.PASS);
			return true;
		}
	}




	/**
	 ************************************************************* 
	 * Function to Retrieve data from dataTable.
	 * 
	 * @param sheetName
	 * 		  Sheet from which data is to be retrieved
	 *            
	 * @param columnName
	 * 		  Column from which data is to be retrieved
	 * 
	 * @param objName
	 * 		  Description of the retrieved data which is to be updated in Test Log
	 * 
	 * @param displayError
	 * 		  Displays error message if true is passed and data is blank in sheet
	 * 		  No error message is displayed if  false is passed
	 *            
	 * @return String
	 * 
	 * @author 387478
	 * 			
	 ************************************************************* 
	 */
	public String getData(String sheetName, String columnName, String objName, boolean displayError)
	{
		String retrievedData ="";
		String defaultValue ="BLANK";

		if(!objName.isEmpty()){
			if(objName.equals("Account Balance"))
				defaultValue = "Zero";

			if(objName.equals("Ami"))
				defaultValue = "Yes";

		}

		try{
			//retrievedData =  dataTable.getData(sheetName, columnName);
			//retrievedData =  dataTable.getData("Accounts", "AccountNumber");
			if(displayError){
				if(retrievedData.isEmpty());

				//report.updateTestLog("Retrieve data from "+columnName, objName + " is blank in "+ columnName +" column. Setting it to " + defaultValue +" by default.", Status.WARNING);					
			}
		}catch(Exception e){
			if(displayError);
			//report.updateTestLog(objName, "Unable to retrieve data from Common Data", Status.WARNING);
		}
		if(retrievedData.isEmpty()){
			if(objName.equals("Account Balance"))
				retrievedData = "0";

			if(objName.equals("Ami"))
				retrievedData = "Yes";
		}
		return retrievedData.trim();
	}


	/**
	 ************************************************************* 
	 * Function to Retrieve data from dataTable based on input environment.
	 * This function will append QA_,Test_ or Prod_ in columnName based on the environment
	 * 
	 * @param environment
	 *        Environment for which data is to be retrieved		  
	 * 
	 * @param sheetName
	 * 		  Sheet from which data is to be retrieved
	 *            
	 * @param columnName
	 * 		  Column from which data is to be retrieved
	 * 
	 * @param objName
	 * 		  Description of the retrieved data which is to be updated in Test Log
	 * 
	 * @param displayError
	 * 		  Displays error message if true is passed and data is blank in sheet
	 * 		  No error message is displayed if  false is passed
	 *            
	 * @return String
	 * 
	 * @author 387478
	 * 			
	 ************************************************************* 
	 */
	public String getData(String environment, String sheetName, String columnName, String objName, boolean displayError){
		String retrievedData ="";
		String defaultValue ="BLANK";
		//Set SheetName based on environment
		if(environment.toLowerCase().equals("qa"))
			columnName = "QA_" + columnName;
		else if(environment.toLowerCase().equals("test"))
			columnName = "Test_" + columnName;
		else 
			columnName = "Prod_" + columnName;


		if(objName.equals("Account Balance"))
			defaultValue = "Zero";
		try{
			//retrievedData =  dataTable.getData(sheetName, columnName);
			//retrievedData =  dataTable.getData("Accounts", "AccountNumber");
			if(displayError){
				//if(retrievedData.isEmpty());
				//report.updateTestLog("Retrieve data from "+columnName, objName + " is blank in "+ columnName +" column. Setting it to " + defaultValue +" by default.", Status.WARNING);
			}
		}catch(Exception e){
			if(displayError);
			//report.updateTestLog(objName, "Unable to retrieve data from Common Data:" +columnName+ ". Setting it to " + defaultValue, Status.WARNING);
		}
		return retrievedData;
	}

	/**
	 ************************************************************* 
	 * Function to Retrieve data from dataTable based on input environment.
	 * This function will append QA_,Test_ or Prod_ in columnName based on the environment
	 * 
	 * @param environment
	 *        Environment for which data is to be retrieved		  
	 * 
	 * @param sheetName
	 * 		  Sheet from which data is to be retrieved
	 *            
	 * @param columnName
	 * 		  Column from which data is to be retrieved
	 * 
	 * @param objName
	 * 		  Description of the retrieved data which is to be updated in Test Log
	 * 
	 * @param displayError
	 * 		  Displays error message if true is passed and data is blank in sheet
	 * 		  No error message is displayed if  false is passed
	 *            
	 * @return String
	 * 
	 * @author 387478
	 * 			
	 ************************************************************* 
	 */

	public String getData(Boolean useenvironment, String sheetName, String columnName, String objName, boolean displayError){
		String retrievedData ="";
		String defaultValue ="BLANK";
		String environment = properties.getProperty("Environment");
		//Set SheetName based on environment
		if(environment.toLowerCase().equals("qa"))
			columnName = "QA_" + columnName;
		else if(environment.toLowerCase().equals("test"))
			columnName = "Test_" + columnName;
		else 
			columnName = "Prod_" + columnName;


		if(objName.equals("Account Balance"))
			defaultValue = "Zero";
		//		try{
		//			retrievedData =  dataTable.getData(sheetName, columnName);
		//			//retrievedData =  dataTable.getData("Accounts", "AccountNumber");
		//			if(displayError){
		//				if(retrievedData.isEmpty())
		//					//report.updateTestLog("Retrieve data from "+columnName, objName + " is blank in "+ columnName +" column. Setting it to " + defaultValue +" by default.", Status.WARNING);
		//			}
		//		}catch(Exception e){
		//			if(displayError)
		//				//report.updateTestLog(objName, "Unable to retrieve data from Common Data:" +columnName+ ". Setting it to " + defaultValue, Status.WARNING);
		//		}
		return retrievedData.trim();
	}



	/**
	 ************************************************************* 
	 * Function to Retrieve data from dataTable.
	 * 
	 * @param sheetName
	 * 		  Sheet from which data is to be retrieved
	 *            
	 * @param columnName
	 * 		  Column from which data is to be retrieved
	 * 
	 * @param objName
	 * 		  Description of the retrieved data which is to be updated in Test Log
	 * 
	 * @param displayError
	 * 		  Displays error message if true is passed and data is blank in sheet
	 * 		  No error message is displayed if  false is passed
	 *            
	 * @return String
	 * 			
	 ************************************************************* 
	 */
	/*public String validateData(String sheetName, String columnName, String objName)
	{
		String retrievedData = null;
		try{
			retrievedData =  dataTable.getData(sheetName, columnName);
			if(retrievedData.isEmpty())
			{	//frameworkParameters.setStopExecution(true);
				throw new FrameworkException("Retrieve data from "+columnName, objName + " is blank in "+ columnName +" column in "+ sheetName +" sheet.");
			}
		}
		catch(Exception e)
		{
			//frameworkParameters.setStopExecution(true);
			throw new FrameworkException("Retrieve data from "+columnName, objName + " is blank in "+ columnName +" column in "+ sheetName +" sheet.");
		}
		return retrievedData;
	}
*/
	/**
	 ************************************************************* 
	 * Function to Retrieve data from dataTable.
	 * 
	 * @param sheetName
	 * 		  Sheet from which data is to be retrieved
	 *            
	 * @param columnName
	 * 		  Column from which data is to be retrieved
	 * 	 
	 * @param displayError
	 * 		  Displays error message if true is passed and data is blank in sheet
	 * 		  No error message is displayed if  false is passed
	 *            
	 * @return String
	 * 			
	 ************************************************************* 
	 */

/*	public String validateData(String sheetName, String columnName)
	{
		String retrievedData = null;

		try{
			retrievedData =  dataTable.getData(sheetName, columnName);
			if(retrievedData.isEmpty())
			{	//frameworkParameters.setStopExecution(true);
				throw new FrameworkException("Retrieve data from "+columnName, "" + " is blank in "+ columnName +" column in "+ sheetName +" sheet.");
			}
		}
		catch(Exception e)
		{
			//frameworkParameters.setStopExecution(true);
			throw new FrameworkException("Retrieve data from "+columnName,"" + " is blank in "+ columnName +" column in "+ sheetName +" sheet.");
		}
		return retrievedData;
	}*/
	/**
	 ************************************************************* 
	 * Function to clear existing text in a field and enter required data.
	 * 
	 * @param ElementName
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @param Text
	 *            The {@link String} object that contains the string to be
	 *            entered in the text field.
	 * @return void
	 ************************************************************* 
	 */

	public boolean clearAndEnterText(WebElement elemToEnter, String strValueToEnter, String strObjName)
	{
		boolean result= false;
		if(!strValueToEnter.trim().equalsIgnoreCase("IGNORE")){
			try{
				if(elemToEnter.isDisplayed() && elemToEnter.isEnabled()){
					elemToEnter.clear();
					Thread.sleep(4000);
					updateAnyElement(elemToEnter, strValueToEnter, strObjName);
					result = true;
				} else{
					result = false;
				}
			} catch(org.openqa.selenium.NoSuchElementException nsee){
				result = false;
			} catch(Exception e){
				result = false;
			}
		} else {
			result = false;
		}return result;
		}

	/**
	 ************************************************************* 
	 * Function to clear existing text in a field and enter required data.
	 * 
	 * @param ElementName
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @param Text
	 *            The {@link String} object that contains the string to be
	 *            entered in the text field.
	 * @return void
	 ************************************************************* 
	 */

	public boolean clearAndEnterText(PageObjects pageObject, String strValueToEnter)
	{
		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();
		if(!strValueToEnter.trim().equalsIgnoreCase("IGNORE")){
			try{
				if(element.isDisplayed() && element.isEnabled()){


					element.clear();
					Thread.sleep(2000);
					updateAnyElement(element, strValueToEnter, strObjName);

					return true;
				} else{
					
				}
			} catch(org.openqa.selenium.NoSuchElementException nsee){
				
			} catch(Exception e){
				
			}
			return false;
		} else
			return true;
	}

	/**
	 ************************************************************* 
	 * Function to click a given element
	 * 
	 * @param elemToClick
	 *            The {@link strObjProperty} element to be updated
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean updateAnyElement(WebElement elemToEnter, String strValueToEnter, String strObjName){

		if(!strValueToEnter.trim().equalsIgnoreCase("IGNORE")){
			try{
				if(elemToEnter.isDisplayed() && elemToEnter.isEnabled()){
					// mouseOverWebElement(elemToUpdate); This is NOT supported
					// in Safari browser. Not required for other browsers too. -

					Thread.sleep(1000);
					try{
						elemToEnter.click();
					} catch(Exception e){
						e.printStackTrace();
					}
					elemToEnter.clear();
					elemToEnter.sendKeys(strValueToEnter);
					Thread.sleep(2000);
					if(strObjName.equals("Password") || strObjName.equals("SSN")){
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].setAttribute('style', arguments[1]);",elemToEnter, "color: red; border: 1px solid red;");
						Thread.sleep(500);  
						//	highLightElement(elemToEnter);
						js.executeScript("arguments[0].setAttribute('style', arguments[1]);", elemToEnter, "");
					}	
						return true;
				} else{
					return false;
				}
			} catch(org.openqa.selenium.NoSuchElementException nsee){
				nsee.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
			return false;
		} else
			return true;
	}

	/**
	 ************************************************************* 
	 * Function to click a link which opens in same tab and verify
	 * if correct URL is opened. User is navigated back to the original URL
	 * after verification is complete
	 * 
	 * @author 387478
	 * @param  element
	 *            The {@link element} is the WelElement object
	 *            which is to be clicked
	 * @param  expectedUrl
	 *            The {@link expectedUrl} is the expected URL on which the 
	 *            user should be navigated on clicking the link
	 * @param  strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if the user is navigated to correct URL
	 * @throws InterruptedException 
	 ************************************************************* 
	 */
	public boolean clickAndVerifyUrl(WebElement element, String expectedUrl, String strObjName) throws InterruptedException{
		if(!clickIfElementPresent(element, strObjName)){
			return false;
		}
		if(driver.getCurrentUrl().equals(expectedUrl)){
			navigateBackFromCurrentPage();
		}else{
			navigateBackFromCurrentPage();
			return false;
		}	

		return true;
	}


	/**
	 ************************************************************* 
	 * Function to Check Element is enabled
	 *      * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strValueToSelect} describes the state to be set
	 *            which can be one of: Y/N
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return None
	 ************************************************************* 
	 */

	public void verifyElementIsEnabledAndNavigateBack(WebElement elementToSelect, String strValueToSelect, String strObjName)throws Exception
	{
		String CurrentUrl = driver.getCurrentUrl();
		String strStateToreport = " ";
		boolean blnValueToSelect = true;

		String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		if(s.contains("Safari"))
		{
			driver.get(CurrentUrl);
			Thread.sleep(3000);
		}
		else
		{
			driver.navigate().back();
			Thread.sleep(3000);
		}

	}

	/**
	 ************************************************************* 
	 * Function to Check Element is enabled
	 *      * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strValueToSelect} describes the state to be set
	 *            which can be one of: Y/N
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return None
	 ************************************************************* 
	 */

	public boolean verifyElementIsEnabled(WebElement elementToSelect, String strValueToSelect, String strObjName)throws Exception
	{

		String strStateToreport = " ";
		boolean blnValueToSelect = true;


		if(elementToSelect.isEnabled())
		{
			return true;

		} else{
			return false;
		}

	}

	/**
	 ************************************************************* 
	 * Function to Check Element is enabled
	 *   
	 * @parameter pageObject
	 * @return None
	 ************************************************************* 
	 */

	public boolean verifyElementIsEnabled(PageObjects pageObject)throws Exception
	{
		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();

		String strStateToreport = " ";
		boolean blnValueToSelect = true;
		boolean result= false;


		if(element.isEnabled()){
			result = true;
		} else{
			result = false;
		}

		return result;

	}



	/**
	 ************************************************************* 
	 * Function to Check Element is not enabled
	 * 	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strValueToSelect} describes the state to be set
	 *            which can be one of: Y/N
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return None
	 ************************************************************* 
	 */

	public boolean verifyElementIsNotEnabled(WebElement elementToSelect, String strValueToSelect, String strObjName)throws Exception
	{

		String strStateToreport = " ";
		boolean blnValueToSelect = true;


		if(!elementToSelect.isEnabled())
		{		
				return true;
		} else{
			return false;
		}

	}

	/**
	 ************************************************************* 
	 * Function to Check Element is not enabled
	 * 	@parameter pageObject

	 * @return None
	 ************************************************************* 
	 */

	public boolean verifyElementIsNotEnabled(PageObjects pageObject)throws Exception
	{
		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();

		String strStateToreport = " ";
		boolean blnValueToSelect = true;


		if(!element.isEnabled())
		{
		return true;	

		} else{
			return false;
		}

	}


	/**
	 ************************************************************* 
	 * Method to check/uncheck a checkbox based on the given option
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be set
	 *            which can be one of: Y/N
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return None
	 ************************************************************* 
	 */
	public void clickIfElementPresent(WebElement elementToSelect, String strValueToSelect, String strObjName){

		String strStateToreport = " ";
		boolean blnValueToSelect = true;
		if(!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))){
			if(strValueToSelect.trim().equalsIgnoreCase("N")){
				blnValueToSelect = false;
				strStateToreport = " not ";
			}
			if(elementToSelect.isEnabled()){
				if(!blnValueToSelect && !elementToSelect.isSelected()){
					if(blnValueToSelect && elementToSelect.isSelected()){
						elementToSelect.click();
					}
				}
				elementToSelect.click();
				

			} else{
				
			}
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify same text is present in both the input strings
	 * 
	 * @param String expectedString
	 * 
	 * @param String actualString
	 * @param objName
	 *        - Name of the object to be updated in the Test log
	 * 
	 * @author 387478    *   
	 *
	 ************************************************************* 
	 */

	public boolean compareText(String expectedString, String actualString, String objName)
	{
		try{
			if(expectedString.equals(actualString)){
				//report.updateTestLog(objName, "'" + objName + "' : " + " Verification is Success", Status.PASS);
				return true;
			} else{
				
				return false;
			}    
		}catch(Exception e){
			System.out.println("compareText-expectedString:"+expectedString+" Actual String:"+actualString+" Error:"+e.getMessage());
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to convert string to integer
	 * 
	 * @param String stringtoConvert
	 *        Input string to be converted to integer
	 *  
	 * @return long 
	 *              Converted value
	 * 
	 * @author 387478
	 *
	 ************************************************************* 
	 */

	public long convertStringtoInteger(String stringtoConvert)
	{
		long convertedInteger=0;
		try{
			convertedInteger = Integer.parseInt(stringtoConvert);
		}catch(Exception e){
			convertedInteger = 0;
			System.out.println("convertStringtoInteger: Error occured in converting '" + stringtoConvert +"' to integer. Setting it to zero");
		}
		return convertedInteger;
	}


	/**
	 ************************************************************* 
	 * Function to convert string to double
	 * 
	 * @param String stringtoConvert
	 *        Input string to be converted to integer
	 *  
	 * @return double 
	 *             Converted value
	 * 
	 * @author 387478
	 *
	 ************************************************************* 
	 */

	public double convertStringtoDouble(String stringtoConvert)
	{
		double convertedInteger=0;
		try{
			if(stringtoConvert.contains("$")){
				stringtoConvert = RemoveCharacter(stringtoConvert, '$').trim();
			}
			stringtoConvert = RemoveSpecialcharactersFromAmount(stringtoConvert);
			if(stringtoConvert.trim().isEmpty())
				return 0;
			convertedInteger = Double.parseDouble(stringtoConvert);
		}catch(Exception e){
			convertedInteger = 0;
			System.out.println("Error occured in converting" + stringtoConvert +" to double. Setting it to zero");
		}
		return convertedInteger;
	}


	/******************************************************
	 * Function to remove a character from Input String
	 * 
	 * @param strring
	 *            to remove the characters
	 * @return string
	 * 
	 * @author 387478
	 * ******************************************************
	 */

	public String RemoveCharacter(String str, char charToRemove){

		String st = "";
		for(int i = 0; i < str.length(); i++){
			int ch = str.charAt(i);

			if(ch!=charToRemove){
				st = st + (char) ch;
			}

		}

		return st;
	}

	/************************************************************
	 * function to remove special characters in a string
	 * 
	 * @param strring
	 *            to remove the characters
	 * @return string
	 ***********************************************************/

	public String RemoveSpecialcharacters(String str){

		String st = "";
		for(int i = 0; i < str.length(); i++){
			int ch = str.charAt(i);

			if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57) || ch==46){
				st = st + (char) ch;
			}

		}

		return st;
	}
	/************************************************************
	 * function to remove Question Mark in a string
	 * 
	 * @param string
	 *            to remove the Question Mark
	 * @return string
	 ***********************************************************/

	public String RemoveQuestionMark(String str){

		String st = "";
		for(int i = 0; i < str.length(); i++){
			int ch = str.charAt(i);

			if(!(ch==63 )){
				st = st + (char) ch;
			}

		}

		return st;
	}
	/**
	 ************************************************************* 
	 * Function to compare (equals or contains) two strings after removing
	 * special characters from them
	 * 
	 * @param str1
	 *            ,str2 The two strings that are to be compared
	 * @param strContainsOrEquals
	 * 
	 * @return Boolean
	 ************************************************************* 
	 */
	public Boolean compareRemovingSpecialCharacters(String str1, String strContainsOrEquals, String str2){

		str1 = RemoveSpecialcharacters(str1.trim().toLowerCase());
		str2 = RemoveSpecialcharacters(str2.trim().toLowerCase());
		if(strContainsOrEquals.equalsIgnoreCase("equals")){
			if(str1.equals(str2))
				return true;
			else
				return false;
		} else{
			if(str1.contains(str2))
				return true;
			else
				return false;
		}
	}

	/***************************************************
	 * Function to remove special characters in a Amount
	 * It keeps '.' and '-' sign
	 * 
	 * @param strring
	 *            to remove the characters
	 * @return string
	 ********************************************************/

	public String RemoveSpecialcharactersFromAmount(String str){

		String st = "";
		for(int i = 0; i < str.length(); i++){
			int ch = str.charAt(i);

			if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57) || ch==46 || ch==45){
				st = st + (char) ch;
			}

		}

		return st;
	}

	/**
	 * ***************************************************
	 * Function to format a amount
	 * Adds Grouping identifier ','
	 * Returns a string having two characters after a dot
	 * 
	 * @param amount
	 *            Amount which is to be formatted
	 * @return string
	 * 
	 * @author 313057
	 * ***************************************************
	 */
	public String formatAmount(String amount){

		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);	

		amount = RemoveSpecialcharactersFromAmount(amount);
		Double floatamount = Double.parseDouble(amount);
		floatamount = Math.abs(floatamount); 
		amount = myFormat.format(floatamount);
		if(!amount.contains(".")){
			amount = amount + ".00";
			return amount;	
		}


		if(amount.split("\\.")[1].length()==1)
			return amount +"0";

		return amount;

	}


	/**************************************************************
	 * Function to format a amount with dollar
	 * Adds Grouping identifier ','
	 * Returns a string having two characters after a dot
	 * 
	 * @param amount
	 *            Amount which is to be formatted
	 * @return string
	 * 
	 * @author 387478
	 ****************************************************************/


	public String formatAmountWithDollar(String amount){
		boolean isNegative = false;
		try{
			NumberFormat myFormat = NumberFormat.getInstance();
			myFormat.setGroupingUsed(true);   

			amount = RemoveSpecialcharactersFromAmount(amount);
			Double floatamount = Double.parseDouble(amount);
			if(floatamount!=Math.abs(floatamount))
				isNegative = true;
			floatamount = Math.abs(floatamount); 
			amount = myFormat.format(floatamount);
			if(!amount.contains(".")){
				amount = amount + ".00";

				if(!isNegative)
					return "$" + amount;
				else
					return "-$"+amount;
			}


			if(amount.split("\\.")[1].length()==1){
				if(!isNegative)
					return "$" + amount +"0";
				else
					return "-$" + amount +"0";
			}

			if(!isNegative)
				return "$" + amount;
			else
				return "-$" + amount;
		}catch(Exception e){
			//System.out.println(e.getMessage());
			return "";
		}      
	}



	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 ************************************************************* 
	 */
	public WebElement getElementByProperty(String strObjectProperty, String strFindElementType,boolean displayError){

		try{
			if(strFindElementType.equalsIgnoreCase("CSS"))
				return driver.findElement(By.cssSelector(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("XPATH"))
				return driver.findElement(By.xpath(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("ID"))
				return driver.findElement(By.id(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("NAME"))
				return driver.findElement(By.name(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return driver.findElement(By.linkText(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("TAG"))
				return driver.findElement(By.tagName(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("CLASS"))
				return driver.findElement(By.className(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("PARTIALLINKTEXT"))
				return driver.findElement(By.partialLinkText(strObjectProperty));
			else
				return null;
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			if(displayError){
			
				return null;
			}else
				return null;
		}

		catch(Exception e){
			
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify same text is present in both the input strings
	 * 
	 * @param String expectedString
	 * 
	 * @param String actualString
	 * @param objName
	 *        - Name of the object to be updated in the Test log
	 * 
	 * @author 387478    *   
	 *
	 ************************************************************* 
	 */

	public boolean verifyText(String expectedString, String actualString, String objName)
	{
		if(expectedString.equals(actualString)){
			//report.updateTestLog(objName, "'" + objName + "' : " + " Verification is Success", Status.PASS);
			return true;
		} else{
			
			return false;
		}           
	}

	/**
	 ************************************************************* 
	 * Function to verify whether a given Element is present within the page and
	 * click
	 * 
	 * @param strObjProperty
	 *            The {@link strObjProperty} defines the property value used for
	 *            identifying the object
	 * @param strObjPropertyType
	 *            The {@link strObjPropertyType} describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean clickIfElementPresent(WebElement element, String strObjName){

		try{
			if(isElementPresentVerification(element, strObjName)){
				element.click();
				Thread.sleep(10000);
			
				return true;
			} else{
				
						return false;
			}
		} catch(Exception e){
			
			return false;
		}
	}
	/**
	 ************************************************************* 
	 * Function to verify whether a given Element is present within the page and
	 * click
	 * 
	 * @parameter pageObject
	 ************************************************/

	public boolean clickIfElementPresent(PageObjects pageObject){

		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();
		try{
			element.click();
			Thread.sleep(5000);
			
			return true;
		}catch(Exception e){

		
			return false;
		}
	}
	/**
	 ************************************************************* 
	 * Function to verify whether a given Element is present within the page and
	 * click
	 * 
	 * @parameter pageObject
	 ************************************************/

	public void clickOnElementjavaScript(PageObjects pageObject)
	{
		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();

		try{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(4000);
			//report.updateTestLog("Click '" + strObjName + "'", "'"+strObjName +"'"+ " is present and clicked", Status.PASS);

		}catch(Exception e){
			

		}
	}
	/**
	 ************************************************************* 
	 * Function to scroll to Element
	 *
	 * 
	 * @parameter pageObject
	 ************************************************/


	public void scrollToElementjavaScript(PageObjects pageObject)
	{


		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();

		try{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			//executor.executeScript("arguments[0].click();", element);
			executor.executeScript("arguments[0].scrollIntoView();", element);

			Thread.sleep(3000);
			//report.updateTestLog("Click '" + strObjName + "'", "'"+strObjName +"'"+ " is present and scroll in view", Status.PASS);

		}catch(Exception e){
			

		}


	}

	/**
	 ************************************************************* 
	 * Function to click on element and take screenshot
	 * 
	 * 
	 * @parameter pageObject
	 ************************************************/

	public boolean clickIfElementPresentWithoutScreenshots(PageObjects pageObject){

		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();

		try{
			if(isElementPresentVerification(element, strObjName)){
				element.click();
				Thread.sleep(5000);
				
				return true;
			} else{
				
						return false;
			}
		} catch(Exception e){
			
			return false;
		}
	}

	/**
	 ************************************************************* 
	 * Function to click on element
	 * 
	 * @param element
	 * @param strObjName
	 ************************************************/
	public boolean clickIfElementPresents(WebElement element, String strObjName){

		try{
			if(isElementPresentVerification(element, strObjName)){
				element.click();
				Thread.sleep(5000);
				return true;
			} else{
				
						return false;
			}
		} catch(Exception e){

			return false;
		}
	}

	/**
	 ************************************************************* 
	 * Function to click on element if present 
	 * 
	 * @param element
	 * @param strObjName
	 ************************************************/

	public boolean clickIfElementPresentNoWait(WebElement element, String strObjName){

		try{
			if(isElementPresentVerification(element, strObjName)){
				element.click();
				
				return true;
			} else{
				
						return false;
			}
		} catch(Exception e){
			
			return false;
		}
	}



	/**
	 ************************************************************* 
	 * Function to return attribute value
	 * 
	 * @param element
	 *            Element to get value
	 * @param attributeName
	 *            AttributeName to get value
	 * 
	 * @return String value of attribute Name.
	 ************************************************************* 
	 */
	public String getAttributeValue(WebElement element, String attributeName){

		try
		{
			return element.getAttribute(attributeName).toString();
		} catch(Exception e){
			
			return null;
		}
	}



	/*************************************************************
	 * Method to execute PDB sql queries
	 * 
	 * @param strQuery
	 *            - SQL query to be executed
	 * @return record set for executed query
	 * @throws SQLException
	 ************************************************************/
	public ResultSet exeuctePDBQuery(String strQuery) throws SQLException{

		Connection connection = null;
		Statement st;
		ResultSet rs;
		String strServer, strDatabase;
		strServer = properties.getProperty("PDBServer");
		if(strQuery.toLowerCase().contains("web_")){
			strDatabase = properties.getProperty("WebDatabase");



		} else{
			strDatabase = properties.getProperty("PDBDatabase");
		}
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:Driver={SQL Server};SERVER=" + strServer
					+ ";Trusted_connection=yes;DATABASE=" + strDatabase);
			st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(strQuery);
			return rs;
		} catch(Exception e){
			if(connection != null){
				connection.close();
			}
			e.printStackTrace();
			return null;
		}
	}

	/*******************************************************
	 * Method to execute WCBE query
	 * 
	 * @param strQuery
	 *            - Query to be triggered
	 * @return - record set for triggered WCBE SQL query
	 * @throws SQLException
	 ******************************************************/
	public ResultSet exeucteWCBEQuery(String strQuery) throws SQLException{

		Connection connection = null;
		Statement st;
		ResultSet rs;
		String strServer, strDatabase, strPort, strUsername, strPassword;
		strServer = properties.getProperty("WCBEServer");
		strDatabase = properties.getProperty("WCBEDBName");
		strPort = properties.getProperty("WCBEPort");
		strUsername = properties.getProperty("WCBEUsername");
		strPassword = properties.getProperty("WCBEPassword");
		try{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			String url = "jdbc:db2://" + strServer + ":" + strPort + "/" + strDatabase;
			connection = DriverManager.getConnection(url, strUsername, strPassword);
			st = connection.createStatement();
			strQuery = strQuery.replace(";", "");
			if(strQuery.toLowerCase().startsWith("update") || strQuery.toLowerCase().startsWith("delete")
					|| strQuery.toLowerCase().startsWith("insert")){
				st.executeUpdate(strQuery);
				return null;
			} else{
				rs = st.executeQuery(strQuery);
				return rs;
			}

		} catch(Exception e){
			if(!strQuery.startsWith("UPDATE userreg")){
				if(connection != null){
					connection.close();
				}
				//report.updateTestLog("Execute WCBE query", "Query unsuccessful : " + e.getMessage(), Status.FAIL);
				e.printStackTrace();
			}
			return null;
		}
	}

	/***************************************************************************
	 * @description Method to result customer name with time stamp
	 * @param strCustomUserName
	 *            - Customer name
	 * @return String
	 * @modified_date Dec 4, 2013
	 *****************************************************************************/
	public String generateCustomUserName(String strCustomUserName){

		String strTimeStamp = getCurrentTimeStamp();
		return strCustomUserName + strTimeStamp;
	}

	/************************************************
	 * @description Method to generate new user name
	 * @return String
	 * @modified_date Dec 4, 2013
	 *******************************************************/
	public String generateNewUserName(){

		String strTimeStamp = getCurrentTimeStamp();
		return "TestUser" + strTimeStamp;
	}

	/**
	 * @description Method to generate new email address
	 * @return String
	 * @modified_date Dec 4, 2013
	 */
	public String generateUpdateEmailAddr(){

		String strTimeStamp = getCurrentTimeStamp();
		return "newuser" + strTimeStamp + "@gmail.com";
	}

	/**
	 * @description Method to generate new user name
	 * @return String
	 * @modified_date Dec 4, 2013
	 */
	public String generateUpdateUserName(){

		String strTimeStamp = getCurrentTimeStamp();
		return "UpdateUser" + strTimeStamp;
	}

	/**
	 ************************************************************* 
	 * Function to select a particular Value from any List box.
	 * 
	 * @param ListBoxObject
	 *            The {@link WebElement} object that has reference to the List
	 *            Box.
	 * @param strSelectOption
	 *            The {@link String} object that has the item to be selected.
	 * @return void
	 ************************************************************* 
	 */
	public void genericListBoxOptionSelector(WebElement ListBoxObject, String strSelectOption) throws Exception{

		try{
			new Select(ListBoxObject).selectByVisibleText(strSelectOption);
			
		} catch(Exception e){
			
		}
	}

	/**
	 * @description Method to get a time-stamp in MMMdd_mm_ss format
	 * @return String
	 * @modified_date Dec 4, 2013
	 */
	public String getCurrentTimeStamp(){

		String strTimestamp;
		Date currentDate = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMdd_mm_ss");
		strTimestamp = dateFormatter.format(currentDate);
		return strTimestamp;
	}



	/**
	 * @description Method to get eastern time
	 * @return String
	 * @modified_date Dec 4, 2013
	 */
	public String getEasternTimeStamp(){

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("US/Eastern"));
		SimpleDateFormat df = new SimpleDateFormat("E h:mm a '-' zzzz");
		df.setTimeZone(cal.getTimeZone());
		String strEasternTimestamp = df.format(cal.getTime());
		System.out.println(strEasternTimestamp);
		return strEasternTimestamp;
	}

	/**
	 ************************************************************* 
	 * Function to get element attribute
	 * 
	 * @param Element
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @param ElementName
	 *            The {@link String} Attribute name of the element which is to
	 *            be fetched
	 * @return
	 ************************************************************* 
	 */
	public String getElementAttribute(String strObjectProperty, String strFindElementType, String attributeToGet,
			String strObjName){

		String attributVal = null;
		try{
			if(isElementPresentVerification(strObjectProperty, strFindElementType, strObjName)){
				attributVal = getElementByProperty(strObjectProperty, strFindElementType,strObjName).getAttribute(attributeToGet);
			}
		} catch(Exception e){
			//report.updateTestLog("", "Error in method - Error Description - " + e.toString(), Status.FAIL);
		}
		return attributVal;
	}

	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 ************************************************************* 
	 */
	public WebElement getElementByProperty(String strObjectProperty, String strFindElementType, String objName){

		try{
			if(strFindElementType.equalsIgnoreCase("CSS"))
				return driver.findElement(By.cssSelector(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("XPATH"))
				return driver.findElement(By.xpath(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("ID"))
				return driver.findElement(By.id(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("NAME"))
				return driver.findElement(By.name(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return driver.findElement(By.linkText(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("TAG"))
				return driver.findElement(By.tagName(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("CLASS"))
				return driver.findElement(By.className(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("PARTIALLINKTEXT"))
				return driver.findElement(By.partialLinkText(strObjectProperty));
			else
				return null;
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			//report.updateTestLog("Get element '"+objName+"'","Element '"+objName+"' is not displayed",Status.FAIL);
			return null;
		}

		catch(Exception e){
			/*//report.updateTestLog("Verify if " + strFindElementType + " - " + strObjectProperty + " is present",
					"Element with property " + strFindElementType + " - " + strObjectProperty + " not found",
					Status.FAIL);*/
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 ************************************************************* 
	 */
	public List<WebElement> getElementsByProperty(String strObjectProperty, String strFindElementType){

		try{
			// GlobalVariables.strImplicitWait="1";
			if(strFindElementType.equalsIgnoreCase("CSS"))
				return driver.findElements(By.cssSelector(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("XPATH"))
				return driver.findElements(By.xpath(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("ID"))
				return driver.findElements(By.id(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("NAME"))
				return driver.findElements(By.name(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return driver.findElements(By.linkText(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("TAG"))
				return driver.findElements(By.tagName(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("CLASS"))
				return driver.findElements(By.className(strObjectProperty));
			else
				return null;
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			
			return null;
		}

		catch(Exception e){
			
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param webElement
	 *            WebElement for which child elements to be found
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 ************************************************************* 
	 */
	public List<WebElement> getElementsByProperty(WebElement webElement, String strObjectProperty,
			String strFindElementType){

		try{
			// GlobalVariables.strImplicitWait="1";
			if(strFindElementType.equalsIgnoreCase("CSS"))
				return webElement.findElements(By.cssSelector(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("XPATH"))
				return webElement.findElements(By.xpath(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("ID"))
				return webElement.findElements(By.id(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("NAME"))
				return webElement.findElements(By.name(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return webElement.findElements(By.linkText(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("TAG"))
				return webElement.findElements(By.tagName(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("CLASS"))
				return webElement.findElements(By.className(strObjectProperty));
			else
				return null;
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			
			return null;
		}

		catch(Exception e){
			
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param webElement
	 *            WebElement for which child elements to be found
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {WebElement} object.
	 ************************************************************* 
	 */
	public WebElement getElementInsideElement(WebElement webElement, String strObjectProperty, String strFindElementType){

		try{
			// GlobalVariables.strImplicitWait="1";
			if(strFindElementType.equalsIgnoreCase("CSS"))
				return webElement.findElement(By.cssSelector(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("XPATH"))
				return webElement.findElement(By.xpath(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("ID"))
				return webElement.findElement(By.id(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("NAME"))
				return webElement.findElement(By.name(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return webElement.findElement(By.linkText(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("TAG"))
				return webElement.findElement(By.tagName(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("CLASS"))
				return webElement.findElement(By.className(strObjectProperty));
			else
				return null;
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			
			return null;
		}

		catch(Exception e){
			
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 ************************************************************* 
	 */
	public List<WebElement> getElementsInsideElement(WebElement elemUsed, String strObjectProperty,
			String strObjectPropertyType){

		try{
			// GlobalVariables.strImplicitWait="1";
			if(strObjectPropertyType.equalsIgnoreCase("CSS"))
				return elemUsed.findElements(By.cssSelector(strObjectProperty));
			else if(strObjectPropertyType.equalsIgnoreCase("XPATH"))
				return elemUsed.findElements(By.xpath(strObjectProperty));
			else if(strObjectPropertyType.equalsIgnoreCase("ID"))
				return elemUsed.findElements(By.id(strObjectProperty));
			else if(strObjectPropertyType.equalsIgnoreCase("NAME"))
				return elemUsed.findElements(By.name(strObjectProperty));
			else if(strObjectPropertyType.equalsIgnoreCase("LINKTEXT"))
				return elemUsed.findElements(By.linkText(strObjectProperty));
			else if(strObjectPropertyType.equalsIgnoreCase("TAG"))
				return elemUsed.findElements(By.tagName(strObjectProperty));
			else if(strObjectPropertyType.equalsIgnoreCase("CLASS"))
				return elemUsed.findElements(By.className(strObjectProperty));
			else
				return null;
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			
					return null;
		}

		catch(Exception e){
			
					return null;
		}
	}



	/**
	 * Method To Get The Window Size
	 * 
	 * @author Manoj Venkat
	 * @param Dimension
	 * @return strSize {@link dimSize} Size Of The Window
	 */
	public Dimension getWindowSize(){

		Dimension dimSize = driver.manage().window().getSize();
		return dimSize;
	}


	/**
	 ************************************************************* 
	 * Method to verify an element which is a image ,href for which we get the
	 * String value using attribute.
	 * 
	 * @return A boolean value indicating if the searched Element is found.
	 *         author Lavannya
	 ************************************************************* 
	 */
	public WebElement isElementPresentContainsAttributeText(String strObjectProperty, String strFindElementType,
			String StrObjName, String textToVerify, String attribute) throws IOException{

		try{
			if(isElementPresentVerification(strObjectProperty, strFindElementType, StrObjName)){
				getElementByProperty(strObjectProperty, strFindElementType,StrObjName).getAttribute(attribute).contains(
						textToVerify);
				
				return null;
			} else{
				
				return null;
			}
		} catch(Exception e){
			
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Method to verify an element which is a image ,href for which we get the
	 * String value using text.
	 * 
	 * @return A boolean value indicating if the searched Element is found.
	 *         author Lavannya
	 ************************************************************* 
	 */

	public WebElement isElementPresentContainsText(String strObjectProperty, String strFindElementType,
			String StrObjName, String textToVerify) throws IOException{

		try{
			if(isElementPresentVerification(strObjectProperty, strFindElementType, StrObjName)){
				getElementByProperty(strObjectProperty, strFindElementType,StrObjName).getText().contains(textToVerify);
				
				return null;
			} else{
				
				return null;
			}
		} catch(Exception e){
			
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify if an element is present in the application, not using
	 * OR.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean isElementPresentVerification(String strObjectProperty, String strFindElementType, String strObjName)
			throws IOException{

		try{
			if(getElementByProperty(strObjectProperty, strFindElementType,strObjName) != null){
				
				return true;
			} else
				return false;
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			
			return false;
		} catch(Exception e){
			
			return false;
		}
	}


	/**
	 * @description Method to verify if the text in the element has Font-Weight
	 *              Bold returns
	 * @param elmt
	 *            - element to be verified
	 * @return boolean - true on pass and false on failure
	 * @modified_date Dec 9, 2013
	 */
	public boolean isFontWeightBold(WebElement elmt){


		String fontWt = elmt.getCssValue("font-weight");
		Boolean blMatch;
		try{
			int fontVal = Integer.parseInt(fontWt);
			if(fontVal >= 700){
				blMatch = true;
			} else{
				blMatch = false;
			}

		} catch(Exception e){
			if(fontWt.equalsIgnoreCase("bold")){
				blMatch = true;
			} else{
				blMatch = false;
			}
		}

		return blMatch;

	}


	/**************************************************
	 * @description Method to perform mouse hover on given element
	 * @param element
	 *            - element on which mouse hover action needs to be performed
	 * @modified_date Dec 9, 2013
	 ************************************************************/

	public void mouseOver(WebElement element){

		try{

			Robot robot = new Robot();
			robot.mouseMove(0, 0);

			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
		} catch(Exception e){
			
		}

	}

	/**************************************************
	 * @description Method to perform mouse hover on given element
	 * @param pageObject
	 *            - element on which mouse hover action needs to be performed
	 * @modified_date Dec 9, 2013
	 ************************************************************/
	public void mouseOver(PageObjects pageObject){

		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();
		try{



			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
		} catch(Exception e){
			
		}

	}

	/**
	 * @description Method to perform mouse hover action on internet explorer
	 * @param element
	 *            - Element on which mouse hover action needs to be performed
	 * @return Nothing
	 * @modified_date Dec 9, 2013
	 */
	public void mouseOverIE(WebElement element){

		String code = " function sleep(milliseconds) {"
				+ " var start = new Date().getTime();"
				+ " while ((new Date().getTime() - start) < milliseconds){"
				+
				// Do nothing
				"} }" + "if(document.createEvent) {" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent('mouseover', true, false); " + "sleep(50000);"
				+ "arguments[0].dispatchEvent(evObj);" + "arguments[0].click();" + "} "
				+ "else if(document.createEventObject) " + "{ arguments[0].fireEvent('onmouseover'); }";
		((JavascriptExecutor) driver).executeScript(code, element);

	}



	/**
	 * @description Method to perform back browser action
	 * @return Nothing
	 * @modified_date Dec 9, 2013
	 */
	public void navigateBackFromCurrentPage(){

		driver.navigate().back();

	}

	/**
	 * @description Method to navigate to specified URL
	 * @param strURL
	 *            - navigation URL
	 * @return Nothing
	 * @modified_date Dec 9, 2013
	 */
	public void navigateToUrl(String strURL){

		driver.get(strURL);
		driver.manage().window().maximize();
	}

	/**
	 * @description Method to open a new tab in browser with specified URL
	 * @param url
	 * @modified_date Dec 9, 2013
	 */
	public void openTab(String url){

		WebElement a = (WebElement) ((JavascriptExecutor) driver)
				.executeScript(
						"var d=document,a=d.createElement('a');a.target='_blank';a.href=arguments[0];a.innerHTML='.';d.body.appendChild(a);return a",
						url);
		a.click();
	}

	/**
	 ************************************************************* 
	 * Function to get the current Page Load state
	 * 
	 * @param none
	 * @author Ganesh
	 * @return Boolean
	 ************************************************************* 
	 */
	public boolean pageLoadstate(){
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}


	/************************************
	 * @description Method to refresh page
	 * @return Nothing
	 * @modified_date Dec 5, 2014
	 *******************************************/
	public void pageRefresh()
	{
		driver.navigate().refresh();
		//report.updateTestLog( "Page", "Page got Refreshed", Status.PASS);
	}


	/**
	 ************************************************************* 
	 * Function to read properties file
	 * 
	 * @param propertiesFileName
	 *            The {@link String} object that contains the OR name.
	 * @param propertyName
	 *            The {@link String} object that contains the property name to
	 *            read.
	 * @return The {@link String} object that contains the property value.
	 ************************************************************* 
	 */
	public String readPropertiesFile(String propertiesFileName, String propertyName){

		Locale locale = new Locale("en", "US");
		ResourceBundle bundle = ResourceBundle.getBundle(propertiesFileName, locale);
		String propertyValue = bundle.getString(propertyName);
		return propertyValue;

	}

	/*************************************************************************
	 * This method will replace the given query if it has fields <VALUE> with
	 * the given data
	 * 
	 * @param strQuery
	 *            The query which should be modified before execution. Ex:
	 *            "Select price from price where SKU='<VALUE>' and zone_id in
	 *            (select zone_id from zip where zip_prefix='<VALUE>' and
	 *            zip_suffix='<VALUE>')"
	 * @param strData
	 *            Data to be replaced in place of <VALUE> specified in the given
	 *            query PRECEEDED by '&'. Ex: &14336&m5g&212
	 * @return
	 **********************************************************************************/
	public String replaceQueryWithValue(String strDTValue, String strScenario){
		if(strDTValue.toUpperCase().contains("AS400") || strDTValue.toUpperCase().contains("PDB")
				|| strDTValue.toUpperCase().contains("WCBE")){
			String[] arrData = strScenario.split("&");
			for(int i = 1; i < arrData.length; i++){
				strDTValue = strDTValue.substring(0, strDTValue.indexOf("<VALUE>") + 7).replace("<VALUE>", arrData[i])
						+ strDTValue.substring(strDTValue.indexOf("<VALUE>") + 7);
			}
			return strDTValue;
		} else
			return strDTValue;
	}

	/**
	 ************************************************************* 
	 * Method to select an option directly from combo box/list box
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of ENABLED/SELECTED/VALUE
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if selecting an option is done.
	 ************************************************************* 
	 */
	public void selectAnyElement(String strObjProperty, String strObjPropertyType, String strValueToSelect,
			String strObjName){

		if(!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))){
			try{
				WebElement elementToSelect = getElementByProperty(strObjProperty, strObjPropertyType,strObjName);
				selectAnyElement(elementToSelect, strValueToSelect, strObjName);
			} catch(org.openqa.selenium.NoSuchElementException nsee){
				
			} catch(Exception e){
				
			}
		}
	}

	/***
	 ************************************************************* 
	 * Method to select an option directly from combo box/list box
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of ENABLED/SELECTED/VALUE
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if selecting an option is done.
	 ************************************************************* 
	 */
	public void selectAnyElement(WebElement elementToSelect, String strValueToSelect, String strObjName) {

		if(!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))){
			if(elementToSelect.isEnabled()){
				elementToSelect.click();

				Select comSelElement = new Select(elementToSelect);
				try{
					Thread.sleep(3000);
				} catch(Exception e){
				}
				comSelElement.selectByVisibleText(strValueToSelect);

			
			} else{
			}
		}
	}

	/***
	 ************************************************************* 
	 * Method to select an option directly from combo box/list box
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param indexToSelect
	 *            Index to Select
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if selecting an option is done.
	 ************************************************************* 
	 */
	public void selectAnyElement(WebElement elementToSelect, int indexToSelect, String strObjName){

		if(indexToSelect > -1){
			if(elementToSelect.isEnabled()){
				elementToSelect.click();

				Select comSelElement = new Select(elementToSelect);
				try{
					
				} catch(Exception e){
				}
				comSelElement.selectByIndex(indexToSelect);

				
			} else{
				
			}
		}
	}

	/**
	 * Method To Get the window handle result
	 * 
	 * @param driver
	 *            driver of active browser
	 * @param strWindowTitle
	 *            tab title to be switched to
	 * @return boolean
	 */
	public boolean switchToDifferentWindow(WebDriver driver, String strWindowTitle){

		WebDriver popup = null;
		driver.getWindowHandle();
		java.util.Iterator<String> obj = driver.getWindowHandles().iterator();
		// Window handle iterator object initiated
		while(obj.hasNext()){
			String windowHandle = obj.next();
			popup = driver.switchTo().window(windowHandle);
			if(popup.getTitle().contains(strWindowTitle)){

						return true;
			}
		}
		
		return false;
	}

	/**
	 * @description Method to switch to next window
	 * @throws NoSuchWindowException
	 * @return nothing
	 * @modified_date Dec 12, 2013
	 */
	public void switchWindow() throws NoSuchWindowException{

		Set<String> handles = driver.getWindowHandles();
		String current = driver.getWindowHandle();
		handles.remove(current);
		String newTab = handles.iterator().next();
		driver.switchTo().window(newTab);
	}

	/**
	 * @description Method to switch to next window
	 * @throws NoSuchWindowException
	 * @return nothing
	 * @modified_date Dec 12, 2013*/

	public void switchwindowHandle()
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();



		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);

			}
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify whether a given Element is present within the page and
	 * update the value
	 * 
	 * @param strObjProperty
	 *            The {@link strObjProperty} defines the property value used for
	 *            identifying the object
	 * @param strObjPropertyType
	 *            The {@link strObjPropertyType} describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean updateAnyElement(String strObjProperty, String strObjPropertyType, String strValueToUpdate,
			String strObjName){

		if(strValueToUpdate.trim().equalsIgnoreCase("IGNORE")){
			try{
				if(isElementPresentVerification(strObjProperty, strObjPropertyType, strObjName)){
					WebElement elemToClick = getElementByProperty(strObjProperty, strObjPropertyType,strObjName);
					enterValueInElement(elemToClick, strValueToUpdate, strObjName);
				} else{
					
				}
			} catch(org.openqa.selenium.NoSuchElementException nsee){
				
			} catch(Exception e){
				
			}
			return false;
		} else
			return true;
	}

	/**
	 ************************************************************* 
	 * Function to enter value in given element
	 * 
	 * @param elemToClick
	 *            The {@link strObjProperty} element to be updated
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean enterValueInElement(WebElement elemToEnter, String strValueToEnter, String strObjName){

		if(!strValueToEnter.trim().equalsIgnoreCase("IGNORE")){
			try{
				if(elemToEnter.isDisplayed() && elemToEnter.isEnabled())
				{
					Thread.sleep(1000);
					try{
						elemToEnter.click();
					} catch(Exception e){
					}
					elemToEnter.clear();
					elemToEnter.sendKeys(strValueToEnter);
					Thread.sleep(2000);
					//report.updateTestLog("Verify if the Element(" + strObjName + ") is present", "'"+strObjName+"'"
					//+ " is present and entered value : " + strValueToEnter, Status.PASS);
					return true;
				} else{
					//report.updateTestLog("Verify if the Element(" + strObjName + ") is present and value is Entered", strObjName
					//+ " is not enabled", Status.FAIL);
				}
			} catch(org.openqa.selenium.NoSuchElementException nsee){
				//report.updateTestLog("ENTER VALUE IN ELEMENT : " + strObjName, strObjName
				//+ " object does not exist in page", Status.FAIL);
			} catch(Exception e){
				//report.updateTestLog("ENTER VALUE IN ELEMENT ", "Error in finding object - " + strObjName
				//+ ". Error Description - " + e.toString(), Status.FAIL);
			}
			return false;
		} else
			return true;
	}

	/**
	 ************************************************************* 
	 * Function to update Element using javascript
	 * 
	 * @param elemToClick
	 *            The {@link strObjProperty} element to be updated
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 *************************************************************/
	public void updateElementUsingJavaScript(WebElement elmt, String strTextToUpdate, String strElemName){

		try{
			String str = "\"" + strTextToUpdate + "\"";
			String strCode = "arguments[0].setAttribute(\"value\"," + str + ")";
			((JavascriptExecutor) driver).executeScript(strCode, elmt);
			
		} catch(Exception e){
			e.printStackTrace();
		}

	}



	/**
	 ************************************************************* 
	 * Method to verify an element state based on given input conditions and
	 * //report
	 * 
	 * @param elemToVerify
	 *            The {@link strObjProperty} element to be verified
	 * @param strElemStateToVerify
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of
	 *            ENABLED/SELECTED/VALUE/SELECTED VALUE. Any value to be
	 *            verified is given as : VALUE-<Value>
	 * @param strExpValue
	 *            The {@link strExpValue} corresponds to each state
	 *            representations of {@link strElemStateToVerify} namely
	 *            Y/N/<the actual text>
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean verifyAndreportElementState(WebElement elemToVerify, String strElemStateToVerify,
	String strExpValue, String strObjName){

		String strExpStateToreport = " ";
		String strExpValueToCompare = "", strActValue = "", strActAttribute = "";
		boolean blnExpValue = true;
		if((!strExpValue.trim().equalsIgnoreCase("IGNORE")) && (!strElemStateToVerify.trim().contains("IGNORE"))){
			if(strExpValue.trim().equalsIgnoreCase("N")){
				strExpStateToreport = " not ";
				blnExpValue = false;
			}

			// ****************To verify the element is enabled or
			// not***********
			if(strElemStateToVerify.equalsIgnoreCase("ENABLED")){
				if((elemToVerify.isEnabled() && blnExpValue) || (!elemToVerify.isEnabled() && !blnExpValue)){
					
					return true;
				}
				// else if ((elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("N")) ||
				// (!elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("Y")) ){
				else{
					
					return false;
				}
			}

			// ****************To verify the element is displayed or
			// not***********
			if(strElemStateToVerify.equalsIgnoreCase("DISPLAYED")){
				if((elemToVerify.isDisplayed() && blnExpValue) || (!elemToVerify.isDisplayed() && !blnExpValue)){
					
					return true;
				}
				// else if ((elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("N")) ||
				// (!elemToVerify.isEnabled() &&
				// strExpValue.trim().equalsIgnoreCase("Y")) ){
				else{
					
					return false;
				}
			}

			// ****************To verify the element is selected or
			// not***********
			else if(strElemStateToVerify.equalsIgnoreCase("SELECTED")){
				if((elemToVerify.isSelected() && blnExpValue) || (!elemToVerify.isSelected() && !blnExpValue)){
			
					return true;
				} else{
					
							return false;
				}
			}

			// ****************To verify the element has the exact
			// value***********
			else if(strElemStateToVerify.substring(0, 6).equalsIgnoreCase("VALUE-")){
				strExpValueToCompare = strElemStateToVerify.substring(6).trim();
				strActValue = elemToVerify.getText().trim();
				strActValue = RemoveSpecialcharacters(strActValue);
				strExpValueToCompare = RemoveSpecialcharacters(strExpValueToCompare);
				if(elemToVerify.getTagName().trim().equalsIgnoreCase("input")){
					strActAttribute = elemToVerify.getAttribute("value").trim();
					strActAttribute = RemoveSpecialcharacters(strActAttribute);
				} else{
					strActAttribute = "";
				}
				if((strActValue.equalsIgnoreCase(strExpValueToCompare) && blnExpValue)
						|| (!strActValue.equalsIgnoreCase(strExpValue.trim()) && !blnExpValue)
						|| (strActAttribute.trim().equalsIgnoreCase(strExpValueToCompare.trim()) && blnExpValue)
						|| (!strActAttribute.trim().equalsIgnoreCase(strExpValueToCompare.trim()) && !blnExpValue)){
					
					return true;
				} else{
					
					return false;
				}
			}

			// ****************To verify the element contains the expected
			// value***********
			else if(strElemStateToVerify.substring(0, 9).equalsIgnoreCase("CONTAINS-")){
				strExpValueToCompare = strElemStateToVerify.substring(9).trim();
				strActValue = elemToVerify.getText().trim();
				if(elemToVerify.getTagName().trim().equalsIgnoreCase("input")){
					strActAttribute = elemToVerify.getAttribute("value").trim();
				} else{
					strActAttribute = "";
				}
				if((strActValue.contains(strExpValueToCompare) && blnExpValue)
						|| (!strActValue.contains(strExpValue.trim()) && !blnExpValue)
						|| (strActAttribute.contains(strExpValueToCompare) && blnExpValue)
						|| (!strActAttribute.contains(strExpValueToCompare) && !blnExpValue)){
				
							return true;
				} else{
					
				
					return false;
				}

			}

			// ***************To verify if the selected value of a list/combo
			// box is same**************
			else if(strElemStateToVerify.substring(0, 15).equalsIgnoreCase("SELECTED VALUE-")){
				Select comSelElement = new Select(elemToVerify);
				strExpValueToCompare = strElemStateToVerify.substring(15).trim();
				strActValue = comSelElement.getFirstSelectedOption().getText().trim();
				if((strActValue.contains(strExpValueToCompare) && blnExpValue)
						|| (!strActValue.contains(strExpValueToCompare.trim()) && !blnExpValue)){
					
							return true;
				} else{
					
					return false;
				}
			}

			// ***************To verify if the combo box has the list of given
			// values**************
			else if(strElemStateToVerify.substring(0, 15).equalsIgnoreCase("LIST OF VALUES-")){
				List<String> arExpLst;
				boolean blnResult = false, blnActCompare = true;
				List<WebElement> lstOptions = new Select(elemToVerify).getOptions();
				strExpValueToCompare = strElemStateToVerify.substring(15).trim();

				arExpLst = Arrays.asList(strExpValueToCompare.toLowerCase().split(","));
				List<String> arActLst = new ArrayList<String>();
				for(WebElement elemOption : lstOptions){
					arActLst.add(elemOption.getText().toString().trim().toLowerCase());
				}
				for(int i = 0; i < arExpLst.size(); i++){
					blnActCompare = arActLst.indexOf(arExpLst.get(i).trim()) != -1;
					if((blnActCompare && blnExpValue) || !(blnActCompare || blnExpValue)){
						blnResult = true;
					} else{
						blnResult = false;
						break;
					}

				}
				if(blnResult){
					
							return true;
				} else{
					
							return false;
				}
			}

		} else
			return true;
		return false;
	}

	/**
	 * Function name: verifyElementAttribute Description: To verify an attribute
	 * of an object Parameters: strPropertyValue - Object property value,
	 * strPropertyBy - Property type strAttributeName - attribute type,
	 * strAttributeValue - expected attribute value Developed by: VaibhavS
	 * */
	public void verifyElementAttribute(String strPropertyValue, String strPropertyBy, String strObjName,
			String strAttributeName, String strAttributeValue){

		String strActualValue = getElementAttribute(strPropertyValue, strPropertyBy, strAttributeName, strObjName);
		if(strActualValue.equalsIgnoreCase(strAttributeValue)){
			
		} else{
			
		}
	}

	/**
	 * Method to verify the positioning of two web elements. Always to compare
	 * the second element with first element keeping the first element as
	 * static.
	 * 
	 * @param strPositionToVerify
	 *            Standard values to be given are : LEFT,RIGHT,ABOVE,BELOW
	 * @param elemStatic
	 *            This is the element which is set as source of comparison
	 * @param elemToVerify
	 *            This is the element which is to be compared (whether this
	 *            element is above/below/left/right of elemStatic)
	 * @return boolean returns true if the element is present in required
	 *         condition
	 * 
	 */
	public boolean verifyElementPositions(WebElement elemStatic, String elemStaticName, String strPositionToVerify,
			WebElement elemToVerify, String elemToVerifyName){

		int intElem1LocX, intElem1LocY, intElem2LocX, intElem2LocY, intElem1Width, intElem2Width, intElem1Height, intElem2Height;
		boolean blnPositionCheck = false;
		String ErrText = "";
		intElem1LocX = elemStatic.getLocation().x;
		intElem1LocY = elemStatic.getLocation().y;
		intElem2LocX = elemToVerify.getLocation().x;
		intElem2LocY = elemToVerify.getLocation().y;
		intElem1Width = elemStatic.getSize().width;
		intElem2Width = elemToVerify.getSize().width;
		intElem1Height = elemStatic.getSize().height;
		intElem2Height = elemToVerify.getSize().height;

		if(strPositionToVerify.equalsIgnoreCase("LEFT")){
			blnPositionCheck = ((intElem2LocX - (intElem1LocX + intElem1Width)) > -5)
					|| ((intElem2LocX - (intElem1LocX + intElem1Width)) < 5);
			if(!blnPositionCheck){
				ErrText = elemStaticName + " is Not to the Left of " + elemToVerifyName + "." + System.lineSeparator()
				+ "Expected X coordinate of " + elemToVerifyName + ": > " + (intElem1LocX + intElem1Width)
				+ " (i.e., X coordinate + Width of " + elemStaticName + ")." + System.lineSeparator()
				+ "Actual X Coordinate of " + elemToVerifyName + " :" + intElem2LocX;
			}
		} else if(strPositionToVerify.equalsIgnoreCase("RIGHT")){
			blnPositionCheck = ((intElem1LocX - (intElem2LocX + intElem2Width)) > -5)
					|| ((intElem1LocX - (intElem2LocX + intElem2Width)) < 5);
			if(!blnPositionCheck){
				ErrText = elemStaticName + " is Not to the Right of " + elemToVerifyName + "." + System.lineSeparator()
				+ "Expected X coordinate of " + elemStaticName + ": > " + (intElem2LocX + intElem2Width)
				+ " (i.e., X coordinate + Width of " + elemToVerifyName + ")." + System.lineSeparator()
				+ "Actual X Coordinate of " + elemStaticName + " :" + intElem1LocX;
			}
		} else if(strPositionToVerify.equalsIgnoreCase("ABOVE")){

			blnPositionCheck = ((intElem2LocY - (intElem1LocY + intElem1Height)) > -5)
					|| ((intElem2LocY - (intElem1LocY + intElem1Height)) < 5);
			if(!blnPositionCheck){
				ErrText = elemStaticName + " is Not Above " + elemToVerifyName + "." + System.lineSeparator()
				+ "Expected Y coordinate of " + elemToVerifyName + ": > " + (intElem1LocY + intElem1Height)
				+ " (i.e., Y coordinate + Height of " + elemStaticName + ")." + System.lineSeparator()
				+ "Actual Y Coordinate of " + elemToVerifyName + " :" + intElem2LocY;
			}

		} else if(strPositionToVerify.equalsIgnoreCase("BELOW")){
			blnPositionCheck = ((intElem1LocY - (intElem2LocY + intElem2Height)) > -5)
					|| ((intElem1LocY - (intElem2LocY + intElem2Height)) < 5);
			if(!blnPositionCheck){
				ErrText = elemStaticName + " is Not Below " + elemToVerifyName + "." + System.lineSeparator()
				+ "Expected Y coordinate of " + elemStaticName + ": > " + (intElem2LocY + intElem2Height)
				+ " (i.e., Y coordinate + Height of " + elemToVerifyName + ")." + System.lineSeparator()
				+ "Actual Y Coordinate of " + elemStaticName + " :" + intElem1LocY;
			}
		}

		if(blnPositionCheck){
			
					return true;
		} else{
			
			return false;
		}
	}


	/**
	 ************************************************************* 
	 * Function to verify source of image
	 * 
	 * @param element
	 *        Element from which src is to be extracted
	 *         
	 * @param expectedSource
	 *		  Expected value of src Attribute
	 *
	 *@param objName
	 *       Name of the object to be updated in Test Log
	 * @author 387478
	 * @modified_by Shabbir on 31 Oct
	 * 				
	 * 			
	 * @return void
	 ************************************************************* 
	 */

	public void verifyImageSource(WebElement element,String expectedSource, String objName){
		String actualSource="";
		try{
			actualSource = element.getAttribute("src");
			if(actualSource.equals(expectedSource))
			{}else {}
		}catch(Exception e){
			
		}
	}
	/**
	 ************************************************************* 
	 * Function to verify source of image
	 * 
	 * @param element
	 *        Element from which src is to be extracted
	 *         
	 * @param expectedSource
	 *		  Expected value of src Attribute
	 *
	 *@param objName
	 *       Name of the object to be updated in Test Log
	 * @author 387478
	 * @modified_by Shabbir on 31 Oct
	 * 				
	 * 			
	 * @return void
	 ************************************************************* 
	 */
	public void verifyImageSource(PageObjects pageObject,String expectedSource){
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();
		String actualSource="";
		try{
			actualSource = element.getAttribute("src");
			if(actualSource.equals(expectedSource)) {}
				
				else {}
					
		}catch(Exception e){
			
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify Same text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */


	public boolean verifyElementPresentEqualsText(WebElement element, String StrObjName, String textToVerify)	throws IOException{

		String browsername=browsername();
		if(browsername.equalsIgnoreCase("MicrosoftEdge") )
		{
			if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
				try{
					String pageSource = element.getText();
					pageSource  = RemoveSpecialcharacters(pageSource);
					textToVerify  = RemoveSpecialcharacters(textToVerify);
					if(pageSource.equalsIgnoreCase(textToVerify)){
						//report.updateTestLog("Verify Text is Equal", "'" + StrObjName + "' : " 	 + " Text Verification is Success. Verified Value:" + textToVerify, Status.PASS);
						return true;
					} else{
						
					} }
				catch(Exception e){
					//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
				}
			}
		}else if( browsername().equalsIgnoreCase("safari"))
		{
			String pageSource = element.getText();
			pageSource  = RemoveSpecialcharacters(pageSource);
			textToVerify  = RemoveSpecialcharacters(textToVerify);
			if(pageSource.toLowerCase().equalsIgnoreCase(textToVerify.toLowerCase())){
				//report.updateTestLog("Verify Text is Equal", "'" + StrObjName + "' : " 	 + " Text Verification is Success. Verified Value:" + textToVerify, Status.PASS);
				return true;
			} else{}
				//report.updateTestLog(StrObjName, StrObjName + " : Text Verification is Failure. Expected : " + textToVerify
				//+ " Actual : " + pageSource, Status.FAIL);
			
		}else
		{
			if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
				try{
					String pageSource = element.getText();
					pageSource  = RemoveSpecialcharacters(pageSource);
					textToVerify  = RemoveSpecialcharacters(textToVerify);


					if(pageSource.equals(textToVerify)){
						//report.updateTestLog("Verify Text is Equal", "'" + StrObjName + "' : " 	 + " Text Verification is Success. Verified Value:" + textToVerify, Status.PASS);
						return true;
					} else{
						//report.updateTestLog(StrObjName, StrObjName + " : Text Verification is Failure. Expected : " + textToVerify
						//+ " Actual : " + pageSource, Status.FAIL);
					}

				} catch(Exception e){
					//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
				}
			}
		}


		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify Link without click
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */


	public boolean verifyLinkWithoutClick(WebElement element, String StrObjName,String linkToVerify)  throws InterruptedException
	{
		String CurrentUrl = driver.getCurrentUrl().trim();	

		try
		{       
			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					Thread.sleep(11000);
				}
			}
			catch(Exception ex){}


			if(driver.getCurrentUrl().equals(linkToVerify)){ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : "    + " Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}

			String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari"))
			{
				driver.get(CurrentUrl);
				
			}
			else
			{
				driver.navigate().back();
				Thread.sleep(8000);

			}


			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify text
	 * 
	 * @param pageObject
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */


	public boolean verifyElementPresentEqualsText(PageObjects pageObject,  String textToVerify)	throws IOException{
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();
		if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
			try{
				String pageSource = element.getText();
				String pageSource1 = pageSource;
				String textToVerify1 = textToVerify;
				pageSource  = RemoveSpecialcharacters(pageSource);
				//System.out.println(pageSource);
				textToVerify  = RemoveSpecialcharacters(textToVerify);


				if(pageSource.trim().equalsIgnoreCase(textToVerify.trim())){
					//report.updateTestLog("Verify Text is Equal " + StrObjName, "'" + StrObjName + "' : " 	 + " Text Verification is Passed as Verified Value is in English: Expected : " + textToVerify1
					//+ " Actual : " + pageSource1, Status.PASS);
					return true;
				} 
				else
				{
					//report.updateTestLog("Verify Text is Equal " + StrObjName, StrObjName + " : Text Verification is Failure. Expected : " + textToVerify1
					//+ " Actual : " + pageSource1, Status.FAIL);
				}
			} catch(Exception e){
				//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
			}
		}
		return false;
	}
	/**
	 ************************************************************* 
	 * Function to verify Text without screenshot
	 * 
	 * @param pageObject
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */



	public boolean verifyElementPresentEqualsTextWithoutScreenshots(PageObjects pageObject,  String textToVerify)	throws IOException{
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();
		if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
			try{
				String pageSource = element.getText();
				String pageSource1 = pageSource;
				String textToVerify1 = textToVerify;
				pageSource  = RemoveSpecialcharacters(pageSource);
				textToVerify  = RemoveSpecialcharacters(textToVerify);


				if(pageSource.equals(textToVerify)){
					//report.updateTestLog("Verify Text is Equal " + StrObjName, "'" + StrObjName + "' : " 	 + " Text Verification is Passed as Verified Value is in English: Expected : " + textToVerify1
					//+ " Actual : " + pageSource1, Status.DONE);
					return true;
				} 
				else
				{
					//report.updateTestLog("Verify Text is Equal " + StrObjName, StrObjName + " : Text Verification is Failure. Expected : " + textToVerify1
					//+ " Actual : " + pageSource1, Status.FAIL);
				}
			} catch(Exception e){
				//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
			}
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify Attribute without screenshot
	 * 
	 * @param pageObject
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */


	public boolean verifyElementPresentEqualsAttributeWithoutScreenshots(PageObjects pageObject,  String textToVerify)	throws IOException{
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();
		if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
			try{
				String pageSource = element.getAttribute("innerHTML");
				String pageSource1 = pageSource;
				String textToVerify1 = textToVerify;
				pageSource  = RemoveSpecialcharacters(pageSource.replace("b", ""));
				textToVerify  = RemoveSpecialcharacters(textToVerify);
				if(pageSource.equals(textToVerify)){
					//report.updateTestLog("Verify Text is Equal " + StrObjName, "'" + StrObjName + "' : " 	 + " Text Verification is Passed as Verified Value is in English: Expected : " + textToVerify1
					//+ " Actual : " + pageSource1, Status.DONE);
					return true;
				} 
				else
				{
					//report.updateTestLog("Verify Text is Equal " + StrObjName, StrObjName + " : Text Verification is Failure. Expected : " + textToVerify1
					//+ " Actual : " + pageSource1, Status.FAIL);
				}
			} catch(Exception e){
				//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
			}
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify whether a given Element is present within the page and
	 * click
	 * 
	 * @param strObjProperty
	 *            The {@link strObjProperty} defines the property value used for
	 *            identifying the object
	 * @param strObjPropertyType
	 *            The {@link strObjPropertyType} describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used
	 *            for //reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean clickOnGlobalNavigationLink(WebElement element, String strObjName){

		try{
			if(isElementPresentVerification(element, strObjName))
			{
				/*
				element.click();
				new Actions(driver).moveToElement(element).click().perform();
				 */
				Actions builder = new Actions(driver);
				builder.moveToElement(element).click();
				builder.perform();
				//  builder.moveToElement(element);
				Thread.sleep(1000);

				return true;
			} else{
				//report.updateTestLog("Verify Link and Click", "'"+strObjName +"'"
						//+ " is not present", Status.FAIL);
						return false;
			}
		} catch(Exception e){
			//report.updateTestLog("CLICK IF ELEMENT PRESENT", "Error in method - Error Description - " + e.toString(),
		//	Status.FAIL);
			return false;
		}
	}


	/**
	 ************************************************************* 
	 * Function to verify text is present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */

	public boolean verifyElementPresentContainsText(WebElement element, String StrObjName, String textToVerify)	throws IOException
	{
		if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
			try{
				String pageSource = element.getText().trim();

				//System.out.println("|"+ pageSource +"|");
				//System.out.println("|"+ textToVerify +"|");

				if(pageSource.contains(textToVerify))
				{
					//report.updateTestLog("Verify Text in Element", "'" + StrObjName + "' : "  + " Text Verification is Success", Status.PASS);
					return true;
				} else{
					//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected : " + textToVerify
					//+ " Actual : " + pageSource, Status.FAIL);
				}

			} catch(Exception e){
				//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
			}
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify element present contains Text
	 * 
	 * @param pageObject
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */
	public boolean verifyElementPresentContainsText(PageObjects pageObject, String textToVerify) throws IOException
	{
		String pageSource;
		String textToverify1;
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();
		if(browsername().equalsIgnoreCase("Safari"))
		{
			textToverify1=	RemoveSpecialcharacters(textToVerify);
		}else
		{
			textToverify1=RemoveSpecialcharacters(textToVerify);
		}
		if(!textToverify1.trim().equalsIgnoreCase("IGNORE")){
			try{
				if(browsername().equalsIgnoreCase("safari"))
				{
					pageSource = RemoveSpecialcharacters(element.getText());
				}else
				{
					pageSource = RemoveSpecialcharacters(element.getText());

				}

				//System.out.println("|"+ pageSource +"|");
				//System.out.println("|"+ textToVerify +"|");

				if((pageSource.toLowerCase()).contains(textToverify1.toLowerCase()))
				{
					//report.updateTestLog("Verify Text in Element", "'" + StrObjName + "' : "  + " Text Verification is Success", Status.PASS);
					return true;
				} else{}
					//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected : " + textToverify1
				//+ " Actual : " + pageSource, Status.FAIL);
				

			} catch(Exception e){
				//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
			}
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify element Match text
	 * 
	 * @param pageObject
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */

	public boolean verifyElementMatchText(PageObjects pageObject,  String textToVerify)throws IOException
	{
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();
		if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
			try{
				if(element != null)
				{
					String pageSource = element.getText();
					pageSource  = RemoveSpecialcharacters(pageSource);
					if(pageSource.matches(textToVerify))
					{
						//report.updateTestLog("Verify Text is Equal", "'" + StrObjName + "' : " + " Text Verification is Success. Verified Value:" + pageSource, Status.PASS);
						return true;
					} else{

						//report.updateTestLog(StrObjName, StrObjName + " : Text Verification is Failure. Expected : " + textToVerify
						//+ " Actual : " + pageSource, Status.FAIL);
					}
				}else
				{
					//report.updateTestLog("Element Verification - Returned NULL","Unable to get element from Page Object - " + pageObject  ,Status.FAIL);
					return false;
				}
			}catch(Exception e){
				//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
			}
		}
		return false;	
	}

	public boolean verifyElementMatchText(WebElement element, String StrObjName, String textToVerify)	throws IOException
	{
		if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
			try{
				if(element != null)
				{
					String pageSource = element.getText();
					pageSource  = RemoveSpecialcharacters(pageSource).trim();
					if(pageSource.matches(textToVerify.trim()))
					{
						//report.updateTestLog("Verify Text is Equal", "'" + StrObjName + "' : " + " Text Verification is Success. Verified Value:" + pageSource, Status.PASS);
						return true;
					} else{

						//report.updateTestLog(StrObjName, StrObjName + " : Text Verification is Failure. Expected : " + textToVerify
					//	+ " Actual : " + pageSource, Status.FAIL);
					}
				}else
				{
					//report.updateTestLog("Element Verification - Returned NULL","Unable to get element from Page Object - ",Status.FAIL);
					return false;
				}
			}catch(Exception e){
				//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
			}
		}
		return false;	
	}


	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyLinkPageTitle(WebElement element, String StrObjName,String titleToVerify,String linkToVerify)	throws InterruptedException
	{
		String Pagetitle = driver.getTitle().trim();
		String CurrentUrl = driver.getCurrentUrl().trim();	
		linkToVerify = linkToVerify.trim();
		titleToVerify = titleToVerify.trim();

		String actualURL = "";
		try
		{                
			element.click();
			Thread.sleep(12000);
			try
			{
				if(driver.findElement(By.name("leaveButton")).isDisplayed())
				{
					driver.findElement(By.name("leaveButton")).click();
					//System.out.println("Fetching the URL");

					Thread.sleep(10000);
				}
			}
			catch(Exception ex){	
			}

			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					Thread.sleep(9000);
				}
			}
			catch(Exception ex){}


			actualURL = driver.getCurrentUrl();
			// System.out.println(CurrentUrl);
			//System.out.println(actualURL);
			try
			{
				if(driver.getTitle().equals(titleToVerify))
				{ 
					//report.updateTestLog("Verify Page Title", "'" + StrObjName + "': " + "Title Verification is Success", Status.PASS);
				}
				else
				{
					//report.updateTestLog(StrObjName, StrObjName + ": Title Verification is Failure. Expected Url: " + titleToVerify + " Actual: " + driver.getTitle(), Status.FAIL);
				}
			}
			catch(Exception ex){	
			}		    	    


			if(actualURL.equals(linkToVerify))
			{ 
				//report.updateTestLog("Verify Link in Page", "'" + StrObjName + "': " + "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + ": Link Verification is Failure. Expected Url: " + linkToVerify + " Actual: " + actualURL, Status.FAIL);
			}

			String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari"))
			{
				driver.get(CurrentUrl);
				
			}
			else
			{
				driver.navigate().back();
				Thread.sleep(8000);

			}


			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}
	/**
	 ************************************************************* 
	 * Function to verify Link In new Tab
	 * 
	 * @param element
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */

	public void  verifyLinkInNewTabjavaScript(WebElement element, String StrObjName,String linkToVerify)
	{
		try{


			explicitWait(element);
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();

			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);

			
			//report.updateTestLog("Click '" + StrObjName + "'", "'"+StrObjName +"'"+ " is present and clicked", Status.PASS);

		}catch(Exception e){
			//report.updateTestLog("Click '" + StrObjName + "'", "Error in method - Error Description - " + e.getMessage(),
			//Status.FAIL);

		}

		waitForPageToBeReady();


		if(driver.getCurrentUrl().equalsIgnoreCase(linkToVerify))
		{ 
			//report.updateTestLog( "","Link Verification is Success", Status.PASS);
		}
		else
		{
			//report.updateTestLog("" ," : Link Verification is Failure. Expected Url: " + linkToVerify
			//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
		}

		navigateBack();

	}
	/**
	 ************************************************************* 
	 * Function to Close All other Windows
	 * 
	 * @param element
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */
	public  boolean closeAllOtherWindows(String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}

		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify Link and Switch In new Tab
	 * 
	 * @param element
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */

	public void  verifyLinkAndSwitchInNewTabjavaScript(WebElement element, String StrObjName,String linkToVerify) throws InterruptedException
	{

		// fetch all windows before clicking on new window link.
		Set<String> windowHandles = driver.getWindowHandles();
		String han= driver.getWindowHandle();
		System.out.println(windowHandles);
		System.out.println(han);
		try{

			explicitWait(element);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);

			
			//report.updateTestLog("Click '" + StrObjName + "'", "'"+StrObjName +"'"+ " is present and clicked", Status.PASS);

		}catch(Exception e){
			//report.updateTestLog("Click '" + StrObjName + "'", "Error in method - Error Description - " + e.getMessage(),
			//Status.FAIL);

		}
		Thread.sleep(6000);

		Set<String> updatedWindowHandles = driver.getWindowHandles();
		updatedWindowHandles.removeAll(windowHandles);
		System.out.println(updatedWindowHandles);

		for (String window: updatedWindowHandles) {
			driver.switchTo().window(window);
		}

		waitForPageToBeReady();


		if(driver.getCurrentUrl().equals(linkToVerify))
		{ 
			//report.updateTestLog( "","Link Verification is Success", Status.PASS);
		}
		else
		{
			//report.updateTestLog("" ," : Link Verification is Failure. Expected Url: " + linkToVerify
			//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
		}
		closeAllOtherWindows(han);


	}

	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyLinkInWebPage(WebElement element, String StrObjName,String linkToVerify)throws InterruptedException{

		String CurrentUrl = driver.getCurrentUrl().trim();	
		linkToVerify = linkToVerify.trim();

		String actualURL = "".trim();
		try	{     

			try {
				if(driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).click();
					//System.out.println("Fetching the URL");				    	
					Thread.sleep(2000);
				}
			}
			catch(Exception ex){}

			try{
				if(driver.findElement(By.xpath("//*[@id='phVerificationPopup']/div/a")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='phVerificationPopup']/div/a")).click();
				}
			}catch(Exception e){}

			element.click();


			Thread.sleep(12000);

			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					Thread.sleep(7000);
				}
			}
			catch(Exception ex){}


			try {
				if(driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).click();
					//System.out.println("Fetching the URL");				    	
					Thread.sleep(2000);
				}
			}
			catch(Exception ex){}

			actualURL = driver.getCurrentUrl().trim();
			System.out.println(actualURL.trim());
			System.out.println(linkToVerify.trim());
			if(actualURL.trim().contentEquals(linkToVerify.trim())) {

				//report.updateTestLog("Verify Link in Page", "'" + StrObjName + "': " + "Link Verification is Success", Status.PASS);
			}else { }
					//report.updateTestLog(StrObjName, StrObjName + ": Link Verification is Failure. Expected Url: " + linkToVerify + "Actual:" + actualURL, Status.FAIL);

					String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari")){

				driver.get(CurrentUrl);
				Thread.sleep(7000);
			}
			else{


				driver.navigate().back();
				Thread.sleep(5000);


				try{
					if(driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).isDisplayed()){
						driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).click();
						Thread.sleep(2000);
					}
				}catch(Exception e){}

				try{
					if(driver.findElement(By.xpath("//*[@id='emailBillPopup']/div/a")).isDisplayed()){
						driver.findElement(By.xpath("//*[@id='emailBillPopup']/div/a")).click();
					}
				}catch(Exception e){}


				try{
					if(driver.findElement(By.xpath("//*[@id='phVerificationPopup']/div/a")).isDisplayed()){
						driver.findElement(By.xpath("//*[@id='phVerificationPopup']/div/a")).click();
					}
				}catch(Exception e){}
			}

			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}


	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
=======

	/**************************************
	 * 
	 * Verify element matches text
	 * @param element
	 * @param StrObjName
	 * @param linkToVerify
	 * @return
	 * @throws InterruptedException
	 ****************************************/


	public boolean verifyLinkInWebPageWithNoSpecialCharacter(WebElement element, String StrObjName,String linkToVerify)throws InterruptedException{

		String CurrentUrl = RemoveSpecialcharacters(driver.getCurrentUrl().trim());	

		linkToVerify = RemoveSpecialcharacters(linkToVerify.trim());

		String actualURL = "".trim();
		try	{     

			try {
				if(driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).click();
					//System.out.println("Fetching the URL");				    	
					Thread.sleep(2000);
				}
			}
			catch(Exception ex){}

			try{
				if(driver.findElement(By.xpath("//*[@id='phVerificationPopup']/div/a")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='phVerificationPopup']/div/a")).click();
				}
			}catch(Exception e){}
			element.click();
			Thread.sleep(12000);

			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					Thread.sleep(7000);
				}
			}
			catch(Exception ex){}


			try {
				if(driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).click();
					//System.out.println("Fetching the URL");				    	
					Thread.sleep(2000);
				}
			}
			catch(Exception ex){}
			//driver.get(actualURL);
			//System.out.println(actualURL);
			actualURL = driver.getCurrentUrl().trim();
			String removeSpecialChar=RemoveSpecialcharacters(actualURL.trim());
			//System.out.println(actualURL.trim());
			//System.out.println(linkToVerify.trim());
			if(removeSpecialChar.contentEquals(linkToVerify.trim())) {}

				//report.updateTestLog("Verify Link in Page", "'" + StrObjName + "': " + "Link Verification is Success", Status.PASS);
				else {}
					//report.updateTestLog(StrObjName, StrObjName + ": Link Verification is Failure. Expected Url: " + linkToVerify + "Actual:" + actualURL, Status.FAIL);

					String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari")){

				driver.get(CurrentUrl);
				Thread.sleep(7000);
			}
			else{

				driver.navigate().back();
				Thread.sleep(5000);

				try{
					if(driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).isDisplayed()){
						driver.findElement(By.xpath("//*[@id='budgetBillPopup']/div/a")).click();
						Thread.sleep(2000);
					}
				}catch(Exception e){}

				try{
					if(driver.findElement(By.xpath("//*[@id='emailBillPopup']/div/a")).isDisplayed()){
						driver.findElement(By.xpath("//*[@id='emailBillPopup']/div/a")).click();
					}
				}catch(Exception e){}

				try{
					if(driver.findElement(By.xpath("//*[@id='phVerificationPopup']/div/a")).isDisplayed()){
						driver.findElement(By.xpath("//*[@id='phVerificationPopup']/div/a")).click();
					}
				}catch(Exception e){}
			}

			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to navigate back
	 * 
	 *
	 ************************************************************* 
	 */

	public void navigateBack()
	{
		driver.navigate().back();
		waitForPageToBeReady();
	}
	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
>>>>>>> c91b737c1ac55c697ad0335f822e733a453b07bc
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyLinkInPopUpPageTitle(WebElement element, String StrObjName,String linkToVerify,String titleToVerify)	throws InterruptedException{

		try
		{                
			element.click();
			


			try
			{
				if(driver.findElement(By.name("leaveButton")).isDisplayed())
				{
					driver.findElement(By.name("leaveButton")).click();

					Thread.sleep(5000);
				}
			}
			catch(Exception ex)
			{

			}

			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					Thread.sleep(5000);
				}
			}
			catch(Exception ex){}



			if(driver.getTitle().equals(titleToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Title Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Title Verification is Failure. Expected Url: " + titleToVerify
				//+ " Actual : " + driver.getTitle(), Status.FAIL);
			}


			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}
			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}


	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyLinkInPopUp(PageObjects pageObject,String linkToVerify)throws InterruptedException
	{
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();

		try
		{                
			element.click();
			
			try {
				if(driver.findElement(By.xpath("//*[@id='com_fpl_core_view_HandlebarsOutput_22']/div/div/div/div/div/a")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='com_fpl_core_view_HandlebarsOutput_22']/div/div/div/div/div/a")).click();
					
				}
			}
			catch(Exception ex){}

			try {
				if(driver.findElement(By.xpath("//*[@id='com_fpl_core_view_HandlebarsOutput_32']/div/div/div/div/div/a")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='com_fpl_core_view_HandlebarsOutput_32']/div/div/div/div/div/a")).click();
					
				}
			}
			catch(Exception ex){}


			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					
				}
			}
			catch(Exception ex){}


			try {

				if(driver.findElement(By.linkText("No, thanks")).isDisplayed()){
					driver.findElement(By.linkText("No, thanks")).click();
				}
			}
			catch(Exception ex){}


			try
			{
				if(driver.findElement(By.name("leaveButton")).isDisplayed())
				{
					driver.findElement(By.name("leaveButton")).click();

					Thread.sleep(5000);
				}
			}
			catch(Exception ex)
			{

			}

			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}
			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to wait for Page To be Ready
	 * 
	 *
	 ************************************************************* 
	 */


	public  void waitForPageToBeReady() 
	{

		JavascriptExecutor js = (JavascriptExecutor)driver;

		//This loop will rotate for 100 times to check If page Is ready after every 4 second.
		//System.out.println(js.executeScript("return document.readyState").toString());

		for (int i=0; i<400; i++)
		{ 
			try 
			{
				Thread.sleep(6000);
			}catch (Exception e) {} 
			//To check page ready state.

			if (js.executeScript("return document.readyState").toString().equals("complete"))
			{ 
				//System.out.println(js.ex6cuteScript("return document.readyState"));
				//System.out.println("The Page is Ready");
				break;
			}   
		}
	}
	/**
	 ************************************************************* 
	 * Function to Click on Element
	 * 
	 * @param element
	 *            The  object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 ************************************************************* 
	 */
	public void clickOnElementjavaScript(WebElement ele, String StrObjName)
	{


		try{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			
			//report.updateTestLog("Click '" + StrObjName + "'", "'"+StrObjName +"'"+ " is present and clicked", Status.PASS);

		}catch(Exception e){
			//report.updateTestLog("Click '" + StrObjName + "'", "Error in method - Error Description - " + e.getMessage(),
			//Status.FAIL);

		}


	}
	/**
	 ************************************************************* 
	 * Function to verify URL
	 * 
	 * @param String to be verified
	 ************************************************************* 
	 */


	public void verifyURL(String URL)
	{

		waitForPageToBeReady();

		if(driver.getCurrentUrl().equals(URL))
		{ 
			//report.updateTestLog( "","Link Verification is Success", Status.PASS);
		}
		else
		{
			//report.updateTestLog("" ," : Link Verification is Failure. Expected Url: " + URL
			//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
		}
	}
	/**
	 ************************************************************* 
	 * Function to verify URL contains
	 * 
	 * @param String to be verified
	 ************************************************************* 
	 */

	public void verifyURLContains(String URL)
	{

		waitForPageToBeReady();

		if(driver.getCurrentUrl().contains(URL))
		{ 
			//report.updateTestLog( "","Link Verification is Success", Status.PASS);
		}
		else
		{
			//report.updateTestLog("" ," : Link Verification is Failure. Expected Url: " + URL
			//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify Link in PopUp
	 * 
	 * @param String to be verified
	 ************************************************************* 
	 */


	public boolean verifyLinkInPopUp(WebElement element, String StrObjName,String linkToVerify)	throws InterruptedException
	{

		try
		{       

			element.click();
			Thread.sleep(15000);


			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					
				}
			}
			catch(Exception ex){}

			try
			{
				if(driver.findElement(By.name("leaveButton")).isDisplayed())
				{
					driver.findElement(By.name("leaveButton")).click();

					Thread.sleep(5000);
				}
			}
			catch(Exception ex)
			{

			}



			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}
			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}


	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyLinkDonotContainPopUpPageTitle(WebElement element, String StrObjName,String titleToVerify, String linkToVerify)	throws InterruptedException
	{
		try
		{                
			element.click();
			Thread.sleep(8000);

			if(driver.getTitle().equals(titleToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Title Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Title Verification is Failure. Expected Url: " + titleToVerify
				//+ " Actual : " + driver.getTitle(), Status.FAIL);
			}

			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}
			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyLinkDonotContainPopUp(WebElement element, String StrObjName,String linkToVerify)	throws InterruptedException
	{
		try
		{   
			element.click();
			Thread.sleep(6000);

			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}
			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify Link do not contain PpoUp
	 * 
	 * @param String 
	 *            Link to be verified
	 *@param pageObject            
	 * 
	 ************************************************************* 
	 */

	public boolean verifyLinkDonotContainPopUp(PageObjects pageObject,String linkToVerify)	throws InterruptedException
	{
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();
		String LocatorType = pageObject.getLocatorType().toString();
		String Property = pageObject.getProperty();

		try
		{                
			element.click();
			//waitForElementVisibility(LocatorType,Property,"30",false);
			Thread.sleep(15000);


			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					Thread.sleep(20000);
				}
			}
			catch(Exception ex){}


			if((driver.getCurrentUrl().trim()).equals(linkToVerify.trim()))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}
			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify Link do not contain PpoUp Navigation
	 * 
	 * @param String 
	 *            Link to be verified
	 *@param pageObject            
	 * 
	 ************************************************************* 
	 */

	public boolean verifyLinkDonotContainPopUpNavigation(PageObjects pageObject,String linkToVerify)	throws InterruptedException
	{
		String CurrentUrl = driver.getCurrentUrl();
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();

		try
		{                
			element.click();

			Thread.sleep(10000);


			try {
				if(driver.findElement(By.linkText("YES, PLEASE")).isDisplayed()){
					driver.findElement(By.linkText("YES, PLEASE")).click();
					
				}
			}
			catch(Exception ex){}



			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}
			String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari"))
			{
				driver.get(CurrentUrl);
				Thread.sleep(4000);

			}
			else
			{
				driver.navigate().back();
				Thread.sleep(4000);


			}


			return true;


		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify text present in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyGlobalLinkNavigationPageTilte(WebElement element, String StrObjName,String titleToVerify, String linkToVerify)	throws InterruptedException
	{
		try
		{    
			String CurrentUrl = driver.getCurrentUrl();
			element.click();
			Thread.sleep(8000);

			if(driver.getTitle().equals(titleToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Title Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Title Verification is Failure. Expected Url: " + titleToVerify
				//+ " Actual : " + driver.getTitle(), Status.FAIL);
			}


			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}

			String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari"))
			{
				driver.get(CurrentUrl);
				Thread.sleep(4000);
			}
			else
			{
				driver.navigate().back();
				Thread.sleep(4000);

			}


			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}
	/**
	 ************************************************************* 
	 * Function to verify  Link and Page Title
	 * 
	 * @param String 
	 *            Link to be verified
	 *@param StrObjName
	 *@param  titleToVerify
	 *@param linkToVerify
	 * 
	 ************************************************************* 
	 */

	public boolean verifyGlobalLinkNavigationContainsPageTilte(WebElement element, String StrObjName,String titleToVerify, String linkToVerify)	throws InterruptedException
	{
		try
		{    
			String CurrentUrl = driver.getCurrentUrl();
			element.click();
			Thread.sleep(8000);

			if(driver.getTitle().contains(titleToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Title Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Title Verification is Failure. Expected Url: " + titleToVerify
				//+ " Actual : " + driver.getTitle(), Status.FAIL);
			}


			if(driver.getCurrentUrl().contains(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}

			String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari"))
			{
				driver.get(CurrentUrl);
				Thread.sleep(4000);
			}
			else
			{
				driver.navigate().back();
				Thread.sleep(4000);

			}


			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}
	/**
	 ************************************************************* 
	 * Function to verify Link Navigation
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyGlobalLinkNavigation(WebElement element, String StrObjName,String linkToVerify)	throws InterruptedException
	{
		try
		{    
			String CurrentUrl = driver.getCurrentUrl();
			element.click();
			waitForPageToBeReady();
			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			}

			String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari"))
			{
				driver.get(CurrentUrl);
				Thread.sleep(4000);
			}
			else
			{
				driver.navigate().back();
				Thread.sleep(4000);

			}


			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify Link Navigation
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 *************************************************************/

	public boolean verifyGlobalLinkNavigation(PageObjects pageObject,String linkToVerify)	throws InterruptedException
	{
		WebElement element = getPageElement(pageObject); 
		String StrObjName = pageObject.getObjectname();

		try
		{    
			String CurrentUrl = driver.getCurrentUrl();
			element.click();
			Thread.sleep(12000);
			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
			}
			else
			{}
				//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
				//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
			

			String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			if(s.contains("Safari"))
			{
				driver.get(CurrentUrl);
				Thread.sleep(5000);
			}
			else
			{
				driver.navigate().back();
				Thread.sleep(5000);

			}


			return true;

		}
		catch(Exception ex)
		{
			//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify Link In Window in an element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 ************************************************************* 
	 */

	public boolean verifyLinkInWindow(WebElement element, String StrObjName,String linkToVerify) throws IOException, InterruptedException
	{
		try
		{
			String oldTab = driver.getWindowHandle();
			element.click();
			/* ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
                       newTab.remove(oldTab);*/

			String lastHandle="";
			String winHandleBefore = driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles())
				lastHandle = winHandle;

			// change focus to new window
			//driver.switchTo().window(newTab.get(0));
			driver.switchTo().window(lastHandle);
			Thread.sleep(9000); 

			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " + " Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Verification is Failure. Expected Url: " + linkToVerify
			//	+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);

			}

			// Do what you want here, you are in the new tab
			driver.close();
			// change focus back to old tab
			driver.switchTo().window(oldTab);
			Thread.sleep(4000);
			return true;
		} 
		catch(Exception e)
		{
			//report.updateTestLog(("Error in method description"), e.toString(), Status.FAIL);
		}
		return false;

	}
	/**
	 ************************************************************* 
	 * Function to verify Link In Window
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 *************************************************************/

	public boolean verifyLinkInWindow(PageObjects pageObject,String linkToVerify) throws IOException, InterruptedException
	{
		try
		{
			WebElement element = getPageElement(pageObject); 
			String StrObjName = pageObject.getObjectname();

			String oldTab = driver.getWindowHandle();
			element.click();
			/* ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
                       newTab.remove(oldTab);*/

			String lastHandle="";
			String winHandleBefore = driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles())
				lastHandle = winHandle;

			// change focus to new window
			//driver.switchTo().window(newTab.get(0));
			driver.switchTo().window(lastHandle);
			Thread.sleep(15000); 

			if(driver.getCurrentUrl().equals(linkToVerify))
			{ 
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " + " Verification is Success", Status.PASS);
			}
			else
			{
				//report.updateTestLog(StrObjName, StrObjName + " : Verification is Failure. Expected Url: " + linkToVerify
			//	+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);

			}

			// Do what you want here, you are in the new tab
			driver.close();
			// change focus back to old tab
			driver.switchTo().window(oldTab);
			Thread.sleep(4000);
			return true;
		} 
		catch(Exception e)
		{
			//report.updateTestLog(("Error in method description"), e.toString(), Status.FAIL);
		}
		return false;

	}


	/***************************************************************
	 * Function to verify text is not present in an element
	 * 
	 * @author sivka002
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return boolean true - if element does not contain the text
	 **************************************************************/

	public boolean verifyElementPresentNotContainsText(WebElement element, String StrObjName, String textToVerify)
			throws IOException{

		if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
			try{
				textToVerify = textToVerify.replace(" ", "");
				String pageSource = element.getText().toLowerCase();
				String[] pageSourceLines = pageSource.trim().split("\\n");
				String pageSourceWithoutNewlines = "";
				textToVerify = textToVerify.toLowerCase().replaceAll(" ", "");

				for(String pageSourceLine : pageSourceLines){
					pageSourceWithoutNewlines += pageSourceLine + " ";
				}

				pageSourceWithoutNewlines = pageSourceWithoutNewlines.trim().replaceAll(" ", "").replaceAll("\\$", "");
				Pattern p = Pattern.compile(textToVerify);
				Matcher m = p.matcher(pageSourceWithoutNewlines);

				if(!m.find()){
					//report.updateTestLog(StrObjName, "'" + StrObjName + "' value doesnot contain text : "
						//	+ textToVerify + " Verification is Success", Status.PASS);
							return true;
				} else{
					//report.updateTestLog(StrObjName, StrObjName + " value contains text : " + textToVerify + ","
							//+ " Actual : " + pageSourceWithoutNewlines, Status.FAIL);
				}

			} catch(Exception e){
				//report.updateTestLog(("Error in method description").toUpperCase(), e.toString(), Status.FAIL);
			}
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Method to verify an element state based on given input conditions
	 * 
	 * @param elemToVerify
	 *            The {@link strObjProperty} element to be verified
	 * @param strElemStateToVerify
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of
	 *            ENABLED/SELECTED/TEXT/SELECTED VALUE
	 * @param strExpValue
	 *            The {@link strExpValue} corresponds to each state
	 *            representations of {@link strElemStateToVerify} namely
	 *            Y/N/<the actual text>
	 * @return A boolean value indicating if the searched Element is found.
	 ************************************************************* 
	 */
	public boolean verifyElementState(WebElement elemToVerify, String strElemStateToVerify, String strExpValue,
			String strObjName) throws IOException{

		boolean blnExpValue = true;
		if(!strExpValue.trim().equalsIgnoreCase("IGNORE")){
			if(strExpValue.trim().equalsIgnoreCase("N")){
				blnExpValue = false;
			}
			if(strElemStateToVerify.equalsIgnoreCase("ENABLED")){
				if((elemToVerify.isEnabled() && blnExpValue) || (!elemToVerify.isEnabled() && !blnExpValue))
					return true;
			} else if(strElemStateToVerify.equalsIgnoreCase("SELECTED")){
				if((elemToVerify.isSelected() && blnExpValue) || (!elemToVerify.isSelected() && !blnExpValue))
					return true;
			} else if(strElemStateToVerify.equalsIgnoreCase("VALUE")){
				if((elemToVerify.getText().trim().equalsIgnoreCase(strExpValue.trim()) && blnExpValue)
						|| (!elemToVerify.getText().trim().equalsIgnoreCase(strExpValue.trim()) && !blnExpValue))
					return true;
			} else if(strElemStateToVerify.equalsIgnoreCase("CONTAINS")){
				if((elemToVerify.getText().toUpperCase().contains(strExpValue.trim().toUpperCase()) && blnExpValue)
						|| (!elemToVerify.getText().toUpperCase().contains(strExpValue.trim().toUpperCase()) && !blnExpValue))
					return true;
			} else if(strElemStateToVerify.equalsIgnoreCase("SELECTED VALUE")){
				Select comSelElement = new Select(elemToVerify);
				if((comSelElement.getFirstSelectedOption().getText().trim().equalsIgnoreCase(strExpValue.trim()) && blnExpValue)
						|| (!comSelElement.getFirstSelectedOption().getText().trim()
								.equalsIgnoreCase(strExpValue.trim()) && !blnExpValue))
					return true;
			}
		}
		return false;
	}


	/*****************************************************************
	 * Inserts the character ch at the location index of string st
	 * @param st
	 * @param ch
	 * @param index
	 * @return a new string 
	 *************************************************************/
	public String insertCharAt(String st, char ch, int index){
		//1 Exception if st == null
		//2 Exception if index<0 || index>st.length()

		if (st == null){
			throw new NullPointerException("Null string!");
		}

		if (index < 0 || index > st.length())
		{
			throw new IndexOutOfBoundsException("Try to insert at negative location or outside of string");
		}
		return st.substring(0, index)+ch+st.substring(index, st.length());
	}


	/************************************************************
	 * Description: Function to validate items in a list
	 * 
	 * @param strPropertyValue
	 *            = object property value
	 * @param strPropType
	 *            = type of property to be used
	 * @param strObjName
	 *            = object label for //reporting
	 * @param strItemNames
	 *            = items to be verified seperated by semi-colin(;) returns:
	 *            nothing Author: VaibhavS
	 ***********************************************************************/
	public void verifyItemsInList(String strPropertyValue, String strPropType, String strObjName, String strItemNames){

		try{
			if(isElementPresentVerification(strPropertyValue, strPropType, strObjName)){
				WebElement elemToClick = getElementByProperty(strPropertyValue, strPropType,strObjName);
				// clickAnyElement(elemToClick,strObjName);
				String[] arrListNames = strItemNames.split(";");
				List<WebElement> lstElement = getElementsByProperty(elemToClick, "*", "XPATH");
				for(String strItemName : arrListNames){
					for(WebElement webElement : lstElement){
						String strText = webElement.getText();
						if(strText.equalsIgnoreCase(strItemName)){
							//report.updateTestLog("Verify Item " + strItemName + " is present", strItemName
						//	+ " is present", Status.PASS);
							break;
						}
					}
					if(false){
						//report.updateTestLog("Verify Item " + strItemName + " is present", strItemName
					//	+ " is not present", Status.FAIL);
					}
				}

			} else{
				//report.updateTestLog("Verify if the Element(" + strObjName + ") is present", strObjName
				//+ " is not present", Status.FAIL);
			}
		} catch(org.openqa.selenium.NoSuchElementException nsee){
			//report.updateTestLog("VerifyItemsInList: " + strObjName, strObjName + " object does not exist in page",
			//Status.FAIL);
		} catch(Exception e){
			//report.updateTestLog("VerifyItemsInList", "Error in method - Error Description - " + e.toString(),
			//Status.FAIL);
		}
	}

	/**
	 ************************************************************* 
	 * Method to verify multiple lines in a web-element text
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * @param textToVerify
	 *            The {@text String} text value to be verified
	 * @param strObjName
	 *            The name of object for reference
	 * @return
	 ************************************************************* 
	 */
	public boolean verifyMultiLine(WebElement element, String StrObjName, String textToVerify) throws IOException{

		boolean blnFound = true;
		if(!textToVerify.trim().equalsIgnoreCase("IGNORE")){
			try{
				String[] arrLinesToVerify = textToVerify.trim().split("\\n");
				String[] arrPageSrcLines = element.getText().trim().split("\\n");
				for(int itPageSrc = 0; itPageSrc < arrPageSrcLines.length; itPageSrc++)
					if(arrPageSrcLines[itPageSrc].trim().equalsIgnoreCase(arrLinesToVerify[0].trim())){
						for(int itLines = 0; itLines < arrLinesToVerify.length; itLines++)
							if(!arrPageSrcLines[itPageSrc + itLines].trim().equalsIgnoreCase(
									arrLinesToVerify[itLines].trim())){
								blnFound = false;
								break;
							}
					} else if(!blnFound && itPageSrc == arrPageSrcLines.length){
						//report.updateTestLog("verifyMultiLineText".toUpperCase(), StrObjName
					//	+ " do not have expected text : " + textToVerify + " ; Actual : " + element.getText(),
					//	Status.FAIL);
						return false;
					} else if(blnFound){
						//report.updateTestLog("verifyMultiLineText".toUpperCase(), StrObjName + " has the text : "
							//	+ textToVerify + " as expected.", Status.PASS);
								return true;
					}
			} catch(Exception e){
				//report.updateTestLog("verifyMultiLineText".toUpperCase(),
				//"Error in verifying elements :  " + e.getMessage(), Status.FAIL);
			}
		}
		return false;
	}

	/**
	 ************************************************************* 
	 * Function to verify Text Present
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 *************************************************************/

	public void verifyTextPresent(String strText) throws Exception{

		//assertTrue(isTextPresent(strText));
		//report.updateTestLog("Text Verification", strText + "The Text is present ", Status.PASS);

	}

	/**
	 ************************************************************* 
	 * Function to wait for element to be clicked
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 *************************************************************/

	public void waitForElementClickable(String xpathVal, long time){

		try{
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
		} catch(Exception e){
			System.err.print(e.getMessage());
		}
	}
	/**
	 ************************************************************* 
	 * Function to wait for an element to be visible
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 *************************************************************/

	public boolean waitForElementVisibility(String xpathVal, long time){

		try{
			long startTime = System.currentTimeMillis();

			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			//report.updateTestLog("Wait For Element - element found", "Waited for " + elapsedTime / 1000
			//+ " seconds to find element with xpath : " + xpathVal, Status.DONE);
			return true;
		} catch(Exception e){
			return false;
		}
	}

	/****************************************************
	 * Method to synchronize until element is present
	 * @param strElementValue - property value
	 * @param strElementType - element locator type
	 * @param time - synchronization timeout
	 * @return true/false
	 *************************************************/
	public boolean waitForElementPresence(String strElementValue, String strElementType, long time)
	{

		try{
			long startTime = System.currentTimeMillis();
			if(strElementType.equalsIgnoreCase("XPATH")){
				WebDriverWait wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strElementValue)));

			} else if(strElementType.equalsIgnoreCase("ID")){
				WebDriverWait wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(strElementValue)));

			} else if(strElementType.equalsIgnoreCase("NAME")){
				WebDriverWait wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(strElementValue)));

			} else if(strElementType.equalsIgnoreCase("LINKTEXT")){
				WebDriverWait wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(strElementValue)));

			} else if(strElementType.equalsIgnoreCase("CSS")){
				WebDriverWait wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(strElementValue)));

			}
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			//report.updateTestLog("Wait For Element - element found", "Waited for " + elapsedTime / 1000
			//+ " seconds to find element with " + strElementType + " - " + strElementValue, Status.DONE);
			return true;
		} catch(Exception e){
			System.err.print(e.getMessage());
			return false;

		}
	}

	/*********************************************************
	 * Method to wait for Element visibility
	 * @param property - property value
	 * @param locator - element locator type
	 * @param time - synchronization timeout
	 * @return true/false
	 * *********************************************************
	 */	
	public boolean waitForElementVisibility(String locator, String property, long time, Boolean printError){
			boolean result= false;
		try{
			long startTime = System.currentTimeMillis();

			WebDriverWait wait = new WebDriverWait(driver, time);
			if(locator.equalsIgnoreCase("css"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(property)));
			else if(locator.equalsIgnoreCase("linktext"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(property)));
			else if(locator.equalsIgnoreCase("xpath"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(property)));
			else if(locator.equalsIgnoreCase("classname"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(property)));
			else if(locator.equalsIgnoreCase("name"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(property)));
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(property)));
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;

			result = true;
		} catch(Exception e){
			if(printError)
				//report.updateTestLog("Wait For Element - element not found", "Waited for " + time
				//+ " seconds to find element with : " + property, Status.DONE);
				result = false;
		}
			return result;	
	}

	/**
	 ************************************************************* 
	 * Function to wait for Element Visibility
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 *************************************************************/
	public boolean waitForElementVisibility(PageObjects pageObject, long time, Boolean printError){
		String locator = pageObject.getLocatorType().toString();
		String property = pageObject.getProperty();
		boolean result = false;
		try{
			long startTime = System.currentTimeMillis();

			WebDriverWait wait = new WebDriverWait(driver, time);
			if(locator.equalsIgnoreCase("css"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(property)));
			else if(locator.equalsIgnoreCase("linktext"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(property)));
			else if(locator.equalsIgnoreCase("xpath"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(property)));
			else if(locator.equalsIgnoreCase("classname"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(property)));
			else if(locator.equalsIgnoreCase("name"))
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(property)));
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(property)));
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;

			result = true;
		} catch(Exception e){
			if(printError)
				//report.updateTestLog("Wait For Element - element not found", "Waited for " + time
			//	+ " seconds to find element with : " + property, Status.DONE);
				result= false;
		}
		return result;
	}

	/**
	 ************************************************************* 
	 * Function to verify whether Element is present Inside Element
	 * 
	 * @param Element
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 
	 * @param textToVerify
	 *            The {@text String} Attribute name of the element which is to
	 *            be verified
	 * @return
	 * @throws InterruptedException 
	 *************************************************************/

	public boolean isElementPresentInsideElement(WebElement parentElement, String strObjectProperty,
			String strFindElementType){
		WebElement elemToFind = null;
		try{

			if(strFindElementType.equalsIgnoreCase("CSS"))
				elemToFind = parentElement.findElement(By.cssSelector(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("XPATH"))
				elemToFind = parentElement.findElement(By.xpath(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("ID"))
				elemToFind = parentElement.findElement(By.id(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("NAME"))
				elemToFind = parentElement.findElement(By.name(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
				elemToFind = parentElement.findElement(By.linkText(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("TAG"))
				elemToFind = parentElement.findElement(By.tagName(strObjectProperty));
			else if(strFindElementType.equalsIgnoreCase("CLASS"))
				elemToFind = parentElement.findElement(By.className(strObjectProperty));
			// //report.updateTestLog("isElementPresent","Expected...",
			// Status.PASS);

		} catch(org.openqa.selenium.NoSuchElementException nsee){
			//System.out.println("Exception in isElementPresent:" + nsee);
			return false;
		}
		// Extra protection...
		if(elemToFind == null){
			return false;
		} else{
			//System.out.println("Found element:" + strObjectProperty);
			return true;
		}
	}

	/****************************************
	 * Method to Arrow down a page
	 * @author Priya
	 * @modified 11 November 2014
	 ***********************************/
	public void ArrowDownNo(int no) throws NoSuchWindowException
	{

		for(int i=0;i<no;i++)
		{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).perform();
		}
	}

	/****************************************
	 * Method to Arrow Up a page
	 * @author Priya
	 * @modified 11 November 2014
	 ***********************************/
	public void ArrowUpNo(int no) throws NoSuchWindowException
	{

		for(int i=0;i<no;i++)
		{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_UP).perform();
		}
	}
	/************************************************************************
	 * 
	 * This function returns the width of the current driver window
	 * 
	 * @return int 
	 *         width of the current window
	 * 
	 * @author 387478
	 * @created on 6 Jan 2014
	 *************************************************************************
	 **/

	public int getWidth(){
		return driver.manage().window().getSize().width;
	}


	/************************************************************************
	 * getRWDView
	 * This function returns the RWD view in which the browser is opened
	 * 
	 * @return desktop 
	 *         If the website is opened in desktop view
	 *         
	 * @return tablet
	 *  	   If the website is opened in tablet view
	 *  
	 * @return mobile
	 * 	 	   If the website is opened in tablet view
	 * 
	 * 
	 * @author 387478
	 * @created on 6 Jan 2014
	 *************************************************************************
	 **/

	public String getRWDView(){
		int width = getWidth();
		String RWDView = "tablet";

		if(width<=752)
			RWDView="mobile";
		else if(width>1009)
			RWDView="desktop";


		return RWDView;
	}


	/************************************************************************
	 * getEnvironment
	 * Read environment from properties file and return it
	 * 
	 * @return String 
	 *         QA, TEST OR PROD
	 * 
	 * @author 387478
	 * @created on 6 Jan 2014
	 *************************************************************************
	 **/

	public String getEnvironment(){
		return properties.getProperty("Environment");
	}  	

	/************************************************************************
	 * getTimeout
	 * Read timeout from properties file and return it
	 * 
	 * @return int
	 *         Value of timeout
	 * 
	 * @author 387478
	 * @created on 6 Jan 2014
	 *************************************************************************
	 **/

	public int getTimeout(){
		int timeout = 60;
		try{
			timeout = Integer.parseInt(properties.getProperty("Timeout"));
		}catch(Exception e){
		}

		return timeout;
	}  	


	/************************************************************************
	 * formatSSN
	 * Convert input ssn to 4 digits and return
	 * e.g. 330 will be converted to 0330
	 * 
	 * @return String
	 *         Four digit ssn padded with zeros
	 * 
	 * @author 387478
	 * @created on 6 Jan 2014
	 *************************************************************************
	 **/
	public String formatSSN(String ssn){
		try{
			if(ssn.length()> 0 && ssn.length()<4)
				ssn = String.format("%04d", Integer.parseInt(ssn));
		}catch(Exception e){
			//System.out.println("formatSSN-"+ssn+" .error-"+e.getMessage());
		}
		return ssn;
	}


	/************************************************************************
	 * formatAccountNumber
	 * Convert input AccountNumber to 10 digits and return
	 * e.g. 123456789 will be converted to 0123456789
	 * 
	 * @return String
	 *         Four digit ssn padded with zeros
	 * 
	 * @author 387478
	 * @created on 6 Jan 2014
	 *************************************************************************
	 **/
	public String formatAccountNumber(String accountNumber){
		try{
			if(accountNumber.length()> 0 && accountNumber.length()<10)
				accountNumber = String.format("%10d", Integer.parseInt(accountNumber));
		}catch(Exception e){
			//System.out.println("formatSSN-"+accountNumber+" .error-"+e.getMessage());
		}
		return accountNumber;
	}

	/**
	 ************************************************************* 
	 * Function to get Page Element
	 * 
	 * @param pageObject
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 	 * 
	 * @return
	 * @throws InterruptedException 
	 *************************************************************/
	public  WebElement getPageElement(PageObjects pageObject)
	{
		try{           
			WebElement element;
			element =  getElementByProperty(pageObject.getProperty(), pageObject
					.getLocatorType().toString(),pageObject.getObjectname());

			if(element != null){                  
				//waitForElementVisibility(pageObject.getLocatorType().toString(), pageObject.getProperty(), 30, true);
				highlightElement(element);
			}
			return element;

		} catch(Exception e){			
			//report.updateTestLog("get page element - get page element", pageObject.toString()
			//+ " object is not defined or found. Error:"+e.getMessage(), Status.FAIL);
			return null;
		}
	}

	/**
	 ************************************************************* 
	 * Function to verify Element is Disabled
	 * 
	 * @param pageObject
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * 	 * 
	 * @return
	 * @throws Exception 
	 *************************************************************/
	public void verifyElementDisebled(PageObjects pageObject, String value)throws Exception
	{
		String strObjName = pageObject.getObjectname();
		WebElement element = getPageElement(pageObject);
		String val=element.getAttribute("aria-disabled");

		if(val.equalsIgnoreCase(value))
		{
			//report.updateTestLog("Verify if the Element(" + strObjName + ") is present and Not Enabled", strObjName
			//+ " object is not enabled", Status.PASS);

		}else
		{
			//report.updateTestLog("Verify if the Element(" + strObjName + ") is present and Enabled", strObjName
		//	+ " object is enabled", Status.FAIL);
		}

	}
	/**
	 ************************************************************* 
	 * Function to verify Element is Displayed
	 * 
	 * @param pageObject
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 *
	 * @return
	 * @throws Exception 
	 *************************************************************/

	public boolean isDisplayed(PageObjects pageObject){
		try{
			WebElement element = getPageElement(pageObject);
			String StrObjName = pageObject.getObjectname();
			if(element.isDisplayed()){ 
				//report.updateTestLog("Verify "+StrObjName+" is displayed", "'" + StrObjName + "' : " 	+ "is displayed", Status.DONE);
			}
			else{
				//report.updateTestLog("Verify "+StrObjName+" is displayed", "'" + StrObjName + "' : " 	+ "is not displayed", Status.FAIL);
			}}catch(Exception e){

			}
		return true;
	}
	/**
	 ************************************************************* 
	 * Function to verify Element is Displayed
	 * 
	 * @param pageObject
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * @param writeTestLog
	 * @return
	 * @throws Exception 
	 *************************************************************/

	public boolean isDisplayed(PageObjects pageObject,Boolean writeTestLog){


		WebElement element = getPageElement(pageObject);
		String StrObjName = pageObject.getObjectname();
		boolean isDisplayed = element.isDisplayed();
		if(writeTestLog){
			if(isDisplayed) {
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "is displayed", Status.PASS);
			}else { }
				//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "is not displayed", Status.FAIL);
			}
		return isDisplayed;
	}
	/**
	 ************************************************************* 
	 * Function to verify Element is not Displayed
	 * 
	 * @param pageObject
	 *            The {@Webelement Element} object that contains
	 *            the page element
	 * @param writeTestLog
	 * @return
	 * @throws Exception 
	 *************************************************************/


	public boolean isNotDisplayed(PageObjects pageObject, Boolean writereport, int timeToSearch){

			String strFindElementType = pageObject.getLocatorType().toString();
	String strObjectProperty= pageObject.getProperty();
	WebElement element=null;
	try{
		if(strFindElementType.equalsIgnoreCase("CSS"))
			element=driver.findElement(By.cssSelector(strObjectProperty));
		else if(strFindElementType.equalsIgnoreCase("XPATH"))
			element=driver.findElement(By.xpath(strObjectProperty));
		else if(strFindElementType.equalsIgnoreCase("ID"))
			element=driver.findElement(By.id(strObjectProperty));
		else if(strFindElementType.equalsIgnoreCase("NAME"))
			element=driver.findElement(By.name(strObjectProperty));
		else if(strFindElementType.equalsIgnoreCase("LINKTEXT"))
			element= driver.findElement(By.linkText(strObjectProperty));
		else if(strFindElementType.equalsIgnoreCase("TAG"))
			element= driver.findElement(By.tagName(strObjectProperty));
		else if(strFindElementType.equalsIgnoreCase("CLASS"))
			element= driver.findElement(By.className(strObjectProperty));
		else if(strFindElementType.equalsIgnoreCase("PARTIALLINKTEXT"))
			element= driver.findElement(By.partialLinkText(strObjectProperty));
		if(element.isDisplayed()){
			//report.updateTestLog("Verify "+pageObject.getObjectname()+" is not displayed", pageObject.getObjectname()+" is displayed", Status.FAIL);
		}else{
			//report.updateTestLog("Verify "+pageObject.getObjectname()+" is not displayed", pageObject.getObjectname()+" is not displayed", Status.PASS);
		}
	}catch(Exception e){
		if(writereport){
				//report.updateTestLog("Verify "+pageObject.getObjectname()+" is not displayed", pageObject.getObjectname()+" is not displayed", Status.PASS);
	}
	return true;
}


return false;


}

/**
 ************************************************************* 
 * Function to verify Element is Displayed with out Screen shot
 * 
 * @param pageObject
 *            The {@Webelement Element} object that contains
 *            the page element
 * @param writeTestLog
 * @return
 * @throws Exception 
 *************************************************************/


public boolean isDisplayedWithoutScreenshot(PageObjects pageObject){
	WebElement element = getPageElement(pageObject);
	String StrObjName = pageObject.getObjectname();
	if(element.isDisplayed())
	{ 
		
	}
	else
	{
	
	}
	return true;

}
/**
 ************************************************************* 
 * Function to verify Element is Selected
 * 
 * @param pageObject
 *            The {@Webelement Element} object that contains
 *            the page element
 * 
 * @return
 * @throws Exception 
 *************************************************************/

public boolean isSelected(PageObjects pageObject){
	WebElement element = getPageElement(pageObject);
	return element.isSelected();
}

/**
 ************************************************************* 
 * Function to HighLight Element 
 * 
 * @param pageObject
 *            The {@Webelement Element} object that contains
 *            the page element
 * @param writeTestLog
 * @return
 * @throws Exception 
 *************************************************************/


public void highlightElement(WebElement element) throws InterruptedException 
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 1px solid red;");

	Thread.sleep(500);     
	js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
}

/***************************************************************
 * Function to Scroll down on web page
 * @return 
 * @Modified by pxg0fzc on 29 October
 ***************************************************************
 */
public boolean scrollDownPage() throws Exception
{
	String browsername=browsername();

	JavascriptExecutor View =(JavascriptExecutor)driver;
	View.executeScript("window.scrollBy(0,500)");
	//report.updateTestLog( "Page Down", "User Scroll down the Page", Status.PASS);

	//Navigating to Account Summary page	and Scroll down the Page
	return false;

}
/***************************************************************
 * Function to Scroll down on web page
 * @return 
 * @Modified by pxg0fzc on 29 October
 ***************************************************************
 */
public boolean scrollUpPage() throws Exception
{
	String browsername=browsername();
	if(browsername.equalsIgnoreCase("firefox"))
	{
		JavascriptExecutor View =(JavascriptExecutor)driver;
		View.executeScript("window.scrollBy(0,-800)");
		//report.updateTestLog( "Page Down", "User Scroll down the Page", Status.PASS);
	}else	{
		//Navigating to Account Summary page	and Scroll down the Page
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).perform();
		Thread.sleep(8000);
		//report.updateTestLog( "Page Up", "User Scroll Up the Page", Status.PASS);
	}
	//Navigating to Account Summary page	and Scroll down the Page
	return false;

}

//get the current browser version
/**
 ************************************************************* 
 * Function to verify Browser name
 * 
 * @return
 * @throws Exception 
 *************************************************************/

public String browsername()
{

	Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	String browserName = cap.getBrowserName();
	//System.out.println(browserName);
	return browserName;
}
/**
 ************************************************************* 
 * Function to verify Execution mode
 * 
 * @return executionmode
 * @throws Exception 
 *************************************************************/


public String executionmode()
{
	String executionmode = properties.getProperty("ExecutionMode");
	//System.out.println(executionmode);
	return executionmode;
}
/**
 ************************************************************* 
 * Function to verify Link In New Tab
 * @param pageObject
 * @param URL
 * @throws Exception 
 *************************************************************/

public void linkInNewTab(PageObjects pageObject, String URL)
{
	int count =0;
	String Parent_Window = driver.getWindowHandle();
	String StrObjName = pageObject.getObjectname();
	WebElement element = getPageElement(pageObject);
	clickIfElementPresent(pageObject);
	for (String Child_Window : driver.getWindowHandles())
	{
		if(count==1)
		{

			driver.switchTo().window(Child_Window);
			// Performing actions on child window
			String URL_Actual= driver.getCurrentUrl();
			if(URL_Actual.equalsIgnoreCase(URL))
			{
				//report.updateTestLog("", StrObjName+"navigates to "+URL_Actual, Status.PASS);
			}else
			{
				//report.updateTestLog("", StrObjName+"navigates to "+URL_Actual, Status.FAIL);
			}
			driver.switchTo().window(Child_Window).close();
		}
		count++;


	}

	//Switching back to Parent Window
	driver.switchTo().window(Parent_Window);


}


public WebDriver getWebDriver() {
	return getWebDriver();
}
/**
 ************************************************************* 
 * Function to verify Explicit Wait
 * @param pageObject
 * 
 * @throws Exception 
 *************************************************************/

public void explicitWait(PageObjects pageObject){
	try{
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element = getPageElement(pageObject);

		if(element!=null){
			wait.until(ExpectedConditions.visibilityOf(element));
		}else{
			//report.updateTestLog("Explicit Wait", "Element returned -null", Status.WARNING);
		}
	}catch (Exception e){
		//report.updateTestLog("Explicit Wait", "Explicit Wait Failed for "+pageObject.toString(), Status.FAIL);
	}
}

/**
 ************************************************************* 
 * Function to verify Explicit Wait
 * @param element
 * 
 * @throws Exception 
 *************************************************************/

public void explicitWait(WebElement element){
	try{
		WebDriverWait wait=new WebDriverWait(driver,60);

		if(element!=null){
			wait.until(ExpectedConditions.visibilityOf(element));
		}else{
			//report.updateTestLog("Explicit Wait", "Element returned -null", Status.WARNING);
		}
	}catch (Exception e){
		//report.updateTestLog("Explicit Wait", "Explicit Wait Failed for "+element.toString(), Status.FAIL);
	}
}

/**
 ************************************************************* 
 * Function to verify Explicit Wait Clickable
 * @param element
 * 
 * @throws Exception 
 *************************************************************/
public void explicitWaitClickAble(PageObjects pageObject){
	try{
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element = getPageElement(pageObject);
		if(element!=null){
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}else{
			//report.updateTestLog("Explicit Wait", "Element returned -null", Status.WARNING);
		}
	}catch (Exception e){
		//report.updateTestLog("Explicit Wait", "Explicit Wait Failed for "+pageObject.toString(), Status.FAIL);
	}
}



/***************************************************
 *Function to  Scroll to  specific element
 ** @param element
 * 
 * @throws Exception 
 *************************************************************/ 


public void scrollToSpecificElemnt(WebElement element)
{

	JavascriptExecutor executor = (JavascriptExecutor)driver;

	executor.executeScript("arguments[0].scrollIntoView(true);", element);
}

/***************************************************
 *Function to  verify Link and Switch in New Tab
 ** @param element
 * 
 * @throws Exception 
 *************************************************************/ 

public void  verifyLinkAndSwitchInNewTabjavaScript(PageObjects pageObject,String linkToVerify) throws InterruptedException
{

	String StrObjName = pageObject.getObjectname();
	WebElement element = getPageElement(pageObject);
	// fetch all windows before clicking on new window link.
	Set<String> windowHandles = driver.getWindowHandles();
	String han= driver.getWindowHandle();
	//System.out.println(windowHandles);
	//System.out.println(han);
	try{
		explicitWait(element);
		//     Actions act = new Actions(driver);
		//act.moveToElement(element).build().perform();
		if(browsername().equalsIgnoreCase("safari"))
		{
			waitForPageToBeReady();
			element.click();
		}else
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
		}

		//report.updateTestLog("Click '" + StrObjName + "'", "'"+StrObjName +"'"+ " is present and clicked", Status.PASS);
	}catch(Exception e){
		e.printStackTrace();
		//report.updateTestLog("Click '" + StrObjName + "'", "Error in method - Error Description - " + e.getMessage(),
		//Status.FAIL);
	}
	Thread.sleep(6000);
	Set<String> updatedWindowHandles = driver.getWindowHandles();
	updatedWindowHandles.removeAll(windowHandles);
	//System.out.println(updatedWindowHandles);
	for (String window: updatedWindowHandles) {
		driver.switchTo().window(window);
	}
	waitForPageToBeReady();
	if(driver.getCurrentUrl().equals(linkToVerify))
	{ 
		//report.updateTestLog( "","Link Verification is Success", Status.PASS);
	}
	else
	{
		//report.updateTestLog("" ," : Link Verification is Failure. Expected Url: " + linkToVerify
		//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
	}
	closeAllOtherWindows(han);
}
/***************************************************
 *Function to  extract Number
 ** @param element
 * 
 * @throws Exception 
 *************************************************************/ 


public static String extractNumber(final String str) {                

	if(str == null || str.isEmpty()) return "";

	StringBuilder sb = new StringBuilder();
	boolean found = false;
	for(char c : str.toCharArray()){
		if(Character.isDigit(c)){
			sb.append(c);
			found = true;
		} else if(found){
			// If we already found a digit before and this char is not a digit, stop looping
			break;                
		}
	}

	return sb.toString();
}
/***************************************************
 *Function to verify Global Link Navigation
 ** @param element
 * 
 * @throws Exception 
 *************************************************************/ 


public boolean verifyGlobalLinkNavigation(WebElement element, String StrObjName,String titleToVerify, String linkToVerify)	throws InterruptedException
{


	try
	{   String url= driver.getCurrentUrl();
	String ActualURL ;
	String ReplacedUrl;
	element.click();
	waitForPageToBeReady();
	String CurrentUrl = driver.getCurrentUrl();
	//System.out.println(CurrentUrl);
	String ifURLCOntainNumbe=extractNumber(CurrentUrl);
	//System.out.println(ifURLCOntainNumbe);

	if( CurrentUrl.contains("cid=HQL"+ifURLCOntainNumbe) )
	{


		ActualURL=CurrentUrl.replaceAll("cid=HQL"+ifURLCOntainNumbe, "");
		ReplacedUrl= RemoveQuestionMark(ActualURL);
		//System.out.println("URL is "+ ReplacedUrl);
	}else
	{
		ReplacedUrl=CurrentUrl;
	}


	if(driver.getTitle().equals(titleToVerify))
	{ 
		//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Title Verification is Success", Status.PASS);
	}
	else
	{
		//report.updateTestLog(StrObjName, StrObjName + " : Title Verification is Failure. Expected Url: " + titleToVerify
		//+ " Actual : " + driver.getTitle(), Status.FAIL);
	}


	if(ReplacedUrl.equals(linkToVerify))
	{ 
		//report.updateTestLog(StrObjName, "'" + StrObjName + "' : " 	+ "Link Verification is Success", Status.PASS);
	}
	else
	{
		//report.updateTestLog(StrObjName, StrObjName + " : Link Verification is Failure. Expected Url: " + linkToVerify
		//+ " Actual : " + driver.getCurrentUrl(), Status.FAIL);
	}

	String s = browsername();
	if(s.contains("Safari"))
	{
		driver.get(url);
		Thread.sleep(4000);
	}
	else
	{
		driver.get(url);
		Thread.sleep(4000);

	}


	return true;

	}
	catch(Exception ex)
	{
		//report.updateTestLog(("Something Went Wrong!!.."), ex.toString(), Status.FAIL);  
	}
	return false;
}
/***************************************************
 *Function to  verify Mouse action
 ** @param element
 * 
 * @throws Exception 
 *************************************************************/ 


public boolean onMouseOver(WebElement element)
{
	boolean result = false;
	try
	{
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject){ arguments[0].fireEvent('onmouseover');}";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(mouseOverScript, element);
		//report.updateTestLog("", "Mouse movement is occured", Status.PASS);
		result = true;
	}
	catch (Exception e)
	{
		e.printStackTrace();
		result = false;
	}
	return result;
}

/**************************************
 * Mouse action for all browsers
 * 
 * @param driver
 * @param element
 * @param locator
 *****************************/

public void moveToElement(WebDriver driver, WebElement element, By locator) {
	if (!(driver instanceof SafariDriver)) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
	}
	else {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String locatorType = locator.toString().substring(3);
		String elem = "var elem = document;";
		if (locatorType.startsWith("id")) {
			elem = "var elem = document.getElementById(\""+locatorType.substring(4)+"\");";
		}
		else if (locatorType.startsWith("xpath")) {
			String snippet = "document.getElementByXPath = function(sValue) { var a = this.evaluate(sValue,this, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null); if (a.snapshotLength > 0){ return a.snapshotItem(0); } }; ";
			js.executeScript(snippet);
			elem = "var elem = document.getElementByXPath(\""+locatorType.substring(7)+"\");";
		}
		else if (locatorType.startsWith("className")) {
			elem = "var elem = document.getElementsByClassName(\""+locatorType.substring(14)+"\")[0];";
		}
		String mouseOverScript = elem + " if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false);" +
				" elem.dispatchEvent(evObj);} else if(document.createEventObject) { elem.fireEvent('onmouseover');}";
		js.executeScript(mouseOverScript);
	}
}
/***************************************************
 *Function to highlight element
 ** @param element
 * 
 * @throws Exception 
 *************************************************************/ 


public void highLightElement(WebElement elemToEnter)
{
	JavascriptExecutor js=(JavascriptExecutor)driver; 

	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elemToEnter);


	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", elemToEnter); 

}

/***************************************************
 *Function to  verify attribute contains value
 ** @param pageObject
 * @param attributeName
 * @param attributeValue
 * @throws Exception 
 *************************************************************/ 

public void verifyAttruibuteContainsValue(PageObjects pageObject,String attributeName, String attributeValue) {
	String StrObjName = pageObject.getObjectname();
	WebElement element = getPageElement(pageObject);
	String check = element.getAttribute(attributeName);
	if (check.equalsIgnoreCase(attributeValue)) {
		//report.updateTestLog("check attribute", attributeName + "attribute verified with" + attributeValue , Status.PASS);
	}
	else {}
		//report.updateTestLog("check attribute", attributeName + "attribute is not verified with" + attributeValue  , Status.PASS);

}

/***************************************************
 *Function to  verify element not Displayed
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 
public void verifyElementNotDisplayed(PageObjects pageObject)
{
	String StrObjName = pageObject.getObjectname();
	WebElement element = getPageElement(pageObject);

	try
	{
		if(element.isDisplayed())
		{
			//report.updateTestLog("", StrObjName + " is displayed ", Status.FAIL);
		}
	}catch(NoSuchElementException e)
	{
		//report.updateTestLog("", StrObjName + " is  not  displayed ", Status.PASS);
	}

}	

/***************************************************
 *Function to  verify mainframe validation
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 
/*public void mainframeValidations(String sql, String Columns, String Expected) throws SQLException
{

	Map testData = DatabaseUtil.executeDB2Query(sql);

	String[] valuesarray=Columns.split(";");
	//System.out.println(valuesarray.length);
	String [] expectedArray=Expected.split(";");

	for(int i=0 ; i<(valuesarray.length); i++)
	{

		String data1 = ((String) testData.get(valuesarray[i]));
		//System.out.println("Column name is " + valuesarray[i]);
		//System.out.println("Expected Value is " + expectedArray[i]);
		//System.out.println("Actual Value is " + data1);
		verifyText(expectedArray[i], data1, valuesarray[i]);
	}

}*/

/***************************************************
 *Function to  verify oracle mainframe validation
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 
/*public void oraclemainframeValidations(String sql, String Columns, String Expected) throws SQLException
{

	Map testData = DatabaseUtil.executeOracleQuery(sql, Databases.SECURITY);
	//System.out.println(testData);
	String[] valuesarray=Columns.split(";");
	//System.out.println(valuesarray.length);
	String [] expectedArray=Expected.split(";");
	//String data = ((String) testData.get("ACCOUNT_NUMBER"));
	//System.out.println(data);

	for(int i=0 ; i<(valuesarray.length); i++)
	{

		String data1 = ((String) testData.get(valuesarray[i]));
		//System.out.println("Column name is " + valuesarray[i]);
		//System.out.println("Expected Value is " + expectedArray[i]);
		//System.out.println("Actual Value is " + data1);
		verifyText(expectedArray[i], data1, valuesarray[i]);
	}

}*/

/***************************************************
 *Function to  verify oracle mainframe validation
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 
/*public  List<Map<String, Object>> oraclemainframeValidation(String sql, String Columns, String Expected) throws SQLException
{

	//	Map testData = DatabaseUtil.executeOracleQuery(sql, Databases.SECURITY);
	List<Map<String, Object>> SecurityData=      DatabaseUtil.getOracleRecordAsMap(Databases.SECURITY, sql);
	//System.out.println(testData);


	if(SecurityData.size()>0)
	{
		String[] valuesarray=Columns.split(";");


		//System.out.println(valuesarray.length);
		String [] expectedArray=Expected.split(";");
		String data = SecurityData.get(0).get("ACCOUNT_NUMBER").toString();
		//System.out.println(data);
		for(int i=0 ; i<(valuesarray.length); i++)
		{

			String data1 = SecurityData.get(0).get(valuesarray[i].toString()).toString();
			//System.out.println("Column name is " + valuesarray[i]);
			//System.out.println("Expected Value is " + expectedArray[i]);
			//System.out.println("Actual Value is " + data1);
			verifyText(expectedArray[i], data1, valuesarray[i]);
		}
	}else
	{
		//report.updateTestLog("", "No relevant data found from query "+ sql, Status.DONE);
	}


	return SecurityData;
}*/
/***************************************************
 *Function to  verify Element Place Holder
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 
public void verifyElementPlaceholder(PageObjects pageObject, String textToVerify) throws IOException
{
	WebElement element = getPageElement(pageObject); 
	String StrObjName = pageObject.getObjectname();
	String placeholder=getAttributeValue(element, "placeholder");
	if(placeholder.equalsIgnoreCase(textToVerify))
	{
		//report.updateTestLog("Verify Placeholder", StrObjName+ " :Placeholder verification succes.", Status.PASS);
	}
	else {
		//report.updateTestLog("Verify Placeholder", StrObjName+ " :Placeholder verification failure.", Status.FAIL);	
	}

}
/***************************************************
 *Function to  verify Text
 ** @param Expected
 *@param Actual
 *@param ObjectName

 * @throws Exception 
 *************************************************************/ 
public void verifyTextEqual(String Expected , String Actual,String ObjectName)
{
	if(Expected.trim().equalsIgnoreCase(Actual.trim()))
	{
		//report.updateTestLog("", ObjectName +" matches with actual " +Expected, Status.PASS);
	}else
	{
		//report.updateTestLog("", ObjectName +" mismatch. Expected "+ Expected  +" Actual "+Actual, Status.FAIL);
	}
}

/***************************************************
 *Function to  verify Element Color
 ** @param pageObject
 *@param property
 *@param CSSValue

 * @throws Exception 
 *************************************************************/ 

public void verifyElementColor(PageObjects pageObject, String property, String CSSValue)
{
	WebElement element = getPageElement(pageObject); 
	String StrObjName = pageObject.getObjectname();
	String csselemnt=element.getCssValue(property);

	if(csselemnt.equalsIgnoreCase(CSSValue))
	{
		//report.updateTestLog("", "CSS value is verified . Value is "+ CSSValue, Status.PASS);
	}else
	{
		//report.updateTestLog("", "CSS value mismatch. Expected  "+ CSSValue+" Actual "+csselemnt, Status.FAIL);
	}

}

/***************************************************
 *Function to verify  element not Displayed
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 
/*
public boolean  isNotDisplayed(PageObjects pageObject)
{

	WebElement element = getPageElement(pageObject);
	String StrObjName = pageObject.getObjectname();
	Boolean value = null;
	String str = element.getSize().toString();
	int i = Integer.valueOf(str);
	if (i>0)
	{
		//report.updateTestLog("Element Display", StrObjName+" Object Display", Status.FAIL);
	}
	else
	{
		//report.updateTestLog("Element not Display", StrObjName+" not Object Display", Status.PASS);
	}
	return value;


}*/

/***************************************************
 *Function to verify Wait 
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 
public void waitforBusy(WebDriver Driver){
	try{
		WebDriverWait wait = new WebDriverWait(Driver, 59);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				waitforElePresence(By.xpath("(//img[@alt='Please Wait...'])[2]"), Driver);
				WebElement busy = Driver.findElement(By.xpath("(//img[@alt='Please Wait...'])[2]"));
				return !busy.isDisplayed();
			}
		});
	}catch(Exception e){
		//System.out.println(e);
	}
}
/***************************************************
 *Function to verify Element Presence
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 
public void waitforElePresence(By by, WebDriver Driver){
	try{
		final By byy=by;
		WebDriverWait wait = new WebDriverWait(Driver, 59);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				WebElement ele = null;
				try{
					ele = driver.findElement(byy);
				}catch(Exception e){}
				return ele!=null;
			}
		});
	}catch(Exception e){
		//System.out.println(e);
	}
}

/***************************************************
 *Function to match with Regex
 ** @param pageObject

 * @throws Exception 
 *************************************************************/ 

public void mathwithRegx(String textToVerify , String regx)
{
	Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
	Matcher matcher = pattern.matcher(textToVerify);
	boolean isMatched = matcher.matches();
	//System.out.println(isMatched);

	if(isMatched==true)
	{
		//report.updateTestLog("", "Text is verified . Text is  "+ textToVerify, Status.PASS);
	}else
	{
		//report.updateTestLog("", "Text is not  verifed with regx . Text is "+ textToVerify, Status.FAIL);
	}

}


/*RegX for Username and Account number
 * 
 */
/***************************************************
 *Function to verify RegX for Username and Account number
 ** @param conten
 *@param pattern
 *@param  logString

 * @throws Exception 
 *************************************************************/ 
public void regxmathcher(String conten, String pattern, String logString)
{
	String content = conten;
	String patternString = pattern;
	Pattern patter = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
	Matcher matcher = patter.matcher(content);
	boolean isMatched = matcher.matches();
	if(isMatched==true)
	{
		//report.updateTestLog("", logString+" is matched with regular expresssion", Status.PASS);
	}else
	{
		//report.updateTestLog("",logString+" is not matched with regular expression", Status.FAIL);	
	}

}
/***************************************************
 *Function to sendkeys to tab
 *@param pageObject

 * @throws Exception 
 *************************************************************/ 

public void  tabOut(PageObjects pageObject)
{
	WebElement element = getPageElement(pageObject); 
	String StrObjName = pageObject.getObjectname();



	element.sendKeys(Keys.TAB);

}	

/***************************************************
 *Function to verify drop down option and select a particular value
 *@param pageObject

 * @throws Exception 
 *************************************************************/ 

public void verifyDropdown( List<WebElement> droOpetion , String drpvalues,String valueToSelect)
{
	//clickOnElementjavaScript(drpName,"Rule Dropdown");
	//WebElement dd = drpName;
	waitForPageToBeReady();
	List<WebElement> opetion = droOpetion;
	//System.out.println("Dropdown options are ");
	String [] expval=drpvalues.split(";");
	String valtoSelect=valueToSelect;
	for(int i =0 ; i<opetion.size();i++)
	{
		String val=opetion.get(i).getText();
		//System.out.println("Dropdown options are: " +val);
		//report.updateTestLog("","Dropdown options are: " +val , Status.valueOf(val));
		if(val.equalsIgnoreCase(expval[i]))
		{
			//report.updateTestLog("verify rule dropdown", "Dropdown options are displayed as"+ expval[i], Status.SCREENSHOT);
		}

	}

	for(int i=0 ; i<opetion.size();i++)
	{
		String val=opetion.get(i).getText();
		System.out.println("Dropdown options are" +val);
		if(val.equalsIgnoreCase(valtoSelect))
		{
			clickOnElementjavaScript(opetion.get(i), "Option to be selected");
			//report.updateTestLog("click option", "Dropdown option is selected ", Status.SCREENSHOT);
		}

	}


}

/***************************************************
 *Function to Scroll Down Page In Mobile
 *@param String amountToBeScrolledDown

 * @throws Exception 
 *************************************************************/ 


public void scrollPageDownMobile(String amountToBeScrolledDown)
{
	JavascriptExecutor View =(JavascriptExecutor)driver;
	View.executeScript("window.scrollBy(0,"+amountToBeScrolledDown+")");
}

/***************************************************
 *Function to Scroll Page  UP In Mobile
 *@param String amountToBeScrolledDown

 * @throws Exception 
 *************************************************************/ 


public void scrollPageUpMobile(String amountToBeScrolledDown)
{
	JavascriptExecutor View =(JavascriptExecutor)driver;
	View.executeScript("window.scrollBy(0,"+"-"+amountToBeScrolledDown+")");
}

/***************************************************
 *Function to Scroll Till Element is displayed in  Mobile
 *@param String element

 * @throws Exception 
 *************************************************************/ 

public void scrollTillElementIsDisplayed( String element)
{
	//List<WebElement> element1= driver.findElements(By.xpath(element));
	while(driver.findElements(By.xpath(element)).size()==0)
	{
		JavascriptExecutor View =(JavascriptExecutor)driver;
		View.executeScript("window.scrollBy(0,250)");
	}
}

/***************************************************
 *Function to Close PopUp  window

 *@param String amountToBeScrolledDown

 * @throws Exception 
 *************************************************************/ 

public void loginPopupsHandle()
{
	List<WebElement> popup=driver.findElements(By.xpath("//div[@class='modal-content']"));
	List<WebElement> closeBtn=driver.findElements(By.xpath("(//a[contains(text(),'Close')])"));
	for(int i=0 ; i< popup.size(); i++)
	{
		try
		{      
			clickOnElementjavaScript(closeBtn.get(i),"Close button for popup");	
			//driver.navigate().refresh();
			waitForPageToBeReady();
		}catch(Exception e)
		{
			if(!e.getMessage().isEmpty())

			{
				break;

			}
		}
	}
}

/***************************************************
 *Function to Check if String is Ten digit

 *@param String acc

 * @throws Exception 
 *************************************************************/ 

public String checkifStringIsTenDigit(String acc)
{
	DecimalFormat df = new DecimalFormat("0000000000");
	String b= df.format(Integer.valueOf(acc));
	//System.out.println(b);
	return b;
}

/***************************************************
 *Function to get random value


 *************************************************************/ 

public  int getRandom(int max){ 

	return (int) (Math.random()*max);
}
/***************************************************
 *Function to open New Tab

 * @throws Exception 
 *************************************************************/ 

public void openblanknewTab() throws AWTException
{

	((JavascriptExecutor)driver).executeScript("window.open();");
}

/***************************************************
 *Function to switch to blank window

 *@param String index

 * @throws Exception 
 *************************************************************/ 
public void switchToBlankWindow(String index)
{
	Integer a = Integer.parseInt(index);
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(a));
	//report.updateTestLog("", "New window is opened ", Status.SCREENSHOT);
}
/***************************************************
 *Function to get SSN in regular Format

 *@param String originalString

 * @throws Exception 
 *************************************************************/ 

public String getSSNinReqFormat(String originalString)
{
	return originalString.substring(originalString.length()-4);
}

/***************************************************
 *Function to scroll to element

 *@param String pixel

 * @throws Exception 
 *************************************************************/ 
public void scrollToElementjavaScript(String pixel)
{

	try{
		JavascriptExecutor View =(JavascriptExecutor)driver;
		View.executeScript("window.scrollBy(0,"+pixel+")");

		
		

	}catch(Exception e){
		

	}


}


}
