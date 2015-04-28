/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyCollections {

    public static void sort(MyLinkedList list) {

        Element listNode = list.getFirstElement();
        if (listNode == null || !listNode.hasNext()) return;

        Element unsortedNodes = listNode.next();
        listNode.setNext(null);

        while (unsortedNodes != null) {
            Element previous = null;
            Element sortedNodes = listNode;
            while (sortedNodes != null && ((Integer) (sortedNodes.getElement())).compareTo((Integer) unsortedNodes.getElement()) < 0) {
                previous = sortedNodes;
                sortedNodes = sortedNodes.next();
            }

            Element tmp = unsortedNodes;
            unsortedNodes = unsortedNodes.next();

            if (previous == null)
                listNode = tmp;
            else
                previous.setNext(tmp);

            tmp.setNext(sortedNodes);

        }

        list.setFirst(listNode);

    }

    public static void sort(MyArrayList list) {
        if (list.size() < 2) return;
        qSort(list, 0, list.size() - 1);
    }

    private static int partition(MyArrayList list, int begin, int end) {
        int index = begin;
        Integer pivot = (Integer) list.get(index);
        swap(list, index, end);
        for (int i = begin; i <= end; ++i) {
            if (pivot.compareTo((Integer) list.get(i)) > 0) {
                swap(list, index++, i);
            }
        }
        swap(list, index, end);
        return (index);
    }

    private static void qSort(MyArrayList list, int begin, int end) {
        if (end > begin) {
            int index = partition(list, begin, end);
            qSort(list, begin, index - 1);
            qSort(list, index + 1, end);
        }
    }

    public static int binarySearch(MyArrayList list, Integer key) {
        return binarySearch(list, 0, list.size(), key);
    }

    private static int binarySearch(MyArrayList a, int fromIndex, int toIndex, Integer key) {
        int low = fromIndex;
        int high = toIndex - 1;

        if (low > high)
            return -(low + 1);
        else {
            int mid = (low + high) >>> 1;
            Integer midVal = (Integer) a.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp == 0) return mid;
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
            return binarySearch(a, low, toIndex, key);
        }
    }

    public static void swap(MyLinkedList list, int i, int j) {
        if (list == null) return;
        if (i == j) return;
        if (i >= list.size() || j >= list.size())
            throw new IndexOutOfBoundsException("wrong index i:" + i + " or j:" + j);

        if (i > j) {
            i += j;
            j = i - j;
            i = i - j;
        }

        Element tempForSwap = list.removeElement(j);
        list.insertElement(j - 1, list.removeElement(i));
        list.insertElement(i, tempForSwap);

        /*Element nodeParentJ = list.getElement(j-1);
        Element nodeJ = nodeParentJ.next();
        Element nodeI;
        if (i == 0) {
            nodeI = list.getFirstElement();
        }else{
            Element nodeParentI = list.getElement(i - 1);
            nodeI = nodeParentI.next();
            nodeParentI.setNext(nodeJ);
        }
        Element nodeJNext = nodeJ.next();
        nodeParentJ.setNext(nodeI);
        nodeJ.setNext(nodeI.next());
        nodeI.setNext(nodeJNext);*/


    }

    public static void swap(MyArrayList list, int i, int j) {
        if (list == null) return;
        if (i == j) return;
        if (i >= list.size() || j >= list.size())
            throw new IndexOutOfBoundsException("wrong index i:" + i + " or j:" + j);

        if (i > j) {
            i += j;
            j = i - j;
            i = i - j;
        }

        Object tempForSwap = list.get(j);
        list.set(j, list.get(i));
        list.set(i, tempForSwap);

    }

    public static void copy(MyLinkedList dest, MyLinkedList src) {

        if (src == null || dest == null) return;

        Element nodeSrc = src.getFirstElement();
        if (src.getFirstElement() == null) return;

        dest.clear();
        while (nodeSrc != null) {
            dest.add(nodeSrc.getElement());
            nodeSrc = nodeSrc.next();
        }

    }

    public static void copy(MyArrayList dest, MyArrayList src) {

        if (src == null || dest == null) return;

        dest.clear();
        dest.addAll(src.toArray());

    }

    public static void reverse(MyLinkedList list) {
        Element node = list.getFirstElement();
        Element nextNode;
        Element newListOrderNode = null;

        while (node != null) {
            nextNode = node.next();
            node.setNext(newListOrderNode);
            newListOrderNode = node;
            node = nextNode;
        }

        list.setFirst(newListOrderNode);

    }

    public static void reverse(MyArrayList list) {
        for (int i = 0; i < (list.size() / 2); i++) {
            swap(list, i, list.size() - 1 - i);
        }
    }

}
