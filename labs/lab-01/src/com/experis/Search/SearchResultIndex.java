package com.experis.Search;

import com.experis.dataBase.DataBase;
import com.experis.dataBase.EncodedString;

import java.util.ArrayList;

class SearchResultIndex implements Search<String[]> {

    final private DataBase dataBase;
    final private ArrayList<String> ignorList;
    ArrayList<Integer> wantedWord;
    ArrayList<Integer> unwantedWord;
    ArrayList<EncodedString> result;


    SearchResultIndex(ArrayList<String> ignorList, DataBase dataBase) {
        this.ignorList = ignorList;
        this.dataBase = dataBase;
        result = new ArrayList<>();
    }

    @Override
    public void search(String[] choiceWordsArr) {
        addwantedWord(choiceWordsArr);
        addToUnwontedWords(choiceWordsArr);
    }

    private void addwantedWord(String[] choiceWordsArr) {
        wantedWord = new ArrayList<>();
        for (String choiceWord : choiceWordsArr) {

            if (isStartWhith(choiceWord, "-") == false) {
                String word = choiceWord;
                word = isStartWithPlus(choiceWord, word);
                if (chekIfIsIgnorListWord(word) == false) {
                    int val = dataBase.encodedMap.getIndex(word);
                    if (val >= 0) ;
                    wantedWord.add(val);
                }
            }
        }
    }

    private void addToUnwontedWords(String[] choiceWordsArr) {
        unwantedWord = new ArrayList<>();
        for (String choiceWord : choiceWordsArr) {

            if (isStartWhith(choiceWord, "-")) {
                String wordWithoutSign = choiceWord.substring(1, choiceWord.length());
                if (chekIfIsIgnorListWord(wordWithoutSign) == false) {
                    int val = dataBase.encodedMap.getIndex(wordWithoutSign);
                    if (val > 0) {
                        unwantedWord.add(val);
                    }
                }
            }
        }
    }

    ArrayList<EncodedString> addToResultTitle(ArrayList<EncodedString> fild) {

        addWonteBookToResult(fild);
        removeBookNoContainAllWord();
        removeUnwontedWordFromResult();
        return result;
    }

    private void addWonteBookToResult(ArrayList<EncodedString> fild) {
        for (EncodedString e : fild) {
            for (int want : wantedWord) {
                if (e.codeStr.indexOf(want) >= 0) {
                    result.add(e);
                    break;
                }
            }
        }
    }

    private void removeUnwontedWordFromResult() {
        int index = 0;
        Boolean isRemove = false;
        while (index != result.size()) {
            {
                for (int unwont : unwantedWord) {
                    if (result.get(index).codeStr.indexOf(unwont) >= 0) {
                        result.remove(index);
                        isRemove = true;
                        break;
                    }
                }
                if (isRemove == false) {
                    index++;
                } else {
                    isRemove = false;
                }
            }
        }
    }

    private void removeBookNoContainAllWord() {

        for (int i : wantedWord) {
            int index = 0;
            while (index != result.size()) {
                if (result.get(index).codeStr.indexOf(i) == -1) {
                    result.remove(index);
                } else {
                    index++;
                }
            }
        }
    }

    private String isStartWithPlus(String choiceWord, String word) {
        if (isStartWhith(choiceWord, "+")) {
            word = word.substring(1);
        }
        return word;
    }

    private boolean isStartWhith(String choiceWord, String sign) {
        return choiceWord.startsWith(sign);
    }

    private boolean chekIfIsIgnorListWord(String choiceWord) {
        if (ignorList.indexOf(choiceWord) == -1) {
            return false;
        }
        return true;
    }

}

