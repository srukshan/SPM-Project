package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class KeywordComplexity extends AbstractComplexityFinder {
	
	public KeywordComplexity(String line) {
		super(line);
		removeDoubleQuotedString();
		wordList = new String[] { "alignas", 
				"alignof", 
				"and", 
				"and_eq", 
				"asm", 
				"atomic_cancel", 
				"atomic_commit", 
				"atomic_noexcept", 
				"auto", 
				"bitand", 
				"bitor", 
				"bool", 
				"break", 
				"case", 
				"catch", 
				"char", 
				"char8_t", 
				"char16_t", 
				"char32_t", 
				"class", 
				"compl", 
				"concept", 
				"const", 
				"consteval", 
				"constexpr", 
				"constinit", 
				"const_cast", 
				"continue", 
				"co_await", 
				"co_yield", 
				"decltype", 
				"default", 
				"do", 
				"double", 
				"dynamic_cast", 
				"enum", 
				"explicit", 
				"export", 
				"extern", 
				"false", 
				"float", 
				"for", 
				"friend", 
				"goto", 
				"if", 
				"inline", 
				"int", 
				"long", 
				"mutable", 
				"namespace",
				"noexcept", 
				"not", 
				"not_eq", 
				"nullptr", 
				"operator", 
				"or", 
				"or_eq", 
				"private", 
				"protected", 
				"reflexpr", 
				"register", 
				"reinterpret_cast", 
				"requires", 
				"short", 
				"signed", 
				"sizeof",
				"String", 
				"static_assert", 
				"static_cast", 
				"struct", 
				"switch", 
				"synchronized", 
				"template", 
				"this", 
				"thread_local", 
				"true", 
				"typedef", 
				"typeid", 
				"typename", 
				"union", 
				"unsigned", 
				"using", 
				"virtual", 
				"void", 
				"volatile", 
				"wchar_t", 
				"while", 
				"xor", 
				"xor_eq", 
				"abstract", 
				"assert", 
				"boolean", 
				"byte", 
				"extends", 
				"final", 
				"finally", 
				"implements", 
				"import", 
				"instanceof", 
				"interface", 
				"native", 
				"package", 
				"strictfp", 
				"super", 
				"transient" };
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		String[] checkWordList = getLineWords();
		
		if(checkWordList != null) {
			
			for(String item: checkWordList) {
				
				for(String key: wordList) {
					if(item.equals(key)) {
						complexity.addKeyword(key);
						complexity.addScore(1);
					}
				}
			}
		}
		
		return complexity;
	}
	
}
