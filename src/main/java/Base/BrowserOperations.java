package Base;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class BrowserOperations {

    public static void pw_Click(Page page, String locator) {
        if (page.locator(locator).isEnabled()) {
            page.locator(locator).click();
            System.out.println("Clicked On : "+ locator);
        } else {
            System.out.println("Element is not Enabled for Click Operation");
        }
    }

    public static String pw_getText(Page page, String locator, String... getFirstElement) {
        if(getFirstElement!=null) {
            return page.locator(locator).innerText();
        }else {
            return page.locator(locator).first().innerText();
        }
    }

    public static boolean pw_IsVisible(Page page, String locator) {
        return page.locator(locator).isVisible();
    }

    public static void pw_Fill(Page page, String locator, String text) {
        if (page.locator(locator).isEnabled()) {
            page.locator(locator).fill(text);
        } else {
            System.out.println("Element is not Enabled for Click Operation");
        }
    }

    public static void pw_SelectByValue(Page page, String locator, String value) {
        if (page.locator(locator).isEnabled()) {
            page.locator(locator).selectOption(value);
        } else {
            System.out.println("Element is not Enabled for Click Operation");
        }
    }

    public static void pw_Type(Page page, String locator, String text) {
        if (page.locator(locator).isEnabled()) {
            ElementHandle element = page.querySelector(locator);
            element.type(text);
        } else {
            System.out.println("Element is not Enabled for Click Operation");
        }
    }


}
