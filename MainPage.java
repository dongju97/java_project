package coupon;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import UserInfo.UserInfoMain;
import UserInfo.UserInfoVO;
import framelodge.FrameLodgeMain;
import login.LogVO;

public class MainPage {

	public MainPage(LogVO logVO) {

		Frame f = new Frame("메인페이지");
		f.setBounds(750, 450, 500, 500);
		f.setLayout(null);// 자동배치 끄기
		f.setResizable(false);
		Button btn1 = new Button("쿠폰 발급");
		btn1.setBounds(200, 130, 100, 40);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new CouponMain(logVO);

			}
		});

		Button btn2 = new Button("예약하기");
		btn2.setBounds(200, 230, 100, 40);

		Button btn_my = new Button("마이페이지");
		btn_my.setBounds(200, 330, 100, 40);

		f.add(btn1);
		f.add(btn2);
		f.add(btn_my);

		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});
		btn_my.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserInfoMain(logVO);

			}
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameLodgeMain(logVO);

			}
		});
	}
}
