package demo_01;

import java.io.File;

/** *@author zhoumei E-mail:zm@qq.com @date 创建时间：2017年2月21日下午9:28:18*/
/*4、编写删除文件的代码，并判断文件是否存在，如果不存在则提示。*/
public class test4 {

	public static void main(String[] args) {
     File f=new File("c:\\a.txt");
     if(f.exists()!=true)
    	 System.out.println("文件不存在");
     else
    	 System.out.println("文件存在");
     f.delete();
	}

}
