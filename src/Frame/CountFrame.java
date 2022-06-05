package Frame;

import javax.swing.*;

import static Other.Global.myText;

/**
 * 统计界面
 *
 * @author 金磊
 */
public class CountFrame {
    /**
     * 构造方法
     */
    public CountFrame(MainFrame mainFrame) {
        myText.save(mainFrame);
        myText.countAllChars();
        JOptionPane.showMessageDialog(mainFrame,
                "字母数：" + myText.getAlphabetsCount() +
                        "\n数字数：" + myText.getNumbersCount() +
                        "\n空格数：" + myText.getSpacesCount() +
                        "\n汉字数：" + myText.getChineseCharsCount() +
                        "\n其它字符：" + myText.getOtherChCount() +
                        "\n总字数：" + myText.getAllCount());
    }
}
