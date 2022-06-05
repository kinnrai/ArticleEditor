package Frame;

import Other.MyFileFilter;

import javax.swing.*;
import java.io.File;

import static Other.Global.TITLE;
import static Other.Global.myText;

/**
 * 写入文件窗口
 *
 * @author 金磊
 */
public class FileWriteFrame {
    int option;

    /**
     * 构造方法-当文件已经打开时
     */
    public FileWriteFrame(MainFrame mainFrame, File saveFilePath) {
        myText.save(mainFrame);
        myText.writeToFile(saveFilePath);
        mainFrame.getFrame().setTitle(mainFrame.getSaveFileRoot().getAbsolutePath() + " - " + TITLE);
        JOptionPane.showMessageDialog(mainFrame, "保存完毕");
    }

    /**
     * 构造方法-当文件未打开时
     */
    public FileWriteFrame(MainFrame mainFrame) {
        JFileChooser chooser = new JFileChooser(".");
        //设置一个文件过滤器
        chooser.setFileFilter(new MyFileFilter());

        option = chooser.showSaveDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            mainFrame.setSaveFileRoot(chooser.getSelectedFile());
            myText.save(mainFrame);
            myText.writeToFile(chooser.getSelectedFile());
            mainFrame.getFrame().setTitle(mainFrame.getSaveFileRoot().getAbsolutePath() + " - " + TITLE);
            JOptionPane.showMessageDialog(mainFrame, "保存完毕");
        }

    }

}
