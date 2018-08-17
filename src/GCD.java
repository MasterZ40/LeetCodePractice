import java.util.Arrays;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
class GCD
{
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 60, 90};
        GCD g = new GCD();
        System.out.println(g.generalizedGCD(6, arr));
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        Arrays.sort(arr);
        int upperlimit = arr[0];
        for(int i = 0; i < num - 1; i ++){
            if(arr[i + 1] - arr[i] < upperlimit){
                upperlimit = arr[i+1] - arr[i];
            }
        }

        if(upperlimit <= 2){
            return upperlimit;
        }

        for(int i = upperlimit; i >= 2; i --){
            boolean isDivisor = true;
            for(int number : arr){
                if(number % i != 0){
                    isDivisor = false;
                    break;
                }
            }
            if(isDivisor){
                return i;
            }
        }

        return 1;
    }
    // METHOD SIGNATURE ENDS
}