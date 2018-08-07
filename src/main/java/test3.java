public class test3 {
    public static void main(String[] args) {
        encode("sdfsdfsdfsdf");
        encode("3453453454");
        encode("C4d5_3A0");
        encode("24ab_2ta");
        encode("24ab_2t3");
        encode("24ab_2t2222");
        encode("204ab_2t2222_");
        encode("24ab_2_t2_");
        encode("_4A4B325");
        encode("24ab_2t2");
    }

    /**
     *
     * @param value 要编译的字符串
     */
    public static void encode(String value){
        //将传进来的字符串转换成char数组，方便判断
        char[] v = value.toCharArray();
        //声明结果参数
        StringBuffer sb = new StringBuffer();
        //声明当前字节对象
        char a;
        //最后一位下标
        int max = v.length - 1;
        //循环
        for (int i = 0 ; i < v.length ; i++ ) {
             a = v[i];
            if( a >= 'A' && a <= 'Z' || a >= 'a' && a <= 'z'){ //字母
                sb.append(a);
            }else if( a >= '1' && a <= '9') {//数字
                //当是最后一位时，特殊处理
                if(i == max){
                    sb.append(a);
                }else{//不是最后一位
                    for(int j = 0 ; j <= a - '0' ; j++ ){//循环N+1次
                        //当后一位是_时
                        if(v[i+1] == '_'){
                            sb.append("\\UL");
                        }else{
                            sb.append(v[i+1]);
                        }
                    }
                }
            }else if(a == '_'){//下划线
                sb.append("\\UL");
            }else if(a == '0'){//为0
                sb.append(a);
            }
            if(i != max){
                sb.append("_");
            }
        }
        System.out.println(sb.toString());
        decode(sb.toString());
    }

    /**
     *
     * @param value 要还原的字符串
     */
    public static void decode(String value) {
        //根据_切割字符串
        String[] v = value.split("_");
        //声明结果参数
        StringBuffer sb = new StringBuffer();
        //声明当前字符串对象
        String a;
        //声明字符串长度参数
        int max;
        //循环
        for (int i = 0; i < v.length; i++) {
            a = v[i];
            max = a.length();
            //判断长度是否大于1
            if (max > 1) {
                if (!a.equals("\\UL")) {//特殊情况，下划线
                    if(a.substring(0,3).equals("\\UL")){//判断是不是一连串的\UL
                        sb.append(max/3-1);
                    }else{
                        //塞入数字
                        sb.append(max - 1);
                    }
                } else {
                    //塞入下划线
                    sb.append("_");
                }
            } else {//单个字符
                sb.append(a);
            }
        }
        System.out.println(sb.toString());
        System.out.println("------------------------------------");
    }
}

