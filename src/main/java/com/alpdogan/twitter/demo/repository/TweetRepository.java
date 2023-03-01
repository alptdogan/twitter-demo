package com.alpdogan.twitter.demo.repository;

import com.alpdogan.twitter.demo.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

    Tweet findTweetById(int id);

}
