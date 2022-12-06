package org.ballad.javacommon.basic.common.lambda;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ClassFunctionSample {

    public static void main(String[] args) {

        List<String> lists = Arrays.asList("I am A","I am B","I am C");
        ClassFunctionSample s = new ClassFunctionSample();

//        String str = 3 -> ClassFunctionSample::tostr;
//        (new ClassFunctionObject(), "aaa") -> ClassFunctionSample::foo);
//        System.out.println((new ClassFunctionObject(), "aaa") -> ClassFunctionSample::foo);

        ClassFunctionSample.foo(new ClassFunctionObject(),"bbb");

        // 通过foreach方法调用::双引号静态方法操作
        lists.forEach(ClassFunctionSample::soutString);

        lists.forEach(s::tostr);



        File myDir = new File("／home/user/files");
        if (myDir.isDirectory()) {
            File[] files = myDir.listFiles(
                    (File f) -> { return f.isFile(); }
            );
            files = myDir.listFiles( File::isFile );
        }
    }

    public static String foo (ClassFunctionObject o, String s){
        return s;
    }

    public String tostr (String s){
        return String.valueOf(s);
    }

    public static String soutString (String s){
        return String.valueOf(s);
    }

}

class ClassFunctionObject {

}


interface FileFilter {

    boolean accept(File pathname);

}