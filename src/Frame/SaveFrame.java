package Frame;

import javax.swing.*;

import static Other.Global.myText;

/**
 * 暂存窗口
 *
 * @author 金磊
 */
public class SaveFrame {
    /**
     * 构造方法
     */
    public SaveFrame(MainFrame mainFrame) {
        int x = JOptionPane.showConfirmDialog(null, "确认暂存吗,这将会覆盖之前的存档？", "友情提示",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            myText.save(mainFrame);
            JOptionPane.showMessageDialog(mainFrame, "暂存成功");
        }
    }
}
