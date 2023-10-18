public  class Book implements Comparable<Book> {
    private String name;
    private int pageNumber;
    private String authorName;
    private String publicDate;


    public Book(String name, int pageNumber, String authorName, String publicDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.publicDate = publicDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    @Override
    public int compareTo(Book other) {

        return Integer.compare(this.pageNumber, other.pageNumber);
    }

}


