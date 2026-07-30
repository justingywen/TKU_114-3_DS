# 系統設計說明文件

本文檔說明系統中 6 個核心功能所使用的資料結構與演算法，並比較不同方案之優劣。

## 1. 保存所有主資料紀錄
- **選擇技術**：`ArrayList`
- **對應程式**：`EventRegistrationSystem.java` - `mainList`
- **選擇原因**：需要動態增加資料，且經常需要轉成陣列進行全表排序或隨機讀取。
- **未採用原因**：未採用一般陣列，因為長度無法動態擴充；未採用 `LinkedList`，因為隨機存取效能較差。

## 2. 候補/待處理順序維護
- **選擇技術**：`Queue` (`ArrayDeque`)
- **對應程式**：`EventRegistrationSystem.java` - `waitQueue`
- **選擇原因**：嚴格遵守先來後到（FIFO）原則，提供 $O(1)$ 的 `offer()` 與 `poll()` 效能。
- **未採用原因**：未採用 `ArrayList`，因為在開頭刪除元素需要搬移所有後續資料，耗費 $O(n)$ 時間。

## 3. 復原最後一次操作紀錄
- **選擇技術**：`Stack` (`ArrayDeque`)
- **對應程式**：`EventRegistrationSystem.java` - `cancelStack`
- **選擇原因**：符合後進先出（LIFO）特性，能快速取得並取出最近一次被取消或完成的物件。
- **未採用原因**：未採用 `Queue`，因為 Queue 只能取得最舊的資料，無法取得最新寫入的紀錄。

## 4. 依唯一識別碼（ID）高頻搜尋
- **選擇技術**：`Binary Search`
- **對應程式**：`RegistrationAlgorithms.java` - `binarySearchById()`
- **選擇原因**：在資料已排序的狀況下，比對時間複雜度僅需 $O(\log n)$，大幅優於線性搜尋。
- **未採用原因**：未採用 `Sequential Search`，因為當資料量達到數萬筆時，線性搜尋耗時過長。

## 5. 依姓名或分類尋找多筆符合資料
- **選擇技術**：`Sequential Search`
- **對應程式**：`RegistrationAlgorithms.java` - `findByName()`
- **選擇原因**：符合該屬性的資料可能有多筆，且主資料未針對該特定文字欄位建立排序，必須進行全表掃描。
- **未採用原因**：未採用 `Binary Search`，因為 Binary Search 要求資料必須依該鍵值嚴格排序，且不適合找多筆分散資料。

## 6. 大量資料多條件/穩定排序
- **選擇技術**：`Merge Sort`
- **對應程式**：`RegistrationAlgorithms.java` - `mergeSortById()`
- **選擇原因**：保證最壞情況下時間複雜度仍為 $O(n \log n)$，且具備穩定性（Stable Sort），可保留相同條件下原有的相對順序。
- **未採用原因**：未採用 `Selection Sort` 或 `Insertion Sort`，因為在大資料量時其時間複雜度為 $O(n^2)$，效能太差。