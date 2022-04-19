package framelodge;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

import login.LogVO;

public class FrameBookSubMain {
	int intcount = 0;

	public FrameBookSubMain(int code, String name, String city,LogVO logVO) {

		// 예약하기 프레임 만들기
		Frame f = new Frame("예약 및 결제");
		int count = 0;
		f.setLayout(null);
		f.setBounds(500, 500, 700, 500);

		// 금액 레이블
		// 기본금액
		Label def = new Label(" 기본 금액");
		def.setBackground(Color.orange);
		def.setBounds(50, 40, 70, 30);
		f.add(def);

		// 추가인원
		Label def1 = new Label(" 추가 인원");
		def1.setBackground(Color.orange);
		def1.setBounds(150, 40, 70, 30);
		f.add(def1);

		// 쿠폰할인
		Label def2 = new Label(" 쿠폰 할인");
		def2.setBackground(Color.orange);
		def2.setBounds(250, 40, 70, 30);
		f.add(def2);

		// 쿠폰할인
		Label def3 = new Label(" =  총 금액");
		def3.setBackground(Color.orange);
		def3.setBounds(350, 40, 70, 30);
		f.add(def3);

		// 결제버튼//
		Button sign = new Button("결제"); // 결제버튼 추가
		sign.setBounds(600, 420, 50, 30);
		sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(sign, "결제완료!");
				System.exit(0);// 결제완료 메세지를 누르면 전체 종료
			}
		});
		//////////////////// 결재///////////////////////////
		Choice setPerson = new Choice(); // 예약인원 초이스문
		setPerson.setBounds(130, 83, 100, 30);
		if (code == 1) {
			Label kindRoom = new Label("2인 : 인원추가시 초과요금있습니다");
			String count1 = "120000";
			Label countfield = new Label(count1);
			countfield.setBounds(50, 76, 60, 40);

			intcount = Integer.parseInt(count1);
			int cost = 10000;
			int cost1 = 20000;
			setPerson.add("추가인원 X");
			setPerson.add("1명 : +" + cost);
			setPerson.add("2명 : +" + cost1);
			setPerson.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					String case1 = e.getItem().toString();
					if (case1.equals("1명 : +" + cost)) {
						intcount += cost;
					} else if (case1.equals("2명 : +" + cost1)) {
						intcount += cost1;
					}
					String test = Integer.toString(intcount);
					Label testWin = new Label(test);
					testWin.setBounds(150, 100, 70, 30);
					f.add(testWin);
				}
			});
			f.add(countfield);
		} else if (code == 2) {
			Label kindRoom = new Label("4인 : 인원추가시 초과요금있습니다");
			count = 70000;
			setPerson.add("1명: +10000");
			setPerson.add("2명: +20000");
			setPerson.add("3명: +28000");
		}

		// 쿠폰 적용하여 총결제액에서 디스카운트//
		Button btn = new Button("쿠폰 적용하기");
		CouponUse cu = new CouponUse();
		btn.setBounds(240, 80, 100, 30);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				intcount -= cu.GetCoupon(logVO);
				JOptionPane.showMessageDialog(btn, "쿠폰적용완료!");
				// 메세지 출력
				Label coup = new Label("적용완료");
				coup.setBackground(Color.red);
				coup.setBounds(250, 106, 70, 30);

				String sCoupon = Integer.toString(intcount);
				Label couWin = new Label(sCoupon + "원");
				couWin.setBounds(350, 82, 70, 30);
				f.add(couWin);
				f.add(coup);

				Label finalpay = new Label(sCoupon + "원");
				finalpay.setBackground(Color.GRAY);
				finalpay.setBounds(500, 420, 100, 30);
				f.add(finalpay);
			}
		});
		// 숙박지 기본정보 txt파일을 불러들여서 저장할 공간 생성
		TextArea ta = new TextArea();
		ta.setBounds(200, 150, 300, 300);
		String path = "C:/storage2/lodgeinfo/menu/" + city + "/" + name + ".txt";
		File file = new File(path);
		try {
			FileReader fis = new FileReader(file);
			BufferedReader bis = new BufferedReader(fis);
			String str = "";
			while ((str = bis.readLine()) != null)
				ta.append(str + "\n");
			// ta에다가 txt 파일을 불러온다.
			ta.selectAll();
			ta.setEditable(false); // 수정불가하도록 조치
			f.add(ta);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		f.add(btn);
		f.add(setPerson);
		f.add(ta);
		f.add(sign);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}
}
