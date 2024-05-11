package TheWheelHouse.com.demo;

import javax.swing.*;

public class MyAppGUI extends JFrame {
    //1 button to shutdown the app
    //1 text to display that the app is running

    public MyAppGUI() {
        //set the title of the window
        setTitle("My App");
        //set the size of the window
        setSize(400, 300);
        //set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the layout of the window
        setLayout(null);

        //create a button
        JButton btn = new JButton("Shutdown");
        //set the size of the button
        btn.setBounds(150, 100, 100, 30);

        //make the button to shut down the app
        btn.addActionListener(e -> System.exit(0));

        //add the button to the window
        add(btn);

        //create a label
        JLabel lbl = new JLabel("The app is running...");
        //set the size of the label
        lbl.setBounds(150, 50, 150, 30);
        //add the label to the window
        add(lbl);

        //set the window to be visible
        setVisible(true);
    }
}
