/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

/**
 *
 * @author jit
 */
public class Registrations {
    private int studentid;
    private int courseid ;
    private int semester;

    public Registrations() {
    }

    public Registrations(int studentid, int courseid, int semester) {
        this.studentid = studentid;
        this.courseid = courseid;
        this.semester = semester;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    
}
