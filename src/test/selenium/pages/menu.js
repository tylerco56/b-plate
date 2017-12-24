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