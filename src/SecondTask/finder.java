package SecondTask;

import java.io.File;

public class finder {

    public static void findAll (File dir, File targetFile, String fileName) {

        if (targetFile.exists()){
            System.out.println(targetFile.getAbsolutePath());
            System.exit(0);
        }

        else {

            String[] list = dir.list();

            if (list != null) {
                for (int i = 0; i < list.length; i++) {

                    File tempFile = new File(dir+"\\"+list[i]);
                    File file2 = new File(tempFile, fileName);
                    if (tempFile.isDirectory()) {
                        findAll(tempFile, file2, fileName);
                    }
                }
            }
        }
    }
}