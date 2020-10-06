package com.tsoft.bot.frontend.pageobject.Empresa.Usuarios;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pageobject.Empresa.EmpresaPageObject;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class EliminarUsuarioRRAAPageObject extends BaseClass {

    public static WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "EliminarRRAA";
    private static final String COLUMNA_RUC_EMPRESA = "RucEmpresa";
    private static final String COLUMNA_NUM_DOCUMENTO = "NumDocumento";

    // selenium
    public static String INPUT_BUSCAR_PERSONA = "//input[@placeholder='Buscar N° documento o Nombres y Apellidos']";
    public static String SELECT_PERSONA = "//tr[1]//td[1]//label[1]//span[1]";
    public static String BTN_ICONO_ELIMINAR = "//body/app-root[1]/app-detail[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]";
    public static String BTN_MODAL_ACEPTAR = "app-modal-general > div > section > div.footer > div > button.boton.boton__primario";


    public EliminarUsuarioRRAAPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData5() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }

    EmpresaPageObject empresaPageObject = new EmpresaPageObject();

    public void seleccionarUnaEmpresa(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String empresaData = getData5().get(valores).get(COLUMNA_RUC_EMPRESA);
            empresaPageObject.buscarSeleccionarUnaEmpresa(empresaData);
//            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono la empresa");
//            generateWord.sendText("Se selecciono la empresa");
//            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public void seleccionarUsuario(String casoDePrueba) throws Throwable {
        int valores = Integer.parseInt(casoDePrueba) - 1;
        String documentoData = getData5().get(valores).get(COLUMNA_NUM_DOCUMENTO);
        try {
            clear(driver, "xpath", INPUT_BUSCAR_PERSONA);
            sendKeyValue(driver, "xpath", INPUT_BUSCAR_PERSONA, documentoData);
            sleep2(5);
            click(driver, "xpath", SELECT_PERSONA);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se busco usuario RRAA con DNI: " + documentoData);
            generateWord.sendText("Se busco usuario RRAA con  DNI: " + documentoData);
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            // ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 10, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void eliminarRRAA() throws Throwable {

        try {
            click(driver, "xpath", BTN_ICONO_ELIMINAR);
            sleep2(2);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió clic en el icono eliminar");
            generateWord.sendText("Se dió clic en el icono eliminar");
            generateWord.addImageToWord(driver);
            click(driver, "css", BTN_MODAL_ACEPTAR);

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


}
