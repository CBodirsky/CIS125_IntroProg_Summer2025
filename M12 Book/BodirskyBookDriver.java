public class BodirskyBookDriver {

    public static void main (String[] args)
    {
        /* My defaults on the IDE don't call this main,
        calling Book.java instead. So the code IS here
        to print the books, but at least in my testing,
        this main doesn't end up running. */
        Book Book1 = new Book();
        Book1.setTitle("Dune");
        Book1.setAuthor("Frank Herbert");
        Book Book2 = new Book();
        Book2.setTitle("The Forever War");
        Book2.setAuthor("Joe Haldeman");

        System.out.println(Book1.getTitle() + " written by " + Book1.getAuthor());
        System.out.println(Book2.getTitle() + " written by " + Book2.getAuthor());
    }
}
