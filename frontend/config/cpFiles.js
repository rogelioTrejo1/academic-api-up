const fs = require("fs-extra");
const path = require("path");

// HTML
const fromIndexHTML = path.resolve(__dirname, "../dist/index.html");
const toIndexHTML = path.resolve(__dirname, "../../src/main/resources/templates") + "/index.html";
const fromStudentHTML = path.resolve(__dirname, "../dist/student.html");
const toStudentHTML = path.resolve(__dirname, "../../src/main/resources/templates") + "/student.html";
const fromNewStudentHTML = path.resolve(__dirname, "../dist/newStudent.html");
const toNewStudentHTML = path.resolve(__dirname, "../../src/main/resources/templates") + "/newStudent.html";
const fromStudentsHTML = path.resolve(__dirname, "../dist/students.html");
const toStudentsHTML = path.resolve(__dirname, "../../src/main/resources/templates") + "/students.html";

// CSS
const fromCSS = path.resolve(__dirname, "../dist/css");
const toCSS = path.resolve(__dirname, "../../src/main/resources/static/css");

// JS
const fromJS = path.resolve(__dirname, "../dist/js");
const toJS = path.resolve(__dirname, "../../src/main/resources/static/js");

// IMAGES
const fromImages = path.resolve(__dirname, "../dist/images");
const toImages = path.resolve(__dirname, "../../src/main/resources/static/images");

/**
 * 
 */
const clearFolder = async() => {
    try {
        await fs.remove(toCSS);
        await fs.remove(toJS);
        await fs.remove(toImages);
        await fs.remove(toIndexHTML);
        await fs.remove(toStudentsHTML);
        await fs.remove(toStudentHTML);
        await fs.remove(toNewStudentHTML);
    } catch (error) {
        console.error(error);
    }
};

/**
 * 
 */
const copyFiles = async() => {
    try {
        await fs.copy(fromCSS, toCSS);
        await fs.copy(fromJS, toJS);
        await fs.copy(fromImages, toImages);
        await fs.copy(fromIndexHTML, toIndexHTML);
        await fs.copy(fromStudentHTML, toStudentHTML);
        await fs.copy(fromStudentsHTML, toStudentsHTML);
        await fs.copy(fromNewStudentHTML, toNewStudentHTML);
    } catch (error) {
        console.log(error);
    }
};

// 
clearFolder();
setTimeout(() => {
    copyFiles();
    console.log("successfully copied files!!!!!");
}, 2000);