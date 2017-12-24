/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
 *
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017 Landon Wiedenman
 */

const By = require("selenium-webdriver").By;

class Menu {
    constructor(driver) {
        this.driver = driver;
        this.locators = {
            menuItemLocation: itemName => By.xpath(`//a[text() = "${itemName}"]`),
            loginMenuBtn: By.css("body > nav > div > div.right.hide-on-med-and-down > ul > li > form > button > i"),
            loginMenuBtnMobile: By.css("@media only screen and (max-width: 992px)\n" +
                "nav .button-collapse i")

        }
    }

    login(aUsername, aPassword) {
        const loginBtn = this.driver.findElement(this.locators.loginMenuBtn)
            .click();
    }

    logout() {
        const logout = this.driver.findElement(By.className("logout"));
        logout.click()
    }



    clickMenuItem(itemName) {
        this.driver.findElement(this.locators.menuItemLocation(itemName))
            .click();
    }
}

module.exports = Menu;