package service;

import java.util.List;

import dao.TweetDao;
import dto.TweetDto;

public class TweetService {

	public List<TweetDto> findAllTweets() {
		TweetDao tweetDao = new TweetDao();
		List<TweetDto> tweetList = tweetDao.findAll();
		return tweetList;
	}
	
	public void createTweet(int userId, String post) {
		TweetDao tweetDao = new TweetDao();
		tweetDao.create(userId, post);
	}
	
	public List<TweetDto> findUserTweets(int userId) {
		TweetDao tweetDao = new TweetDao();
		List<TweetDto> tweetList = tweetDao.findByUser(userId);
		return tweetList;
	}
	
	public void deleteTweetById(int tweetId, int userId) {
		TweetDao tweetDao = new TweetDao();
		tweetDao.delete(tweetId, userId);
	}
	public TweetDto findUserTweet(int tweetId, int userId) {
		TweetDao tweetDao = new TweetDao();
		TweetDto tweetDto = tweetDao.findById(tweetId, userId);
		return tweetDto;
	
	}
	
	public void updateTweetById(int tweetId, int userId, String post) {
		TweetDao tweetDao = new TweetDao();
		tweetDao.update(tweetId, userId, post);
	}
}