package com.keyin.domain.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassAttendanceReport {
    private String courseName;
    private String year;
    private String semester;
    private Date classOccurenceDate;

    private List<StudentAttendanceReport> studentAttendanceReports;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getClassOccurenceDate() {
        return classOccurenceDate;
    }

    public void setClassOccurenceDate(Date classOccurenceDate) {
        this.classOccurenceDate = classOccurenceDate;
    }

    public List<StudentAttendanceReport> getStudentAttendanceReports() {
        if (studentAttendanceReports == null) {
            studentAttendanceReports = new ArrayList<StudentAttendanceReport>();
        }

        return studentAttendanceReports;
    }

    public void setStudentAttendanceReports(List<StudentAttendanceReport> studentAttendanceReports) {
        this.studentAttendanceReports = studentAttendanceReports;
    }

}
