package com.example.dm_phonebook;

public class recycle_1_data {
    private String contact_name;
    private Integer contact_image;

    public recycle_1_data(){

    }

    public recycle_1_data(String contact_name, Integer contact_image) {
        this.contact_name = contact_name;
        this.contact_image = contact_image;
    }


    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public Integer getContact_image() {
        return contact_image;
    }

    public void setContact_image(Integer contact_image) {
        this.contact_image = contact_image;
    }
}
