import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pearson {
    public static Logger logger = Logger.getLogger(Pearson.class);

    public static void main(String[] args) {
        String path = "../chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        /* initiate the driver */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /* Casting with javaScriptExecutor */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*Launch the pearson application*/
        js.executeScript("window.location='https://www.pearson.com/'");
        js.executeScript("document.getElementById('cookie-notification-policy-accept-continue').click()");
        /*Validate search option is visible on homepage*/
        WebElement search = driver.findElement(By.xpath("//input[@id='search-box-input']"));
        if (search.isDisplayed()) {
            System.out.println("Search element is visible");
        }
        js.executeScript("document.getElementById('search-box-input').value='test'");
        js.executeScript("document.getElementsByClassName('search-box-icon')[0].click()");
        js.executeScript("window.scrollBy(0,3000)");
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length-1],10000)");
        String getSearchResults1 = driver.findElement(By.xpath("//div[@class='st-results-container']/p")).getText();
        /*Validate search results 1 -10 */
        if (getSearchResults1.contains("1 - 10")) {
            System.out.println(getSearchResults1);
        }
        WebElement element = driver.findElement(By.xpath("//a[text()='2']"));
        js.executeScript("arguments[0].click();", element);
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length-1],10000)");
        String getSearchResults2 = driver.findElement(By.xpath("//div[@class='st-results-container']/p")).getText();
        /*Validate search results 11 - 20 */
        if (getSearchResults2.contains("11 - 20")) {
            System.out.println(getSearchResults2);
        }
        /*  Verified 3rd searched element should be redirected to proper article*/
        WebElement element1 = driver.findElement(By.xpath("(//a[@class='productItem__name'])[3]"));
        js.executeScript("arguments[0].click();", element1);
        String getUrl = element1.getAttribute("href");
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length-1],10000)");
        System.out.println(getUrl);
        String url = driver.getCurrentUrl();
        String mainWindow = driver.getWindowHandle();
        // open a new tab
        js.executeScript("window.open()");
        // switch to new tab
        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        // navigate to chrome downloads
        driver.get("chrome://downloads");
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length-1],10000)");
        // close the downloads tab2
        driver.close();
        // switch back to main window
        driver.switchTo().window(mainWindow);
        driver.quit();
    }
}

