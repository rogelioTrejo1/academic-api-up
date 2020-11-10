class Api {
    private URL: string;

    /**
     * Create a connection with the api
     */
    constructor() {
        this.URL = process.env.URI_API as string || "http://localhost:3000/api";
    }

    /**
     * Request all Students in the API
     */
    public async getStudents(): Promise<Student[]> {
        const resp: Response = await fetch(`${this.URL}/student`);
        const students: Student[] = await resp.json();
        return students;
    }

    /**
     * Request a specific Student in the API
     * @param up ID of the Student
     */
    public async getStudent(up: string): Promise<Student> {
        const resp: Response = await fetch(`${this.URL}/student/${up}`);
        const student: Student = await resp.json();
        return student;
    }

    /**
     * Request all Courses in the API
     */
    public async getCourses() {
        const resp: Response = await fetch(`${this.URL}/course`);
        const courses: Course[] = await resp.json();
        return courses;
    }

    /**
     * Send a new Student to the API to save into itself
     * @param student Data of the new Student
     */
    public async postStudent(newStudent: Student): Promise<Student> {
        const resp: Response = await fetch(`${this.URL}/student`, {
            method: "POST",
            body: JSON.stringify(newStudent),
            headers: {
                "Content-Type": "application/json"
            }
        });
        const student: Student = await resp.json();
        return student;
    }

    /**
     * Send a new Qualification to save into itself
     * @param newQualification Data of the new Qualification
     */
    public async postQualification(newQualification: Qualification) {
        const resp: Response = await fetch(`${this.URL}/qualification`, {
            method: "POST",
            body: JSON.stringify(newQualification),
            headers: {
                "Content-Type": "application/json"
            }
        });
        const qualification: Qualification = await resp.json();
        return qualification;
    }    

}

/**
 * 
 */
export interface Student {
    up?: string;
    fisrtNames?: string;
    lastNames?: string;
    address?: string;
    career?: string;
    grade?: number;
    group?: string;
    qualifications?: Qualification[];
}

/**
 * 
 */
export interface Qualification {
    idQualification?: number,
    up?: string,
    idCourse?: number,
    califUnit1?: number,
    califUnit2?: number,
    attendances?: number,
}

/**
 * 
 */
export interface Course {
    idCourse?: number,
    courseName?: string,
    qualifications?: Qualification[]
}


export default Api;