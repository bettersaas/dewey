package common.util.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortInt implements Comparator<Integer> {
	
    public final static int UP = 1;
    
    public final static int DOWN = -1;
    
    public int state;

    public SortInt(int state) {
        this.state = state;
    }

    public int compare(Integer o1, Integer o2) {
        return (state == SortInt.DOWN)? sortDown(o1, o2): sortUp(o1, o2);
    }

    private int sortUp(Integer o1, Integer o2) {
        if (o1.compareTo(o2) < 0) {
            return -1;
        } else if (o1.compareTo(o2) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private int sortDown(Integer o1, Integer o2) {
        if (o1.compareTo(o2) > 0) {
            return -1;
        } else if (o1.compareTo(o2) < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(11);
        array.add(2);
        array.add(21);
        //sort(List<T> list, Comparator<? super T> c) 根据指定比较器产生的顺序对指定列表进行排序
        Collections.sort(array, new SortInt(SortInt.UP));
        System.out.println("升序排列的结果：");
        for (Integer str : array) {
            System.out.println(str);
        }
        
        Collections.sort(array, new SortInt(SortInt.DOWN));
        System.out.println("降序排列的结果：");
        for (Integer str : array) {
            System.out.println(str);
        }
    }
}
