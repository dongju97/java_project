package UserInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class UserInfoRead {

	public UserInfoVO getUserInfo(UserInfoVO userInfoVO) {

		// 파일 읽어오기 시작
		// 파일경로
		String user_path = "C:/storage2/userinfo";
		File dir = new File(userInfoVO.path);
		File[] files = dir.listFiles();
		String findfileName = "]" + userInfoVO.getId() + ".txt";
		System.out.println("되면대박 : " + findfileName);
		for (File f : files) {
			// 파일을 찾았을 때 유저패스를 셋팅한다.
			if (f.getName().endsWith(findfileName)) {
				user_path += "/" + f.getName();
			}
			System.out.println("f2:" + f.getName());
		}
		// 파일경로 확인
		System.out.println("f1:" + findfileName);
		System.out.println("파일경로를 확인하기 위함 : " + user_path);
		String[] infoRead = new String[8];

		try {
			// 파일읽기
			BufferedReader reader = new BufferedReader(new FileReader(user_path));
			// 읽은파일 Str
			String str;
			while ((str = reader.readLine()) != null) {
				System.out.println(str);
				// 읽은파일 "/"로 잘라서 infoRead에 저장
				infoRead = str.split("/");

				// infoRead에 잘려진 값 확인
				System.out.println("ID : " + infoRead[0]);// id
				System.out.println("비밀번호 : " + infoRead[1]);// 비밀번호
				System.out.println("이름 : " + infoRead[2]);// 이름
				System.out.println("성별 : " + infoRead[3]);// 성별
				System.out.println("생년월일 : " + infoRead[4]);// 생년월일
				System.out.println("휴대폰번호 : " + infoRead[5]);// 휴대폰번호
				System.out.println("이메일 : " + infoRead[6]);// 이메일

				userInfoVO.setId(infoRead[0]);// 아이디 저장
				userInfoVO.setPwd(infoRead[1]);// 비밀번호 저장
				userInfoVO.setName(infoRead[2]);// 이름저장
				userInfoVO.setGender(infoRead[3]);// 성별저장
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
		// 파일 읽어오기 끝
		return userInfoVO;
	}
}