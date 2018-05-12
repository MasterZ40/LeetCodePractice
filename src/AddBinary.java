/**
 * Created by bzhao on 4/3/2018.
 */
public class AddBinary {
    public static void main (String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("111", "111"));
    }
    public String addBinary(String a, String b) {
        String aa = ReverseString(a);
        String bb = ReverseString(b);
        StringBuilder cc= new StringBuilder();
        if(aa.length() < bb.length()){
            while(bb.length() > aa.length()){
                aa += '0';
            }
        }
        else{
            while(aa.length() > bb.length()){
                bb += '0';
            }
        }

        int index = 0;
        boolean highBit = false;
        while(index < aa.length()){
            char charA = aa.charAt(index);
            char charB = bb.charAt(index);
            int temp = (charA > '0' ? 1:0) + (charB > '0'? 1:0) + (highBit? 1:0);

            cc.append(temp % 2 == 0? '0':'1');
            highBit = temp >= 2;
            index ++;
        }
        if(highBit){
            cc.append('1');
        }

        return cc.reverse().toString();
    }

    public String ReverseString(String x) {
        StringBuilder sb = new StringBuilder();
        for(int i = x.length() -1; i >=0; i --) {
            sb.append(x.charAt(i));
        }
        return sb.toString();
    }
}
