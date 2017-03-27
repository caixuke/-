//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [2, 3, 6, 7] and target 7, 
// A solution set is: 
// [
//   [7],
//   [2, 2, 3]
// ]
//如果start为0，那么for循环里使用backtrack遍历每一个nums[i],如果start为1，那么从1开始，因为加入nums[0]的所有情形已经被遍历，如此继续下去，所有的情形都被遍历，如果加入这个nums[i]不行的话，在后面一条语句中将这个nums[i]去除，继续遍历。此时已经考虑所有遍历的情况，需要对递归返回的条件进行考虑，首先是remain为0，那么把这条序列加入list中，若小于0则返回，没有结果，大于或等于0则继续，因为等于0的后一步再加入数便会返回了，如此遍历完for循环之后函数自己就会退出。
//总之，考虑所有遍历的情况，设立好返回条件，将事情交给这个函数
public class Solution{
	public List<List<Integer>> combinationSum(int[] candiates, int target)
	{
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candiates);
		backtrack(list, new ArrayList<>(), candiates, target, 0);
		return list;
	}
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else{
			for(int i = start; i < nums.length; i++){
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}

//The main idea reminds an approach for solving coins/knapsack problem - to store the result for all i < target and create the solution from them. For that for each t from 1 to our target we try every candidate which is less or equal to t in ascending order. For each candidate "c" we run through all combinations for target t-c starting with the value greater or equal than c to avoid duplicates and store only ordered combinations.
public class Solution {
    public List<List<Integer>> combinationSum(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}
















