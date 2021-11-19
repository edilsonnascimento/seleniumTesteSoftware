import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Principal {
    public static void main(String[] args) {
        //versão do driver compatível com a versão do chrome, Versão 95.0.4638.69 (Versão oficial) 64 bits
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        WebElement campoTexto = driver.findElement(By.name("q"));
        campoTexto.sendKeys("UTFPR");
        campoTexto.submit();
        driver.close();
    }
}
