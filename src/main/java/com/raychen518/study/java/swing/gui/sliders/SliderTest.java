package com.raychen518.study.java.swing.gui.sliders;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest {

	private static final String FRAME_TITLE = "Test - Slider";
	private static final int FRAME_DEFAULT_WIDTH = 800;
	private static final int FRAME_DEFAULT_HEIGHT = 480;
	private static final int FRAME_DEFAULT_COORDINATE_X = 400;
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

				JPanel panel = new JPanel();
				frame.add(panel);

				Hashtable<Integer, Component> labelTable0To100 = new Hashtable<>();
				for (int i = 0; i <= 100; i += 10) {
					labelTable0To100.put(i, new JLabel(String.valueOf(i)));
				}

				Hashtable<Integer, Component> labelTableAToE = new Hashtable<>();
				labelTableAToE.put(0, new JLabel("A"));
				labelTableAToE.put(1, new JLabel("B"));
				labelTableAToE.put(2, new JLabel("C"));
				labelTableAToE.put(3, new JLabel("D"));
				labelTableAToE.put(4, new JLabel("E"));

				{
					JSlider slider = new JSlider();
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider();
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(20);
					slider.setMinorTickSpacing(5);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider(0, 200, 100);
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(20);
					slider.setMinorTickSpacing(5);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider();
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(20);
					slider.setMinorTickSpacing(5);
					slider.setSnapToTicks(true);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider();
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(20);
					slider.setMinorTickSpacing(5);
					slider.setSnapToTicks(true);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTable0To100);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider();
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(20);
					slider.setMinorTickSpacing(5);
					slider.setSnapToTicks(true);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTable0To100);
					slider.setPaintTrack(false);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider();
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(20);
					slider.setMinorTickSpacing(5);
					slider.setSnapToTicks(true);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTable0To100);
					slider.setInverted(true);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider();
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(20);
					slider.setMinorTickSpacing(5);
					slider.setSnapToTicks(true);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTable0To100);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider(0, 4, 2);
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(1);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTableAToE);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider(SwingConstants.VERTICAL, 0, 4, 2);
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(1);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTableAToE);
					slider.setInverted(true);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider(0, 4, 2);
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(1);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTableAToE);
					slider.setEnabled(false);
					panel.add(slider);
				}

				{
					JSlider slider = new JSlider(0, 4, 2);
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(1);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTableAToE);
					slider.setForeground(Color.RED);
					slider.setBackground(Color.CYAN);
					panel.add(slider);
				}

				{
					JTextField textField = new JTextField(4);

					JSlider slider = new JSlider();
					slider.setPaintTicks(true);
					slider.setMajorTickSpacing(10);
					slider.setSnapToTicks(true);
					slider.setPaintLabels(true);
					slider.setLabelTable(labelTable0To100);
					slider.addChangeListener(new ChangeListener() {

						@Override
						public void stateChanged(ChangeEvent event) {
							JSlider slider = (JSlider) event.getSource();
							textField.setText(String.valueOf(slider.getValue()));
						}

					});
					panel.add(slider);

					panel.add(textField);
				}

				frame.setVisible(true);
			}

		});
	}

}
