import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class VariosBrowserBrowserstack {

    public static String USERNAME = "edilsonnasciment_YUfC4x";
    public static String ACCESSKEY = "puxRDNgLJfmpupZWypz3";
    public static String URL = "https://" + USERNAME + ":" + ACCESSKEY + "@hub.browserstack.com/wd/hub";

    @Parameter
    public Platform plataforma;

    @Parameter(value = 1)
    public String browser;

    @Parameter(value = 2)
    public String versaoBrowser;

    private WebDriver driver;

    @Parameters(name = "{0},{1},{2}")
    public static Object[][] getData(){
        return new Object[][]{
                {Platform.MAC, "chrome", "62.0"},
                {Platform.WIN8, "chrome", "62.0"},
                {Platform.WINDOWS, "firefox", "57"},
        };
    }
    @Before
    public void init() throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setPlatform(plataforma);
        capability.setBrowserName(browser);
        capability.setVersion(versaoBrowser);
        URL browserStackURL = new URL(URL);
        driver = new RemoteWebDriver(browserStackURL, capability);
    }
    @After
    public void end(){
        driver.quit();
    }
    @Test
    public void deveAcessarPortalUTFPR() {
        //cenario
        String expectedURL = "http://www.utfpr.edu.br/";
        //acao
        driver.get("http://www.utfpr.edu.br/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualURL = driver.getCurrentUrl();
        //validacao
        assertEquals(expectedURL, actualURL);
    }
}
