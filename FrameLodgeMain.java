package framelodge;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import login.LogVO;

public class FrameLodgeMain {
	public FrameLodgeMain(LogVO logVO) {
		// 폰트사이즈 설정 메서드
		Font font = new Font("abc", Font.PLAIN, 30);

		// 틀을 생성
		Frame f = new Frame("숙박예약화면창");
		f.setBounds(700, 500, 500, 700);
		f.setLayout(null);

		// 틀에 아이콘 대입
		ImageIcon back = new ImageIcon("src/images/won.png ");
		JLabel j1_back = new JLabel(back); // back 이미지 아이콘을 넣는다.
		j1_back.setBounds(0, 200, 500, 500);

		// 메뉴레이블 생성
		Label l1 = new Label("도시를 선택하시오"); // 레이블 설명 추가하는 란.
		l1.setFont(font);
		l1.setBackground(Color.orange);
		l1.setBounds(50, 40, 300, 50);

		// =======대도시 지정=============//
		Button seoul = new Button("서울");
		Button gyeonggi = new Button("경기");
		Button gang = new Button("강원");
		Button gyeongsang = new Button("경상");
		Button jeju = new Button("제주");
		Button Chung = new Button("충청");
		seoul.setBounds(60, 100, 50, 50);
		gyeonggi.setBounds(120, 100, 50, 50);
		gang.setBounds(180, 100, 50, 50);
		gyeongsang.setBounds(60, 160, 50, 50);
		jeju.setBounds(180, 160, 50, 50);
		Chung.setBounds(120, 160, 50, 50);

		// ============================//도시 버튼을 눌렀을 때
		seoul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = "Seoul";
				FrameLodgeSubMain subMain = new FrameLodgeSubMain(city, logVO);
			}
		});
		gyeonggi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = "gyeonggi";
				FrameLodgeSubMain subMain = new FrameLodgeSubMain(city, logVO);
			}
		});
		gang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = "gang";
				FrameLodgeSubMain subMain = new FrameLodgeSubMain(city, logVO);
			}
		});
		jeju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = "Jeju";
				FrameLodgeSubMain subMain = new FrameLodgeSubMain(city, logVO);
			}
		});
		// ===============================//
		// f.프레임에 화면 대입하기
		f.add(seoul);
		f.add(gyeonggi);
		f.add(gang);
		f.add(jeju);
		f.add(gyeongsang);
		f.add(Chung);
		f.add(l1);
		f.add(j1_back);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {// 윈도우 어뎁터를 하나 만듦
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}