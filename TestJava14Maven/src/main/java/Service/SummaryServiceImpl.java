package Service;

import Data.PersonRepository;
import Data.PersonRepositoryFromPropertyFileImpl;
import Data.PersonalData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SummaryServiceImpl implements SummaryService {

    private PersonalData personalData;

    public SummaryServiceImpl(String propertyFilePath){
        PersonRepository personRepository = new PersonRepositoryFromPropertyFileImpl(
                getClass().getClassLoader().getResourceAsStream(propertyFilePath)
        );
        this.personalData = personRepository.getPersonalData();
    }

    @Override
    public void createHtmlFile(String pathHtmlFile) {
        if (this.personalData != null){
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
                    "                    <dt>ФИО:</dt><dd>" + personalData.returnKey("FIO") + "</dd>\n" +
                    "                    <dt>Дата рождения:</dt><dd>" + personalData.returnKey("DOB") + "</dd>\n" +
                    "                    <dt>Телефон:</dt><dd>" + personalData.returnKey("phone") + "</dd>\n" +
                    "                    <dt>e-mail:</dt><dd>" + personalData.returnKey("email") + "</dd>\n" +
                    "                    <dt>Skype:</dt><dd>" + personalData.returnKey("skype") + "</dd>\n" +
                    "                </dl></div>\n" +
                    "            <div class=\"col-xs-4 col-md-4\">\n" +
                    "                <img src=\"" + personalData.returnKey("avatar") + "\" width=\"100%\">\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h4 class=\"card-title\"><strong>Цель:</strong></h4>\n" +
                    "            <p class=\"card-text\">" + personalData.returnKey("target") + "</p>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h4 class=\"card-title\"><strong>Опыт работы:</strong></h4>\n" +
                    "            <ol class=\"card-text\">\n"
                                    + personalData.returnKey("experiences") +
                    "            </ol>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h4 class=\"card-title\"><strong>Образование:</strong></h4>\n" +
                    "            <p class=\"card-text\">" + personalData.returnKey("educations") + "</p>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h4 class=\"card-title\"><strong>Доп. образ. и курсы:</strong></h4>\n" +
                    "            <ol class=\"card-text\">\n"
                                    + personalData.returnKey("additional_educations") +
                    "            </ol>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h4 class=\"card-title\"><strong>Навыки:</strong></h4>\n" +
                    "            <ol class=\"card-text\">\n"
                                    + personalData.returnKey("skills") +
                    "            </ol>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h4 class=\"card-title\"><strong>Примеры моего кода:</strong></h4>\n" +
                    "            <div class=\"card-text\">\n"
                                    + personalData.returnKey("examples_code") +
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
}
