package startup;

import GUI.frame.MainFrame;
import GUI.panel.CategoryPanel;
import GUI.panel.MainPanel;
import GUI.panel.*;
import util.GUIUtil;

import javax.swing.*;
import java.util.logging.Logger;

public class Bootstrap {
    public static void main(String[] args)throws Exception{

        GUIUtil.useLNF();

        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                System.out.println("起飞！");
                MainFrame.getInstance().setVisible(true);
                MainPanel.getInstance().workingPanel.show(CategoryPanel.getInstance());
            }
        });
    }



}
