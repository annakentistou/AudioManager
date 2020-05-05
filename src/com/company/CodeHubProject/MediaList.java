package com.company.CodeHubProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class MediaList {
    private ArrayList<Media> media = new ArrayList<>();

    public void addMedia(Media archive) {
        media.add(archive);
    }

    public void readList() {
        media.forEach(System.out::println);
    }

    public void deleteList() {
        media.clear();
    }

    public int getTotalFiles() {
        int totalFiles;
        totalFiles = media.size();
        return totalFiles;
    }

    public float getTotalSize() {
        float totalSize = 0;
        for (int i = 0; i < media.size(); i++) {
            totalSize += media.get(i).getSize();
        }
        return totalSize;
    }

    public void saveMediaList(String filename) {
        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for (Media m : media) {

                printWriter.println(m.getName()
                        + ", " + m.getFiletype()
                        + ", " + m.getSize()
                        + ", " + m.getDateOfArchive()
                        + ", " + m.getDuration());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }

    }

    public Media searchMaxSize() {

        return media.stream().max(Comparator.comparing(Media::getSize)).get();

    }

    public Media searchMinDuration(){
        return media.stream().min(Comparator.comparing(Media::getDuration)).get();
    }

    public float totalDuration(){
        float totalDuration = 0.0f;
        for (int i = 0; i < media.size(); i++) {
            totalDuration += media.get(i).getDuration();
        }
        return totalDuration;
    }

    public float averageDuration() {
        float mediaListSize = 0.0f;
        float totalDuration = 0.0f;
        for (int i = 0; i < media.size(); i++) {
            totalDuration += media.get(i).getDuration();
        }
        mediaListSize = media.size();
        float averageDuration = totalDuration / mediaListSize;
        return averageDuration;
    }

   /* public void loadMediaList(String filename){
        //clear basket before loading
        media.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); //read a row
                String[] words = line.split(", ");
                Media archive = new Media(words[0],
                        words[1],
                        Float.parseFloat(words[2]),
                        Date.(words[3]),
                        Float.parseFloat(words[4]),
                        words[5]);
                media.add(archive);
            }


        } catch (Exception e) {
            System.out.println("File can't be loaded");

        }
    }*/
}
