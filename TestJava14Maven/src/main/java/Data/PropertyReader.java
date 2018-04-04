package Data;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertyReader extends Thread {
    private InputStream propertyPath;
    private Properties properties;
    public Thread t;

    PropertyReader(InputStream propertyPath) {
        this.propertyPath = propertyPath;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            this.properties = getPropertiesFromFile(propertyPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties getPropertiesFromFile(InputStream propertyPath) throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(propertyPath, Charset.forName("UTF-8")));
        return properties;
    }

    Properties getPersonalDataOfProperties() {
        return this.properties;
    }
}
