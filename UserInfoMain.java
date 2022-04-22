package UserInfo;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import coupon.CouponCheck;
import login.LogVO;

public class UserInfoMain {

	public UserInfoMain(LogVO logVO) {

		Frame myPageFrame = new Frame("My page");
		myPageFrame.setBounds(25, 20, 400, 600);
		myPageFrame.setLayout(null);

		ImageIcon back = new ImageIcon("src/UserInfo/img/yanolja.png");
		JLabel imgback = new JLabel(back);
		imgback.setBounds(0, 450, 400, 100);

		Panel myPagePanel = new Panel();
		myPagePanel.setBounds(0, 20, 400, 380);
		myPagePanel.setLayout(null);

		Button btnChUser = new Button("회원정보 수정");
		Button btnChPw = new Button("비밀번호 변경");
		Button btnRh = new Button("예약내역 조회");
		Button btnCp = new Button("쿠폰내역 조회");// 수정
		Button btnBack = new Button("돌아가기");

		btnChUser.setBounds(100, 45, 200, 40);
		btnChPw.setBounds(100, 95, 200, 40);
		btnRh.setBounds(100, 145, 200, 40);
		btnCp.setBounds(100, 195, 200, 40);
		btnBack.setBounds(150, 350, 100, 30);

		myPageFrame.add(myPagePanel);
		myPageFrame.add(imgback);
		myPagePanel.add(btnBack);
		myPagePanel.add(btnChUser);
		myPagePanel.add(btnChPw);
		myPagePanel.add(btnRh);
		myPagePanel.add(btnCp);
		myPageFrame.setVisible(true);

		// 나중에 이거 자동으로 받아와야됨
		String id = logVO.getId();

		// 회원정보 수정------------------------------------------------
		btnChUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserInfoVO suserInfoVO = new UserInfoVO();
				suserInfoVO.setId(id);
				UserInfoRead uir = new UserInfoRead();
				UserInfoVO userInfoVO = uir.getUserInfo(suserInfoVO);

				new UserInfoEdit(myPageFrame, myPagePanel, userInfoVO);
			}
		});

		// 비밀번호 변경--------------------------------------------------
		btnChPw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserInfoVO suserInfoVO = new UserInfoVO();
				suserInfoVO.setId(id);
				UserInfoRead uir = new UserInfoRead();
				UserInfoVO userInfoVO = uir.getUserInfo(suserInfoVO);

				new ChangePw(myPageFrame, myPagePanel, userInfoVO);

			}
		});

		// 예약내역 확인----------------------------------------------------------
		btnRh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserInfoVO suserInfoVO = new UserInfoVO();
				suserInfoVO.setId(id);
				UserInfoRead uir = new UserInfoRead();
				UserInfoVO userInfoVO = uir.getUserInfo(suserInfoVO);
				// 돌아가기
				new ReservationHistory(myPageFrame, myPagePanel, userInfoVO);
			}
		});

		// 쿠폰확인 내역---------------------------------------------
		btnCp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CouponCheck(logVO);
			}
		});
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPageFrame.dispose();

			}
		});

		// 메인종료
		myPageFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				myPageFrame.dispose();
			};
		});

	}// main

}
