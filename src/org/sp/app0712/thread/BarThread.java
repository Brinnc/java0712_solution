package org.sp.app0712.thread;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JProgressBar;

public class BarThread extends Thread{
	int interval;
	JProgressBar bar;
	int n;
	
	public BarThread(int interval, JProgressBar bar) {
		this.interval=interval;
		this.bar=bar;
	}

	public void increase() {
		n++;
		bar.setValue(n);
		bar.setString(Integer.toString(n));
		bar.setStringPainted(true);
		bar.setBackground(Color.YELLOW);
		bar.setForeground(Color.RED);
		bar.setFont(new Font("돋움", Font.BOLD, 25));
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			increase();
		}
	
	}

}
