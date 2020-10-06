package com.tsoft.bot.frontend.pageobject.Empresa.Usuarios;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pageobject.Empresa.EmpresaPageObject;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;

public class EditarUsuarioRRAAPageObject extends BaseClass {

    public static WebDriver driver;
    Actions actions;
    static GenerateWord generateWord = new GenerateWord();
    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "EditarRRAA";
    private static final String COLUMNA_RUC_EMPRESA = "RucEmpresa";
    private static final String COLUMNA_NUM_DOCUMENTO = "NumDocumento";
    private static final String COLUMNA_CORREO = "CorreoCorporativo";
    private static final String COLUMNA_CELULAR = "Celular";
    private static final String COLUMNA_ROL_COMERCIAL = "RolComercial";
    private static final String COLUMNA_ROL_ONLINE = "RolOnline";

    // selenium
    public static String INPUT_BUSCAR_PERSONA = "//input[@placeholder='Buscar N° documento o Nombres y Apellidos']";
    public static String MENU_OPCIONES_USUARIO = "//td[@class='options ng-star-inserted']";
    public static String OPCION_EDITAR = "//li[contains(text(),'Editar')]";
    public static String INPUT_CORREO = "//body/app-dialog[1]/div[1]/div[1]/app-individual-rraa-new[1]/div[1]/form[1]/div[1]/section[1]/div[2]/app-detail-contact[1]/div[1]/div[1]/div[4]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input";
    public static String INPUT_TELEFONO = "//body/app-dialog[1]/div[1]/div[1]/app-individual-rraa-new[1]/div[1]/form[1]/div[1]/section[1]/div[2]/app-detail-contact[1]/div[1]/div[1]/div[4]/div[2]/mat-form-field[1]/div[1]/div[1]/div[1]/input";
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
    //roles Onlines

    public static String SELECT_ROL_ONLINE = "#mat-select-8 > div > div.mat-select-arrow-wrapper > div";
    public static String OPCION_DECISOR = "//span[contains(text(),'Decisor')]";
    public static String OPCION_AUTORIZADO = "//span[contains(text(),'Autorizado')]";
    public static String OPCION_INVITADO = "//span[contains(text(),'Invitado')]";

    public static String BTN_ACTUALIZAR = "//button[contains(text(),'Actualizar')]";
    public static String BTN_CONFIRMAR_FINAL = "//button[contains(text(),'Confirmar')]";


    public EditarUsuarioRRAAPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData6() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }

    EmpresaPageObject empresaPageObject = new EmpresaPageObject();

    /*------------------------------------------------------------------------------------------------------*/
    public void seleccionarUnaEmpresa(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String empresaData = getData6().get(valores).get(COLUMNA_RUC_EMPRESA);
            empresaPageObject.buscarSeleccionarUnaEmpresa(empresaData);
//            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono la empresa");
//            generateWord.sendText("Se selecciono la empresa");
//            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    /*------------------------------------------------------------------------------------------------------*/
    public void buscarSeleccionarUnUsuario(String casoDePrueba) throws Throwable {
        int valores = Integer.parseInt(casoDePrueba) - 1;
        String documentoData = getData6().get(valores).get(COLUMNA_NUM_DOCUMENTO);

        try {
            sendKeyValue(driver, "xpath", INPUT_BUSCAR_PERSONA, documentoData);
            sleep2(7);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se Buscó y seleccionó el usuario con DNI: " + documentoData);
            generateWord.sendText("Se Buscó y seleccionó el usuario con DNI: " + documentoData);
            generateWord.addImageToWord(driver);
            clickEditar();
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    /*------------------------------------------------------------------------------------------------------*/
    public void ingresarDatos(String casoDePrueba) throws Throwable {
        int valores = Integer.parseInt(casoDePrueba) - 1;
        String correoData = getData6().get(valores).get(COLUMNA_CORREO);
        String celularData = getData6().get(valores).get(COLUMNA_CELULAR);
        String rolComercialData = getData6().get(valores).get(COLUMNA_ROL_COMERCIAL);
        String rolOnlineData = getData6().get(valores).get(COLUMNA_ROL_ONLINE);
        try {
            if (correoData != " " && celularData != " ") {
                clear(driver, "xpath", INPUT_CORREO);
                sendKeyValue(driver, "xpath", INPUT_CORREO, correoData);
                clear(driver, "xpath", INPUT_TELEFONO);
                sendKeyValue(driver, "xpath", INPUT_TELEFONO, celularData);

                ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingreso los Datos Personales");
                generateWord.sendText("Se ingreso los datos Datos Personales");
                generateWord.addImageToWord(driver);
            } else {

                ExtentReportUtil.INSTANCE.stepPass(driver, "No se editó los Datos Personales");
                generateWord.sendText("No se editó los Datos Personales");
                generateWord.addImageToWord(driver);
            }

            click(driver, "css", BTN_SIGUIENTE);

            if (rolComercialData != " " && rolOnlineData != " ") {
                seleccionarAsignarRolComercial(rolComercialData);
                selecionarTipoRolOnline(rolOnlineData);
                ExtentReportUtil.INSTANCE.stepPass(driver, "Se Selecionó el rol Comercial: " + rolComercialData + " Rol Online: " + rolOnlineData);
                generateWord.sendText("Se Selecionó el rol Comercial: " + rolComercialData + " Rol Online: " + rolOnlineData);
                generateWord.addImageToWord(driver);

            } else {
                ExtentReportUtil.INSTANCE.stepPass(driver, "No se editó la Asignación de Roles");
                generateWord.sendText("No se editó la Asignación de Roles");
                generateWord.addImageToWord(driver);
            }

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void seleccionarBotonActualizaryConfirmar() throws Throwable {

        try {
            click(driver, "xpath", BTN_ACTUALIZAR);
            click(driver, "xpath", BTN_CONFIRMAR_FINAL);

            ExtentReportUtil.INSTANCE.stepPass(driver, "se dio clic en el boton Actualizar ");
            generateWord.sendText("se dio clic en el boton Actualizar");
            generateWord.addImageToWord(driver);

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    /*------------------------------------------------------------------------------------------------------*/
    public void clickEditar() throws InterruptedException {
        actions = new Actions(driver);
        Thread.sleep(500);
        WebElement element = driver.findElements(By.xpath(MENU_OPCIONES_USUARIO)).get(0);
        actions.moveToElement(element).perform();
        element.findElement(By.xpath(OPCION_EDITAR)).click();
    }


    /*------------------------------------------------------------------------------------------------------*/
    public void selecionarTipoRolOnline(String tipoeRolOnlineData) throws Throwable {
        try {
            switch (tipoeRolOnlineData) {
                case "Decisor":
                    click(driver, "css", SELECT_ROL_ONLINE);
                    click(driver, "xpath", OPCION_DECISOR);
                    break;
                case "Autorizado":
                    click(driver, "css", SELECT_ROL_ONLINE);
                    click(driver, "xpath", OPCION_AUTORIZADO);
                    break;
                case "Invitado":
                    click(driver, "css", SELECT_ROL_ONLINE);
                    click(driver, "xpath", OPCION_INVITADO);
                    break;
                case " ":
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Aviso: Tipo de Rol Online ingresado en Excel Vacio");
                    generateWord.sendText("Aviso: Tipo de Rol Online ingresado en Excel Vacio");
                    break;
                default:
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Error: Tipo de Rol Online ingresado en Excel no Valido");
                    generateWord.sendText("Error: Tipo de Rol Online ingresado en Excel no Valido");
                    break;
            }

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    /*------------------------------------------------------------------------------------------------------*/
    public void seleccionarAsignarRolComercial(String rolComercialData) throws Throwable {
        try {
            switch (rolComercialData) {
                case "RepresentanteLegal":
                    click(driver, "css", CHECK_REPRESENTANTE_LEGAL);
                    break;
                case "Administrativo":
                    click(driver, "css", CHECK_ADMINISTRATIVO);
                    break;
                case "General":
                    click(driver, "css", CHECK_GENERAL);
                    break;
                case "PostVenta":
                    click(driver, "css", CHECK_POST_VENTA);
                    break;
                case "Cobranza":
                    click(driver, "css", CHECK_COBRANZA);
                    break;
                case "Facturacion":
                    click(driver, "css", CHECK_FACTURACION);
                    break;
                case "Tecnico":
                    click(driver, "css", CHECK_TECNICO);
                    break;
                case "Empleado":
                    click(driver, "css", CHECK_EMPLEADO);
                    break;
                case " ":
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Aviso: Tipo de Rol Comercial ingresado en Excel Vacio");
                    generateWord.sendText("Aviso: Tipo de Rol Comercial ingresado en Excel Vacio");
                    break;
                default:
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Error: Tipo de Rol Comercial ingresado en Excel no Valido");
                    generateWord.sendText("Error: Tipo de Rol Comercial ingresado en Excel no Valido");
                    break;

            }

//            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono los roles del RRAA");
//            generateWord.sendText("Se selecciono los roles del RRAA");
//            generateWord.addImageToWord(driver);

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }
}
