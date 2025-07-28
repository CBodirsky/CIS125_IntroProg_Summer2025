    //book class
    public class Book {
        private String author;
        private String title;
        private double price;
        private int numberOfPages;


        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getPages() {
            return numberOfPages;
        }

        public void setPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
        }

        public static void main(String[] args)
        {
            //testing this main
            Book testBook = new Book();
            testBook.setTitle("Neuromancer");
            testBook.setAuthor("William Gibson");

            System.out.println("Test Book: " + testBook.getTitle() + " by " + testBook.getAuthor());
        }
    }