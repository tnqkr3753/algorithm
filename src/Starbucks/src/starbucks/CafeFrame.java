package starbucks;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class CafeFrame extends JFrame implements ActionListener, ListSelectionListener {
	ArrayList<String> orderList = new ArrayList<String>();
	ArrayList<Menu> menuList = new ArrayList<Menu>();//가게에 있는 메뉴들 모음
	String[] menuName = {"나이트로 바닐라 크림","제주 비자림 콜드 브루","나이트로 쇼콜라 클라우드","돌체 콜드 브루"
			,"바닐라 크림 콜드 브루","콜드 브루","아이스 커피","오늘의 커피","아이스 슈 크림 라떼"
			,"에스프레소 콘 파나","에스프레소 마키아또","카페 아메리카노","블론드 카라멜 클라우드 마키아또"
			,"블로드 코코아 클라우드 마키아또","진한 가나슈 루비 케이크","7레이어 가나슈 케이크","DT밀당 케이크_레드벨벳"
			,"레드벨벳 크림치즈 케이크","리얼 피칸 타르트","마스카포네 티라미수 케이크"};
	String[] image = {"imgs/c_nitro.png","imgs/c_visa.png","imgs/c_cloud.png","imgs/c_dol.png",
			"imgs/c_bcc.png","imgs/c_cold.png","imgs/b_ameri.png","imgs/b_today.png",
			"imgs/es_cream.png","imgs/es_con.png","imgs/es_macchi.png","imgs/es_cafeame.png",
			"imgs/es_caramel.png","imgs/es_coco.png","imgs/ck_1.png","imgs/ck_2.png","imgs/ck_3.png","imgs/ck_4.png","imgs/ck_5.png","imgs/ck_6.png"};
	int[] menuPrice = new int[] {5000,7000,5000,6000,7500,4500,4000,3500,6500,5500,4000,5300,8000,8000,18000,19000,15000
			,18500,20000,17000};
	JCheckBox[] cb = new JCheckBox[3];
	JButton[] bt = new JButton[20];  
	JPanel j1,listEastP;
	JPanel [] jp = new JPanel[4];
	JList<String> list;
	JLabel[] jl = new JLabel[4];
	JLabel[] item = new JLabel[4];
	int total = 0;
	JButton btDel,btFin;
	ImageIcon icon ;
	public CafeFrame(){
		icon = (ImageIcon) resizeIcon("imgs/Starbucks.png", 50, 50);
		setLayout(new BorderLayout());//전체 레이아웃 추가
		for (int i = 0; i < jp.length; i++) {//콜드브루,브루드,에스프레소,케익 패널 생성 레이아웃 추가
			jp[i] = new JPanel();
			jp[i].setLayout(new GridLayout(2,3));
		}
		for (int i = 0; i < menuName.length; i++) { //메뉴만들기 //버튼에 이름넣기 , 이미지 추가해야함//판넬에 버튼 생성
			JPanel jpb = new JPanel();
			jpb.setLayout(new BorderLayout());
			jpb.setBackground(Color.BLACK);
			jpb.add(new JLabel(resizeIcon(image[i],300,280)),BorderLayout.CENTER);
			if(i<6) {
				menuList.add(new Coffee(menuName[i], menuPrice[i], 'd'));
				bt[i] = new JButton(menuList.get(i).getName(),icon);
				jpb.add(bt[i],BorderLayout.SOUTH);
//				jp[0].add(bt[i]);
				jp[0].add(jpb);
			}
			else if(i>=6&i<8) {
				menuList.add(new Coffee(menuName[i], menuPrice[i], 'b'));
				bt[i] = new JButton(menuList.get(i).getName(),icon);
				jpb.add(bt[i],BorderLayout.SOUTH);
//				jp[1].add(bt[i]);
				jp[1].add(jpb);
			}
			else if(i>=8&i<14) {
				menuList.add(new Coffee(menuName[i], menuPrice[i], 'e'));
				bt[i] = new JButton(menuList.get(i).getName(),icon);
				jpb.add(bt[i],BorderLayout.SOUTH);
//				jp[2].add(bt[i]);
				jp[2].add(jpb);
			}
			else if(i>=14&i<20) {
				menuList.add(new Cake(menuName[i], menuPrice[i]));
				bt[i] = new JButton(menuList.get(i).getName(),icon);
				jpb.add(bt[i],BorderLayout.SOUTH);
//				jp[3].add(bt[i]);
				jp[3].add(jpb);
			}
			bt[i].setPreferredSize(new Dimension(200, 100));
			bt[i].setBackground(Color.WHITE);
		}
		//브루드 패널 남은공간 null 채우기
		for (int i = 0; i < 4; i++) {
			jp[1].add(new JButton("NULL"));
		}
		JTabbedPane pane = new JTabbedPane();//탭만들기
		JTabbedPane paneDrink = new JTabbedPane(); //음료 탭
		j1 = new JPanel();//J1 음료부분 패널
		j1.setLayout(new BorderLayout());//음료 패널 레이아웃
		String[] paneName = {"콜드","브루드","에스프레소"}; //팬버튼이름배열
		j1.add(paneDrink,BorderLayout.CENTER);//센터에 탭 생성
		for (int i = 0; i < paneName.length; i++) {//탭에 각 종류별 탭 생성
			paneDrink.add(jp[i],paneName[i]);
		}
		pane.add(j1,"커피");
		pane.add(jp[3],"케이크");
		add(pane,BorderLayout.CENTER);
		
		JPanel listPan = new JPanel();//왼쪽 주문목록 추가
		listPan.setLayout(new BorderLayout());//주문목록패널 레이아웃추가
		JPanel labelJ = new JPanel();//라벨 넣을 판넬
		listEastP = new JPanel();//리스트의 오른쪽에 들어갈 판넬
		listEastP.setLayout(new GridLayout(6,1));
		for (int i = 0; i < jl.length; i++) {//라벨 객체생성 총가격,총수량 하나당 가격 이름
			jl[i] = new JLabel();
			item[i]= new JLabel();
			listEastP.add(item[i]);
			labelJ.add(jl[i]);
		}
		//주문리스트 위에 총개수,가격 label
		jl[0].setText("주문 개수");
		jl[1].setText(String.valueOf(orderList.size()));
		jl[2].setText("총 가격");
		jl[3].setText(String.valueOf(total));
		item[0].setText("     상품이름     ");
		item[1].setText("이름");
		item[2].setText("     상품가격     ");
		item[3].setText("가격");
		//삭제,결제 버튼 객체 생성
		btDel = new JButton("삭제");
		btFin = new JButton("결제");
		list = new JList<String>();//주문목록 list 객체 생성
		list.setPreferredSize(new Dimension(200, 1000));
		listEastP.add(btDel);listEastP.add(btFin);//패널에 버튼 추가
		listEastP.setPreferredSize(new Dimension(150, 1000));
		listPan.add(new JLabel("선택 상품 목록"),BorderLayout.NORTH);
		listPan.add(labelJ,BorderLayout.SOUTH);//라벨 판넬 list판넬에 추가
		listPan.add(new JScrollPane(list),BorderLayout.CENTER);//주문목록 list를 스크롤팬에 넣어 listPan의 센터에 추가
		listPan.add(listEastP,BorderLayout.EAST);//개당가격판넬 listPan에 추가
		add(listPan,BorderLayout.EAST);
	}
	void display(){
		setSize(1500,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void eventProc() {
		for (int i = 0; i < bt.length; i++) {
			bt[i].addActionListener(this);
		}
		list.addListSelectionListener(this);
		btDel.addActionListener(new ActionListener() { //삭제 버튼 액션 리스너
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(null, list.getSelectedValue()+"를 취소하시겠습니까?")==JOptionPane.OK_OPTION) {
					orderList.remove(orderList.indexOf(list.getSelectedValue()));
					String[] arr =setList();
					getTotal(arr);
				}
			}
		});
		btFin.addActionListener(new ActionListener() { //결제 버튼 액션 리스너
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < orderList.size(); i++) { //StringBuffer에 모든 메뉴들개행포함 저장
					sb.append(orderList.get(i)+"\n");
				}
				if(JOptionPane.showConfirmDialog(null, sb.toString()+"결제금액 : "+total+"\n를 결제하시겠습니까?")==JOptionPane.OK_OPTION) { //ok버튼을 누르면
					JOptionPane.showMessageDialog(null, "결제되었습니다.\n3초 후프로그램이 종료됩니다.");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
					//영수증?
					
				}
			}
		});
	}
	void getTotal(String[] arr) { //총가격 구하는 메소드
		total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += getItemPrice(arr[i]);
		}
		jl[3].setText(String.valueOf(total));
	}
	String[] setList() { //리스트에 배열 재구성
		String[] arr = new String[orderList.size()];//리스트에 들어갈 String배열
		for (int j = 0; j < orderList.size(); j++) {//String배열에 orderList에 있는 값들 넣기
			arr[j] = orderList.get(j);
		}
		jl[1].setText(String.valueOf(orderList.size()));
		list.setListData(arr);
		return arr;
	}
	int getItemPrice(String name) { //선택한 아이템의가격 반환하는 메소드
		int price = -1;
		for (int i = 0; i < menuList.size(); i++) {
			if(menuList.get(i).getName().equals(name)) {
				price = menuList.get(i).getPrice();
				break;
			}
		}
		return price;
	}
	Icon resizeIcon(String image, int resizedWidth, int resizedHeight) {
			Image img = new ImageIcon(image).getImage();  
	       Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	       return new ImageIcon(resizedImage);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 눌렀을 때
		Object evt = e.getSource(); //누른버튼 값을 object evt에 저장
		for (int i = 0; i < bt.length; i++) {
			if(evt == bt[i]) { //버튼값이 같은 버튼을 찾기
				String name = bt[i].getText(); //버튼의 이름을 name에 저장
				//다이얼로그를 띄우고 만약 OK를 눌렀을 때
				if(JOptionPane.showConfirmDialog(null, name+"를 추가하시겠습니까?")==JOptionPane.OK_OPTION) {	
					orderList.add(name);//주문목록에 이름 추가
					String[] arr= setList();
					getTotal(arr);
					//리스트 목록을 새로운 arr목록으로 변경
				}
			}
		}
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==list) {
			String name = list.getSelectedValue();
			item[1].setText(name); //라벨에 상품 이름 넣기
			item[3].setText(String.valueOf(getItemPrice(name))); //라벨에 상품 가격 넣기
			listEastP.repaint();
		}
	}
}
