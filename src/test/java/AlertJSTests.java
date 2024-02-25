import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertJSTests extends BaseTest {
    @Test
    public void alertTestJS() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'JS Alert')]"));

        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("return arguments[0].click()", alertButton);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = getResult();
        Assert.assertEquals(result, "You clicked: Ok");
    }

    private String getResult() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor.executeScript("return document.getElementById('result').textContent").toString();
    }
}
