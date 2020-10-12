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

public class HomePrincipalPageObject extends BaseClass {

    public  WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "RRAA";
    private static final String COLUMNA_NUM_DOCUMENTO = "NumDocumento";
    private static final String COLUMNA_EMPRESA = "Empresa";
    private static final String COLUMNA_ROLES = "Roles";


    //Menu principal
    public static final String MENU_EMPRESAS ="//a[@class='nav-link'][contains(text(),'Empresa')]";
    public static final String MENU_REPORTES ="//a[@class='nav-link'][contains(text(),'Reportes')]";

    public HomePrincipalPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData2() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }

    public  void seleccionarMenuEmpresas() throws Throwable {
        try {
            click(driver, "xpath", MENU_EMPRESAS);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono Opcion menu Empresas");
            generateWord.sendText("Se selecciono Opcion menu Empresas");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            //ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 6, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    public  void seleccionarMenuReportes() throws Throwable {
        try {
            click(driver, "xpath", MENU_REPORTES);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se seleccionó opción Menu Principal: Reportes");
            generateWord.sendText("Se seleccionó opción Menu Principal: Reportes");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }



}
