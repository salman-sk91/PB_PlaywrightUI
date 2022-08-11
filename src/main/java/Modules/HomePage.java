package Modules;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateToHomePage(String url) {
        page.navigate(url);
        if (page.locator("id=onetrust-accept-btn-handler").isVisible()) {
            page.locator("id=onetrust-accept-btn-handler").click();
        } else {
            System.out.println("Element is not visible");
        }

    }

    public void clickOnAnmelden() {

        page.locator("text=Anmelden").first().dispatchEvent("click");

    }
}