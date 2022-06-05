package Frame;

import javax.swing.*;

import static Other.Global.NOT_INPUT_ERROR;
import static Other.Global.myText;

/**
 * 查找子串窗口
 *
 * @author 金磊
 */
public class FindSubstringFrame {
    public FindSubstringFrame(MainFrame mainFrame) {
        String sub = JOptionPane.showInputDialog(mainFrame, "请输入一个想要查找的字符串");
        if ("".equals(sub)) {
            new ErrorFrame(NOT_INPUT_ERROR);
            new FindSubstringFrame(mainFrame);
        } else if (sub != null) {
            myText.save(mainFrame);
            int count = myText.findSubstring(sub);
            JOptionPane.showMessageDialog(mainFrame, "'" + sub + "'在文章中出现的次数为:" + count);
        }
    }
}
