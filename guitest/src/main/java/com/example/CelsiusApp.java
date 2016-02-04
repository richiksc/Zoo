package com.example;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class CelsiusApp {
  private static Color menuGray = new Color(0x333333);
  private static void createAndShowGUI() {
    JFrame frame = new JFrame("Celsius Converter");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar myMenuBar = new JMenuBar();
    myMenuBar.setOpaque(true);
    myMenuBar.setBackground(menuGray);
    myMenuBar.setBorderPainted(false);
    myMenuBar.setPreferredSize(new Dimension(500, 30));

    JMenu menu = new JMenu("File");
    menu.setOpaque(true);
    menu.setBackground(menuGray);
    menu.setForeground(Color.white);
    menu.setRolloverEnabled(true);
    menu.setMnemonic(KeyEvent.VK_F);
    menu.getAccessibleContext()
        .setAccessibleDescription("The only menu in this program that has menu items");
    myMenuBar.add(menu);

    menu.getPopupMenu().setBackground(menuGray);
    menu.getPopupMenu().setForeground(Color.white);

    JMenuItem menuItem = new JMenuItem("Save",
        KeyEvent.VK_S);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_S, InputEvent.CTRL_MASK));
    menuItem.getAccessibleContext().setAccessibleDescription(
        "This doesn't really do anything");
    menu.add(menuItem);

    JLabel title = new JLabel("Celsius Converter");
    title.setOpaque(true);
    title.setBorder(new EmptyBorder(16, 72, 16, 72));
    title.setBackground(new Color(0x222222));
    title.setFont(new Font("Segoe UI", Font.PLAIN, 26));
    title.setForeground(Color.white);
    title.setPreferredSize(new Dimension(500, 400));
    title.setVerticalAlignment(JLabel.TOP);

    JButton convert = new JButton("Convert");
    convert.setOpaque(true);
    convert.setBackground(Color.orange);
    convert.setPreferredSize(new Dimension(300, 30));

    frame.setJMenuBar(myMenuBar);
    frame.getContentPane().add(title, BorderLayout.CENTER);
    frame.getContentPane().add(convert, BorderLayout.PAGE_END);

    try
    {
      setUIFont(new javax.swing.plaf.FontUIResource("Tahoma", Font.PLAIN, 12));
    }
    catch(Exception e){
      e.printStackTrace();
    }

    frame.pack();
    frame.setVisible(true);

  }

  public static void main(String[] args) {

    System.out.println();
    SwingUtilities.invokeLater(CelsiusApp::createAndShowGUI);
  }

  public static void setUIFont(javax.swing.plaf.FontUIResource f)
  {
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while(keys.hasMoreElements())
    {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if(value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
    }
  }
}
