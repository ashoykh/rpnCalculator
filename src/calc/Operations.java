package calc;

enum Operations {
	add("+"), subtract("-"), multiply("*"), devide("/");

	String alt;

	Operations(String alt) {
		this.alt = alt;
	}

	public Number operate(Number n2, Number n1) {
		Number result = 0;
		switch (this) {
		case add:
			result = n1.doubleValue() + n2.doubleValue();
			break;
		case subtract:
			result = n1.doubleValue() - n2.doubleValue();
			break;
		case multiply:
			result = n1.doubleValue() * n2.doubleValue();
			break;
		case devide:
			result = n1.doubleValue() / n2.doubleValue();
			break;
		}
		if (result.doubleValue() == result.longValue()) {
			return result.longValue();
		} else
			return result;
	}

	public static Operations get(String alt) {
		for (Operations o : values())
			if (o.alt.equals(alt)) {
				return o;
			}
		return null;
	}
}