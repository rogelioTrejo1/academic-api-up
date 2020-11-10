// Images
import "../image/favicon.ico";
import "../image/webpack.png";

// Styles
import "bootswatch/dist/lux/bootstrap.min.css";
import "../sass/index.scss";

import Api, { Student } from "../class/Api";

// Global Variables
const formNewStudent: HTMLFormElement = document.querySelector('#formNewStudent') as HTMLFormElement;
const api: Api = new Api();

// Events

formNewStudent.addEventListener('submit', (e: Event) => {
    const target: HTMLFormElement = e.target as HTMLFormElement;

    const formData: FormData = new FormData(target);
    let newStudent: Student = {
        up: formData.get('up') as string,
        fisrtNames: formData.get('firstNames') as string,
        lastNames: formData.get('lastNames') as string,
        address: formData.get('address') as string,
        career: formData.get('career') as string,
        grade: parseInt(formData.get('grade') as string),
        group: formData.get('group') as string
    };
    
    api.postStudent(newStudent)
        .then(() => window.location.href = "/students");
    
    e.preventDefault();
});