/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// Solution 1 --- 经典的一道interval的题目。我们分析一下，两个Interval之间可能存在哪些状态呢？其实就2种状态，
//                overlap和non-overlap, 其中non-overlap又分两种，即B在A左侧或者B再A的右侧,可以通过start和end的大小判断情况。
//                这个题的关键就是！！要维护待插入位置insertPost, 同时待插入的interval涉及到和初始Interval list中Interval的
//                merge操作，因此如果需要merge, 则需要不断维护并更新待插入interval的左右边界，最后循环结束后。再特定位置插入
//                interval, 同时还需要注意，如果待插入interval的右边界定好了不再更新了，那么之后的循环会进入第二个分支，这样
//                的话，对于后续的interval, 仍然要继续加入解集。

// 时间复杂度: O(n)
// 空间复杂度: O(1), 不算解集空间的话。

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    
    	List<Interval> res = new ArrayList<Interval>();
    	if( intervals == null || intervals.size() == 0 ){
    		res.add(newInterval);
    		return res;
    	}
    	int length = intervals.size();
    	// 关键的一个环节，维护一个insertPos用来表示newInterval要被插入在哪个index位置。
    	int insertPos = 0;
    	for(int i = 0; i < length; i++){
    		// 如果待插入的interval的start 大于 当前Interval的end,则将当前interval加入解集，同时插入位置insertPos前进。
    		if( newInterval.start > intervals.get(i).end ){
    			res.add( new Interval(intervals.get(i).start, intervals.get(i).end) );
    			insertPos++;

    		}else if( intervals.get(i).start > newInterval.end ){
    			// 如果待插入的interval的end 小于 当前interval的start, 则也应当将当前interval加入解集，但是不前进insertPos
    			res.add( new Interval(intervals.get(i).start, intervals.get(i).end) );
    		}else{
    			// 如果待插入的interval的start 处于当前 interval的[start, end]之间，那么即意味着有overlap,
    			// 此时我们用Math.min和Math.max得到实际待插入Interval的左右boundary
    			// 但是由于右侧boundary有可能还可以继续延伸，所以循环继续。
    			// 注意：一旦进入过这个分支，之后再循环的话，第一个if不可能再进去了，第二个仍然有可能，第三个也有可能.
    			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
    			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
    		}
    	}
    	res.add(insertPos, new Interval(newInterval.start, newInterval.end) );
    	return res;
    }
}
