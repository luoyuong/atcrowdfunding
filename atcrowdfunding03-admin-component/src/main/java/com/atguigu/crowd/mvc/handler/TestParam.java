package com.atguigu.crowd.mvc.handler;

import java.util.List;

/**
 * @author hy
 * @create 2022-07-17 19:29
 * @Description
 */
public class TestParam {

    private List<Integer> array;

    public TestParam() {
    }

    public TestParam(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getArray() {
        return array;
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "TestParam{" +
                "array=" + array +
                '}';
    }
}

