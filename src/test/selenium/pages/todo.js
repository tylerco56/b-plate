const By = require("selenium-webdriver").By;

// The starting URL
const url = "http://localhost:8080/todo";

class Todo {
    constructor(driver) {
        this.driver = driver;
        this.locators = {
            checkOffField: task => By.xpath(`//label[text() = "${task}"]`)
        }
    }

    open() {
        this.driver.get(url);
    }

    createTask(task) {
        const newTaskInput = this.driver.findElement(By.name("description"));
        newTaskInput.sendKeys(task);
        newTaskInput.submit();
    }

    checkOffTask(task) {
        this.driver.findElement(this.locators.checkOffField(task)).click();
    }
}

module.exports = Todo;