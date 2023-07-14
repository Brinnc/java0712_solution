package org.sp.app0712.thread;

public class BarThread_mine extends Thread{
	ProgressTest_mine progressTest_mine;
	
	public BarThread_mine(ProgressTest_mine progressTest_mine) {
		this.progressTest_mine=progressTest_mine;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			progressTest_mine.increaseBar1();					
			progressTest_mine.increaseBar2();					
			progressTest_mine.increaseBar3();					
		}
	
	}

}
