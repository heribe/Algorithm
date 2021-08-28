package LeetCode;


public class Kmp {
    /**
     *
     * @param s
     * @param mo
     * @return
     */
    public int kmp(String s,String mo){
        if(mo.length()==0) return 0;
        int[] next = new int[mo.length()];
        getNext(next,mo);
        int ans=0;
        int si=0,moi=0;
        while (si<s.length()&&moi<mo.length()){
            if(s.charAt(si)==mo.charAt(moi)){
                si++;moi++;
            }else if(moi==0) si++;
            else{
                moi=next[moi-1];
            }
        }
        if(moi==mo.length()) return si-moi;
        return -1;


    }

    /**
     * 储存的是i处最大相等后缀，主函数使用时要i-1，并且要处理0处边界
     * 1.初始化
     * 2.不相等情况
     * 3.相等情况
     * 4.next赋值
     * @param next
     * @param mo
     */
    public void getNext(int[] next,String mo){
        int qianm=0,houm=0;
        for (houm = 1; houm < mo.length(); houm++) {
            while(qianm>0&&mo.charAt(qianm)!=mo.charAt(houm)){
                qianm=next[qianm-1];
            }
            if(mo.charAt(qianm)==mo.charAt(houm)) qianm++;
            next[houm]=qianm;
        }

    }
}
