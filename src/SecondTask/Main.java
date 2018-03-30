package SecondTask;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        if (args[1].equals("-d")) {

            if (args.length == 3) {

                File dir = new File("C:\\users\\Nikesh\\IdeaProjects\\find\\");
                File file = new File(dir, args[args.length - 1]);

                if (file.exists()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    System.out.println("Файл отсутствует");
                }
            }

            if (args.length == 4) {

                File dir = new File(args[args.length - 2]);
                File file = new File(dir, args[args.length - 1]);

                if (file.exists()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    System.out.println("Файл отсутствует2");
                }
            }
        }

        if (args[1].equals("-r")) {

            if (args.length == 4) {

                File dir = new File("C:\\users\\nikesh\\IdeaProjects\\find\\");
                File file = new File(dir, args[args.length - 1]);

                String fileName = args[3];

                finder.findAll(dir, file, fileName);
            }

            if (args.length == 5) {

                File dir = new File(args[args.length - 2]);
                File file = new File(dir, args[args.length - 1]);

                String fileName = args[args.length - 1];


                //finder.findAll(dir, file, fileName);

                if (!finder.findAll(dir, file, fileName)) {
                    System.out.println("Файл не найден");
                } else {
                    System.out.println("");
                }
            }
        }
    }
}
