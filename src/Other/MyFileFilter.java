package Other;

import javax.swing.filechooser.FileFilter;
import java.io.File;

import static Other.Global.TXT_END;

/**
 * 文件筛选器，仅显示文件夹和以“.txt”结尾的文本文件
 *
 * @author 金磊
 */
public class MyFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().endsWith(TXT_END);
    }

    @Override
    public String getDescription() {
        return "文本文档（.txt）";
    }
}
