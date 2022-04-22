package UserInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class UserInfoRead {

	public UserInfoVO getUserInfo(UserInfoVO userInfoVO) {

		// ���� �о���� ����
		// ���ϰ��
		String user_path = "C:/storage2/userinfo";
		File dir = new File(userInfoVO.path);
		File[] files = dir.listFiles();
		String findfileName = "]" + userInfoVO.getId() + ".txt";
		System.out.println("�Ǹ��� : " + findfileName);
		for (File f : files) {
			// ������ ã���� �� �����н��� �����Ѵ�.
			if (f.getName().endsWith(findfileName)) {
				user_path += "/" + f.getName();
			}
			System.out.println("f2:" + f.getName());
		}
		// ���ϰ�� Ȯ��
		System.out.println("f1:" + findfileName);
		System.out.println("���ϰ�θ� Ȯ���ϱ� ���� : " + user_path);
		String[] infoRead = new String[8];

		try {
			// �����б�
			BufferedReader reader = new BufferedReader(new FileReader(user_path));
			// �������� Str
			String str;
			while ((str = reader.readLine()) != null) {
				System.out.println(str);
				// �������� "/"�� �߶� infoRead�� ����
				infoRead = str.split("/");

				// infoRead�� �߷��� �� Ȯ��
				System.out.println("ID : " + infoRead[0]);// id
				System.out.println("��й�ȣ : " + infoRead[1]);// ��й�ȣ
				System.out.println("�̸� : " + infoRead[2]);// �̸�
				System.out.println("���� : " + infoRead[3]);// ����
				System.out.println("������� : " + infoRead[4]);// �������
				System.out.println("�޴�����ȣ : " + infoRead[5]);// �޴�����ȣ
				System.out.println("�̸��� : " + infoRead[6]);// �̸���

				userInfoVO.setId(infoRead[0]);// ���̵� ����
				userInfoVO.setPwd(infoRead[1]);// ��й�ȣ ����
				userInfoVO.setName(infoRead[2]);// �̸�����
				userInfoVO.setGender(infoRead[3]);// ��������
				userInfoVO.setBirth(infoRead[4]);
				userInfoVO.setPhone1(infoRead[5]);
				userInfoVO.setEmail1(infoRead[6].split("@")[0]);
				userInfoVO.setEmail2(infoRead[6].split("@")[1]);
				userInfoVO.setCoupon(infoRead[7]);
			}
			reader.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ���� �о���� ��
		return userInfoVO;
	}
}