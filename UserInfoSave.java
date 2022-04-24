package UserInfo;

import java.awt.Panel;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class UserInfoSave {

	public boolean save(Panel panel, UserInfoVO userInfoVO) {

		String user = "";
		user += userInfoVO.getId() + "/";
		user += userInfoVO.getPwd() + "/";
		user += userInfoVO.getName() + "/";
		user += userInfoVO.getGender() + "/";
		user += userInfoVO.getBirth() + "/";
		user += userInfoVO.getPhone1() + "/";
		user += userInfoVO.getEmail1() + "@";
		user += userInfoVO.getEmail2()+"/";
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
		JOptionPane.showMessageDialog(panel, "저장되었습니다");
		return true;
	}

}
