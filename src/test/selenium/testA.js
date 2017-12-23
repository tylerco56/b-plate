// Runs a Selenium test in Chrome -- Logs a USER in, creates a tasks, checks task off, logs out.
// Requires Node to be installed first: https://treehouse.github.io/installation-guides/mac/node-mac.html or https://treehouse.github.io/installation-guides/windows/node-windows.html

// WEBDRIVER INSTALLATION:
// 'npm install selenium-webdriver'
// 'sudo npm install chrome-driver -g"

// RUN:
// 'node testA.js'



// Imports Selenium WebDriver
const selenium = require("selenium-webdriver");
const  driver = new selenium.Builder().forBrowser("chrome").build();

// The starting URL for testing
const url = "http://localhost:8080/";

// Opens the window
driver.get(url);

const By = selenium.By;



///////
/////// LOCATORS
///////

const loginLocators = {
    usernameUser: By.name("username"),
    passwordUser: By.name("password"),
    loginBtn: By.css("form.login button[type=submit]"),
    registerLink: By.linkText("register"),
    forgotLink: By.linkText("forgot password?"),
    loginMenuBtn: By.css("body > nav > div > div.right.hide-on-med-and-down > ul > li > form > button > i"),
    loginMenuBtnMobile: By.css("@media only screen and (max-width: 992px)\n" +
        "nav .button-collapse i")
}

const testTasks = [
    'Do something robotoic',
    'Do something crazy',
    'Write a novel',
    'Go to town',
    'Happy dance'
]

const taskLocator = {
    checkOffField: task => By.xpath(`//label[text() = "${task}"]`)
}

const menuLocator = {
    menuItemLocation: itemName => By.xpath(`//a[text() = "${itemName}"]`)
}

//a[text() = "ADD NEW"]

///////
/////// FUNCTIONS
///////

function login(aUsername, aPassword) {
    var username = driver.findElement(loginLocators.usernameUser);
    var password = driver.findElement(loginLocators.passwordUser);
    username.sendKeys(aUsername);
    password.sendKeys(aPassword);
    var submitBtn = driver.findElement(loginLocators.loginBtn);
    submitBtn.click();
}

function logout() {
    const logout = driver.findElement(By.className("logout"));
    logout.click()
}

function createTask(task) {
    const newTaskInput = driver.findElement(By.name("description"));
    newTaskInput.sendKeys(task);
    newTaskInput.submit();
}

function checkOffTask(task) {  // TODO: finish this
    driver.findElement(taskLocator.checkOffField(task)).click();
}

function clickMenuItem(itemName) {
    driver.findElement(menuLocator.menuItemLocation(itemName)).click();
}

// function checkOnTask(task) {
// // Checks the top task back on
//     const chekhon = driver.findElement(By.className("todo-item")).findElement(By.css("label"));
//     chekhon.click();
// }



///////
/////// ROLE_USER Test
///////

login("user", "password");
testTasks.forEach(createTask);
testTasks.forEach(checkOffTask);
// TODO: Refresh page and look for tasks in menu
// TODO: Look for absence of admin and publisher level menu items
// TODO:
logout();
// TODO: Look for absence of admin and publisher role level menu items



///////
/////// ROLE_ADMIN Test
///////

login("user2", "password");
testTasks.forEach(createTask);
testTasks.forEach(checkOffTask);
clickMenuItem("pages");  // TODO: check for pages menu item and click
// TODO: Go to each page and look for images and content?
clickMenuItem("images");// TODO: Check for images menu item and click
// TODO: Add an set of images, edit the image fields, remove the images
clickMenuItem("users");// TODO: Check for users menu item and click
// TODO: Add a set of users
// TODO: Click on each user and edit all fields and trigger password reset
// TODO: Reset logged in user password
// TODO: Delete set of users
logout();