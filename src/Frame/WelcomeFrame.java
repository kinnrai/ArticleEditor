package Frame;

import javax.swing.*;
import java.awt.*;

import static Other.Global.LOGIN_IMAGE_URL;

/**
 * 欢迎界面
 *
 * @author 金磊
 */
public class WelcomeFrame extends Thread {
    MainFrame mainFrame;

    /**
     * 构造方法
     */
    public WelcomeFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * 实现线程
     */
    @Override
    public void run() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                if (LOGIN_IMAGE_URL != null) {
                    graphics.drawImage(new ImageIcon(LOGIN_IMAGE_URL).getImage(), 0, 0, 1080, 570, null);
                }
            }
        };
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setSize(1080, 570);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle("欢迎使用文章编辑器");

        try {
            sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jFrame.dispose();
        mainFrame.getFrame().setVisible(true);
    }
}
