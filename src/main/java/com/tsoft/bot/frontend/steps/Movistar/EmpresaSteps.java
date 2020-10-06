package com.tsoft.bot.frontend.steps.Movistar;

import com.tsoft.bot.frontend.pageobject.Empresa.EmpresaPageObject;
import com.tsoft.bot.frontend.pageobject.Empresa.UsuarioRRAAPageObject;
import com.tsoft.bot.frontend.pageobject.Empresa.Usuarios.EditarUsuarioRRAAPageObject;
import com.tsoft.bot.frontend.pageobject.Empresa.Usuarios.EliminarUsuarioRRAAPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class EmpresaSteps extends EmpresaPageObject {

    UsuarioRRAAPageObject usuarioRRAAPageObject = new UsuarioRRAAPageObject();
    EliminarUsuarioRRAAPageObject eliminarUsuarioRRAA = new EliminarUsuarioRRAAPageObject();
    EditarUsuarioRRAAPageObject editarUsuarioRRAA = new EditarUsuarioRRAAPageObject();

    /*------------------------------------------------------------------------------------------------------*/
    @And("^Selecciona una empresa \"([^\"]*)\" y opcion añadir RRAA$")
    public void seleccionaUnaEmpresaYOpcionAñadirRRAA(String casoPrueba) throws Throwable {
        seleccionarUnaEmpresa(casoPrueba);

    }

    /*------------------------------------------------------------------------------------------------------*/
    @And("^Ingresa datos solicitados del nuevo agente \"([^\"]*)\"$")
    public void ingresaDatosSolicitadosDelNuevoAgente(String casoPrueba) throws Throwable {
        usuarioRRAAPageObject.ingresoDatosNuevoRRAA(casoPrueba);
        usuarioRRAAPageObject.seleccionarAsignarRoles(casoPrueba);
        usuarioRRAAPageObject.seleccionarBotonCrear();
        usuarioRRAAPageObject.seleccionarBotonConfirmar();
    }

    /*------------------------------------------------------------------------------------------------------*/
    @Then("^Usuario selecciona RRAA \"([^\"]*)\" y se asigna un rol online \"([^\"]*)\"$")
    public void usuarioSeleccionaRRAAYSeAsignaUnRolOnline(String usuario, String rolOnline) throws Throwable {
        usuarioRRAAPageObject.seleccionarUnUsuario(usuario);
        usuarioRRAAPageObject.certificarUsuario();
        usuarioRRAAPageObject.editarAsignarRolOnline(rolOnline);
    }

    /*------------------------------------------------------------------------------------------------------*/
    @And("^Verifica la Certificacion del nuevo RRAA \"([^\"]*)\"$")
    public void verificaLaCertificacionDelNuevoRRAA(String dniPrueba) throws Throwable {
        usuarioRRAAPageObject.ValidarUsuario(dniPrueba);
    }


    /*-------------------------------- Eliminar Usuario  ----------------------------------------------------*/

    @And("^Selecciona una empresa \"([^\"]*)\" y selecciona un usuario \"([^\"]*)\"$")
    public void seleccionaUnaEmpresaYSeleccionaUnUsuario(String rucEmpresa, String dniUsuario) throws Throwable {
        eliminarUsuarioRRAA.seleccionarUnaEmpresa(rucEmpresa);
        eliminarUsuarioRRAA.seleccionarUsuario(dniUsuario);
    }

    /*------------------------------------------------------------------------------------------------------*/
    @Then("^Usuario da clic en el icono Eliminar y se valida el registo eliminado$")
    public void usuarioDaClicEnElIconoEliminarYSeValidaElRegistoEliminado() throws Throwable {
        eliminarUsuarioRRAA.eliminarRRAA();

    }



    /*-------------------------------- Editar Usuario  --------------------------------------------------------*/

    @And("^Selecciona una empresa \"([^\"]*)\" y selecciona el usuario \"([^\"]*)\" a editar$")
    public void seleccionaUnaEmpresaYSeleccionaElUsuarioAEditar(String rucEmpresa, String dniUsuario) throws Throwable {
        editarUsuarioRRAA.seleccionarUnaEmpresa(rucEmpresa);
        editarUsuarioRRAA.buscarSeleccionarUnUsuario(dniUsuario);

    }

    /*------------------------------------------------------------------------------------------------------*/
    @Then("^Usuario ingresa los datos a editar \"([^\"]*)\"$")
    public void usuarioIngresaLosDatosAEditar(String nuevosDatos) throws Throwable {
        editarUsuarioRRAA.ingresarDatos(nuevosDatos);
    }

    /*------------------------------------------------------------------------------------------------------*/
    @Then("^Usuario da clic en boton Actualizar y valida registro editado$")
    public void usuarioDaClicEnBotonActualizarYValidaRegistroEditado() throws Throwable {
        editarUsuarioRRAA.seleccionarBotonActualizaryConfirmar();
    }


    /*------------------------------------------------------------------------------------------------------*/


}
