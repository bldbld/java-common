package org.ballad.javacommon.basic.common.lambda;

/**
 * 你可以使用 下面语法实现Lambda:
 *
 * (params) -> expression
 * (params) -> statement
 * (params) -> { statements }
 *
 * 如果你的方法并不改变任何方法参数，比如只是输出，那么可以简写如下：
 * () -> System.out.println("Hello Lambda Expressions");
 *
 * 如果你的方法接受两个方法参数，如下：
 *
 * (int even, int odd) -> even + odd
 *
 *
 * Function接口总共分为6大类：
 *
 *     Function：(函数)代表其参数与返回类型不一致的函数（17个接口）
 *     UnaryOperator：(一元操作)表示结果和参数类型一致的函数（4个）
 *     BinaryOperator：(二元操作)表示结果和参数类型一致的函数（4个）
 *     Predicate：（断言）该接口代表传入一个参数并返回boolean的函数（5个）
 *     Supplier：（供应者）表示没有输入参数，但返回一个值（5个）
 *     Consumer：（消费者）表示传入一个参数，但不返回任何值（8个）
 *
 */
public class LambdaSample {

    public static void main(String[] args) {
//        String s = String.valueOf((int x) -> { return x+1; });
//        System.out.println(s);
    }
}
