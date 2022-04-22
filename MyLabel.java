package UserInfo;

import java.awt.Label;

public class MyLabel extends Label {

	public MyLabel(String str, int x, int y, int width, int height) {

		setText(str);
		setAlignment(CENTER);
		setBounds(x, y, width, height);

	}

}
