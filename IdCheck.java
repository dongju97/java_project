package sign;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class IdCheck implements ActionListener {

	static boolean idCheck = true;

	private Frame mf;
	private TextField id;

	public IdCheck(Frame mf, TextField id) {
		this.mf = mf;
		this.id = id;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			File path = new File("C:/storage2/userinfoid/id.txt");
			FileReader filereader = new FileReader(path);
			BufferedReader bufferreader = new BufferedReader(filereader);

			String code = "";
			while ((code = bufferreader.readLine()) != null) {
				if (code.equals(id.getText())) {
					JOptionPane.showMessageDialog(mf, "중복된 아이디입니다.");
					idCheck = false;
					break;
				} else
					idCheck = true;

			}

			if (idCheck == true) {
				JOptionPane.showMessageDialog(mf, "사용 가능한 아이디입니다.");
				id.setEnabled(false);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}