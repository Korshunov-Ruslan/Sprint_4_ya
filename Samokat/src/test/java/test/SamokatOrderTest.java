package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import samokat.OrderSamokat;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class SamokatOrderTest {
    OrderSamokat objOrderSamokat;
    WebDriver driver;
    private final String username;
    private final String surname;
    private final String address;
    private final String phonenumber;
    private final boolean isOrderMadeTextVisiable;

    public SamokatOrderTest(String username, String surname, String address, String phonenumber,
                            boolean isOrderMadeTextVisiable) {
        this.username = username;
        this.surname = surname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.isOrderMadeTextVisiable = isOrderMadeTextVisiable;

    }
    @Parameterized.Parameters()
    public static Object[][] gerOrderData() {
        return new Object[][]{
                {"Жека", "Смирнов", "Абовян 22", "333333333333", true},
                {"Маша", "Шимякина", "Москва", "89999999999", true}
        };
    }

    @Before
    public void before() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
        // переход на страницу тестового приложения
        String url = "https://qa-scooter.praktikum-services.ru";
        driver.get(url);
        // создай объект класса главной страницы приложения
        this.objOrderSamokat = new OrderSamokat(driver);
    }

    @Test
    public void orderPositive() {
        objOrderSamokat.clickOrderButtonHeader();
        objOrderSamokat.createOrder(username, surname, address, phonenumber);
        Assert.assertEquals(isOrderMadeTextVisiable, objOrderSamokat.isTextContainsOrderMadeText());
    }

    @Test
    public void makeOrderCreateOrderSecondButton() {
        objOrderSamokat.scrollToSecondOrderButton();
        objOrderSamokat.clickSecondOrderButton();
        objOrderSamokat.createOrder(username, surname, address, phonenumber);
        Assert.assertEquals(isOrderMadeTextVisiable, objOrderSamokat.isTextContainsOrderMadeText());
    }

    @After
    public void after(){
        driver.quit();
    }
}