package test;

import SecondTask.Finder;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FindTest {

    @Test
    public void testFind() {

        var fileN1 = new Finder("find firstFile.txt");
        var fileN2 = new Finder("find -d " + System.getProperty("user.dir") + "\\myDirectory file.txt");
        var fileN3 = new Finder("find -d " + System.getProperty("user.dir") + "\\myDirectory\\firstDirectory myFile.txt");
        var fileN4 = new Finder("find -d " + System.getProperty("user.dir") + "\\myDirectory\\firstDirectory file.txt");
        var fileN5 = new Finder("find -r file.txt");
        var fileN6 = new Finder("find -r deletedFile.txt");
        var fileN7 = new Finder("find -r -d " + System.getProperty("user.dir") + " file.txt");
        var fileN8 = new Finder("find -d " + System.getProperty("user.dir") + " -r file.txt");

        var fileN9 = new Finder("find -d " + System.getProperty("user.dir") + "\\myDirectory\\oneMoreDirectory myFile.txt");
        var fileNS = new Finder("find -d " + System.getProperty("user.dir") + "\\myDirectory\\hiddenDirectory myFile.txt");
        var fileNS1 = new Finder("find -d " + System.getProperty("user.dir") + "\\notMyDirectory\\hiddenDirectory myFile.txt");

        var defaultDirectory = System.getProperty("user.dir");

        var fileA1 = new File(defaultDirectory, "firstFile.txt");
        var fileA4 = new File(defaultDirectory + "\\myDirectory\\firstDirectory", "file.txt");
        var fileA51 = new File(defaultDirectory + "\\myDirectory\\firstDirectory", "file.txt");
        var fileA52 = new File(defaultDirectory + "\\myDirectory\\secondDirectory", "file.txt");
        var fileA71 = new File(defaultDirectory + "\\myDirectory\\firstDirectory", "file.txt");
        var fileA72 = new File(defaultDirectory + "\\myDirectory\\secondDirectory", "file.txt");
        var fileA81 = new File(defaultDirectory + "\\myDirectory\\firstDirectory", "file.txt");
        var fileA82 = new File(defaultDirectory + "\\myDirectory\\secondDirectory", "file.txt");

        var answer1 = new ArrayList<>();
        answer1.add(fileA1.getAbsolutePath());

        var answer2 = new ArrayList<>();
        answer2.add("File not found");

        var answer3 = new ArrayList<>();
        answer3.add("File not found");

        var answer4 = new ArrayList<>();
        answer4.add(fileA4.getAbsolutePath());

        var answer5 = new ArrayList<>();
        answer5.add(fileA51.getAbsolutePath());
        answer5.add(fileA52.getAbsolutePath());

        var answer6 = new ArrayList<>();
        answer6.add("Files not found");

        var answer7 = new ArrayList<>();
        answer7.add(fileA71.getAbsolutePath());
        answer7.add(fileA72.getAbsolutePath());

        var answer8 = new ArrayList<>();
        answer8.add(fileA81.getAbsolutePath());
        answer8.add(fileA82.getAbsolutePath());

        var answer9 = new ArrayList<>();
        answer9.add("File not found");

        var answerS = new ArrayList<>();
        answerS.add("File not found");

        var answerS1 = new ArrayList<>();
        answerS1.add("File not found");

        assertEquals(answer1, fileN1.find());
        assertEquals(answer2, fileN2.find());
        assertEquals(answer3, fileN3.find());
        assertEquals(answer4, fileN4.find());
        assertEquals(answer5, fileN5.find());
        assertEquals(answer6, fileN6.find());
        assertEquals(answer7, fileN7.find());
        assertEquals(answer8, fileN8.find());
        assertEquals(answer9, fileN9.find());
        assertEquals(answerS, fileNS.find());
        assertEquals(answerS1, fileNS1.find());
    }
}