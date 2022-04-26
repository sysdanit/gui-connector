/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guiconector;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author dani
 */
public class CConnector 
{
    protected Canvas canvas;
    protected int x, y, width, height;
    protected Color borderColor, fillColor, selectedColor;
    protected boolean selected, enlarge;
    protected int selectedBorder;
    protected int pointerLastX, pointerLastY;
    protected CGrid grid;
    
    // --------------------------------------------------------------------------------------------
    public CConnector (Canvas canvas, int x, int y, int width, int height)
    {
        this.canvas         = canvas;
        this.x              = x;
        this.y              = y;
        this.width          = width;
        this.height         = height;
        
        this.borderColor    = Color.GRAY;
        this.fillColor      = Color.LIGHT_GRAY;
        this.selectedColor  = Color.GREEN;
        this.selected       = false;
        this.selectedBorder = 2;
    }
    
    // --------------------------------------------------------------------------------------------
    public void setGrid (CGrid grid)
    {
        this.grid = grid;
    }
    
// --------------------------------------------------------------------------------------------
    public void mousePressed (MouseEvent mouseEvent)
    {

        if (isInBorder (mouseEvent.getX (), mouseEvent.getY ()))
        {
            pointerLastX = mouseEvent.getX ();
            pointerLastY = mouseEvent.getY ();
            enlarge = true;
        }
        else
        {
            if (isInRectangle(mouseEvent.getX (), mouseEvent.getY ()))
            {
                pointerLastX = mouseEvent.getX ();
                pointerLastY = mouseEvent.getY ();
                selected = true;
            }
        }
    }
    
    // --------------------------------------------------------------------------------------------
    public void mouseReleased (MouseEvent mouseEvent)
    {
        if (selected)
        {
            if (grid != null)
            {
                x = grid.getWidth () * divide (x, grid.getWidth ());
                y = grid.getHeight () * divide (y, grid.getHeight());
            }
        }
        
        if (enlarge)
        {
            if (grid != null)
            {
                int calculateWidth = grid.getWidth () * divide (width, grid.getWidth ());
                int calculateHeight = grid.getHeight () * divide (height, grid.getHeight());
                width = calculateWidth > 0 ? calculateWidth : grid.getWidth();
                height = calculateHeight > 0 ? calculateHeight: grid.getHeight ();
            }
        }

        selected    = false;
        enlarge     = false;
        
        canvas.repaint ();
    }

    // --------------------------------------------------------------------------------------------
    public void mouseDragged (MouseEvent mouseEvent)
    {

        if (selected)
        {
            x -= pointerLastX - mouseEvent.getX ();
            y -= pointerLastY - mouseEvent.getY ();
            
            pointerLastX = mouseEvent.getX ();
            pointerLastY = mouseEvent.getY ();
            canvas.repaint ();
        }
        else if (enlarge)
        {
            width -= pointerLastX - mouseEvent.getX ();
            height -= pointerLastY - mouseEvent.getY ();

            pointerLastX = mouseEvent.getX ();
            pointerLastY = mouseEvent.getY ();
            canvas.repaint ();
        }
    }
    
    // --------------------------------------------------------------------------------------------
    private int divide (int dividend, int divider)
    {
        return divider == 0 ? 0 : dividend / divider;
    }
    
    // --------------------------------------------------------------------------------------------
    public void paint (Graphics g)
    {
        g.setColor (fillColor);
        g.fillRoundRect (x, y, width, height, 5, 5);
        g.setColor (borderColor);
        g.drawRoundRect (x, y, width, height, 5, 5);
        
        paintSelected (g);
    }
    
    // --------------------------------------------------------------------------------------------
    public void paintSelected (Graphics g)
    {
        if (selected)
        {
            g.setColor (selectedColor);
            g.drawRoundRect (x - selectedBorder, y - selectedBorder, width + selectedBorder, height + selectedBorder, 5, 5);
        }
    }
    
    // --------------------------------------------------------------------------------------------
    public boolean isInBorder (int pointX, int pointY)
    {
        final int MARGIN = 5;
        
        return 
                pointX >= x + width - MARGIN && 
                pointX < x + width  + MARGIN&& 
                pointY >= y + height - MARGIN && 
                pointY < y + height + MARGIN;
    }
    
    // --------------------------------------------------------------------------------------------
    public boolean isInRectangle (int pointX, int pointY)
    {
        return pointX >= x && pointX < x + width && pointY >= y && pointY < y + height;
    }
}
