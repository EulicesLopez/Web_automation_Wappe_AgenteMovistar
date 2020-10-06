package com.tsoft.bot.frontend.pageobject.Empresa;


import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;


public class UsuarioRRAAPageObject extends BaseClass {
    Actions actions;
    public static WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "AnadirRRAA";
    private static final String COLUMNA_TIPO_DOCUMENTO = "TipoDocumento";
    private static final String COLUMNA_NUM_DOCUMENTO = "NumDocumento";
    private static final String COLUMNA_CORREO = "CorreoCorporativo";
    private static final String COLUMNA_TELEFONO = "Celular";
    private static final String COLUMNA_ROLES = "RolComercial";
    private static final String COLUMNA_ROL_ONLINE = "RolOnline";

    // selenium
    public static String BTN_AÑADIR_RRAA = "//button[contains(text(),'Añadir RR.AA')]";
    public static String INPUT_DNI = "//*[@id='mat-input-16']";
    public static String BTN_VALIDAR_DOCUMENTO = "//button[@class='boton boton__acentuado--validar']";
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


    public static String BTN_CREAR = "//button[@class='boton boton__primario'][contains(text(),'Crear')]";
    public static String BTN_CONFIRMAR = "//button[contains(text(),'Confirmar')]";

    //tipo de documento

    public static String SELECT_TIPO_DOCUMENTO = "#mat-select-1 > div > div.mat-select-arrow-wrapper > div";
    public static String TIPO_DOC_PASAPORTE = "//span[contains(text(),'Pasaporte')]";
    public static String TIPO_CE = "//span[contains(text(),'Carné Extranjeria')]";
    public static String TIPO_OTROS = "//span[@class='mat-option-text'][contains(text(),'Otros')]";

    public static String INPUT_BUSCAR_PERSONA = "//input[@placeholder='Buscar N° documento o Nombres y Apellidos']";
    public static String SELECT_PERSONA = "//tr[1]//td[1]//label[1]//span[1]";
    public static String BTN_CERTIFICAR = "//button[contains(text(),'Certificar')]";
    public static String BTN_ADJUNTO_ARCHIVO = "div > div:nth-child(1) > div:nth-child(2) > span > img";
    public static String ARCHIVO_SELECT = "//div[@class='upload py-5']//div[1]//input[1]";
    public static String BTN_CERTIFICAR_USUARIO = "//button[@class='boton boton__primario ng-star-inserted']";
    public static String BTN_MODAL_ACEPTAR = "app-root > app-detail > app-modal-general-accept > div > div.modal-content > div.modal-buttons > button";


    public static String MENU_OPCIONES_USUARIO = "//td[@class='options ng-star-inserted']";
    public static String OPCION_EDITAR = "//li[contains(text(),'Editar')]";
    public static String BTN_ACTUALIZAR = "//button[contains(text(),'Actualizar')]";
    public static String BTN_CONFIRMAR_FINAL = "//button[contains(text(),'Confirmar')]";

    public static String BTN_MENSAJE_AUTORIZADO = "//span[contains(text(),'Autorizado')]";


    //archivo
    private final String BASE_PAHT = System.getProperty("user.dir") + "/src/main/resources/images/";
    private final String ARCHIVO_IMAGEN = BASE_PAHT + "manzana.PNG";


