package com.tsoft.bot.frontend.steps.Movistar;

import com.tsoft.bot.frontend.pageobject.Login.HomePrincipalPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class HomePrincipalSteps extends HomePrincipalPageObject {

    @And("^Selecciona una empresa y opcion añadir RR\\.AA$")
    public void seleccionaUnaEmpresaYOpcionAñadirRRAA() throws Throwable {
        HomePrincipalPageObject.seleccionarUnaEmpresa("1");

    }

    @And("^Ingresa datos solicitados del nuevo agente \"([^\"]*)\"$")
    public void ingresaDatosSolicitadosDelNuevoAgente(String casoPrueba) throws Throwable {
        HomePrincipalPageObject.crearNuevoRRAA(casoPrueba);
        HomePrincipalPageObject.seleccionarAsignarRoles(casoPrueba);
        HomePrincipalPageObject.seleccionarBotonCrear();
    }

    @Then("^Usuario da clic en boton Confirmar Registro$")
    public void usuarioDaClicEnBotonConfirmarRegistro() throws Throwable {
        //HomePrincipalPageObject.seleccionarBotonConfirmar();
    }

    @And("^Verifica la creacion del nuevo RRAA$")
    public void verificaLaCreacionDelNuevoRRAA() {
    }
}
