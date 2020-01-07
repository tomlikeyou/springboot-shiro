package com.dy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author huang
 * @date 2019/11/19 14:23
 * @Disc
 **/
public class Page<T> implements Serializable {

    //当前页码，起始页
    private Integer startPage = 1;
    //每页记录条数
    private Integer pageSize = 5;
    //上一页
    private Integer previousPage;
    //下一页
    private Integer nextPage;
    //总页数
    private Integer totalPage;
    //总记录数
    private Integer totalRecord;
    //数据集合
    private List<T> list;

    //limit offset,pageSize
    public Integer getOffset() {
        return (this.startPage - 1) * pageSize;
    }

    /**
     * 得到总页码数
     */
    public Integer getTotalPage() {

        return (this.totalRecord + this.pageSize - 1) / this.pageSize;
    }

    /*
    得到上一页数
     */
    public Integer getPriviousPage() {
        return (this.startPage - 1) < 1 ? 1 : this.startPage - 1;
    }

    /*
    得到下一页数
     */
    public Integer getNextPage() {
        //表示当前页已经是最后一页了，
        if (this.startPage.equals(this.totalPage)) {
            return this.startPage;
        } else {
            return this.startPage + 1;
        }
    }

    static class SingleTon {
        //饿汉式单例模式
        private static SingleTon instance = new SingleTon();

        private SingleTon() {

        }

        public static SingleTon getInstance() {
            return instance;
        }

        //懒汉式单例模式 线程不安全
        public static SingleTon getInstance1() {
            if (instance == null) {
                instance = new SingleTon();
            }
            return instance;
        }

        //线程同步 速度慢
        public synchronized static SingleTon getInstance2() {
            instance = new SingleTon();
            return instance;
        }

        //线程安全
        public static SingleTon getInstance3() {
            if (instance == null) {
                synchronized (SingleTon.class) {
                    if (instance == null) {
                        instance = new SingleTon();
                    }
                }
            }
            return instance;
        }
    }
}