    public UsuarioRRAAPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData3() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }

    /*------------------------------------------------------------------------------------------------------*/
    public void ingresoDatosNuevoRRAA(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String numdocumentoData = getData3().get(valores).get(COLUMNA_NUM_DOCUMENTO);
            String correoData = getData3().get(valores).get(COLUMNA_CORREO);
            String telefonoData = getData3().get(valores).get(COLUMNA_TELEFONO);
            click(driver, "xpath", BTN_AÑADIR_RRAA);
            selecionarTipoDocumento(casoDePrueba);
            sendKeyValue(driver, "xpath", INPUT_DNI, numdocumentoData);
            click(driver, "xpath", BTN_VALIDAR_DOCUMENTO);
            sleep2(3);
            clear(driver,"xpath",INPUT_CORREO);
            sendKeyValue(driver, "xpath", INPUT_CORREO, correoData);
            clear(driver,"xpath",INPUT_TELEFONO);
            sendKeyValue(driver, "xpath", INPUT_TELEFONO, telefonoData);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa documento: " + numdocumentoData + " Y se valida con la RENIEC");
            generateWord.sendText("Se ingresa documento: " + numdocumentoData + " Y se valida con la RENIEC");
            generateWord.addImageToWord(driver);
            click(driver, "css", BTN_SIGUIENTE);
            sleep2(5);

        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 10, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void selecionarTipoDocumento(String casoPrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoPrueba) - 1;
            String tipoDocumentoData = getData3().get(valores).get(COLUMNA_TIPO_DOCUMENTO);
            switch (tipoDocumentoData) {
                case "DNI":
                    break;
                case "Pasaporte":
                    click(driver, "css", SELECT_TIPO_DOCUMENTO);
                    click(driver, "xpath", TIPO_DOC_PASAPORTE);
                    break;
                case "CE":
                    click(driver, "css", SELECT_TIPO_DOCUMENTO);
                    click(driver, "xpath", TIPO_CE);
                    break;
                case "Otros":
                    click(driver, "css", SELECT_TIPO_DOCUMENTO);
                    click(driver, "xpath", TIPO_OTROS);
                    break;
                default:
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Error: tipo de documento no valido(Excel)");
                    generateWord.sendText("Error: tipo de documento no valido(Excel)");
                    break;
            }
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se seleccion el tipo de documento: " + tipoDocumentoData);
            generateWord.sendText("Se seleccion el tipo de documento: " + tipoDocumentoData);
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    /*------------------------------------------------------------------------------------------------------*/
    public void seleccionarAsignarRoles(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String rolesData = getData3().get(valores).get(COLUMNA_ROLES);

            switch (rolesData) {
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
                default:
                    System.out.println("caso no valido");
                    break;

            }

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono los roles del RRAA");
            generateWord.sendText("Se selecciono los roles del RRAA");
            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            //ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 10, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    /*------------------------------------------------------------------------------------------------------*/
    public void seleccionarBotonCrear() throws Throwable {

        try {
            click(driver, "xpath", BTN_CREAR);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono El boton Crear");
            generateWord.sendText("Se selecciono El boton Crear");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            //ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 10, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    /*------------------------------------------------------------------------------------------------------*/
    public void seleccionarBotonConfirmar() throws Throwable {

        try {
            click(driver, "xpath", BTN_CONFIRMAR);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono el boton modal Confirmar");
            generateWord.sendText("Se selecciono el boton modal Confirma");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
           // ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 10, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }
    /*------------------------------------------------------------------------------------------------------*/

    public void seleccionarUnUsuario(String casoDePrueba) throws Throwable {
        int valores = Integer.parseInt(casoDePrueba) - 1;
        String documentoData = getData3().get(valores).get(COLUMNA_NUM_DOCUMENTO);

        try {
            sleep2(3);
            sendKeyValue(driver, "xpath", INPUT_BUSCAR_PERSONA, documentoData);
            sleep2(3);
            click(driver, "xpath", SELECT_PERSONA);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono el usuario con DNI: " + documentoData);
            generateWord.sendText("Se selecciono el usuario con DNI: " + documentoData);
            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void ValidarUsuario(String casoDePrueba) throws Throwable {
        int valores = Integer.parseInt(casoDePrueba) - 1;
        String documentoData = getData3().get(valores).get(COLUMNA_NUM_DOCUMENTO);
        String tipoeRolOnlineData = getData3().get(valores).get(COLUMNA_ROL_ONLINE);
        try {
            clear(driver,"xpath",INPUT_BUSCAR_PERSONA);
            sendKeyValue(driver, "xpath", INPUT_BUSCAR_PERSONA, documentoData);
            sleep2(3);
            driver.findElement(By.xpath("//span[contains(text(),'" + tipoeRolOnlineData + "')]")).isDisplayed();

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se busco usuario con RRAA DNI: " + documentoData);
            generateWord.sendText("Se busco usuario con RRAA DNI: " + documentoData);
            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void certificarUsuario() throws Throwable {

        try {
            click(driver, "xpath", BTN_CERTIFICAR);
            sleep(3000);
            sendKeyValue(driver, "xpath", ARCHIVO_SELECT, ARCHIVO_IMAGEN);
            click(driver, "xpath", BTN_CERTIFICAR_USUARIO);
            sleep2(5);
            click(driver, "css", BTN_MODAL_ACEPTAR);
            sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se certifico el usuario");
            generateWord.sendText("Se certifico el usuario");
            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void editarAsignarRolOnline(String casoPrueba) throws Throwable {

        try {
            clickEditar();
            click(driver, "css", BTN_SIGUIENTE);
            selecionarTipoRolOnline(casoPrueba);
            click(driver, "xpath", BTN_ACTUALIZAR);
            click(driver, "xpath", BTN_CONFIRMAR_FINAL);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Los datos ");
            generateWord.sendText("Se certifico el usuario");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public void clickEditar() throws InterruptedException {
        actions = new Actions(driver);
        Thread.sleep(500);
        WebElement element = driver.findElements(By.xpath(MENU_OPCIONES_USUARIO)).get(0);
        actions.moveToElement(element).perform();
        element.findElement(By.xpath(OPCION_EDITAR)).click();
    }


    /*------------------------------------------------------------------------------------------------------*/
    public void selecionarTipoRolOnline(String casoPrueba) throws Throwable {
        try {

            int valores = Integer.parseInt(casoPrueba) - 1;
            String tipoeRolOnlineData = getData3().get(valores).get(COLUMNA_ROL_ONLINE);
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
                default:
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Error: tipo de ROL no valido(Excel)");
                    generateWord.sendText("Error: tipo de ROL no valido(Excel)");
                    break;
            }

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se seleccion el rol: " + tipoeRolOnlineData);
            generateWord.sendText("Se seleccion el rol : " + tipoeRolOnlineData);
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


}
