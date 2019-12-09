package com.iugu.model;

public class SendEmailTest {

    String to;

    public SendEmailTest() {
    }

    public SendEmailTest(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "SendEmailTest{" +
                "to='" + to + '\'' +
                '}';
    }

}
