package com.learning.PageObjectsDesign;

import static com.learning.PageObjectsDesign.ObjectLocator.XPATH;

public enum LoginPageObject implements PageObjects{
	

	//For Successful Login & Remember User_Id functionality
	txt_UserName("//input[@id='core_view_form_ValidationTextBox_2']",XPATH,"User Name"),
	txt_Password("//input[@id='core_view_form_ValidationTextBox_3']",XPATH,"Password"),
	btn_LoginButton("//span[@id='core_view_form_Button_1_label']", XPATH,"Login Button"),
	lnk_logout("//*[@class='col-md-12']/div/a[5]",XPATH,"Logout link"),
	btn_editProile("//span[contains(.,'Edit Profile')]", XPATH,"EDit profile link"),
	txt_LoginFailed("//div[@class='-bounding-box registration']/div",XPATH,"Login Failed Text");

	String strProperty = "";
	ObjectLocator locatorType = null;
	String strObjName = "";
	
	private LoginPageObject(String strPropertyValue, ObjectLocator locatorType, String strObjName){
		this.strProperty = strPropertyValue;
		this.locatorType = locatorType;
		this.strObjName = strObjName;
	}
	
	
	public String getProperty(){
		return strProperty;
	}

	public ObjectLocator getLocatorType(){
		return locatorType;
	}
	
	public String getObjectname() {
		// TODO Auto-generated method stub
		return strObjName;
	}


}