package com.browserstack.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class SampleTest {

    @Test
    public void testGoogleOnBrowserStack() throws Exception {
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
       String buildName = System.getenv("JENKINS_LABEL");
if (buildName == null || buildName.isEmpty()) {
    buildName = "Jenkins - Seminar Demo Build " + System.currentTimeMillis();
}


        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "100.0");

        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("sessionName", "Google Test via Jenkins");
        browserstackOptions.put("buildName", buildName);
        browserstackOptions.put("seleniumVersion", "4.0.0");
browserstackOptions.put("local", "true"); // 👈 required for local testing


        capabilities.setCapability("bstack:options", browserstackOptions);

        WebDriver driver = new RemoteWebDriver(
            new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"),
            capabilities
        );

        driver.get("https://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
