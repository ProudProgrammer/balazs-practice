package hu.gaborbalazs.l10n;

import java.util.ListResourceBundle;

public class test extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][]{
			{"1", "1_LRB"},
			{"2", "2_LRB"},
			{"3", "3_LRB"},
			{"4", "4_LRB"},
			{"5", "5_LRB"}
		};
	}

}
