// Solution 2 --- 我们维护并更新一个变量furthest, 用于记录我们最远能够到达的位置，最后如果furthest >= length - 1
//                则说明可以jump, 否则不能jump
// 时间复杂度: O(n)
// 空间复杂度: O(1)

public class Solution {
    public boolean canJump(int[] nums) {
        
        if( nums == null || nums.length == 0 ){
        	return false;
        }
        int length = nums.length;
        // 初始时，先赋值一个起始能够最远到达的位置。
        int furthest = nums[0];
        for(int i = 1; i < length; i++){
        	// 如果在当前能够到达的最远位置范围内, 遇到了一个位置, 其能够再次前进到更远的位置，
        	// 那我们就可以继续更新furthest, 然后继续遍历。
        	if( i <= furthest && (i + nums[i]) >= furthest ) {
        		furthest = i + nums[i];
        	}
        }

        return furthest >= length - 1;
    }
}

// Solution 1 --- 贪心greedy思路，注意是判断是否能够reach last index即能否站在最后那个index位置处。
//                我们研究每一个当前位置crt, 对于一个当前位置，如果从它开始，到它最远能走的地方 能够 >= last index
//                我们就可以判断是return true；如果从它开始其最远的能到达的地方不能够触及last index, 
//                我们就要在其能够到达的地方中，选择能够再次前进更远的位置。也就是说，每一次更新当前位置的策略，都是
//                在其能够走到的位置中选择再走时能够走最远的那个位置。

// 时间复杂度: O(n^2)
// 空间复杂度: O(1)

/*
public class Solution {
    public boolean canJump(int[] nums) {
        
        if( nums == null || nums.length == 0 ){
        	return false;
        }
        int length = nums.length;
        int crt = 0; // 维护并更新当前所处的位置
        while( crt + nums[crt] < length - 1 ){
        	// 当前这个位置，还未到last index, 且其再能往前的步子为0, 因此永远
        	// 无法到达last index, return false;
        	if( nums[crt] == 0 ){
        		return false;
        	}
        	int max = Integer.MIN_VALUE;
        	int next = 0;
        	// 注意下面for循环的控制条件。
        	for(int i = crt + 1; i < length && i <= crt + nums[crt]; i++ ){
        		if( i + nums[i] >= max ){
        			max = i + nums[i];
        			next = i;
        		}
        	}
        	crt = next;
        }
        return true;
    }
}
*/
