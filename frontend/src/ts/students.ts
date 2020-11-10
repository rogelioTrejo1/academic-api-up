// Images
import "../image/favicon.ico";
import "../image/webpack.png";

// Styles
import "bootswatch/dist/lux/bootstrap.min.css";
import "../sass/index.scss";

// Imports of application
import Api, { Student } from "../class/Api";
import Util from "../class/Util";

// Global Variables
const studentsContainer: HTMLElement = document.getElementById("studentsContainer") as HTMLElement;
const students: HTMLElement = document.getElementById("students") as HTMLElement;
const messgeContainer: HTMLElement = document.getElementById('messgeContainer') as HTMLElement;
const api: Api = new Api();

// Events

/**
 * 
 */
document.addEventListener("DOMContentLoaded", async () => {
    const studentsData: Student[] = await api.getStudents();

    if (studentsData.length > 0) {
        let template: string = "";
        studentsData.forEach(student => template += Util.makeStudent(student));
        studentsContainer.innerHTML = template;
        messgeContainer.style.display = "none";
    } else {
        students.style.display = "none";
    }
});


/**
 * 
 */
studentsContainer.addEventListener("click", (e: Event) => {
    const target: HTMLElement = e.target as HTMLElement;

    if (target.classList.contains("qualification")) {
        const btnShowQuali: HTMLButtonElement = target as HTMLButtonElement;
        window.location.href = `/student?up=${btnShowQuali.value}`;
    }
});