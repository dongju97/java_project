package login;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import UserInfo.UserInfoVO;
import coupon.MainPage;
import sign.JoinMain;

public class Login {

	static String[] getpw;

	public Login() {
		LogVO logVO = new LogVO();

		Frame loginFrame = new Frame("로그인");

		Label log_Label = new Label("아이디");
		Label pw_Label = new Label("비밀번호");

		TextField login_tf = new TextField();
		TextField pw_tf = new TextField();

		Button login_btn = new Button("로그인");
		Button join_btn = new Button("회원가입");
		Button finds_Id = new Button("아이디찾기");
		Button finds_Pw = new Button("비밀번호 찾기");

		loginFrame.setLayout(null);
		loginFrame.setResizable(false);
		loginFrame.setBounds(750, 450, 500, 500);

		log_Label.setBounds(167, 200, 50, 25);
		pw_Label.setBounds(167, 240, 50, 25);

		login_tf.setBounds(250, 200, 100, 25);
		pw_tf.setBounds(250, 240, 100, 25);
		pw_tf.setEchoChar('*');

		finds_Id.setBounds(150, 300, 100, 25);
		finds_Pw.setBounds(250, 300, 100, 25);
		login_btn.setBounds(200, 390, 100, 25);
		join_btn.setBounds(200, 460, 100, 25);

		loginFrame.add(log_Label);
		loginFrame.add(pw_Label);

		loginFrame.add(login_tf);
		loginFrame.add(pw_tf);

		loginFrame.add(login_btn);
		loginFrame.add(join_btn);
		loginFrame.add(finds_Id);
		loginFrame.add(finds_Pw);

		login_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String path = "C:/storage2/userinfo/";
				File f = new File(path);
				String id = login_tf.getText();
				String pw = pw_tf.getText();
				String[] ss = f.list();
				byte[] info_Read = new byte[100];
				int i = 0;
				for (i = 0; i < ss.length; i++) {
					if (id.equals(ss[i].substring(ss[i].indexOf(']') + 1, ss[i].indexOf('.')))) {
						try {
							FileInputStream fis = new FileInputStream(path + "/" + ss[i]);
							fis.read(info_Read);
							String info = new String(info_Read).trim();
							System.out.println("파일 데이터 :" + info);
							getpw = info.split("/");
							System.out.println("파일명 : " + ss[i]);
							fis.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						if (pw.equals(getpw[1].toString())) {
							JOptionPane.showMessageDialog(loginFrame, "로그인 성공");
							System.out.println("로그인 성공");
							logVO.setId(getpw[0]);
							logVO.setPw(getpw[1]);
							logVO.setName(getpw[2]);
							logVO.setGender(getpw[3]);
							logVO.setBirth(getpw[4]);
							logVO.setPhone(getpw[5]);
							logVO.setEmail(getpw[6]);

							new MainPage(logVO);
							break;
						} else if (!pw.equals(getpw[1].toString())) {
							System.out.println("아이디 또는 비밀번호를 잘못입력하였습니다.");
							JOptionPane.showMessageDialog(loginFrame, "아이디 또는 비밀번호를 잘못입력하였습니다.");
							break;
						}
					}
				}
				if (i == ss.length)
					JOptionPane.showMessageDialog(loginFrame, "아이디 또는 비밀번호를 잘못입력하였습니다.");
			}
		});
		loginFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		join_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinMain();

			}

		});

		join_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent g) {

				String path = "C:/storage2/userinfoid";
				File f = new File(path);

				if (!f.exists()) {
					f.mkdirs();
				}

				try {
					FileOutputStream fos = new FileOutputStream("C:/storage2/userinfoid/id.txt", true);

					fos.close();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		finds_Id.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Finds_ID();
			}
		});

		finds_Pw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Finds_PW();
			}
		});

		loginFrame.setVisible(true);
	}// main

}