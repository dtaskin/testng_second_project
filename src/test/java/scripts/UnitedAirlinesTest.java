package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base{
    /*
    Test Case 1: Validate "Main menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see “Main menu” navigation items
    |BOOK                	          	  |
    |MY TRIPS            	          	  |
    |TRAVEL INFO         	  |
    |MILEAGEPLUS® PROGRAM|
    |DEALS               	          	  |
    |HELP                	          	  |
     */

    @Test(priority = 1, description = "TC1: Validate \"Main menu\" navigation items")
    public void validateMainMenuNavigationItems(){
        driver.get("https://www.united.com/en/us");

        String[] expectedTexts = {"BOOK","MY TRIPS","TRAVEL INFO","MILEAGEPLUS® PROGRAM","DEALS","HELP"};
        for (int i = 0; i < unitedAirlinesLandingPage.mainMenuNavigationItems.size(); i++) {
            Assert.assertTrue(unitedAirlinesLandingPage.mainMenuNavigationItems.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesLandingPage.mainMenuNavigationItems.get(i).getText(),expectedTexts[i]);
        }
    }

    /*
    Test Case 2: Validate "Book travel menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see "Book travel menu" navigation items
    |Book             |
    |Flight Status|
    |Check-in       |
    |My trips        |
     */

    @Test(priority = 1, description = "TC2: Validate \"Book travel menu\" navigation items")
    public void validateBookTravelMenuNavigationItems(){
        driver.get("https://www.united.com/en/us");

        String[] expectedTexts ={"Book","Flight status","Check-in","My trips"};

        for (int i = 0; i < unitedAirlinesLandingPage.bookTravelMenuItems.size(); i++) {
            Assert.assertTrue(unitedAirlinesLandingPage.bookTravelMenuItems.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesLandingPage.bookTravelMenuItems.get(i).getText(),expectedTexts[i]);

        }
    }

    /*
    Test Case 3: Validate "Round-trip" and "One-way" radio buttons
    Given user is on "https://www.united.com/en/us"
    Then validate "Roundtrip" radio button is displayed, is enabled and is selected
    And validate "One-way" radio button is displayed, is enabled but is not selected
    When user clicks on "One-way" radio button
    Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
     */
    @Test(priority = 3, description = "TC3: Validate \"Round-trip\" and \"One-way\" radio buttons")
    public void validateRoundTripAndOneWayRadioButtons() {
        driver.get("https://www.united.com/en/us");

        for (int i = 0; i < unitedAirlinesLandingPage.flightTypeRadioButtons.size(); i++) {
            WebElement oneWay = unitedAirlinesLandingPage.flightTypeRadioButtons.get(1);
            WebElement roundTrip = unitedAirlinesLandingPage.flightTypeRadioButtons.get(0);

            roundTrip.click();
            softAssert.assertTrue(roundTrip.isDisplayed(), "Round trip IS NOT displayed");
            softAssert.assertTrue(roundTrip.isEnabled(), "Round trip IS NOT enabled");
            softAssert.assertFalse(roundTrip.isSelected(), "Round trip IS NOT selected");

            softAssert.assertTrue(oneWay.isDisplayed(), "One way IS NOT displayed");
            softAssert.assertTrue(oneWay.isEnabled(), "One way IS NOT enabled");
            softAssert.assertFalse(oneWay.isSelected(), "One way IS selected");

            oneWay.click();
            softAssert.assertFalse(oneWay.isSelected(), "One way IS NOT selected");
            softAssert.assertFalse(roundTrip.isSelected(), "Round trip IS selected");
        }
    }
    /*
    Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
    Given user is on "https://www.united.com/en/us"
    Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
    And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
    When user clicks both checkboxes
    Then validate both checkboxes are selected
    When user clicks on both selected checkboxes again
    Then validate both checkboxes are deselected
    */

    @Test(priority = 4, description = "TC4: Validate \"Book with miles\" and \"Flexible dates\" checkboxes")
    public void validateCheckBoxes(){
        driver.get("https://www.united.com/en/us");

        Assert.assertTrue(unitedAirlinesLandingPage.bookWithMilesCheckBox.isDisplayed());
        Assert.assertTrue(unitedAirlinesLandingPage.bookWithMilesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesLandingPage.bookWithMilesCheckBox.isSelected());

        Assert.assertTrue(unitedAirlinesLandingPage.flexibleDatesCheckBox.isDisplayed());
        Assert.assertTrue(unitedAirlinesLandingPage.flexibleDatesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesLandingPage.flexibleDatesCheckBox.isSelected());

        unitedAirlinesLandingPage.bookWithMilesCheckBox.click();
        unitedAirlinesLandingPage.flexibleDatesCheckBox.click();

        softAssert.assertTrue(unitedAirlinesLandingPage.bookWithMilesCheckBox.isSelected()); // FAILING
        softAssert.assertTrue(unitedAirlinesLandingPage.flexibleDatesCheckBox.isSelected()); // FAILING

        unitedAirlinesLandingPage.bookWithMilesCheckBox.click();
        unitedAirlinesLandingPage.flexibleDatesCheckBox.click();

        Assert.assertFalse(unitedAirlinesLandingPage.bookWithMilesCheckBox.isSelected());
        Assert.assertFalse(unitedAirlinesLandingPage.flexibleDatesCheckBox.isSelected());
    }
    /*
    Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
    Given user is on "https://www.united.com/en/us"
    When user selects "One-way" ticket radio button
    And user enters "Chicago, IL, US (ORD)" to from input box
    And user enters "Miami, FL, US (MIA)" to to input box
    And user selects "Jan 30" to the dates input box
    And user selects "2 Adults" from travelers selector
    And user selects "Business or First" from cabin dropdown
    And user clicks on "Find Flights" button
    Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
     */

    @Test(priority = 5, description = "TC5: Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public void validateTicketSearchResults(){
        driver.get("https://www.united.com/en/us");

        unitedAirlinesLandingPage.flightTypeRadioButtons.get(1).click();
        unitedAirlinesLandingPage.ticketSearchFrom.clear();
        unitedAirlinesLandingPage.ticketSearchFrom.sendKeys("Chicago, IL, US (ORD)");
        unitedAirlinesLandingPage.ticketSearchTo.clear();
        unitedAirlinesLandingPage.ticketSearchTo.sendKeys("Miami, FL, US (MIA)");
        unitedAirlinesLandingPage.departDates.clear();
        unitedAirlinesLandingPage.departDates.sendKeys("Jan 30");
        unitedAirlinesLandingPage.passengerSelector.sendKeys("2 Adults");
        unitedAirlinesLandingPage.cabinType.click();
        unitedAirlinesLandingPage.businessOrFirst.click();
        unitedAirlinesLandingPage.findFlightsButton.click();
        Assert.assertEquals(unitedAirlinesLandingPage.departValidationText.getText(),"Depart: Chicago, IL, US to Miami, FL, US");



























}
}
