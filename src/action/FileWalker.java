package action;

import java.io.File;
import java.io.FileFilter;

public class FileWalker {
  public void walk(String path) {

    class MyFilter implements FileFilter {
      public boolean accept(File file) {
        return !file.isHidden() && file.getName().endsWith(".txt");
      }
    }
    
    File root = new File(path);
    File[] list = root.listFiles(new MyFilter());

    if (list == null)
      return;

    for (File f : list) {
      if (f.isDirectory()) {
        walk(f.getAbsolutePath());
        System.out.println("Dir:" + f.getAbsoluteFile());
      } else {
        System.out.println("File:" + f.getAbsoluteFile());
      }
    }
  }

  public static void main(String[] args) {
    FileWalker fw = new FileWalker();
    fw.walk("c:\\");
  }
}