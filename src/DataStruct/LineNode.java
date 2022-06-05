package DataStruct;

import static Other.Global.LINE_MAX;

/**
 * 行结点
 *
 * @author 金磊
 * @since 2021/12/1
 */
public class LineNode {
    char[] ch;
    LineNode next;

    /**
     * 构造函数
     */
    public LineNode(LineNode next) {
        ch = new char[LINE_MAX];
        this.next = next;
    }
}
