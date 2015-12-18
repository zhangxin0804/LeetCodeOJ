// Solution 1 -- 穷竭搜索DFS递归回溯
// 时间复杂度: O( 2^n * n ), 因为 C(1,n) + C(2,n) + C(3, n) + ..... + C(n,n) < 2^n
// 空间复杂度: O(n), 不算解集的话就是递归深度消耗的system stack


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> eachSub = new ArrayList<Integer>();
    	if( nums == null || nums.length == 0 ){
    		result.add(eachSub);
    		return result;
    	}
    	Arrays.sort(nums); // non-descending order
    	helper(result, eachSub, nums, 0);
    	return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> eachSub, int[] nums, int index){
    	result.add( new ArrayList<Integer>(eachSub) );
    	for(int i = index; i < nums.length; i++){
    		eachSub.add(nums[i]);
    		helper(result, eachSub, nums, i + 1);
    		eachSub.remove(eachSub.size()-1);
    	}
    }
}
