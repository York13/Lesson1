import Service.SummaryServiceImpl;

public class Main {

    public static void main(String[] args) {
        SummaryServiceImpl summaryService = new SummaryServiceImpl("1.properties", "2.properties");
        summaryService.createHtmlFile("src/main/java/Webapp/summary.html");
    }
}
