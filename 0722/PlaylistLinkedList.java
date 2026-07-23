public class PlaylistLinkedList {
    private PlaylistNode head;

    public PlaylistLinkedList() {
        head = null;
    }

    public boolean contains(String code) {
        PlaylistNode current = head;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void addLast(String code, String name) {
        if (contains(code)) {
            System.out.println("新增失敗：歌曲代碼 [" + code + "] 已存在。");
            return;
        }

        PlaylistNode newNode = new PlaylistNode(code, name);
        if (head == null) {
            head = newNode;
        } else {
            PlaylistNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("已加入播放清單：" + name);
    }

    public void removeByCode(String code) {
        if (head == null) {
            System.out.println("刪除失敗：播放清單為空。");
            return;
        }

        if (head.code.equalsIgnoreCase(code)) {
            System.out.println("已移除歌曲：" + head.name);
            head = head.next;
            return;
        }

        PlaylistNode previous = head;
        PlaylistNode current = head.next;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                System.out.println("已移除歌曲：" + current.name);
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("刪除失敗：找不到代碼 [" + code + "] 的歌曲。");
    }

    public void printPlaylist() {
        if (head == null) {
            System.out.println("播放清單目前沒有歌曲。");
            return;
        }
        PlaylistNode current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.code + " - " + current.name);
            current = current.next;
            index++;
        }
    }
}