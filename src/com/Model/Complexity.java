package com.Model;

import java.util.ArrayList;

public class Complexity {
	private int score;
	private ArrayList<String> keywords;

	public Complexity() {
		score = 0;
		keywords = new ArrayList<String>();
	}

	public Complexity(int score, ArrayList<String> keywords) {
		this.score = score;
		this.keywords = keywords;
	}
	
	public void addScore(int value) {
		score += value;
	}
	
	public void addKeyword(String keyword) {
		keywords.add(keyword);
	}

	public int getScore() {
		return score;
	}

	public String keywordsToString() {
		String keys = "";
		
		for(String item: keywords) {
			if(keys == "") {
				keys = item;
			} else {
				keys += ", "+ item;
			}
		}
		
		return keys;
	}
	
	public ArrayList<String> getKeywords(){
		return keywords;
	}

	public void merge(Complexity complexity) {
		this.keywords.addAll(complexity.getKeywords());
		this.score += complexity.getScore();
	}
	
}
