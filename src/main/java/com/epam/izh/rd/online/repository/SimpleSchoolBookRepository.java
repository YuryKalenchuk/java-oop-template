package com.epam.izh.rd.online.repository;
import com.epam.izh.rd.online.entity.SchoolBook;

class SimpleSchoolBookRepository implements BookRepository<SchoolBook>{


    private SchoolBook[] schoolBooks = new SchoolBook[]{};
    private static int countOfBooks = 0;

    public boolean save(SchoolBook book){
        countOfBooks++;
        SchoolBook [] arrayOfBooks = new SchoolBook[countOfBooks];
        arrayOfBooks[countOfBooks-1] = book;
        schoolBooks = arrayOfBooks;
        return true;
    }
    public boolean removeByName(String name){
        for (int i = 0; i < schoolBooks.length; i++){
        if(schoolBooks[i].getAuthorName()==name){
            countOfBooks--;
            SchoolBook [] combineArray = new SchoolBook[countOfBooks];
            System.arraycopy(schoolBooks, 0, combineArray, 0, i);
            System.arraycopy(schoolBooks, i + 1, combineArray, i, combineArray.length-i);
            schoolBooks = combineArray;
        }
        else return false;
        }
        return true;
    }

    public SchoolBook[] findByName(String name) {
        int count = 0;
        SchoolBook [] sb = new SchoolBook[]{};
        for(int i = 0; i<schoolBooks.length-1; i++){

        if (schoolBooks[i].getName() == name) {
            count++;
            System.arraycopy(schoolBooks, i, sb, count-1,1);
        }
            return sb;
        }

        return sb;
    }



    public int count(){
        return countOfBooks;
    };
}
