package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightsAppPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;


public class UITest {

    FlightsAppPages flightsAppPages = new FlightsAppPages();


    @Test
    public void tc1_twoPlacesBeingTheSame(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(2);

        flightsAppPages.from.click();
        flightsAppPages.dropdownfrom.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.fromistanbul.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.to.click();
        flightsAppPages.dropdownto.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.toIstanbul.click();
        ReusableMethods.waitFor(2);
        String expectedData = "Istanbul";
        String actualData = "Istanbul";
        Assert.assertNotEquals(actualData,expectedData,"The same cities should not be chosen but they are"); //bug

        Driver.closeDriver();
    }

    @Test
    public void tc2_noFlightBetweenTwoPlaces(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(2);

        flightsAppPages.from.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.dropdownfrom.click();
        flightsAppPages.fromistanbul.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.to.click();
        flightsAppPages.dropdownto.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.toParis.click();
        ReusableMethods.waitFor(2);
        Driver.closeDriver();

    }

    @Test
    public void tc3_testThatThereAreTwoFlightsBetweenIstanbulAndLosAngeles(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(2);

        flightsAppPages.from.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.dropdownfrom.click();
        flightsAppPages.fromistanbul.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.to.click();
        flightsAppPages.dropdownto.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.toLosangeles.click();
        ReusableMethods.waitFor(2);

        Assert.assertTrue(flightsAppPages.flight1.isDisplayed());
        Assert.assertTrue(flightsAppPages.flight2.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void tc4_compareTheNumberInTheMessageWithTheNumberOfFlights(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(2);

        flightsAppPages.from.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.dropdownfrom.click();
        flightsAppPages.fromNewyork.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.to.click();
        flightsAppPages.dropdownto.click();
        ReusableMethods.waitFor(2);
        flightsAppPages.toLondon.click();
        ReusableMethods.waitFor(2);

        String foundMessage = flightsAppPages.foundMessage.getText();
        int foundMessageCount = Integer.parseInt(foundMessage.replaceAll("\\D+",""));

        List<WebElement> flightListSize = Driver.getDriver().findElements(By.xpath("//li[@class='overflow-hidden rounded-xl border border-gray-200']"));
        int flightCount = flightListSize.size();
        Assert.assertEquals(foundMessageCount,flightCount);

        Driver.closeDriver();



    }

}
