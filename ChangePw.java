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

		// ����,���� ��ǥ ��� ���� ���� ũ��
		tfOldPw.setBounds(160, 80, 100, 20);
		oldPwChk.setBounds(50, 110, 250, 20);
		tfNewPw.setBounds(160, 140, 100, 20);
		newPwChk.setBounds(50, 170, 250, 20);
		tfChkPw.setBounds(160, 200, 100, 20);
		chkPwChk.setBounds(50, 230, 250, 20);

		// ��й�ȣ�� �Է��� *������� ǥ�õǵ��� ����
		tfOldPw.setEchoChar('*');
		tfNewPw.setEchoChar('*');
		tfChkPw.setEchoChar('*');

		// ��й�ȣ ���� ȭ�鿡�� �ʿ��� �� ����
		pwFrame.add(new MyLabel("���� ��й�ȣ", 30, 80, 100, 20));
		pwFrame.add(new MyLabel("�� ��й�ȣ", 30, 140, 100, 20));
		pwFrame.add(new MyLabel("�� ��й�ȣ Ȯ��", 30, 200, 100, 20));

		// �۾����� ����
		oldPwChk.setForeground(Color.RED);
		newPwChk.setForeground(Color.RED);
		chkPwChk.setForeground(Color.RED);
		Button btnSave = new Button("����");
		btnSave.setBounds(40, 350, 100, 30);
		Button btnReturnPage = new Button("���ư���");
		btnReturnPage.setBounds(160, 350, 100, 30);

		pwFrame.add(tfOldPw);// ���� ��й�ȣ
		pwFrame.add(tfNewPw);// �� ��й�ȣ
		pwFrame.add(tfChkPw);// �� ��й�ȣ Ȯ��
		pwFrame.add(btnSave);
		pwFrame.add(btnReturnPage);
		pwFrame.add(oldPwChk);
		pwFrame.add(newPwChk);
		pwFrame.add(chkPwChk);

		pwFrame.setVisible(true);

		// �׼Ǹ�����--------------------------------------------------
		tfOldPw.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				// ��й�ȣ üũ�� Ȯ���ϱ� ���� Ű ������ ���� ����
				if (tfOldPw.getText().length() == 0) {
					oldPwChk.setVisible(false);
				} else if (!userInfoVO.getPwd().equals(tfOldPw.getText())) {
					oldPwChk.setText("���� ��й�ȣ�� ����ġ �մϴ�.");
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
				// ��й�ȣ üũ�� Ȯ���ϱ� ���� Ű ������ ���� ����
				if (tfNewPw.getText().length() == 0) {
					newPwChk.setVisible(false);
				} else if (userInfoVO.getPwd().equals(tfNewPw.getText())) {
					newPwChk.setText("���� ��й�ȣ�� ��ġ �մϴ�.");
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
				// ��й�ȣ üũ�� Ȯ���ϱ� ���� Ű ������ ���� ����
				if (tfChkPw.getText().length() == 0) {
					chkPwChk.setVisible(false);
				} else if (!tfNewPw.getText().equals(tfChkPw.getText())) {
					chkPwChk.setText("�� ��й�ȣ�� ��ġ ���� �ʽ��ϴ�.");
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

		// ��ư�׼ǵ�-----------------------------------------------
		// �����ư ����
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tfOldPw.getText().length() == 0) {
					JOptionPane.showMessageDialog(pwFrame, "���� ��й�ȣ�� �Է����ּ���!!");
				} else if (tfNewPw.getText().length() == 0) {
					JOptionPane.showMessageDialog(pwFrame, "�� ��й�ȣ�� �Է����ּ���!!");
				} else if (tfChkPw.getText().length() == 0) {
					JOptionPane.showMessageDialog(pwFrame, "�� ��й�ȣ Ȯ���� �Է����ּ���!!");
				} else if (oldPwChk.isVisible()) {
					JOptionPane.showMessageDialog(pwFrame, "���� ��й�ȣ�� ������ �ֽ��ϴ�.");
				} else if (newPwChk.isVisible()) {
					JOptionPane.showMessageDialog(pwFrame, "�� ��й�ȣ�� ������ �ֽ��ϴ�.");
				} else if (chkPwChk.isVisible()) {
					JOptionPane.showMessageDialog(pwFrame, "�� ��й�ȣ Ȯ�ο� ������ �ֽ��ϴ�.");
				} else {
					UserInfoSave sv = new UserInfoSave();
					// ����� �� ���� vo�� ����
					userInfoVO.setPwd(tfNewPw.getText());
					// ����
					sv.save(pwFrame, userInfoVO);
					new ChangePanel(pwFrame, myPagePanel);
				}

			}
		});
		// ��ҹ�ư
		btnReturnPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ȭ�� �̵��ϱ�
				new ChangePanel(pwFrame, myPagePanel);
			}
		});

	}

}
