package com.iugu.model;

public class Email {

    private String id;
    private String identifier;
    private String template;
    private String subject;
    private Boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "EmailResponse{" +
                "id='" + id + '\'' +
                ", identifier='" + identifier + '\'' +
                ", template='" + template + '\'' +
                ", subject='" + subject + '\'' +
                ", active='" + active + '\'' +
                '}';
    }

}
