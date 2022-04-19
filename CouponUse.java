package framelodge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import login.LogVO;

public class CouponUse {

	public CouponUse() { // 마이페이지에 저장된 쿠폰 불러오기

	}

	public int GetCoupon(LogVO logVO) {

		// 유저에 쿠폰 저장
		String path = "C:/storage2/userinfo/[" + logVO.getName() + "]" + logVO.getId() + ".txt";
		int couponPay = 0;
		File file = new File(path);
		try {
			FileReader fis = new FileReader(file);
			BufferedReader bis = new BufferedReader(fis);
			String ss = "";
			ss = bis.readLine();
			String findCoupon[] = ss.split("/");
			System.out.println(findCoupon[7]);
			int intCoupon = Integer.parseInt(findCoupon[7]);
			couponPay = intCoupon;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return couponPay;
	}
}
