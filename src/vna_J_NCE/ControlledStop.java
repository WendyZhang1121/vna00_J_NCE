package vna_J_NCE;

final class ControlledStop implements Runnable {
	
	private boolean done = false;
	
	@Override public void run() { 
		
		while (!done) {
			try {
				// ...
				Thread.currentThread().sleep(1000); 
				// Do something 
				shutdown();			
				System.out.println(Thread.currentThread().getName());
				
			} catch(InterruptedException ie) {
				Thread.currentThread().interrupt(); // Reset interrupted status 
			}
		} 
	}
	public void shutdown() { 
		done = true;
	}
	
	public static void main(String[] args) throws Exception { 
		
		for (int i = 0; i < 3; i++) {
			ControlledStop cnTest = new ControlledStop();
			Thread t = new Thread (cnTest);
			t.start();
		}
	}
	
	}
