import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class sort {
    sort(String from,String to) throws IOException{



        Path path = Paths.get(from);
        Stream<Path> subPaths =Files.walk(path);
        subPaths.forEach(e -> {
            try {
                move(e.toString(),to);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        subPaths.close();
        
    }

    String getFileExt(String file){
        String extension = "";

        int i = file.lastIndexOf('.');
        int p = Math.max(file.lastIndexOf('/'), file.lastIndexOf('\\'));

        if (i > p) {
            extension = file.substring(i+1);
        }
        
        return extension;
    }

    void move(String file,String to) throws IOException{
        String fileExt = getFileExt(file);
        String toPath ="D:\\test\\" + fileExt + "\\" + Paths.get(file).getFileName();
        int i = file.lastIndexOf('.');
        int p = Math.max(file.lastIndexOf('/'), file.lastIndexOf('\\'));
        if (i > p) {
            String dir = to + "\\" + fileExt; 
            new File(dir).mkdirs();
            Files.move(Paths.get(file),Paths.get(toPath));
        }
    }


}
