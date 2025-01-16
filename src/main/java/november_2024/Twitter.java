package november_2024;

import java.util.*;

public class Twitter {

    int count;
    Map<Integer, List<Integer[]>> tweetMap;
    Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new Integer[] {count, tweetId});
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!tweetMap.containsKey(userId) && !followMap.containsKey(userId)) {
            return res;
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Make sure the user follows themselves
        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }
        followMap.get(userId).add(userId);

        // Add the latest tweet from each user they follow
        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                int index = tweetMap.get(followeeId).size() - 1;
                Integer[] tweet = tweetMap.get(followeeId).get(index);
                int count = tweet[0];
                int tweetId = tweet[1];
                minHeap.add(new Element(count, tweetId, followeeId, index - 1));
            }
        }

        // Process the tweets and add them to the result
        while (!minHeap.isEmpty() && res.size() < 10) {
            Element element = minHeap.poll();
            res.add(element.tweetId);

            if (element.index >= 0) {
                Integer[] tweet = tweetMap.get(element.followeeId).get(element.index);
                int count = tweet[0];
                int tweetId = tweet[1];
                minHeap.add(new Element(count, tweetId, element.followeeId, element.index - 1));
            }
        }

        return res;
    }


    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    static class Element implements Comparable<Element> {
        int count;
        int tweetId;
        int followeeId;
        int index;

        public Element(int count, int tweetId, int followeeId, int index) {
            this.count = count;
            this.tweetId = tweetId;
            this.followeeId = followeeId;
            this.index = index;
        }

        @Override
        public int compareTo(Element o) {
            return count - o.count;
        }
    }


}
