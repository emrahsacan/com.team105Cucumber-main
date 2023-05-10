package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    DesiredCapabilities cap= new DesiredCapabilities();  // Bir Capabilites oluşturmak gerekiyordu

    static String hubURL="http://192.168.0.102:4444";  // remote bilgisayarın id'si -->192.168.0.102  root'u -->4444
    public WebDriver setDriver(WebDriver driver, String browser){

        if (browser=="chrome") {

            cap.setBrowserName("chrome");
            cap.setVersion("113.0.5672.93");
            cap.setPlatform(Platform.ANY);

            ChromeOptions optionsChrome = new ChromeOptions();
            optionsChrome.merge(cap);  // merge methodunu kullanarak cap objemizi yukarıdaki bilgileri birleştirerek
                                     // bir options haline getirdik

        }
            if (browser=="edge"){

                cap.setBrowserName("edge");
                cap.setVersion("113.0.1774.35");
                cap.setPlatform(Platform.ANY);

                EdgeOptions optionsEdge = new EdgeOptions();
                optionsEdge.merge(cap);


            }


            try {
                driver = new RemoteWebDriver(new URL(hubURL),cap);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        return  driver;

    }


}
