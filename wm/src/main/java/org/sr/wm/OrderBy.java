package org.sr.wm;

public enum OrderBy {

	NAME(1), VILLAGE(2), FATHER(3);

	int value;

	private OrderBy(int val) {
		this.value = val;
	}
}
