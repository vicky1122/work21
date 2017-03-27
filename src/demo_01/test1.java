package demo_01;
/*新建一个文件a.txt，里面有如下内容
klediklew2323f0-=+
用字节流的一个个读取字符后输出，并按ASCII码排序输出
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;


public class test1 {

	public static void main(String[] args) {
    File f=new File("c:\\a.txt");
    String content="klediklew2323f0-=+";
    FileWriter fw;
	try {
		    fw = new FileWriter(f);
		    BufferedWriter bw=new BufferedWriter(fw);
		    bw.write(content);
		    bw.flush();
		    bw.close();
		    System.out.println(content);
		    int byteread=0;
		    InputStream in=new FileInputStream("c:\\a.txt");
		    while((byteread=in.read())!=-1){
		    	System.out.println(byteread);	
		    }
		  in.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
