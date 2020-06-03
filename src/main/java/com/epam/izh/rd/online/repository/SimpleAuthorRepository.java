package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;


public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors =new Author[]{};
    static private int countOfAuthors=0;
@Override
    public boolean save(Author author){

        if(findByFullName(author.getName(),author.getLastName())==null) {
           countOfAuthors++;
           Author [] newArray = new Author [authors.length+1];
           System.arraycopy(authors,0,newArray,0, authors.length);
           newArray[authors.length+1] = author;
           authors = newArray;
           return true;
       }
       return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for(int i = 0; i<authors.length -1; i++) {
            if (authors[i].getName() == name && authors[i].getLastName() == lastname) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {

        for (int i = 0; i < authors.length - 1; i++) {
            if (authors[i].getName() == author.getName() && authors[i].getLastName() == author.getLastName()) {
                countOfAuthors--;
                Author[] combineArray = new Author[authors.length - 1];
                System.arraycopy(authors, 0, combineArray, 0, i);
                System.arraycopy(authors, i + 1, combineArray, i, combineArray.length-i);
                authors = combineArray;

                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return countOfAuthors;
    }

}
