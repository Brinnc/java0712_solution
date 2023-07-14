package org.sp.app0712.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

//진행상황을 직관적으로 표현해주는 컴포넌트인 JProgressBar를 사용해보되,
//쓰레드를 이용해 서로 다른 속도와 크기로 동작하도록 해보자 (독립적 동작)
public class ProgressTest_mine extends JFrame{
	JProgressBar bar1;
	JProgressBar bar2;
	JProgressBar bar3;
	JButton bt;
	
	int n, n2, n3;
	BarThread_mine barThread_mine;
	
	public ProgressTest_mine() {
		bar1= new JProgressBar();
		bar2= new JProgressBar();
		bar3= new JProgressBar();
		bt=new JButton("START");
		
		barThread_mine=new BarThread_mine(this);
	
		
		//스타일
		bar1.setPreferredSize(new Dimension(480, 50));
		bar2.setPreferredSize(new Dimension(480, 50));
		bar3.setPreferredSize(new Dimension(480, 50));
		
		setLayout(new FlowLayout());

		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//버튼에 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("뿅");
				barThread_mine.start();
				
			}
		});
		
	}
	
	public void increaseBar1() {
		n+=10;
		bar1.setValue(n);
	}
	
	public void increaseBar2() {
		n2+=0.1;
		bar2.setValue(n2);
	}
	
	public void increaseBar3() {
		n3++;
		bar3.setValue(n3);
	} 
	
	public static void main(String[] args) {
		new ProgressTest_mine();
	}
}
