package org.ballad.javacommon.basic.common.lambda;

/**
 * �����ʹ�� �����﷨ʵ��Lambda:
 *
 * (params) -> expression
 * (params) -> statement
 * (params) -> { statements }
 *
 * �����ķ��������ı��κη�������������ֻ���������ô���Լ�д���£�
 * () -> System.out.println("Hello Lambda Expressions");
 *
 * �����ķ������������������������£�
 *
 * (int even, int odd) -> even + odd
 *
 *
 * Function�ӿ��ܹ���Ϊ6���ࣺ
 *
 *     Function��(����)����������뷵�����Ͳ�һ�µĺ�����17���ӿڣ�
 *     UnaryOperator��(һԪ����)��ʾ����Ͳ�������һ�µĺ�����4����
 *     BinaryOperator��(��Ԫ����)��ʾ����Ͳ�������һ�µĺ�����4����
 *     Predicate�������ԣ��ýӿڴ�����һ������������boolean�ĺ�����5����
 *     Supplier������Ӧ�ߣ���ʾû�����������������һ��ֵ��5����
 *     Consumer���������ߣ���ʾ����һ�����������������κ�ֵ��8����
 *
 */
public class LambdaSample {

    public static void main(String[] args) {
//        String s = String.valueOf((int x) -> { return x+1; });
//        System.out.println(s);
    }
}
