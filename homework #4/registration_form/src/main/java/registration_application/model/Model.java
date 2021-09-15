package registration_application.model;

import registration_application.database.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The central component class of the MVC pattern.
 * It is the application's dynamic data structure, independent of the user interface.
 * It directly manages the data, logic and rules of the application.
 * The model is responsible for managing the data of the application. It receives user input from the controller.
 *
 * @version 1.0 9 Sep 2021
 * @author kagu-tsuchi
 */
public class Model {
    private Pattern pattern;
    private Matcher matcher;

    private String languageCode;
    private String userName;

    private int index;

    public boolean setLanguageCode(String languageCode) {
        if (languageCode.equals("en") || languageCode.equals("En") || languageCode.equals("EN") || languageCode.equals("eN")) {
            this.languageCode = "en";
            return true;
        } else if (languageCode.equals("uk") || languageCode.equals("Uk") || languageCode.equals("UK") || languageCode.equals("uK")) {
            this.languageCode = "uk";
            return true;
        } else {
            return false;
        }
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public boolean setInfo(String userInput, String currentRegulation, String variableColumn) {
        this.pattern = Pattern.compile(currentRegulation);
        this.matcher = pattern.matcher(userInput);
        if (this.index == 4 ||
            this.index == 6 ||
            this.index == 8 ||
            this.index == 13 ||
            this.index == 14) {
            if (userInput.equals("")){
                index++;
                DBHandler.addUpdate(variableColumn, "null", userName);
                return true;
            } else if (matcher.find()) {
                index++;
                DBHandler.addUpdate(variableColumn, userInput, userName);
                return true;
            } else return false;
        } else if (matcher.find()) {
            if (index == 0) {
                this.index++;
                if (!DBHandler.uniqueIndex(userInput)) {
                    this.index--;
                    return false;
                } else {
                    this.userName = userInput;
                    DBHandler.signUp(variableColumn, userInput);
                    return true;
                }
            } else {
                this.index++;
                DBHandler.addUpdate(variableColumn, userInput, userName);
                return true;
            }
        } else return false;
    }

    public void SFP(String column, String surname, String firstName, String Patronimic) {
        DBHandler.addUpdate(
            column,
            getShortenedSFP(DBHandler.executeQuery(userName, surname),
                DBHandler.executeQuery(userName, firstName),
                DBHandler.executeQuery(userName, Patronimic)
            ),
            userName
        );
    }

    public String getShortenedSFP(String surname, String firstName, String patronimic) {
        String fullSFP =  surname + " " + firstName + " " + patronimic;
        String pattern = "(\\S+\\s)(\\S{1})\\S+\\s(\\S{1})\\S+";
        String shortenedSFP = fullSFP.replaceAll(pattern, "$1$2.$3.");
        return shortenedSFP;
    }

    public String getFullAddress (String ZipCode, String City, String Street, String Building, String Floor, String Room){
        String fullAddress = ZipCode + ", " + City  + ", " + Street  + ", " + Building  + ", " + Floor  + ", " + Room;
        return fullAddress;
    }

    public void getFullAddress(String column, String ZipCode, String City, String Street, String Building, String Floor, String Room) {
        DBHandler.addUpdate(column,
            getFullAddress(DBHandler.executeQuery(userName, ZipCode),
                DBHandler.executeQuery(userName, City),
                DBHandler.executeQuery(userName, Street),
                DBHandler.executeQuery(userName, Building),
                DBHandler.executeQuery(userName, Floor),
                DBHandler.executeQuery(userName, Room)),
            userName
        );
    }
}
