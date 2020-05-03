package com.example.kjv15;

public class VersesModel {
    int verseNo;
    String verses;

    public VersesModel(int verseNo, String verses) {
        this.verseNo = verseNo;
        this.verses = verses;
    }

    @Override
    public String toString() {
        return verseNo+" "+verses;
    }

    public int getVerseNo() {
        return verseNo;
    }

    public void setBook(int verseNo) {
        this.verseNo= verseNo;
    }

    public String getVerses() {
        return verses;
    }

    public void setVerses(String verses) {
        this.verses = verses;
    }
}
