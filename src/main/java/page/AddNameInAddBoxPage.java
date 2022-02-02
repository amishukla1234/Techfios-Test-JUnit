
package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNameInAddBoxPage {
	WebDriver driver; 
	 public AddNameInAddBoxPage(WebDriver driver) {
	  this.driver = driver;
	 }
	 
	 @FindBy(how = How.NAME, using = "data")
		WebElement addNewData;
		@FindBy(how = How.XPATH, using = "//input[@value='Add']")
		WebElement addButton;

		public void userShouldBeAbleToAddNewNameInAddBox() throws InterruptedException {
			Random rnd = new Random();
			int randomNumber = rnd.nextInt(21);
			addNewData.sendKeys("Appium" + randomNumber);
			addButton.click();
		}
	
	
}
