package com.tsoft.bot.frontend.steps.Movistar;

import com.tsoft.bot.frontend.pageobject.Login.EmpresaPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class EmpresaSteps extends EmpresaPageObject {


    @And("^Selecciona una empresa \"([^\"]*)\" y opcion añadir RRAA$")
    public void seleccionaUnaEmpresaYOpcionAñadirRRAA(String casoPrueba) throws Throwable {
        EmpresaPageObject.seleccionarUnaEmpresa(casoPrueba);
    }


    @And("^Ingresa datos solicitados del nuevo agente \"([^\"]*)\"$")
    public void ingresaDatosSolicitadosDelNuevoAgente(String casoPrueba) throws Throwable {
        EmpresaPageObject.ingresoDatosNuevoRRAA(casoPrueba);
        EmpresaPageObject.seleccionarAsignarRoles(casoPrueba);
        EmpresaPageObject.seleccionarBotonCrear();
    }

    @Then("^Usuario da clic en boton Confirmar Registro$")
    public void usuarioDaClicEnBotonConfirmarRegistro() throws Throwable {
        EmpresaPageObject.seleccionarBotonConfirmar();
    }

    @And("^Verifica la creacion del nuevo RRAA$")
    public void verificaLaCreacionDelNuevoRRAA() {
    }

}
