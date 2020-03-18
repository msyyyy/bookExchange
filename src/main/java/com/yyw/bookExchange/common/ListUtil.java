package com.yyw.bookExchange.common;

import com.yyw.bookExchange.data.ReturnWrap;

import java.util.List;

public class ListUtil {
    public static  <T> ReturnWrap<List<T>> getByCondition(int offset, int length, List<T> t) {
        if (offset > t.size()){
            return ReturnWrap.returnWithData(null);
        } else if (offset + length > t.size()){
            return ReturnWrap.returnWithData(t.subList(offset,t.size()-offset));
        } else {
            return ReturnWrap.returnWithData(t.subList(offset,length));
        }
    }
}
