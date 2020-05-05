package com.company.CodeHubProject;

import java.util.Date;

public class Audio extends Media{
    private float duration;
    private String composer;

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Audio(String name, String filetype, float size,Date dateOfArchive,float duration, String composer) {
        super(name, filetype, size, dateOfArchive);
        this.composer = composer;
    }

    @Override
    public String toString() {
        return super.toString()+" Audio{" +
                "duration=" + duration +
                ", composer='" + composer + '\'' +
                '}';
    }
}
