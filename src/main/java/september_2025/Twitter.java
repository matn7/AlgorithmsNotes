package september_2025;

import java.util.*;

public class Twitter {

    int count;
    Map<Integer, List<int[]>> tweetMap; // userId -> list of [count, tweetIds]
    Map<Integer, Set<Integer>> followMap; // userId -> set of followeeId

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[] {count, tweetId});
        count++;
    }

    // O(nlog(n)) time | O(N * m + N * M + n) space
    // m - max num of tweets
    // N - total num of userIds
    // M - max num of followees by any user
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(); // ordered starting from recent
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }

        // Ensure the user follows themselves
        followMap.get(userId).add(userId);

        // Fix: iterate only over the followees of userId, not the entire map
        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                if (index >= 0) {
                    int[] tweet = tweets.get(index);
                    int cnt = tweet[0];
                    int tweetId = tweet[1];
                    maxHeap.add(new int[] {cnt, tweetId, followeeId, index - 1});
                }
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] current = maxHeap.poll();
            int cnt = current[0];
            int tweetId = current[1];
            int followeeId = current[2];
            int index = current[3];
            result.add(tweetId);
            if (index >= 0) {
                int[] tweet = tweetMap.get(followeeId).get(index);
                maxHeap.add(new int[] {tweet[0], tweet[1], followeeId, index - 1});
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // Fix: check if followerId exists before removing
        if (followMap.containsKey(followerId)) {
            // A user cannot unfollow themselves
            if (followeeId != followerId) {
                followMap.get(followerId).remove(followeeId);
            }
        }
    }
}