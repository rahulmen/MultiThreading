package com.learning.PrePrationAdobe.AdobeQuetions;

import org.testng.annotations.Test;

public class Problem13 {

    @Test
    public void test(){

        String s1 = "Demo is Test";

        StringBuilder stringBuilder = new StringBuilder();

        String[] strings = s1.split(" ");

        for(int i=1;i<=strings.length;i++){
            stringBuilder.append(strings[strings.length-i]).append(" ");
        }

        System.out.println(stringBuilder);

    }

}
