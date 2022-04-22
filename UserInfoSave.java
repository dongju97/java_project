package UserInfo;

import java.awt.Panel;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class UserInfoSave {

	public boolean save(Panel panel, UserInfoVO userInfoVO) {

		String user = "";
		user = user + userInfoVO.getId() + "/";
		user = user + userInfoVO.getPwd() + "/";
		user = user + userInfoVO.getName() + "/";
		user = user + userInfoVO.getGender() + "/";
		user = user + userInfoVO.getBirth() + "/";
		user = user + userInfoVO.getPhone1() + "/";
		user = user + userInfoVO.getEmail1() + "@";
		user = user + userInfoVO.getEmail2()+"/";
		user += userInfoVO.getCoupon();
		

		try {
			String path = "C:/storage2/userinfo";
			String user_path = path + "/" + "[" + userInfoVO.getName() + "]" + userInfoVO.getId() + ".txt";
			File file = new File(path);
			File delfile = new File(user_path);

			delfile.delete();

			if (file.exists()) {
				file.mkdirs();
			}
			System.out.println(user_path);

			FileOutputStream fos_user = new FileOutputStream(user_path, true);
			fos_user.write(user.getBytes());
			fos_user.close();

		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
		JOptionPane.showMessageDialog(panel, "저장 되었습니다.");
		return true;
	}

}
