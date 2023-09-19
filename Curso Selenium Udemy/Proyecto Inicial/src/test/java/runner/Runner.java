// 3° se define el archito vde confugración de Cucumber, configura la ejecución utilizando JUnit

package runner;

//Import de JUnit
import org.junit.runner.RunWith;
// Imports de Cucumber con JUnit
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Ejecuta con Cucumber
@RunWith(Cucumber.class)

//Opciones de ejecución
@CucumberOptions(
    features = "src/test/resources/features",   //Localización de los escenarios
    glue = "steps"                              //Localización de la definición de los pasos para las features
)

public class Runner{

}

