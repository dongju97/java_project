package framelodge;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import login.LogVO;

public class FrameBookMain {
	// 버튼 코드
	// 1 트윈룸 코드 1 출력
	// 2 패밀리룸 : 코드 2를 출력
	int code = 0;

	public FrameBookMain(String city, String name, LogVO logVO) {

		// 레이블 폰트 설정.
		Font roomFont = new Font("", Font.PLAIN, 30);

		Frame f = new Frame("숙박예약화면창");
		f.setLayout(null);
		f.setBounds(500, 100, 1000, 800);
		System.out.println(city);
		System.out.println(name);
		// 숙박지 이름은 name으로 저장된다.
		// a모텔, b펜션 등등 .

		// 도시에 저장된 모텔들의 정보의 경로를 지정한다.
		// String path = "C:\\java\\lodgeinfo\\" + city;
		// 가져온 숙박지 이름.
		ImageIcon backWindow = new ImageIcon("src/images/" + city + name + ".png");
		JLabel j1_back = new JLabel(backWindow); // back 이미지 아이콘을 넣는다.
		j1_back.setBounds(0, 50, 900, 700);

		// 레이블만들기.
		// 레이블화면 띄우기 메임화면
		Label roomName = new Label(name);// 호텔 이름 기입하는 레이블 만듦.
		roomName.setFont(roomFont);
		roomName.setBackground(Color.GREEN);
		roomName.setBounds(180, 500, 150, 30);

		// 레이블화면 띄우기 트윈 룸
		Label twinRoom = new Label("트윈 룸");
		twinRoom.setFont(roomFont);
		twinRoom.setBackground(Color.red);
		twinRoom.setBounds(600, 335, 150, 30);

		// 레이블화면 띄우기 패밀리룸
		Label familyRoom = new Label("패밀리 룸");
		familyRoom.setFont(roomFont);
		familyRoom.setBackground(Color.red);
		familyRoom.setBounds(600, 630, 150, 30);

		// 화면에 버튼 만들기.
		// 취소 //예약하기 //리뷰보기 버튼
		// 방 선택 버튼
		Button exit = new Button("뒤로가기");
		exit.setBounds(50, 600, 50, 50);
		Button book1 = new Button("예약"); // 예약버튼 추가
		book1.setBounds(700, 335, 150, 30);
		Button book2 = new Button("예약");
		book2.setBounds(700, 630, 150, 30);

		f.add(book1);
		f.add(book2);
		f.add(twinRoom);
		f.add(familyRoom);
		f.add(exit);
		f.add(roomName);
		f.add(j1_back);

		// 트윈룸 버튼을 눌렀을 때
		book1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code = 1;
				System.out.println("code : " + code);
				JOptionPane.showMessageDialog(book1, "트윈룸 예약버튼을 눌렀습니다.");
				FrameBookSubMain bookF = new FrameBookSubMain(code, name, city, logVO);
			}
		});
		// 패밀리룸 버튼을 눌렀을 때
		book2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code = 2;
				System.out.println("code : " + code);
				JOptionPane.showMessageDialog(book2, "패밀리룸 예약버튼을 눌렀습니다.");
				// 에약 화면으로 넘어간다. 예약 메소드 구현하기
				FrameBookSubMain bookF = new FrameBookSubMain(code, name, city,logVO);
			}
		});
		f.setVisible(true);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}

		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}
}
