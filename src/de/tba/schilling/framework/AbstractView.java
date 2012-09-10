package de.tba.schilling.framework;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame implements View {
	private GridBagLayout layout;
	private GridBagConstraints constr;
	
	protected boolean packOnStart = true;
	protected boolean resizable = false;
	protected int defaultCloseOperation = EXIT_ON_CLOSE;

	public void init() {
		layout = new GridBagLayout();
		constr = new GridBagConstraints();
		
		constr.insets = new Insets(5, 5, 5, 5);
		constr.fill = GridBagConstraints.BOTH;
		constr.weightx = 1;
		//constr.anchor = GridBagConstraints.NORTHWEST;

		this.setLayout(layout);
		this.setDefaultCloseOperation(defaultCloseOperation);
		this.setResizable(resizable);

	}

	public void start() {
		if(packOnStart)
			this.pack();
		setVisible(true);
	}

	public void stop() {
		setVisible(false);
	}

	public void destroy() {

	}

	protected void addComponent(Component comp, int gridx, int gridy, int gridwidth, int gridheight) {
		constr.gridx = gridx;
		constr.gridy = gridy;
		constr.gridwidth = gridwidth;
		constr.gridheight = gridheight;
		layout.setConstraints(comp, constr);
		this.add(comp);
	}
	
	public void centerFrame() {
		this.setLocationRelativeTo(null);
	}

}
