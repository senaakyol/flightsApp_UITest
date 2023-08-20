package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.Driver.getDriver;

public class FlightsAppPages {

    public FlightsAppPages() {
        PageFactory.initElements(getDriver(),this);
    }


    @FindBy(xpath = "//input[@id='headlessui-combobox-input-:Rq9lla:']")
    public WebElement from;

    @FindBy(xpath = "//button[@id='headlessui-combobox-button-:R1a9lla:']")
    public WebElement dropdownfrom;

    @FindBy(xpath = "//span[contains(text(),'Istanbul')]")
    public WebElement fromistanbul;

    @FindBy(xpath = "//input[@id='headlessui-combobox-input-:Rqhlla:']")
    public WebElement to;

    @FindBy(xpath = "//button[@id='headlessui-combobox-button-:R1ahlla:']")
    public WebElement dropdownto;

    @FindBy(xpath = "//span[contains(text(),'Istanbul')]")
    public WebElement toIstanbul;

    @FindBy(xpath = "//li[@id='headlessui-combobox-option-:ri:']")
    public WebElement toParis;

    @FindBy(xpath = "//span[contains(text(),'Los Angeles')]")
    public WebElement toLosangeles;

    @FindBy(xpath = "(//li[@class='overflow-hidden rounded-xl border border-gray-200'])[1]")
    public WebElement flight1;

    @FindBy(xpath = "(//li[@class='overflow-hidden rounded-xl border border-gray-200'])[2]")
    public WebElement flight2;

    @FindBy(xpath = "//span[contains(text(),'New York')]")
    public WebElement fromNewyork;

    @FindBy(xpath = "//span[contains(text(),'London')]")
    public WebElement toLondon;

    @FindBy(xpath = "//li[@class='overflow-hidden rounded-xl border border-gray-200']")
    public WebElement flightList;

    @FindBy(xpath = "//p[@class='mb-10']")
    public WebElement foundMessage;
}
