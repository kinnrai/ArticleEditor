package Frame;

import javax.swing.*;

/**
 * 清屏窗口
 *
 * @author 金磊
 */
public class ClearScreenFrame {
    /**
     * 构造方法
     */
    public ClearScreenFrame(MainFrame mainFrame) {
        int x = JOptionPane.showConfirmDialog(null, "确定要清屏吗？(这不会清除内存中的文章)", "友情提示",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            mainFrame.getTextArea().setText("");
        }
    }
}
