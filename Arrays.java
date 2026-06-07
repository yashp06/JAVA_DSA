public class Arrays {
    public static int linear(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }  
        }return -1;
    }
    public static int largest(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(largest<arr[i]){
                largest=arr[i];
            }
        }
        return largest;
    }
    public static int binary(int arr[],int key){
        int si=0,ei=arr.length-1;
        while (si<=ei) {
            
        
        int mid = (si+ei)/2;
        
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]>key){
               ei= mid-1;
            }
            else{
               si= mid+1;
            }
        }
        return -1;
    }
    public static void revese(int arr[]){
        int si=0,ei=arr.length-1;
        while (si<ei) {
            int temp=arr[ei];
            arr[ei]=arr[si];
            arr[si]=temp;
            si++;
            ei--;
        }
    }

    // public static int maxSumPrefix(int arr[]){
    //     int prefix[]=new int[arr.length];
    //     int maxSum=Integer.MIN_VALUE;
    //     prefix[0]=arr[0];
    //     for(int i=1;i<arr.length;i++){
    //         prefix[i]=prefix[i-1]+arr[i];
    //     }
    // }
    
        
    
    public static int kadanes(int arr[]){
        int cs=0;
        int ms=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
             cs+=arr[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(ms, cs);
        }
        return ms;

    }

    public static void trappedWater(int height[]){
        int leftMax[]=new int[height.length];
        leftMax[0]=height[0];
        for(int i=1;i<height.length;i++){
            leftMax[i]=Math.max(leftMax[i-1], height[i]);     
        }
        int rightMax[]=new int[height.length];
        rightMax[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1], height[i]);
        }
        int trappedWater=0;
        
        for(int i=0;i<height.length;i++){
            int waterLevel=Math.min(leftMax[i], rightMax[i]);
            trappedWater+=waterLevel-height[i];

        }
        System.out.println(trappedWater);
    }
    
    public static void raining(int height[]){
        int leftm[]=new int[height.length];
        leftm[0]=height[0];
        for(int i=1;i<height.length;i++){
           leftm[i]=Math.max(leftm[i-1], height[i]);
        }
        int righm[]=new int[height.length];
        righm[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            righm[i]=Math.max(righm[i+1], height[i]);
        }
        int trapp=0;
        for(int i=0;i<height.length;i++){
            int waterLevel=Math.min(leftm[i], righm[i]);
             trapp+=waterLevel-height[i];
        }
        System.out.println(trapp);

    }

    public static void buyandsell(int price[]){
        int buy=price[0];
        int profit=0;
        for(int i=1;i<price.length;i++){
            if(buy<price[i]){
                profit=Math.max(price[i]-buy, profit);
            }
            else{
                buy=price[i];
            }

        }
        System.out.println(profit);

    }

    // inverted rotation search
     public static int search(int arr[],int si,int ei,int target ){
       while (si<=ei) {
         int mid=si+(ei-si)/2;
         if(arr[mid]== target){
          return mid;
         }
         if(arr[mid]>target){
          ei=mid-1;
         }else{
          si=mid+1;
         }
       }
       return -1;
     }
     public static int invertedSearch(int arr[],int target){
      int min=minSearch(arr);
      if(arr[min]<=target && target<=arr[arr.length-1]){
          return search(arr, min, arr.length-1, target);
      }else{
        return search(arr, 0,min, target);
      }
     }

     public static int  minSearch(int arr[]){
      int si=0,ei=arr.length-1;
      
      while (si<ei) {
        int mid=si+(ei-si)/2;
      
      if(mid>0 && arr[mid-1]>arr[mid]){
        return mid;
      }
      if(arr[si] <arr[mid] && arr[mid]>arr[ei]){
        si=mid+1;
      }else{
          ei=mid-1;
      }
    }
    return si;
     }
  

    

    

   public static void main(String[] args) {
    int price[]={7,1,5,3,6,4};

    buyandsell(price);
    
    
   }
       
       
    
}
