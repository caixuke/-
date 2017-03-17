//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

// For example, given:
// s: "barfoothefoobarman"
// words: ["foo", "bar"]

// You should return the indices: [0,9].
// (order does not matter).
public class Solution{
	public ArrayList<Integer> findSubstring(String S, String[] L){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(S == null || S.length() == 0 || L == null || L.length == 0)
			return res;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int len = L[0].length();
		for(int i = 0; i < L.length; i++){
			map.put(L[i], map.containsKey(L[i]) ? map.get(L[i]) + 1 : 1);
		}
		for(int i = 0; i < len; i++){
			HashMap<String, Integer> curMap = new HashMap<String, Integer>();
			int count = 0;//count标记当前窗口中是否已经将所有L中的单词包括
			int left = i;
			for(int j = i; j <= S.length() - len; j += len){//从左往右扫描
				String str = S.substring(j, j + len);//一个一个单词扫描
				if(map.containsKey(str)){
					if(curMap.containsKey(str))
						curMap.put(str, curMap.get(str) + 1);
					else
						curMap.put(str, 1);//存在该单词将其加入到当前窗口的curMap中去
					if(curMap.get(str) <= map.get(str))
						count++;//该单词出现的频率不高于在总的L数组出现的频率
					else{//当前的单词在L中，但是它已经在窗口中出现了相应的次数，不应该再加入窗口，此时应该把窗口起始位置向左移动到该单词第一次出现的位置的下一个位置
						while(curMap.get(str) > map.get(str))
						{
							String temp = S.substring(left, left+len);
							if(curMap.containsKey(temp)){
								curMap.put(temp, curMap.get(temp)-1);
								if(curMap.get(temp) < map.get(temp))
									count--;
							}
							left += len;
						}

					}
					if(count == L.length){
						res.add(left);
						String temp = S.substring(left, left+len);
						if(curMap.containsKey(temp))
							curMap.put(temp,curMap.get(temp)-1);
						count--;
						left += len;
					}
				}
				else{
					curMap.clear();
					count = 0;
					left = j + len;
				}
			}
		}
		return res;
	}
}

//Another way
//It's not too hard to find some resemblance between this problem and minimum-window-substring. Actually the main difference is the fact that we are interested at some interval length: we want intervals with fixed length K * M, where K is the number of strings in the "words" array and M the length of each target string. In order to apply the same idea we used for that problem, all we need to do is to map each string from the "words" array to something we are able to index (I prefer to use hashing for this). Also, in order to speed up the algorithm, we can find all occurrences of those strings in S (which is equivalent to do it on demand, but we will potentially do the same matching twice). Notice that, we can simply apply these occurrences as they appear because we are assured that no word is contained by some other. Finally, we use all this information to process each possibility. Notice here that, the fact that all strings has the same length, implies that we have just M (being M the length of each target string) possible starting points, hence we end up performing M linear scans over array with length O(N/M) (being N the length of S) and that makes the scanning stage of the algorithm to be linear on the length of S.
public List<Integer> findSubstring(String s, String[] words){
	int N = s.length();
	List<Integer> indexes = new ArrayList<Integer>(N);
	if(words.length == 0)
		return indexes;
	int M = words[0].length();
	if(N < M * words.length)
		return indexes;
	int last = N - M + 1;
	Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
	int[][] table = new int[2][words.length];
	int failures = 0, index = 0;
	for(int i = 0; i < words.length; ++i){
		Integer mapped = mapping.get(words[i]);
		if(mapped == null){
			++failures;
			mapping.put(words[i], index);
			mapped = index++;
		}
		++table[0][mapped];
	}
	int[] smapping = new int[last];
	for(int i = 0; i < last; ++i){
		String section = s.substring(i, i+M);
		Integer mapped = mapping.get(section);
		if(mapped == null) smapping[i] = -1;
		else smapping[i] = mapped;
	}
	for(int i = 0; i < M; ++i){
		int currentFailures = failures;//number of current mismatches
		int left = i, right = i;
		Arrays.fill(table[1], 0);
		while(right < last){
			while(currentFailures > 0 && right < last){
				int target = smapping[right];
				if(target != -1 && ++table[1][target] == table[0][target])
					--currentFailures;
				right += M;
			}
			while(currentFailures == 0 && left < right){
				int target = smapping[left];
				if(target != -1 && --table[1][target] == table[0][target]-1){
					int length = right - left;
					if((length / M) == words.length)
						indexes.add(left);
					++currentFailures;
				}
				left += M;
			}
		}
	}
	return indexes;
}
























