class Solution {
   public static void main(String[] args){
    int[] max = new int[]{1,8,6,2,5,4,8,3,7};
    System.out.println(maxArea(max));
   } 
    public static int maxArea(int[] height) {
        int max =0;
        int tmpmax =0;
        int j=0;
        int k=height.length-1;
        int a =0;
        int b =0;
        int check1 =0;
        int check2 =0;
        int array[] = new int[3];
        
        while(j<k){
            a=height[j];
            b=height[k];
            check1 = j-1;
            check2 = k+1;
            if(a<b){
                tmpmax = a*(k-j);
                array[0]=tmpmax;
            }
            else{
                tmpmax=b*(k-j);
                array[0]=tmpmax;
            }
            
            if(check1 >=0  && (b<height[check1])){
                tmpmax=b*(k-j-1);
                array[1]=tmpmax;
            }
            else if(check1>=0){
                tmpmax =height[check1] *(k-j-1);
                array[1]=tmpmax;
            }
            else{
                array[1]=0;
            }
            if(check2<height.length && a<(height[check2])){
                tmpmax = a*(k-j+1);
                array[2]=tmpmax;
            }
            else if((k+1)<height.length){
                tmpmax = height[check2]*(k-j+1);
                array[2]=tmpmax;
            } 
            else{
                array[2]=0;
            }
            for(int z=0; z<array.length;z++){
                System.out.println(array[z]);
                if(max<array[z]){
                    max = array[z];
                }
            }
            System.out.println("....................................");
            k--;
            j++;
        }
        return(max);
    }
}