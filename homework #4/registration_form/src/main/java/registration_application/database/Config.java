/*
 *  Copyright (c) Monsters, Inc. All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by kagu-tsuchi <palerence@gmail.com>, September 2021
 */
package registration_application.database;

/**
 * DBHandler's superclass that stores configuration data.
 *
 * @version 1.0 9 Sep 2021
 * @author kagu-tsuchi
 */
public class Config {
    protected static final String dbHost = "127.0.0.1";
    protected static final String dbPort = "3306";
    protected static final String dbUser = "root";
    protected static final String dbPass = "password";
    protected static final String dbName = "registration";
}
