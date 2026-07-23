public class PlaylistSystem {
    public static void main(String[] args) {
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        System.out.println("--- 測試新增 ---");
        playlist.addLast("S01", "Shape of You");
        playlist.addLast("S02", "Blinding Lights");
        playlist.addLast("S03", "Someone Like You");
        playlist.addLast("S01", "Shape of You (Remix)"); 

        System.out.println("\n--- 完整播放順序 ---");
        playlist.printPlaylist();

        System.out.println("\n--- 測試刪除 ---");
        playlist.removeByCode("S01");
        playlist.removeByCode("S03");
        playlist.removeByCode("S99");

        System.out.println("\n--- 刪除後播放順序 ---");
        playlist.printPlaylist();
    }
}