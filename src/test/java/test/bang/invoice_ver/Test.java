package test.bang.invoice_ver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    
    public static void main(String[] args) {
//        System.out.println(getWS(1000));
//        System.out.println(1<<2);
        
//        int[] aa = {1,2,3,4,5,1,2,3,4,1,2,3,4,5};
//        System.out.println(getSingleFromThree(aa));
        
//        answer();
//        System.out.println(ballS(100, 10));
//        System.out.println(ballN(100, 10));
        
//        System.out.println(getZS(1, 100));
        
//        System.out.println(get222(2, 6));
        
        System.out.println(getSXH());
        
    }
    
    public static List<Integer> getWS(int c){
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 1 ; i <= c ; i++){
            int sum = 0;
            for(int j = 1 ; j <= i/2 ; j++){
                if(i%j == 0){
                    sum += j;
                }
            }
            if(i == sum){
                list.add(sum);
            }
        }
        return list;
    }

    public static int getSingleFromThree(int[] a){
        int[] bit = new int[32];
        Arrays.fill(bit, 0);
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < 32 ; j++){
                bit[j] += (a[i]>>j)&1;
            }
        }
        int result = 0;
        for(int j = 0 ; j < 32 ; j++){
            if(bit[j]%3 != 0){
                result += 1<<j;
            }
        }
        return result;
    }
    
    public static float ballN(float high, int n){
        for(int i = 1 ; i <= n ; i++){
            high = high/2;
        }
        return high;
    }
    
    public static float ballS(float high, int n){
        float s = 0;
        for(int i = 1 ; i <= n ; i++){
            s += high;
            high = high/2;
            s += high;
        }
        return s;
    }
    
    public static void answer(){  
        float distance=100;float h=0;float s=0;  
        for(int i=1;i<=10;i++){  
            s+=distance+distance/2;  
            distance=distance/2;  
        }  
        s=s-distance;  
        h=distance;  
        System.out.println("第10次落地时，经过："+s+"m");  
        System.out.println("第10次反弹： "+h+"m");  
    }  
    
    public static int getZS(int start, int end){
        int sum = 0;
        for(int i = start ; i <= end ; i++){
            boolean f = true;
            for(int j = 2 ; j < i/2 ; j++){
                if(i%j==0){
                    f = false;
                    break;
                }
            }
            if(f){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
    
    public static int get222(int k, int n){
        int sum = 0;
        int dq = k;
        for(int i = 0 ; i < n ; i++){
            dq = dq*10 + k;
            sum += dq;
        }
        return sum;
    }
    
    public static List<Integer> getSXH(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 123 ; i < 1000 ; i++){
            int g = i%10;
            int s = (i/10)%10;
            int b = i/100;
            int sum3 = g*g*g + s*s*s + b*b*b;
            if(i == sum3){
                list.add(i);
            }
        }
        return list;
    }
    
}
