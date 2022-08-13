package Modules;

import Base.BrowserOperations;
import Base.InterfacePageValidation;
import com.microsoft.playwright.Page;
import org.testng.Assert;


public class AnmeldenPage implements InterfacePageValidation {

    Page page;
    String PLZerrorTxt = "Bitte geben Sie Ihre PLZ ein";
    String ORTerrorTxt = "Bitte geben Sie Ihren Wohnort an";
    String accepCookieBtn = "id=onetrust-accept-btn-handler";
    String anmeldenLink = "//div[text()='Anmelden']";
    String card_selection_radio_btn = "(//label[@class='pb-radio__label'])[2]";
    String firstPBCardTile = "(//div[contains(@class,'swiper-slide-active')]//img)[1]";
    String WeiterBtn = "(//span[@class='pb-sign-up__button-text'])[1]";
    String AnmeldenPageTitle = "Jetzt bei PAYBACK Österreich anmelden";

    public AnmeldenPage(Page page) {
        this.page = page;
    }

    public void doRegistrations() {
        BrowserOperations.pw_Click(this.page,"(//label[@class='pb-radio__label'])[2]");
        BrowserOperations.pw_Click(this.page,"//div[contains(@class,'swiper-slide-active')]//img[@alt='BP']");
        BrowserOperations.pw_Click(this.page,"(//span[@class='pb-sign-up__button-text'])[1]");
        BrowserOperations.pw_Fill(this.page,"id=email","salman@gmail.com");
        BrowserOperations.pw_Fill(this.page,"id=pin","1234");
        BrowserOperations.pw_Click(this.page,"(//span[@class='pb-sign-up__button-text'])[2]");
    }

    public void verifyFieldValidation() {

        BrowserOperations.pw_SelectByValue(this.page,"select#salutation","1");
        BrowserOperations.pw_Fill(this.page,"id=firstName","Salman");
        BrowserOperations.pw_Fill(this.page,"id=lastName","Shaikh");
        BrowserOperations.pw_Type(this.page,"//input[@name='birthday']","20/01/1991");
        BrowserOperations.pw_Fill(this.page,"id=street","Straße123");
        BrowserOperations.pw_Fill(this.page,"id=floor","C12");
        BrowserOperations.pw_Fill(this.page,"id=zipCode","@32");
        BrowserOperations.pw_Fill(this.page,"id=city","");
        BrowserOperations.pw_Click(this.page,"//body");
        String zipcode_errorText = BrowserOperations.pw_getText(this.page,"text="+this.PLZerrorTxt);
        Assert.assertEquals(zipcode_errorText, this.PLZerrorTxt);
        String city_errorText = BrowserOperations.pw_getText(this.page,"text="+this.ORTerrorTxt);
        Assert.assertEquals(city_errorText, this.ORTerrorTxt);

        System.out.println("Validations done successfully...");
    }

    @Override
    public void verifySuccessful_Navigation() {
        String txt = BrowserOperations.pw_getText(this.page, "//title","yes");
        if(!txt.equalsIgnoreCase(this.AnmeldenPageTitle)){
            System.out.println("First Click did not work");
            this.page.locator("//div[text()='Anmelden']").dispatchEvent("click");
            txt = BrowserOperations.pw_getText(this.page, "//title","yes");
        }
            Assert.assertEquals(txt, this.AnmeldenPageTitle);
            System.out.println("Successfully Navigated to Anmelden Page");

    }
}
