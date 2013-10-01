/**
 * 
 * @author pkumar5
 * You are to design a simple Java program where you create two threads, Ping and Pong, to alternately display “Ping” and “Pong” respectively on the console.
 *   The program should create output that looks like this:
 *   Ready… Set… Go!
 *   Ping!
 *   Pong!
 *   Ping!
 *   Pong!
 *   Ping!
 *   Pong!
 *   Done!
 *   It is up to you to determine how to ensure that the two threads alternate printing on the console, and how to ensure that the main thread waits 
 *   until they are finished to print: “Done!”  The order does not matter (it could start with "Ping!" or "Pong!").
 *   
 *   Consider using any of the following concepts discussed in the videos:
 *   ·      wait() and notify()
 *   ·      Semaphores
 *   ·      Mutexes
 *   ·      Locks
 *   
 */
public class Program {

	public static void main(String[] args) {
		Program p = new Program();
	}
	
	public Program() {
		
        System.out.println("Ready… Set… Go!");

        PingPongThread ping = new Program.PingPongThread("Ping!");
        PingPongThread pong = new Program.PingPongThread("Pong!");

        ping.start();
		pong.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
        System.out.println("Done");
	}
	
	static final Object lock= new Object();    

	public class PingPongThread extends Thread {
		private String message;

		public PingPongThread(String message) {
			this.message = message;
		}

		public PingPongThread(){
			this.message = "NO!";
		}

		public void run() {
				for(int i = 0; i< 5;i++){
					synchronized(lock){
						System.out.println(""+ message);
						lock.notify();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}//synchronized end
				}//for loop end
	    }//run end
	}
}
