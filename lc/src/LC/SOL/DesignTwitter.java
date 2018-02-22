package LC.SOL;

import java.util.*;

public class DesignTwitter {
    class Twitter {

        Map<Integer,Set<Integer>> follow;

        Map<Integer,LinkedList<Map.Entry<Long,Integer>>> tweets;

        /** Initialize your data structure here. */
        public Twitter() {
            follow = new HashMap<>();
            tweets = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if ( !tweets.containsKey(userId)) {
                tweets.put(userId, new LinkedList<>());
            }
            tweets.get(userId).put(new Map.Entry<>(System.currentTimeMillis(), tweetId));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            // get all followee's tweet's iterator
            Set<Integer> followes = follow.get(userId);
            Queue<>
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {

        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {

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
}
