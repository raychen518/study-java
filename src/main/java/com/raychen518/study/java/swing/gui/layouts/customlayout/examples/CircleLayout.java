package com.raychen518.study.java.swing.gui.layouts.customlayout.examples;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CircleLayout implements LayoutManager {

	private int minWidth = 0;
	private int minHeight = 0;
	private int preferredWidth = 0;
	private int preferredHeight = 0;
	private boolean sizesSet = false;
	private int maxComponentWidth = 0;
	private int maxComponentHeight = 0;

	@Override
	public void addLayoutComponent(String name, Component component) {
	}

	@Override
	public void removeLayoutComponent(Component component) {
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = preferredWidth + insets.left + insets.right;
		int height = preferredHeight + insets.top + insets.bottom;
		return new Dimension(width, height);
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = minWidth + insets.left + insets.right;
		int height = minHeight + insets.top + insets.bottom;
		return new Dimension(width, height);
	}

	@Override
	public void layoutContainer(Container parent) {
		setSizes(parent);

		// -------------------------------------------------
		// Computing Center of the Circle
		// -------------------------------------------------
		Insets insets = parent.getInsets();

		int containerWidth = parent.getSize().width - insets.left - insets.right;
		int containerHeight = parent.getSize().height - insets.top - insets.bottom;

		int centerX = insets.left + containerWidth / 2;
		int centerY = insets.top + containerHeight / 2;

		// -------------------------------------------------
		// Computing Radius of the Circle
		// -------------------------------------------------
		int radiusX = (containerWidth - maxComponentWidth) / 2;
		int radiusY = (containerHeight - maxComponentHeight) / 2;
		int radius = Math.min(radiusX, radiusY);

		// -------------------------------------------------
		// Laying out Components along the Circle
		// -------------------------------------------------
		int componentCount = parent.getComponentCount();

		for (int i = 0; i < componentCount; i++) {
			Component component = parent.getComponent(i);
			if (component.isVisible()) {
				double angle = 2 * Math.PI * i / componentCount;

				// Center Point of the Component
				int x = centerX + (int) (Math.cos(angle) * radius);
				int y = centerY + (int) (Math.sin(angle) * radius);

				// Move the component so that its center is (x, y)
				// and its size is its preferred size.
				Dimension dimension = component.getPreferredSize();
				component.setBounds(x - dimension.width / 2, y - dimension.height / 2, dimension.width,
						dimension.height);
			}
		}

	}

	public void setSizes(Container parent) {
		if (sizesSet) {
			return;
		}

		int componentCount = parent.getComponentCount();

		preferredWidth = 0;
		preferredHeight = 0;
		minWidth = 0;
		minHeight = 0;
		maxComponentWidth = 0;
		maxComponentHeight = 0;

		// Compute the maximum component widths and heights
		// and set the preferred size to the sum of the component sizes.
		for (int i = 0; i < componentCount; i++) {
			Component component = parent.getComponent(i);
			if (component.isVisible()) {
				Dimension dimension = component.getPreferredSize();
				maxComponentWidth = Math.max(maxComponentWidth, dimension.width);
				maxComponentHeight = Math.max(maxComponentHeight, dimension.height);
				preferredWidth += dimension.width;
				preferredHeight += dimension.height;
			}
		}

		minWidth = preferredWidth / 2;
		minHeight = preferredHeight / 2;
		sizesSet = true;
	}

	private static final String FRAME_TITLE = "Frame Using Circle Layout";
	private static final int FRAME_DEFAULT_WIDTH = 480;
	private static final int FRAME_DEFAULT_HEIGHT = 200;
	private static final int FRAME_DEFAULT_COORDINATE_X = 300;
	private static final int FRAME_DEFAULT_COORDINATE_Y = 240;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				frame.setTitle(FRAME_TITLE);
				frame.setBounds(FRAME_DEFAULT_COORDINATE_X, FRAME_DEFAULT_COORDINATE_Y, FRAME_DEFAULT_WIDTH,
						FRAME_DEFAULT_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setLayout(new CircleLayout());
				frame.add(new JButton("Yellow"));
				frame.add(new JButton("Blue"));
				frame.add(new JButton("Red"));
				frame.add(new JButton("Green"));
				frame.add(new JButton("Orange"));
				frame.add(new JButton("Fuchsia"));
				frame.add(new JButton("Indigo"));
				frame.pack();

				frame.setVisible(true);
			}

		});
	}

}