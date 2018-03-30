package test;

import org.junit.Test;

import java.io.File;

import static SecondTask.Main.findAll;
import static SecondTask.Main.listOfWays;
import static org.junit.Assert.*;

public class findTest {

    @Test
    public void testFindD() {

        String[] testArgs;
        testArgs = "find -d firstFile.txt".split(" ");

        String[] testArgs2;
        testArgs2 = "find -d secondFile.txt".split(" ");

        File defaultDir = new File("C:\\Users\\Nikesh\\IdeaProjects\\find\\");

        File myFile = new File (defaultDir+"\\"+testArgs[testArgs.length - 1]);
        File myFile2 = new File(defaultDir+"\\"+testArgs2[testArgs2.length - 1]);

        assertTrue(myFile.exists());
        assertFalse(myFile2.exists());
    }

    @Test
    public void testFindDDirectory() {

        String[] testArgs;
        testArgs = "find -d C:\\Users\\Nikesh\\IdeaProjects\\find\\.idea\\ misc.xml".split(" ");

        String[] testArgs2;
        testArgs2 = "find -d C:\\Users\\Nikesh\\IdeaProjects\\find\\myDirectory\\ file.txt".split(" ");

        File thisDir1 = new File(testArgs[testArgs.length - 2]);
        File thisDir2 = new File(testArgs2[testArgs2.length - 2]);

        File myFile = new File (thisDir1+"\\"+testArgs[testArgs.length - 1]);
        File myFile2 = new File(thisDir2+"\\"+testArgs2[testArgs2.length - 1]);

        assertTrue(myFile.exists());
        assertFalse(myFile2.exists());
    }

/*
    @Test
    void testFindRD() {

    }

    @Test
    void testFindRDDirectory() {

    }
    */
}