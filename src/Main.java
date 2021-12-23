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
	int [] n = {1,2,3,4,5};
      System.out.println(subsetsWithDup(n));
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) { // original int[] type
	
		List <List<Integer>> subsList = new ArrayList <>();
		
		if(nums.length == 1) {
			subsList.add(new ArrayList<>());
			subsList.add(new ArrayList<>());
			subsList.get(1).add(nums[0]);	
			return subsList;	// 3 len. in. == multidim.arr. [[6]]
		}
		else if (nums.length > 1) {
			for(int i = 0; i<nums.length*2; ++i) {
				subsList.add(new ArrayList<>());
			}			// when [0] == 1 len. * 2 [[2len.]]-[[][0]]	
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
		}
		return subsList;
		}
	}
