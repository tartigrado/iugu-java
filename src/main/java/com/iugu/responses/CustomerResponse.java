package com.iugu.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResponse {

    private String id;
    private String email;
    private String name;
    private String notes;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("custom_variables")
    private List<CustomVariableResponse> customVariables;    
    @JsonProperty("cpf_cnpj")
    private String cpfCnpj;
    @JsonProperty("zip_code")
    private String zipCode;
    private String number;
    private String street;
    private String district;
    private String complement;
    private String city;
    private String state;
    private String phone_prefix;
    private String phone;
    private String cc_emails;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<CustomVariableResponse> getCustomVariables() {
        return customVariables;
    }

    public void setCustomVariables(List<CustomVariableResponse> customVariables) {
        this.customVariables = customVariables;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone_prefix() {
        return phone_prefix;
    }

    public void setPhone_prefix(String phone_prefix) {
        this.phone_prefix = phone_prefix;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCc_emails() {
        return cc_emails;
    }

    public void setCc_emails(String cc_emails) {
        this.cc_emails = cc_emails;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" + "id=" + id + ", email=" + email + ", name=" + name + ", notes=" + notes + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", customVariables=" + customVariables + ", cpfCnpj=" + cpfCnpj + ", zipCode=" + zipCode + ", number=" + number + ", street=" + street + ", district=" + district + ", complement=" + complement + ", city=" + city + ", state=" + state + ", phone_prefix=" + phone_prefix + ", phone=" + phone + ", cc_emails=" + cc_emails + '}';
    }

}
