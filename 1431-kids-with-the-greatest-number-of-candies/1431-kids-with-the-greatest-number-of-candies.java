class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> ans = new ArrayList<>(n);
        int greatestCandies = Arrays.stream(candies).max().getAsInt();
        for(int i=0;i<n;i++){
            if(candies[i]+extraCandies>=greatestCandies){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}