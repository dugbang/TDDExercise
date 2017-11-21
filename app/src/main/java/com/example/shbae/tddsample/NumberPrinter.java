package com.example.shbae.tddsample;

/**
 * Created by shbae on 2017-11-15.
 */
class NumberPrinter {
    private int linesPerPage;
    private int columns;

    public NumberPrinter(int linesPerPage, int columns) {
        this.linesPerPage = linesPerPage;
        this.columns = columns;
    }

    public void print(int[] numbers, int numberOfPrimes) {
        for (int pagenumber = 1, pageoffset = 1; pageoffset <= numberOfPrimes; pagenumber++, pageoffset += linesPerPage * columns) {
            System.out.println("The First " + numberOfPrimes +
                    " Prime Numbers --- Page " + pagenumber);
            System.out.println("");
            for (int rowoffset = pageoffset; rowoffset < pageoffset + linesPerPage; rowoffset++) {
                for (int column = 0; column < columns; column++)
                    if (rowoffset + column * linesPerPage <= numberOfPrimes)
                        System.out.format("%10d", numbers[rowoffset + column * linesPerPage]);
                System.out.println("");
            }
            System.out.println("\f");
        }
    }
}
