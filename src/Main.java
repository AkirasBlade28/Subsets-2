import java.util.ArrayList;
import java.util.List;

/*<Taken from leetcode.com>
 * Given an integer array nums that may contain duplicates, 
 * return all possible subsets (the power set).
   The solution set must not contain duplicate subsets. 
   Return the solution in any order.
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] n = {1,2,3,4,1};
    	System.out.println(subsetsWithDup(n));
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) { 
	
		List <List<Integer>> subsList = new ArrayList <>();
		
		if(nums.length == 1) {
			subsList.add(new ArrayList<>());
			subsList.add(new ArrayList<>());
			subsList.get(1).add(nums[0]);	
			return subsList;	
			}
		else if (nums.length > 1) {
			for(int i = 0; i<nums.length*2; ++i) {
				subsList.add(new ArrayList<>());
			}							// when [0] == 1 len. * 2 [[2len.]]-[[][0]]	
		int restriction = nums.length; // - Each set is a subset of itself or an empty subset
		int r=1;											
		for(int i=0; i<nums.length; ++i) {
			while(r<=restriction) {
					subsList.get(r).add(nums[i]);
					if(r==restriction) {
						r = r - (nums.length - 2); 
						++restriction;
						break;
					}
				++r;
			   }
			}
		check(nums, subsList);
		}
		
		return subsList;
	}

	private static void check(int[] nums, List<List<Integer>> subsList) {
		// trim + rest of numbers set (if not duplicate+check for duplicate)
		List<List<Integer>> l = new ArrayList<>();
		for(int i=0; i<nums.length;++i) {
			l.add(new ArrayList<>());
			l.get(i).add(nums[i]);
		}
		for(int i=0; i<subsList.size();++i) {
			for(List e : l) {
				if(!subsList.contains(e)) {
					subsList.add(e);	
				}
			}
			if(i>1) // check and remove duplicate single number in ar
			if(subsList.get(1).equals(subsList.get(i))) {
				subsList.remove(i);
			}
		}
	}
}
