package coupon;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import UserInfo.UserInfoMain;
import login.LogVO;

public class CouponCheck extends RandomCoupon {

	public CouponCheck(LogVO logVO) {

		super(logVO);

		Frame f = new Frame("쿠폰함");
		f.setBounds(700, 200, 400, 500);
		f.setLayout(null);// 자동배치 끄기
		f.setBackground(Color.white);

		Button btn_main = new Button("메인 가기");
		btn_main.setBounds(30, 40, 100, 40);
		btn_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new MainPage(logVO);

			}
		});

		Button btn_my = new Button("마이페이지 가기");
		btn_my.setBounds(230, 40, 150, 40);

		btn_my.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserInfoMain(logVO);

			}
		});

		JLabel bar = new JLabel("쿠폰내역", JLabel.CENTER);
		bar.setOpaque(true);
		bar.setBackground(Color.pink);
		bar.setBounds(10, 90, 360, 30);

		Font font = new Font("", Font.PLAIN, 30);
		if (result != null) {
			JLabel lb = new JLabel("" + result + "원 사용가능", JLabel.CENTER);
			lb.setOpaque(true);
			lb.setBackground(Color.lightGray);
			lb.setBounds(10, 150, 360, 80);
			lb.setForeground(Color.BLUE);
			lb.setFont(font);
			f.add(lb);
		} else {
			JLabel lb = new JLabel("쿠폰이 없습니다.", JLabel.CENTER);
			lb.setOpaque(true);
			lb.setBounds(10, 150, 350, 80);
			lb.setFont(font);
			f.add(lb);

		}

		f.add(btn_main);
		f.add(btn_my);
		f.add(bar);

		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});

	}

}
