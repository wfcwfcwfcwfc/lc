package io.fengchao.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordSquare {
  Trie trie;

  public static void main(String[] args) {
    WordSquare wordSquare = new WordSquare();
    String[] input = {"area","lead","wall","lady","ball"};
    List<List<String>> result = wordSquare.wordSquares(input);

  }


  public List<List<String>> wordSquares(String[] words) {
    trie = new Trie();
    for(String word : words) {
      trie.insert(word);
    }

    List<List<String>> result = new ArrayList<List<String>>();
    if(words.length == 0) {
      return result;
    }
    helper(new ArrayList<String>(), result, words);
    return result;
  }

  private void helper(List<String> path, List<List<String>> result, String[] words) {
    if(path.size() == words[0].length()) {
      result.add(new ArrayList<String>(path));
      return;
    }

    String prefix = "";
    for(int i = 0; i < path.size(); i++) {
      prefix += path.get(i).charAt(path.size());
    }

    List<String> candidates = trie.getWordByPrefix(prefix);
    // System.out.println(candidates.size());
    for(String word : candidates) {
      path.add(word);
      if(isValid(path, word)) {
        helper(path, result, words);
      }
      path.remove(path.size() - 1);
    }

  }

  private boolean isValid(List<String> path, String word) {
    for(int i = 0; i < path.size(); i++) {
      for(int j = 0; j < path.size(); j++) {
        if(path.get(i).charAt(j) != path.get(j).charAt(i)) {
          return false;
        }
      }
    }

    return true;
  }
  //有后效性 所以不能DP

}

class Trie {

  TrieNode root;
  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();

  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode cur = root;
    char[] carray = word.toCharArray();
    root.words.add(word);
    for(int i = 0;i < carray.length; i++) {
      char c = carray[i];
      TrieNode node = new TrieNode(c);
      if(!cur.map.containsKey(c)) {
        cur.map.put(c, node);
      }
      cur = cur.map.get(c);
      if(i == carray.length - 1) {
        cur.hasWord = true;
      }
      cur.words.add(word);
    }
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode node = find(word);
    if(node == null) {
      return false;
    } else if (node.hasWord) {
      return true;
    } else {
      return false;
    }
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode node = find(prefix);
    if(node == null) {
      return false;
    } else {
      return true;
    }
  }

  private TrieNode find(String word) {
    TrieNode cur = root;
    char[] carray = word.toCharArray();
    for(int i = 0; i < carray.length; i++) {
      char c = carray[i];
      if(!cur.map.containsKey(c)) {
        return null;
      }
      cur = cur.map.get(c);
    }
    return cur;
  }

  public List<String> getWordByPrefix(String prefix) {
    TrieNode node = find(prefix);
    if(node == null) {
      return new ArrayList<String>();
    } else {
      return node.words;
    }
  }

  class TrieNode {
    char c;
    boolean hasWord;
    Map<Character, TrieNode> map;
    List<String> words;

    public TrieNode() {
      hasWord = false;
      map = new HashMap<>();
      this.words = new ArrayList<String>();
    }

    public TrieNode(char c) {
      this.hasWord = false;
      this.map = new HashMap<>();
      this.c = c;
      this.words = new ArrayList<String>();
    }
  }
}