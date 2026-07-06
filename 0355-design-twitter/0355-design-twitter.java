class Twitter {

    private static class Tweet {
        int tweetId;
        int timestamp;
        Tweet next;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    private int timestamp;

    // follower -> followees
    private final Map<Integer, Set<Integer>> followMap;

    // user -> latest tweet
    private final Map<Integer, Tweet> tweetMap;

    public Twitter() {
        timestamp = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timestamp++);
        tweet.next = tweetMap.get(userId);   // Insert at head
        tweetMap.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        // User's own latest tweet
        if (tweetMap.containsKey(userId)) {
            maxHeap.offer(tweetMap.get(userId));
        }

        // Latest tweet of every followee
        for (int followee : followMap.getOrDefault(userId, Collections.emptySet())) {
            if (tweetMap.containsKey(followee)) {
                maxHeap.offer(tweetMap.get(followee));
            }
        }

        List<Integer> feed = new ArrayList<>();

        while (!maxHeap.isEmpty() && feed.size() < 10) {

            Tweet latest = maxHeap.poll();
            feed.add(latest.tweetId);

            // Push previous tweet of same user
            if (latest.next != null) {
                maxHeap.offer(latest.next);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        followMap
                .computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followMap.get(followerId);

        if (followees != null) {
            followees.remove(followeeId);

            if (followees.isEmpty()) {
                followMap.remove(followerId);
            }
        }
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