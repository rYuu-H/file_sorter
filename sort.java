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
                return;
            }
            
        });
        subPaths.close();
        System.out.println("done!");
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

    void move(String path,String to) throws IOException{
        String fileExt = getFileExt(path);
        String toPath =to + "\\" + fileExt + "\\" + Paths.get(path).getFileName();
        
        File file = new File(path);
        File file1 = new File(toPath);
        if (file.isFile() && !file.isDirectory()) {
            int i = 0;
            while (file1.exists() && !(Files.size(file.toPath())==Files.size(file1.toPath()))){
                toPath =to + "\\" + fileExt + "\\" + i + Paths.get(path).getFileName();
                System.out.println("renamed "+ Paths.get(path).getFileName()+ " to " + i + Paths.get(path).getFileName());
                file1 = new File(toPath);
                i++;
            }
            if (file1.exists()){
                System.out.println("skipped file "+ path + " because is the same with " + toPath);
            }else{
                String dir = to + "\\" + fileExt; 
                new File(dir).mkdirs();
                Files.move(Paths.get(path),Paths.get(toPath));
                System.out.println("moved "+ path + " to " + toPath);

            }
        }
    }


}
