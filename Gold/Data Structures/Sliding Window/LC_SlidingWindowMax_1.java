class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> multiset = new TreeMap<>();
        int n = nums.length;
        for(int i = 0 ; i < k ; ++i){
            add(multiset, nums[i]);
        }
        int max = multiset.lastKey();
        int[] res = new int[n - k + 1];
        res[0] = multiset.lastKey();
        for(int i = k ; i < nums.length ; ++i){
            add(multiset, nums[i]);
            delete(multiset, nums[i - k]);
            res[i - k + 1] = multiset.lastKey();
        }
        return res;
    }
    public void add(TreeMap<Integer, Integer>map, int e){
        map.put(e, map.getOrDefault(e, 0 ) + 1);
    }
    public void delete(TreeMap<Integer, Integer>map, int e){
        map.put(e, map.getOrDefault(e, 0 ) - 1);
        if(map.get(e) == 0){
            map.remove(e);
        }
    }
}