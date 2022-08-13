package Modules;

import Base.BrowserOperations;
import Base.InterfacePageValidation;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class HomePage implements InterfacePageValidation {

    Page page;
    String accepCookieBtn = "id=onetrust-accept-btn-handler";
    String anmeldenLink = "//div[text()='Anmelden']";
    String homePageTitle = "PAYBACK Österreich: Punkten und belohnen";

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateToHomePage(String url) {
        page.navigate(url);
        if (BrowserOperations.pw_IsVisible(this.page, this.accepCookieBtn)) {
            BrowserOperations.pw_Click(this.page, this.accepCookieBtn);
            System.out.println("Cookie Accepted");
        } else {
            System.out.println("Cookie Already Accepted");
        }
    }

    public void clickOnAnmelden() {
        this.page.waitForTimeout(400);
        BrowserOperations.pw_Click(this.page, this.anmeldenLink);
        System.out.println("Clicked on Anmelden");
    }

    @Override
    public void verifySuccessful_Navigation() {
        String txt = BrowserOperations.pw_getText(this.page, "//title");
        Assert.assertEquals(txt, this.homePageTitle);
        System.out.println("Successfully Navigated to PayBack Home Page");
    }
}