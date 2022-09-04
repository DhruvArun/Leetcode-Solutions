import java.util.*;

class Twitter {
    private int count; // Time Stamp
    private HashMap<Integer, HashSet<Integer>> followMap;
    private HashMap<Integer, Tweet> tweetMap;
    
    private class Tweet {
        private int userId;
        private int tweetId;
        private int time;
        
        public Tweet(int userId, int tweetId, int time){
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = time;
        }  
    }
    
    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet post = new Tweet(userId, tweetId, count++);
        tweetMap.put(count, post);
        follow(userId, userId); // Follow oneself to get ones own tweets
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> recent = new ArrayList<>();
        int currTime = count;
        
        while (tweetMap.containsKey(currTime) && recent.size() < 10) {
            Tweet curr = tweetMap.get(currTime);
            if (followMap.get(userId).contains(curr.userId)) {
                recent.add(curr.tweetId);
            }
            currTime--;
        }
        
        return recent;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
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