package Frame;

import javax.swing.*;

import static Other.Global.MAIN_FRAME_ICON_URL;

/**
 * 关于窗口
 *
 * @author 金磊
 */
public class AboutFrame {
    /**
     * 构造方法
     */
    public AboutFrame(MainFrame mainFrame) {
        Icon icon = null;
        if (MAIN_FRAME_ICON_URL != null) {
            icon = new ImageIcon(MAIN_FRAME_ICON_URL);
        }
        JOptionPane.showMessageDialog(mainFrame,
                "AUST\n" +
                        "版本 Pro Max Plus Ultra Super Extreme Edition\n" +
                        "© 金磊 保留所有权利",
                "关于",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }
}