package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class ToggleAllCheckBoxPage {

WebDriver driver;
	
	//Create a constructor to invite a driver
    public ToggleAllCheckBoxPage(WebDriver driver) {
    	this.driver = driver;
    	}
//Element Library
    @FindBy(how = How.NAME, using = "allbox") 
    WebElement ToggleAllCheckBox;
   
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    WebElement EntireToggleList;
    
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    List<WebElement>checkboxes;
    
    @FindBy(how = How.NAME, using = "submit") WebElement RemoveButton;
	 
	 @FindBy(how = How.XPATH, using = "//b[contains(text(),'Warning')]")
	 WebElement WarningMessage;
	
   
  //Method to check toggle all check box
    public void ToggleAllChecked() {
    	ToggleAllCheckBox.click();
    }
    //Method to validate that ToggleAll check box is selected
    public boolean isToggleAllCheckBoxSelected() {
		return ToggleAllCheckBox.isSelected();
		
    	}
    //Method to validate that all check boxes are selected
    public boolean checkAllCheckBoxesAreSelected() {
    	int uncheckedCount = 0;
    	
    	for (int i = 0; i <checkboxes.size(); i++) {
    		if(checkboxes.get(i).isSelected() == false) {
    			uncheckedCount++;
    		}
    	}
    	if(uncheckedCount> 0) {
    		return false;
    		} else {
    			return true;
    			}
    	}
    //Method to validate that a single list item could is selected and removed
    public boolean isAnElementSelectedToRemove() {
    	boolean outcomeChecked = false;
    	for(int i = 0; i< checkboxes.size(); i++) {
    		if (i == 3) {
    			checkboxes.get(i).click();
    			outcomeChecked = checkboxes.get(i).isSelected();
    			System.out.println("Is single Element selected : " + outcomeChecked);
    			break;
    		}
    	}
    	return outcomeChecked;
    }
    //Method to remove Element from list
    public void removeElementFromList() {
		RemoveButton.click();
		
	}
	
    
 //Test 3: Validate that all list item could be removed using the remove button
  //  and when "Toggle All" functionality is on.
    
    
    public boolean isWarningMassageElementDisplayed() {
    	return WarningMessage.isDisplayed();
    	
    }
	
}
