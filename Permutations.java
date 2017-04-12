//Given a collection of distinct numbers, return all possible permutations.
public List<List<Integer>> permute(int[] nums){
	List<List<Integer>> list = new ArrayList<>();
	backtrack(list, new ArrayList<>(), nums);
	return list;
}
private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums){
	if(tempList.size() == nums.length){
		list.add(new ArrayList<>(tempList));
	}else{
		for(int i = 0; i < nums.length; i++){
			if(tempList.contains(nums[i])) continue;
			tempList.add(nums[i]);
			backtrack(list, tempoList, nums);//搜索有这个数的所有序列
			tempList.remove(tempList.size() - 1);//已经搜索完所有关于这个数的序列，删除这个数，在for循环中换一个数搜索
		}
	}
}