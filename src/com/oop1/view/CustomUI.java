package com.oop1.view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * Created by Miles on 2/7/16.
 */
public class CustomUI {     //Defines a bunch of custom UIs. Separated from the "real" programming.

    public static class funScrollBarUI extends BasicScrollBarUI {

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            super.paintTrack(g, c, trackBounds);
            //g.drawRoundRect((int) trackBounds.getX(), (int) trackBounds.getY(), (int) trackBounds.getWidth(), (int) trackBounds.getHeight(), 1, 1);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            //super.paintThumb(g, c, thumbBounds);
            g.setColor(thumbColor);
            g.fillRoundRect((int) thumbBounds.getX(), (int) thumbBounds.getY(), (int) thumbBounds.getWidth() - 4, (int) thumbBounds.getHeight(), 3, 3 );
            //g.drawRoundRect((int) thumbBounds.getX(), (int) thumbBounds.getY(), (int) thumbBounds.getWidth(), (int) thumbBounds.getHeight(), 1, 1);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton jbutton = new JButton();
            jbutton.setPreferredSize(new Dimension(0, 0));
            jbutton.setMinimumSize(new Dimension(0, 0));
            jbutton.setMaximumSize(new Dimension(0, 0));
            return jbutton;
        }

        @Override
        protected void configureScrollBarColors(){
            this.thumbColor = new Color(70, 70, 70);
            this.trackColor = Color.BLACK;
        }
    }
}
