package JavaFX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloSwingWorldApp extends JFrame {
    public HelloSwingWorldApp(){
        initUI();
    }

    private void initUI() {
        System.out.println(Thread.currentThread().getName());
        setSize(640,480);
        setTitle("HelloSwingWorld");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel=new JPanel(new GridBagLayout());
        JButton myButton=new JButton("Close App");
        myButton.addActionListener(e-> {
            System.out.println("Bye!");
            System.exit(0);
        });
        panel.add(myButton);
        this.add(panel);
        this.setVisible(true);
    }
}
