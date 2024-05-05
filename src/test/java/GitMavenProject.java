import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GitMavenProject {
    public WebDriver driver;

    @BeforeTest
    public void browserLaunch(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }

    @Test
    public void PageTitleTest() {
        String expectedPageTitle = "Welcome: Mercury Tours";
        String actualPageTitle = driver.getTitle();
        if(expectedPageTitle.contains(actualPageTitle)) {
            System.out.println("Page Title is pass");
        }
        else{
            System.out.println("Page Title is fail");
        }
        /* Assert.assertEquals(expectedPageTitle, actualPageTitle);*/

    }

    @Test
    public void signOnTest(){
        WebElement signOnLink = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"));
        signOnLink.click();
        WebElement signOnSection = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"));
        Assert.assertTrue(signOnSection.isDisplayed());
    }
}
