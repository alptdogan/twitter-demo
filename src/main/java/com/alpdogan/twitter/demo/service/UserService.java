package com.alpdogan.twitter.demo.service;

import com.alpdogan.twitter.demo.entity.Tweet;
import com.alpdogan.twitter.demo.entity.User;
import com.alpdogan.twitter.demo.repository.TweetRepository;
import com.alpdogan.twitter.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    public String saveUser (User user)
    {
        User user1 = new User();

        user1 = userRepository.save(user);

        return "User Has Been Created.";
    }

    public User findUserById (int userId)
    {
        return userRepository.findById(userId).get();
    }

    public String updateUserById (User user)
    {
        int userId = user.getId();

        Optional<User> userOptional = userRepository.findById(userId);
        User user1 = userOptional.get();

        user1 = user;

        userRepository.save(user1);

        return "Changes Saved.";
    }

    public String addTweetToUserById (User user, Tweet tweet)
    {

        //tweet'i baştan yaratabilmeli!!!!!!!!!!

        int userId = user.getId();
        int tweetId = tweet.getId(); //tweet'i baştan yaratabilmeli!!!!!!!!!!

        User user1 = userRepository.findById(userId).get();
        Tweet tweet1 = tweetRepository.findById(tweetId).get();

        List<Tweet> tweets = new ArrayList<>();
        tweets.add(tweet1);
        user.setTweets(tweets);

        List<User> users = new ArrayList<>();
        users.add(user1);
        tweet1.setUser((User) users);

        userRepository.save(user1);

        return "Tweet Added.";

    }

    public String deleteUserById (int userId)
    {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.get();
        userRepository.delete(user);

        return "User Deleted.";
    }

    public List<User> findAllUsers ()
    {
        return userRepository.findAll();
    }


}
