package com.atguigu.crowd.util;

/**
 * @author hy
 * @create 2022-07-17 20:33
 * @Description
 */
public class ResultEntity<T> {

    private String result;
    private String message;
    private T      data;

    public static final String SUCCESS = "SUCCESS";
    public static final String FIED = "FIED";

    /**
     * 有返回类型的成功
     * @param message
     * @param data
     * @param <E>
     * @return
     */
    public static<E> ResultEntity<E> successWithWithData(String message, E data){
        return new ResultEntity<>(SUCCESS,message,data);
    }

    /**
     * 没有返回类型的成功
     * @param message
     * @param <E>
     * @return
     */
    public static<E> ResultEntity<E> successWithNoData(String message){
        return new ResultEntity<>(SUCCESS,message,null);
    }


    /**
     * 没有返回类型的失败
     * @param message
     * @param <E>
     * @return
     */
    public static<E> ResultEntity<E> fiedWithNoData(String message){
        return new ResultEntity<>(FIED,message,null);
    }



    private ResultEntity() {
    }

    private ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
