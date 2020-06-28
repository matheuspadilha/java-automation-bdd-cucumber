package br.rs.matheuspadilha.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "br.rs.matheuspadilha.steps",
        tags = {"not @ignore"},
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        snippets = SnippetType.CAMELCASE,
        monochrome = false,
        dryRun = false,
        strict = false
)
public class RunnerTest {
    
    @BeforeClass
    public static void reset() {
        /* Reset aplication */
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com");
        driver.findElement(By.id("email")).sendKeys("userTeste@email.com");
        driver.findElement(By.name("senha")).sendKeys("password");
        driver.findElement(By.xpath("//button[.='Entrar']")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}