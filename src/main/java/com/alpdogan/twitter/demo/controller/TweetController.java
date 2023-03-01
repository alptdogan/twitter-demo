package com.alpdogan.twitter.demo.controller;

import com.alpdogan.twitter.demo.entity.Tweet;
import com.alpdogan.twitter.demo.entity.User;
import com.alpdogan.twitter.demo.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;

    @PostMapping("/saveTweet")
    private ResponseEntity<String> saveTweet(@RequestBody Tweet tweet, @ModelAttribute User user)
    {
        String saveText = tweetService.saveTweet(tweet, user);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @GetMapping("/findTweet")
    public ResponseEntity<Tweet> findTweetById (@RequestParam int tweetId)
    {
        Tweet tweet = tweetService.findTweetById(tweetId);

        return new ResponseEntity<>(tweet, HttpStatus.OK);
    }

    @PostMapping("/updateTweet")
    public ResponseEntity<String> updateTweet (@RequestBody Tweet tweet)
    {
        String updateText = tweetService.updateTweetById(tweet);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTweet")
    public ResponseEntity<String> deleteTweet (@RequestParam int tweetId)
    {
        String deleteText = tweetService.deleteTweetById(tweetId);

        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

    @GetMapping("/findAllTweets")
    public ResponseEntity<List<Tweet>> findAllTweets ()
    {
        List<Tweet> tweets = tweetService.findAllTweets();

        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
