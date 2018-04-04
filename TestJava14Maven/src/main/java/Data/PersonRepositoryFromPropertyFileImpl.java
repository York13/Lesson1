package Data;

import java.io.InputStream;
import java.util.Properties;

public class PersonRepositoryFromPropertyFileImpl implements PersonRepository {

    private Properties personDataFile;

    public PersonRepositoryFromPropertyFileImpl(InputStream configFileInputOne, InputStream configFileInputTwo){
        PropertyReader readerOnePropertyFile = new PropertyReader(configFileInputOne);
        PropertyReader readerTwoPropertyFile = new PropertyReader(configFileInputTwo);

        try {
            readerOnePropertyFile.t.join();
            readerTwoPropertyFile.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.personDataFile = readerOnePropertyFile.getPersonalDataOfProperties();
        this.personDataFile.putAll(readerTwoPropertyFile.getPersonalDataOfProperties());
    }

    @Override
    public PersonalData getPersonalData() {
        PersonalData personalData = null;
        if(this.personDataFile != null){
            personalData = new PersonalData(
                    personDataFile.getProperty(PersonPropertyKeys.FIO),
                    personDataFile.getProperty(PersonPropertyKeys.DOB),
                    personDataFile.getProperty(PersonPropertyKeys.PHONE),
                    personDataFile.getProperty(PersonPropertyKeys.EMAIL),
                    personDataFile.getProperty(PersonPropertyKeys.SKYPE),
                    personDataFile.getProperty(PersonPropertyKeys.AVATAR),
                    personDataFile.getProperty(PersonPropertyKeys.TARGET),
                    personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES),
                    personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS),
                    personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS),
                    personDataFile.getProperty(PersonPropertyKeys.SKILLS),
                    personDataFile.getProperty(PersonPropertyKeys.EXAMPLES_CODE)
            );
        }
        return personalData;
    }
}
