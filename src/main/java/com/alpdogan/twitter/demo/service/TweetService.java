package com.alpdogan.twitter.demo.service;

import com.alpdogan.twitter.demo.entity.Tweet;
import com.alpdogan.twitter.demo.entity.User;
import com.alpdogan.twitter.demo.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserService userService;

    public String saveTweet (Tweet tweet, User user)
    {
        String text = tweet.getText();
        LocalDateTime createdAt = tweet.getCreatedAt();
        String[] usersWhoLike = tweet.getUsersWhoLike();
        //User user1 = tweet.getUser();

        Tweet tweet1 = new Tweet();
        User user1 = userService.findUserById(user.getId());

        tweet1.setText(text);
        tweet1.setCreatedAt(createdAt);
        tweet1.setUsersWhoLike(usersWhoLike);
        tweet1.setUser(user1);

        /*
        List<Student> students = new ArrayList<>();
        students.add(student);
        course.setStudents(students);
         */

        List<Tweet> tweets = new ArrayList<>();
        tweets.add(tweet1);
        user.setTweets(tweets);

        tweetRepository.save(tweet1);

        return "Tweet Has Been Created.";

    }

    public Tweet findTweetById (int tweetId)
    {
        return tweetRepository.findById(tweetId).get();
    }

    public String updateTweetById (Tweet tweet)
    {
        int tweetId = tweet.getId();

        Optional<Tweet> optionalTweet = tweetRepository.findById(tweetId);
        Tweet tweet1 = optionalTweet.get();

        tweet1 = tweet;

        tweetRepository.save(tweet1);
        return "Changes Saved.";
    }

    public String deleteTweetById (int tweetId)
    {
        Optional<Tweet> optionalTweet = tweetRepository.findById(tweetId);
        Tweet tweet = optionalTweet.get();

        tweetRepository.delete(tweet);

        return "Tweet Deleted.";
    }

    public List<Tweet> findAllTweets()
    {
        return tweetRepository.findAll();
    }

}
