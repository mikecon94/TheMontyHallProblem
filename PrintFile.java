import java.io.File;
import java.io.FileWriter;
public class PrintFile
{
  public static void main(String[] args) throws Exception
  {
    String printThis = "";
    for(int i = 0; i < 10000; i++)
    {
      printThis += "1\ny\n";
      printThis += "1\nn\n";
    }
    File newFile = new File("montyinput.txt");
    newFile.createNewFile();
    FileWriter writer = new FileWriter("montyinput.txt",false);
    writer.write(printThis);
    writer.close();
  }
}