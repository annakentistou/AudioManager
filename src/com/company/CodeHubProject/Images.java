package com.company.CodeHubProject;

import java.util.Date;

public class Images extends Media{

   private String photographer;

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public Images(String name, String filetype, float size, Date dateOfArchive, String photographer) {
        super(name, filetype, size, dateOfArchive);
        this.photographer = photographer;
    }

    @Override
    public String toString() {
        return super.toString()+" Images{" +
                " photographer='" + photographer + '\'' +
                '}';
    }
}
