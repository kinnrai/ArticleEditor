package Frame;

import javax.swing.*;

import static Other.Global.*;

/**
 * 替换窗口
 *
 * @author 金磊
 */
public class ReplaceFrame {
    /**
     * 构造方法
     */
    public ReplaceFrame(MainFrame mainFrame) {
        String sub = JOptionPane.showInputDialog(mainFrame, "请输入一个想要替换的字符串");
        if ("".equals(sub)) {
            new ErrorFrame(NOT_INPUT_ERROR);
            new ReplaceFrame(mainFrame);
        } else if (sub != null) {
            String rep = JOptionPane.showInputDialog(mainFrame, "请输入想要替换成的字符串(请不要超过原长度)");
            if ("".equals(rep)) {
                new ErrorFrame(NOT_INPUT_ERROR);
                new ReplaceFrame(mainFrame);
            } else if (rep != null) {
                if (rep.length() > sub.length()) {
                    new ErrorFrame(OVER_LENGTH_ERROR);
                    new ReplaceFrame(mainFrame);
                } else {
                    myText.save(mainFrame);
                    int count = myText.replace(sub, rep);
                    if (count != 0) {
                        myText.load(mainFrame);
                        JOptionPane.showMessageDialog(mainFrame, "替换完毕,已将 " + count + " 个 '" + sub + "' 替换成 '" + rep + "'");
                    } else {
                        JOptionPane.showMessageDialog(mainFrame, "没有需要替换的子串");
                    }
                }
            }
        }
    }


}
