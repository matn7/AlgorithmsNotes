package november_2025;

import java.util.*;

public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
//        twitter.postTweet(1, 5);
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.unfollow(1, 2);
//        System.out.println(twitter.getNewsFeed(1));
//
//        twitter.postTweet(1, 100);
//        twitter.follow(1, 1);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.unfollow(1, 1);
//        System.out.println(twitter.getNewsFeed(1));


//        twitter.postTweet(5, 108);
//        twitter.postTweet(5, 109);

        // ["Twitter", "postTweet", [1, 101], "postTweet", [1, 102], "follow", [2, 1], "getNewsFeed", [2], "unfollow", [2, 1], "getNewsFeed", [2]]
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Integer>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        if (!followMap.containsKey(userId)) { // in case user does not exists (postTweet executed before follow)
            followMap.put(userId, new HashSet<>());
            followMap.get(userId).add(userId);
        }
        tweetMap.get(userId).add(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followedUsers = followMap.getOrDefault(userId, Collections.emptySet()); // [2, 1] -> user 1 follows user 1 and 2.
        // user 1 has the following tweets [5]
        // user 2 has the following tweets [6]
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int user : followedUsers) {
            List<Integer> followedUserTweets = tweetMap.get(user);
            for (int tweet : followedUserTweets) {
                maxHeap.add(tweet);
            }
        }

        int size = maxHeap.size();
        for (int i = 0; i < Math.min(10, size); i++) {
            result.add(maxHeap.poll());
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
            followMap.get(followerId).add(followerId);
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            throw new RuntimeException("User does not exists");
        }
        if (!followMap.get(followerId).contains(followeeId)) {
            throw new RuntimeException("User: " + followerId + " does not follow: " + followeeId);
        }
        if (followerId != followeeId) { // user cannot unfollow themselves
            followMap.get(followerId).remove(followeeId);
        }
    }

}
