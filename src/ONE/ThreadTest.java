package ONE;

public class ThreadTest {
	private int j;
	public static void main(String[] args) {
		ThreadTest th = new ThreadTest();
		Inc inc = th.new Inc();
		Dec dec = th.new Dec();
		for(int a=0;a<2;a++){
			Thread t=new Thread(inc);
			t.start();
			t=new Thread(dec);
			t.start();
		}
	}
	public synchronized void inc(){
		j++;
		System.out.println(Thread.currentThread().getName()+"inc:"+j);
	}
	public synchronized void dec(){
		j--;
		System.out.println(Thread.currentThread().getName()+"dec:"+j);
	}
	class Inc implements Runnable{
		public void run() {
			for(int a=0;a<100;a++)
			inc();
		}
	}
	class Dec implements Runnable{
		public void run() {
			for(int a=0;a<100;a++)
			dec();
		}
	}
	
	
	
	
	
	
	}