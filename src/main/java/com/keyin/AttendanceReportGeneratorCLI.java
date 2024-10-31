package com.keyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keyin.domain.report.ClassAttendanceReport;
import com.keyin.domain.report.StudentAttendanceReport;
import com.keyin.http.RESTClient;

public class AttendanceReportGeneratorCLI {
    private RESTClient restClient;

    public ClassAttendanceReport generateAttendanceReport() throws JsonProcessingException {
        return restClient.buildClassAttendanceReportFromResponse(restClient.getResponseFromHTTPRequest());
    }

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }


    public static void main(String[] args) throws Exception {
        for (String arg : args) {
            System.out.println(arg);
        }

        AttendanceReportGeneratorCLI cliApp = new AttendanceReportGeneratorCLI();

        String serverURL = args[0];

        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);


            ClassAttendanceReport classAttendanceReport = cliApp.generateAttendanceReport();

            System.out.println("Class Name: " + classAttendanceReport.getCourseName());
            System.out.println("Semester: " + classAttendanceReport.getSemester());
            System.out.println("Year: " + classAttendanceReport.getYear());
            System.out.println("Date of Class: " + classAttendanceReport.getClassOccurenceDate());

            System.out.println("----------------------");

            System.out.println("Student Attendance Report");

            System.out.println("----------------------");

            for (StudentAttendanceReport studentAttendanceReport : classAttendanceReport.getStudentAttendanceReports()) {
                System.out.println(studentAttendanceReport.getName() +
                        ", " + studentAttendanceReport.getEmailAddress() +
                        ", " + (studentAttendanceReport.isAttended() ? "P" : "A"));
            }
        }

    }

}
