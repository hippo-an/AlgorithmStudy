package leetcode.array;

public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        for(int j = 0; j < arr.length; j++) {
            for(int i = 0; i < arr.length; i++) {
                if(i == j) continue;
                if(arr[j] == arr[i] * 2) return true;
            }
        }
        return false;
    }
}
