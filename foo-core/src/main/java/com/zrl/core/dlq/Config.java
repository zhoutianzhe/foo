package com.zrl.core.dlq;

/**
 * @author zrl
 * @date 2024/5/31 22:16
 * @description xxx
 */
public class Config {

    /**
     * 从open状态进去halfOpen状态的等待时间
     * 毫秒
     */
    private long halfOpenTimeOut = 5*1000;

    /**
     * close状态进入open状态的失败个数
     */
    private int closeFailedCount = 5;

    /**
     * halfOpen状态进去open状态的成功个数
     */
    private int openSuccessCount = 2;

    /**
     * 统计失败的时间窗口
     */
    private long failureTimeInterval = 2*1000;

    public long getHalfOpenTimeOut() {
        return halfOpenTimeOut;
    }

    public void setHalfOpenTimeOut(long halfOpenTimeOut) {
        this.halfOpenTimeOut = halfOpenTimeOut;
    }

    public int getCloseFailedCount() {
        return closeFailedCount;
    }

    public void setCloseFailedCount(int closeFailedCount) {
        this.closeFailedCount = closeFailedCount;
    }

    public int getOpenSuccessCount() {
        return openSuccessCount;
    }

    public void setOpenSuccessCount(int openSuccessCount) {
        this.openSuccessCount = openSuccessCount;
    }

    public long getFailureTimeInterval() {
        return failureTimeInterval;
    }

    public void setFailureTimeInterval(long failureTimeInterval) {
        this.failureTimeInterval = failureTimeInterval;
    }
}
