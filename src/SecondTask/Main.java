package SecondTask;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        if (args[1].equals("-d")) {

            if (args.length == 3) {


                File defaultDir = new File("C:\\users\\Nikesh\\IdeaProjects\\find\\");
                File file = new File(defaultDir, args[args.length - 1]);

                if (file.exists()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    System.out.println("File not found");
                }
            }

            if (args.length == 4) {

                File dir = new File(args[args.length - 2]);
                File file = new File(dir, args[args.length - 1]);

                if (file.exists()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    System.out.println("File not found");
                }
            }
        }

        if (args[1].equals("-r")) {

            if (args.length == 4) {

                File defaultDir = new File("C:\\users\\nikesh\\IdeaProjects\\find\\");
                File file = new File(defaultDir, args[args.length - 1]);
                String fileName = args[args.length - 1];

                findAll(defaultDir, file, fileName);

                if (listOfWays.isEmpty()) {
                    System.out.println("Files bot found");
                } else {
                    System.out.println(listOfWays);
                }
            }

            if (args.length == 5) {

                File dir = new File(args[args.length - 2]);
                File file = new File(dir, args[args.length - 1]);
                String fileName = args[args.length - 1];

                findAll(dir, file, fileName);

                if (listOfWays.isEmpty()) {
                    System.out.println("Files not found");
                } else {
                    System.out.println(listOfWays);
                }
            }
        }
    }

    private static ArrayList<String> listOfWays = new ArrayList<>();

    public static ArrayList<String> getListOfWays () {
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
