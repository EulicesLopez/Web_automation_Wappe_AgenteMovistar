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

    public static WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "RRAA";
    private static final String COLUMNA_NUM_DOCUMENTO = "NumDocumento";
    private static final String COLUMNA_EMPRESA = "Empresa";
    private static final String COLUMNA_ROLES = "Roles";


// selenium

    public static String INPUT_BUSCAR_EMPRESA = "//input[@placeholder='Buscar por Nro. de Doc / Razón Social']";
    public static String BTN_TODAS_EMPRESAS = "//span[@class='border-right']";


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

    //tipo de comento
    public static String SELECT_TIPO_DOCUMENTO = "mat-select-3";
    public static String TIPO_DOC_PASAPORTE = "//span[contains(text(),'Pasaporte')]";
    public static String TIPO_CE = "//span[contains(text(),'Carné Extranjeria')]";
    public static String TIPO_OTROS = " //span[@class='mat-option-text'][contains(text(),'Otros')]";


    public HomePrincipalPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData2() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }


}
