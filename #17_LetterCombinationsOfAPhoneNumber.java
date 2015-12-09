// Solution 1 ----- 标准的递归回溯穷竭搜索
// 时间复杂度: O(3^k), k 为digit数字的长度
// 空间复杂度: O(k)即递归深度

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if( digits == null || digits.length() == 0 ){
        	return result;
        }
        HashMap<String, String> map = new HashMap<String, String>();
        // 注意不考虑digit为1的情况
        map.put("2", "abc");map.put("3", "def");map.put("4", "ghi");
        map.put("5", "jkl");map.put("6", "mno");map.put("7", "pqrs");
        map.put("8", "tuv");map.put("9", "wxyz");map.put("0", " ");
        dfs(result, digits, map, 0, "");
        return result;
    }
    
    private void dfs(List<String> result, String digits, HashMap<String, String> map, int index, String temp){
    	if( index == digits.length() ){
    		result.add(temp);
    		return; 
    	}
    	String crtDigit = digits.charAt(index) + "";
    	String crtChar = map.get(crtDigit);
    	for(int i = 0; i < crtChar.length(); i++){
    		char c = crtChar.charAt(i);
    		dfs(result, digits, map, index + 1, temp + c);
    	}
    }
}
