package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Other.Global.MAIN_FRAME_ICON_URL;
import static Other.Global.TITLE;

/**
 * 编辑器窗口
 *
 * @author 金磊
 */
public class MainFrame extends JFrame {
    boolean saveFlag = false;
    File saveFileRoot = null;

    JFrame frame;
    JPanel panelBottom;
    JMenuBar menuBar1;
    JSeparator separator1;
    JSeparator separator2;
    JTextArea textArea;
    JScrollPane scrollPane;
    /**
     * 菜单"文件": ("打开","保存","另存为","退出")
     */
    JMenu menu1;
    JMenuItem menu1Item1;
    JMenuItem menu1Item2;
    JMenuItem menu1Item3;
    JMenuItem menu1Item4;
    /**
     * 菜单"编辑": ("暂存",“加载”)
     */
    JMenu menu2;
    JMenuItem menu2Item1;
    JMenuItem menu2Item2;
    JMenuItem menu2Item3;
    /**
     * 菜单"工具": ("统计","查找","替换","删除")
     */
    JMenu menu3;
    JMenuItem menu3Item1;
    JMenuItem menu3Item2;
    JMenuItem menu3Item3;
    JMenuItem menu3Item4;
    /**
     * 菜单"其它": ("帮助","关于")
     */
    JMenu menu4;
    JMenuItem menu4Item1;
    JMenuItem menu4Item2;


    /**
     * 构造方法
     */
    public MainFrame() {
        frame = new JFrame(TITLE);
        panelBottom = new JPanel();
        menuBar1 = new JMenuBar();
        separator1 = new JSeparator();
        separator2 = new JSeparator();
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        menu1 = new JMenu("文件");
        menu1Item1 = new JMenuItem("打开");
        menu1Item2 = new JMenuItem("保存");
        menu1Item3 = new JMenuItem("另存为");
        menu1Item4 = new JMenuItem("退出");

        menu2 = new JMenu("编辑");
        menu2Item1 = new JMenuItem("暂存");
        menu2Item2 = new JMenuItem("加载");
        menu2Item3 = new JMenuItem("清屏");

        menu3 = new JMenu("工具");
        menu3Item1 = new JMenuItem("统计");
        menu3Item2 = new JMenuItem("查找");
        menu3Item3 = new JMenuItem("替换");
        menu3Item4 = new JMenuItem("删除");

        menu4 = new JMenu("其它");
        menu4Item1 = new JMenuItem("帮助");
        menu4Item2 = new JMenuItem("关于");

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 500);
        if (MAIN_FRAME_ICON_URL != null) {
            frame.setIconImage(new ImageIcon(MAIN_FRAME_ICON_URL).getImage());
        }
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);

        setLayout();
        setBottomPanel();
        setRelationShip();
        setScrollPane();
        addListener();
    }

    /**
     * 将不同容器关联起来
     */
    private void setRelationShip() {
        frame.add(BorderLayout.CENTER, scrollPane);
        frame.add(BorderLayout.SOUTH, panelBottom);

        menu1.add(menu1Item1);
        menu1.add(menu1Item2);
        menu1.add(menu1Item3);
        menu1.add(separator1);
        menu1.add(menu1Item4);

        menu2.add(menu2Item1);
        menu2.add(menu2Item2);
        menu2.add(separator2);
        menu2.add(menu2Item3);

        menu3.add(menu3Item1);
        menu3.add(menu3Item2);
        menu3.add(menu3Item3);
        menu3.add(menu3Item4);

        menu4.add(menu4Item1);
        menu4.add(menu4Item2);

        menuBar1.add(menu1);
        menuBar1.add(menu2);
        menuBar1.add(menu3);
        menuBar1.add(menu4);

        frame.setJMenuBar(menuBar1);
    }

    /**
     * 为底部栏设置网格
     */
    private void setLayout() {
        GridLayout gridLayout = new GridLayout(1, 2);
        panelBottom.setLayout(gridLayout);
    }

    /**
     * 设置面板
     */
    private void setScrollPane() {
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    /**
     * 给底部栏添加时间
     */
    private void setBottomPanel() {
        JLabel jLabelDate = new JLabel("Date");
        JLabel jLabelTime = new JLabel("Time");
        Timer timeAction = new Timer(1000, e -> {
            long timeMillis = System.currentTimeMillis();
            // 转换日期显示格式
            SimpleDateFormat date = new SimpleDateFormat("yyyy 年 MM 月 dd 日 ");
            jLabelDate.setText("  当前日期： " + date.format(new Date(timeMillis)));
            SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss ");
            jLabelTime.setText("  当前时间： " + time.format(new Date(timeMillis)));
        });
        panelBottom.add(jLabelDate);
        panelBottom.add(jLabelTime);
        timeAction.start();
    }

    /**
     * 添加事件监听器
     */
    private void addListener() {
        //主窗口关闭
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new ClosingFrame();
            }
        });
        //打开
        menu1Item1.addActionListener(e -> {
            new FileReadFrame(MainFrame.this);
            saveFlag = true;
        });
        //保存
        menu1Item2.addActionListener(e -> {
            if (!saveFlag) {
                new FileWriteFrame(MainFrame.this);
                saveFlag = true;
            } else {
                new FileWriteFrame(MainFrame.this, saveFileRoot);
            }
        });
        //另存为
        menu1Item3.addActionListener(e -> {
            new FileWriteFrame(MainFrame.this);
            saveFlag = true;
        });
        //退出
        menu1Item4.addActionListener(e -> new ClosingFrame());
        //暂存
        menu2Item1.addActionListener(e -> new SaveFrame(MainFrame.this));
        //加载
        menu2Item2.addActionListener(e -> new LoadFrame(MainFrame.this));
        //清屏
        menu2Item3.addActionListener(e -> new ClearScreenFrame(MainFrame.this));
        //统计
        menu3Item1.addActionListener(e -> new CountFrame(MainFrame.this));
        //查找
        menu3Item2.addActionListener(e -> new FindSubstringFrame(MainFrame.this));
        //替换
        menu3Item3.addActionListener(e -> new ReplaceFrame(MainFrame.this));
        //删除
        menu3Item4.addActionListener(e -> new DeleteFrame(MainFrame.this));
        //帮助
        menu4Item1.addActionListener(e -> new HelpFrame(MainFrame.this));
        //关于
        menu4Item2.addActionListener(e -> new AboutFrame(MainFrame.this));
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public File getSaveFileRoot() {
        return saveFileRoot;
    }

    public void setSaveFileRoot(File saveFileRoot) {
        this.saveFileRoot = saveFileRoot;
    }

    public JFrame getFrame() {
        return frame;
    }

}
