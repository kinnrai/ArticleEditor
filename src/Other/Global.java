package Other;

import DataStruct.Text;

import java.net.URL;

/**
 * 全局变量和常量
 *
 * @author 金磊
 */
public class Global {
    public static final int LINE_MAX = 80;
    public static final int OVER_LINE_ERROR = 1;
    public static final int OVER_LENGTH_ERROR = 2;
    public static final int NOT_INPUT_ERROR = 3;
    public static final String TXT_END = ".txt";
    public static final String TITLE = "文章编辑器 by金磊";
    public static final URL LOGIN_IMAGE_URL = Global.class.getResource("/Images/AUST gate.jpg");
    public static final URL MAIN_FRAME_ICON_URL = Global.class.getResource("/Images/AUST badge.png");
    public static Text myText = new Text();

    /**
     * 判断一个字符是不是汉字
     */
    public static boolean isChineseChar(char ch) {
        return String.valueOf(ch).matches("[\u4e00-\u9fa5]");
    }
}
