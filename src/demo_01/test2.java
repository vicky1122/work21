package demo_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*2、用字符流的方法实现把文件复制到指定路径
比如在C盘下有个test.txt的文件，内容随意，先用JAVA实现新建一个目录，C：/test
然后把文件通过字符流的方式复制到其下面，命名为test_copy.txt*/
public class test2 {

	public static void main(String[] args) throws IOException {
	File path = new File("c:\\test");
	if(path.exists()!=true)
		path.mkdir();	
    File f=new File("c:/a.txt");
    FileReader fr=new FileReader(f);
    BufferedReader br=new BufferedReader(fr);
	File f1=new File("c:\\test/test_copy.txt");
	FileWriter fw=new FileWriter(f1,true);//׷����filewrite����дtrue.
	BufferedWriter bw=new BufferedWriter(fw);
	String line=" ";
	while((line=br.readLine())!=null)
	{
		bw.write(line+"come on!");
		bw.newLine();
		bw.flush();
	}
	br.close();
	bw.close();//��Ϊ��ִ�������Σ������ı��������С�
	}
}
