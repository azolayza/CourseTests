package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{
    private static final String
    MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find navigation button 'My Lists''",
                5
        );
    }
}
