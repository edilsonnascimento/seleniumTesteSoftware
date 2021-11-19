import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class PortalUTFPR {

    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void end() {
        driver.close();
    }

    @Test
    public void deveVerificarSePortalEstaAtivo() {
        //cenario
        driver.get("http://www.utfpr.edu.br/");
        String tituloEsperado = "UTFPR — Universidade Tecnológica Federal do Paraná UTFPR";
        //acao
        String titulo = driver.getTitle();
        //validacao
        assertEquals(tituloEsperado, titulo);
    }

    @Test
    public void deveFuncionarClickAlunos() {
        //cenario
        driver.get("http://www.utfpr.edu.br/");
        WebElement li = driver.findElement(By.linkText("Alunos"));
        String tituloEsperado = "Tamo Junto — Universidade Tecnológica Federal do Paraná UTFPR";
        //acao
        li.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String titulo = driver.getTitle();
        //validacao
        assertEquals(tituloEsperado, titulo);
    }
}