package framelodge;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import login.LogVO;

public class FrameLodgeSubMain {

	public FrameLodgeSubMain(String city, LogVO logVO) { // city = 서울 / 강원 / 경기 / 전라 / 제주 등을 의미
		Font font = new Font("", Font.PLAIN, 20);// tf의 폰트싸이즈를 조절하기 위해 규현
		Frame f = new Frame("상세페이지");
		f.setLayout(null);
		f.setBounds(500, 500, 700, 500);

		String path = "C:/storage2/lodgeinfo/" + city + ".txt"; // 숙박주소 저장장소

		// 배경화면을 불러드린다.
		ImageIcon backWindow = new ImageIcon("src/images/" + city + ".png");
		JLabel j1_back = new JLabel(backWindow); // back 이미지 아이콘을 넣는다.
		j1_back.setBounds(0, 0, 700, 500);

		// 레이블을 불러드린다.
		Label l1 = new Label("숙소종류 선택"); // 레이블 설명 추가하는 란.
		l1.setFont(font);
		l1.setBackground(Color.yellow);
		l1.setBounds(400, 150, 200, 50);

		File file = new File(path);
		try {
			FileReader fis = new FileReader(file);
			BufferedReader bis = new BufferedReader(fis);
			String ss = "";
			Choice area = new Choice();
			while ((ss = bis.readLine()) != null) {
				area.setBounds(400, 200, 200, 500);
				area.add(ss);
			}
			f.add(area);
			area.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					System.out.println(e.getItem().toString());
					String sellodge[] = e.getItem().toString().split("/");
					FrameBookMain fbm = new FrameBookMain(sellodge[0], sellodge[1], logVO);
					f.dispose();
				}
			});
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		f.add(l1);
		f.add(j1_back);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
