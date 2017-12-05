package utils;

import model.connection.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


public class Report {

    private Connection connection;
    public static final String accountReportPdf = System.getProperty("user.dir")+"/src/reports/Account.pdf";
    public static final String accountReportPath = System.getProperty("user.dir")+"/src/reports/acc.jasper";
    

    public Report() {
        connection = ConnectionFactory.getConnection();
    }

    private Map getParameters() {
        Map params = new HashMap();
        return params;
    }

    public void viewReport(){
        JasperPrint print;
        try {
            print = JasperFillManager.fillReport(
                    accountReportPath,
                    getParameters(),
                    connection);

            JasperViewer.viewReport(print);
        } catch (JRException ex) {
            System.err.println("Não foi possível exportar o relatório.\n\n");
            ex.printStackTrace();
        }
    }

    public void genereteReport(){
        JasperPrint impressao;
        try {
            impressao = JasperFillManager.fillReport(
                    accountReportPath,
                    null,
                    connection);
            JasperExportManager.exportReportToPdfFile(impressao, accountReportPdf);
        } catch (JRException ex) {
            System.err.println("Não foi possível exportar o relatório.\n\n");
            ex.printStackTrace();
        }
    }
}
