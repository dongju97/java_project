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

import login.LogVO;

public class CouponMain {

	public CouponMain(LogVO logVO) {

		Frame f = new Frame("쿠폰페이지");
		f.setBounds(700, 200, 400, 500);
		f.setBackground(Color.white);
		f.setLayout(null);// 자동배치 끄기

		Button btn1 = new Button("<쿠폰 받기>");
		btn1.setBounds(110, 300, 140, 50);

		RandomCoupon rc = new RandomCoupon(logVO);
		btn1.addActionListener(rc);

		Button btn_main = new Button("메인 가기");
		btn_main.setBounds(30, 40, 100, 40);
		btn_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new MainPage(logVO);

			}
		});

		Font font = new Font("", Font.BOLD, 40);
		JLabel lb = new JLabel("만원부터 랜덤쿠폰 ", JLabel.CENTER);
		lb.setOpaque(true);
		lb.setBackground(Color.lightGray);
		lb.setFont(font);
		lb.setBounds(10, 150, 350, 80);
		lb.setForeground(Color.BLUE);

		Font font2 = new Font("", Font.PLAIN, 20);
		JLabel lb2 = new JLabel("ID당 쿠폰 하나입니다.", JLabel.CENTER);
		lb2.setFont(font2);
		lb2.setBounds(10, 200, 350, 80);

		Button btn_ham = new Button("내 쿠폰보기");
		btn_ham.setBounds(230, 40, 100, 40);
		btn_ham.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new CouponCheck(logVO);
			}

		});

		if (RandomCoupon.result != null) {
			btn1.setEnabled(false);
		}

		f.add(btn1);
		f.add(btn_ham);
		f.add(lb);
		f.add(btn_main);
		f.add(lb2);

		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});
	}
}