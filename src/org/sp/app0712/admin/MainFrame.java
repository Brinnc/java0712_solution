package org.sp.app0712.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.sp.app0712.admin.page.BoardPage;
import org.sp.app0712.admin.page.CompanyPage;
import org.sp.app0712.admin.page.MemberPage;
import org.sp.app0712.admin.page.Page;
import org.sp.app0712.admin.page.ProductPage;

public class MainFrame extends JFrame implements ActionListener{
	ArrayList<JButton> menu; //어플리케이션의 네비게이션
	ImageIcon[] icon;
	
	JPanel p_north; //네비게이션이 올라갈 컨테이너
	JPanel p_center; //모든 컨텐츠의 페이지가 붙여질 컨테이너
	JScrollPane scroll;
	
	Page[] pages; //모든 페이지들을 담을 수 있는 페이지 배열
	
	public MainFrame() {
		menu=new ArrayList<JButton>();
		icon=new ImageIcon[4];
		pages=new Page[4];
		
		p_north=new JPanel();
		p_center=new JPanel();
		scroll=new JScrollPane(p_center);
		
		p_center.setBackground(Color.WHITE);
		
		createIcon(); //아이콘 생성하는 메서드 호출
		createPage(); //페이지화면 생성

		//버튼4개 생성
		for(int i=0; i<4; i++) {
			JButton bt=new JButton(icon[i]);
			menu.add(bt); //컬렉션에 추가
			p_north.add(bt);
			//menu[i].setPreferredSize(new Dimension(100, 100)); 이미지는 안줄고 메뉴버튼크기만 줄어듬
			
			//생성된 각 버튼에 리스너 연결
			bt.addActionListener(this);
		}
		
		
		//네비를 포함하고 있는 패널 북쪽에 부착
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		setSize(1000, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void createIcon() {
		String[] path= {"52634_box_empty_product_shipment_icon.png", 
				"2530821_business man_employee_general_human_member_icon.png", 
				"2247713_building_city_company_construction_icon.png", 
				"2064486_board_education_learn_school_student_icon.png"};
		
		for(int i=0; i<path.length; i++) {
			try {
				Image image=ImageIO.read(ClassLoader.getSystemResource("res/icon/"+path[i]));
				//크기 조정
				image=image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
				icon[i]=new ImageIcon(image);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createPage() {
		pages[0]=new ProductPage();
		pages[1]=new MemberPage();
		pages[2]=new CompanyPage();
		pages[3]=new BoardPage();
		
		for(int i=0; i<pages.length; i++) {
			p_center.add(pages[i]);
		}
	
	}
	
	//페이지 보이고 감추고 처리를 효율적으로 하는 메서드 정의
	//결론: 인덱스값은 보여주고 싶은 페이지의 인덱스를 넘기면됨, 인덱스는 버튼의 순번과 일치
	public void showHide(int index) {
		for(int i=0; i<pages.length; i++) {
			
			if(i==index) { //사용자가 누른 버튼의 index번째라면
				pages[i].setVisible(true);
			}else {
				pages[i].setVisible(false);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource(); //이벤트를 일으킨 컴포넌트 얻기
		
		//버튼 4개 중에 내가 누른 버튼의 인덱스값을 얻어오기
		int index=menu.indexOf(obj);
		System.out.println(index+"번째 버튼 뿅");
		
		showHide(index);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
