package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    private final boolean isPopUpVisiable;

    public SamokatOrderTest(String username, String surname, String address, String phonenumber, boolean isPopUpVisiable) {
        this.username = username;
        this.surname = surname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.isPopUpVisiable = isPopUpVisiable;

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
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");
        // создай объект класса главной страницы приложения
        this.objOrderSamokat = new OrderSamokat(driver);
    }

    @Test
    public void orderPositive() {
        objOrderSamokat.clickOrderButtonHeader();
        objOrderSamokat.createOrder(username, surname, address, phonenumber);
        Assert.assertEquals(isPopUpVisiable, objOrderSamokat.isPanelVisible());
    }

    @Test
    public void makeOrderCreateOrderSecondButton() {
        objOrderSamokat.scrollToSecondOrderButton();
        objOrderSamokat.clickSecondOrderButton();
        objOrderSamokat.createOrder(username, surname, address, phonenumber);
        Assert.assertEquals(isPopUpVisiable, objOrderSamokat.isPanelVisible());
    }

    @After
    public void after(){
        driver.quit();
    }
}
