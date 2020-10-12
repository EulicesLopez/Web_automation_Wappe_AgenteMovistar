package com.tsoft.bot.frontend.steps.Movistar;

import com.tsoft.bot.frontend.pageobject.Reportes.DescargarReportePageObject;
import cucumber.api.java.en.Then;

public class ReportesSteps extends DescargarReportePageObject {
    /*------------------------------------------------------------------------------------------------------*/
    @Then("^Usuario da clic menu reportes y elige reporte cobranzas solicitud de FM$")
    public void usuarioDaClicMenuReportesYEligeReporteCobranzasSolicitudDeFM() throws Throwable {
        seleccionarReporteCobranzasSolicitudFM();
    }
    /*------------------------------------------------------------------------------------------------------*/
    @Then("^Usuario da clic menu reportes y elige reporte cobranzas detalle de FM$")
    public void usuarioDaClicMenuReportesYEligeReporteCobranzasDetalleDeFM() throws Throwable {
        seleccionarReporteCobranzasDetalleFM();
    }

    @Then("^Usuario da clic menu reportes y elige reporte cobranzas solicitud de FF$")
    public void usuarioDaClicMenuReportesYEligeReporteCobranzasSolicitudDeFF() throws Throwable {
        seleccionarReporteCobranzasSolicitudFF();
    }

    @Then("^Usuario da clic menu reportes y elige reporte cobranzas detalle de FF$")
    public void usuarioDaClicMenuReportesYEligeReporteCobranzasDetalleDeFF() throws Throwable {
        seleccionarReporteCobranzasDetalleFF();

    }
    /*------------------------------------------------------------------------------------------------------*/




}
