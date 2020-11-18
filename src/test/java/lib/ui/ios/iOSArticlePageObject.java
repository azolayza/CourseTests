package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser]";
        OPTIONS_ADD_TO_MY_LIST = "id:Save for later";
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        CLOSE_ARTICLE_BUTTON = "id:Back";
    }
    public iOSArticlePageObject(AppiumDriver driver){
        super(driver);
    }
}
