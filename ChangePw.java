package UserInfo;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class ChangePw {

	public ChangePw(Frame f, Panel myPagePanel, UserInfoVO userInfoVO) {

		Panel pwFrame = new Panel();
		pwFrame.setBounds(50, 20, 300, 380);
		pwFrame.setLayout(null);
		f.add(pwFrame);
		new ChangePanel(myPagePanel, pwFrame);
		TextField tfOldPw = new TextField();
		TextField tfNewPw = new TextField();
		TextField tfChkPw = new TextField();

		Label oldPwChk = new Label();
		Label newPwChk = new Label();
		Label chkPwChk = new Label();
		oldPwChk.setAlignment(1);
		newPwChk.setAlignment(1);
		chkPwChk.setAlignment(1);

		// 가로,세로 좌표 찍고 가로 세로 크기
		tfOldPw.setBounds(160, 80, 100, 20);
		oldPwChk.setBounds(50, 110, 250, 20);
		tfNewPw.setBounds(160, 140, 100, 20);
		newPwChk.setBounds(50, 170, 250, 20);
		tfChkPw.setBounds(160, 200, 100, 20);
		chkPwChk.setBounds(50, 230, 250, 20);

		// 비밀번호의 입력을 *모양으로 표시되도록 설정
		tfOldPw.setEchoChar('*');
		tfNewPw.setEchoChar('*');
		tfChkPw.setEchoChar('*');

		// 비밀번호 변경 화면에서 필요한 라벨 셋팅
		pwFrame.add(new MyLabel("기존 비밀번호", 30, 80, 100, 20));
		pwFrame.add(new MyLabel("새 비밀번호", 30, 140, 100, 20));
		pwFrame.add(new MyLabel("새 비밀번호 확인", 30, 200, 100, 20));

		// 글씨색깔 변경
		oldPwChk.setForeground(Color.RED);
		newPwChk.setForeground(Color.RED);
		chkPwChk.setForeground(Color.RED);
		Button btnSave = new Button("저장");
		btnSave.setBounds(40, 350, 100, 30);
		Button btnReturnPage = new Button("돌아가기");
		btnReturnPage.setBounds(160, 350, 100, 30);

		pwFrame.add(tfOldPw);// 기존 비밀번호
		pwFrame.add(tfNewPw);// 새 비밀번호
		pwFrame.add(tfChkPw);// 새 비밀번호 확인
		pwFrame.add(btnSave);
		pwFrame.add(btnReturnPage);
		pwFrame.add(oldPwChk);
		pwFrame.add(newPwChk);
		pwFrame.add(chkPwChk);

		pwFrame.setVisible(true);

		// 액션리스너--------------------------------------------------
		tfOldPw.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				// 비밀번호 체크를 확인하기 위해 키 누를때 마다 검증
				if (tfOldPw.getText().length() == 0) {
					oldPwChk.setVisible(false);
				} else if (!userInfoVO.getPwd().equals(tfOldPw.getText())) {
					oldPwChk.setText("기존 비밀번호가 불일치 합니다.");
					oldPwChk.setVisible(true);
				} else {
					oldPwChk.setVisible(false);
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		tfNewPw.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				// 비밀번호 체크를 확인하기 위해 키 누를때 마다 검증
				if (tfNewPw.getText().length() == 0) {
					newPwChk.setVisible(false);
				} else if (userInfoVO.getPwd().equals(tfNewPw.getText())) {
					newPwChk.setText("기존 비밀번호와 일치 합니다.");
					newPwChk.setVisible(true);
				} else {
					newPwChk.setVisible(false);
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		tfChkPw.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				// 비밀번호 체크를 확인하기 위해 키 누를때 마다 검증
				if (tfChkPw.getText().length() == 0) {
					chkPwChk.setVisible(false);
				} else if (!tfNewPw.getText().equals(tfChkPw.getText())) {
					chkPwChk.setText("새 비밀번호와 일치 하지 않습니다.");
					chkPwChk.setVisible(true);
				} else {
					chkPwChk.setVisible(false);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		// 버튼액션들-----------------------------------------------
		// 저장버튼 셋팅
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tfOldPw.getText().length() == 0) {
					JOptionPane.showMessageDialog(pwFrame, "기존 비밀번호를 입력해주세요!!");
				} else if (tfNewPw.getText().length() == 0) {
					JOptionPane.showMessageDialog(pwFrame, "새 비밀번호를 입력해주세요!!");
				} else if (tfChkPw.getText().length() == 0) {
					JOptionPane.showMessageDialog(pwFrame, "새 비밀번호 확인을 입력해주세요!!");
				} else if (oldPwChk.isVisible()) {
					JOptionPane.showMessageDialog(pwFrame, "기존 비밀번호에 오류가 있습니다.");
				} else if (newPwChk.isVisible()) {
					JOptionPane.showMessageDialog(pwFrame, "새 비밀번호에 오류가 있습니다.");
				} else if (chkPwChk.isVisible()) {
					JOptionPane.showMessageDialog(pwFrame, "새 비밀번호 확인에 오류가 있습니다.");
				} else {
					UserInfoSave sv = new UserInfoSave();
					// 변경된 값 들을 vo에 저장
					userInfoVO.setPwd(tfNewPw.getText());
					// 저장
					sv.save(pwFrame, userInfoVO);
					new ChangePanel(pwFrame, myPagePanel);
				}

			}
		});
		// 취소버튼
		btnReturnPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 화면 이동하기
				new ChangePanel(pwFrame, myPagePanel);
			}
		});

	}

}
