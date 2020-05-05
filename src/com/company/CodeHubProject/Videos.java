package com.company.CodeHubProject;

import java.util.Date;

public class Videos extends Media{
    private float duration;
    private String producer;

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Videos(String name, String filetype, float size,Date dateOfArchive,float duration, String producer) {
        super(name, filetype, size, dateOfArchive);
        this.duration = duration;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return super.toString()+ " Videos{" +
                " duration=" + duration +
                ", producer='" + producer + '\'' +
                '}';
    }
}
