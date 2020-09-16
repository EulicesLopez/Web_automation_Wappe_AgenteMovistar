package com.tsoft.bot.frontend.steps.Movistar;

import com.tsoft.bot.frontend.pageobject.Empresa.EmpresaPageObject;
import com.tsoft.bot.frontend.pageobject.Empresa.UsuarioRRAAPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class EmpresaSteps extends EmpresaPageObject {

   UsuarioRRAAPageObject usuarioRRAAPageObject = new UsuarioRRAAPageObject();


    /*------------------------------------------------------------------------------------------------------*/
    @And("^Selecciona una empresa \"([^\"]*)\" y opcion añadir RRAA$")
    public void seleccionaUnaEmpresaYOpcionAñadirRRAA(String casoPrueba) throws Throwable {
        EmpresaPageObject.seleccionarUnaEmpresa(casoPrueba);
    }

    /*------------------------------------------------------------------------------------------------------*/
    @And("^Ingresa datos solicitados del nuevo agente \"([^\"]*)\"$")
    public void ingresaDatosSolicitadosDelNuevoAgente(String casoPrueba) throws Throwable {
        usuarioRRAAPageObject.ingresoDatosNuevoRRAA(casoPrueba);
        usuarioRRAAPageObject.seleccionarAsignarRoles(casoPrueba);
        usuarioRRAAPageObject.seleccionarBotonCrear();
    }

    /*------------------------------------------------------------------------------------------------------*/
    @Then("^Usuario da clic en boton Confirmar Registro$")
    public void usuarioDaClicEnBotonConfirmarRegistro() throws Throwable {
        usuarioRRAAPageObject.seleccionarBotonConfirmar();


    }

    /*------------------------------------------------------------------------------------------------------*/
    @And("^Verifica la creacion del nuevo RRAA$")
    public void verificaLaCreacionDelNuevoRRAA() throws Throwable {
        usuarioRRAAPageObject.seleccionarUnUsuario("1");

    }


    /*------------------------------------------------------------------------------------------------------*/
}
