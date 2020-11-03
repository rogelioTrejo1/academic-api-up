// Imports of application
import "./ts/scripts";

// Global Variables
const studentsContainer: HTMLElement = document.querySelector("#studentsContainer") as HTMLElement;

// Events
studentsContainer.addEventListener("click", (e: Event) => {
    const target: HTMLElement = e.target as HTMLElement;

    if (target.classList.contains("qualification")) {
        const btnShowQuali: HTMLButtonElement = target as HTMLButtonElement;

        window.location.href = `/student?up=${btnShowQuali.value}`;
    }
        
});