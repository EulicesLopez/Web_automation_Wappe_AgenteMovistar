package com.tsoft.bot.frontend.pageobject.Login;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class HomePrincipalPageObject extends BaseClass {

    public static WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "RRAA";
    private static final String COLUMNA_NUM_DOCUMENTO = "NumDocumento";
    private static final String COLUMNA_EMPRESA = "Empresa";
    private static final String COLUMNA_ROLES = "Roles";


// selenium

    public static String INPUT_BUSCAR_EMPRESA = "//input[@placeholder='Buscar por Nro. de Doc / Razón Social']";
    public static String SELECT_EMPRESA = "//span[contains(text(),'EMPRESAS CAJAS SAC')]";
    public static String BTN_AÑADIR_RRAA = "//button[contains(text(),'Añadir RR.AA')]";
    public static String INPUT_DNI = "//*[@id='mat-input-16']";
    public static String BTN_VALIDAR_DOCUMENTO = "//button[@class='boton boton__acentuado--validar']";
    public static String BTN_SIGUIENTE = "div.section-toggle-body.ng-trigger.ng-trigger-toggle > div > div > div > button";

    //roles
    public static String CHECK_REPRESENTANTE_LEGAL = "#\\30  > label > span";
    public static String CHECK_ADMINISTRATIVO = "#\\31  > label > span";
    public static String CHECK_GENERAL = "#\\32  > label > span";
    public static String CHECK_POST_VENTA = "#\\33  > label > span";
    public static String CHECK_COBRANZA = "#\\34  > label > span";
    public static String CHECK_FACTURACION = "#\\35  > label > span";
    public static String CHECK_TECNICO = "#\\36  > label > span";
    public static String CHECK_EMPLEADO = "#\\37  > label > span";


    public static String BTN_CREAR = "//button[@class='boton boton__primario'][contains(text(),'Crear')]";
    public static String BTN_CONFIRMAR = "//button[contains(text(),'Confirmar')]";


    public HomePrincipalPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData1() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }


    public static void seleccionarUnaEmpresa(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String empresaData = getData1().get(valores).get(COLUMNA_EMPRESA);
//            sendKeyValue(driver, "xpaht", INPUT_BUSCAR_EMPRESA, empresaData);

            click(driver, "xpath", SELECT_EMPRESA);
            sleep(2000);
            click(driver, "xpath", BTN_AÑADIR_RRAA);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono la empresa y la opcion crear RRAA");
            generateWord.sendText("Se selecciono la empresa y la opcion crear RRAA");
            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 4, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public static void crearNuevoRRAA(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String numdocumentoData = getData1().get(valores).get(COLUMNA_NUM_DOCUMENTO);

            sendKeyValue(driver, "xpath", INPUT_DNI, numdocumentoData);
            click(driver, "xpath", BTN_VALIDAR_DOCUMENTO);

            click(driver, "css", BTN_SIGUIENTE);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa datos Y se valida del nuevo RRAA");
            generateWord.sendText("Se ingresa datos Y se valida del nuevo RRAA");
            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 4, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }




    public static void seleccionarAsignarRoles(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String rolesData = getData1().get(valores).get(COLUMNA_ROLES);

            switch (rolesData) {
                case "RepresentanteLegal":
                    click(driver,"css",CHECK_REPRESENTANTE_LEGAL);
                    break;
                case "Administrativo":
                    click(driver,"css",CHECK_ADMINISTRATIVO);
                    break;
                case "General":
                    click(driver,"css",CHECK_GENERAL);
                    break;
                case "PostVenta":
                    click(driver,"css",CHECK_POST_VENTA);
                    break;
                case "Cobranza":
                    click(driver,"css",CHECK_COBRANZA);
                    break;
                case "Facturacion":
                    click(driver,"css",CHECK_FACTURACION);
                    break;
                case "Tecnico":
                    click(driver,"css",CHECK_TECNICO);
                    break;
                case "Empleado":
                    click(driver,"css",CHECK_EMPLEADO);
                    break;
                default:
                    System.out.println("caso no valido");
                    break;

            }

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono los roles del RRAA");
            generateWord.sendText("Se selecciono los roles del RRAA");
            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 4, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public static void seleccionarBotonCrear() throws Throwable {

        try {

            click(driver, "xpath",BTN_CREAR);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono El boton Crear");
            generateWord.sendText("Se selecciono El boton Crear");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 4, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }


    public static void seleccionarBotonConfirmar() throws Throwable {

        try {

            click(driver, "xpath",BTN_CONFIRMAR);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono el boton modal Confirmar");
            generateWord.sendText("Se selecciono el boton modal Confirma");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 4, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

}
