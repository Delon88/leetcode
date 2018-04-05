package LC.SOL;

import java.util.*;

public class DesignTwitter {
    class Twitter {

        Map<Integer, User> userMap;

        long addTime = 0l;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userMap = new HashMap<>();
        }

        public void ensureUserExist(int... ids) {
            for (int id : ids) {
                if (!userMap.containsKey(id)) {
                    userMap.put(id, new User(id));
                }
            }
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            ensureUserExist(userId);
            userMap.get(userId).postTweets(tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            ensureUserExist(userId);
            return userMap.get(userId).getNewsFeed();
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            ensureUserExist(followerId, followeeId);
            userMap.get(followerId).follow(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            ensureUserExist(followerId, followeeId);
            userMap.get(followerId).unfollow(followeeId);
        }

        class User {
            public User(int id) {
                this.id = id;
            }

            int id;
            Set<Integer> follows = new HashSet<>();
            List<Tweet> tweets = new ArrayList<>();

            public void follow(int followeeId) {
                follows.add(followeeId);
            }

            public void unfollow(int followeeId) {
                follows.remove(followeeId);
            }

            public List<Integer> getNewsFeed() {
                List<Integer> ret = new ArrayList<>();
                PriorityQueue<TweetsPair> q = new PriorityQueue<>((t1, t2) -> (int) (t2.list.get(t2.index).ts - t1.list.get(t1.index).ts));
                for (Integer f : follows) {
                    if ( !userMap.get(f).tweets.isEmpty() ) {
                        q.offer(new TweetsPair(userMap.get(f).tweets));
                    }
                }
                if ( !tweets.isEmpty() && !follows.contains(id)) q.offer(new TweetsPair(tweets));
                for (int i = 0; i < 10 && !q.isEmpty(); i++) {
                    TweetsPair tp = q.poll();
                    ret.add(tp.list.get(tp.index).id);
                    tp.index--;
                    if (tp.index >= 0) {
                        q.offer(tp);
                    }
                }
                q = null;
                return ret;
            }

            public void postTweets(int id) {
                tweets.add(new Tweet(id, addTime++));
            }
        }

        class TweetsPair {
            List<Tweet> list;
            int index;

            public TweetsPair(List<Tweet> list) {
                index = list.size() - 1;
                this.list = list;
            }
        }

        class Tweet {
            int id;
            long ts;

            public Tweet(int id, long ts) {
                this.id = id;
                this.ts = ts;
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
}
