package com.example.usertestingapplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTestingApplicationTests {

    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private CounterPage counter;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @BeforeEach
    public void beforeEach(){
        driver.get("http://localhost:" + port + "/counter");
        counter = new CounterPage(driver);
    }

    @Test
    public void testIncrement(){
        int value = counter.getDisplayedCount();
        counter.incrementCount();
        assertEquals(value + 1, counter.getDisplayedCount());
    }

    public void testIncrementTenTimes(){
        int value = counter.getDisplayedCount();
        for(int i = 0; i < 10; i++){
            assertEquals(value + i, counter.getDisplayedCount());
            counter.incrementCount();
        }
    }

    @Test
    void contextLoads() {
    }

}
