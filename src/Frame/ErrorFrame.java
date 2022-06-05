package Frame;

import javax.swing.*;

import static Other.Global.*;

/**
 * 文件读取错误窗口
 *
 * @author 金磊
 */
public class ErrorFrame {
    /**
     * 构造方法
     */
    public ErrorFrame(int error) {
        switch (error) {
            case OVER_LINE_ERROR:
                JOptionPane.showMessageDialog(null, "每一行请不要超过" + LINE_MAX + "个字符", "警告", JOptionPane.WARNING_MESSAGE);
                break;
            case OVER_LENGTH_ERROR:
                JOptionPane.showMessageDialog(null, "输入的字符串请不要超过要替换字符串的长度！", "警告", JOptionPane.WARNING_MESSAGE);
                break;
            case NOT_INPUT_ERROR:
                JOptionPane.showMessageDialog(null, "没有输入！", "警告", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                break;
        }

    }
}