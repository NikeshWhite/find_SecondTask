package SecondTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Finder {

    private String[] args;
    private String line;

    public Finder(String[] args) {
        this.args = args;
    }
    public Finder(String line) {
        this.line = line;
    }

    public List<String> find() {

        List<String> answer = new ArrayList<>();

        if (args == null) {
            args = line.split(" ");
        }

        if (args.length == 2) {

            File defaultDir = new File(System.getProperty("user.dir"));
            File file = new File(defaultDir, args[args.length - 1]);

            if (file.exists()) {
                answer.add(file.getAbsolutePath());
            } else {
                answer.add("File not found");
            }
        }

        if (args.length == 4) {

            File dir = new File(args[args.length - 2]);
            File file = new File(dir, args[args.length - 1]);

            if (file.exists()) {
                answer.add(file.getAbsolutePath());
            } else {
                answer.add("File not found");
            }
        }

        if (args.length == 3) {

            File defaultDir = new File(System.getProperty("user.dir"));
            File file = new File(defaultDir, args[args.length - 1]);
            String fileName = args[args.length - 1];

            finderFiles(defaultDir, file, fileName);

            if (listOfWays.isEmpty()) {
                answer.add("Files not found");
            } else {
                answer = listOfWays;
            }
        }


        if (args.length == 5) {

            if (args[1].equals("-r")) {

                File dir = new File(args[args.length - 2]);
                File file = new File(dir, args[args.length - 1]);
                String fileName = args[args.length - 1];

                finderFiles(dir, file, fileName);

                if (listOfWays.isEmpty()) {
                    answer.add("Files not found");
                } else {
                    answer = listOfWays;
                }

            } else {

                File dir = new File(args[args.length - 3]);
                File file = new File(dir, args[args.length - 1]);
                String fileName = args[args.length - 1];

                finderFiles(dir, file, fileName);

                if (listOfWays.isEmpty()) {
                    answer.add("Files not found");
                } else {
                    answer = listOfWays;
                }
            }
        }
        return answer;
    }

    private List<String> listOfWays = new ArrayList<>();

    private void finderFiles(File dir, File targetFile, String fileName) {

        if (targetFile.exists()) {
            listOfWays.add(targetFile.getAbsolutePath());
        } else {

            String[] list = dir.list();

            if (list != null) {

                for (int i = 0; i < list.length; i++) {

                    File tempFile = new File(dir + "\\" + list[i]);
                    File file2 = new File(tempFile, fileName);

                    if (tempFile.isDirectory()) {
                        finderFiles(tempFile, file2, fileName);
                    }
                }
            }
        }
    }
}
