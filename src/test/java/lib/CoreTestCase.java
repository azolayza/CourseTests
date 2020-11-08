package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http:127.0.0.1:4723/wd/hub";
    private static final String
            PLATFORM_IOS = "ios",
            PLATFORM_ANDROID = "android";


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        //driver = this.getDriverByPlatformEnv(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrait();
    }
    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();
    }
    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    protected void backgroundApp(int seconds)
    {
        driver.runAppInBackground(Duration.ofMillis(seconds));
    }
    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "test");
            capabilities.setCapability("platformVersion", "8.1");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/liza/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
        } else if (platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iphone8");
            capabilities.setCapability("platformVersion", "13.4");
            capabilities.setCapability("app", "/Users/liza/Desktop/JavaAppiumAutomation/apks/Wikipedia.app");
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value " + platform);
        }
        return capabilities;
    }
   /* private AppiumDriver getDriverByPlatformEnv(String typeOfDriver) throws Exception
    {
        String platform = System.getenv("PLATFORM");
        if (platform.equals(PLATFORM_ANDROID)) {
            typeOfDriver = AndroidDriver;
        } else if (platform.equals(PLATFORM_IOS)) {
            typeOfDriver = IOSDriver;
        } else {
            throw new Exception("Cannot get run driver for platform from env variable. Platform value " + platform);
        }
        return getDriverByPlatformEnv(typeOfDriver);
    }*/
}