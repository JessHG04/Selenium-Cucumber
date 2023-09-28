// 3° se define el archito vde confugración de Cucumber, configura la ejecución utilizando JUnit

package runner;

import org.junit.AfterClass;
//Import de JUnit
import org.junit.runner.RunWith;
// Imports de Cucumber con JUnit
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

//Ejecuta con Cucumber
@RunWith(Cucumber.class)

//Opciones de ejecución
@CucumberOptions(
    features = "src/test/resources/features",   //Localización de los escenarios
    glue = "steps",                             //Localización de la definición de los pasos para las features
    monochrome = true,                          //Limpia la vista del CMD para el resultado
    //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"}, //Para el pugin de reportes con Cucumber
    tags = "@Test"          //Define qué tests se van a ejecutar de los Feature Files
)

public class Runner{
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}