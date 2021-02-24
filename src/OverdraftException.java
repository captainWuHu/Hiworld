public class OverdraftException extends Exception{
    private double deficit;
    public OverdraftException(String message,double deficit){
        this.deficit=deficit;
        System.out.println(message+deficit);
    }

    public double getDeficit() {
        return deficit;
    }

}
