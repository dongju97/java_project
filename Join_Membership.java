package join_membership;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class Join_Membership {
	String gender = "남자";
	String infor;

	public static void main(String[] args) {
		new Join_Membership();
	}

	public Join_Membership() {

		Frame membership = new Frame("회원가입");

		Label name_lb = new Label("이름");
		Label gender_lb = new Label("성별");
		Label day_lb = new Label("생년월일");
		Label id_lb = new Label("아이디");
		Label pw_lb = new Label("비밀번호");
		Label tel_lb = new Label("휴대전화");
		Label email_lb = new Label("이메일");

		TextField name_tf = new TextField();
		Choice gender_tf = new Choice();
		gender_tf.add("남자");
		gender_tf.add("여자");
		TextField day_tf = new TextField();
		TextField id_tf = new TextField();
		TextField pw_tf = new TextField();
		TextField tel_tf = new TextField();
		TextField email_tf = new TextField();

		Button join_btn = new Button("회원가입");
		Button back_btn = new Button("취소");

		membership.setLayout(null);
		membership.setResizable(false);
		membership.setBounds(750, 450, 500, 500);

		name_lb.setBounds(167, 90, 50, 25);
		gender_lb.setBounds(167, 130, 50, 25);
		day_lb.setBounds(167, 170, 50, 25);
		id_lb.setBounds(167, 210, 50, 25);
		pw_lb.setBounds(167, 250, 50, 25);
		tel_lb.setBounds(167, 290, 50, 25);
		email_lb.setBounds(167, 330, 50, 25);

		name_tf.setBounds(250, 90, 100, 25);
		gender_tf.setBounds(250, 130, 100, 25);
		day_tf.setBounds(250, 170, 100, 25);
		id_tf.setBounds(250, 210, 100, 25);
		pw_tf.setBounds(250, 250, 100, 25);
		tel_tf.setBounds(250, 290, 100, 25);
		email_tf.setBounds(250, 330, 100, 25);

		join_btn.setBounds(200, 390, 100, 25);
		back_btn.setBounds(200, 460, 100, 25);

		membership.add(name_lb);
		membership.add(gender_lb);
		membership.add(day_lb);
		membership.add(id_lb);
		membership.add(pw_lb);
		membership.add(tel_lb);
		membership.add(email_lb);

		membership.add(name_tf);
		membership.add(gender_tf);
		membership.add(day_tf);
		membership.add(id_tf);
		membership.add(pw_tf);
		membership.add(tel_tf);
		membership.add(email_tf);

		membership.add(join_btn);
		membership.add(back_btn);

		membership.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				membership.dispose();

			}
		});
		ItemListener checkListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				gender = e.getItem().toString();
				System.out.println(gender);

			}

		};
		join_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String infor = name_tf.getText() + "/" + gender + "/" + day_tf.getText() + "/" + id_tf.getText() + "/"

						+ pw_tf.getText() + "/" + tel_tf.getText() + "/" + email_tf.getText();

				System.out.println(infor);

				String path = "C:/storage2/userinfor/"; // 사용자 저장경로

				File f = new File(path);

				if (!f.exists()) {

					f.mkdirs();

				}

				try {

					FileOutputStream fos = new FileOutputStream(

							path + "[" + name_tf.getText() + "]" + id_tf.getText() + ".txt");

					fos.write(infor.getBytes());

					fos.close();

				} catch (Exception e1) {

					e1.printStackTrace();

				}
				JOptionPane.showMessageDialog(membership, "회원가입이 완료되었습니다");
			}
		});
		gender_tf.addItemListener(checkListener);

		membership.setVisible(true);
	}// main
}