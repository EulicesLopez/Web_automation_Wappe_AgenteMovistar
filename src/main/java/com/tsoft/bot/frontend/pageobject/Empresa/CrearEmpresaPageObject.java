package com.tsoft.bot.frontend.pageobject.Empresa;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

public class CrearEmpresaPageObject extends BaseClass {

    public WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "CrearEmpresa";
    private static final String COLUMNA_RUC_EMPRESA = "NumRUC";
    private static final String COLUMNA_RAZON_SOCIAL = "RazonSocial";

    // selenium
    public static String INPUT_BUSCAR_EMPRESA = "//input[@placeholder='Buscar por Nro. de Doc / Razón Social']";
    public static String BTN_TODAS_EMPRESAS = "//span[@class='border-right']";
    public static String BTN_CREAR_EMPRESA = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-company[1]/div[1]/div[1]/div[2]/button[1]";
    public static String INPUT_NUM_DOCUMENTO = "//input[@formcontrolname='documentNumber']";
    public static String BTN_VALIDAR = "//button[contains(text(),'Validar')]";
    public static String BTN_MODAL_SI = "//app-modal-enterprise[1]/app-modal-decision[2]/div[1]/div[2]/div[3]/button[1]";
    public static String INPUT_RAZON_SOCIAL = "//input[@formcontrolname='businessName']";

    public static String SELECT_SECTOR = "//app-modal-enterprise[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[2]/div[1]";
    public static String SELECT_SECTOR_CONSULTORIA = "//span[contains(text(),'CONSULTORIA')]";
    public static String SELECT_SUB_SECTOR = "//app-modal-enterprise[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[2]/div[1]";
    public static String SELECT_SUB_SECTOR_INFORMATICA = "//span[contains(text(),'INFORMATICA')]";
    public static String SELECT_AV_CALLE = "//app-modal-enterprise[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[2]/div[1]";
    public static String OPCION_CALLE = "//body/div[4]/div[2]/div[1]/div[1]/div[1]/mat-option[2]/span[1]";
    public static String INPUT_NOMBRE_AVENIDA = "//input[@formcontrolname='nombreAvenida']";
    public static String INPUT_NUMERO_AVENIDA = "//input[@formcontrolname='numeroAvenida']";
    public static String ARROW1 = "/html/body/app-dialog/div/div/app-modal-enterprise/div/div/form/div[2]/div/div[3]/div/div[1]/div/mat-form-field/div/div[1]/div/mat-select";
    public static String ARROW2 = "/html/body/app-dialog/div/div/app-modal-enterprise/div/div/form/div[2]/div/div[3]/div/div[2]/div/mat-form-field/div/div[1]/div/mat-select";


    public CrearEmpresaPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData7() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }


    public static void AUDITORIA() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    public void ingresoDatosCreacionEmpresa(String casoDePrueba) throws Throwable {
        int valores = Integer.parseInt(casoDePrueba) - 1;
        String numDocumentoEmpresaData = getData7().get(valores).get(COLUMNA_RUC_EMPRESA);
        String razonSocialEmpresaData = getData7().get(valores).get(COLUMNA_RAZON_SOCIAL);

        try {

            click(driver, "xpath", BTN_CREAR_EMPRESA);
            sendKeyValue(driver, "xpath", INPUT_NUM_DOCUMENTO, numDocumentoEmpresaData);
            click(driver, "xpath", BTN_VALIDAR);
            click(driver, "xpath", BTN_MODAL_SI);
            sendKeyValue(driver, "xpath", INPUT_NUM_DOCUMENTO, razonSocialEmpresaData);


            click(driver, "xpath", ARROW1);
            AUDITORIA();

            //            click(driver, "xpath", SELECT_SECTOR);
//            click(driver, "xpath", SELECT_SECTOR_CONSULTORIA);
//            click(driver, "xpath", SELECT_SUB_SECTOR);
//            click(driver, "xpath", SELECT_SUB_SECTOR_INFORMATICA);


            click(driver, "xpath", SELECT_AV_CALLE);
            click(driver, "xpath", OPCION_CALLE);
            sendKeyValue(driver, "xpath", INPUT_NOMBRE_AVENIDA, "Javier Prado");
            sendKeyValue(driver, "xpath", INPUT_NUMERO_AVENIDA, "56");

            sleep2(5);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono el usuario con DNI: " + numDocumentoEmpresaData);
            generateWord.sendText("Se selecciono el usuario con DNI: " + numDocumentoEmpresaData);
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

}
