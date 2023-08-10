class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length <3){
            return false;
        }
        int i = 0 ; 
        boolean  peakFind = false;
        for(i = 1 ; i <arr.length-1 ; i++) {
            if(arr[i-1] == arr[i]){
                return false;
            }else if(arr[i]>arr[i-1] && arr[i] >arr[i+1]){
                peakFind  = true ; 
                break;
            } else if(arr[i]<arr[i-1]){
                return false;
            }
        }
        if(peakFind == false) {
            return peakFind ; 
        }
       
        for(;i < arr.length-1; i++){
            if(arr[i]<=arr[i+1]) {
              return false;  
            }
        }

        return true;
        
    }
}