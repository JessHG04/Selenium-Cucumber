package pages;

public class GooglePage extends BasePage {
    private String acceptCookiesId = "L2AGLb";
    private String searchTextField = "//*[@id=\"APjFqb\"]";
    private String searchButton = "//input[@value='Buscar con Google']";
    

    public GooglePage(){
        super(driver); //Utiliza la instancia del Diver de la BasePage
    }
    
    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
        clickAcceptCookies(acceptCookiesId);
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);  
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }
}
