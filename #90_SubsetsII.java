// Solution 1 ---- 先排序sorting, 暴力枚举递归回溯穷竭搜索，注意去重剪枝处理
// 时间复杂度: O(2^n * n)
// 空间复杂度: O(n)

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> eachSubset = new ArrayList<Integer>();
        if( nums == null || nums.length == 0 ){
        	results.add(eachSubset);
        	return results;
        }
        Arrays.sort(nums);
        dfs(results, eachSubset, nums, 0);
        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> eachSubset, int[] nums, int index){
    	results.add( new ArrayList<Integer>(eachSubset) );
    	for(int i = index; i < nums.length; i++){
    		if( i != index && nums[i] == nums[i-1]){
    			continue;
    		}
    		eachSubset.add(nums[i]);
    		dfs(results, eachSubset, nums, i + 1);
    		eachSubset.remove(eachSubset.size()-1);
    	}
    }
}
