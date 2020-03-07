package com.yyw.bookExchange.common;

import java.util.ArrayList;
import java.util.List;

public class Binary {
    public static List<Integer> getBit(long l){
        List<Integer> res = new ArrayList<>();
        if (l == 0){
            return res;
        }
        long n = 1;
        int bit = 0;
        for ( ;bit < 63; ){
            if ((l&n)!= 0) {
                res.add(bit);
            }
            n = n << 1;
            bit++;
        }
        return res;
    }
}
