package com.Model;

public class Complexity {

	private int score;
	private String keywords;

	public Complexity() {
		score = 0;
		keywords = "";
	}

	public Complexity(int score, String keywords) {
		this.score = score;
		this.keywords = keywords;
	}
	
	public void increaseScore(int value) {
		score+=value;
	}
	
	public void addKeyword(String keyword) {
		if(keywords == "") {
			keywords = keyword;
		}else {
			keywords += ", " + keyword;
		}
	}

	public int getScore() {
		return score;
	}

	public String getKeywords() {
		return keywords;
	}

	public void merge(Complexity complexity) {
		addKeyword(complexity.getKeywords());
		increaseScore(complexity.getScore());
	}
	
}
