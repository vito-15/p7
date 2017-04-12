package com.p7.mvc.model;


public class PageViewData {
    private int firstResult;
    private int total;
    private String showTasks;

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getShowTasks() {
        return showTasks;
    }

    public void setShowTasks(String showTasks) {
        this.showTasks = showTasks;
    }
}
