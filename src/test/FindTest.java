package test;

import org.junit.Test;
import java.io.File;
import java.util.ArrayList;

import static SecondTask.Main.findAll;
import static SecondTask.Main.getListOfWays;
import static org.junit.Assert.*;

public class FindTest {

    @Test
    public void testFindD() {

        String[] testArgs = "find firstFile.txt".split(" ");
        String[] testArgs2 = "find secondFile.txt".split(" ");

        File defaultDir = new File("C:\\Users\\Nikesh\\IdeaProjects\\find\\");

        File myFile = new File(defaultDir + "\\" + testArgs[testArgs.length - 1]);
        File myFile2 = new File(defaultDir + "\\" + testArgs2[testArgs2.length - 1]);

        assertTrue(myFile.exists());
        assertFalse(myFile2.exists());
    }

    @Test
    public void testFindDDirectory() {

        String[] testArgs = "find -d C:\\Users\\Nikesh\\IdeaProjects\\find\\.idea\\ misc.xml".split(" ");
        String[] testArgs2 = "find -d C:\\Users\\Nikesh\\IdeaProjects\\find\\myDirectory\\ file.txt".split(" ");

        File thisDir1 = new File(testArgs[testArgs.length - 2]);
        File thisDir2 = new File(testArgs2[testArgs2.length - 2]);

        File myFile = new File(thisDir1 + "\\" + testArgs[testArgs.length - 1]);
        File myFile2 = new File(thisDir2 + "\\" + testArgs2[testArgs2.length - 1]);

        assertTrue(myFile.exists());
        assertFalse(myFile2.exists());
    }


    @Test
    public void testFindRD() {

        String[] testArgs = "find -r file.txt".split(" ");

        File defaultDir = new File("C:\\Users\\Nikesh\\IdeaProjects\\find\\");

        File myFileTest11 = new File("C:\\Users\\Nikesh\\IdeaProjects\\find\\myDirectory\\firstDirectory\\" + testArgs[testArgs.length - 1]);
        File myFileTest12 = new File("C:\\Users\\Nikesh\\IdeaProjects\\find\\myDirectory\\secondDirectory\\" + testArgs[testArgs.length - 1]);

        File myFile = new File(defaultDir, testArgs[testArgs.length - 1]);

        String myFileName = testArgs[testArgs.length - 1];

        ArrayList<String> answer = new ArrayList<>();
        answer.add(myFileTest11.getAbsolutePath());
        answer.add(myFileTest12.getAbsolutePath());

        findAll(defaultDir, myFile, myFileName);

        assertEquals(answer, getListOfWays());

        getListOfWays().clear();
    }

    @Test
    public void testFindRDDirectory() {

        String[] testArgs = "find -r -d C:\\Users\\nikesh\\IdeaProjects\\find\\myDirectory file.txt".split(" ");

        File myFileTest11 = new File("C:\\Users\\nikesh\\IdeaProjects\\find\\myDirectory\\firstDirectory\\" + testArgs[testArgs.length - 1]);
        File myFileTest12 = new File("C:\\Users\\nikesh\\IdeaProjects\\find\\myDirectory\\secondDirectory\\" + testArgs[testArgs.length - 1]);

        File myDir1 = new File(testArgs[testArgs.length - 2]);

        File myFile1 = new File(testArgs[testArgs.length - 1]);

        String myFileName1 = testArgs[testArgs.length - 1];

        ArrayList<String> answer = new ArrayList<>();
        answer.add(myFileTest11.getAbsolutePath());
        answer.add(myFileTest12.getAbsolutePath());

        findAll(myDir1, myFile1, myFileName1);

        assertEquals(answer, getListOfWays());

        getListOfWays().clear();
    }

}