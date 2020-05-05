package com.company.CodeHubProject;

import java.util.Date;

public abstract class Media {

    private String name;
    private String filetype;
    private float size;
    private Date dateOfArchive;
    private float duration;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public float getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    public Date getDateOfArchive() {
        return dateOfArchive;
    }

    public void setDateOfArchive(Date dateOfArchive) {
        this.dateOfArchive = dateOfArchive;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }


    public Media(String name, String filetype, float size, Date dateOfArchive, float duration) {
        this.name = name;
        this.filetype = filetype;
        this.size = size;
        this.dateOfArchive = dateOfArchive;
        this.duration = duration;
    }

    public Media(String name, String filetype, float size, Date dateOfArchive) {
        this.name = name;
        this.filetype = filetype;
        this.size = size;
        this.dateOfArchive = dateOfArchive;
    }
    @Override
    public String toString() {
        return "Media{" +
                "name='" + name + '\'' +
                ", filetype='" + filetype + '\'' +
                ", size=" + size +
                ", dateOfArchive=" + dateOfArchive +
                //", duration=" + duration +
                '}';
    }
}
