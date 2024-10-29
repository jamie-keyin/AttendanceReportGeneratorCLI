package com.keyin;

import com.keyin.http.RESTClient;

public class AttendanceReportGeneratorCLI {
    private RESTClient restClient;

    public String generateAttendanceReport() {
        return restClient.getResponseFromHTTPRequest();
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


    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        AttendanceReportGeneratorCLI cliApp = new AttendanceReportGeneratorCLI();

        String serverURL = args[0];

        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);

            System.out.println(cliApp.generateAttendanceReport());
        }

    }

}
