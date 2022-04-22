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

		Button btnChUser = new Button("ȸ������ ����");
		Button btnChPw = new Button("��й�ȣ ����");
		Button btnRh = new Button("���೻�� ��ȸ");
		Button btnCp = new Button("�������� ��ȸ");// ����
		Button btnBack = new Button("���ư���");

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

		// ���߿� �̰� �ڵ����� �޾ƿ;ߵ�
		String id = logVO.getId();

		// ȸ������ ����------------------------------------------------
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

		// ��й�ȣ ����--------------------------------------------------
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

		// ���೻�� Ȯ��----------------------------------------------------------
		btnRh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserInfoVO suserInfoVO = new UserInfoVO();
				suserInfoVO.setId(id);
				UserInfoRead uir = new UserInfoRead();
				UserInfoVO userInfoVO = uir.getUserInfo(suserInfoVO);
				// ���ư���
				new ReservationHistory(myPageFrame, myPagePanel, userInfoVO);
			}
		});

		// ����Ȯ�� ����---------------------------------------------
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

		// ��������
		myPageFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				myPageFrame.dispose();
			};
		});

	}// main

}
