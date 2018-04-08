package Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PersonRepositoryFromPropertyFileImpl implements PersonalRepository {

    @Autowired
    MyReader propertyReader;

    protected HashMap<String, String> peronalData = new HashMap<>();

    @Override
    public void fillHashMap(String propertyFilePathOne, String propertyFilePathTwo) {
        peronalData.put(PersonPropertyKeys.FIO, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.FIO));
        peronalData.put(PersonPropertyKeys.DOB, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.DOB));
        peronalData.put(PersonPropertyKeys.PHONE, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.PHONE));
        peronalData.put(PersonPropertyKeys.EMAIL, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.EMAIL));
        peronalData.put(PersonPropertyKeys.SKYPE, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.SKYPE));
        peronalData.put(PersonPropertyKeys.AVATAR, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.AVATAR));
        peronalData.put(PersonPropertyKeys.TARGET, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.TARGET));
        peronalData.put(PersonPropertyKeys.EXPERIENCES, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.EXPERIENCES));
        peronalData.put(PersonPropertyKeys.EDUCATIONS, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.EDUCATIONS));
        peronalData.put(PersonPropertyKeys.ADDITIONAL_EDUCATIONS, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS));
        peronalData.put(PersonPropertyKeys.SKILLS, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.SKILLS));
        peronalData.put(PersonPropertyKeys.EXAMPLES_CODE, propertyReader.getPersonDataFile(propertyFilePathOne, propertyFilePathTwo).getProperty(PersonPropertyKeys.EXAMPLES_CODE));
    }

    @Override
    public String returnKey(String key) {
        return peronalData.get(key);
    }
}
