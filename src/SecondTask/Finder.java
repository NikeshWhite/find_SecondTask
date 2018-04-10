package SecondTask;

import java.io.File;
import java.util.ArrayList;

public class Finder {

    private static ArrayList<String> listOfWays = new ArrayList<>();

    public static ArrayList<String> getListOfWays() {
        return listOfWays;
    }

    public static void findAll(File dir, File targetFile, String fileName) {

        if (targetFile.exists()) {
            listOfWays.add(targetFile.getAbsolutePath());
        } else {

            String[] list = dir.list();

            if (list != null) {

                for (int i = 0; i < list.length; i++) {

                    File tempFile = new File(dir + "\\" + list[i]);
                    File file2 = new File(tempFile, fileName);

                    if (tempFile.isDirectory()) {
                        findAll(tempFile, file2, fileName);
                    }
                }
            }
        }
    }
}
