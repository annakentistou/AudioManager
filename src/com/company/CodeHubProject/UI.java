package com.company.CodeHubProject;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class UI {

    //UI return Choice
    public Choice menu() {
        Choice returnchoice;
        System.out.println("1. Create Medialist "
                + "2. Delete Medialist "
                + "3. Read Medialist "
                + "4. Save Medialist "
                + "5. Search a file with criteria in Medialist (max size, min duration)"
                + "6. Total Files "
                + "7. Total size of Medialist "
                + "8. Load from file "
                + "9. Total duration of Medialist"
                + "10. Average of duration "
                + "0. Exit");

        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt(); //system waiting for an integer
            switch (choice) {
                case 1:
                    return Choice.CREATE;
                case 2:
                    return Choice.DELETE;
                case 3:
                    return Choice.READ;
                case 4:
                    return Choice.SAVE;
                case 5:
                    return Choice.SEARCH;
                case 6:
                    return Choice.TOTALFILES;
                case 7:
                    return Choice.TOTALSIZE;
                case 8:
                    return Choice.LOAD;
                case 9:
                    return Choice.TOTALDURATION;
                case 10:
                    return Choice.AVERAGEDURATION;
                case 0:
                    return Choice.EXIT;
                default:
                    return Choice.ERROR;
            }
        } catch (Exception e) {
            return Choice.ERROR;
        }
    }

    public Media createMediaList() {
        String name;
        String filetype;
        float size;
        Date dateOfArchive = null;
        // int year, month, day;
        float duration;
        String producer;
        String composer;
        String photographer;
        int mediaType = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. For Videos 2. For Audio 3. For Images");
        mediaType = scanner.nextInt();

        System.out.println("Give filename");
        name = scanner.next();
        System.out.println("Give filetype");
        filetype = scanner.next();
        System.out.println("Give size in Mb");
        size = scanner.nextFloat();
        /*System.out.println("Give year");year = Integer.parseInt(scanner.next())-1900;
        System.out.println("Give month");month = Integer.parseInt(scanner.next())-1;
        System.out.println("Give day"); day = Integer.parseInt(scanner.next());
        dateOfArchive = new Date(year, month, day);*/


            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");//.format(dateOfArchive);
            System.out.println("Give Date in 'dd-MM-yyyy' format");
            String str = scanner.next();

        try {
            dateOfArchive = dateFormat.parse(str);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Media archive;
        switch (mediaType) {
            case 1:
                System.out.println("Give video's duration in sec ");
                duration = scanner.nextFloat();
                System.out.println("Give producer");
                producer = scanner.next();
                archive = new Videos(name, filetype, size, dateOfArchive, duration, producer);
                return archive;
            case 2:
                System.out.println("Give audio duration");
                duration = scanner.nextFloat();
                System.out.println("Give composer");
                composer = scanner.next();
                archive = new Audio(name, filetype, size, dateOfArchive, duration, composer);
                return archive;
            case 3:
                System.out.println("Give photographer");
                photographer = scanner.next();
                archive = new Images(name, filetype, size, dateOfArchive, photographer);
                return archive;
            default:
                return null;
        }
    }

    public void manageMediaList(MediaList mediaList) {
        Choice choice;
        do {
            choice = menu();

            switch (choice) {
                case EXIT:
                    break;
                case CREATE:
                    Media archive = createMediaList();
                    mediaList.addMedia(archive);
                    break;
                case DELETE:
                    mediaList.deleteList();
                    break;
                case READ:
                    mediaList.readList();
                    break;
                case SAVE:
                    mediaList.saveMediaList("media.txt");
                    break;
                case TOTALFILES:
                    System.out.println("Total Files: " + mediaList.getTotalFiles());
                    break;
                case TOTALSIZE:
                    System.out.println("Total size of files: " + mediaList.getTotalSize());
                    break;
                case TOTALDURATION:
                    System.out.println("Total duration: "+mediaList.toString());
                    break;
                case AVERAGEDURATION:
                    System.out.println("Average duration: "+mediaList.averageDuration());
                    break;
                case SEARCH:
                    Media maxSize = mediaList.searchMaxSize();
                    System.out.println("Max file size: "+ maxSize.getSize());
                    Media minDuration = mediaList.searchMinDuration();
                    System.out.println("Max file duration: " + minDuration.getDuration());
                    break;
                case LOAD:
                    //mediaList.loadMediaList("media.txt");
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;
            }
        } while (choice != Choice.EXIT);

    }

}