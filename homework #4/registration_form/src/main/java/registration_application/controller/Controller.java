/*
 *  Copyright (c) Monsters, Inc. All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by kagu-tsuchi <palerence@gmail.com>, September 2021
 */
package registration_application.controller;

import java.util.Scanner;

import registration_application.model.*;
import registration_application.view.*;

/**
 * Controller class accepts input and converts it to commands for the model or view.
 * It responds to the user input and performs interactions on the data model objects.
 * The controller receives the input, optionally validates it and then passes the input to the model.
 *
 * @version 1.0 9 Sep 2021
 * @author kagu-tsuchi
 */
public class Controller {

    private Model model;
    private View view;
    String word;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    // this method boots application
    public void applicationBoot() {
        Scanner scannerInput = new Scanner(System.in);
        languagePack(scannerInput);
        View.localization(model.getLanguageCode());
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.USERNAME_REGEX),
            View.getResourceBundle().getString(GlobalConstants.USERNAME_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.USERNAME_WARNING),
            GlobalConstants.USERNAME_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.FIRST_NAME_REGEX),
            View.getResourceBundle().getString(GlobalConstants.FIRST_NAME_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.FIRST_NAME_WARNING),
            GlobalConstants.FIRSTNAME_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.MIDDLE_NAME_REGEX),
            View.getResourceBundle().getString(GlobalConstants.MIDDLE_NAME_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.MIDDLE_NAME_WARNING),
            GlobalConstants.MIDDLENAME_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.LAST_NAME_REGEX),
            View.getResourceBundle().getString(GlobalConstants.LAST_NAME_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.LAST_NAME_WARNING),
            GlobalConstants.LASTNAME_DATABASE
        );
        model.SFP(
            GlobalConstants.SFP_DATABASE,
            GlobalConstants.LASTNAME_DATABASE,
            GlobalConstants.FIRSTNAME_DATABASE,
            GlobalConstants.MIDDLENAME_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.LANDLINE_REGEX),
            View.getResourceBundle().getString(GlobalConstants.LANDLINE_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.LANDLINE_WARNING),
            GlobalConstants.LANDLINE_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.CELL_REGEX),
            View.getResourceBundle().getString(GlobalConstants.CELL_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.CELL_WARNING),
            GlobalConstants.CELL_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.EXTRA_CELL_REGEX),
            View.getResourceBundle().getString(GlobalConstants.EXTRA_CELL_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.EXTRA_CELL_WARNING),
            GlobalConstants.EXTRA_CELL_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.EMAIL_REGEX),
            View.getResourceBundle().getString(GlobalConstants.EMAIL_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.EMAIL_WARNING),
            GlobalConstants.EMAIL_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.SKYPE_REGEX),
            View.getResourceBundle().getString(GlobalConstants.SKYPE_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.SKYPE_WARNING),
            GlobalConstants.SKYPE_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.ZIP_CODE_REGEX),
            View.getResourceBundle().getString(GlobalConstants.ZIP_CODE_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.ZIP_CODE_WARNING),
            GlobalConstants.ZIP_CODE_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.CITY_REGEX),
            View.getResourceBundle().getString(GlobalConstants.CITY_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.CITY_WARNING),
            GlobalConstants.CITY_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.STREET_REGEX),
            View.getResourceBundle().getString(GlobalConstants.STREET_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.STREET_WARNING),
            GlobalConstants.STREET_DATABASE
        );
        setInfo(scannerInput,
            View.getResourceBundle().getString(GlobalConstants.BUILDING_REGEX),
            View.getResourceBundle().getString(GlobalConstants.BUILDING_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.BUILDING_WARNING),
            GlobalConstants.BUILDING_DATABASE
        );
        setInfo(scannerInput,
            View.getResourceBundle().getString(GlobalConstants.FLOOR_REGEX),
            View.getResourceBundle().getString(GlobalConstants.FLOOR_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.FLOOR_WARNING),
            GlobalConstants.FLOOR_DATABASE
        );
        setInfo(
            scannerInput,
            View.getResourceBundle().getString(GlobalConstants.ROOM_REGEX),
            View.getResourceBundle().getString(GlobalConstants.ROOM_REQUEST),
            View.getResourceBundle().getString(GlobalConstants.ROOM_WARNING),
            GlobalConstants.ROOM_DATABASE
        );
        model.getFullAddress(GlobalConstants.FULLADDRESS_DATABASE,
            GlobalConstants.ZIP_CODE_DATABASE,
            GlobalConstants.CITY_DATABASE,
            GlobalConstants.STREET_DATABASE,
            GlobalConstants.BUILDING_DATABASE,
            GlobalConstants.FLOOR_DATABASE,
            GlobalConstants.ROOM_DATABASE
        );
    }

    private void languagePack(Scanner scannerInput) {
        view.printMessage(view.mergeStrings(
            String.format(GlobalConstants.LOCALISATION),
            String.format(GlobalConstants.SUPPORTED_LANGUAGES)
        ));
         while (!model.setLanguageCode(scannerInput.nextLine())) {
            view.printMessage(view.mergeStrings(
                String.format(GlobalConstants.LANGUAGE_CODE_ERROR),
                String.format(GlobalConstants.SUPPORTED_LANGUAGES)
            ));
        }
    }

    private void setInfo (Scanner scannerInput, String currentRegulation, String variable_request, String variable_warning, String variableColumn) {
        view.printMessage(view.mergeStrings(
            String.format(View.getResourceBundle().getString(GlobalConstants.INPUT_REQUEST) + " "),
            String.format(variable_request),
            String.format(GlobalConstants.ARROWS)
        ));
        while (!model.setInfo(scannerInput.nextLine(), currentRegulation, variableColumn)) {
            view.printMessage(view.mergeStrings(
            String.format(View.getResourceBundle().getString(GlobalConstants.INPUT_REQUEST) + " "),
            String.format(variable_request + "\n"),
            String.format(View.getResourceBundle().getString(GlobalConstants.WARNING_WARNING) + " "),
            String.format(variable_warning + " "),
            String.format(GlobalConstants.ARROWS)
        ));
        }
    }
}
