package com.Model;

import java.util.ArrayList;

public class Block {
	private int start, end = -1;
	private String type = "";
	private String name = "";
	private ArrayList<Block> children = new ArrayList<Block>();
	
	public Block(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public Block(int start, int end, String type) {
		this.start = start;
		this.end = end;
		this.type = type;
	}
	
	public Block(int start, String type) {
		this.start = start;
		this.type = type;
	}
	
	public Block(int start, String type, String name) {
		this.start = start;
		this.type = type;
		this.name = name;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean isComplete() {
		return end != -1;
	}
	
	public boolean isChildernComplete() {
		for (Block child : children) {
			if(!child.isComplete()) {
				return false;
			}
		}
		return true;
	}
	
	public void startChild(Block newchild) {
		if(isChildernComplete()) {
			children.add(newchild);
		}else {
			for (Block child : children) {
				if(!child.isComplete()) {
					child.startChild(newchild);
					break;
				}
			}
		}
	}
	
	public Block endBlock(int line) {
		if(!isComplete()) {
			if(isChildernComplete()) {
				this.end = line;
				return this;
			}else {
				for (Block child : children) {
					if(!child.isComplete()) {
						return child.endBlock(line);
					}
				}
			}
		}
		return null;
	}
	
	public void addChild(Block child) {
		children.add(child);
	}
	
	public ArrayList<Block> getLevels(ArrayList<Block> blocks, Line line){
		if((this.start<line.getLineIndex()) && (line.getLineIndex()<this.end)) {
			blocks.add(this);
			for(Block child: this.children) {
				ArrayList<Block> newBlocks = child.getLevels(blocks, line);
				if(newBlocks != null) {
					blocks = newBlocks;
					break;
				}
			}
			return blocks;
		}else
			return null;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("{type:"+type+",start:"+start+",end:"+end+", children: {");
		for (Block block : children) {
			str.append(block.toString()+",");
		}
		str.append("}");
		return str.toString();
	}

	public String getName() {
		return name;
	}
	
	
}
