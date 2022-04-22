package UserInfo;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationHistory {

	public ReservationHistory(Frame myPageFrame, Panel myPagePanel, UserInfoVO userInfoVO) {

		Panel reservationHistoryFme = new Panel();
		reservationHistoryFme.setBounds(25, 20, 400, 380);
		reservationHistoryFme.setLayout(null);

		myPageFrame.add(reservationHistoryFme);

		new ChangePanel(myPagePanel, reservationHistoryFme);

		Label lbStay = new Label("숙소 ");
		lbStay.setBounds(10, 50, 100, 20);

		Label lbDate = new Label("날짜");
		lbDate.setBounds(10, 83, 100, 20);

		Button btnReservationCancle = new Button("예약취소");
		btnReservationCancle.setBounds(70, 150, 100, 30);
		Button btnReturnPage = new Button("돌아가기");
		// btnReturnPage.setBounds(150, 240, 100, 30);
		btnReturnPage.setBounds(150, 350, 100, 30);

		reservationHistoryFme.add(lbStay);
		reservationHistoryFme.add(lbDate);
		reservationHistoryFme.add(btnReservationCancle);
		reservationHistoryFme.add(btnReturnPage);
		reservationHistoryFme.setVisible(true);

		// 돌아가기버튼 누르면---------------------------------------------
		btnReturnPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// reservationHistoryFme -> myPagePanel
				new ChangePanel(reservationHistoryFme, myPagePanel);
			}
		});

	}
}
