package Modules;

import com.microsoft.playwright.Page;
import org.testng.Assert;


public class AnmeldenPage {

    Page page;

    public AnmeldenPage(Page page) {
        this.page = page;
    }

    public void doRegistrations() {
        page.locator("(//label[@class='pb-radio__label'])[2]").click();
        page.locator("//div[contains(@class,'swiper-slide-active')]//img[@alt='BP']").click();
        page.locator("(//span[@class='pb-sign-up__button-text'])[1]").click();
        page.locator("id=email").type("salman@gmail.com");
        page.locator("id=pin").type("1234");
        page.locator("(//span[@class='pb-sign-up__button-text'])[2]").click();
    }

    public void verifyFieldValidation() throws InterruptedException {

        page.locator("select#salutation").selectOption("1");
        page.locator("id=firstName").type("Salman");
        page.locator("id=lastName").type("Shaikh");
        page.locator("//input[@name='birthday']").type("20/01/1991");
        page.locator("id=street").type("Straße123");
        page.locator("id=floor").type("C12");
        page.locator("id=zipCode").type("@32");
        page.locator("id=city").type("");
        page.locator("//body").click();
        String zipcode_errorText = page.locator(".pb-form-field__error-msg").first().innerText();
        Assert.assertEquals(zipcode_errorText, "Bitte geben Sie Ihre PLZ ein");
        String city_errorText = page.locator(".pb-form-field__error-msg").last().innerText();
        Assert.assertEquals(city_errorText, "Bitte geben Sie Ihren Wohnort an");

        System.out.println("Validations done successfully...");
    }
}
