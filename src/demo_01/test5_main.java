package demo_01;


public class test5_main  {

	public static void main(String[] args) {
//		test5 td1=new test5("A线程");
//		test5 td2=new test5("B线程");
//		test5 td3=new test5("C线程");
//        td1.start();
//        td2.start();
//        td3.start();
		Object a = new Object();     
        Object b = new Object();     
        Object c = new Object();     
        test5 pa = new  test5("线程A", c, a);     
        test5 pb = new  test5("线程B", a, b);     
        test5 pc = new  test5("线程C", b, c);     
             
             
        new Thread(pa).start();//c a加锁，a输出'A'，a唤醒pb，a解锁（synchronized (a){}同步块结束），c.wait()->该线程pa等待（c暂时解锁，直至其它线程执行c.notify()之后，该线程pa才能继续执行（即被唤醒）---可以理解为等待c的通知）  
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//在单线程下，Thread.sleep（10000）让你的线程“睡眠”10000ms，也就是不工作，因为是单线程，所以要等到过了10000ms之后，该子线程继续工作。  
        //多线程下，睡眠的线程main先不工作，让其余的子线程先工作，等过了10000ms之后，它再重新回到线程的等待队伍中，开始工作。  
        //main睡眠10ms结束后，执行下面的语句，即new Thread(pb).start();----pb线程启动后，main再睡眠10ms，接着启动pc。这样不让pb和pc相邻启动，避免pc和pb竞争（因为开始时pc和pb都符合条件）  
        new Thread(pb).start();//a b加锁，b输出'B'，b唤醒pc，b解锁，a.wait()->该线程pb等待（c暂时解锁，直至其它线程执行a.notify()之后，该线程pb才能继续执行）  
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        new Thread(pc).start();//b c加锁，c输出'C'，c唤醒pa，c解锁，b.wait()->该线程pc等待（b暂时解锁，直至其它线程执行b.notify()之后，该线程pc才能继续执行）  
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
	}

}
