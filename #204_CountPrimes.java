
// Soluion 3 --- only need to consider factors up to √n, to avoid repeatedly call on sqrt(n), use i * i <= n
// 时间复杂度: O(nlogn)
// 空间复杂度: O(1)

public class Solution {
    public int countPrimes(int n) { 
        int count = 0;
        if( n <= 2 ){
        	return count;
        }
        for(int i = 2; i < n; i++){
        	if( isPrime(i) ){
        		count++;
        	}
        }
        return count;
    }
    private boolean isPrime(int n){
    	if( n == 2 ){
    		return true;
    	}
    	if( n % 2 == 0 ){
    		return false;
    	}
    	for(int i = 2; i * i < n; i++){
    		if( n % i == 0 ){
    			return false;
    		}
    	}
    	return true;
    }
}


// Solution 4 -- 空间换时间
// 时间复杂度: O(nloglogn)
// 空间复杂度: O(n)

public class Solution {
    public int countPrimes(int n) { 
        int count = 0;
        if( n <= 2 ){
        	return count;
        }

        return isPrime(n);
    }
    private int isPrime(int n){
    	int count = 0;
    	boolean[] markArr = new boolean[n];
    	for(int i = 2; i < n; i++){
    		markArr[i] = true;  // 先都初始化为true
    	}

    	for(int i = 2; i * i < n; i++){
    		if( markArr[i] == false ){
    			continue;
    		}
    		for(int j = i * i; j < n; j += i){
    			markArr[j] = false;
    		}
    	}

    	for(int i = 2; i < n; i++){
    		if( markArr[i] == true ){
    			count++;
    		}
    	}
    	return count;
    }
}
