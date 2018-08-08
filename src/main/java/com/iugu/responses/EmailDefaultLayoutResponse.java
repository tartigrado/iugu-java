package com.iugu.responses;

public class EmailDefaultLayoutResponse {

    private String subject;
    private String template;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "EmailDefaultLayoutResponse{" +
                "subject='" + subject + '\'' +
                ", template='" + template + '\'' +
                '}';
    }

}
