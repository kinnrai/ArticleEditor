package Frame;

import javax.swing.*;

/**
 * 关闭窗口
 *
 * @author 金磊
 */
public class ClosingFrame {
    /**
     * 构造方法
     */
    public ClosingFrame() {
        int x = JOptionPane.showConfirmDialog(null, "确认退出么？", "友情提示",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            System.exit(0);
        }
    }
}
