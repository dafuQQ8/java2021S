/*
 *  Copyright (c) Monsters, Inc. All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by kagu-tsuchi <palerence@gmail.com>, September 2021
 */
package registration_application.view;

/**
 * A View class is used to display data using the Controller class object.
 * The Views folder contains all the view files in the Maven MVC application.
 * The view renders presentation of the model in a particular format.
 *
 * @version 1.0 9 Sep 2021
 * @author kagu-tsuchi
 */
import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private static final String DEFAULT_LANGUAGE_PACK = "languagePack";
    private static ResourceBundle resourceBundle;

    public static void localization (String language) {
        Locale LanguageLocalization = new Locale(language);
        resourceBundle = ResourceBundle.getBundle(DEFAULT_LANGUAGE_PACK, LanguageLocalization);
    }

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public String mergeStrings(String...strings) {
        String finalString = "";

        for (String input: strings) {
            finalString += input;
        }
        return finalString;
    }
}
