package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSamokat {
    private final WebDriver driver;
    private final By orderButtonHeader = By.className("Button_Button__ra12g");
    private final By orderButtonMiddle = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath("//input[@class='select-search__input']");
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button");
    private final By deliveryDateField = By.xpath("//div[@class = 'react-datepicker__input-container']/input");
    private final By durationOrderField = By.xpath("//div[@class='Dropdown-root']");
    private final By makeOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[2]");
    private final By yesInDialog = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
        private final By confirmationDialog = By.className("Order_Modal__YZ-d3");

    public OrderSamokat(WebDriver driver){
        this.driver = driver;
    }
    public void clickOrderButtonHeader(){
        driver.findElement(orderButtonHeader).click();
    }
    public void confirmCookies() {
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
    public void scrollToSecondOrderButton(){
        WebElement element = driver.findElement(orderButtonMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickSecondOrderButton(){
        driver.findElement(orderButtonMiddle).click();
    }
    public void setUsername(String username){
        driver.findElement(nameField).sendKeys(username);
    }

    public void setSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void setMetroStation(){
        driver.findElement(metroField).click();
        driver.findElement(By.xpath("//div[@class='select-search__select']/ul/li/button")).click();
    }
    public void setPhone(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void setDeliveryDate() {
        driver.findElement(deliveryDateField).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__week'][2]/div[1]")).click();
    }
    public void setDurationOrder() {
        driver.findElement(durationOrderField).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']/div")).click();
    }
    public void clickOrderScooterButton() {
        driver.findElement(makeOrderButton).click();
    }
    public void clickYesInDialog() {
        driver.findElement(yesInDialog).click();
    }
    public Boolean isPanelVisible() {
        return driver.findElement(confirmationDialog).isDisplayed();
    }
    public void createOrder(String username, String surname, String address, String phone){
        setUsername(username);
        setSurname(surname);
        setAddress(address);
        setMetroStation();
        setPhone(phone);
        clickNextButton();
        setDeliveryDate();
        setDurationOrder();
        clickOrderScooterButton();
        clickYesInDialog();
    }
}
