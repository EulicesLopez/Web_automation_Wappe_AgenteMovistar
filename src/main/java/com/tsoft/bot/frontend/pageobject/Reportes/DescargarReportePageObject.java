package com.tsoft.bot.frontend.pageobject.Reportes;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pageobject.Login.HomePrincipalPageObject;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;


public class DescargarReportePageObject extends BaseClass {
    public WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "AnadirRRAA";
    private static final String COLUMNA_EMPRESA = "RucEmpresa";

    // selenium

    public static String BTN_DESCARGAR_COBRANZAS = "//app-root/app-reports/app-main/div/div/section/app-billing-cards[1]/div/div[5]/div/img";
    public static String BTN_DESCARGAR_COBRANZAS_DETALLE_FM = "//app-root/app-reports/app-main/div/div/section/app-billing-cards[1]/div/div[6]/div/img";
    public static String BTN_DESCARGAR_COBRANZAS_DETALLE_FF = "//app-root/app-reports/app-main/div/div/section/app-billing-cards[1]/div/div[8]/div/img";
    public static String BTN_DESCARGAR_COBRANZAS_SOLICITUD_FF = "//app-root/app-reports/app-main/div/div/section/app-billing-cards[1]/div/div[7]/div/img";


    public DescargarReportePageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getDat() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }

HomePrincipalPageObject homePrincipal = new HomePrincipalPageObject();

    public  void seleccionarReporteCobranzasSolicitudFM() throws Throwable {
        try {
            homePrincipal.seleccionarMenuReportes();
            click(driver, "xpath", BTN_DESCARGAR_COBRANZAS);
            sleep2(4);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se Descargó Reporte Cobranzas - Solicitud de Fraccionamiento Móvil");
            generateWord.sendText("Se Descargó Reporte Cobranzas - Solicitud de Fraccionamiento Móvil");
            generateWord.addImageToWord(driver);
            abrirDescargasChrome();
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public  void seleccionarReporteCobranzasDetalleFM() throws Throwable {
        try {
            homePrincipal.seleccionarMenuReportes();
            click(driver, "xpath", BTN_DESCARGAR_COBRANZAS_DETALLE_FM);
            sleep2(4);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se Descargó Reporte Cobranzas - Detalle de Fraccionamiento Móvil");
            generateWord.sendText("Se Descargó Reporte Cobranzas - Detalle de Fraccionamiento Móvil");
            generateWord.addImageToWord(driver);
            abrirDescargasChrome();
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }




    public  void seleccionarReporteCobranzasSolicitudFF() throws Throwable {
        try {
            homePrincipal.seleccionarMenuReportes();
            click(driver, "xpath", BTN_DESCARGAR_COBRANZAS_SOLICITUD_FF);
            sleep2(4);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se Descargó Reporte Cobranzas - Solicitud de Fraccionamiento Fija");
            generateWord.sendText("Se Descargó Reporte Cobranzas - Solicitud de Fraccionamiento Fija");
            generateWord.addImageToWord(driver);
            abrirDescargasChrome();
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }



    public  void seleccionarReporteCobranzasDetalleFF() throws Throwable {
        try {
            homePrincipal.seleccionarMenuReportes();
            click(driver, "xpath", BTN_DESCARGAR_COBRANZAS_DETALLE_FF);
            sleep2(4);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se Descargó Reporte Cobranzas - Detalle de Fraccionamiento Fija");
            generateWord.sendText("Se Descargó Reporte Cobranzas - Detalle de Fraccionamiento Fija");
            generateWord.addImageToWord(driver);

            abrirDescargasChrome();
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }



    public  void abrirDescargasChrome() throws Throwable {
        try {

            driver.get("chrome://downloads/");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se Lista las descargas Navegador Chrome");
            generateWord.sendText("Se Lista las descargas Navegador Chrome ");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


}
