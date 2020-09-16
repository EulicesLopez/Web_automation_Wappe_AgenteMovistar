package com.tsoft.bot.frontend.steps.Movistar;

import com.tsoft.bot.frontend.pageobject.Login.LoginPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginSteps extends LoginPageObject {
    /*------------------------------------------------------------------------------------------------------*/
    @Given("^Usuario se encuentra en la Web Wappe Agente \"([^\"]*)\"$")
    public void usuarioSeEncuentraEnLaWebWappeAgente(String casoPrueba) throws Throwable {
        LoginPageObject.ingresoALaUrlDeWappeAgente(casoPrueba);
        //LoginPageObject.cargarWeb();
    }

    /*------------------------------------------------------------------------------------------------------*/
    @When("^Completa datos de login y da click en el boton ingresar \"([^\"]*)\"$")
    public void completaDatosDeLoginYDaClickEnElBotonIngresar(String casoPrueba) throws Throwable {
        LoginPageObject.ingresoDatosLogin(casoPrueba);
    }


}
