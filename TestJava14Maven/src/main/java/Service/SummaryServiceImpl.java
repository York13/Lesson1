package Service;

import Data.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    PersonalRepository personRepositoryFromPropertyFile;

    @Override
    public void createHtmlFile(String propertyFilePathOne, String propertyFilePathTwo, String pathHtmlFile) {

        personRepositoryFromPropertyFile.fillHashMap(propertyFilePathOne, propertyFilePathTwo);

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"ru\">\n" +
                "<head>\n" +
                "    <title>Резюме</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
                "          integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\n" +
                "          crossorigin=\"anonymous\">\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"\n" +
                "            integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\"\n" +
                "            crossorigin=\"anonymous\"></script>\n" +
                "    <style>\n" +
                "        body{background: darkgray; padding: 10px 0;}\n" +
                "        .container { max-width: 50%; background: white; padding: 10px;}\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h4 class=\"text-center\"><strong>Резюме</strong><p>на должность Java-стажер</p></h4>\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col-xs-8 col-md-8\">\n" +
                "                <dl class=\"dl-horizontal\">\n" +
                "                    <dt>ФИО:</dt><dd>" + personRepositoryFromPropertyFile.returnKey("FIO") + "</dd>\n" +
                "                    <dt>Дата рождения:</dt><dd>" + personRepositoryFromPropertyFile.returnKey("DOB") + "</dd>\n" +
                "                    <dt>Телефон:</dt><dd>" + personRepositoryFromPropertyFile.returnKey("phone") + "</dd>\n" +
                "                    <dt>e-mail:</dt><dd>" + personRepositoryFromPropertyFile.returnKey("email") + "</dd>\n" +
                "                    <dt>Skype:</dt><dd>" + personRepositoryFromPropertyFile.returnKey("skype") + "</dd>\n" +
                "                </dl></div>\n" +
                "            <div class=\"col-xs-4 col-md-4\">\n" +
                "                <img src=\"" + personRepositoryFromPropertyFile.returnKey("avatar") + "\" width=\"100%\">\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"card card-block\">\n" +
                "            <h4 class=\"card-title\"><strong>Цель:</strong></h4>\n" +
                "            <p class=\"card-text\">" + personRepositoryFromPropertyFile.returnKey("target") + "</p>\n" +
                "        </div>\n" +
                "        <div class=\"card card-block\">\n" +
                "            <h4 class=\"card-title\"><strong>Опыт работы:</strong></h4>\n" +
                "            <ol class=\"card-text\">\n"
                + personRepositoryFromPropertyFile.returnKey("experiences") +
                "            </ol>\n" +
                "        </div>\n" +
                "        <div class=\"card card-block\">\n" +
                "            <h4 class=\"card-title\"><strong>Образование:</strong></h4>\n" +
                "            <p class=\"card-text\">" + personRepositoryFromPropertyFile.returnKey("educations") + "</p>\n" +
                "        </div>\n" +
                "        <div class=\"card card-block\">\n" +
                "            <h4 class=\"card-title\"><strong>Доп. образ. и курсы:</strong></h4>\n" +
                "            <ol class=\"card-text\">\n"
                + personRepositoryFromPropertyFile.returnKey("additional_educations") +
                "            </ol>\n" +
                "        </div>\n" +
                "        <div class=\"card card-block\">\n" +
                "            <h4 class=\"card-title\"><strong>Навыки:</strong></h4>\n" +
                "            <ol class=\"card-text\">\n"
                + personRepositoryFromPropertyFile.returnKey("skills") +
                "            </ol>\n" +
                "        </div>\n" +
                "        <div class=\"card card-block\">\n" +
                "            <h4 class=\"card-title\"><strong>Примеры моего кода:</strong></h4>\n" +
                "            <div class=\"card-text\">\n"
                + personRepositoryFromPropertyFile.returnKey("examples_code") +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
        try {
            File file = new File(pathHtmlFile);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(pathHtmlFile, false);
            writer.write(html);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
