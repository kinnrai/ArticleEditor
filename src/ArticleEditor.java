import Frame.MainFrame;
import Frame.WelcomeFrame;

/**
 * @author 金磊
 * @since 2021/12/1
 */
public class ArticleEditor {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        new WelcomeFrame(mainFrame).start();
    }
}
