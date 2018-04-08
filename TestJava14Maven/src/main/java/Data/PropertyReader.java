package Data;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

@Component
public class PropertyReader implements MyReader {

    protected Properties personDataFile;

    public void getFromProperty(String propertyFilePathOne, String propertyFilePathTwo) {
        try {
            personDataFile.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(propertyFilePathOne), Charset.forName("UTF-8")));
            personDataFile.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(propertyFilePathTwo), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getPersonDataFile(String propertyFilePathOne, String propertyFilePathTwo) {
        getFromProperty(propertyFilePathOne, propertyFilePathTwo);
        return personDataFile;
    }
}
