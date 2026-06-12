public class Helper {
    public static void pressEnter() {
        System.out.println();
        System.out.print("  Pressione Enter para continuar...");
        try { System.in.read(); } catch (Exception ignored) {}
    }
}
