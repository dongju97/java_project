package UserInfo;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoEdit {

	public UserInfoEdit(Frame myPageFrame, Panel myPagePanel, UserInfoVO userInfoVO) {

		Panel f1 = new Panel();
		f1.setBounds(25, 20, 350, 380);
		f1.setLayout(null);

		myPageFrame.add(f1);
		new ChangePanel(myPagePanel, f1);

		f1.add(new MyLabel("아이디", 30, 50, 60, 25));
		f1.add(new MyLabel("이름", 30, 80, 60, 25));
		f1.add(new MyLabel("성별", 30, 110, 60, 25));
		f1.add(new MyLabel("생년월일", 30, 140, 60, 25));
		f1.add(new MyLabel("휴대폰번호", 30, 170, 60, 25));
		f1.add(new MyLabel("이메일", 30, 200, 60, 25));
		f1.add(new MyLabel("@", 215, 200, 10, 25));

		// TextField ------------------------------------------------
		TextField id = new TextField();
		TextField name = new TextField();
		TextField birth = new TextField();
		TextField phone1 = new TextField();
		TextField email = new TextField();
		id.setBounds(110, 50, 100, 25);
		name.setBounds(110, 80, 200, 25);
		birth.setBounds(110, 140, 200, 25);
		phone1.setBounds(110, 170, 100, 25);
		email.setBounds(110, 200, 100, 25);

		id.setEnabled(false);
		name.setEnabled(false);
		birth.setEnabled(false);

		f1.add(id);
		f1.add(name);
		f1.add(birth);
		f1.add(phone1);
		f1.add(email);

		// Choice --------------------------------------------------------
		Choice c = new Choice();
		c.add("naver.com");
		c.add("hanmail.net");
		c.add("nate.com");
		c.add("gmail.com");
		c.add("yahoo.co.kr");
		c.setBounds(230, 200, 100, 25);

		f1.add(c);

		// Checkbox----------------------------------------------------------
		CheckboxGroup group = new CheckboxGroup();
		Checkbox boy = new Checkbox("남자", group, true);
		boy.setBounds(110, 110, 50, 25);
		boy.setEnabled(false);
		Checkbox girl = new Checkbox("여자", group, false);
		girl.setBounds(165, 110, 50, 25);
		girl.setEnabled(false);

		f1.add(boy);
		f1.add(girl);

		// Button ----------------------------------------------------------
		Button save = new Button("저장하기");
		save.setBounds(65, 350, 100, 30);// 350
		Button btnReturnPage = new Button("돌아가기");
		btnReturnPage.setBounds(185, 350, 100, 30);

		f1.add(save);
		f1.add(btnReturnPage);
		f1.add(phone1);
		f1.add(email);
		f1.setVisible(true);

		// 텍스트박스에 파일내용 셋팅
		id.setText(userInfoVO.getId());
		name.setText(userInfoVO.getName());
		birth.setText(userInfoVO.getBirth());
		phone1.setText(userInfoVO.getPhone1());
		email.setText(userInfoVO.getEmail1());
		c.select(userInfoVO.getEmail2());

		// 성별 체크박스 셋팅
		if (userInfoVO.getGender().equals("여자")) {
			group.setSelectedCheckbox(girl);
		} else {
			group.setSelectedCheckbox(boy);
		}

		// 버튼액션들-----------------------------------------------
		// 저장버튼 셋팅
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				UserInfoSave sv = new UserInfoSave();
				// 변경된 값 들을 vo에 저장
				userInfoVO.setPhone1(phone1.getText());
				userInfoVO.setEmail1(email.getText());
				userInfoVO.setEmail2(c.getSelectedItem());
				// 저장

				sv.save(f1, userInfoVO);
				new ChangePanel(f1, myPagePanel);
			}
		});

		// 취소버튼
		btnReturnPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 화면 이동하기
				new ChangePanel(f1, myPagePanel);

			}
		});

	}

}
