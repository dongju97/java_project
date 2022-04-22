package sign;

import java.awt.Button;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JoinMain {

	static String gender = "남자";
	static String EMAIL = "naver.com";

//	public static void main(String[] args) {
//		new JoinMain();
//	}

	public JoinMain() {

		MyFrame mf = new MyFrame();
		boolean idCheck = false;

		// Label ======================================================
		mf.add(new MyLabel("아이디", 130, 40, 60, 25));
		mf.add(new MyLabel("비밀번호", 130, 80, 60, 25));
		mf.add(new MyLabel("재입력", 130, 120, 60, 25));
		mf.add(new MyLabel("이름", 130, 160, 60, 25));
		mf.add(new MyLabel("성별", 130, 200, 60, 25));
		mf.add(new MyLabel("생년월일", 130, 240, 60, 25));
		mf.add(new MyLabel("휴대전화", 130, 280, 60, 25));
		mf.add(new MyLabel("-", 230, 280, 5, 25));
		mf.add(new MyLabel("-", 270, 280, 5, 25));
		mf.add(new MyLabel("이메일", 130, 320, 60, 25));
		mf.add(new MyLabel("@", 285, 320, 25, 25));

		// TextField ===================================================
		TextField id = new TextField();
		id.setBounds(200, 40, 100, 25);

		TextField pwd = new TextField();
		pwd.setBounds(200, 80, 100, 25);
		pwd.setEchoChar('*');

		TextField pwd_check = new TextField();
		pwd_check.setBounds(200, 120, 100, 25);
		pwd_check.setEchoChar('*');

		TextField name = new TextField();
		name.setBounds(200, 160, 100, 25);

		TextField birth = new TextField();
		birth.setBounds(200, 240, 100, 25);

		TextField phone1 = new TextField();
		phone1.setBounds(200, 280, 25, 25);

		TextField phone2 = new TextField();
		phone2.setBounds(240, 280, 25, 25);

		TextField phone3 = new TextField();
		phone3.setBounds(280, 280, 25, 25);

		TextField email = new TextField();
		email.setBounds(200, 320, 85, 25);

		mf.add(id);
		mf.add(pwd);
		mf.add(pwd_check);
		mf.add(name);
		mf.add(birth);
		mf.add(phone1);
		mf.add(phone2);
		mf.add(phone3);
		mf.add(email);

		// Choice ======================================================

		Choice c = new Choice();
		c.add("naver.com");
		c.add("hanmail.net");
		c.add("nate.com");
		c.add("gamil.com");
		c.add("yahoo.co.kr");
		c.add("nate.com");
		c.setBounds(310, 320, 100, 25);
		mf.add(c);

		// Checkbox======================================================

		Choice gender_tf = new Choice();
		gender_tf.add("남자");
		gender_tf.add("여자");
		gender_tf.setBounds(200, 200, 100, 25);
		mf.add(gender_tf);

		// Button =======================================================

		Button check = new Button("중복확인");
		check.setBounds(310, 40, 100, 25);

		Button join = new Button("회원가입");
		join.setBounds(200, 390, 100, 25);

		Button quit = new Button("취소");
		quit.setBounds(200, 460, 100, 25);

		mf.add(check);
		mf.add(join);
		mf.add(quit);

		// gender_tf
		ItemListener checkListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				gender = e.getItem().toString();
				System.out.println(gender);

			}

		};
		// Choice에서 email값 가져오기
		c.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				EMAIL = e.getItem().toString();
			}
		});

		// 중복확인 버튼 이벤트
		IdCheck ic = new IdCheck(mf, id);
		check.addActionListener(ic);

		// 가입버튼 이벤트
		join.addActionListener(new Join(mf, id, pwd, pwd_check, name, birth, phone1, phone2, phone3, email));
		// 취소버튼 이벤트
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mf.dispose();
			}
		});
	}

}
