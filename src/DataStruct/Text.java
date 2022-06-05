package DataStruct;

import Frame.ErrorFrame;
import Frame.MainFrame;
import Other.Global;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

import static Other.Global.OVER_LINE_ERROR;
import static Other.Global.myText;

/**
 * 文本类
 *
 * @author 金磊
 */
public class Text {
    LineNode head;
    LineNode tail;
    int lineNumber;

    int alphabetsCount;
    int numbersCount;
    int spacesCount;
    int chineseCharsCount;
    int otherChCount;
    int allCount;

    /**
     * 构造方法
     */
    public Text() {
        this.head = new LineNode(null);
        this.tail = this.head;
        this.lineNumber = 0;

        alphabetsCount = 0;
        numbersCount = 0;
        spacesCount = 0;
        chineseCharsCount = 0;
        otherChCount = 0;
        allCount = 0;
    }

    /**
     * 清空文章
     */
    public void clear() {
        this.tail = this.head;
        this.head.next = null;
        this.lineNumber = 0;
    }

    /**
     * 从内存加载文章到文本域中
     */
    public void load(MainFrame mainFrame) {
        LineNode p = this.head.next;
        mainFrame.getTextArea().setText("");
        while (p != null) {
            for (int i = 0; p.ch[i] != 0; i++) {
                mainFrame.getTextArea().append(String.valueOf(p.ch[i]));
            }
            mainFrame.getTextArea().append("\n");
            p = p.next;
        }
    }

    /**
     * 从文本域保存文章到内存中
     */
    public void save(MainFrame mainFrame) {
        String text = mainFrame.getTextArea().getText();
        String[] lines = text.trim().split("\n");
        myText.clear();
        for (String line : lines) {
            this.tail.next = new LineNode(null);
            this.tail = this.tail.next;
            lineNumber++;
            for (int i = 0; i < line.length(); i++) {
                this.tail.ch[i] = line.charAt(i);
            }
        }
    }

    /**
     * 从文件读取文章到内存中
     */
    public void readFromFile(File selectedFile) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(selectedFile.toPath())));
            String line;
            myText.clear();
            while ((line = reader.readLine()) != null) {
                this.tail.next = new LineNode(null);
                this.tail = this.tail.next;
                lineNumber++;
                for (int i = 0; i < line.length(); i++) {
                    this.tail.ch[i] = line.charAt(i);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            new ErrorFrame(OVER_LINE_ERROR);
        }
    }

    /**
     * 使内存中的文章写入到文件中
     */
    public void writeToFile(File selectedFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(selectedFile.toPath())));
            LineNode p = this.head.next;
            while (p != null) {
                for (int i = 0; p.ch[i] != 0; i++) {
                    writer.write(p.ch[i]);
                }
                //输出完一行后换行
                writer.newLine();
                //刷新缓冲区
                writer.flush();
                p = p.next;
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 统计文章的字母数、空格数和总字数
     */
    public void countAllChars() {
        alphabetsCount = 0;
        numbersCount = 0;
        spacesCount = 0;
        chineseCharsCount = 0;
        otherChCount = 0;
        allCount = 0;

        LineNode p = this.head.next;
        while (p != null) {
            for (int i = 0; p.ch[i] != 0; i++) {
                if (Global.isChineseChar(p.ch[i])) {
                    this.chineseCharsCount++;
                } else if (Character.isAlphabetic(p.ch[i])) {
                    this.alphabetsCount++;
                } else if (Character.isDigit(p.ch[i])) {
                    this.numbersCount++;
                } else if (p.ch[i] == ' ') {
                    this.spacesCount++;
                } else {
                    this.otherChCount++;
                }
                this.allCount++;
            }
            p = p.next;
        }
    }

    /**
     * 查找某一子串在文章中出现的次数
     */
    public int findSubstring(String sub) {
        //使用KMP算法
        return new KnuthMorrisPratt(Text.this, sub).getCount();
    }

    /**
     * 替换某一子串
     */
    public int replace(String sub, String rep) {
        KnuthMorrisPratt kmp = new KnuthMorrisPratt(Text.this, sub);
        ArrayList<ArrayList<Integer>> positionList = kmp.getPositionList();
        LineNode p = this.head.next;
        for (ArrayList<Integer> position : positionList) {
            for (int i = position.size() - 1; i >= 0; i--) {
                for (int j = 0; j < rep.length(); j++) {
                    p.ch[j + position.get(i)] = rep.charAt(j);
                }
                int srcPos = position.get(i) + sub.length();
                int destPos = position.get(i) + rep.length();
                int length = p.ch.length - position.get(i) - sub.length();
                System.arraycopy(p.ch, srcPos, p.ch, destPos, length);
            }
            p = p.next;
        }
        return kmp.getCount();
    }

    /**
     * 删除某一子串
     */
    public int delete(String sub) {
        KnuthMorrisPratt kmp = new KnuthMorrisPratt(Text.this, sub);
        ArrayList<ArrayList<Integer>> positionList = kmp.getPositionList();
        LineNode p = this.head.next;
        for (ArrayList<Integer> position : positionList) {
            for (int i = position.size() - 1; i >= 0; i--) {
                int srcPos = position.get(i) + sub.length();
                int destPos = position.get(i);
                int length = p.ch.length - position.get(i) - sub.length();
                System.arraycopy(p.ch, srcPos, p.ch, destPos, length);
            }
            p = p.next;
        }
        return kmp.getCount();
    }

    public int getAlphabetsCount() {
        return alphabetsCount;
    }

    public int getNumbersCount() {
        return numbersCount;
    }

    public int getSpacesCount() {
        return spacesCount;
    }

    public int getChineseCharsCount() {
        return chineseCharsCount;
    }

    public int getOtherChCount() {
        return otherChCount;
    }

    public int getAllCount() {
        return allCount;
    }
}
