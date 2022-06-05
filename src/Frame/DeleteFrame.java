package Frame;

import javax.swing.*;

import static Other.Global.NOT_INPUT_ERROR;
import static Other.Global.myText;

/**
 * 删除窗口
 *
 * @author 金磊
 */
public class DeleteFrame {
    /**
     * 构造方法
     */
    public DeleteFrame(MainFrame mainFrame) {
        String sub = JOptionPane.showInputDialog(mainFrame, "请输入一个想要删除的字符串");
        if ("".equals(sub)) {
            new ErrorFrame(NOT_INPUT_ERROR);
            new DeleteFrame(mainFrame);
        } else if (sub != null) {
            myText.save(mainFrame);
            int count = myText.delete(sub);
            if (count != 0) {
                myText.load(mainFrame);
                JOptionPane.showMessageDialog(mainFrame, "删除完毕,已删除 " + count + " 个 " + "'" + sub + "'");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "没有需要删除的子串");
            }
        }
    }
}
