package com.tsoft.bot.frontend.pageobject.Login;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

import static com.tsoft.bot.frontend.baseClass.web.CommonComponents.cargarBrowser;

public class LoginPageObject extends BaseClass {

    public static WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "Login";
    private static final String COLUMNA_URL = "URL";
    private static final String COLUMNA_DOCUMENTO = "DOCUMENTO";
    private static final String COLUMNA_PASSWORD = "PASSWORD";
// selenium

    public static String INPUT_DOC = "mat-input-0";
    public static String INPUT_PASS = "mat-input-1";
    public static String BTN_ACEPTAR = "//button[@class='boton button-green w-100 button-responsive-login']";


    public  LoginPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }

    public static void ingresoALaUrlDeWappeAgente(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(valores).get(COLUMNA_URL);
            driver.get(url);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se inició correctamente la página del Agente");
            generateWord.sendText("Se inició correctamente la página del Agente");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 4, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public static void ingresoDatosLogin(String casoDePrueba) throws Throwable {

        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String documentoData = getData().get(valores).get(COLUMNA_DOCUMENTO);
            String passwordData = getData().get(valores).get(COLUMNA_PASSWORD);
            sendKeyValue(driver, "id", INPUT_DOC, documentoData);
            sendKeyValue(driver, "id", INPUT_PASS, passwordData);

            click(driver,"xpath",BTN_ACEPTAR);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se llena los datos de login");
            generateWord.sendText("Se llena los datos de login");
            generateWord.addImageToWord(driver);
            sleep2(7);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 4, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }


    public static void cargarWeb() throws Throwable {
        try {
            cargarBrowser(driver, "https://wappe.movistar.com.pe/#/agente");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó a la pagina web Agente Wappe");
            generateWord.sendText("Se ingresó a la pagina web Agente Wappe");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


}
