package indi.structures.queue;

public interface Queue<T> {
    /**
     * 返回队列长度
     */
    int size();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * data入队
     * @param data
     * @return
     */
    boolean push(T data);

    /**
     * 返回队头元素
     */
    T peek();

    /**
     * 出队
     */
    T pop();

    /**
     * 清空队列
     */
    void clearQueue();

    /**
     *  提供当前数值域类型，如果相等返回真
     * @param obj
     * @return 找到为真
     */
    boolean find(T obj);
}
