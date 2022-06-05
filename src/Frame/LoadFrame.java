package Frame;

import javax.swing.*;

import static Other.Global.myText;

/**
 * 加载窗口
 *
 * @author 金磊
 */
public class LoadFrame {
    /**
     * 构造方法
     */
    public LoadFrame(MainFrame mainFrame) {
        int x = JOptionPane.showConfirmDialog(null, "确认加载吗,这将会覆盖当前文本域的内容？", "友情提示",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            myText.load(mainFrame);
            JOptionPane.showMessageDialog(mainFrame, "加载成功");
        }
    }
}
