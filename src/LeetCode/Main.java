package LeetCode;


import java.util.*;

public class Main {
    int g = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
//        TestThread testThread = new TestThread();
//        testThread.test();


        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        int[] nums = {29,91,62,76,51};
        int[][] graph = {{1,3,7,3,1,1,5,4,10,9,3},{1,10,0,9,2,6,10,2,9,6,2},{5,1,8,4,4,1,8,5,5,7,6},{8,2,8,4,3,5,3,1,5,3,4},{5,2,5,8,9,3,8,2,3,9,6},{8,10,4,4,7,7,8,3,8,8,2},{2,10,10,2,7,6,1,8,4,2,4},{8,5,5,4,4,7,5,0,2,7,4},{7,0,9,5,6,4,5,4,7,5,2},{5,0,8,0,2,3,1,0,9,1,0},{2,6,5,3,5,8,1,4,8,0,9}};

        System.out.println(solution.wordBreak("abcdefgh",new String[]{"abc","a","aa","de","df"}));


    }
}


//["MaxQueue","max_value","pop_front","max_value","push_back","max_value","pop_front",
//        "max_value","pop_front","push_back","pop_front","pop_front","pop_front",
//        "push_back","pop_front","max_value",
//        [],[],[],[],[46],[],
//        [],[],[],[868],[],[],[],
//        [525],[],[]