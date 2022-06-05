package Frame;

import Other.MyFileFilter;

import javax.swing.*;

import static Other.Global.TITLE;
import static Other.Global.myText;

/**
 * 读取文件窗口
 *
 * @author 金磊
 */
public class FileReadFrame {
    int option;

    /**
     * 构造方法
     */
    public FileReadFrame(MainFrame mainFrame) {
        JFileChooser chooser = new JFileChooser("c:/");
        //切换目录到我的电脑
        chooser.changeToParentDirectory();
        //设置一个文件筛选器
        chooser.setFileFilter(new MyFileFilter());

        option = chooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            mainFrame.setSaveFileRoot(chooser.getSelectedFile());
            myText.readFromFile(chooser.getSelectedFile());
            myText.load(mainFrame);
            mainFrame.getFrame().setTitle(mainFrame.getSaveFileRoot().getAbsolutePath() + " - " + TITLE);
            JOptionPane.showMessageDialog(mainFrame, "读取完毕");
        }
    }
}
