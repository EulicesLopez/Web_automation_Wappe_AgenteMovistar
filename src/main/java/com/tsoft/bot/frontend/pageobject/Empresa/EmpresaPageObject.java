package com.tsoft.bot.frontend.pageobject.Empresa;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class EmpresaPageObject extends BaseClass {
    public  WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();
    
    private static final String EXCEL_WEB = "excel/DATA_WAPPE_MOVISTAR.xlsx";
    private static final String EXCEL_SHEET = "AnadirRRAA";
    private static final String COLUMNA_EMPRESA = "RucEmpresa";



// selenium
    public static String INPUT_BUSCAR_EMPRESA = "//input[@placeholder='Buscar por Nro. de Doc / Razón Social']";
    public static String BTN_TODAS_EMPRESAS = "//span[@class='border-right']";
//menu empresa

    public static String MENU_USUARIOS = "//span[contains(text(),'Usuarios')]";

    public EmpresaPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData4() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }


    public  void seleccionarUnaEmpresa(String casoDePrueba) throws Throwable {
      try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String empresaData = getData4().get(valores).get(COLUMNA_EMPRESA);
            listarTodasLasEmpresas();
            sleep2(3);
            sendKeyValue(driver, "xpath", INPUT_BUSCAR_EMPRESA, empresaData);
            sleep2(3);
            driver.findElement(By.xpath("//span[contains(text(),'" + empresaData + "')]")).click();
            sleep(3000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciono la empresa y la opcion crear RRAA");
            generateWord.sendText("Se selecciono la empresa y la opcion crear RRAA");
            generateWord.addImageToWord(driver);
            sleep2(5);


        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 6, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }



    public  void buscarSeleccionarUnaEmpresa(String rucEmpresaDataExcel) throws Throwable {
        try {
            click(driver, "xpath", BTN_TODAS_EMPRESAS);
            sleep2(4);
            sendKeyValue(driver, "xpath", INPUT_BUSCAR_EMPRESA, rucEmpresaDataExcel);
            sleep2(3);
            driver.findElement(By.xpath("//span[contains(text(),'" + rucEmpresaDataExcel + "')]")).click();
            sleep(3000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se busco la empresa con Ruc: "+rucEmpresaDataExcel+ " y se seleccionó");
            generateWord.sendText("Se busco la empresa con Ruc: " + rucEmpresaDataExcel + " y se seleccionó");
            generateWord.addImageToWord(driver);
            sleep2(5);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }





    public  void listarTodasLasEmpresas() throws Throwable {
        try {
            click(driver, "xpath", BTN_TODAS_EMPRESAS);
            sleep2(4);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dio clic en boton todas las empresas");
            generateWord.sendText("Se dio clic en boton todas las empresas");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }





    public void seleccionarMenuUsuarios() throws Throwable {
        try {
            click(driver, "xpath", MENU_USUARIOS);
            sleep2(4);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dio clic en boton todas las empresas");
            generateWord.sendText("Se dio clic en boton todas las empresas");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
           // ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 6, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


}
