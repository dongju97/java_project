package coupon;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import login.LogVO;

public class RandomCoupon implements ActionListener {

	LogVO logVO = null;

	public RandomCoupon(LogVO logVO) {
		this.logVO = logVO;
	}

	static String result;

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 1; i++) {
			int n = new Random().nextInt(100);

			if (n >= 90) {
				result = "50000";
			} else if (n >= 75) {
				result = "40000";
			} else if (n >= 55) {
				result = "30000";
			} else if (n >= 30) {
				result = "20000";
			} else {
				result = "10000";
			}
		}

		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, result + "원이 당첨되셨습니다!\nMypage에서 확인해주세요!");
		int choice = JOptionPane.showConfirmDialog(null, "쿠폰함으로 가시겠습니까?", "쿠폰함가기", JOptionPane.YES_NO_OPTION);

		if (choice == JOptionPane.YES_OPTION) {
			frame.dispose();
			new CouponCheck(logVO);

		}

		Button b = (Button) e.getSource();
		if (b.getLabel().equals("<쿠폰 받기>")) {
			b.setEnabled(false);

		}

		// 유저에 쿠폰 저장

		try {
			String path = "C:/storage2/userinfo/[" + logVO.getName() + "]" + logVO.getId() + ".txt";

			FileOutputStream fw = new FileOutputStream(path, true);
			fw.write("/".getBytes());
			fw.write(result.getBytes());

			fw.close();

		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}

}
