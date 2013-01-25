package de.travelbasys.training.framework;

public abstract class AbstractUiComponent {

	private Control control;
	private Formatter formatter;
	private String name;
	protected Object value;

	public AbstractUiComponent() {
		super();
	}

	protected Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public Formatter getFormatter() {
		return formatter;
	}

	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;

		if (null == value) {
			setType(null);
		} else {
			setType(value.getClass());
		}
	}

	public void setType(Class<? extends Object> class1) {
		if (null == class1) {
			formatter = Formatter.NULL;
		} else {
			formatter = AbstractFormatter.createFormatter(class1);
		}
	}

}