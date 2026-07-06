import java.time.LocalDateTime;

class Tweet{
    private Integer userId;
    private Integer tweetId;
    private LocalDateTime tweetedAt;

    public Tweet(Integer userId, Integer tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.tweetedAt = LocalDateTime.now();
    }

    public Integer getUserId(){
        return this.userId;
    }
    public Integer getTweetId(){
        return this.tweetId;
    }
    public LocalDateTime getTweetedAt(){
        return this.tweetedAt;
    }

    public String toString(){
        return "UserId = " + this.userId + ", tweetId = " + this.tweetId + ", tweetedAt = " + tweetedAt;
    }
}
class Twitter {

    private final Map<Integer, Set<Integer>> userFollowersMap;
    private final Map<Integer, List<Tweet>> userTweets;

    public Twitter() {
        userFollowersMap = new HashMap<>();
        userTweets = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId);
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feedHeap = new PriorityQueue<>((a, b)-> b.getTweetedAt().compareTo(a.getTweetedAt()));
        List<Tweet> tweets = userTweets.getOrDefault(userId, new ArrayList<Tweet>());  
        tweets.stream().filter(t-> t.getUserId() == userId).forEach(t -> feedHeap.add(t));
        Set<Integer> followings = userFollowersMap.getOrDefault(userId, Collections.emptySet()); 
        for(Integer following : followings) {
            if(userTweets.containsKey(following)) {
                List<Tweet> followingTweets = userTweets.get(following);
                followingTweets.forEach(t -> feedHeap.add(t));
            }
        }
        System.out.println(feedHeap);

        int count = 1;
        List<Integer> feed = new ArrayList<>();
        while(count<=10 && !feedHeap.isEmpty()){
            feed.add(feedHeap.poll().getTweetId());
            count++;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowersMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowersMap.remove(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */