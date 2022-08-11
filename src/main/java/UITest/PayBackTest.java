package UITest;

import Base.BaseLoader;
import Modules.AnmeldenPage;
import Modules.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.*;

public class PayBackTest extends BaseLoader {

    Page page;

    @Parameters({"browserType", "headlessMode"})
    @BeforeTest(alwaysRun = true)
    public void setupPW(@Optional("chrome") String browserType, @Optional("false") Boolean headlessMode) {
        super.doSetUp(browserType, headlessMode);
        this.page = super.page;
    }

    @Test(priority = 1)
    public void AnmeldenFlow() throws InterruptedException {

        new HomePage(page).navigateToHomePage("https://www.payback.at/");
        new HomePage(page).clickOnAnmelden();
        new AnmeldenPage(page).doRegistrations();
        new AnmeldenPage(page).verifyFieldValidation();

    }

    @AfterTest()
    public void tearDown() {
        super.exitBrowser();
    }

}
