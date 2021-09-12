/*
 *  Copyright (c) Monsters, Inc. All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by kagu-tsuchi <palerence@gmail.com>, September 2021
 */
package registration_application;

import registration_application.controller.*;
import registration_application.model.*;
import registration_application.view.*;

/**
 * Application boot class.
 *
 * @version 1.0 9 Sep 2021
 * @author kagu-tsuchi
 */
public class Main {
    public static void main(String[] args) {
        // initialization of MVC elements
        Model Model = new Model();
        View View = new View();
        Controller Controller = new Controller(Model, View);
        // registrationForm startUp
        Controller.applicationBoot();
    }
}
