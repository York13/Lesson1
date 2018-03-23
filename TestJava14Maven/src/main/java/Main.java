import Service.SummaryServiceImpl;

public class Main {

    public static void main(String[] args) {
        SummaryServiceImpl summaryService = new SummaryServiceImpl("person.properties");
        summaryService.createHtmlFile("src/main/java/Webapp/summary.html");
    }
}
