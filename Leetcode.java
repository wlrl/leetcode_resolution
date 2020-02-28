public class Leetcode {
    public String leetcode_6(String s, int numRows) {
        //寻找规律 每组字符串个数为2n-2
        if (s == null) {
            return null;
        }
        if (s.length() < 3) {
            return new String("");
        }
        int num = 2 * numRows - 2;
        int length = s.length();
        String res = "";
        //打印顶行
        for (int i = 0; i < length; i += num) {
            res += s.substring(i, i + 1);
        }
        //打印中行
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = i; j < length; j += num) {
                int interval = 2 * (numRows - 1 - i);
                String first = s.substring(j, j + 1);
                res = res + first;
                if (j + interval < length) {
                    String second = s.substring(j + interval, j + interval + 1);
                    res = res + second;
                }

            }
        }
        //打印底行
        for (int i = numRows - 1; i < length; i += num) {
            res += s.substring(i, i + 1);
        }
        return res;
    }
    public int leetcode_7(int x) {
        if (x == 0) {
            return 0;
        }
        int res = 0, tmp;
        while (x != 0) {
            tmp = x % 10;
            x = x / 10;
            int max_v = (Integer.MAX_VALUE % (Integer.MAX_VALUE / 10));
            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && tmp > max_v)) return 0;
            if ((res < Integer.MIN_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && tmp < (Integer.MIN_VALUE % (Integer.MIN_VALUE / 10)))) return 0;
            res = res * 10 + tmp;
        }
        return res;
    }
    public int leetcode_8(String str) {
        char[] a = str.toCharArray();
        char[] sym = {'+', '-'};
        byte flag = 0;
        int pos = -1;
        //寻找第一位非空格字符
        for (int i = 0; i < str.length(); i++) {
            //检测全部为空格的数
            if (a[i] == ' ') {
                continue;
            } else if (a[i] == '+' && i < a.length - 1 && (a[i + 1] - '0' > -1) && (a[i + 1] - '0' < 10)) {
                flag = 1;
                pos = i + 1;
                break;
            } else if (a[i] == '-' && i < a.length - 1 && (a[i + 1] - '0' > -1) && (a[i + 1] - '0' < 10)) {
                flag = -1;
                pos = i + 1;
                break;
            } else if (a[i] - '0' >= 0 && a[i] - '0' < 10) {
                pos = i;
                flag = 1;
                break;
            } else {
                return 0;
            }
        }


        if (flag == 0) {
            return 0;
        } else {
            //res为最终结果
            int res = flag * (a[pos]-'0');
            pos++;
            int tmpval = 0;
            int max_10 = Integer.MAX_VALUE / 10;
            int min_10 = Integer.MIN_VALUE / 10;
            while (pos < a.length && a[pos] - '0' >= 0 && a[pos] - '0' < 10) {
                tmpval = flag * (a[pos] - '0');
                //判断上界溢出
                if (res > max_10 || (res == max_10 && tmpval > Integer.MAX_VALUE % max_10)) {
                    return Integer.MAX_VALUE;
                }
                //判断下界溢出
                if (res < min_10 || (res == min_10 && tmpval < Integer.MIN_VALUE % min_10)) {
                    return Integer.MIN_VALUE;
                }
                res = res*10 + tmpval;
                pos++;
            }
            return  res;
        }
    }
    public boolean leetcode_9(int x) {
        //当x为负数或为10的倍数时不为回文数
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int palidrome_num=0;
        while(palidrome_num<x){
            palidrome_num=palidrome_num*10+x%10;
            x=x/10;
        }
        //返回时需要考虑奇数和偶数问题，由于奇数中间位不影响所以可以直接将中间位移除
        return x==palidrome_num || x==palidrome_num%10;
    }

    public String leetcode_1372(String s,int length){
        StringBuilder sb=new StringBuilder();
        for (char i :s.toCharArray()){
            if(i==' '){
                sb.append("%20");
            }else{
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
