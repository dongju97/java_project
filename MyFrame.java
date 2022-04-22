package sign;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

	public MyFrame() {

		setBounds(750, 450, 500, 500);

		setLayout(null);
		setResizable(false);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			};
		});

	}

}
