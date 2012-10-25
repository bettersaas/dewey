package common.util.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortString implements Comparator<String> {
	
	public final static int UP = 1;
	
	public final static int DOWN = -1;
	
	public int state;

    public SortString(int state) {
        this.state = state;
    }

    public int compare(String o1, String o2) {
        return (state == SortString.DOWN)? sortDown(o1, o2): sortUp(o1, o2);
    }

    private int sortUp(String o1, String o2) {
        if (o1.compareTo(o2) < 0) {
            return -1;
        } else if (o1.compareTo(o2) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private int sortDown(String o1, String o2) {
        if (o1.compareTo(o2) > 0) {
            return -1;
        } else if (o1.compareTo(o2) < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();
        array.add("ccccc");
        array.add("bbbbb");
        array.add("ddddd");
        array.add("aaaaa");
        array.add("1");
        array.add("11");
        array.add("2");
        array.add("21");
        //sort(List<T> list, Comparator<? super T> c) 根据指定比较器产生的顺序对指定列表进行排序
        Collections.sort(array, new SortString(SortString.UP));
        System.out.println("升序排列的结果：");
        for (String str : array) {
            System.out.println(str);
        }
        
        Collections.sort(array, new SortString(SortString.DOWN));
        System.out.println("降序排列的结果：");
        for (String str : array) {
            System.out.println(str);
        }
    }
}
