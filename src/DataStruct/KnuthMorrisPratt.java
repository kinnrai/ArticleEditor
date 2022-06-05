package DataStruct;

import java.util.ArrayList;

import static Other.Global.LINE_MAX;

/**
 * KMP算法
 *
 * @author 金磊
 */
public class KnuthMorrisPratt {
    private final int[] next = new int[LINE_MAX];
    private final int[] nextVal = new int[LINE_MAX];
    private final ArrayList<ArrayList<Integer>> positionList = new ArrayList<>();
    private int count = 0;

    /**
     * 构造方法
     */
    public KnuthMorrisPratt(Text myText, String sub) {
        LineNode p = myText.head.next;
        while (p != null) {
            ArrayList<Integer> position = new ArrayList<>();
            getNext(p);
            getNextVal(p);
            int pos = -1;
            while (pos < p.ch.length) {
                pos = kmp(p, sub, pos);
                if (pos != -1) {
                    count++;
                    position.add(pos);
                } else {
                    break;
                }
            }
            p = p.next;
            positionList.add(position);
        }
    }

    /**
     * 对每行执行KMP算法
     */
    private int kmp(LineNode p, String sub, int pos) {
        int i = pos + 1, j = 0;
        while (i < p.ch.length && j < sub.length()) {
            if (j == -1 || p.ch[i] == sub.charAt(j)) {
                i++;
                j++;
            } else {
                j = nextVal[j];
            }
        }
        if (j >= sub.length()) {
            return i - sub.length();
        } else {
            return -1;
        }
    }

    /**
     * 计算next的值
     */
    private void getNext(LineNode p) {
        int i = 0, j = -1;
        next[0] = -1;
        while (i < p.ch.length - 1) {
            if (j == -1 || p.ch[i] == p.ch[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    /**
     * 计算next的函数修正值
     */
    private void getNextVal(LineNode p) {
        int i = 0, j = -1;
        nextVal[0] = -1;
        while (i < p.ch.length - 1) {
            if (j == -1 || p.ch[i] == p.ch[j]) {
                i++;
                j++;
                if (p.ch[i] != p.ch[j]) {
                    nextVal[i] = j;
                } else {
                    nextVal[i] = nextVal[j];
                }
            } else {
                j = nextVal[j];
            }
        }
    }

    public int getCount() {
        return count;
    }

    public ArrayList<ArrayList<Integer>> getPositionList() {
        return positionList;
    }
}
