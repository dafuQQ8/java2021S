/*
 *  Copyright (c) Monsters, Inc. All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by kagu-tsuchi <palerence@gmail.com>, September 2021
 */
package registration_application.view;

/**
 * Constants container.
 *
 * @version 1.0 9 Sep 2021
 * @author kagu-tsuchi
 */

public class GlobalConstants {
    //! SQL
    public static final String DATABASE = "reg";
    public static final String USERNAME_DATABASE = "Username";
    public static final String FIRSTNAME_DATABASE = "FirstName";
    public static final String MIDDLENAME_DATABASE = "MiddleName";
    public static final String LASTNAME_DATABASE = "LastName";
    public static final String LANDLINE_DATABASE = "Landline";
    public static final String CELL_DATABASE = "Cell"; // Cell stands for cellular phone
    public static final String EXTRA_CELL_DATABASE = "ExtraCell";
    public static final String EMAIL_DATABASE = "Email";
    public static final String SKYPE_DATABASE = "Skype";
    public static final String ZIP_CODE_DATABASE = "ZipCode";
    public static final String CITY_DATABASE = "City";
    public static final String STREET_DATABASE = "Street";
    public static final String BUILDING_DATABASE = "Building";
    public static final String FLOOR_DATABASE = "Floor";
    public static final String ROOM_DATABASE = "Room";
    public static final String CURRENT_DATE_DATABASE = "RegistryDate";
    public static final String SFP_DATABASE = "SFP";
    public static final String FULLADDRESS_DATABASE = "FullAddress";


    //! REQUESTS
    public static final String INPUT_REQUEST = "string.input.request";
    public static final String FIRST_NAME_REQUEST = "string.firstName.request";
    public static final String MIDDLE_NAME_REQUEST = "string.middleName.request";
    public static final String LAST_NAME_REQUEST = "string.lastName.request";
    public static final String USERNAME_REQUEST = "string.username.request";
    public static final String LANDLINE_REQUEST = "string.landline.request";
    public static final String CELL_REQUEST = "string.cell.request"; // Cell stands for cellular phone
    public static final String EXTRA_CELL_REQUEST = "string.extraCell.request";
    public static final String EMAIL_REQUEST = "string.email.request";
    public static final String SKYPE_REQUEST = "string.skype.request";
    public static final String ZIP_CODE_REQUEST = "string.zipCode.request";
    public static final String CITY_REQUEST = "string.city.request";
    public static final String STREET_REQUEST = "string.street.request";
    public static final String BUILDING_REQUEST = "string.building.request";
    public static final String FLOOR_REQUEST = "string.floor.request";
    public static final String ROOM_REQUEST = "string.room.request";
    //! WARNINGS
    public static final String FIRST_NAME_WARNING = "string.firstName.warning";
    public static final String MIDDLE_NAME_WARNING = "string.middleName.warning";
    public static final String LAST_NAME_WARNING = "string.lastName.warning";
    public static final String USERNAME_WARNING = "string.username.warning";
    public static final String LANDLINE_WARNING = "string.landline.warning";
    public static final String CELL_WARNING = "string.cell.warning"; // Cell stands for cellular phone
    public static final String EXTRA_CELL_WARNING = "string.extraCell.warning";
    public static final String EMAIL_WARNING = "string.email.warning";
    public static final String SKYPE_WARNING = "string.skype.warning";
    public static final String ZIP_CODE_WARNING = "string.zipCode.warning";
    public static final String CITY_WARNING = "string.city.warning";
    public static final String STREET_WARNING = "string.street.warning";
    public static final String BUILDING_WARNING = "string.building.warning";
    public static final String FLOOR_WARNING = "string.floor.warning";
    public static final String ROOM_WARNING = "string.room.warning";
    public static final String WARNING_WARNING = "string.warning.warning";
    //!REGEX REGULATIONS
    public static final String FIRST_NAME_REGEX = "string.firstName.regex";
    public static final String MIDDLE_NAME_REGEX = "string.middleName.regex";
    public static final String LAST_NAME_REGEX = "string.lastName.regex";
    public static final String USERNAME_REGEX = "string.username.regex";
    public static final String LANDLINE_REGEX = "string.landline.regex";
    public static final String CELL_REGEX = "string.cell.regex"; // Cell stands for cellular phone
    public static final String EXTRA_CELL_REGEX = "string.extraCell.regex";
    public static final String EMAIL_REGEX = "string.email.regex";
    public static final String SKYPE_REGEX = "string.skype.regex";
    public static final String ZIP_CODE_REGEX = "string.zipCode.regex";
    public static final String CITY_REGEX = "string.city.regex";
    public static final String STREET_REGEX = "string.street.regex";
    public static final String BUILDING_REGEX = "string.building.regex";
    public static final String FLOOR_REGEX = "string.floor.regex";
    public static final String ROOM_REGEX = "string.room.regex";

    public static final String LOCALISATION =
        "Greetings!\n" +
        "You are to choose localization pack for registration form.\n" +
        "You will be asked for language code.\n"
    ;

    public static final String SUPPORTED_LANGUAGES =
        "\n" +
        "Available options:\n" +
        ">>>> en-US - English layout, localized for the United States.(language code - en)\n" +
        ">>>> uk-UA - Українська розкладка, локалізована під Україну.(language code - uk)\n" +
        "\n" +
        "Language code " +
        ">>>> "
    ;

    public static final String LANGUAGE_CODE_ERROR =
        "\n" +
        "This language is not supported yet!\n" +
        "Try to pick a supported one.\n"
    ;

    public static final String ARROWS =
        "\n" +
        ">>>> "
    ;
}
