public class inventoryList {

    public void Ilist() {

        String line1 = new String(new char[350]).replace('\0', '-');

        porscheInventory[] itemList = new porscheInventory[7];
        itemList[0] = new porscheInventory("MACAN S", 68400, 35);
        itemList[1] = new porscheInventory("TAYCAN TURBO S", 187400, 16);
        itemList[2] = new porscheInventory("PANAMERA 4", 97000, 52);
        itemList[3] = new porscheInventory("CAYENNE TURBO GT", 188700, 10);
        itemList[4] = new porscheInventory("911 GT3", 169700, 6);
        itemList[5] = new porscheInventory("718 BOXSTER", 65500, 45);
        itemList[6] = new porscheInventory("918 SPYDER", 2000000, 1);

        porscheInventory[] item1 = new porscheInventory[7];
        porscheInventory[] item2 = new porscheInventory[7];
        porscheInventory[] item3 = new porscheInventory[7];
        porscheInventory[] item4 = new porscheInventory[7];
        porscheInventory[] item5 = new porscheInventory[7];

        for (int i = 0; i < itemList.length; i++) {
            item1[i] = itemList[i];
            item2[i] = itemList[i];
            item3[i] = itemList[i];
            item4[i] = itemList[i];
            item5[i] = itemList[i];
        }

        System.out.println("\n\nPORSCHE INVENTORY\n");
        System.out.println("CURRENT SORT:");
        printInventory(itemList);

        System.out.println("\n" + line1);
        System.out.println("SELECTION SORT:");
        printInventory(itemList);
        Sorting.selectionSort(item1);

        System.out.println("\n" + line1);
        System.out.println("INSERTION SORT:");
        printInventory(itemList);
        Sorting.insertionSort(item2);

        System.out.println("\n" + line1);
        System.out.println("BUBBLE SORT:");
        printInventory(itemList);
        Sorting.bubbleSort(item3);

        System.out.println("\n" + line1);
        System.out.println("QUICK SORT:");
        printInventory(itemList);
        Sorting.quickSort(item4);

        System.out.println("\n" + line1);
        System.out.println("MERGE SORT:");
        printInventory(itemList);
        Sorting.mergeSort(item5);
    }


    public static void printInventory(porscheInventory[] items) {
        int i = 0;
        while (i < items.length && items[i] != null) {
            System.out.print(items[i].toString() + " ");
            i++;
        }
        System.out.println();
    }
}

