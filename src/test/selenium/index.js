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


const fs = require("fs");

// Imports Selenium WebDriver
const selenium = require("selenium-webdriver");
const By = selenium.By;
const driver = new selenium.Builder()
    .forBrowser("chrome")
    .build();

const LoginPage = require('./pages/loginPage');
const loginPage = new LoginPage(driver);

const Todo = require('./pages/todo');
const todo = new Todo(driver);

const Menu = require('./pages/menu');
const menu = new Menu(driver);

const testTasks = [
    'Do something robotic',
    'Do something crazy',
    'Write a novel',
    'Go to town',
    'Happy dance'
]

//a[text() = "ADD NEW"]



///////
/////// ROLE_USER Test
///////
loginPage.open();
loginPage.login("user", "password");
testTasks.forEach(task => todo.createTask(task));
testTasks.forEach(task => todo.checkOffTask(task));
driver.takeScreenshot().then((image, err) => {
    fs.writeFile("images/task-layout.png", image, "base64",
        err => console.error(err));
});
// TODO: Refresh page and look for tasks in menu
// TODO: Look for absence of admin and publisher level menu items
// TODO:
menu.logout();
// TODO: Look for absence of admin and publisher role level menu items



///////
/////// ROLE_ADMIN Test
///////

loginPage.login("user2", "password");
testTasks.forEach(task => todo.createTask(task));
testTasks.forEach(task => todo.checkOffTask(task));
menu.clickMenuItem("pages");  // TODO: check for pages menu item and click
// TODO: Go to each page and look for images and content?
menu.clickMenuItem("images");// TODO: Check for images menu item and click
// TODO: Add an set of images, edit the image fields, remove the images
menu.clickMenuItem("users");// TODO: Check for users menu item and click
// TODO: Add a set of users
// TODO: Click on each user and edit all fields and trigger password reset
// TODO: Reset logged in user password
// TODO: Delete set of users
menu.logout();



///////
/////// Registration Test
///////

// TODO: Open loginPage
// TODO: Click register link
// TODO: Register user function