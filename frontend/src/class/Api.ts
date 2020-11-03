class Api {
    private URL: string;

    /**
     * 
     */
    constructor() {
        this.URL = process.env.URI_API as string || "http://localhost:3000/api";
    }

    /**
     * 
     */
    public async getStudents(): Promise<Student[]> {
        const resp: Response = await fetch(`${this.URL}/student`);
        const students: Student[] = await resp.json();
        return students;
    }

    /**
     * 
     * @param up 
     */
    public async getStudent(up: string): Promise<Student> {
        const resp: Response = await fetch(`${this.URL}/student/${up}`);
        const student: Student = await resp.json();
        return student;
    }

    

}

/**
 * 
 */
export interface Student {
    up: string;
    firstNames: string;
    lastNames: string;
    address: string;
    career: string;
    grade: number;
    group: string;
    qualifications: Qualification[];
}

/**
 * 
 */
export interface Qualification {
    idQuQualification: 2,
    up: string,
    idCourse: number,
    califUnit1: number,
    califUnit2: number,
    attendances: number,
}

/**
 * 
 */
export interface Course {
    idCourse: number,
    courseName: string,
    qualifications: Qualification[]
}


export default Api;