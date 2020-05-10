public class Pgm10b {
    public static void main(String[] args) {
        String str = "My name is Python";
        String rs = str.replace("Python", "Java");
        System.out.println(rs);
        rs = rs.replace("Java", "Python");
        System.out.println(rs);
    }
}
