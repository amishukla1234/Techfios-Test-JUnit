 package test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.ToggleAllCheckBoxPage;
import util.BrowserFactory;


 public class ToggleAllCheckTest {
     WebDriver driver;
	 
	@Test
	  public void UserShouldAbleToGoToUrl() throws InterruptedException {
		
			driver =  BrowserFactory.startBrowser(); 
			//Navigate  to the site
			 driver.get("http://techfios.com/test/101/");
			 
			 // creating object by calling ToggleAllCheckBoxPage class
 ToggleAllCheckBoxPage toggleallchckpage = PageFactory.initElements(driver,ToggleAllCheckBoxPage.class );	
  Boolean outcome = toggleallchckpage.isToggleAllCheckBoxSelected();
  
	if(outcome == false) {
		toggleallchckpage.ToggleAllChecked();
	  assertTrue("CheckBox is not selected", toggleallchckpage.isToggleAllCheckBoxSelected() ); 
	  }
	else {
		  //unselect it
		toggleallchckpage.ToggleAllChecked();
		  //select it
		toggleallchckpage.ToggleAllChecked();
		  Assert.assertTrue("CheckBox is not selected", toggleallchckpage.isToggleAllCheckBoxSelected());

				  
	  }
	
   //Validating if all elements in the list are checked when the toggle all button 
   assertTrue("All itemsin the list are not selected",toggleallchckpage.isToggleAllCheckBoxSelected());
   
  //Test 2: Validate that a single list item could be removed using the remove button
   //when a single checkbox is selected.
   
   //uncheck everything
   toggleallchckpage.ToggleAllChecked();
   //method to check if an element is selected
   assertTrue("Element is not selected", toggleallchckpage.isAnElementSelectedToRemove());
   //remove single element from list
   toggleallchckpage.removeElementFromList();
   
   //Test 3: Validate that all list item could be removed using the remove button
   //and when "Toggle All" functionality is on.
   
   //check all checkboxes, select toggleall to remove the list
   toggleallchckpage.ToggleAllChecked();
   //remove entire list
   toggleallchckpage.removeElementFromList();
   assertTrue("Warning Massage is not displayed",toggleallchckpage.isWarningMassageElementDisplayed() );
   driver.navigate().refresh();
   
   

   
   

   
   
	 
	 }
	
}