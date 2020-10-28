const fs = require("fs-extra");
const path = require("path");

// HTML
const fromIndexHTML = path.resolve(__dirname, "../dist/index.html");
const toIndexHTML = path.resolve(__dirname, "../../src/main/resources/templates") + "/index.html";

// CSS
const fromCSS = path.resolve(__dirname, "../dist/css");
const toCSS = path.resolve(__dirname, "../../src/main/resources/static/css");

// JS
const fromJS = path.resolve(__dirname, "../dist/js");
const toJS = path.resolve(__dirname, "../../src/main/resources/static/js");

// IMAGES
const fromImages = path.resolve(__dirname, "../dist/static");
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
    } catch (error) {
        console.log(error);
    }
};

// 
clearFolder();
setTimeout(() => {
    copyFiles();
    console.log("successfully copied files!!!!!")
}, 2000);