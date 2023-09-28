package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver; //1 única instancia de WebDriver
    private static WebDriverWait wait; //Espera máxima del WebDriver para encontrar lo que busca, si no lo encuentra tira excepción
    private static Actions action;
    
    static{
        //Configuración ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:/Jess/Selenium/chromedriver.exe");
        ArrayList<String> optionsList = new ArrayList<String>();
        ChromeOptions chromeOptions = new ChromeOptions();
        optionsList.add("--start-minimized");
		optionsList.add("--incognito");
		chromeOptions.addArguments(optionsList);
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Constructor, cuando se cree una instancia de la página reutiliza el webDriver para que use sólo una instancia
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //Navega a una URL pasada como parámetro
    public static void navigateTo(String url){
        driver.get(url);
    }

    //Devuelve el WebElement localizado, esperando 10 segundos para encontrarlo, sino, tira Excepción
    private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    //Hace click en el webElement localizado
    public void clickElement(String locator){
        find(locator).click();
    }

    //Hace click en el webElement Aceptar Cookies para poder continuar la ejecución
    public void clickAcceptCookies(String locator){
        WebElement aceptButton = driver.findElement(By.id(locator));
        aceptButton.click();
    }

    //Localizado el campo de texto, limpia lo que hay escrito y escribe lo pasado por parámetro
    public void write(String locator, String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    //Selecciona de una lista pasándole un valor de la propia lista (no tiene por qué ser el texto)
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropDown = new Select(find(locator));

        dropDown.selectByValue(valueToSelect);
    }

    //Selecciona de una lista pasándole un índice de la propia lista
    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropDown = new Select(find(locator));

        dropDown.selectByIndex(valueToSelect);
    }

    //Selecciona de una lista pasándole el texto visible de la propia lista
    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropDown = new Select(find(locator));

        dropDown.selectByVisibleText(valueToSelect);
    }

    //Función para hacer un hoverOver (pasar por encima de un elemento)
    public void hoverOverElement(String locator){
        action.moveToElement(find(locator));
    }

    //Función para hacer un doble click
    public void doubleClick(String locator){
        action.doubleClick(find(locator));
    }

    //Función para hacer click derecho
    public void rightClick(String locator){
        action.contextClick(find(locator)); 
    }
    
    //Obtener un valor de una celda de una tabla
    public String getValueFromTable(String locator, int row, int column){
        String cell = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

        return find(cell).getText();
    }

    //Escribir un valor en una celda de una tabla
    public void setValueOnTable(String locator, int row, int column, String text){
        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        
        find(cellToFill).sendKeys(text);
    }

    //Cambiar la ventana en la que actúa Selenium (para iFrames, como vídeos incrustados)
    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    //Volver a la ventana padre, la principal
    public void switchToParentFrame (){
        driver.switchTo().parentFrame();
    }

    //Denegar una alerta de un pop-up
    public void dimissAlert(){
        driver.switchTo().alert().dismiss();
    }

    //Devuelve el texto de un elemento
    public String textFromElement(String locator){
        return find(locator).toString();
    }

    //Cierra el navegador
    public static void closeBrowser(){
        driver.quit();
    }
    
}
