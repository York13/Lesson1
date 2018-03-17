import Service.SummaryService;
import Service.SummaryServiceImpl;

/*
*   За предоставленный рабочий вариант программы огромное спасибо Стратонову Алексею из SimbirSoft
*/
public class Main {

    public static void main(String[] args) {
        SummaryService summaryService = new SummaryServiceImpl("Resources/person.properties");
        summaryService.createHtmlFile("src/Webapp/summary.html");
    }
}
