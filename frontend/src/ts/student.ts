// Images
import "../image/favicon.ico";
import "../image/webpack.png";

// Styles
import "bootswatch/dist/lux/bootstrap.min.css";
import "../sass/index.scss";

import "../image/perfil.png";
import Util from "../class/Util";
import Api, { Course, Qualification, Student } from "../class/Api";

// Global Variables
const qualifiContainer: HTMLElement = document.getElementById("qualifiContainer") as HTMLElement;
const informationStudent: HTMLElement = document.getElementById("informationStudent") as HTMLElement;
const qualifications: HTMLElement = document.getElementById("qualifications") as HTMLElement;
const messageContainer: HTMLElement = document.getElementById('messgeContainer') as HTMLElement;
const api: Api = new Api();

// Evets
document.addEventListener("DOMContentLoaded", async () => {
    // get the URL param for the peticion of the API
    const urlSplit: string[] = window.location.href.split("?");
    const params: string[] = urlSplit[1].split("=");
    const up: string = params[1];

    // Request all date about the student
    const student: Student = await api.getStudent(up);
    const courses: Course[] = await api.getCourses();

    // Create a templates
    const templateInformation: string = Util.makeStudentInformation(student);

    // Validate if the student does not have some qualificatios 
    if ((student.qualifications as Qualification[]).length > 0) {
        const templateQualification: string = Util.makeQualification(student.qualifications as Qualification[], courses);

        // Send the HTML Elements
        qualifiContainer.innerHTML = templateQualification;
        informationStudent.innerHTML = templateInformation;

        // Hiden the message container
        messageContainer.style.display = "none"

    } else {
        informationStudent.innerHTML = templateInformation;
        qualifications.style.display = "none";
    } 
});