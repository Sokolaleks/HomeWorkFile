import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        List<File> dir = Arrays.asList(new File("/Users/admin/Games/src"),
                new File("/Users/admin/Games/res"),
                new File("/Users/admin/Games/savegames"),
                new File("/Users/admin/Games/temp"),
                new File("/Users/admin/Games/src/main"),
                new File("/Users/admin/Games/src/test"),
                new File("/Users/admin/Games/res/drawables"),
                new File("/Users/admin/Games/res/vectors"),
                new File("/Users/admin/Games/res/icons"));
        List<File> file = Arrays.asList(new File("/Users/admin/Games/src/main/Main.java"),
                new File("/Users/admin/Games/src/main/Utils.java"),
                new File("/Users/admin/Games/temp/temp.txt"));

        dirSb(stringBuilder, dir);
        fileSb(stringBuilder, file);
        Writer(stringBuilder.toString());


    }

    public static boolean createDir(File file) {
        return file.mkdir();
    }

    public static boolean createFile(File file) {
        try {
            if (file.createNewFile()) {
                //  System.out.println("Файл был создан");
                return true;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    public static void Writer(String temp) {
        try (FileWriter writer = new FileWriter("/Users/admin/Games/temp/temp.txt", true)) {
            writer.write(temp);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void dirSb(StringBuilder stringBuilder, List<File> dir) {
        for (File x : dir) {
            if (createDir(x)) {
                stringBuilder.append("Каталог ");
                stringBuilder.append(x.getName());
                stringBuilder.append(" создан");
                stringBuilder.append('\n');
            } else {
                stringBuilder.append("Ошибка создания каталога ");
                stringBuilder.append(x.getName());
                stringBuilder.append('\n');
            }
        }

    }

    public static void fileSb(StringBuilder stringBuilder, List<File> file) {
        for (File y : file) {
            if (createFile(y)) {
                stringBuilder.append("Файл ");
                stringBuilder.append(y.getName());
                stringBuilder.append(" создан");
                stringBuilder.append('\n');
            } else {
                stringBuilder.append("Ошибка создания файла ");
                stringBuilder.append(y.getName());
                stringBuilder.append('\n');
            }
        }
    }

}
