package sign;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class Join implements ActionListener {

	private Frame mf;
	private TextField id;
	private TextField pwd;
	private TextField pwd_check;
	private TextField name;
	private TextField birth;
	private TextField phone1;
	private TextField phone2;
	private TextField phone3;
	private TextField email;

	public Join(Frame mf, TextField id, TextField pwd, TextField pwd_check, TextField name, TextField birth,
			TextField phone1, TextField phone2, TextField phone3, TextField email) {
		this.mf = mf;
		this.id = id;
		this.pwd = pwd;
		this.pwd_check = pwd_check;
		this.name = name;
		this.birth = birth;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email = email;
	}

	@Override 
	public void actionPerformed(ActionEvent e) {
		if (id.getText().equals(""))
			JOptionPane.showMessageDialog(mf, "아이디를 입력해주세요.");
		else if (pwd.getText().equals(""))
			JOptionPane.showMessageDialog(mf, "비밀번호를 입력해주세요.");
		else if (name.getText().equals(""))
			JOptionPane.showMessageDialog(mf, "이름을 입력해주세요.");
		else if (birth.getText().equals(""))
			JOptionPane.showMessageDialog(mf, "생년월일을 입력해주세요.");
		else if (phone1.getText().equals(""))
			JOptionPane.showMessageDialog(mf, "핸드폰 번호를 입력해주세요.");
		else if (email.getText().equals(""))
			JOptionPane.showMessageDialog(mf, "이메일을 입력해주세요.");
		else if (!pwd.getText().equals(pwd_check.getText()))
			JOptionPane.showMessageDialog(mf, "비밀번호가 일치하지 않습니다.");
		else if (IdCheck.idCheck == false)
			JOptionPane.showMessageDialog(mf, "아이디 중복체크를 해주세요.");
		else {
			String myid = id.getText();
			String mypwd = pwd.getText();
			String myname = name.getText();
			String mybirth = birth.getText();
			String myphone = phone1.getText() + phone2.getText() + phone3.getText();
			String email_com = email.getText() + "@" + JoinMain.EMAIL;

			String user = myid + "/" + mypwd + "/" + myname + "/" + JoinMain.gender + "/" + mybirth + "/" + myphone
					+ "/" + email_com;

			String path = "C:/storage2/userinfo";
			File f = new File(path);

			if (!f.exists()) {
				f.mkdirs();
			}
			try {
				String user_path = "C:/storage2/userinfo/" + "[" + name.getText() + "]" + id.getText() + ".txt";

				System.out.println(user_path);

				FileOutputStream fos_user = new FileOutputStream(user_path, true);
				fos_user.write(user.getBytes());
				fos_user.close();

				FileOutputStream fos_id = new FileOutputStream("C:/storage2/userinfoid/id.txt", true);
				myid += "\n";

				int yesno = JOptionPane.showConfirmDialog(null, "가입하시겠습니까?", "알림창", JOptionPane.YES_NO_OPTION);
				fos_id.write(myid.getBytes());

				if (yesno == 1) {

				} else {
					JOptionPane.showMessageDialog(null, "가입되었습니다!");
					mf.dispose();

				}

				fos_id.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

}
