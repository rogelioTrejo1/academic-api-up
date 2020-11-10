import Api, { Course, Qualification, Student } from "../class/Api";

class Util {
    private static api: Api = new Api();


    /**
     * 
     * @param student 
     */
    public static makeStudent(student: Student): string {
        const htmlStudent: string = `
            <div class="col-3 mb-2">
                <div class="card card-body">
                    <div class="form-group">
                        <img class="w-50 centerX-relative" src="images/perfil.png" alt="">
                    </div>
                    <p>Name: <span>${student.fisrtNames}</span> <span>${student.lastNames}</span></p>
                    <p>UP: <span>${student.up}</span></p>
                    <p>Grade and Group: <span>${student.career}</span><span>0${student.grade}</span><span>${student.group}</span></p>
                    <button value="${student.up}" type="button" class="btn btn-block btn-sm btn-primary qualification">Show
                        Qualifications</button>
                </div>
            </div>
        `;
        return htmlStudent;
    }

    /**
     * 
     * @param student 
     */
    public static makeStudentInformation(student: Student): string {
        const htmlStudentInformation: string = `
            <p>Name: <span>${student.fisrtNames}</span> <span>${student.lastNames}</span></p>
            <p>UP: <span>${student.up}</span></p>
            <p>Address: <span>${student.address}</span></p>
            <p>Grade and Group: <span>${student.career}</span><span>0${student.grade}</span><span>${student.group}</span></p>
        `;

        return htmlStudentInformation;
    }

    /**
     * 
     * @param student 
     * @param course 
     */
    public static makeQualification(qualifications: Qualification[], courses: Course[]): string {
        let template: string = "";
    
        courses.forEach(course => {
            qualifications.forEach(({ idQualification, idCourse, califUnit1, califUnit2, attendances }) => {
                if (course.idCourse == idCourse)
                    template += `
                        <tr>
                            <td>${idQualification}</td>
                            <td>"${course.courseName}</td>
                            <td>${califUnit1}</td>
                            <td>${califUnit2}</td>
                            <td>${attendances}</td>
                            <td>${this.avg(califUnit1 as number, califUnit2 as number)}</td>
                        </tr>
                    `;
            });
        });

        return template;
    }

    private static avg(...values: number[]): number {
        return values.reduce(value => value + value) / values.length;
    }

}

export default Util;