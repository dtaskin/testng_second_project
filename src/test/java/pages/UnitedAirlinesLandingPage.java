package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedAirlinesLandingPage {
    public UnitedAirlinesLandingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //WebElements

    @FindBy(css = "a[class='app-components-GlobalHeader-globalHeader__expandedTabHeader--1Ra2H")
    public List<WebElement> mainMenuNavigationItems;

    @FindBy(css = "ul[class='app-components-BookTravel-bookTravel__travelNav--3RNBj'] li")
    public List<WebElement> bookTravelMenuItems;

    @FindBy(css = "fieldset[name='flightType'] div>label")
    public List<WebElement> flightTypeRadioButtons;

    @FindBy(xpath = "//*[@for='award']")
    public WebElement bookWithMilesCheckBox;

    @FindBy(id = "flexDatesLabel")
    public WebElement flexibleDatesCheckBox;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement ticketSearchFrom;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement ticketSearchTo;

    @FindBy(id = "DepartDate")
    public WebElement departDates;

    @FindBy(id = "passengerSelector")
    public WebElement passengerSelector;

    @FindBy(id = "cabinType")
    public WebElement cabinType;

    @FindBy(xpath = "//*[@id=\"cabinType\"]/div")
    public WebElement businessOrFirst;

    @FindBy(xpath = "///*[text()='Find flights']")
    public WebElement findFlightsButton;

    @FindBy(css = "div[class='app-components-Shopping-TripInfo-styles__tripOriginDestinationHeader--RcPyp']")
    public WebElement departValidationText;

}
