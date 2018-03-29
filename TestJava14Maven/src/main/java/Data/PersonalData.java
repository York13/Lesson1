package Data;

import java.util.HashMap;

public class PersonalData {

    private HashMap<String, String> peronalData = new HashMap<>();

    public PersonalData(String FIO, String DOB, String phone, String email, String skype, String avatar, String target,
            String experiences, String educations, String additionalEducations, String skills, String examplesCode) {
            peronalData.put(PersonPropertyKeys.FIO, FIO);
            peronalData.put(PersonPropertyKeys.DOB, DOB);
            peronalData.put(PersonPropertyKeys.PHONE, phone);
            peronalData.put(PersonPropertyKeys.EMAIL, email);
            peronalData.put(PersonPropertyKeys.SKYPE, skype);
            peronalData.put(PersonPropertyKeys.AVATAR, avatar);
            peronalData.put(PersonPropertyKeys.TARGET, target);
            peronalData.put(PersonPropertyKeys.EXPERIENCES, experiences);
            peronalData.put(PersonPropertyKeys.EDUCATIONS, educations);
            peronalData.put(PersonPropertyKeys.ADDITIONAL_EDUCATIONS, additionalEducations);
            peronalData.put(PersonPropertyKeys.SKILLS, skills);
            peronalData.put(PersonPropertyKeys.EXAMPLES_CODE, examplesCode);

    }

    public String returnKey(String key) {
        return peronalData.get(key);
    }

}
