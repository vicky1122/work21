package demo_01;
/*建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，打印10次ABC*/
//public class test5 extends Thread {
//    public test5(String name)
//    {
//    	super(name);
//    	for(int i=1;i<=10;i++)
//		{
//			System.out.println(getName()+":     A");	
//        }
//    	for(int i=1;i<=10;i++)
//    	{
//    		System.out.println(getName()+":     B");	
//    	}
//    	for(int i=1;i<=10;i++)
//    	{
//    		System.out.println(getName()+":     C");	
//    	}
//    }
//	public void run()
//	{
//		System.out.println("Child thread"+getName());
//	}
//
//}



public class test5 implements Runnable {     
    
    private String name;     
    private Object prev;     
    private Object self;     
    
    test5(String name, Object prev, Object self) {     
        this.name = name;     
        this.prev = prev;     
        this.self = self;     
    }     
    
    @Override    
    public void run() {     
        int count = 10;     
        while (count > 0) {     
            //同步块，加锁  
            synchronized (prev) {     
                synchronized (self) {     
                    System.out.print(name);     
                    count--;    
                   /* try{ 
                    Thread.sleep(1); 
                    } 
                    catch (InterruptedException e){ 
                     e.printStackTrace(); 
                    }*/  
                      
                    self.notify(); //唤醒在此对象监视器上等待的单个线程（即等待给self加锁的线程）。假如多个线程都在此对象上等待，则会挑选唤醒其中一个线程。  
                }//self解锁，被唤醒的线程此时可以给self加锁了。     
                try {     
                    prev.wait();   //该线程暂时释放prev的锁，等待再次获得prev的锁，然后执行下面的语句。此时prev还需要被唤醒  
                } catch (InterruptedException e) {     
                    e.printStackTrace();     
                }     
            }     
    
        }     
    }
}
