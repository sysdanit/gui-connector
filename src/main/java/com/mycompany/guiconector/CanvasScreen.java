/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guiconector;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// ------------------------------------------------------------------------------------------------
public class CanvasScreen extends Canvas
{
    private BufferedImage doubleBuffer;
    private Graphics gc;
    private ArrayList <CConnector> connectors;
    private CGrid grid;
    
    // --------------------------------------------------------------------------------------------
    public CanvasScreen ()
    {
        connectors = new ArrayList <> ();
        doubleBuffer = new BufferedImage (100, 100, BufferedImage.TYPE_INT_RGB);
        gc = doubleBuffer.getGraphics();
        grid = new CGrid (50, 50, Color.DARK_GRAY);
        
        setBackground (Color.BLACK);
        
        addMouseListener (new MouseAdapter (){
            @Override
            public void mouseReleased(MouseEvent e) {
                for (CConnector connector : connectors)
                {
                    connector.mouseReleased(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                for (CConnector connector : connectors)
                {
                    connector.mousePressed(e);
                }
            }
            
        });
        
        addMouseMotionListener (new MouseMotionAdapter (){
            @Override
            public void mouseDragged(MouseEvent e) {
                for (CConnector connector : connectors)
                {
                    connector.mouseDragged(e);
                }
            }
            
        });
    }
    
    // --------------------------------------------------------------------------------------------
    public void add (CConnector connector)
    {
        connector.setGrid(grid);
        connectors.add (connector);
    }
    
    // --------------------------------------------------------------------------------------------
    public void update (Graphics g)
    {
        paint (g);
    }
    
    // --------------------------------------------------------------------------------------------
    public void paint (Graphics g)
    {
        clearDoubleBuffer ();
        grid.paint (gc, getWidth (), getHeight ());
                
        for (CConnector connector : connectors)
        {
            connector.paint (gc);
        }
        
        g.drawImage (doubleBuffer, 0, 0, this);
        
    }

    // --------------------------------------------------------------------------------------------
    protected void clearDoubleBuffer ()
    {
        gc.setColor (Color.BLACK);
        gc.fillRect (0, 0, doubleBuffer.getWidth(), doubleBuffer.getHeight ());
    }
    
    // --------------------------------------------------------------------------------------------
    void resizeEvent() 
    {
        doubleBuffer = new BufferedImage (getWidth (), getHeight (), BufferedImage.TYPE_INT_RGB);
        gc = doubleBuffer.getGraphics();
    }
}
