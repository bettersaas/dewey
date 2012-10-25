package com.dewey.his.common.util;

import java.util.Comparator;

import com.dewey.his.common.model.FunctionVO;

public class FunctionVOSort  implements Comparator<FunctionVO>{
	
    public int compare(FunctionVO n1, FunctionVO n2) {
        return n1.getId().compareTo(n2.getId());
    }

}
