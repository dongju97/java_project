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
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class Finds_PW {
	static String[] getpw;
	static String path;

	public Finds_PW() {
		Frame find_PW = new Frame("비밀번호 찾기");

		Label id_Label = new Label("아이디");
		Label tel_Label = new Label("휴대전화");

		TextField id_tf = new TextField();
		TextField tel_tf = new TextField();

		Button finds_btn = new Button("찾기");
		Button back_btn = new Button("뒤로가기");

		find_PW.setLayout(null);
		find_PW.setResizable(false);

		find_PW.setBounds(750, 450, 500, 500);

		id_Label.setBounds(167, 200, 80, 25);
		tel_Label.setBounds(167, 240, 70, 25);

		id_tf.setBounds(250, 200, 100, 25);
		tel_tf.setBounds(250, 240, 100, 25);

		finds_btn.setBounds(200, 390, 100, 25);
		back_btn.setBounds(200, 460, 100, 25);

		find_PW.add(id_Label);
		find_PW.add(tel_Label);

		find_PW.add(id_tf);
		find_PW.add(tel_tf);

		find_PW.add(finds_btn);
		find_PW.add(back_btn);

		find_PW.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				find_PW.dispose();
			}
		});
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				find_PW.dispose();
			}
		});
		finds_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = id_tf.getText();
				String tel = tel_tf.getText();
				path = "C:/storage2/userinfo";
				File f = new File(path);
				String[] ss = f.list();

				byte[] info_Read = new byte[100];

				out: for (int i = 0; i < ss.length; i++) {
					if (id.equals(ss[i].substring(ss[i].indexOf(']') + 1, ss[i].indexOf(".txt")))) {
						try {
							FileInputStream fis = new FileInputStream(path + "/" + ss[i]);
							fis.read(info_Read);

							String info = new String(info_Read);

							getpw = info.split("/");

							fis.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						if (tel.equals(getpw[5].toString())) {
							JOptionPane.showMessageDialog(find_PW, "비밀번호는" + getpw[1].toString() + " 입니다");
							System.out.println("비밀번호찾기 성공");
							break;
						} else if (!tel.equals(getpw[5].toString())) {
							System.out.println("없는 휴대폰번호입니다.");
							JOptionPane.showMessageDialog(find_PW, "없는 휴대폰번호입니다.");
							break;
						}
					} else {
						continue out;
					}
				}
			}
		});
		find_PW.setVisible(true);
	}// main
}