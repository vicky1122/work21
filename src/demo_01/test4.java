package demo_01;

import java.io.File;

/** *@author zhoumei E-mail:zm@qq.com @date ����ʱ�䣺2017��2��21������9:28:18*/
/*4����дɾ���ļ��Ĵ��룬���ж��ļ��Ƿ���ڣ��������������ʾ��*/
public class test4 {

	public static void main(String[] args) {
     File f=new File("c:\\a.txt");
     if(f.exists()!=true)
    	 System.out.println("�ļ�������");
     else
    	 System.out.println("�ļ�����");
     f.delete();
	}

}
