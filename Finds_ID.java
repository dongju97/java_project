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

import javax.swing.JOptionPane;

public class Finds_ID {
	String path;
	String[] gettel;

	public Finds_ID() {

		Frame finds_ID = new Frame("아이디 찾기");

		Label name_Label = new Label("이름");
		Label tel_Label = new Label("휴대전화");

		TextField name_tf = new TextField();
		TextField tel_tf = new TextField();

		Button finds_btn = new Button("찾기");
		Button back_btn = new Button("뒤로가기");

		finds_ID.setLayout(null);
		finds_ID.setResizable(false);

		finds_ID.setBounds(750, 450, 500, 500);

		name_Label.setBounds(167, 200, 80, 25);
		tel_Label.setBounds(167, 240, 70, 25);

		name_tf.setBounds(250, 200, 100, 25);
		tel_tf.setBounds(250, 240, 100, 25);

		finds_btn.setBounds(200, 390, 100, 25);
		back_btn.setBounds(200, 460, 100, 25);

		finds_ID.add(name_Label);
		finds_ID.add(tel_Label);

		finds_ID.add(name_tf);
		finds_ID.add(tel_tf);

		finds_ID.add(finds_btn);
		finds_ID.add(back_btn);

		finds_ID.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finds_ID.dispose();
			}
		});
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				finds_ID.dispose();

			}
		});
		finds_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = name_tf.getText();
				String tel = tel_tf.getText();
				path = "C:/storage2/userinfo";
				File f = new File(path);
				String[] ss = f.list();

				byte[] info_Read = new byte[100];

				out: for (int i = 0; i < ss.length; i++) {

					System.out.println(ss[i]);

					if (name.equals(ss[i].substring(1, ss[i].indexOf("]")))) {
						try {
							FileInputStream fis = new FileInputStream(path + "/" + ss[i]);
							fis.read(info_Read);

							String info = new String(info_Read);

							gettel = info.split("/");

							fis.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						if (tel.equals(gettel[5])) {
							JOptionPane.showMessageDialog(finds_ID, "아이디는" + gettel[0] + "입니다");
							System.out.println("성공");
							break;
						} else if (!tel.equals(gettel[5])) {
							System.out.println("없는 휴대폰번호입니다.");
							JOptionPane.showMessageDialog(finds_ID, "없는 휴대폰번호입니다.");
							break;
						}
					} else {
						continue out;

					}
				}
			}
		});
		finds_ID.setVisible(true);
	}
}