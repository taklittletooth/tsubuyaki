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
}