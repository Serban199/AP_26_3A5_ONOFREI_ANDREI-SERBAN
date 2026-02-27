public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String[] limbaje = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        int r = n * 3;
        r += Integer.parseInt("10101", 2);
        r += Integer.parseInt("FF", 16);
        r *=6;

        int finalResult = digitsSum(r);
        System.out.println("willy-nilly, this semester i will learn " + limbaje[finalResult]);
    }
    private static int digitsSum(int number) {
        while (number > 9) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }
        return number;
    }

}