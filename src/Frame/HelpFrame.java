package Frame;

import javax.swing.*;

/**
 * 帮助窗口
 *
 * @author 金磊
 */
public class HelpFrame {
    /**
     * 构造方法
     */
    public HelpFrame(MainFrame mainFrame) {
        JOptionPane.showMessageDialog(mainFrame,
                "1.文本域中的文字不会即时保存到内存,可以使用暂存来将其保存到内存\n" +
                        "2.如果不小心修改错了可以使用加载来回退到上一个保存点！");
    }
}
