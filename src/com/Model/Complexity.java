package com.Model;

import java.util.ArrayList;

public class Complexity {

	private int score;
	private ArrayList<String> keywords;
	private String keys = "";

	public Complexity() {
		score = 0;
		keywords = new ArrayList<String>();
	}

	public Complexity(int score, ArrayList<String> keywords) {
		this.score = score;
		this.keywords = keywords;
	}
	
	public void increaseScore(int value) {
		score+=value;
	}
	
	public void addKeyword(String keyword) {
		keywords.add(keyword);
	}

	public int getScore() {
		return score;
	}

	public String getKeywords() {
		keys = "";
		keywords.forEach(keyword -> {
			if(keys == "") {
				keys = keyword;
			}else {
				keys += ", " + keyword;
			}
		});
		return keys;
	}
	
	public ArrayList<String> getKeywordList(){
		return keywords;
	}

	public void merge(Complexity complexity) {
		keywords.addAll(complexity.getKeywordList());
		increaseScore(complexity.getScore());
	}
	
}
