package indi.structures.stack;

public interface Stack<T> {
    /**
     * 判断是否为空
     * @return 空为真
     */
    boolean isEmpty();

    /**
     * data元素入栈
     * @param data
     */
    void push(T data);

    /**
     * 出栈，返回栈顶元素，同时移除
     * @return 返回被移除元素
     */
    T pop();

    /**
     * 获取栈顶元素
     * @return 返回栈顶
     */
    T peek();

    /**
     *  提供当前数值域类型，如果相等返回真
     * @param obj
     * @return 找到为真
     */
    boolean find(T obj);
}
