package com.mycompany.guiconector;

// ------------------------------------------------------------------------------------------------

import java.awt.Color;
import java.awt.Graphics;

public class CGrid 
{
    protected int width;
    protected int height;
    protected Color gridColor;
    
    // --------------------------------------------------------------------------------------------
    public CGrid (int width, int height, Color gridColor)
    {
        this.width      = width;
        this.height     = height;
        this.gridColor  = gridColor;
    }
    
    // --------------------------------------------------------------------------------------------
    public void paint (Graphics g, int canvasWidth, int canvasHeight)
    {
        g.setColor (gridColor);
        for (int y = 0; y < canvasHeight; y += height)
        {
            g.drawLine (0, y, canvasWidth, y);
            for (int x = 0; x < canvasWidth; x +=width)
            {
                g.drawLine (x, 0, x, canvasHeight);
            }
        }
    }

    // --------------------------------------------------------------------------------------------
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
}
