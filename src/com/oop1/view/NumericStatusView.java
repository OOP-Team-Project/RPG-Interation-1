package com.oop1.view;

import javax.swing.*;
import java.awt.*;

public class NumericStatusView extends JPanel {
    private int currentValue;
    private int minValue;
    private int maxValue;

    public NumericStatusView(int currentValue, int minValue, int maxValue) {
        this.currentValue = currentValue;
        this.minValue = minValue;
        this.maxValue = maxValue;

        setBackground(Color.BLACK);
        setForeground(Color.RED);
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        //double percentage = 0.5 + (double)(currentValue - minValue) / (maxValue - minValue);
        double percentage = (double)(currentValue - minValue) / (maxValue - minValue);
        g.setColor(getForeground());
        g.fillRect(0, 0, (int)(getWidth() * percentage), getHeight());
    }

    /**
     * Sets the actual size of this status view by setting all three of minimum, maximum, and preferred sizes.
     *
     * This forces the view to actually display at this size when part of a BoxLayout
     *
     * @param width
     * @param height
     */
    public void setActualSize(int width, int height) {
        Dimension barSize = new Dimension(width, height);
        setMaximumSize(barSize);
        setMinimumSize(barSize);
        setPreferredSize(barSize);

    }
}
