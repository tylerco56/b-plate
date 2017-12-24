const By = require("selenium-webdriver").By;

// The starting URL
const url = "http://localhost:8080/login";

class LoginPage {
    constructor(driver) {
        this.driver = driver;
        this.locators = {
            usernameUser: By.name("username"),
            passwordUser: By.name("password"),
            loginBtn: By.css("form.login button[type=submit]"),
            registerLink: By.linkText("register"),
            forgotLink: By.linkText("forgot password?"),
            loginMenuBtn: By.css("body > nav > div > div.right.hide-on-med-and-down > ul > li > form > button > i"),
            loginMenuBtnMobile: By.css("@media only screen and (max-width: 992px)\n" +
                "nav .button-collapse i")

        }
    }

    open() {
        this.driver.get(url);
    }

    login(aUsername, aPassword) {
        var username = this.driver.findElement(this.locators.usernameUser);
        var password = this.driver.findElement(this.locators.passwordUser);
        username.sendKeys(aUsername);
        password.sendKeys(aPassword);
        var submitBtn = this.driver.findElement(this.locators.loginBtn);
        submitBtn.click();
    }
}

module.exports = LoginPage;