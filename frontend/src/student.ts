// Imports
import "./ts/scripts";
import "./image/perfil.png";

// Global Variables
const studentContainer: HTMLElement = document.querySelector("#studentConteiner") as HTMLElement;

// Evets
document.addEventListener("DOMContentLoaded", () => {
    const urlSplit: string[] = window.location.href.split("?");
    const params: string[] = urlSplit[1].split("=");

    console.log(params);
})