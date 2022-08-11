package Base;

import com.microsoft.playwright.*;

import java.util.List;

public class BaseLoader {

    Playwright playWriteManager;
    public Browser browser;
    public BrowserContext context;
    public Page page;

    public void doSetUp(String browserType, boolean headlessMode) {

        // For Chrome Browser pass the following parameter: LaunchOptions().setChannel("chrome").setHeadless(headlessMode)

        if (browserType.equalsIgnoreCase("Chrome")) {
            var launchOptions = new BrowserType.LaunchOptions().setHeadless(headlessMode).setArgs(List.of("--start-maximized"));
            var contextOptions = new Browser.NewContextOptions().setViewportSize(null);
            playWriteManager = Playwright.create();
            browser = playWriteManager.chromium().launch(launchOptions);
            context = browser.newContext(contextOptions);
            page = context.newPage();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            System.out.println("Executing in Firefox...");
        } else {
            var launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized"));
            var contextOptions = new Browser.NewContextOptions().setViewportSize(null);
            playWriteManager = Playwright.create();
            browser = playWriteManager.chromium().launch(launchOptions);
            context = browser.newContext(contextOptions);
            page = context.newPage();
        }
    }

    public void exitBrowser() {
        page.close();
        browser.close();
        playWriteManager.close();
    }

}
