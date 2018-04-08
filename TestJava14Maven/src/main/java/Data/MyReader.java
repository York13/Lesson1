package Data;

import java.util.Properties;

public interface MyReader {
    void getFromProperty(String pathOne, String pathTwo);
    Properties getPersonDataFile(String pathOne, String pathTwo);

}
